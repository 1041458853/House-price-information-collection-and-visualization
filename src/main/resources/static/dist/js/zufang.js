$(document).ready(function () {
    // 公共页面提取导入
    $(function () {
        $('#main-header').load("common/main-header.html");
        $('#main-sidebar').load("common/main-sidebar.html", function () {
            $('#sidebar_zufang').addClass('active');
        });
        // footer 引入会导致错版
        $('#main-footer').load("common/main-footer.html");
        // 商圈自动补全
        // getBizcircleName();
    });

});

// 解决dataTable
// 搜索发起
function searchCommunityViaBizcircle() {
    // 解决搜索时一个页面中两个dataTable对象
    var input = $('#bizcircle').val();
    window.location.href = "bizcircle.html?bizcircle=" + input;
}

// 初始化表格对象
function initTable() {
    return $("#records_table").dataTable({
        'paging': true,
        'lengthChange': true,
        'searching': true,
        'ordering': true,
        'info': true,
        'autoWidth': true,
        'language': {
            "lengthMenu": "每页 _MENU_ 条记录",
            "zeroRecords": "没有找到记录",
            "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
            "infoEmpty": "无记录",
            "infoFiltered": "(从 _MAX_ 条记录过滤)",
            "search": "搜索：",
            "paginate": {
                "next": "下一页",
                "previous": "上一页"
            }
        },
    }).api();
}






//===========================================================================================================================================================================================================

//进入页面加载
$(function(){
    getZhongYuanLouPans();
});


//获取所有楼盘的信息
function getZhongYuanLouPans() {
    $.ajax({
        type: "get", //请求方式
        url: "http://localhost:8080/zhongyuan/zhongyuanzufangs/", //地址，就是json文件的请求路径
        dataType: "json", //数据类型可以为 text xml json  script  jsonp
        success: function (result) { //返回的参数就是 action里面所有的有get和set方法的参数
            if (result.length == 0) {
                $("#alert").html("<div class=\"alert alert-info text-center fade in\" role=\"alert\" id=\"alert\">该商圈未找到房源<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button></div>")
            } else {
                eCharts();
                addCommunityTable(result);
            }
        },

        error: function (data,type, err) {
            $("#alert").html("<div class=\"alert alert-info text-center fade in\" role=\"alert\" id=\"alert\">服务器开小差啦<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button></div>")
            console.log("ajax错误类型："+type);
            console.log(err);
            console.log(data);
        }
    });
}

// 将楼盘渲染到表格
function addCommunityTable(result) {
    if (result.length == 0) {
        $('#records_title').text("搜索结果为空");
    } else {
        $('#records_title').text("搜索结果：共" + result.length + "个楼盘");
        addData(result);
    }

    // 添加数据到表格中
    function addData(result) {
        $.each(result, function (i, item) {
            //if ($.fn.dataTable.isDataTable('#records_table'))id {
            //    table.destroy(true);
            //}
            $('<tr>').html(
                "<td>"+ result[i].id +"</td><td>"+
                result[i].name +"</td><td>" +
                result[i].jiage + "</td><td>" +
                result[i].mianji + "</td><td>" +
                result[i].huxing + "</td><td>" +
                result[i].chuzuleixing + "</td><td>" +
                result[i].riqi + "</td><td>" +
                result[i].louti + "</td><td>" +
                result[i].wuye + "</td><td>" +
                result[i].zhuangxiu + "</td><td>" +
                result[i].chengshi + "</td>").appendTo('#records_table tbody');
        });

        // 表格分页系统
        // =============================
        // ===  未解决 发起搜索！！！===
        // =============================
        // 1. 通过dataTable API销毁
        // 2. 通过url重新渲染页面
        // dataTable 对象
        var table = initTable();
        // table.fnDraw();
    }
}

function eCharts(){

    $.ajax({
        type: "get", //请求方式
        url: "http://localhost:8080/zhongyuan/zhongyuanloupans/zufangaverageprice", //地址，就是json文件的请求路径
        dataType: "json", //数据类型可以为 text xml json  script  jsonp
        success: function (result) { //返回的参数就是 action里面所有的有get和set方法的参数
            if (result.length == 0) {
                $("#alert").html("<div class=\"alert alert-info text-center fade in\" role=\"alert\" id=\"alert\">该商圈未找到房源<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button></div>")
            } else {
                // 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(document.getElementById('mycanvas'));

                option = {
                    title: {
                        text: '南京各区楼盘平均房价'
                    },
                    xAxis: {
                        type: 'category',
                        data: Object.keys(result),
                        axisLabel :{
                            interval:0,
                        }
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: Object.values(result),
                        type: 'bar'
                    }],

                };

                myChart.setOption(option);
            }
        },

        error: function (data,type, err) {
            $("#alert").html("<div class=\"alert alert-info text-center fade in\" role=\"alert\" id=\"alert\">服务器开小差啦<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button></div>")
            console.log("ajax错误类型："+type);
            console.log(err);
            console.log(data);
        }
    });
}
