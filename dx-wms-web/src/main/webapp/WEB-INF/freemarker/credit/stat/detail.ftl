<#include "/macro/base.ftl">
<@table items=["还款日","债权总数","债权总价值"]>	
	<#list stats as stat>	
		<tr>
			<td class="txt-center">${stat.repayDay}</td>
			<td class="txt-center">${stat.num}</td>
			<td class="txt-center"><span class='label label-info'>${stat.amountView}</span></td>
		</tr>
	</#list>
</@table>