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
            	
                
                <!-- 资源标示 wmsCustOpenApply wmsCustLenderApply  wmsLenderCheck-->
				<input type="hidden" id="resKey" name="resKey" value="wmsLenderCheck" >
				<!-- 系统 编码-->
				<input type="hidden" id="appCode" name="appCode" value="wms" >
				<!-- 当前查看文件的目录 -->
				<input type="hidden" id="currentFileDir" name="currentFileDir" value="" >
				<!-- 上传文件 -->
				<input type="hidden" id="cmAction" name="cmAction" value="uploadFile" >
				<!-- 用户编号  -->
				<input type="hidden" id="userUniqueId" name="userUniqueId" value="${custAccountId}" >
				<input type="hidden" id="lenderCustCode" name="lenderCustCode" value="${lenderCustCode}" >
				<!-- 某用户理财序号 -->
				<input type="hidden" id="lenderUniqueId" name="lenderUniqueId" value="${lenderApplyId}" >
				<input type="hidden" id="lenderCode" name="lenderCode" value="${lenderCode}" >
				<!-- 影像文件只读配置 -->
				<input type="hidden" id="readonly" name="readonly" value="true" >
                                    
                <div class="control-group" id="vFolder" style="text-align:center;height:auto;">
                    <!-- 影像资料文件夹 -->                
                </div>
                <br >
                <h4 class="form-section"></h4> 
                <div class="control-group" id="vFile" style="text-align:center;height:auto;">
                    <!-- 影像资料文件 -->
                </div> 
				<#if lenderApplyLogs?? && lenderApplyLogs?size!=0>
				<div id="checkRecords" >
					<h4 class="form-section" style="text-align:left;">  操作记录  </h4>
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
            </div>
        </div>
    </div>
</div>

<script>
var base = "${baseUrl}"; 
var resBase = "${resRoot}";
</script>
<script src="${baseUrl}/assets/flexpaper/js/flexpaper.js"></script>
<script src="${baseUrl}/assets/js/contents/image_goto_change.js"></script>
<script>
        $(function() {
        	showRefFolders();
        });
</script>    
<!-- BEGIN PAGE LEVEL SCRIPTS -->


 