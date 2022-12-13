<#import "hr/entry/fileInfo.ftl" as fileInfo>

<div class="control-group" id="vFolder" style="text-align:center;height:auto;margin-top:40px">
    <!-- 影像资料文件夹 -->				
</div>
<br ><h4 class="form-section"></h4>	
<div class="control-group" id="vFile" style="text-align:center;height:auto;">
	<!-- 影像资料文件 -->
</div>
<#if lenderApplyLogs?? && lenderApplyLogs?size!=0>
<div id="checkRecords" >
    <h4 class="form-section" style="text-align:left">  操作记录  </h4>
    <div class="control-group" id="ckResults" style="text-align:center;height:auto;">
    <!-- 影像资料文件夹 -->     
        <div class="form-group">
            <table cellspacing="0" class="table table-striped table-bordered table-advance table-hover">
                <thead>
                    <tr>
                        <th>操作人</th>
						<th>操作时间</th>
						<th>操作环节</th>
						<th>操作结果</th>
						<th>操作内容</th>
                    </tr>
                </thead>
                <tbody id="logList">
                    <#if lenderApplyLogs?exists>
                        <#list lenderApplyLogs as log>
                            <tr>
                                <td width="150">${log.createUser}</td>
								<td width="250">${log.createTime}</td> 
								<td width="150">${log.currentStep}</td> 
								<td width="150">${log.currentAction}</td>
								<td width="400" style="word-break:break-all">${log.approveComment}</td>
                            </tr>
                        </#list>
                    </#if>
                </tbody>
            </table>
        </div>
    </div>
</div>
</#if>