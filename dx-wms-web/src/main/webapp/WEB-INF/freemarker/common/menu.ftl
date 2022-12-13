<div class="page-sidebar nav-collapse collapse">
	<!-- BEGIN SIDEBAR MENU -->
        <ul class="page-sidebar-menu">
            	<li>
                <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                <div class="sidebar-toggler hidden-phone"></div>
                <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
            	</li>
           	<#if menus?exists>
          		<li class="start ">
				<a href="${baseUrl}/index.htm">
				<i class="icon-home"></i>
				<span class="title">首页</span>
				</a>
				</li>
			<#list menus as cscMenu>
			<li class="">
				<a href="javascript:;">
				<i class="icon-cogs"></i>
				<span class="title">${cscMenu.name}</span>
				<span class="arrow "></span>
				</a>
			<#if cscMenu.hasChild>
				<ul class="sub-menu">
			<#list cscMenu.childList as child1>
				<li>
				<a href="${baseUrl}${child1.url}">${child1.name}
			<#if child1.hasChild>
				<span class="arrow "></span>
			</#if>
				</a>
			<#if child1.hasChild>
				<ul class="sub-menu">
			<#list child1.childList as child2>
				<li>
				<a href="${baseUrl}${child2.url}">${child2.name}
			<#if child2.hasChild>
				<span class="arrow"></span>
			</#if>
				</a>
			<#if child2.hasChild>
				<ul class="sub-menu">
			<#list child2.childList as child3>
				<li>
				<a href="${baseUrl}${child3.url}">${child3.name}
			<#if child3.hasChild><span class="arrow "></span></#if>
				</a>
				</li>
			</#list>
				</ul>
			</#if>
				</li>
			</#list>
				</ul>
			</#if>
				</li>
			</#list>
				</ul>
			</#if>	
				</li>
			</#list>
			</#if>
        </ul>
 </div>       
 
