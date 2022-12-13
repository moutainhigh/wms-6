<#if detail.logVos?exists>	
  	<table class="table table-striped table-bordered table-advance table-hover">
       <thead>
			<tr>
			    <th>操作人</th>
				<th>操作时间</th>
				<th>操作环节</th>
				<th>操作结果</th>
				<th>操作内容</th>
			</tr>
       </thead>
       <tbody>
       <#list detail.logVos as log>
            <tr>
                <td width="14%">${log.createUser}</td>
				<td width="21%">${log.createTime}</td> 
				<td width="14%">${log.currentStep}</td> 
				<td width="14%">${log.currentAction}</td>
				<td width="30%" style="word-break:break-all">${log.approveComment}</td>
            </tr>
        </#list>
        </tbody>
    </table> 
</#if>