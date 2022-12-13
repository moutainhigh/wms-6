`<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<#assign saicf=JspTaglibs["http://it.saic.com/saicf"]>
<script type="text/javascript" src="${base}/jslib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${base}/jslib/jquery.form.min.js"></script>
<script type="text/javascript" src="${base}/jslib/se.ajax.js"></script>
<script type="text/javascript" src="${base}/jslib/se.form.js"></script>
<script type="text/javascript">
$(function(){
 
	 
	 $.se.post({
		 url:"redistort/validFrom",
		 data:data,
		 success:function(result){
		 	//deal with result
		 }
	 })
	
 });

 </script>
</head>
<body>

<form id="myForm">
	<@saicf.reDistortFormTag   name="antiDistorTest">
	<@saicf.reDistortFieldTag name="price" value="100.00"/>
	<@saicf.reDistortFieldTag name="inventory" value="20"/>
	<@saicf.reDistortFieldTag name="code" value="a3"/>
	</@saicf.reDistortFormTag>
	<div id="d1">1<input type="text" name="txt1" /></div><br>
	<br>
	<div id="d2">2<input type="text" name="txt2"/></div><br>
	
	<input type="button"  name="btn1" id="btn1" value="test"/>
</form>
 </body>
</html>
