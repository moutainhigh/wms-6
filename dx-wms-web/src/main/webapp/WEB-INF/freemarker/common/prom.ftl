<#import "/ftlib/pager.ftl" as p />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>车系活动列表页</title>
    <meta name="keywords" content="SEO内容，关键词" />
    <meta name="description" content="SEO内容，页面描述" />
    <link href="${resRoot}/css/reset.css?v=${jscssVersion}" rel="stylesheet">	
    <link href="${resRoot}/css/common.css?v=${jscssVersion}" rel="stylesheet">
    <link href="${resRoot}/css/component/carStyle.css?v=${jscssVersion}" rel="stylesheet">
    <link href="${resRoot}/css/activitylist.css?v=${jscssVersion}" rel="stylesheet">
</head>
 

<body>
<#assign searchType="车型">
<#include "/index/header.ftl" />
<!--crumbs.html-->
<div class="w960 breadcrumbs" style="margin-left:auto; margin-right:auto;">
    <a href="#" target="_blank">首页</a>&gt;<a href="#" target="_blank">车系</a>&gt;<a href="#" target="_blank">活动</a>
</div>
<!--crumbs.html END-->
<!--车系导航-->
<#include "/product/series/two_navigation.ftl" />
<!-- 车系活动列表页 -->
<div class="w960 mt-50">
<h3 class="title title-m">
		<span class="title-name"><i></i>${list.totalRows}个活动</span>
		<span class="fr">
			<ul class="title-tab title-tab-blue title-tabone">
				<li <#if orderByItem == "ACTIVITY_OVER_TIME"> class="current" </#if>><a href="prom.htm?currentPage=1&pageSize=2&cityId=${cityId}&carCatenaId=${carCatenaId}&orderByItem=ACTIVITY_OVER_TIME&seriesId=${seriesId}&targ=${mark}">按结束时间排序</a></li>
				<li <#if orderByItem == "NUMBER_OF_ENTRIES"> class="current" </#if>><a href="prom.htm?currentPage=1&pageSize=2&cityId=${cityId}&carCatenaId=${carCatenaId}&orderByItem=NUMBER_OF_ENTRIES&seriesId=${seriesId}&targ=${mark}">按热度排序 </a></li>
			</ul>
		</span>
	</h3>
<div class="modelactivity">
 <ul class="avylist">
 <#list list.r as l> 
	<li>
    <div class="pic"><a href="#" target="_blank"><img src="${resRoot}${l.imageUrl}" width="294px" height="198px" alt="" border="0"></a></div>
    <div class="txt">
      <h4><a href="#" target="_blank">${l.title}</a></h4>
      <p><strong>发起方：</strong>${l.sponsor}</p>
      <p><strong>活动有效期：</strong>${l.activityStarTime?string("yyyy.MM.dd")} --- ${l.activityOverTime?string("yyyy.MM.dd")}</p>
      <#if l.activityIsHaventStarted>
      	<p><strong>距离活动开始还有：</strong><span class="color"><font>${l.beAboutToDay}</font>天<font>${l.beAboutToHour}</font>小时<font>${l.beAboutToMinute}</font>分</span></p>
      </#if>
      <#if l.activityIsOnTheMarch>
      	<p><strong>距离活动结束还有：</strong><span class="color"><font>${l.theRemainingDays}</font>天<font>${l.theRemainingHours}</font>小时<font>${l.theRemainingMinute}</font>分</span></p>
      </#if>
    </div>
    <#if l.activityIsOnTheMarch>
    <div class="signup">
      <span class="entered">已有<span class="big">${l.numberOfEntries}人</span>报名</span>
      <span class="atonce"><a href="#" class="btn btn-med btn-green btn-med-apply" target="_blank">立即报名</a>
      </span>
    </div> 
	<#elseif l.activityIsHaventStarted>
    <div class="signup">
		<div class="msgbox msgbox-orange dsp-ib f-14"><i class="icon icon-20 icon-20-clock"></i>活动即将开始，敬请期待！</div>
    </div>
	<#else>
    <div class="signup">
      <span class="entered">共有<span class="big">${l.numberOfEntries}人</span>报名</span>
      <span class="atonce"><span class="btn btn-med btn-gray clr-gray6">活动已结束</span>
      </span>
    </div> 
    </#if>
  </li>
		
	</#list>
	
	<div class="clear"></div>
	<div class="fr mt-15">
	<#-- currentPage:当前页码，pageSize:每页行数，pageCount:页数 -->
	<#assign pager = {"currentPage": (list.currentPage)!,"pageSize": (list.pageSize)!,"pageCount": (list.pageCount)!} />
	<@p.pager pager = pager baseUrl = "/product/promotion/prom.htm"  parameterMap={"cityId":(cityId)!, "carCatenaId":(carCatenaId)!,"orderByItem":(orderByItem)!,"seriesId":(seriesId)!,"targ":(mark)!}/> 
	</div>

	 
 </ul>
</div>
</div>
</body>
</html>
