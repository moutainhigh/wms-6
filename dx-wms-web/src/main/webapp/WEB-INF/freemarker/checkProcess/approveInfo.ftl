<style>
    .boder-right-scroll{
        width:100%;
        overflow-x:scroll;
    }
    .row-fluid{
        height: 50px;
    }
</style>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <div class="portlet-body">
				<#if lenderApplyLogs?? && lenderApplyLogs?size!=0>
				<div id="checkRecords" >
					<div class="control-group" id="ckResults" style="text-align:center;height:auto;">
                    <!-- 影像资料文件夹 -->     
                    	<div class="form-group">
		    				<table cellspacing="0" class="table table-striped table-bordered table-advance table-hover">
								<thead>
									<tr>
										<th>审批人</th>
										<th>审批时间</th>
										<th>审批环节</th>
										<th>审批结果</th>
										<th>审批内容</th>
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
				
				<div class="row-fluid">
			        <div class="span6 responsive">
                        <label class="control-label">审批内容：<span class="required">*</span></label>
                        <div class="controls">
                            <textarea style="resize:none;" cols="40" rows="4" name="approveComment" id="approveComment" maxlength="400" ></textarea>
                            <span class="help-inline"></span>
                        </div>
                    </div>
                    <div class="span6 responsive"  style="margin-left: -50px;">
                        <label class="control-label">&nbsp;</label>
                        <div class="controls">
                            &nbsp;
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
var base = "${baseUrl}"; 
var resBase = "${resRoot}";

</script>
  
<!-- BEGIN PAGE LEVEL SCRIPTS -->


 