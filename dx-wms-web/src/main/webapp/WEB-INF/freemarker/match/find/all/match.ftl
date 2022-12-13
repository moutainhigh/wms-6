<style>
.label-info a:hover, a:active {
    color: #fff;
    text-decoration: none;
}
.label-info a{
	color: #fff;
    text-decoration: none;
}
</style>
<#include "/macro/base.ftl">
<@datatable id="matchResult" items=["信贷客户","匹配金额","剩余债权","初始债权","还款期数","剩余期数","年利率","还款日","产品类型","操作"] />
<script src="${baseUrl}/assets/js/match/find/all/match.js" type="text/javascript"/>