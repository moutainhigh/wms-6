<#include "/macro/base.ftl">
<@table items=["客户姓名","合同编号","身份证","债权比例","退回债权价值","当前总价值","还款金额","本金","利息","产品类型"]>
	<#list details as detail>
		<tr>
			<td width="10%" class="txt-center">${detail.custName}</td>
			<td width="10%" class="txt-center">${detail.contractCode}</td>
			<td width="10%" class="txt-center">${detail.idCard}</td>
			<td width="10%" class="txt-center">${detail.creditRateView}</td>
			<td width="10%" class="txt-center"><span class='label label-info'>${detail.transAmountView}</span></td>
			<td width="10%" class="txt-center">${detail.totalAmountView}</td>
			<td width="10%" class="txt-center">${detail.repayView}</td>
			<td width="10%" class="txt-center">${detail.capitalView}</td>
			<td width="10%" class="txt-center">${detail.interestView}</td>
			<td width="10%" class="txt-center">${detail.productView}</td>
		</tr>
	</#list>
</@table>