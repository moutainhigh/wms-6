<#-- 分页（Pager对象、链接URL、参数Map、最大页码显示数、页数直接跳转） -->
<#macro pager pager baseUrl parameterMap = {} maxShowPageCount = 6>

	<#local pageNumber = pager.pageNumber />
	<#local pageSize = pager.pageSize />
	<#local pageCount = pager.pageCount />
	<#local property = pager.property />
	<#local keyword = pager.keyword />
	<#local orderBy = pager.orderBy />
	<#local orderType = pager.orderType />
	
	<#local parameter = "" />
	<#if (pageSize != "")!>
		<#local parameter = parameter + "&pageSize=" + pageSize />
	</#if>
	<#if (property != "")!>
		<#local parameter = parameter + "&property=" + property />
	</#if>
	<#if (keyword != "")!>
		<#local parameter = parameter + "&keyword=" + keyword />
	</#if>
	<#if (orderBy != "")!>
		<#local parameter = parameter + "&orderBy=" + orderBy />
	</#if>
	<#if (orderType != "")!>
		<#local parameter = parameter + "&orderType=" + orderType />
	</#if>
	<#list parameterMap?keys as key>
		<#if parameterMap[key] != null && parameterMap[key] != "">
			<#local parameter = parameter + "&" + key + "=" + parameterMap[key] />
		</#if>
	</#list>
	
	<#if baseUrl?contains("?")>
		<#local baseUrl = baseUrl + "&" />
	<#else>
		<#local baseUrl = baseUrl + "?" />
	</#if>
	<#local firstPageUrl = baseUrl + "pageNumber=1" + parameter />
	<#local lastPageUrl = baseUrl + "pageNumber=" + pageCount + parameter />
	<#local prePageUrl = baseUrl + "pageNumber=" + (pageNumber - 1) + parameter />
	<#local nextPageUrl = baseUrl + "pageNumber=" + (pageNumber + 1) + parameter />

	<#if maxShowPageCount <= 0>
		<#local maxShowPageCount = 4>
	</#if>
	
	<#local segment = ((pageNumber - 1) / maxShowPageCount)?int + 1 />
	<#local startPageNumber = (segment - 1) * maxShowPageCount + 1 />
	<#local endPageNumber = segment * maxShowPageCount />
	<#if (startPageNumber < 1)>
		<#local startPageNumber = 1 />
	</#if>
	<#if (endPageNumber > pageCount)>
		<#local endPageNumber = pageCount />
	</#if>

	<#if (pageCount > 1)>
<script language="javascript" type="text/javascript">
	$(function () {
 	$('#go').click(function () {
 		var gopage=$("#go2page").val();
 		if(gopage=='')
 		{
 			alert("页数不能为空");
 			return false;
 		}
 	    
 		if(parseInt(gopage)==gopage && parseInt(gopage)>0){
 			if(parseInt(gopage)>parseInt(${pageCount})){
 				alert("页数不能大于总页数！");
 				return false;
 			}else{
 				var pageurl="${base}${baseUrl + "pageNumber=" + "\"+gopage+\"" + parameter}";
	 			window.location.href = pageurl;
 			}
 			
 		}else{
 			alert("请输入大于0的数字！");
 			return false;
 		}
	 		
    });
});
</script>
			<#-- 上一页 -->
			<#if (pageNumber > 1)>
				<a href="${base}${prePageUrl}" class="prev">上一页</a>
			<#else>
				<span class="prev">上一页</span>
			</#if>
			
			<#if (startPageNumber > 1)>
					<a href="${base}${firstPageUrl}">1</a>
					<span>...</span>
			</#if>
			
			<#list startPageNumber .. endPageNumber as index>
				<#if pageNumber != index>
						<a href="${base}${baseUrl + "pageNumber=" + index + parameter}">${index}</a>
				<#else>
						<a href="${base}${baseUrl + "pageNumber=" + index + parameter}" class="current">${index}</a>
				</#if>
			</#list>
			
			<#if (endPageNumber < pageCount)>
					<span>...</span>
					<a href="${base}${lastPageUrl}">${pageCount}</a>
			</#if>
		    
			<#-- 下一页 -->
			<#if (pageNumber < pageCount)>
					<a href="${base}${nextPageUrl}" class="next">下一页</a>
			<#else>
					<span class="prev">下一页</span>
			</#if>
			
			<div>跳转至<input type="text" id="go2page" value="${pageNumber}">页
				<input type="button" class="pagesubmit" value="确定" id="go">
			</div>
	</#if>

</#macro>