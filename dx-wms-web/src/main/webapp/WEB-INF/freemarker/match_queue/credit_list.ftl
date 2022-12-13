<style> 
    .row-fluid{
        height: 50px;
    }
    .view{
	    float: left;
	    padding-top: 5px;
	    text-align: left;
	    width: 200px;
	    margin-top: 2px;
	    margin-left: 10px;
	}
	.show{
		float: left;
	    padding-top: 5px;
	    text-align: right;
	    width: 100px;
	    margin-top: 2px;
	    margin-left: 10px;
	}
}  
</style>
<#include "/macro/base.ftl">
<div class="container-fluid">
	<@head title="债权队列" home="队列管理" item={"债权队列":"/matchQueue/credit.htm"} />
	<@portlet title="债权队列" formId="matchQueueForm">
		 <div class="row-fluid">
	    	<@div title="客户姓名">
	        	<@text id="custName"/>
	        </@div>
	        <@div title="还款日">
	        	<select class="medium m-wrap" name="repaymentDay" id="repaymentDay">
					<option value=''>请选择</option>
					<option value='1'>1</option>
					<option value='16'>16</option> 
    			</select>	
	        </@div>
	    </div>
	    <div class="row-fluid">
	     	<@div title="签约日期（起）">
	        	<@date id="signDateBegin" name="signDateBegin" />
	        </@div>
	        <@div title="签约日期（止）">
	        	<@date id="signDateEnd" name="signDateEnd" />
	        </@div>
	    </div>
	    <div class="row-fluid">
	    	<@div title="放款日期（起）">
	        	<@date id="enterDateBegin" name="enterDateBegin" />
	        </@div>
	        <@div title="放款日期（止）">
	        	<@date id="enterDateEnd" name="enterDateEnd" />
	        </@div>
	    </div>
	    <div class="control-group">
            <div class="span5 responsive"></div>
            <div class="span5 responsive" style="margin-left: 110px;">
                <input type="button" class="btn blue" value="查询" id="query">
                <input type="button" class="btn blue" value="重置" id="reset">
                <input type="button" class="btn green" value="加入" id="add">
            </div>
        </div>
        <@line/>
        <@datatable id="statList" items=["还款日","借款数量","借款金额"]></@datatable>
        <@line/>
        <@datatable id="statList" items=["还款日","借款数量","借款金额"]></@datatable>
    </@portlet>
</div>
<!-- BEGIN PAGE L SCRIPTS -->
<script src="${baseUrl}/assets/js/app.js" type="text/javascript"></script>
<script src="${baseUrl}/assets/js/form-components.js"></script>
<script src="${baseUrl}/assets/js/match_queue/credit_list.js" type="text/javascript"></script> 
<script src="${baseUrl}/assets/js/match_queue/credit_stat_list.js" type="text/javascript"></script> 
<!-- END PAGE LEVEL SCRIPTS -->
<script>var base = "${baseUrl}"</script>
<script>
    (function($) {
        $(function() {
            App.init();
            FormComponents.init();
        });
    })(jQuery);
    
</script>
 