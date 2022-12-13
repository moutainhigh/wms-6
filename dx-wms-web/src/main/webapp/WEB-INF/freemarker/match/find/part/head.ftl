<@hidden name="isFilter" id="isFilter" value=0 />
<@hidden name="repayDay" id="repayDay" value=total.port />
<@hidden name="biz" id="biz" value=biz />
<@table items=["待匹配金额","待匹配人数","已选择金额","已选择人数"]>
	<tr>
		<td id="needAmount" class="txt-center">${total.needAmounts}</td>
		<td id="needCounts" class="txt-center">${total.needCounts}</td>
		<td id="totalAmounts" class="txt-center">${total.totalAmounts}</td>
		<td id="totalCounts" class="txt-center">${total.totalCounts}</td>
	</tr>
</@table>