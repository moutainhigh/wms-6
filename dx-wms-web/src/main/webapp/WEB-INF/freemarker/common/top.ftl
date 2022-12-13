<style>
	.dueAndBir{
		background-color:#eee;
		color:#000;
		font-size:14px;
		font-weight:300;
		margin:0;
		padding:10px;
	}
</style>

<!-- BEGIN HEADER -->
<div class="header navbar navbar-inverse navbar-fixed-top">
    <!-- BEGIN TOP NAVIGATION BAR -->
    <div class="navbar-inner">
        <div class="container-fluid">
            <!-- BEGIN LOGO -->
            <span class="brand">
                <img src="${baseUrl}/assets/image/logo_mini.jpg" style="height: 30px;" alt="logo" />
            </span>
            <#if role==3>
            <span style="color:#ddd;">
            	理财服务部
            </span>
            <span style="color:#ddd;position:absolute;bottom:10px;left:225px">
            	${org.name}
            </span>
            <#elseif role==2>
            <span style="color:#ddd;line-height:40px;">
            	${org.name}
            </span>
            <#elseif role==1>
            <span style="color:#ddd;line-height:40px;">
            	${parentOrg.name}
            </span>
            <#else>
            <span style="color:#ddd;">
            	${allOrg.name}
            </span>
            <span style="color:#ddd;position:absolute;bottom:10px;left:225px">
            	${parentOrg.name}
            	${org.name}
            </span>
            </#if>
            <!-- END LOGO -->
            <!-- BEGIN RESPONSIVE MENU TOGGLER -->
            <a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">
                <img src="${baseUrl}/assets/image/menu-toggler.png" alt="" />
            </a>
            <!-- END RESPONSIVE MENU TOGGLER -->
            <!-- BEGIN TOP NAVIGATION MENU -->
            <ul class="nav pull-right" style="width:300px">
            	<!-- BEGIN USER LOGIN DROPDOWN -->
                <li class="dropdown user" style="float:right">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img alt="" src="${baseUrl}/assets/image/login2_mini.jpg" />
                        <span class="username">${user.name}</span>
                        <i class="icon-angle-down"></i>
                    </a>
                    <ul class="dropdown-menu">
                    	<li><a href="${baseUrl}/user/updatePassView.htm"><i class="icon-key"></i> 修改密码 </a></li>
                        <li><a href="${baseUrl}/user/loginout.do"><i class="icon-key"></i> 退出 </a></li>
                    </ul>
                </li>
                <!-- END USER LOGIN DROPDOWN -->
                
                <!-- 到期提醒 -->
            	<li id="paymentsDue" class="dropdown" style="float:right">
            		<a href="#" class="dropdown-toggle" data-toggle="dropdown">
            			<i class="icon-envelope"></i>
            			<#if dueNO?exists&&dueNO!=0>
            				<span class="badge">${dueNO}</span>
            			</#if>
            		</a>
            		<ul class="dropdown-menu" style="overflow:auto;height:200px">
            			<li><p class="dueAndBir">${dueManager}</p></li>
            			<#list custNames as custName>
            				<#if custName?exists&&custName!=''>
            					<li><a href="${baseUrl}/process/due.htm"><i class="icon-bolt"></i>${custName}</a></li>
            				</#if>
            			</#list>
            		</ul>
            	</li>
            
            
            	<!-- 生日提醒 -->
            	<li id="birthday" class="dropdown" style="float:right">
            		<a href="#" class="dropdown-toggle" data-toggle="dropdown">
            			<i class="icon-user"></i>
            			<span class="badge"></span>
            		</a>
            		<ul class="dropdown-menu">
            		<li><p class="dueAndBir">生日提醒</p></li>
            			<li><a href="#"><i class="icon-bell"></i>敬请期待...</a></li>
            		</ul>
            	</li>
            	
            </ul>
            <!-- END TOP NAVIGATION MENU -->
        </div>
    </div>
    <!-- END TOP NAVIGATION BAR -->
</div>
<!-- END HEADER -->