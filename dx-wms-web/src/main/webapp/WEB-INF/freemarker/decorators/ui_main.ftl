<!DOCTYPE html>
<!-- BEGIN HEAD -->
<#assign menuTab="">
<script>var baseUrl="${request.contextPath}";</script>  
<@include_page path="/head.json" />
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
 	<div class="header navbar navbar-inverse navbar-fixed-top">
   	<@include_page path="/top.json" />
    </div>
   <!-- BEGIN CONTAINER -->
   <div class="page-container">
   	  <!-- BEGIN SIDEBAR -->       
	  <@include_page path="/menu.json" />
	  <!-- BEGIN PAGE -->
      <div class="page-content">
      ${body}
      </div>
   </div>
   <!-- END CONTAINER -->
   <!-- BEGIN FOOTER -->
   <@include_page path="/footer.json" />
   <!-- END FOOTER -->
</body>
<!-- END BODY -->
</html>