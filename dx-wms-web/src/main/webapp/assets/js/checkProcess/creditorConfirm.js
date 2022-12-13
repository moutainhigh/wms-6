var TableManaged;
$().ready(function () {
    $('#custName').attr('maxlength', 20);
    $('#idCard').attr('maxlength', 18);
    TableManaged = $('#resultList').dataTable({
        'bDestroy': true, // 销毁
        'bFilter': false, // 不显示搜索框
        'bSort': true, // 排序功能
        'sScrollX': '100%',
        'sScrollXInner': '150%',
        'sAjaxSource': 'creditor.json', // 请求url
        'sServerMethod': 'POST',
        'bServerSide': true, // 异步请求
        'fnServerParams': function (aoData) {
            aoData.push({
                'name': 'custName',
                'value': $('#custNameQuery').val()
            }, {
                'name': 'signDateBegin',
                'value': $('#signDateBegin').val()
            }, {
                'name': 'signDateEnd',
                'value': $('#signDateEnd').val()
            }, {
                'name': 'lenderCode',
                'value': $('#lenderCodeQuery').val()
            }, {
                'name': 'lenderAmountArea',
                'value': $('#lenderAmountQuery').val()
            }, {
                'name': 'bizBillDay',
                'value': $('#bizBillDayQuery').val()
            }, {
                'name': 'currentStep',
                'value': $('#currentStepQuery').val()
            }, {
                'name': 'productId',
                'value': $('#loanWayQuery').val()
            });
        },
        'aoColumns': [
            {
                'mData': 'lenderCode',
                'bSortable': false,
                'sWidth': '10%',
                'sClass': 'txt-center',
                'mRender': function (data, type, full) {
                    if (full.formStatusView == '等待债权确认') {
                        return '<input  type="checkbox"  value="'
                        + data
                        + '"/>';
                    }
                    return '';
                }
            },
            {
                'mData': 'lenderCode',
                'bSortable': false,
                'sWidth': '70px',
                'sClass': 'txt-center'
            },
            {
                'mData': 'custName',
                'bSortable': false,
                'sWidth': '100px',
                'sClass': 'txt-center custName'
            },
            {
                'mData': 'idCard',
                'bSortable': false,
                'sWidth': '100px',
                'sClass': 'txt-center'
            },
            {
                'mData': 'product',
                'bSortable': false,
                'sWidth': '50px',
                'sClass': 'txt-center'
            },
            {
                'mData': 'lenderAmountView',
                'bSortable': false,
                'sWidth': '75px',
                'sClass': 'txt-center'
            },
            {
                'mData': 'signDateView',
                'bSortable': false,
                'sWidth': '50px',
                'sClass': 'txt-center'
            },
            {
                'mData': 'statementDate',
                'bSortable': false,
                'sWidth': '50px',
                'sClass': 'txt-center'
            },
            {
                'mData': 'matchDateView',
                'bSortable': false,
                'sWidth': '50px',
                'sClass': 'txt-center'
            },
            {
                'mData': 'payWay',
                'bSortable': false,
                'sWidth': '50px',
                'sClass': 'txt-center'
            },
            {
                'mData': 'formStatusView',
                'bSortable': false,
                'sWidth': '70px',
                'sClass': 'txt-center'
            },
            {
                'mData': 'lenderApplyId',
                'bSortable': false,
                'sWidth': '120px',
                'sClass': 'txt-center',
                'mRender': function (data, type, full) {
                    if (full.formStatusView == '等待债权确认') {
                        return '<button type=\'button\' class=\'btn mini blue\' onclick=\'confirmProcess("'
                        + full.lenderApplyId
                        + '","'
                        + full.payWay
                        + '")\'  >确认</button>'
                        + ' <button type=\'button\' class=\'btn mini red\' onclick=\'reMatchView("'
                        + full.lenderApplyId
                        + '","'
                        + full.lenderCode
                        + '")\'  >重新匹配</button>'
                        + '  <button type=\'button\' class=\'btn mini red review\' data=\''
                        + full.lenderCode
                        + '\'  >预览</button>';
                    } else if (full.formStatusView == '支付失败') {
                        return '<button type=\'button\' class=\'btn mini blue\' onclick=\'confirmProcess("'
                        + full.lenderApplyId
                        + '","'
                        + full.payWay
                        + '")\' >确认</button>'
                        + '&nbsp;<button type=\'button\' class=\'btn mini red\' onclick=\'failReason("'
                        + full.lenderApplyId
                        + '","'
                        + full.payWay
                        + '","'
                        + full.sourPayWay
                        + '","'
                        + full.approveComment
                        + '")\' >失败原因</button>';
                    }
                }
            }
        ],
        "aLengthMenu": [
               	     [ 20, 40, 60, 80, 100, -1],
               	     [ 20, 40, 60, 80, 100, "全部"] // change per page values here
               	  ],
        // set the initial value
        'iDisplayLength': 20,
        'sPaginationType': 'bootstrap',
        'oLanguage': {
            'sLengthMenu': '每页显示 _MENU_ 条记录',
            'sZeroRecords': '抱歉， 没有找到',
            'sInfo': '从 _START_ 到 _END_ /共 _TOTAL_ 条数据',
            'sInfoEmpty': '显示 0 至 0 共 0 项',
            'oPaginate': {
                'sPrevious': '上一页',
                'sNext': '下一页'
            }
        },
        'aoColumnDefs': [
            {
                'bSortable': false,
                'aTargets': [
                    0
                ]
            }
        ],
        // 回调函数
        'fnDrawCallback': function (oSettings) {
            $('#query').removeAttr('disabled');
            var fsv = $('#resultList_length select[name=\'resultList_length\']').val();
            if (fsv == '-1' || fsv == - 1) {
                $('#resultList_wrapper li').addClass('disabled');
            }
            $("#all").attr('checked', false);
			$("#all").parent().removeClass("checked");
        }
    });
    $('.review').live('click', function () {
        $('#reportModal').html('');
        $.ajax({
            url: base + '/reportManagement/init.json?biz=first&lenderCode='+ $(this).attr('data'), // 请求url
            type: 'POST',
            async: false,
            dataType: 'html',
            contentType: 'application/json',
            timeout: 10000,
            success: function (data) {
                $('#reportModal').html(data);
                $('#reportModal').modal({
                    show: true
                });
            }
        });
    });
});
$(function () {
    $('#query').click(function () {
        TableManaged.fnDraw();
    });
    // $("#reset").click(function() {
    // $("#custNameQuery").val("");
    // $("#signDateBegin").val("");
    // $("#signDateEnd").val("");
    // $("#loanWayQuery").val("-1");
    // $("#lenderCodeQuery").val("");
    // $("#lenderAmountQuery").val("-1");
    // $("#currentStepQuery").val("-1");
    // $("#bizBillDayQuery").val("-1");
    // });
});
function checkQuality(custAccountId, lenderApplyId, lenderCode) {
    var url = 'businessQuality.json?type=2&custAccountId=' + custAccountId
    + '&lenderApplyId=' + lenderApplyId + '&lenderCode=' + lenderCode;
    $.get(url, function (data) {
        $('#createCustApplyDiv').html(data);
    });
    $('#createCustApplyDiv').modal({
        show: true
    });
}
function AccountDetail(custAccountId) {
    // var url =base +
    // "/detail/detail.json?type=1&custAccountId="+custAccountId;
    // $.get(url, function(data) {
    // $('#createCustAccountDiv').html(data);
    // });
    // $('#createCustAccountDiv').modal({
    // show : true
    // });
    window.open(base + '/detail/detail.htm?type=1&custAccountId='
    + custAccountId);
}
function confirmProcess(lenderApplyId, payWay) {
    if (payWay == '汇款' || payWay == '直接划扣') {
        showUploadPaymentVouchersWindow(lenderApplyId);
    }
    var lenderPushDataVo = {
    };
    lenderPushDataVo.payWay = payWay;
    lenderPushDataVo.lenderApplyId = lenderApplyId;
    if (payWay == '委托划扣' || payWay == '续投') {
        $.dopConfirm('确认' + payWay + '吗？', null, function (r) {
            if (r) {
                $.ajax({
                    url: base + '/operate/confirm_push.json', // 请求url
                    type: 'POST',
                    async: true,
                    dataType: 'json',
                    contentType: 'application/json',
                    data: JSON.stringify(lenderPushDataVo),
                    timeout: 30000,
                    success: function (data) {
                        if (data.code) {
                            $.dopAlert('操作成功');
                            TableManaged.fnDraw();
                        } else {
                            $.dopAlert(data.msg);
                            TableManaged.fnDraw();
                        }
                    },
                    error: function (data) {
                        $.dopAlert('委托划扣异常');
                    }
                });
            }
        });
    }
}
function showUploadPaymentVouchersWindow(lenderApplyId) {
    var url = base
    + '/operate/voucher.json?lenderApplyId='
    + lenderApplyId
    + '&appCode=wms&resKey=wmsPaymentVouchers&cmAction=getFoldersStatus';
    $.get(url, function (data) {
        $('#createCustApplyDiv').html(data);
    });
    $('#createCustApplyDiv').modal({
        show: true
    });
}/**
 * 重新匹配
 * 
 * @param lenderApplyId
 */

function reMatchView(lenderApplyId, lenderCode) {
    var url = base + '/operate/reMatchView.json?lenderApplyId=' + lenderApplyId
    + '&lenderCode=' + lenderCode;
    $.get(url, function (data) {
        $('#returnMatchDiv').html(data);
    });
    $('#returnMatchDiv').modal({
        show: true
    });
}/**
 * 预览
 */

function browser(lenderCode) {
    var url = base + '/operate/browser.json?lenderCode=' + lenderCode;
    $.get(url, function (data) {
        $('#browserDiv').html(data);
    });
    $('#browserDiv').modal({
        show: true
    });
}
function giveUp(lenderApplyId) {
    var lenderPushDataVo = {
    };
    lenderPushDataVo.lenderApplyId = lenderApplyId;
    $.dopConfirm('确认取消出资吗？', null, function (r) {
        if (r) {
            $.ajax({
                url: 'giveUp.json', // 请求url
                type: 'POST',
                async: true,
                dataType: 'json',
                contentType: 'application/json',
                data: JSON.stringify(lenderPushDataVo),
                timeout: 30000,
                success: function (data) {
                    if (data.code) {
                        $.dopAlert('取消出资成功');
                        TableManaged.fnDraw();
                    } else {
                        $.dopAlert(data.msg);
                        TableManaged.fnDraw();
                    }
                },
                error: function (data) {
                    $.dopAlert('取消出资异常');
                }
            });
        }
    });
}
function reMatch(lenderApplyId) {
    var lenderPushDataVo = {
    };
    lenderPushDataVo.lenderApplyId = lenderApplyId;
    $.dopConfirm('确认重新匹配吗？', null, function (r) {
        if (r) {
            $.ajax({
                url: 'reMatch.json', // 请求url
                type: 'POST',
                async: true,
                dataType: 'json',
                contentType: 'application/json',
                data: JSON.stringify(lenderPushDataVo),
                timeout: 30000,
                success: function (data) {
                    if (data.code) {
                        $.dopAlert('拒绝匹配');
                        TableManaged.fnDraw();
                    }
                },
                error: function (data) {
                    $.dopAlert('重新匹配异常');
                }
            });
        }
    });
}/**
 * 显示失败信息div层
 * 
 * @param lenderApplyId
 * @param payWay
 * @param sourPayWay
 * @param approveComment
 */

function failReason(lenderApplyId, payWay, sourPayWay, approveComment) {
    if (sourPayWay == '委托划扣') {
        /*
		 * $("#reasonTitle").css({ "height":"450px", "overflow-y":"auto" });
		 */
        dealDetail(lenderApplyId);
        // 显示交易明细按钮
        $('#dealDetail').show();
    } else {
        $('#reasonTitle').css({
            'height': 'auto'            /* "overflow-y":"hide" */
        });
        // 隐藏交易明细按钮
        $('#dealDetail').hide();
    }
    if (approveComment != '' && approveComment != 'null') {
        $('#showFailReason').html(approveComment);
    }
    $('#failReasonDiv').modal({
        show: true
    });
    // 给遮罩层添加关闭div层事件
    $('.modal-backdrop').attr('onclick', 'closed()');
}
var count;
/**
 * 获得交易明细
 */
function dealDetail(lenderApplyId) {
    var url = base + '/operate/dealDetail.json?lenderApplyId=' + lenderApplyId;
    $.ajax({
        type: 'post',
        url: url,
        dataType: 'json',
        async: false,
        success: function (datas) {
            count = datas.length;
            $('#dealDetailList').html('');
            var tabHTML = '';
            if (datas && datas.length > 0) {
                for (var i = 0; i < datas.length; i++) {
                    var tempData = datas[i];
                    tabHTML += '<tr>';
                    tabHTML += '<td>' + tempData.tradeCommitTime + '</td>';
                    tabHTML += '<td>' + tempData.tradeAmount + '</td>';
                    tabHTML += '<td>' + tempData.tradeResult + '</td>';
                    tabHTML += '<td>' + tempData.remark + '</td>';
                    tabHTML += '</tr>';
                }
                $('#dealDetailList').html(tabHTML);
            } else {
                tabHTML = '<tr><td colspan=4>抱歉，暂时没有交易明细</td></tr>';
                // $("#reasonTitle").css({"height":"auto"});
            }
            $('#dealDetailList').html(tabHTML);
        }
    });
}/**
 * 来回切换交易明细的显示与隐藏
 */

$('#dealDetail').click(function () {
    var failReasonHeight = parseFloat($('#showFailReason').height());
    $('#dealDetailDiv').toggleClass('hide');
    var hideClass = $('#dealDetailDiv').attr('class');
    if (hideClass != '') {
        $('#dealDetail').val('展开交易明细');
        $('#reasonTitle').css({
            'height': 'auto'
        });
    } else {
        $('#dealDetail').val('隐藏交易明细');
        if (count > 3 || failReasonHeight > 100) {
            $('#reasonTitle').css({
                'height': '450px'
            });
        } else {
            $('#reasonTitle').css({
                'height': 'auto'
            });
        }
    }
});
/**
 * 关闭弹出层和重置信息
 */
function closed() {
    // 关闭出资失败div层
    $('#failReasonDiv').modal('hide');
    // 隐藏交易明细列表
    $('#dealDetailDiv').attr('class', 'hide');
    // 重置失败理由
    $('#showFailReason').html('未说明出资失败理由');
    // 使滚动条显示在最顶端
    $('#reasonTitle').css({
        'height': 'auto'
    }).scrollTop(0);
    $('#dealDetail').val('展开交易明细');
    // 隐藏交易明细按钮
    $('#dealDetail').hide();
}
$('#signDateBegin').change(function () {
    if (null != this.value && $.trim(this.value) != '') {
        var dateArr = this.value.split('-');
        var year = dateArr[0];
        var month = dateArr[1];
        var day = dateArr[2];
        var selDate = new Date();
        selDate.setFullYear(year, month - 1, day);
        if (selDate <= new Date()) {
        } else {
            $('#signDateBegin').val('');
        }
    }
});
$('#signDateEnd').change(function () {
    if (null != this.value && $.trim(this.value) != '') {
        var dateArr = this.value.split('-');
        var year = dateArr[0];
        var month = dateArr[1];
        var day = dateArr[2];
        var selDate = new Date($('#signDateEnd').val());
        selDate.setFullYear(year, month - 1, day);
        if (selDate >= new Date($('#signDateBegin').val())) {
        } else {
            $('#signDateEnd').val('');
        }
    }
});
/**
 * 全选/取消全选
 */
$('#all').click(function () {
    var $checkbox = $(':checkbox');
    $checkbox.attr('checked', this.checked)
});

$('resultList:checkbox').live('click',function(){
	isShow($(this).is(':checked'),this);
});

function isShow(isShow,e){
	isShow?$(e).closest("tr").addClass("success"):$(e).closest("tr").removeClass("success");
}
/**
 * 【反向】全选/取消全选
 */
//$('input:checkbox', '#resultList').live('click', function () {
//    var trCount = $('#resultList > tbody').find('tr').length;
//    var checkedCount = $('input:checked', '#resultList > tbody').length;
//    if (trCount != checkedCount) {
//        $('#all').attr('checked', false).parent().attr('class', '');
//    } else {
//        $('#all').attr('checked', true).parent().attr('class', 'checked');
//    }
//});
/**
 * 下载新增匹配首期协议
 */
$('#export').live('click', function () {
    var processResultVo = {
    };
    var processResult = [
    ];
    $('input:checked', '#resultList > tbody').each(function () {
        dealProtocolFileName($(this).parent().siblings('td'), processResult, $(this).val());
    });
    if (processResult.length == 0) {
        $.dopAlert('请勾选数据');
        return;
    }
    if (processResult.length > 20) {
        $.dopAlert('请选择少于20条数据');
        return;
    }
    $.dopAlert("正在生成首期协议PDF，请不要刷新页面，耐心等候");
    processResultVo.processResult = processResult;
    $.ajax({
        type: 'POST',
        async: true,
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(processResultVo),
        url: base + '/reportManagement/pdf.json',
        success: function (data) {
            if (data.msg == 'ok') {
            	$("#okDopAlertButton").click();
                window.location.href = base
                + '/reportManagement/download.json?path='
                + data.path;
            } else {
                $.dopAlert(data.cause);
            }
        },
        error: function (data) {
            $.dopAlert(data.cause);
        }
    });
});
/**
 * 关闭导出协议时的提示框
 */
function waitforexport() {
    $('#waitexper').modal('hide');
}/**
 * 处理导出协议文件的名称
 * 
 * @param tds:每一行中checkbox的兄弟td
 * @param processResult
 * @param lenderCode
 */

function dealProtocolFileName(tds, processResult, lenderCode) {
    var processResultVo = {
    };
    // 协议文件的前缀
    var suffix = '首期债权转让及受让协议 ';
    // 获取匹配日期
    var matchDate = $(tds[7]).text().replace('-', '').replace('-', '');
    var name =  $(tds[1]).text()+' ';
    // 拼接获取协议文件名称
    var protocolFileName = suffix + matchDate+" "+name+lenderCode;
    processResultVo.lenderCode = lenderCode;
    processResultVo.protocolFileName = protocolFileName;
    processResult.push(processResultVo);
}
