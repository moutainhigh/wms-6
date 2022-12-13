
$(function() {
	
//	initColumnChart();
	
	$("#custNum").click(function(){
		window.location.href = base + "/custView/list.htm";
	});
	
	$("#refusedApplyNum").click(function(){
		window.location.href = base + "/process/add.htm";
	});
	
	$("#custAccountNum").click(function(){
		window.location.href = base + "/custAccountApply/list.htm";
	});
	
});

var activities_A = new Array();//[INDEX,productId]
var activities_B = new Array();//[INDEX,productName]
var activities_C = new Array();//[INDEX,amount]

/**
 * 获取series中的出借方式编号，名称，出借投资金额
 * @param index	序号
 * @param type	1-出借方式编号  2-名称 3-出借投资金额
 * @returns
 */
function getLenderProportionInfo(index,type) {
	if(parseInt(type) == 1) {
		return getInfoFromArray(activities_A,index);
	} else if(parseInt(type) == 2) {
		return getInfoFromArray(activities_B,index);
	} else if(parseInt(type) == 3) {
		return getInfoFromArray(activities_C,index);
	}
	return "";
}

/**
 * 从指定的二位数组中取出信息
 * @param arr
 * @param index
 * @returns
 */
function getInfoFromArray(arr,index) {
	if(null == arr || arr.length == 0) {
		return "";
	}
	for(var i=0;i<arr.length;i++) {
		if(arr[i][0] == index) {
			return arr[i][1];
		}
	}
	return "";
}

/**
 * 设置series内容
 * @param x		series 横坐标
 * @param y		series 纵坐标
 * @param contents	序号
 */
function showTooltip(x, y, contents) {
    $('<div id="tooltip" class="chart-tooltip"><div class="date">' + getLenderProportionInfo(contents,2) + '<\/div><div class="label label-success">(￥)' + getLenderProportionInfo(contents,3) + '<\/div><\/div>').css({
        position: 'absolute',
        display: 'none',
        top: y - 100,
        width: 75,
        left: x - 40,
        border: '0px solid #ccc',
        padding: '2px 6px',
        'background-color': '#fff',
    }).appendTo("body").fadeIn(200);
}

var x = -1;
var y = -1;


/**
 * 出借投资比例柱状图初始化
 */
function initColumnChart() {
	if ($('#site_activities').size() != 0) {
		var previousPoint2 = -1;
		$('#site_activities_loading').hide();
		$('#site_activities_content').show();
		var maxv = 20;
		
		if(lenderRes.indexOf(";") != -1) {
			var lenderResArr = lenderRes.split(";");
			for (var i = 0; i < lenderResArr.length; i++) {
				
				activities_A[i] = new Array();
				activities_A[i][0] = parseInt(i)+1;
				activities_A[i][1] = lenderResArr[i].split(",")[0];
				
				activities_B[i] = new Array();
				activities_B[i][0] = parseInt(i)+1;
				activities_B[i][1] = lenderResArr[i].split(",")[1];
				
				activities_C[i] = new Array();
				activities_C[i][0] = parseInt(i)+1;
				activities_C[i][1] = lenderResArr[i].split(",")[2];
			}
			
			
		} else {
			return ;
		}
		if(activities_C && activities_C.length > 0) {
			for(var j=0;j<activities_C.length;j++) {
				if(maxv < parseInt(activities_C[j][1])) {
					maxv = parseFloat(activities_C[j][1]) * 1.3;
				}
			}
		}
		if(maxv < 20) {
			maxv = 20;
		}
		var plot_activities = $.plot(
				$("#site_activities"), [{
					data: activities_C,
					color: "rgba(256,256,256, 0.9)",
					shadowSize: 0,
					bars: {
						show: true,
						lineWidth: 0,
						fill: true,
						fillColor: {
							colors: [{
								opacity: 1
							}, {
								opacity: 1
							}
							]
						}
					}
				}
				], {
					series: {
						bars: {
							show: true,
							barWidth: 0.9
						}
					},
					grid: {
						show: false,
						hoverable: true,
						clickable: false,
						autoHighlight: true,
						borderWidth: 0
					},
					yaxis: {
						min: 0,
						max: parseInt(maxv)
					}
				});
		
		$("#site_activities").bind("plothover", function (event, pos, item) {
			$("#x").text(pos.x.toFixed(2));// 横坐标
			$("#y").text(pos.y.toFixed(2));// 纵坐标
			if (item) {
				var idx = item.datapoint[0];
                if (previousPoint2 != item.dataIndex) {
                    previousPoint2 = item.dataIndex;
                    $("#tooltip").remove();
                    var x = item.datapoint[0].toFixed(2),
                        y = item.datapoint[1].toFixed(2);
                    showTooltip(item.pageX, item.pageY, idx);
                }
			}
		})
//		.bind("click",function(event, pos, item){
//			$('#openUploads').modal({
//				show : true
//			});
//		})
		;
		
		$('#site_activities').bind("mouseleave", function () {
			$("#tooltip").remove();
		});
		
	}
}








