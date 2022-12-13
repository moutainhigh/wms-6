<style>
  .boder-right-scroll{
   width:100%; overflow-x:scroll; 
   } 
   .row-fluid{
    height:
  50px; 
  }
    th{
    work-wrap:break-word;
  }
    #resultList tbody  td{
    word-break:break-all;word-wrap:break-word
  }
</style>
<div class="container-fluid">
  <!-- BEGIN PAGE HEADER-->
  <div class="row-fluid">
    <div class="span12">
      <!-- BEGIN PAGE TITLE & BREADCRUMB-->
      <h3 class="page-title">
        在职管理
      </h3>
      <ul class="breadcrumb">
        <li>
          <i class="icon-home">
          </i>
          在职管理
          <i class="icon-angle-right">
          </i>
        </li>
        <li>
          <a href="${baseUrl}/reportManagement/list.htm">
            人员异动
          </a>
        </li>
      </ul>
      <!-- END PAGE TITLE & BREADCRUMB-->
    </div>
  </div>
  <!-- END PAGE HEADER-->
  <div class="row-fluid">
    <div class="span12">
      <div class="portlet box blue">
        <div class="portlet-title">
          <div class="caption">
            <i class="icon-reorder">
            </i>
            在职管理 
          </div>
        </div>
        <div class="portlet-body">
          <!-- BEGIN FORM-->
          <form action="#" role="form" class="form-horizontal" id="refundForm">
            <div class="row-fluid">
              <div class="span5 responsive">
                <label class="control-label">
                  岗位职务：
                </label>
                <div class="controls">
                  <select class="span12 m-wrap" name="loanWayQuery" id="loanWayQuery">
                    <option value='-1'>
                      请选择
                    </option>
                  </select>
                </div>
              </div>
              <div class="span6 responsive">
                <label class="control-label">
                  员工姓名：
                </label>
                <div class="controls">
                  <input type="text" maxlength="20" class="span9 m-wrap" name="custNameQuery"
                  id="custNameQuery">
                </div>
              </div>
            </div>
            <div class="row-fluid">
              <div class="span5 responsive">
                <label class="control-label">
                  在职情况：
                </label>
                <div class="controls">
                  <select class="span12 m-wrap" name="areaOrgIdsQuery" id="areaOrgIdsQuery">
                    <option value='-1'>
                      请选择
                    </option>
                  </select>
                </div>
              </div>
              <div class="span6 responsive">
                <label class="control-label">
                  移动电话：
                </label>
                <div class="controls">
                  <input type="text" maxlength="20" class="span9 m-wrap" name="custNameQuery"
                  id="custNameQuery">
                </div>
              </div>
            </div>
            <div class="control-group">
              <div class="span5 responsive">
              </div>
              <div class="span5 responsive" style="margin-left:59.5%">
                <input type="button" class="btn blue" value="查询" id="query">
                <input type="button" class="btn blue" value="重置" id="reset">
              </div>
            </div>
            <div class="form-section">
            </div>
            <div style="overflow-x: hidden;">
              <table id="resultList" class="table table-striped table-bordered table-hover">
                <thead id="tableName">
                  <th>
                    员工姓名
                  </th>
                  <th>
                    性别
                  </th>
                  <th>
                    任职部门
                  </th>
                  <th>
                    岗位职务
                  </th>
                  <th>
                    移动电话
                  </th>
                  <th>
                    入职时间
                  </th>
                  <th>
                    操作
                  </th>
                </thead>
              </table>
            </div>
          </form>
          <!-- END FORM-->
        </div>
      </div>
    </div>
  </div>
</div>
<div id="responsive" class="modal hide fade" tabindex="-1" data-width="100%"
style="width:800px;height:500px">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
    </button>
    <font size="3.5">
      图片信息
    </font>
    <div id="imgChangeDiv">
    </div>
  </div>
  <div style="position:absolute;left:0px;top:50px;">
    <div id="documentViewer" class="flexpaper_viewer" style="width:800px;height:500px">
    </div>
  </div>
</div>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript">
</script>
<script src="${baseUrl}/assets/js/form-components.js" type="text/javascript">
</script>
<script src="${baseUrl}/assets/js/jobmanagement/orglist.js">
</script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
  var base = "${baseUrl}";
  var resBase = "${resRoot}"; (function($) {
    $(function() {
      App.init();
      FormComponents.init();
    });
  })(jQuery);
</script>
 