
<#import "fileBase/baseInfo.ftl" as baseInfo>

<#macro logModel results={}>
	<#if results?exists && results?size gt 0>
		<div class="control-group" style="height: auto;">
			<div class="span10 responsive" style="">
                <div class="controls span12">
                    <div class="form-group">
						<table class="table table-striped table-bordered table-advance table-hover">
							<thead>
								<tr>
									<th>审批人</th>
									<th>审批时间</th>
									<th>审批结果</th>
									<th>审批内容</th>
								</tr>
							</thead>
							<tbody class="results">
								<#list results as log>
								<tr>
									<td>${log.userName}</td>
									<td>${(log.ctime?string("yyyy-MM-dd HH:mm:ss"))!"-"}</td>
									<td>${log.action}</td>
									<#if applicant != log.userId>
									<td class="tooLong">${log.content}</td>
									<#else>
									<td class="tooLong">提交申请单</td>
									</#if>
								</tr>
								</#list>
							</tbody>
			  			</table>
					</div>
                </div>
            </div>
            <div style="clear:both;height:1px;width:100%; overflow:hidden; margin-top:-1px;"></div>
		</div>
	</#if>
</#macro>

<#macro approveLogModel results={}>
	<#if results?exists && results?size gt 0>
		<div class="control-group" style="height: auto;">
			<div class="span12 responsive" style="">
                <div class="controls span12">
                    <div class="form-group">
						<table class="table table-striped table-bordered table-advance table-hover">
							<thead>
								<tr>
									<th>操作环节</th>
									<th>发起人</th>
									<th>操作时间</th>
									<th>原始情况</th>
									<th>操作结果</th>
								</tr>
							</thead>
							<tbody class="results">
								<#list results as log>
								<tr>
									<td>${log.businessType}</td>
									<td>${log.userName}</td>
									<td>${(log.ctime?string("yyyy-MM-dd HH:mm:ss"))!"-"}</td>
									<td class="tooLong">${log.before}</td>
									<td class="tooLong">${log.result}</td>
								</tr>
								</#list>
							</tbody>
			  			</table>
					</div>
                </div>
            </div>
            <div style="clear:both;height:1px;width:100%; overflow:hidden; margin-top:-1px;"></div>
		</div>
	</#if>
</#macro>

<#macro simpleLogModel title="" block="" titles=[]>
<div class="" id="${block}">
	<h4 class="form-section" style="">${title}</h4>
	<div class="control-group" style="">
        <div class="form-group">
			<table class="table table-striped table-bordered table-advance table-hover">
				<thead>
					<tr>
						<#list titles as title>
							<th>${title}</th>
						</#list>
					</tr>
				</thead>
				<tbody class="results"></tbody>
  			</table>
		</div>
        <div style="clear:both;height:1px;width:100%; overflow:hidden; margin-top:-1px;"></div>
	</div>
</div>
</#macro>

 