<@hidden name="isFilter" id="isFilter" value=1 />
<@hidden name="userId" id="userId" value=invest.userId />
<@hidden name="repayDay" id="repayDay" value=total.port />
<@hidden name="poolId" id="poolId" value=invest.poolId />
<@hidden name="biz" id="biz" value=biz />
<@hidden name="custName" id="custName" value=invest.custName />
<@hidden name="idCard" id="idCard" value=invest.idCard />
<@hidden name="undoAmount" id="undoAmount" value=invest.undoAmount />
<@table items=["理财客户","身份证","出借编号","待匹配金额","已选择金额","已选择人数","未匹配金额","已匹配金额","已匹配人数"]>
	<tr>
		<td class="txt-center">${invest.custName}</td>
		<td class="txt-center">${invest.idCard}</td>
		<td class="txt-center">${invest.lenderCode}</td>
		<td id="needAmount" class="txt-center">${invest.undoAmount}</td>
		<td id="totalAmounts" class="txt-center">${total.totalAmounts}</td>
		<td id="totalCounts" class="txt-center">${total.totalCounts}</td>
		<td class="txt-center"><span class='label label-info' id="remainAmounts">${total.remainAmounts}</span></td>
		<td class="txt-center"><span class='label label-info' id="matchAmounts">${total.matchAmounts}</span></td>					
		<td class="txt-center"><span class='label label-info' id="matchCounts">${total.matchCounts}</span></td>
	</tr>
</@table>