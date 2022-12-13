<html>
<head lang="en">
    <meta charset="UTF-8"></meta>
    <title>资金报告模版</title>
    <style type="text/css">
    	@page {
        	margin-top: 75px;
        	margin-bottom: 55px;
   		 }
        .body{
		    width:685px !important;
		    font-family: Microsoft YaHei;
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
    <div class="txt_01" style="margin-left: 3%">
        <p style="margin-bottom: -10px;font-family:Microsoft YaHei;font-size: 31.5px;">${report.zipCodeView}</p>
        <p class="txt" style="font-family:SimSun;">${report.custAddress}</p>
        <p class="txt" style="font-family:SimSun;">${report.custName}	收</p>
    </div>
    <div>
        <h3 style="text-align: center;margin-bottom: 20px;margin-top: 25px;" class="font_h">达信财富平台客户资金出借情况报告</h3>
		<P class="txt10 font_h"><span style="margin-left: 65%;"><b>客户编号：${report.lenderCustCode}</b></span></P>
        <p class="txt10 font_h">尊敬的<span style="border-bottom:0.6px solid black;">   ${report.custName}   </span>先生/女士，您好！</p>
		<br></br>
		<p class="txt10 font_h txt_indent">以下是您在达信财富平台出借款项的资金出借情况报告，如有任何疑问，请致电您的理财顾问，我们将竭诚为您服务！</p>
		<br></br>
		<P class="txt10 font_h"><b>报告周期：${report.reportPeriodBeginView}-${report.reportDateView} <span style="margin-left: 30%;">账户级别：${report.accountLevel}</span></b></P>
		<div>
		<P class="txt10 font_h"><b>报告日<span style="margin-left: 2%;">：</span>每月${report.billDay}日</b></P>
		</div>
    </div>
    <div style="margin-top: 5%">
		<p class="txt10 font_h " >以下是您在达信财富平台出借的单笔资金及产品明细：</p>
		<p class="txt10 font_h " ><b><span style="float: right;">货币单位：人民币（元）</span></b></p>
        <table style="font-size:12px;width: 100%;text-align: center;border: 0.6px solid black;border-collapse: collapse;border-spacing: 0;">
            <tr style="page-break-inside: avoid;">
                <td style="width: 164px;border: 0.6px solid black;padding:18px 0px;">出借编号</td>
                <td style="width: 80px;border: 0.6px solid black;padding:18px 0px;">资金出借及>回收方式</td>
                <td style="width: 95px;border: 0.6px solid black;padding:18px 0px;">初始出借日期</td>
                <td style="width: 100px;border: 0.6px solid black;padding:18px 0px;">初始出借金额</td>
                <td style="width: 80px;border: 0.6px solid black;padding:18px 0px;">本报告日</td>
                <td style="width: 90px;border: 0.6px solid black;padding:18px 0px;">上一个报告日资产总额</td>
                <td style="width: 80px;border: 0.6px solid black;padding:18px 0px;">本报告日资产总额</td>  
            </tr>
            <tr style="page-break-inside: avoid;line-height: 24px;">
                <td style="border: 0.6px solid black;padding:2px 0px;" >${report.lenderCode}</td>
                <td style="border: 0.6px solid black;padding:2px 0px;">${report.productView}</td>
                <td style="border: 0.6px solid black;padding:2px 0px;">${report.initLoanDayView}</td>
                <td style="border: 0.6px solid black;padding:2px 0px;">${report.initTotalAmountView}</td>
                <td style="border: 0.6px solid black;padding:2px 0px;">${report.billDay}</td>
                <td style="border: 0.6px solid black;padding:2px 0px;">${report.lastTotalAmountView}</td>
                <td style="border: 0.6px solid black;padding:2px 0px;">${report.totalAmountView}</td>
            </tr>
        </table>
    </div>
    <div style="margin-top: 5%">
		<p class="txt10 font_h " style="margin-top: -0.4%">您的出借款项回款明细：</p>
        <table style="font-size:12px;width: 100%;text-align: center;border: 0.6px solid black;border-collapse: collapse;border-spacing: 0;">
            <tr style="page-break-inside: avoid;">
                <td style="width: 164px;border: 0.6px solid black;padding:18px 0px;">出借编号</td>
                <td style="width: 80px;border: 0.6px solid black;padding:18px 0px;">报告期内借款人应还款金额（或还款风险金代偿金额）</td>
                <td style="width: 95px;border: 0.6px solid black;padding:18px 0px;">报告日您选择受让的债权金额</td>
                <td style="width: 100px;border: 0.6px solid black;padding:18px 0px;">当期回收金额</td>
                <td style="width: 100px;border: 0.6px solid black;padding:18px 0px;">服务费率(月)</td>
                <td style="width: 70px;border: 0.6px solid black;padding:18px 0px;">服务费</td>
                <td style="width: 80px;border: 0.6px solid black;padding:18px 0px;">报告日实际资产总额</td>  
            </tr>
            <tr style="page-break-inside: avoid;line-height: 24px;">
                <td style="border: 0.6px solid black;padding:2px 0px;">${report.lenderCode}</td>
                <td style="border: 0.6px solid black;padding:2px 0px;">${report.recycleAmountView}</td>
                <td style="border: 0.6px solid black;padding:2px 0px;">${report.loanAmountView}</td>
                <td style="border: 0.6px solid black;padding:2px 0px;">${report.incomeView}</td>
                <td style="border: 0.6px solid black;padding:2px 0px;">${report.accountManageRateView}</td>
                <td style="border: 0.6px solid black;padding:2px 0px;">${report.accountManageAmountView}</td>
                <td style="border: 0.6px solid black;padding:2px 0px;">${report.totalAmountView}</td>
            </tr>
        </table>	
    </div>
	<br></br>
	<br></br>
	<p class="txt10 font_h " style="margin-top: -0.4%">温馨提示：达信财富平台每月为您出具您的资金情况报告，让您及时了解资金增值情况，感受贴心服务！我们将不断提升完
	善我们的服务，如您有任何宝贵意见或建议，欢迎联系我们：400-6699-959！祝您工作生活愉快！</p>   
</div>
</body>
</html>
