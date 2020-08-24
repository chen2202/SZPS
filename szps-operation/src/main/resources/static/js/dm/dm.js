
/*用户管理-新增-选择部门树*/
function selectAreaTree() {
    var treeId = $("#treeIdArea").val();
    var deptId = $.common.isEmpty(treeId) ? "3" : $("#treeIdArea").val();
    var url = ctx + "system/area/selectAreaTree/" + deptId;
    var options = {
        title: '选择区域',
        width: "380",
        url: url,
        callBack: doSubmitArea
    };
    $.modal.openOptions(options);
}

function doSubmitArea(index, layero){
    var tree = layero.find("iframe")[0].contentWindow.$._tree;
    var body = layer.getChildFrame('body', index);
    $("#treeIdArea").val(body.find('#treeIdArea').val());
    $("#treeNameArea").val(body.find('#treeNameArea').val());
    layer.close(index);
}

/* 水质净化厂 */
function selectBrfTree() {
    var treeId = $("#treeIdBrf").val();
    var brfId = $.common.isEmpty(treeId) ? "100" : $("#treeIdBrf").val();
    var url = ctx + "system/brf/selectTree/" + brfId;
    var options = {
        title: '选择',
        width: "380",
        url: url,
        callBack: doSubmitBrf
    };
    $.modal.openOptions(options);
}

function doSubmitBrf(index, layero){
    var tree = layero.find("iframe")[0].contentWindow.$._tree;
    var body = layer.getChildFrame('body', index);
    $("#treeIdBrf").val(body.find('#treeIdBrf').val());
    $("#treeNameBrf").val(body.find('#treeNameBrf').val());
    layer.close(index);
}