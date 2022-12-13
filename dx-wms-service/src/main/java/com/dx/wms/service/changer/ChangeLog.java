
package com.dx.wms.service.changer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dx.wms.common.BaseEntity;
import com.dx.wms.service.log.LogJsonDto;

/**
 * 理财日志表
 *
 * @author yangbao
 */
@Entity(name = "t_change_log")
public class ChangeLog extends BaseEntity {

    /**
     */
    private static final long serialVersionUID = -8241139759693548272L;

    /**
     * 日志编号
     */
    private Long logId;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 主键编号
     */
    private Long pkId;

    /**
     * 内容
     */
    private String content;

    /**
     * 数据库语句
     */
    private String dbSql;

    private LogJsonDto logJsonDto;

    /**
     * 功能描述: 日志编号<br>
     *
     * @return the logId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "log_id")
    public Long getLogId() {
        return this.logId;
    }

    /**
     * 功能描述: 日志编号<br>
     *
     * @param logId the logId to set.
     */
    public void setLogId(Long logId) {
        this.logId = logId;
    }

    /**
     * 功能描述: 表名<br>
     *
     * @return the tableName
     */
    @Column(name = "table_name")
    public String getTableName() {
        return this.tableName;
    }

    /**
     * 功能描述: 表名<br>
     *
     * @param tableName the tableName to set.
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 功能描述: 主键编号<br>
     *
     * @return the pkId
     */
    @Column(name = "pk_id")
    public Long getPkId() {
        return this.pkId;
    }

    /**
     * 功能描述: 主键编号<br>
     *
     * @param pkId the pkId to set.
     */
    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    /**
     * 功能描述: 内容<br>
     *
     * @return the content
     */
    @Column(name = "content")
    public String getContent() {
        return this.content;
    }

    /**
     * 功能描述: 内容<br>
     *
     * @param content the content to set.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 功能描述: 数据库语句<br>
     *
     * @return the dbSql
     */
    @Column(name = "db_sql")
    public String getDbSql() {
        return this.dbSql;
    }

    /**
     * 功能描述: 数据库语句<br>
     *
     * @param dbSql the dbSql to set.
     */
    public void setDbSql(String dbSql) {
        this.dbSql = dbSql;
    }

    public LogJsonDto getLogJsonDto() {
        return logJsonDto;
    }

    public void setLogJsonDto(LogJsonDto logJsonDto) {
        this.logJsonDto = logJsonDto;
    }

    /**
     * 
     * 功能描述: <br>
     * 创建时间
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */

}
