function gettreevalue() {
    $.ajax({
        url: base + '/hr/treevalue.json',
        // 请求url
        type: "POST",
        async: false,
        dataType: "json",
        contentType: "application/json",
        timeout: 30000,
        success: function(data) {
            if (data) {
                var treelength = data.length;
                var datatrees = new Array();
                for(var u=0;u<data.length;u++){
                	var datatree = {};
                	datatree.orgName=data[u].orgName;
                	datatree.orgId=data[u].orgId;
                	datatree.parentId=data[u].parentId;
                	datatree.hasParentId=false;
					datatree.hasSonId=false;
					datatrees.push(datatree);
                }
                
                for(var t=0;t<datatrees.length;t++){
        			for(var i=0;i<datatrees.length;i++){
        				if(datatrees[t].orgId==datatrees[i].parentId){
        					datatrees[i].hasParentId=true;
        					datatrees[t].hasSonId=true;
        				}
        				
        			}
        		}
                for (var i = 0; i < datatrees.length; i++) {
                    if (!datatrees[i].hasParentId && datatrees[i].hasSonId) {
                        $("#tree_1").append("<li class='tree" + datatrees[i].orgId + "'><a href='#' class='tree-toggle' data-toggle='branch' " + "data-value='Bootstrap_Tree'  value='" + datatrees[i].orgId + "' onclick='getOrg(" + datatrees[i].orgId + ")'>" + datatrees[i].orgName + "</a><ul class='branch in' id='tree" + datatrees[i].orgId + "'></ul></li>");
                        datatrees.splice(i, 1);
                        treelength--;
                    } else if (!datatrees[i].hasParentId && !datatrees[i].hasSonId) {
                        $("#tree_1").append("<li><a href='#' data-role='leaf' value='" + datatrees[i].orgId + "'>" + datatrees[i].orgName + "</a></li>");
                        datatrees.splice(i, 1);
                        treelength--;
                    }
                }
                while (treelength >= 1) {
                    for (var o = 0; o < datatrees.length; o++) {
                        if ($('#tree' + datatrees[o].parentId)) {
                            if (datatrees[o].hasSonId) {
                                $('#tree' + datatrees[o].parentId).append("<li><a href='#' class='tree-toggle' data-toggle='branch' " + "data-value='Bootstrap_Tree'  value='" + datatrees[o].orgId + "' onclick='getOrg(" + datatrees[o].orgId + ")'>" + datatrees[o].orgName + "</a><ul class='branch in' id='tree" + datatrees[o].orgId + "'></ul></li>");
                            } else {
                                $('#tree' + datatrees[o].parentId).append("<li><a href='#' data-role='leaf' value='" + datatrees[o].orgId + "' onclick='getOrg(" + datatrees[o].orgId + ")'>" + datatrees[o].orgName + "</a></li>");
                            }
                            treelength--;
                        }
                    }
                }

            }
        },
    });
}
function getOrg(dataId) {
    $("#orgId").val(dataId);
    query();
}

$(function(){
	gettreevalue();
	$('.tree-toggle', $('#tree_1 > li > ul')).removeClass("closed");
    $('.branch', $('#tree_1 > li > ul')).addClass("in");
//    $("#employeetree").css("height",$("#employeelist").height());
});