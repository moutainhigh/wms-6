<style>
    .boder-right-scroll{
        width:100%;
        overflow-x:scroll;
    }
    .row-fluid{
        height: 50px;
    }
</style>
<h4 class="form-section">影像信息</h4>
<!-- 资源标示 wmsCustOpenApply wmsCustLenderApply  wmsLenderCheck-->
<input type="hidden" id="resKey" name="resKey" value="wmsCustOpenApply" >
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
<script>
var base = "${baseUrl}"; 
var resBase = "${resRoot}";
</script>
<script>
        $(function() {
	        showRefFolders();
        });
</script>    
<!-- BEGIN PAGE LEVEL SCRIPTS -->


 