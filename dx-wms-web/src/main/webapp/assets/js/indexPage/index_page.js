$(function() {
	initPage();
// $('#LenderProportion').unbind("click");
// $("#LenderProportion").click(function(){
// });
	
});



function showBigLenderProportion() {
	
}

function initPage() {
	$.getJSON(base + '/indexDisplay/initPage.json?type=1', function(data) {

		$("#theFirstValue").html(data.theFirstModel + 1);
		$("#theSecondValue").html(data.theSecondModel + 1);
		$("#theThirdValue").html(data.theThirdModel + 1);
		$("#theForthValue").html(data.theForthModel + 1);
		$("#theFifthValue").html(data.theFifthModel + 1);

		// $.each(data, function(index, item) {
		// folders[index] = item;
		// sunFileNumberArr[index] = item.folderCode+"Num";
		// ctxhtml += "<div class='span3' style='margin:auto;'>";
		// ctxhtml += "<input type='hidden' name='"+item.folderCode+"FolderPath'
		// id='"+item.folderCode+"FolderPath' value='"+item.fileDirId+"' />";
		// ctxhtml += "<div style='width:100%;height:auto;'>";
		// ctxhtml += "<img src='"+resBase+"/image/u37.png'
		// alt='"+item.folderName+"-文件夹'"+ "style='width:40%;length:40%;'
		// ></img><br /><br />";
		// ctxhtml += "</div>";
		// ctxhtml += "<div style='width:100%;height:auto;'>";
		// ctxhtml += "<strong><span>"+item.folderName+"(<span
		// id='"+item.folderCode+"Num"+"'>"+item.sunFileNumber+"</span>)</span></strong><br
		// /><br />";
		// ctxhtml += "</div>";
		// ctxhtml += "<div style='width:100%;height:auto;'>";
		// ctxhtml += "<span class='btn green' id='"+item.folderCode+"OpenBtn'
		// onclick='doOpenFiles(folders["+index+"])'>";
		// ctxhtml += "<span class='icon-folder-open'></span>&nbsp;展开";
		// ctxhtml += "</span>";
		// ctxhtml += "<span class='btn red' style='display:none'
		// id='"+item.folderCode+"CloseBtn'
		// onclick='doCloseFiles(folders["+index+"])'>";
		// ctxhtml += "<span class='icon-folder-close'></span>&nbsp;收起";
		// ctxhtml += "</span>";
		// ctxhtml += "</div>";
		// ctxhtml += "</div>";
		// $("#vFolder").append(ctxhtml);
		// ctxhtml = "";
		// });
	});
}

if ($('#site_activities').size() != 0) {
	// site activities
	var previousPoint2 = null;
	$('#site_activities_loading').hide();
	$('#site_activities_content').show();

	var activities = [ [ 1, 10 ], [ 2, 9 ], [ 3, 8 ], [ 4, 6 ], [ 5, 5 ],
			[ 6, 3 ], [ 7, 9 ], [ 8, 10 ], [ 9, 12 ], [ 10, 14 ], [ 11, 15 ],
			[ 12, 13 ], [ 13, 11 ], [ 14, 10 ], [ 15, 9 ], [ 16, 8 ],
			[ 17, 12 ], [ 18, 14 ], [ 19, 16 ], [ 20, 19 ], [ 21, 20 ]];

	var plot_activities = $.plot($("#site_activities"), [ {
		data : activities,
		color : "rgba(107,207,123, 0.9)",
		shadowSize : 0,
		bars : {
			show : true,
			lineWidth : 0,
			fill : true,
			fillColor : {
				colors : [ {
					opacity : 1
				}, {
					opacity : 1
				} ]
			}
		}
	} ], {
		series : {
			bars : {
				show : true,
				barWidth : 0.9
			}
		},
		grid : {
			show : false,
			hoverable : true,
			clickable : false,
			autoHighlight : true,
			borderWidth : 0
		},
		yaxis : {
			min : 0,
			max : 20
		}
	});

	$("#site_activities")
			.bind(
					"plothover",
					function(event, pos, item) {
						$("#x").text(pos.x.toFixed(2));
						$("#y").text(pos.y.toFixed(2));
						if (item) {
							if (previousPoint2 != item.dataIndex) {
								previousPoint2 = item.dataIndex;
								$("#tooltip").remove();
								var x = item.datapoint[0].toFixed(2),y = item.datapoint[1].toFixed(2);
								showTooltip('24 Feb 2013', item.pageX,item.pageY, x);
							}
						}
					})
			.bind("click",function(event,pos,item){
				$('#openUploads').modal({
					show : true
				});
			});

	$('#site_activities').bind("mouseleave", function() {
		$("#tooltip").remove();
	});
}

function showTooltip(title, x, y, contents) {
	$('<div id="tooltip" class="chart-tooltip"><div class="date">'
					+ title + '<\/div><div class="label label-success">CTR: '
					+ x / 10
					+ '%<\/div><div class="label label-important">Imp: ' + x
					* 12 + '<\/div><\/div>').css({
		position : 'absolute',
		display : 'none',
		top : y - 100,
		width : 75,
		left : x - 40,
		border : '0px solid #ccc',
		padding : '2px 6px',
		'background-color' : '#fff',
	}).appendTo("body").fadeIn(200);
}


var data = [];
var series = Math.floor(Math.random() * 10) + 1;
series = series < 5 ? 5 : series;

for (var i = 0; i < series; i++) {
    data[i] = {
        label: "Series" + (i + 1),
        data: Math.floor(Math.random() * 100) + 1
    }
}

$.plot($("#pie_chart_1"), data, {
    series: {
        pie: {
            show: true
        }
    },
    legend: {
        show: false
    }
});
