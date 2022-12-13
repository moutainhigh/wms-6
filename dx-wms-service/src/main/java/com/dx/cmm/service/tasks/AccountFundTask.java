package com.dx.cmm.service.tasks;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.enums.MatchTask;
import com.dx.cmm.exception.SaveException;
import com.dx.cmm.exception.TaskException;
import com.dx.cmm.service.cache.ICacheService;
import com.dx.cmm.service.rules.ParamRuler;
import com.dx.cmm.service.rules.ResultRuler;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.transaction.annotation.Transactional;
import com.dx.op.service.dao.IAccountLevelDao;
import com.dx.op.service.dao.IAccountLevelLogDao;
import com.dx.op.service.entity.AccountLevel;
import com.dx.op.service.entity.AccountLevelLog;

@Service("accountFundTask")
public class AccountFundTask extends TaskAbs {

    private static final String OUTPUT_ACCOUNT_NAME = "OUTPUT_ACCOUNT_NAME";

    private static final String OUTPUT_ACCOUNT_RATE = "OUTPUT_ACCOUNT_RATE";

    private static final String ACCOUNT_INFO_KEY = "accountInfoKey:";

    @Autowired
    private IAccountLevelDao accountLevelDao;

    @Autowired
    private IAccountLevelLogDao accountLevelLogDao;

    @Autowired
    private ICacheService<MatchTask> cacheService;

    @Override
    public synchronized void execute() throws TaskException {
        execute(dalClient.queryForList("batchTask.queryAccount", null, AccountParamTask.class));
    }

    @Transactional
    private void execute(List<AccountParamTask> accounts) {
        Assert.notNull(new TaskException("no find accounts"), accounts);
        try {
            accountLevelLogDao.update();
        } catch (SaveException e) {
            throw new TaskException(e.getMessage());
        }
        LOG.info("do account[{}] task", accounts.size());
        for (AccountParamTask account : accounts) {
            execute(account);
        }

    }

    private void execute(AccountParamTask account) {
        Assert.notNull(new TaskException("User[{0}] has no amount", account.getCustCode()), account.getAccountAmount());
        LOG.info("User[{}] current amount[{}]", account.getCustCode(), account.getAccountAmount());
        ResultRuler rule = ruler.parse(new ParamRuler(account));
        execute(get(rule), account);
    }

    private AccountLevel get(ResultRuler rule) {
        Map<String, Object> results = rule.getResults();
        Assert.notNull(new TaskException("no find results"), results);
        Assert.notNull(new TaskException("no find result"), results.get(OUTPUT_ACCOUNT_NAME),
                results.get(OUTPUT_ACCOUNT_RATE));
        LOG.info("account level param account:{} , rate;{}", results.get(OUTPUT_ACCOUNT_NAME),
                results.get(OUTPUT_ACCOUNT_RATE));
        return accountLevelDao.queryByParam(results.get(OUTPUT_ACCOUNT_NAME).toString(),
                new BigDecimal(results.get(OUTPUT_ACCOUNT_RATE).toString()));
    }

    private void execute(AccountLevel level, AccountParamTask account) {
        Assert.notNull(new TaskException("cust code:{0} current amount:{1} no find level", account.getCustCode(),
                account.getAccountAmount()), level);
        try {
            cacheService.del(ACCOUNT_INFO_KEY, account.getCustCode());
            accountLevelLogDao.save(new AccountLevelLog(account, level));
        } catch (SaveException e) {
            LOG.error("save error:{}", e.getMessage());
            throw new TaskException(e.getMessage());
        }
    }

}
