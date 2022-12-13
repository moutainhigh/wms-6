<#include "/macro/base.ftl">
<div class="row-fluid h50">
	<@div title="剩余债权-起（万）" span="span4">
    	<@text name="remainAmountFrom" id="remainAmountFrom" class="small"/>
    </@div>
    <@div title="剩余债权-止（万）" span="span4">	
    	<@text name="remainAmountTo" id="remainAmountTo" class="small"/>
    </@div>
    <@div title="剩余债权（排序）" span="span4">
   		<@select source=sort name="sort" id="sort" default=false class="small"/>	
    </@div>
</div>
<div class="row-fluid h50">
	<@div title="剩余期限-起（月）" span="span4">
    	<@text name="remainPeriodFrom" id="remainPeriodFrom" class="small"/>
    </@div>
    <@div title="剩余期限-止（月）" span="span6">	
    	<@text name="remainPeriodTo" id="remainPeriodTo" class="small"/>
    </@div>
   	<div class="span2 responsive">
   		<@query id="findQuery"/>
    	<@reset id="findReset"/>
    </div>   
</div>
<@datatable id="findResult" items=["checkbox","客户姓名","可推荐比例","剩余债权","初始债权","还款期数","剩余期数","年利率","还款日","产品类型"] />
<script src="${baseUrl}/assets/js/match/find/list.js" type="text/javascript"/>		 
