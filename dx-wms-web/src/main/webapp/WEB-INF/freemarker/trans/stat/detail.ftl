<#include "/macro/base.ftl">
<@table items=["账单日","到期总数","退回总价值"]>	
	<#list stats as stat>	
		<tr>
			<td class="txt-center">${stat.billDay}</td>
			<td class="txt-center">${stat.num}</td>
			<td class="txt-center"><span class='label label-info'>${stat.amountView}</span></td>
		</tr>
	</#list>
</@table>