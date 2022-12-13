<html>
<head lang="en">
    <meta charset="UTF-8"></meta>
    <title>债权转让及受让协议模板</title>
    <style type="text/css">
    	@page {
        	margin-top: 75px;
        	margin-bottom: 55px;
   		 }
        .body{
		    width:685px !important;
		    font-family: Microsoft YaHei;
		    <#if report.isView?exists && report.isView!="">
		    padding: 25px 40px;
		    </#if>
		}
		.txt_bg {
		    font-size: 10pt;
		    line-height: 35px;
		    height: 30px;
		}
		
		.txt {
		    font-size: 10pt;
		    line-height: 25px;
		    height: 25px;
		}
		
		.txt9 {
		    font-size: 9pt;
		    line-height: 15px;
		    height: 12px;
		}
		
		.txt10 {
		   	font-size: 10pt;
			line-height: 15px;
			height: 12px;
		}
		
		.txt_bold {
		    font-weight: bold;
		}
		
		.txt_indent{
		    text-indent: 2em;
		}
		
		.table_txt{
		    font-size: 8pt;
		}
		.table_txt9{
		    font-size: 9pt;
		}
		.report_table{
		    border-collapse:collapse;
		    border-spacing:0;
		    border-left:0.6px solid #888;
		    border-top:0.6px solid #888;
		    width: 680px;
		}
		.report_td{
		    border-right:0.6px solid #888;
		    border-bottom:0.6px solid #888;
		    padding:5px 5px;
		}
		.report_th{
		    font-weight:bold;
		}
		.table_height{
		    height: 40px;
		}
		.txt_hb{
		    text-align:right;
		    height: 10px;
		    margin-top: -4%;
		}
		.table_zw{
		    font-size: 9pt;
		    height: 15px;
		    line-height: 15px;
		}
    </style>
</head>
<body>
<div class="body" >
	<#if report.isView?exists && report.isView!="">
   	<div>
        <img src="${baseUrl}/assets/image/report_logo.png" style="width: 22%; margin-left: 70%"></img>
        <hr style="margin-top: 3px;"></hr>
    </div>
    </#if>
    <div class="txt_01" style="margin-left: 3%">
        <p style="margin-bottom: -10px;font-family:Microsoft YaHei;font-size: 31.5px;">${report.zipCode}</p>
        <#if report.isView?exists && report.isView!="">
        </br>
        </#if>
        <p class="txt" style="font-family:SimSun;">${report.custAddress}</p>
        <p class="txt" style="font-family:SimSun;">${report.custName}	收</p>
    </div>
    <div>
        <h3 style="text-align: center;margin-bottom: 20px;margin-top: 25px;" class="font_h">债权转让及受让协议</h3>
        <p class="txt10 font_h" style="margin-top: 35px"><span style="margin-left: 60%">出借编号:${report.lenderCode}</span></p>
        <p class="txt10 font_h">尊敬的<span style="border-bottom:0.6px solid black;">   ${report.custName}   </span>先生/女士，您好！</p>
        <p class="txt10 font_h txt_indent">通过达信公司的评估与筛选，推荐您通过受让他人既有的个人间借贷合同的方式，出借资金给如下借款人，详见</p><p class="txt10 font_h">《债权列表》。</p>
    </div>
    <div>
        <h4 style="text-align: center;margin-bottom: 0px;margin-top: 10px" class="font_h">债权列表</h4>
         <p class="txt9 font_h">转让人（原债权人）：鲁永祥<span style="margin-left: 40%">受让人（新债权人）：${report.custName}</span><br />
                                身份证号码：370206195007272814<span style="margin-left: 33.7%">身份证号码：${report.idCard}</span>
        </p>
        <p class="txt9 font_h" style="margin-top: 35px">转让债权明细：<span style="margin-left: 65%">货币单位：人民币（元)</span></p>
    </div>
    <div style="margin-top: -1%">
        <table style="font-size:12px;width: 100%; text-align: center;border: 0.6px solid black;border-collapse: collapse;border-spacing: 0;">
            <tr style="page-break-inside: avoid;line-height: 24px;">
                <td colspan="7" style="border: 0.6px solid black;padding:5px 2px;">债权基本信息</td>
                <td colspan="4" style="border: 0.6px solid black;padding:5px 2px;">借款人如约还款情况下债权收益信息</td>
            </tr>
            <tr style="page-break-inside: avoid;">
                <td style="width: 20px;border: 0.6px solid black;padding:18px 0px;">序号</td>
                <td style="width: 75px;border: 0.6px solid black;padding:18px 0px;">借款人<#if report.isView?exists && report.isView!=""></br><#else><br></br></#if>姓名</td>
                <td style="width: 160px;border: 0.6px solid black;padding:18px 0px;">借款人身份证号码</td>
                <td style="width: 80px;border: 0.6px solid black;padding:18px 0px;">本次转让<#if report.isView?exists && report.isView!=""></br><#else><br></br></#if>债权价值</td>
                <td style="width: 75px;border: 0.6px solid black;padding:18px 0px;">需支付对价</td>
                <td style="width: 60px;border: 0.6px solid black;padding:18px 0px;">借款人<#if report.isView?exists && report.isView!=""></br><#else><br></br></#if>职业情况</td>
                <td style="width: 60px;border: 0.6px solid black;padding:18px 0px;">借款人<#if report.isView?exists && report.isView!=""></br><#else><br></br></#if>借款用途</td>
                <td style="width: 120px;border: 0.6px solid black;padding:18px 0px;">还款<#if report.isView?exists && report.isView!=""></br><#else><br></br></#if>起始日期</td>
                <td style="width: 55px;border: 0.6px solid black;padding:18px 0px;">还款<#if report.isView?exists && report.isView!=""></br><#else><br></br></#if>期限（月）</td>
                <td style="width: 40px;border: 0.6px solid black;padding:18px 0px;">剩余还款<#if report.isView?exists && report.isView!=""></br><#else><br></br></#if>月数</td>
                <td style="width: 50px;border: 0.6px solid black;padding:18px 0px;">预计债权<#if report.isView?exists && report.isView!=""></br><#else><br></br></#if>	收益率（年）</td>
            </tr> 
           	 <#list report.results as result>
	            <tr style="page-break-inside: avoid;line-height: 24px;">
	                <td style="border: 0.6px solid black;padding:2px 0px;">${result.index}</td>
	                <#if result.custName?length gt 3>
	                	<td style="border: 0.6px solid black;padding:2px 0px;"><span style="font-size:8pt">${result.custName}</span></td>
	                	<#else>
	                	<td style="border: 0.6px solid black;padding:2px 0px;">${result.custName}</td>
	                </#if>
	                <td style="border: 0.6px solid black;padding:2px 0px;">${result.idCard}</td>
	                <td style="border: 0.6px solid black;padding:2px 0px;">${result.transAmountView}</td>
	                <td style="border: 0.6px solid black;padding:2px 0px;">${result.payAmountView}</td>
	                <td style="border: 0.6px solid black;padding:2px 0px;">${result.profession}</td>
	                <td style="border: 0.6px solid black;padding:2px 0px;">${result.purpose}</td>
	                <td style="border: 0.6px solid black;padding:2px 0px;">${result.repayDateView}</td>
	                <td style="border: 0.6px solid black;padding:2px 0px;">${result.initPeriod}</td>
	                <td style="border: 0.6px solid black;padding:2px 0px;">${result.remainPeriod}</td>
	                <td style="border: 0.6px solid black;padding:2px 0px;">${result.rateYearView}</td>
	            </tr>
            </#list>
            <tr style="page-break-inside: avoid;line-height: 24px;">
                <td colspan="3">合计</td>
                <td style=";border: 0.6px solid black;padding:2px 0px;">${report.transferTotalAmountView}</td>
                <td style=";border: 0.6px solid black;padding:2px 0px;">${report.transferTotalAmountView}</td>
                <td style=";border: 0.6px solid black;padding:2px 0px;"></td>
                <td style=";border: 0.6px solid black;padding:2px 0px;"></td>
                <td style=";border: 0.6px solid black;padding:2px 0px;"></td>
                <td style=";border: 0.6px solid black;padding:2px 0px;"></td>
                <td style=";border: 0.6px solid black;padding:2px 0px;"></td>
                <td style=";border: 0.6px solid black;padding:2px 0px;"></td>
            </tr>
        </table>
    </div>
    <div style="page-break-inside: avoid">
	    <div>
	        <h4 style="text-align: center;margin-top: 10px" class="font_h">转让人声明</h4>
	         <p class="txt9 font_h">
	            本人自愿将上述债权转让给受让人。如果受让人对上述债权转让没有任何异议，须于<span style="border-bottom:0.6px solid black;">${report.reportDayView}</span>前将上述对价共计：
	        </p>
	        <p class="txt9 font_h">人民币（大写）<span style="border-bottom:0.6px solid black;">${report.transferTotalAmountChsView}</span>（人民币小写￥<span style="border-bottom:0.6px solid black;">${report.transferTotalAmountView}</span>）支付到如下指定账户。</p>
	    </div>
    </div>
    <!-- page-break-inside: avoid 保证分页不被分割,确保完整性 -->
    <div>
        <p class="txt9 font_h">
            自款项到账之日起，上述债权转让即生效；债权转让生效后，署有本人签章的本文件即代表受让人对上述债权的所有权。
        </p>
        <p class="txt9 font_h" style="margin-top: 5%">本人特此签章证明。</p>
    </div>
    <div style=" margin-left: 20%;page-break-inside: avoid;">
        <p style="font-size: 12px; line-height: 30px;">转让人：鲁永祥<span style="margin-left: 25%">见证人：达信卓惠金融信息服务（上海）有限公司</span></p>
        <p style="font-size: 12px; line-height: 30px;">签章：<span style="margin-left: 33.7%">盖章：</span></p>
        <p style="font-size: 12px; line-height: 30px;">日期：${report.reportDayView}<span style="margin-left: 21.5%">日期：${report.reportDayView}</span></p>
    </div>
    <div style="margin-top: 4%">
        <hr style="height:1px;border:none;border-top:1px dashed #000;" />
    </div>
    <div style="margin-top: 2%">
         <p class="txt9 font_h">
            温馨提示：
        </p>
         <p class="txt9 font_h">
            	如果受让人对上述债权全部或部分不认可，请填写本执，标明所拒绝的债权序号，在
            <span style="border-bottom:0.6px solid black;">
            	${report.reportDayView}
            </span>前将回执交给达信并自己保留
        </p>
        <p class="txt9 font_h">
        	一份取得达信盖章的回执，由达信协调进行其他债权的推荐。
        </p>
    </div>
    <div style="page-break-inside: avoid">
	    <div>
	        <center><h4 style="margin-top: 55px; margin-bottom: 5px;" class="font_h" align="center" >债权转让拒绝回执</h4></center>
	         <p class="txt9 font_h">
	            	本人拒绝转让人<span style="border-bottom:0.6px solid black;">鲁永祥</span>上述欲转让给本人的第
	            <span>__________</span>
	            	号（依次填写序号）债权，本人将不予支付该债权的对价；对于其他
	        </p>
	        <p class="txt9 font_h">
	       	 未拒绝的债权，将按时支付对价。请达信公司知悉并见证。
	        </p>
	        <p class="txt9 font_h">
	        	  本人特此签章证明。
	        </p>
	        
	    </div>
	    <div  style="margin-left: 20%; page-break-inside: avoid; margin-bottom: -3%;">
	        <p style="font-size: 12px; line-height: 30px;">受让人：<span style="margin-left: 25%">见证人：达信卓惠金融信息服务（上海）有限公司</span></p>
	        <p style="font-size: 12px; line-height: 30px;">签章：<span style="margin-left: 27%">盖章：</span></p>
	        <p style="font-size: 12px; line-height: 30px;">日期：<span style="margin-left: 27%">日期：</span></p>
	    </div>
    </div>
</div>
</body>
</html>
