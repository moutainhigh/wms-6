<style>
  
    .row-fluid{
        height: 62px;
    }
    .modal {
    position: fixed;
    top: 10%;
    left: 50%;
    z-index: 1050;
    width: 800px;
    margin-left: -400px;
    background-color: #fff;
    border: 1px solid #999;
    border: 1px solid rgba(0, 0, 0, 0.3);
    *border: 1px solid #999;
    -webkit-border-radius: 6px;
    -moz-border-radius: 6px;
    border-radius: 6px;
    outline: 0;
    -webkit-box-shadow: 0 3px 7px rgba(0, 0, 0, 0.3);
    -moz-box-shadow: 0 3px 7px rgba(0, 0, 0, 0.3);
    box-shadow: 0 3px 7px rgba(0, 0, 0, 0.3);
    -webkit-background-clip: padding-box;
    -moz-background-clip: padding-box;
    background-clip: padding-box
}
	#resultRecordList{
    	table-layout:fixed;
    }
    th{
    	work-wrap:break-word;
    }
    #resultRecordList tbody  td{
    	word-break:break-all;word-wrap:break-word
    }
   
    
</style>
<div class="container-fluid">
    <!-- BEGIN PAGE HEADER-->
    <div class="row-fluid">
        <div class="span12"><br>
            <div class="portlet box blue">
            <div class="portlet-title">
                <div class="caption"><i class="icon-reorder"></i>变更记录</div>
            </div>
            <input type="hidden" name="pkId" id="pkId" value="${pkId}">
            <div class="portlet-body">
                <!-- BEGIN FORM-->
                <form action="#" role="form" class="form-horizontal" id="refundForm">
                 <!-- END FORM-->
                <div style="overflow-x: hidden;">
                        <table id="resultRecordList" class="table table-striped table-bordered table-hover" style="width:200% !important">
                            <thead>
                                <th >客户编号</th>
                                <th>客户姓名</th>
                                <th >变更项</th>
                                <th >原始内容</th>
                                <th width="50px;">变更内容</th>
                                <th >变更时间</th>
                            </thead>
                        </table>
                </div>
                <div class="control-group">
                        <div class="span5 responsive" style="margin-left: 71%">
                            <input type="button" class="btn red" value="关闭" id="close">
                        </div>
                 </div>
                </form>   
            </div>
        </div>
    </div>
    </div>
</div>
<script src="${baseUrl}/assets/js/custInfoChange/record.js" type="text/javascript"></script> 
<script>
var base = "${baseUrl}"
</script>
<script>
    (function($) {
        $(function() {
            queryRecordData();
        });
    })(jQuery);
    
</script>