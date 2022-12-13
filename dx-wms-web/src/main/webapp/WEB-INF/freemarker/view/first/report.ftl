<link href="${baseUrl}/assets/css/report/table.css" rel="stylesheet" type="text/css" />
<div class="body" >
    <div>
        <img src="${baseUrl}/assets/image/report_logo.png" style="width: 22%; margin-left: 70%">
        <hr>
    </div>
    <div class="txt_01" style="margin-left: 5%">
        <h2 style="margin-bottom: -10px;">${report.zipCode}</h2>
        <p class="txt">${report.custAddress}</p>
        <p class="txt">${report.custName}	收</p>
    </div>
    <div>
        <h3 align="center" style="margin-top: 10%; margin-bottom: 20px" class="font_h">债权转让及受让协议</h3>
        <p class="txt font_h">尊敬的<ins>   ${report.custName}   </ins>先生/女士，您好！</p>
        <p class="txt font_h txt_indent">通过达信公司的评估与筛选，推荐您通过受让他人既有的个人间借贷合同的方式，出借资金给如下借款人，详见《债权列表》。</p>
        <p class="txt font_h txt_indent" style="margin-top: 3%">在您接受该批债权转让并按时支付对价的情况下，预期您的出借获益情况如下： 货币单位：人民币</p>
    </div>
    <div style="margin-top: 5%">
        <table class="table_txt report_table">
            <tr>
                <th width="80px" class="report_th report_td">出借编号</th>
                <th width="55px" class="report_th report_td">资金出借及回收方式</th>
                <th width="67px" class="report_th report_td">初始出借日期</th>
                <th width="67px" class="report_th report_td">初始出借金额</th>
                <th width="67px" class="report_th report_td">下一个报告日</th>
                <th width="75px" class="report_th report_td">告期借款人应还款额</th>
                <th width="60px" class="report_th report_td">账户管理费</th>
                <th class="report_th report_td">预计下一个报告日您的资产总额</th>
            </tr>
            <tr style="text-align: center">
                <td class="report_td">${report.lenderCode}</td>
                <td class="report_td">${report.productView}</td>
                <td class="report_td">${report.initMatchTimeView}</td>
                <td class="report_td">${report.initTotalAmountView}</td>
                <td class="report_td">${report.initBillDateView}</td>
                <td class="report_td">${report.repayView}</td>
                <td class="report_td">${report.accountAmountView}</td>
                <td class="report_td">${report.nextTotalAmountView}</td>
            </tr>
        </table>
    </div>
    <div>
        <h4 align="center" style="margin-top: 20px; margin-bottom: 5px" class="font_h">债权列表</h4>
        <p class="txt9 font_h">转让人（原债权人）：鲁永祥<span style="margin-left: 40%">受让人（新债权人）：${report.custName}</span><br />
                                身份证号码：370206195007272814<span style="margin-left: 33.7%">身份证号码：${report.idCard}</span>
        </p>
        <p class="txt9 font_h" style="margin-top: 35px">转让债权明细：<span style="margin-left: 65%">货币单位：人民币（元)</span></p>
    </div>
    <div style="margin-top: -1%">
        <table class="table_txt9 report_table" style="text-align: center">
            <tr>
                <td colspan="7" class="report_td">债权基本信息</td>
                <td colspan="4" class="report_td">借款人如约还款情况下债权收益信息</td>
            </tr>
            <tr>
                <td width="15px" class="report_td">序号</td>
                <td width="45px" class="report_td">借款人姓名</td>
                <td width="120px" class="report_td">借款人身份证号码</td>
                <td width="60px" class="report_td">本次转让债权价值</td>
                <td width="55px" class="report_td">需支付对价</td>
                <td width="50px" class="report_td">借款人职业情况</td>
                <td width="50px" class="report_td">借款人借款用途</td>
                <td width="45px" class="report_td">还款起始日期</td>
                <td width="45px" class="report_td">还款期限(月)</td>
                <td width="45px" class="report_td">剩余还款月数</td>
                <td width="45px" class="report_td">预计债权收益率(年)</td>
            </tr>
            <#list report.results as result>
				<tr>
                    <td class="report_td">${result.index}</td>
                    <td class="report_td">${result.custName}</td>
                    <td class="report_td">${result.idCard}</td>
                    <td class="report_td">${result.transAmountView}</td>
                    <td class="report_td">${result.payAmountView}</td>
                    <td class="report_td">${result.profession}</td>
                    <td class="report_td">${result.purpose}</td>
                    <td class="report_td">${result.repayDateView}</td>
                    <td class="report_td">${result.initPeriod}</td>
                    <td class="report_td">${result.remainPeriod}</td>
                    <td class="report_td">${result.rateYearView}</td>
                </tr>
			</#list>
            <tr>
                <td colspan="3" class="report_td">合计</td>
                <td class="report_td">${report.initTotalAmountView}</td>
                <td class="report_td">${report.initTotalAmountView}</td>
                <td class="report_td"></td>
                <td class="report_td"></td>
                <td class="report_td"></td>
                <td class="report_td"></td>
                <td class="report_td"></td>
                <td class="report_td"></td>
            </tr>
        </table>
    </div>
    <div>
        <h4 align="center" style="margin-top: 20px; margin-bottom: 5px" class="font_h">转让人声明</h4>
        <p class="txt9 font_h">
            本人自愿将上述债权转让给受让人。如果受让人对上述债权转让没有任何异议，须于<ins>&nbsp&nbsp&nbsp&nbsp&nbsp${report.initMatchTimeView}&nbsp&nbsp&nbsp&nbsp&nbsp</ins>前将上述对价共计：
        </p>
        <p class="txt9 font_h">人民币（大写）<ins>${report.initTotalAmountChsView}</ins>（人民币小写￥<ins>${report.initTotalAmountView}</ins>）支付到如下指定账户。</p>
    </div>
    <div style="line-height: 15px; margin-left: 40%; margin-top: 5%; margin-bottom: 5%" class="txt_bold" >
        <p>开户行：招商银行上海分行新客站支行</p>
        <p>账户名称：鲁永祥</p>
        <p>账号：6214831211095986</p>
    </div>
    <div>
        <p class="txt9 font_h">
            自款项到账之日起，上述债权转让即生效；债权转让生效后，署有本人签章的本文件即代表受让人对上述债权的所有权。
        </p>
        <p class="txt9 font_h" style="margin-top: 5%">本人特此签章证明。</p>
    </div>
    <div  class="txt9 font_h" style="line-height: 30px; margin-left: 28%;">
        <p>转让人：鲁永祥<span style="margin-left: 25%">见证人：达信卓惠金融信息服务（上海）有限公司</span></p>
        <p>签章：<span style="margin-left: 34.7%">盖章：</span></p>
        <p>日期：${report.initMatchTimeView}<span style="margin-left: 21.3%">日期：${report.initMatchTimeView}</span></p>
    </div>
    <div style="margin-top: 20%">
        <hr style="height:1px;border:none;border-top:1px dashed #000;" />
    </div>
    <div style="margin-top: 2%">
        <p class="txt9 font_h">
            提示：
        </p>
        <p class="txt9 font_h" style="line-height:25px">如果受让人对上述债权全部或部分不认可，请填写本执，标明所拒绝的债权序号，在   ${report.initMatchTimeView}  前将回执交给达信并自己保留一份取得达信盖章的回执，由达信协调进行其他债权的推荐。</p>
    </div>
    <div>
        <h5 align="center" style="margin-top: 55px; margin-bottom: 5px" class="font_h">债权转让拒绝回执</h5>
        <p class="txt9 font_h" style="line-height:25px">
            本人拒绝转让人<ins> 鲁永祥 </ins>上述欲转让给本人的第<ins> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</ins>号（依次填写序号）债权，本人将不予支付该债权的对价；对于其他未拒绝的债权，将按时支付对价。请达信公司知悉并见证。
        <br />
            本人特此签章证明。
        </p>
    </div>
    <div  class="txt9 font_h" style="line-height: 20px; margin-left: 16%; margin-top: 12%;margin-bottom: 8%">
        <p>受让人：<span style="margin-left: 25%">见证人：达信卓惠金融信息服务（上海）有限公司</span></p>
        <p>签章：<span style="margin-left: 27%">盖章：</span></p>
        <p>日期：<span style="margin-left: 27%">日期：</span></p>
    </div>
</div>

