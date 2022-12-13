<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="${baseUrl}/assets/css/print/laborContract.css" rel="stylesheet" type="text/css" />
	<style media="print">
		.front-text,.main-text{
			border:none;
		}
		body{
			position:relative;
			left:-35px;
			top:-20px;
		}
		.print-body{
			height:1090px;
			border:1px solid white;
		}
		.last-page{
			height:1000px;
		}
		#printDiv{
			display:none;
		}
	</style>
</head>
<body>
<div align="left" id="printDiv" name="printDiv">
	<h4 style="color:red">打印前注意：</h4>
	<p>打印前请确认页边距设置为0，</p>
	<p>设置请在浏览器-打印-页面设置中设置，</p>
	<p>比例设置为100%(默认为调整到适合)</p>
	</br>
	<p><input type="button" class="tab" value="打印" onclick="printFunction();"></p>
	<div class="font-size5" style="position:relative;left:100px;top:-40px;">
	<p><a href="#laborContract">劳动合同</a> </p>
	<p><a href="#secrecyAgreement">保密、不竞争和知识产权归属协议</a> </p>
	<p><a href="#complianceCommitment">合规承诺书</a> </p>
	</div>
</div> 
<!-- laborContract start -->
<div class="font-size5">
<a name="laborContract"></a> 
	<#macro footer value="">
			<p style="font-size:8pt;font-family:微软雅黑;position:absolute;bottom:0;left:365px;">第${value}页&emsp;共8页</p>
	</#macro>	
	<!-- Page 1 start -->
	<div class="print-body front-page">
		<div class="front-text">
			<p align="right" class="info">合同编号：<u><b>${employeeNo}</u></b></p>
			</br>
			</br>
			<p class="title1" align="center">劳 动 合 同</p>
			</br>
			</br>
			</br>
			</br>
			</br>
			</br>
			</br>
			</br>
			</br>
			</br>
			</br>
			</br>
			</br>
			<p class="font-size4" style="position:relative;top:-6px;">姓&nbsp;名  <u><b>${employeeName}</u></b> </p>
			<p class="font-size4" style="position:relative;top:3px;">部&nbsp;门</p>
			<div class="font-size4" style="position:relative;top:-45px;left:64px;width:550px;"><u><b>${orgFullName2}</u></b></div> 
		</div>
	</div>
	<!-- Page 1 end -->
	<!-- Page 2 start -->
	<div id="page2" class="print-body main-page">
		<div class="main-text">
			</br>
			<p>甲方（用人单位）名称：   <b>达信财富投资管理（上海）有限公司</b></p>
			</br>
			<p>法定代表人（委托代理人）： </p>
			</br>
			<p>注册地址或营业地址：<b>上海浦东新区花园石桥路33号花旗集团大厦803室</b></p>
			</br>
			<p>邮政编码：<b>200120</b></p>
			</br>
			</br>
			</br>
			</br>
			<p>乙方（劳动者）姓名： <b>${employeeName}</b></p>
			</br>
			<p>身份证号码： <b>${employeeIdCard}</b></p>
			</br>
			<p>出生日期：  <b>${(birthDate?string("yyyy-MM-dd"))!""}</b></p>
			</br>
			<p>户籍地： <b>${censusAddress}</b></p>
			</br>
			<p>经常居住地址： <b>${homeAddress}</b></p>
			</br>
			<p>联系电话： <b>${mobilePhone}</b></p>
			</br>
			<p>邮编： <b>${homeZipCode}</b></p>
			</br>
			</br>
			</br>
			</br>
			<p>合同签署地：<b>上海浦东新区花园石桥路33号花旗集团大厦803室</b></p>
		</div>
	<@footer value="2" />
	</div>
	<!-- Page 2 end -->
	<!-- Page 3 start -->
	<div id="page3" class="print-body main-page">
		<div class="main-text">
			</br>
			<p>甲、乙双方根据《中华人民共和国劳动法》、《中华人民共和国劳动合同法》以及当地相关法规和政策，</p>
			<p>在平等自愿、协商一致的基础上，订立本合同。</p>
			<p>双方确认，在签订本合同前，双方已经认真全面阅读本合同书条款，清楚全部合同条款含义，本合同一</p>
			<p>经签订，即具有法律效力，双方必须全面严格履行。</p>
			<p>乙方向甲方承诺，乙方为签订本合同而向甲方提供的本人各项证明文件真实有效，并且没有与其他单位</p>
			<p>建立劳动关系，如果有伪造、欺诈行为，愿意承担由此产生的后果。</p>
			</br>
			<p class="title2">一、劳动合同期限&nbsp;&nbsp;&nbsp;&nbsp;</p>
			<p>第一条　本合同为下列第  <u>&nbsp;1&nbsp;</u>  种类型：</p>
			<p>1、固定期限劳动合同：</p>
			<p>劳动期限从 ________ 起至 ________ 止。其中试用期为  6  个月，自 ________ 起至 ________ 止。</p>
			<p>2、无固定期限劳动合同：</p>
			<p>劳动期限从 ____/____ 开始。其中试用期为 ____/____ 个月，自 ____/____ 起至____/____ 止。</p>
			<p>3、以完成一定的工作（任务）为期限的劳动合同：</p>
			<p>乙方需要完成的工作任务内容为：____/____ 。</p>
			<p>乙方执行工作任务的开始日期为：____/____ 。</p>
			</br>
			</br>
			<p class="title2">二、工作内容和工作地点&nbsp;&nbsp;&nbsp;&nbsp;</p>
			<p>第二条　乙方同意根据甲方工作安排，担任 <u>&nbsp;${positionName}&nbsp;</u> 职位。工作职责参照职位说</p>
			<p>明书。经甲、乙双方协商同意，可以变更工作岗位（工种）。</p>
			<p>第三条　乙方应根据甲方安排的工作内容和要求，按时保质保量完成工作任务。</p>
			<p>第四条  乙方出现能力、表现不能适应本岗位工作、绩效考核不合格等不能胜任工作情形的，甲方可安</p>
			<p>排乙方培训或予以调整工作岗位，乙方岗位调整后劳动报酬根据新岗位相应调整。</p>
			<p>第五条  乙方工作地点为 城市 。乙方的工作内容需要乙方公出从事工作，公出地点包括但不限于以下</p>
			<p>地点：甲方在国内各分支机构所在地；甲方客户和供应商所在地；甲方开展业务、从事活动的其他地区。</p>
			</br>
			</br>
			</br>
		</div>
	<@footer value="3" />
	</div>
	<!-- Page 3 end -->
	<!-- Page 4 start -->
	<div id="page4" class="print-body main-page">
		<div class="main-text">
			</br>
			<p class="title2">三、工作时间和休息休假&nbsp;&nbsp;&nbsp;&nbsp;</p>
			</br>
			<p>第六条　工作时间。</p>
			<p>甲乙双方同意按以下第  1  种方式确定乙方的工作时间：</p>
			<p>1、标准工时工作制的，即每日工作8小时，每周工作5天，每周休息2天。</p>
			<p>2、不定时工作制，即经劳动行政部门审批，乙方所在岗位实行不定时工作制。在保证完成甲方工作任务</p>
			<p>的情况下，工作和休息休假由甲方统一安排。</p>
			<p>3、综合计算工时工作制的，即经劳动行政部门审批，乙方所有岗位实行以 __/__为周期，总工时 __/__</p>
			<p>小时的综合计算工时工作制。</p>
			<p>第七条  甲方因工作需要，可以合理延长乙方工作时间。甲方安排乙方加班的，应按国家有关规定安排</p>
			<p>乙方同等补休、或者支付加班工资。</p>
			<p>第八条  休息休假</p>
			<p>1、乙方依法享有法定的节假日；</p>
			<p>2、乙方按国家法律和甲方规定享有带薪年假，年假的天数和申请参照甲方规章制度的相关内容执行。</p>
			</br>
			<p class="title2" >四、劳动保护、劳动条件和职业危害防护&nbsp;&nbsp;&nbsp;&nbsp;</p>
			<p>第九条　甲方执行国家、上海市有关劳动保护规定，为乙方提供符合国家规定的劳动保护设施等劳动条</p>
			<p>件，切实保障乙方在工作中的安全和健康。</p>
			<p>第十条　甲方按国家、上海市有关规定对乙方进行安全工作知识、法规政策和操作规程培训以及其他的</p>
			<p>业务知识培训；乙方应参加上述培训并严格遵守有关的安全法规、规章。</p>
			<p>第十一条　甲方依法采取安全防范措施，预防职业危害。</p>
			</br>
			<p class="title2">五、劳动报酬&nbsp;&nbsp;&nbsp;&nbsp;</p>
			<p>第十二条　甲方的工资分配体系遵循按劳分配、公平合理的原则。</p>
			<p>第十三条　甲方给予乙方的劳动报酬请见《入职通知书》，定期以银行工资卡的形式向乙方支付。</p>
			<p>第十四条　绩效工资根据职务不同，由甲方决定每年或每月考评后发放。</p>
			<p>第十五条　甲方每月10号将乙方上月工资汇出，银行按其付款流程负责发放至乙方账户。</p>
			<p>第十六条  乙方应依法缴纳个人所得税和国家有关规定劳动者应缴纳的有关款项，乙方同意由甲方从其</p>
			<p>工资中代扣代缴。</p>
		</div>
	<@footer value="4" />
	</div>
	<!-- Page 4 end -->
	<!-- Page 5 start -->
	<div id="page5" class="print-body main-page">
		<div class="main-text">
			</br>
			<p class="title2">六、社会保险和福利待遇&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
			<p>第十七条　社会保险和公积金。</p>
			<p>1、乙方符合国家和参保地有关规定缴纳社会保险及住房公积金条件的，甲、乙双方按照该规定缴纳社会</p>
			<p>保险及住房公积金；其中依法应由乙方缴纳的部分，由甲方从乙方劳动报酬中代扣代缴。</p>
			<p>2、乙方患职业病或因工负伤，治疗期间或医疗终结后的工伤保险待遇按国家和参保地工伤医疗保险规定</p>
			<p>执行。</p>
			<p>第十八条　福利待遇</p>
			<p>甲方可以根据企业的经济效益将积极创造条件，改善福利，为乙方提供一定的福利待遇。</p>
			</br>
			<p class="title2">七、劳动合同的履行、变更、中止、续订、解除、终止&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
			<p>第十九条　订立本合同所依据的法律、法规、行政规章发生变化时，本合同应变更相关内容。</p>
			<p>第二十条　经甲、乙双方协商一致，可以变更本合同相关内容。变更内容以补充协议的形式作出。</p>
			<p>第二十一条　本合同期限内，有下列情形之一，劳动合同中止履行：</p>
			<p>1、乙方应征入伍或者履行国家规定的其他法定义务的；</p>
			<p>2、乙方暂时无法履行劳动合同的义务，但仍有继续改造条件和可能的；</p>
			<p>3、法律、法规规定的其他情形。</p>
			<p>劳动合同中止情形消失的，劳动合同继续履行，但法律、法规另有规定的除外。</p>
			<p>第二十二条　本合同期限届满前，甲乙双方若欲续订合同，需提前以书面形式通知对方，经协议一致可</p>
			<p>以续订劳动合同。如甲方提出续订意向，乙方应在甲方提出续订意向2个工作日内予以书面回复，逾期</p>
			<p>未书面回复的或不接受甲方续签条件或拖延办理续签手续的，视为乙方拒绝续订合同。</p>
			<p>第二十三条　有以下情况之一的，甲乙双方的劳动关系终止：</p>
			<p>1、本合同期满前，若甲乙双方未就续订劳动合同协商一致的，本合同期满时即行终止。</p>
			<p>2、下列情形之一的，劳动合同终止：</p>
			<p>（1）乙方开始依法享受基本养老保险待遇的；</p>
			<p>（2）乙方死亡，或者被人民法院宣告死亡或者宣告失踪的；</p>
			<p>（3）甲方被依法宣告破产的；</p>
			<p>（4）甲方被吊销营业执照、责令关闭、撤销或者甲方决定提前解散的；</p>
			<p>3、法律、行政法规规定的其他情形出现，本合同可以终止。</p>
			<p>第二十四条  经甲、乙方协商一致，本合同可以解除。</p>
			</br>
		</div>
	<@footer value="5" />
	</div>
	<!-- Page 5 end -->
	<!-- Page 6 start -->
	<div id="page6" class="print-body main-page">
		<div class="main-text">
			<p>第二十五条  乙方有下列情形之一的，甲方可以随时解除劳动合同且不需承担任何补偿或赔偿责任：</p>
			<p>1、以欺诈、胁迫的手段或者乘人之危，使甲方在违背真实意思的情况下订阅或者变更劳动合同的，包括</p>
			<p>但不限于：乙方提交虚假入职材料及担保材料、伪造学历、学位、技能等证书的；</p>
			<p>2、乙方在试用期间被证明不符合甲方录用条件的，包括但不限于：乙方不能按期提交办理入职、社会保</p>
			<p>险等所需材料的、不能完成指定工作任务的；</p>
			<p>3、乙方严重违反甲方规章制度的，包括但不限于：当月连续旷工3天（含3天）以上的；</p>
			<p>4、严重失职、营私舞弊，对甲方利益造成重大损害的；</p>
			<p>5、同时与其他用人单位建立劳动关系，对完成甲方工作任务造成严重影响，或者经甲方提出，拒不改正</p>
			<p>的；</p>
			<p>6、被依法追究刑事责任的；</p>
			<p>7、法律、法规规定的其他情形。</p>
			<p>第二十六条　有下列情形之一，甲方可以解除本合同，但应提前30日以书面形式通知乙方或者向乙方额</p>
			<p>外支付一个月的工资（或付给该员工所相差天数的工资以代替不足的通知时间）：</p>
			<p>1、乙方患病或非因工负伤，医疗期满后，不能从事原工作也不能从事甲方另行安排的工作的；</p>
			<p>2、乙方不能胜任工作，经过培训或者调整工作岗位，仍不能胜任工作的；</p>
			<p>3、合同订立时所依据的客观情况发生重大变化，致使本合同无法履行，经双方协商不能就变更本合同达</p>
			<p>成协议的。前项所指客观情况重大变化包括但不限于：由于甲方机构、行政职能调整、上级主管单位政</p>
			<p>策变化和管理方式变化等原因，导致乙方的劳动成为不能或者不必要的情形。</p>
			<p>第二十七条　乙方有下列情形之一，甲方不得依据本合同第二十六条解除本合同：</p>
			<p>1、从事接触职业病危害作业未进行离岗前职业健康检查，或者疑似职业病病人在诊断或者医学观察期间</p>
			<p>的；</p>
			<p>2、患职业病或因工负伤并被确认丧失或者部分丧失劳动能力的； </p>
			<p>3、患病或者非因工负伤，在规定的医疗期内的；</p>
			<p>4、女职工在孕期、产期、哺乳期内的；</p>
			<p>5、在甲方连续工作满15年，且距法定退休年龄不足五年的；</p>
			<p>6、法律、行政法规规定其他情况的。</p>
			<p>第二十八条　有下列情形之一，乙方可以随时解除本合同：</p>
			<p>1、甲方未按照劳动合同约定为乙方提供劳动保护或者劳动条件的；</p>
			<p>2、甲方未及时足额支付乙方劳动报酬的；</p>
			<p>3、甲方未依法为乙方缴纳社会保险费的；</p>
		</div>
	<@footer value="6" />
	</div>
	<!-- Page 6 end -->
	<!-- Page 7 start -->
	<div id="page7" class="print-body main-page">
		<div class="main-text">
			<p>4、甲方的规章制度违反法律、法规的规定，损害乙方权益的；</p>
			<p>5、有下列情形之一，致使劳动合同无效的：</p>
			<p>（1）甲方以欺诈、胁迫的手段或者乘人之危，使乙方在违背真实意思的情况下订立或者变更劳动合同；</p>
			<p>（2）劳动合同免除甲方的法定责任、排除乙方的权利的；</p>
			<p>（3）劳动合同违反法律、行政法规强制性规定；</p>
			<p>6、法律、行政法规规定乙方可以解除劳动合同的其他情形。</p>
			<p>第二十九条　除第二十八条规定外，乙方解除劳动合同，应当提前30日以书面形式通知甲方（试用期内</p>
			<p>提前3日书面通知），该期限从乙方提交书面辞职报告之日起计算。</p>
			<p>在该30天提前通知期内，乙方擅自离开工作岗位不履行工作职责的，甲方有权根据制订的规章制度进行</p>
			<p>处罚。</p>
			<p>第三十条  解除和终止劳动合同的经济补偿，按照《中华人民共和国劳动法》、《中华人民共和国劳动</p>
			<p>合同法》、以及当地相关法规和政策执行。</p>
			<p>第三十一条  解除或终止合同后，甲方应当在规定的期限内办理有关手续。</p>
			</br>
			<p class="title2">八、保守商业秘密&nbsp;&nbsp;&nbsp;&nbsp;</p>
			<p>第三十二条　乙方在受聘期间，应对甲方的商业机密，如知识产权、商务、财务等严格保密。该机密资</p>
			<p>料包括但不限于公司的财务状况、业务报表、业务合同、客户资料、行业数据、员工档案、业务流程、</p>
			<p>待开发项目方案、经营业务会议内容等，否则，视情节轻重，甲方有权给予乙方行政处分直到追究其法</p>
			<p>律责任，造成经济损失的，甲方有权要求乙方赔偿。具体见保密协议。</p>
			</br>
			<p class="title2">九、劳动争议处理&nbsp;&nbsp;&nbsp;&nbsp;</p>
			<p>第三十三条　双方因履行本合同发生的劳动争议，应协商解决，协议不成的，可自争议发生之日起30</p>
			<p>日内向甲方劳动争议调解组织申请调解，或自争议发生之日起在法定期限内向甲方注册地劳动争议仲裁</p>
			<p>委员会申请仲裁。任何一方对仲裁裁决不服，可在收到仲裁裁决书之日起在法定期限内向甲方注册登记</p>
			<p>地的人民法院提起诉讼。</p>
			</br>
			<p class="title2">十、其他&nbsp;&nbsp;&nbsp;&nbsp;</p>
			<p>第三十四条　国家和地方颁布新的法律、法规或者修改现行法律、法规时，如果按照法律、法规规定，</p>
			<p>本合同适用新的法律、法规的，则本合同内容与新的法律、法规抵触之处，按照新的法律、法规执行。</p>
		</div>
	<@footer value="7" />
	</div>
	<!-- Page 7 end -->
	<!-- Page 8 start -->
	<div id="page8" class="print-body main-page">
		<div class="main-text">
			<p>第三十五条  双方承诺本合同登记信息真实有效，如有变化应及时通知，乙方如提供虚假信息的将承担</p>
			<p>由此导致的法律责任。乙方确认本合同登记的现居住地址为通讯地址，任何依该地址寄送（挂号邮寄或</p>
			<p>邮政快递）的文件，凭有关邮寄凭证即视为送达。如乙方通讯地址变更，乙方有义务在变更之日起三个</p>
			<p>工作日内书面通知甲方，否则将承担由此产生的不利后果。甲方在收到乙方变更书面通知前仍可按原地</p>
			<p>址寄送。</p>
			<p>第三十六条　双方特别协议事项：</p>
			<p>1、合同期间或乙方接受过甲方专项出资培训的，因乙方个人原因提前解除合同的，乙方应按甲方的有关</p>
			<p>规定向甲方做出赔偿或补偿。具体见相关的服务期协议。</p>
			<p>2、________________________________________________________________</p>
			<p>第三十七条　甲乙双方另行签订的合同或协议如与本合同抵触的，以本合同为准。</p>
			<p>第三十八条  本合同一式贰份，甲乙双方各执壹份。</p>
			</br>
			</br>
			</br>
			</br>
			</br>
			<p>甲方（盖章）：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;乙方（签名）：</p>
			</br>
			</br>
			</br>
			</br>
			<p>法定代表人（委托代理人）（签名）</p>
			</br>
			<p>__________年_____月____日           __________年_____月____日</p>
		</div>
	<@footer value="8" />
	</div>
	<!-- Page8 end -->
</div>
<!-- laborContract end -->
<!-- secrecyAgreement start -->
<a name="secrecyAgreement"></a>
<div>
		<#macro saheader>
			<div>
				<p style="margin-top:35px"><span class="header-left">达信</span><span class="header-right" align="right">CreditCrestHR-2014-0001</span></p>
				<hr style="margin:0px 2cm 0px 2cm"></hr>
			</div>
		</#macro>
		<#macro safooter value="">
			<p style="font-size:8pt;font-family:微软雅黑;position:absolute;bottom:0;left:365px;">第${value}页&emsp;共4页</p>
		</#macro>
	<!-- Page1 start -->
		<div class="print-body sa-main-page">
			<@saheader/>
			<div class="sa-main-text">
				<p class="sa-title1">保密、不竞争和知识产权归属协议&nbsp;&nbsp;&nbsp;&nbsp;</p>
				</br>
				<div class="sa-main-text-front sa-title2">
					<p>甲&emsp;&emsp;&emsp;方：达信财富投资管理(上海)有限公司</p>
					<p>法定代表人：</p>
					</br>
					<p>乙&emsp;&emsp;方：</p>
					<p style="position">姓&emsp;&emsp;名：<u>${employeeName}</u><span class="sa-title2" style="position:absolute;left:395px;">性&emsp;&emsp;别：<u>${employeeAgenda}</u></span></p>
					<p>通信住址：<u>${homeAddress}</u></p>
					<p>邮政编码：<u>${homeZipCode}</u></p>
					<p>联系电话：<u>${mobilePhone}</u></p>
					<p>身份证（护照）号码：<u>${employeeIdCard}</u></p>
					</br>
				</div>
				<p>&emsp;&emsp;&nbsp;为明确甲乙双方之间的知识产权归属、商业秘密和不竞争事项，双方就下列条款达成一致，共同遵守。</p>
				<p class="sa-title2" style="margin-bottom:5px">1.&emsp;&nbsp;&nbsp;保密信息的内容</p>
					<div class="sa-text">
						<p><span style="margin-right:20px">1.1</span>由甲方或甲方提供条件或以甲方名义开发、创造、发现的、或为甲方所知的、或转移至甲方的、对甲方有商业</p>
						<p><span style="margin-right:37px"></span>价值的所有信息，包括但不限于技术秘密和商业秘密。</p>
					</div>
					<div class="sa-text">
						<p><span style="margin-right:20px">1.2</span>本协议提及的技术秘密，包括但不限于管理文本、评估模型、评估手段、统计表格、技术方案、工程设计、电</p>
						<p><span style="margin-right:37px"></span>路设计、制造方法、配方、工艺流程、技术指标、计算机软件、数据库、开发计划、研究开发记录、技术报告、</p>
						<p><span style="margin-right:37px"></span>检测报告、实验数据、试验结果、图纸、样品、样机、模型、模具、操作手册、技术文档、相关的函电等。</p>
					</div>
					<div class="sa-text">
						<p><span style="margin-right:20px">1.3</span>本协议提及的商业秘密，包括但不限于客户名单、行销计划、采购资料、定价政策、财务资料、进货渠道、法</p>
						<p><span style="margin-right:37px"></span>律事务信息、人力资源信息、其他员工的报酬、与甲方业务有关的客户的信息、甲方从他方受得的有保密义务</p>
						<p style="margin-bottom:7px"><span style="margin-right:37px"></span>的信息等等。</p>
					</div>
				<p class="sa-title2" style="margin-bottom:5px">2.&emsp;&nbsp;&nbsp;保密信息的载体</p>
					<div class="sa-text">
						<p><span style="margin-right:20px">2.1</span>乙方因职务上的需要所持有或保管的一切记录有甲方秘密信息的文件、资料、照片、图表、笔记、报告、信件、</p>
						<p><span style="margin-right:37px"></span>传真、磁带、磁盘、仪器以及其他任何形式的载体均归甲方所有，无论这些秘密信息有无商业上的价值。</p>
					</div>
					<div class="sa-text">
						<p><span style="margin-right:20px">2.2</span>乙方应当于离职（无论何种原因）时，或者于甲方提出请求时，返还属于甲方的全部财物和载有甲方秘密信息</p>
						<p><span style="margin-right:37px"></span>的一切载体，不得将这些载体擅自复制、保留或交给其他任何人。</p>
					</div>
					<div class="sa-text">
						<p><span style="margin-right:20px">2.3</span>若上述记录有甲方秘密信息的载体是乙方自备的，在乙方返还这些载体时，甲方应给予乙方相当于载体本身价</p>
						<p style="margin-bottom:7px"><span style="margin-right:37px"></span>值的经济补偿。</p>
					</div>
				<p class="sa-title2" style="margin-bottom:5px">3.&emsp;&nbsp;&nbsp;保密规章和制度</p>
					<div class="sa-text">
						<p><span style="margin-right:20px">3.1</span>乙方在甲方任职期间，必须遵守甲方的保密规章、制度，履行与其工作岗位相应的保密职责。</p>
					</div>
					<div class="sa-text">
						<p><span style="margin-right:20px">3.2</span>甲方的保密规章、制度没有规定或者规定不明确之处，乙方亦应本着善意、谨慎、负责的态度，采取必要、合</p>
						<p><span style="margin-right:37px"></span>理的措施，保守其于任职期间知悉或者持有的任何属于甲方或者虽属于第三方但甲方承诺有保密义务的技术秘</p>
						<p style="margin-bottom:7px"><span style="margin-right:37px"></span>密和商业秘密。</p>
					</div>
				<p class="sa-title2" style="margin-bottom:5px">4.&emsp;&nbsp;&nbsp;任职期间</p>
					<div class="sa-text">
						<p><span style="margin-right:20px">4.1</span>本协议中所称的任职期间，是指乙方从甲方领取工资到甲方终止向乙方发放工资或乙方不再从甲方领取工资为</p>
					</div>
			</div>
		<@safooter value="1" />
		</div>
	<!-- Page1 end -->
	<!-- Page2 start -->
		<div  class="print-body  sa-main-page">
			<@saheader/>
			<div class="sa-main-text" style="position:relative;top:-5px;">
					<div class="sa-text">
						<p><span style="margin-right:37px"></span>止的期间与劳动合同中规定的合同期限相比，较长的期间。</p>
					</div>
					<div class="sa-text">
						<p><span style="margin-right:20px">4.2</span>本协议中所称的离职，是指任何一方明确表示解除聘用关系并将此种意愿付诸实践的行为，包括但不限于辞职、</p>
						<p style="margin-bottom:7px"><span style="margin-right:37px"></span>止的期间与劳动合同中规定的合同期限相比，较长的期间。</p>
					</div>	
				<p class="sa-title2" style="margin-bottom:5px">5.&emsp;&nbsp;&nbsp;保密责任</p>
					<div class="sa-text">
						<p><span style="margin-right:20px">5.1</span>除履行职务需要外，未经甲方事先书面同意，乙方不得泄露、传播、公布、发表、传授、转让或者以其他任何</p>
						<p><span style="margin-right:37px"></span>方式使任何第三方（包括但不限于按照甲方的保密规定无权知悉该项秘密的甲方其他职员）知悉属于甲方或者</p>
						<p><span style="margin-right:37px"></span>虽属于他人但甲方承诺有保密义务的技术秘密和其他商业秘密，也不得在履行职务之外使用这些保密信息。</p>
					</div>
					<div class="sa-text">
						<p><span style="margin-right:20px">5.2</span>乙方的上级主管书面同意乙方披露、使用以上技术秘密或其他商业秘密的，视为甲方已同意这样做，但前提是</p>
						<p><span style="margin-right:37px"></span>甲方已事先声明该主管人员具有此权限。</p>
					</div>
					<div class="sa-text">
						<p><span style="margin-right:20px">5.3</span>非经甲方书面同意，乙方不得与甲方内、外的任何人（乙方的直接亲属除外）探听、披露或讨论甲方公司内部</p>
						<p><span style="margin-right:37px"></span>薪金、奖金、福利、期权或任何形式的报酬事宜。</p>
					</div>
					<div class="sa-text">
						<p><span style="margin-right:20px">5.4</span>本协议约定保密信息及责任等的效力范围不仅及于甲方本身，也及于甲方的关联机构，包括但不限于各分支机</p>
						<p style="margin-bottom:7px"><span style="margin-right:37px"></span>构、母公司、全资子公司和参股公司。</p>
					</div>
				<p class="sa-title2" style="margin-bottom:5px">6.&emsp;&nbsp;&nbsp;知识产权归属</p>
					<div class="sa-text">
						<p>在到甲方任职期间，乙方单独或与他人共同构思、开发或实践的与甲方当前或潜在业务、产品或研发相关的任何发明</p>
						<p>创造、发明、发现、设计、开发成果、改进、作品、计算机软件、半导体芯片、享有版权的书面资料、技术秘密和商</p>
						<p>业秘密（统称“成果”），乙方应即时、全面地向甲方披露。</p>
					</div>
					<p class="sa-title2" style="margin-bottom:4px;margin-left:30px">6.1&emsp;&nbsp;&nbsp;职务成果</p>
						<div class="sa-text sa-text3">
							<p><span style="margin-right:20px">6.1.1</span>双方确认，乙方在甲方任职期间，因基于职务、履行单位分派的任务或者主要是利用甲方的物质条件、</p>
							<p><span style="margin-right:47px"></span>业务信息等产生的成果，或无论何种原因乙方从甲方离职在离职之日起一年内完成的与其在甲方承担</p>
							<p><span style="margin-right:47px"></span>的本职工作或分配任务有关的成果，其全部知识产权归甲方所有，甲方为其唯一的权利所有人，有权</p>
							<p><span style="margin-right:47px"></span>使用或转让这些成果。在法律许可的最大限度内，乙方有义务提供一切必要的信息资料和采取一切必</p>
							<p><span style="margin-right:47px"></span>要的行动，协助甲方证明、获得、维持、维护、实现或抗辩与这些成果有关的权利，包括但不限于专</p>
							<p><span style="margin-right:47px"></span>利申请、商标注册、版权（软件）登记和/或在法律纠纷中的协助或合作等，协助甲方取得和行使有关</p>
							<p><span style="margin-right:47px"></span>的知识产权。为上述目的，乙方在此不可撤销地指定甲方和/或其授权的高级管理人员作为乙方的全权</p>
							<p><span style="margin-right:47px"></span>代表签署有关的文件和实施一切合法的行为。</p>
						</div>
						<div class="sa-text sa-text3">
							<p><span style="margin-right:20px">6.1.2</span>上述成果的署名权，一般应由甲方享有，如法律规定且乙方书面要求，则由作为发明人、创作人或设</p>
							<p><span style="margin-right:47px;margin-bottom:7px;"></span>计人的乙方享有，并且乙方有权按甲方的有关规定获得相应的奖励。</p>
						</div>
					<p class="sa-title2" style="margin-bottom:4px;margin-left:30px">6.2&emsp;&nbsp;&nbsp;非职务成果</p>
						<div class="sa-text sa-text3">
							<p><span style="margin-right:20px">6.2.1</span>乙方在任职期间完成的成果或者退职、退休或者调动工作后一年内作出的，与其在甲方承担的本职工</p>
							<p><span style="margin-right:47px"></span>作或者分配的任务有关的发明创造，乙方主张其本人享有知识产权的，应当及时向甲方书面申明。经</p>
							<p><span style="margin-right:47px"></span>甲方书面核准，认为确属非职务成果的，由乙方享有知识产权；如乙方转让或许可使用该非职务成果，</p>
							<p><span style="margin-right:47px"></span>甲方享有优先受让权。</p>
						</div>
						<div class="sa-text sa-text3">
							<p><span style="margin-right:20px">6.2.2</span>乙方没有申明的，推定其为职务成果，甲方可以使用或者向第三方转让这些成果。即使日后证明为非</p>
							<p><span style="margin-right:47px;margin-bottom:7px;"></span>职务成果，乙方亦不得要求甲方承担任何责任和/或补偿乙方收益。</p>
						</div>
					<p class="sa-title2" style="margin-bottom:4px;margin-left:30px">6.3&emsp;&nbsp;&nbsp;声明、陈述和保证</p>
						<div class="sa-text sa-text3">
							<p><span style="margin-right:20px">6.3.1</span>乙方在到职时已附上一份备忘录的清单并提供了相关的证明表明在受雇于甲方之前所作的并属于乙方</p>
							<p><span style="margin-right:47px"></span>的全部成果，甲方通过在所附的清单上签章确认这些成果已经从本协议中排除。如没有附上这样的清</p>
							<p><span style="margin-right:47px"></span>单，则表明乙方没有任何成果。</p>
						</div>
			</div>
		<@safooter value="2" />
		</div>
	<!-- Page2 end -->
	<!-- Page3 start -->
		<div  class="print-body  sa-main-page">
			<@saheader/>
			<div class="sa-main-text" style="position:relative;top:-5px;">
						<div class="sa-text sa-text3">
							<p><span style="margin-right:20px">6.3.2</span>乙方声明，在甲方任职期间，绝对不会也没有使用和透露乙方过去的雇主、被代理人、合伙人、合作</p>
							<p><span style="margin-right:47px"></span>人、客户（统称“原雇主”）的任何保密信息、技术、商业秘密、任何成果。乙方也不会将属于原雇</p>
							<p><span style="margin-right:47px"></span>主的未出版的文件和任何财产带入甲方，除非原雇主同意。乙方确认，绝对不会也没有违反其应遵守</p>
							<p><span style="margin-right:47px"></span>的和原雇主的任何协议。</p>
						</div>
						<div class="sa-text sa-text3">
							<p><span style="margin-right:20px">6.3.3</span>乙方保证，在甲方的工作中没有、将来也不会擅自使用侵犯他人知识产权的产品、工具或软件等，否</p>
							<p><span style="margin-right:47px"></span>则将承担相应的责任；但由甲方指示、安排或提供的产品、工具或软件等侵犯他人知识产权与乙方无</p>
							<p><span style="margin-right:47px;margin-bottom:7px;"></span>关。</p>
						</div>
				<p class="sa-title2" style="margin-bottom:5px">7.&emsp;&nbsp;&nbsp;保密期限</p>
					<div class="sa-text">
						<p><span style="margin-right:20px">7.1</span>无论乙方因何种原因从甲方离职应当保守在甲方任职期间接触、知悉的属于甲方或虽属于第三方但甲方承诺有</p>
						<p><span style="margin-right:37px"></span>保密义务的技术秘密和商业秘密，承担同在甲方任职期间一样的保密义务，直到该技术秘密或商业秘密被公开</p>
						<p><span style="margin-right:37px"></span>为止。</p>
					</div>
					<div class="sa-text">
						<p><span style="margin-right:20px;margin-bottom:7px;">7.2</span>乙方确认，在离职前应与甲方签订备忘录，以进一步明确有关的保密责任和范围。</p>
					</div>
				<p class="sa-title2" style="margin-bottom:5px">8.&emsp;&nbsp;&nbsp;竞业限制约定</p>
					<div class="sa-text">
						<p><span style="margin-right:20px">8.1</span>乙方承诺在甲方任职期间，不从事此外的任何第二职业。特别是未经甲方事先书面同意，不得与甲方生产、经</p>
						<p><span style="margin-right:37px"></span>营同类产品或提供同类服务的或与甲方有直接经济往来的其他经济组织和社会团体内担任任何职务、包括但不</p>
						<p><span style="margin-right:37px"></span>限于合伙人、董事、监事、股东、经理、职员、代理人、顾问等，不得利用在甲方的任职以任何不正当手段获</p>
						<p><span style="margin-right:37px"></span>取利益，不得利用在甲方的地位和职权为自己谋取私利。</p>
					</div>
					<div class="sa-text">
						<p><span style="margin-right:20px">8.2</span>无论因何种原因从甲方离职，在乙方离职后的壹年内（甲方可以自主决定放弃或者缩短该期限）（以下统称竞</p>
						<p><span style="margin-right:37px"></span>业限制期间），乙方保证在没有事先取得甲方董事会书面一致同意的情况下，乙方都不会：(i) 担任同甲方及/</p>
						<p><span style="margin-right:37px"></span>或集团业务形成竞争关系或有相似业务的实体的合伙人、雇员、顾问、管理人员、董事、经理、代理人、合作</p>
						<p><span style="margin-right:37px"></span>者、投资者等；(ii) 直接或间接地拥有、购买、设立组织或筹备设立组织而同甲方及/或集团业务形成竞争或相</p>
						<p><span style="margin-right:37px"></span>似业务关系；(iii) 从事建立、设计、融资、收购、租赁、运作、管理、投资、工作、提供咨询、使乙方成为内</p>
						<p><span style="margin-right:37px"></span>部人或其他业务而同甲方业务形成竞争或相似业务关系；上述约定将涵盖规定期间内乙方将从事业务活动的任</p>
						<p><span style="margin-right:37px"></span>一地域范围。“地域”是指(a) 中国大陆；(b) 台湾；(c) 香港；(d) 澳门； (e) 美国；(f) 其他国家和地区。</p>
					</div>
					<div class="sa-text">
						<p><span style="margin-right:20px">8.3</span>为了履行本协议第8.2条的约定，乙方将从甲方获得补偿（简称“补偿金”）。补偿金的金额为其本人离职前</p>
						<p><span style="margin-right:37px"></span>当月月工资额的10% x（乘以）竞业限制期（12个月）(如果甲方放弃对于乙方的竞业禁止的要求或者缩短竞</p>
						<p><span style="margin-right:37px"></span>业禁止的期限，则该等补偿金取消或者按比例减少)。该补偿金在竞业限制期间内按月支付。</p>
					</div>
					<div class="sa-text">
						<p><span style="margin-right:20px">8.4</span>在甲方任职期间和离职后的壹年内，乙方保证不会直接或间接地唆使或试图影响甲方或甲方关联公司的其他员</p>
						<p><span style="margin-right:37px"></span>工离职，去为乙方或任何其他个人或实体服务；乙方保证不会引诱甲方或甲方关联公司的客户或以前的客户以</p>
						<p><span style="margin-right:37px"></span>攫取他们的业务而直接或间接获利。</p>
					</div>
					<div class="sa-text">
						<p><span style="margin-right:20px">8.5</span>前述竞业限制相关条款的履行，应以乙方离职时甲方向乙方送达《竞业限制履行通知书》为准。如乙方离职时</p>
						<p><span style="margin-right:37px"></span>未收到甲方送达的《竞业限制履行通知书》，则自劳动合同解除之日起，本协议中第8条竞业限制约定条款同</p>
						<p><span style="margin-right:37px;margin-bottom:7px;"></span>时随之解除，甲乙双方无需履行相关义务。</p>
					</div>
				<p class="sa-title2" style="margin-bottom:5px">9.&emsp;&nbsp;&nbsp;争议解决</p>
					<div class="sa-text">
						<p><span style="margin-right:20px">9.1</span>因本协议约定事宜而引起的纠纷由双方协商解决；协商不成的，任何一方可提交给当地仲裁委员会。当地仲裁</p>
						<p><span style="margin-right:37px"></span>委员会有权依据其现行有效的仲裁规则下的简易程序在当地进行仲裁。仲裁裁决为终局裁决，对合同双方具有</p>
						<p><span style="margin-right:37px"></span>法律约束力。</p>
					</div>
					<div class="sa-text">
						<p><span style="margin-right:20px;margin-bottom:7px;">9.2</span>上述约定不影响甲方请求知识产权管理部门对侵权行为进行行政处理。</p>
					</div>
				<p class="sa-title2" style="margin-bottom:5px">10.&emsp;损失赔偿</p>
					<div class="sa-text">
						<p><span style="margin-right:13px">10.1</span>乙方确认在从甲方领取的薪酬中已包含了乙方承担除本协议8条外的全部义务的费用和补偿，乙方同意并接受</p>
					</div>
			</div>
		<@safooter value="3" />
		</div>
	<!-- Page3 end -->
	<!-- Page4 start -->
		<div  class="print-body  sa-main-page">
			<@saheader/>
			<div class="sa-main-text" style="position:relative;top:-5px;">
					<div class="sa-text">
						<p><span style="margin-right:37px;margin-bottom:7px;"></span>这样的安排。</p>
					</div>
					<div class="sa-text">
						<p><span style="margin-right:13px">10.2</span>如乙方离职时甲方向乙方送达了《竞业限制履行通知书》，乙方不履行本协议第8.2条、8.4条竞业限制约定</p>
						<p><span style="margin-right:37px"></span>的，应当承担违约责任，一次性向甲方支付违约金，金额为乙方离职前月平均工资的6倍。</p>
					</div>
					<div class="sa-text">
						<p><span style="margin-right:13px;margin-bottom:7px;">10.3</span>乙方的违约行为给甲方造成损失的，乙方应当赔偿甲方的损失。</p>
					</div>
				<p class="sa-title2" style="margin-bottom:5px">11.&emsp;其他事项</p>
					<div class="sa-text">
						<p><span style="margin-right:13px">11.1</span>对本协议任何条款的不履行不应构成对任何条款的放弃。本协议任何条款无效或不可强制执行不应影响本协议</p>
						<p><span style="margin-right:37px"></span>其他条款的有效性和强制执行性。</p>
					</div>
					<div class="sa-text">
						<p><span style="margin-right:13px">11.2</span>本协议的修改必须采用书面形式。本协议构成全部协议，并取代双方先前与本协议主题事项有关的任何和全部</p>
						<p><span style="margin-right:37px"></span>口头或书面谅解、安排和协议，如与双方以前的任何口头或书面协议有抵触，以本协议的规定为准。</p>
					</div>
					<div class="sa-text">
						<p><span style="margin-right:13px">11.3</span>本协议自双方签字之日起生效，如双方签字日不同，以在后的签字日为协议生效日。本协议以中文书写一式两</p>
						<p><span style="margin-right:37px"></span>份，甲乙双方各执一份，具有同等法律效力。</p>
					</div>
					<div class="sa-text">
						<p> 双方确认，在签署本协议前已仔细审阅过协议全文并完全了解本协议各条款的法律含义。</p>
					</div>
				</br>
				</br>
				</br>
				</br>
				</br>
				</br>
				<div class="sa-main-text-front sa-title2">
					<p>甲方（签章）：<span class="sa-title2" style="margin-left:262px">乙方（签字）：</span></p>
					</br>
					<p>日&emsp;&emsp;&emsp;&emsp;期：<span class="sa-title2" style="margin-left:262px">日&emsp;&emsp;&emsp;&emsp;期：</span></p>
				</div>
			</div>
		<@safooter value="4" />	
		</div>
	<!-- Page4 end -->
</div>
<!-- secrecyAgreement end -->
<!-- complianceCommitment start -->
<a name="complianceCommitment"></a> 
	<!-- Page1 start -->
		<div class="print-body last-page">
			<div>
				<p style="margin-top:40px"><span class="cc-header-left">达信</span><span class="cc-header-right">机密文件</span></p>
				<hr style="margin:0px 2.8cm 0px 2.8cm;position:relative;top:-10px;"></hr>
			</div>
			<p class="cc-title">合&emsp;规&emsp;承&emsp;诺&emsp;书</p>
			<div class="cc-main-text">
				<p>&emsp;&emsp;员工姓名：<u>${employeeName}</u><span style="position:absolute;left:515px;">身份证号：<u>${employeeIdCard}</u></span></p>
				<p>&emsp;&emsp;所属公司：<u>达信财富投资管理(上海)有限公司</u><span style="position:absolute;left:515px;">入职日期：<u>${(entryDate?string("yyyy-MM-dd"))!""}</u></span></p>
				<p>&emsp;&emsp;部&emsp;&emsp;门：<u>${orgFullName2}</u></p>
				<div class="cc-main-text3">
					</br>
					<p>&emsp;&emsp;本人愿意积极履行岗位职责，依法合规，坚持诚信、正直的职业操守和价值观念，保障公司</p>
					<p>业务安全稳健运行，并自愿作出以下承诺，在违反本承诺时愿意承担相应的法律责任及公司问责：</p>
					</br>
					<p>&emsp;&emsp;一、&emsp;&emsp;遵守国家法律、法规、规章，行业规范，职业道德。 </p>
					<p>&emsp;&emsp;二、&emsp;&emsp;恪守合规执业原则，严守风险底线，诚实守信，坚决抵制、纠正一些行业不良之风。</p>
					<p>&emsp;&emsp;三、&emsp;&emsp;积极学习并遵守公司所有规章制度，严格履行公司要求及操作规范。</p>
					<p>&emsp;&emsp;四、&emsp;&emsp;坚持廉洁从业，严格遵守职业操守。</p>
					<p>&emsp;&emsp;&emsp;&emsp;（一）廉洁从业，自觉抵制商业贿赂及不正当交易；</p>
					<p>&emsp;&emsp;&emsp;&emsp;（二）公私分明，秉公办事，杜绝利用职务便利谋取私利；</p>
					<p>&emsp;&emsp;&emsp;&emsp;（三）拒绝虚假，正确宣传公司、业务、服务、产品及相关风险；</p>
					<p>&emsp;&emsp;&emsp;&emsp;（四）杜绝造假，严格履行岗位职责、积极履行风险识别义务，杜绝造假、隐瞒不报；</p>
					<p>&emsp;&emsp;&emsp;&emsp;（五）坚决杜绝挪用公司或客户资金行为的发生；</p>
					<p>&emsp;&emsp;&emsp;&emsp;（六）自觉抵制非法集资、高利贷、其他同业组织的高额回报诱惑。</p>
					<p>&emsp;&emsp;五、&emsp;&emsp;在职及离职后合理期限内严格遵守公司各项规章制度及相关保密规定。</p>
					<p>&emsp;&emsp;六、&emsp;&emsp;自觉接受监管部门、员工之间、社会公众的监督。</p>
					<p>&emsp;&emsp;七、&emsp;&emsp;其他：公司制度管理平台网址： </p>
					<p>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;公司内网网址：</p>
					<p>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;内网合规园地网址：</p>
					</br>
					<p>&emsp;&emsp;本承诺书一式两份，经承诺人签字之日起随《劳动合同》一同生效，由承诺人与人力资源与</p>
					<p>行政部各持一份，人力资源与行政部持有的承诺书随承诺人其他入职资料一并归档。</p>
					</br>
					<p>本人已知晓并自愿承诺以上所有内容（确认全部知晓后请誊抄）</p>
					</br>
					<p>_____________________________________________________________________________________________</p>
				</div>
				<p style="margin-left:340px">承诺人：</p>
				<p style="margin-left:340px">日&emsp;期：</p>
			</div>
		</div>
	<!-- Page1 end -->
<!-- complianceCommitment end -->
</body>
<script>
	function printFunction(){
		document.getElementById("printDiv").style.display="none";
		window.print();
		document.getElementById("printDiv").style.display="";
	}
</script>
