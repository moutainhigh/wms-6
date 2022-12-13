<div class='modal-header'>
	<button type='button' class='close' data-dismiss='modal' aria-hidden='true'></button>
	<h3>首期债权及受让协议</h3>
</div>
<div class='modal-body'>
	<div class="view_top">
		<img src="${baseUrl}/assets/image/image001.png" class="images1">
	</div>
	<div class="view_nav">
		<p class="line1"></p>
		<p class="number">${billViewVo.lenderCustZip}<br>
			<span class="address1">${billViewVo.lenderCustAddress}</span></span></p>
		<p class="receiver"> ${billViewVo.lenderCustName} <span class="accept"> 收 </span>	</p>
	</div>
	<div class="view_content">
		<p class="title1">债权转让及受让协议 </p>
		<p class="hello">
			尊敬的 <span class="underline1">${billViewVo.lenderCustName}</span>  先生/女士，您好！
		</p>
		<p style="text-indent:4em;">
				通过达信公司的评估与筛选，推荐您通过受让他人既有的个人间借贷合同的方式，
				出借资金给如下借款人，详见《债权列表》。</p>
		<p style="text-indent:2em"> 
			在您接受该批债权转让并按时支付对价的情况下，预期您的出借获益情况如下：
		</p>
		<p style="text-weight:bold;text-align:right;"> 
			货币单位：人民币（元）
		</p>
		<div class="view_box">
			<table class="table1">
				<thead>
					<tr>
						<th style="width:60px;"> 出借编号 </th> 
						<th>资金出借及回收方式</th> 
						<th>初始出借日期</th>
						<th>初始出借金额 </th> 
						<th>下一个报告日 </th>
						<th>下一个报告期借款人应还款额</th>
						<th>账户管理费 </th>	
						<th>预计下一个报告日您的资产总额</th>
					</tr>
				</thead>
				<tbody>
					<#list billViewVo.lenderDetailVos as lenderDetailVo>
					<tr>
						<td>${lenderDetailVo.lenderCode}</td>
						<td>${lenderDetailVo.productName}</td>
						<td>${billViewVo.printDate}</td>
						<td>${lenderDetailVo.lenderAmount}</td>
						<td>${lenderDetailVo.nextReportDate}</td>
						<td>${lenderDetailVo.nextRepRepayAmount}</td>
						<td>${lenderDetailVo.accountManagerAmount}</td>
						<td>${lenderDetailVo.nextRepAssetAmount}</td>
					</tr>
					</#list> 	
				</tbody>
			</table>
		</div>
		<p class="title2"> 债权列表 </p>
		<div class="assignor">
			转让人（原债权人）：鲁永祥 <span class="receiver"> 受让人（新债权人）：${billViewVo.lenderCustName}</span>
		</div>
		<div class="idCode1">身份证号码：370206195007272814<span class="idCode2">  身份证号码：${billViewVo.lenderCustIdCard}</span>
		</div><br>
		<div class="detail1" style="font-size:9.0pt;text-indent:2em;">转让债权明细： 
			<span style="display:block;float:right;">  货币单位：人民币（元）</span>
		</div>
		<div class="view_box2">
			<table class="table2">
				<thead>
					<tr>
						<th colspan="7">债权基本信息</th>
						<th colspan="4">借款人如约还款情况下债权收益信息</th>
					</tr>
					<tr>
						<th style="width:50px;"> 序号 </th>
					  	<th>借款人姓名</th>
					  	<th>借款人身份证号码</th>
						<th>本次转让债权价值</th>
					  	<th>需支付对价 </th>
						<th>借款人职业情况</th>
					  	<th>借款人借款用途 </th>	
					  	<th>还款起始日期 </th>
					  	<th>还款期限（月）</th>	
					  	<th>剩余还款月数</th>	
					  	<th>预计债权收益率（年）</th>	
					</tr>
				</thead>
				<tbody>
				<#list billViewVo.creditorDetailVos as creditorDetailVo>
				<tr>
					<td>${creditorDetailVo_index + 1}</td>
					<td>${creditorDetailVo.loanCustName}</td>
					<td>${creditorDetailVo.loanCustIdCard}</td>
					<td>${creditorDetailVo.creditorAmountView}</td>
					<td>${creditorDetailVo.payConsiderationView}</td>
					<td>${creditorDetailVo.loanCustWorkSituationView}</td>
					<td>${creditorDetailVo.loanPurposeView}</td>
					<td>${creditorDetailVo.bizStartDateView}</td>
					<td>${creditorDetailVo.period}</td>
					<td>${creditorDetailVo.remainingPeriod}</td>
					<td>${creditorDetailVo.annualReRateView}</td>
				</tr>
				</#list>
				<tr>
				<th colspan="3">合计</th>
					<td>${billViewVo.totalCreditorAmount}</td>
					<td>${billViewVo.totalPayConsideration}</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>	
				</tbody>
			</table>
			</div><br>
			<p class="title3"> 转让人声明 </p><br>
			<p class="statement">本人自愿将上述债权转让给受让人。如果受让人对上述债权转让没有任何异议，须于
				 <span class="underline2">  ${billViewVo.printDate}    </span>  前将上述对价共计：</p><br>
			<p class="money">人民币（大写）<span class="underline3">     ${billViewVo.lenderAmountCn}  </span>   
				（人民币小写￥<span class="underline4">   ${billViewVo.lenderAmountView}   </span>  ）支付到如下指定账户。</p><br>
			<div class="title4">开户行：招商银行上海分行新客站支行</div>
			<p class="title5">账户名称：鲁永祥</p>
			<p class="title6">账号：6214831211095986</p>
			<div style="text-indent:2em;">自款项到账之日起，上述债权转让即生效；债权转让生效后，
				署有本人签章的本文件即代表受让人对上述债权的所有权。<p style="line-height:50px;"> 本人特此签章证明。</p></div>
			<div class="assignor2">
				转让人：鲁永祥   <span class="witness"> 见证人：达信卓惠金融信息服务（上海）有限公司</span>
			</div>
			<div style="text-indent:15em;">
				签章： <span style="position:relative;left:202px;">盖章：</span>
			</div>
			<div style="text-indent:15em;"> 
				日期：${billViewVo.printDate}<span style="position:relative;left:134px;">日期：${billViewVo.printDate}  </span>
			</div>
			<div class="dottedLine"></div>
			<div style="text-indent:2em;">
				提示：<p>如果受让人对上述债权全部或部分不认可，请填写本执，标明所拒绝的债权序号，
				在 <span style="text-decoration:underline"> ${billViewVo.printDate}</span>   前将回执交给达信并自己保留一份取得达信盖章的回执，
				由达信协调进行其他债权的推荐。</p>
			</div>
				<p class="title3"> 债权转让拒绝回执</p>
				<p style="text-indent:2em;"> 本人拒绝转让人<span style="text-decoration:underline;"> 鲁永祥 </span>上述欲转让给本人的第 
					 <span style="text-decoration:underline;"></span> 号（依次填写序号）债权，本人将不予支
					付该债权的对价；对于其他未拒绝的债权，将按时支付对价。请达信公司知悉并见证。</p><br>
					<p style="text-indent:2em;">本人特此签章证明。 </p>
					<div class="assignor2"> 受让人： ${billViewVo.lenderCustName} <span class="witness">见证人：达信卓惠金融信息服务（上海）有限公司
				</span>
			</div>
			<div style="text-indent:15em;">
				签章：<span style="position:relative;left:210px;">盖章：</span>
			</div>
			<div style="text-indent:15em;">
				日期：<span style="position:relative;left:210px;">日期：</span>
			</div>
		</div>	
		<div class="view_foot">
			<p class="company">上海市花旗大厦</p>
		</div>		
</div>
<div class='modal-footer'>
	<button type='button' class='btn mini blue download' bizId='" + aData.bizId + "' custName='" + aData.custName + "'>下载</button>		
	<button type='button' data-dismiss='modal' class='btn'>关闭</button>
</div>