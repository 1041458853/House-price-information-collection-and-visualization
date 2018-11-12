$(document).ready(function () {
    // 公共页面提取导入
    $(function () {
        $('#main-header').load("common/main-header.html");
        $('#main-sidebar').load("common/main-sidebar.html", function () {
            $('#sidebar_ershoufang').addClass('active');
        });
        // footer 引入会导致错版
        $('#main-footer').load("common/main-footer.html");
        // 商圈自动补全
        // getBizcircleName();
    });

    eCharts();

});

// 解决dataTable
// 搜索发起
function searchCommunityViaBizcircle() {
    // 解决搜索时一个页面中两个dataTable对象
    var input = $('#bizcircle').val();
    window.location.href = "bizcircle.html?bizcircle=" + input;
}

// 初始化表格对象
$(document).ready(function() {
    $("#records_table").DataTable({
        language: {
                "processing":   "处理中...",
                "lengthMenu":   "_MENU_ 记录/页",
                "zeroRecords":  "没有匹配的记录",
                "info":         "第 _START_ 至 _END_ 项记录，共 _TOTAL_ 项",
                "infoEmpty":    "第 0 至 0 项记录，共 0 项",
                "infoFiltered": "(由 _MAX_ 项记录过滤)",
                "infoPostFix":  "",
                "search":       "搜索:",
                "url":          "",
                "decimal": ",",
                "thousands": ".",
                "emptyTable":"未找到符合条件的数据",
                "paginate": {
                    "first":    "首页",
                    "previous": "上页",
                    "next":     "下页",
                    "last":     "末页"
                }
            },
            retrieve: true,
            paging: true,
            ordering: false,
            info: true,
            autoWidth: false,
            pageLength: 10,//每页显示10条数据
            pagingType: "full_numbers", //分页样式：simple,simple_numbers,full,full_numbers，
            bFilter: false, //去掉搜索框方法
            bLengthChange: true,//也就是页面上确认是否可以进行选择一页展示多少条
            serverSide: true, //启用服务器端分页，要进行后端分页必须的环节
            ajax: function (data, fnCallback, settings) {
                var table = $('#records_table').DataTable();
                var info = table.page.info();
                //封装相应的请求参数，这里获取页大小和当前页码
                var pagesize = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候,页大小
                var start = info.page+1;//开始的记录的页号
                var draw = data.draw;
                var param = {
                    page: start,
                    pagesize: pagesize,//这里只传了当前页和页大小，如果有其他参数，可继续封装
                    draw : draw
                };
                $.ajax({
                    type: "post",
                    url: "/zhongyuan/zhongyuanershoufangs/",
                    cache : false,  //禁用缓存
                    data: param,   //传入已封装的参数
                    dataType: "json",//返回数据格式为json
                    success: function(result) {
                        console.log("============数据==========")
                        var returnData = {};
                        returnData.draw = data.draw;//这里直接自行返回了draw计数器,应该由后台返回，没什么卵用！
                        returnData.recordsTotal = result.recordsTotal;//totalCount指的是总记录数
                        returnData.recordsFiltered = result.recordsFiltered;//后台不实现过滤功能,全部的记录数都需输出到前端，记录数为总数
                        returnData.data = result.data;//返回汽车列表
                        console.log("======returnData.data=======")
                        console.log( returnData.draw)
                        console.log(returnData.recordsTotal)
                        console.log(returnData.recordsFiltered)
                        fnCallback(returnData);//这个别忘了！！！
                    },
                    error: function(XMLHttpRequest, textStatus, errorThrown) {
                        // $wrapper.spinModal(false);
                    }
                });
            },
            columns: [
                {"data": "id", "width": "50px", "defaultContent": "<i></i>"},
                {"data": "name", "width": "120px", "defaultContent": "<i></i>"},
                {"data": "jiage", "width": "120px", "defaultContent": "<i></i>"},
                {"data": "mianji", "width": "120px", "defaultContent": "<i></i>"},
                {"data": "huxing", "width": "120px", "defaultContent": "<i></i>"},
                {"data": "zhuangxiu", "width": "120px", "defaultContent": "<i></i>"},
                {"data": "louceng", "width": "120px", "defaultContent": "<i></i>"},
                {"data": "riqi", "width": "120px", "defaultContent": "<i></i>"},
                {"data": "leixing", "width": "120px", "defaultContent": "<i></i>"},
                {"data": "lvhualv", "width": "120px", "defaultContent": "<i></i>"},
                {"data": "guanlifei", "width": "120px", "defaultContent": "<i></i>"},
                {"data": "wuye", "width": "120px", "defaultContent": "<i></i>"},
                {"data": "kaifashang", "width": "120px", "defaultContent": "<i></i>"},
                {"data": "louti", "width": "120px", "defaultContent": "<i></i>"},
                {"data": "chengshi", "width": "120px", "defaultContent": "<i></i>"},
            ]
        })
})






//===========================================================================================================================================================================================================

// 将楼盘渲染到表格
function addCommunityTable(result) {
    if (result.length == 0) {
        $('#records_title').text("搜索结果为空");
    } else {
        $('#records_title').text("搜索结果：共" + result.length + "个楼盘");
        // addData(result);
    }

    // 添加数据到表格中
    // function addData(result) {
    //     $.each(result, function (i, item) {
    //         //if ($.fn.dataTable.isDataTable('#records_table'))id {
    //         //    table.destroy(true);
    //         //}
    //         $('<tr>').html(
    //             "<td>"+ result[i].id +"</td><td>"+
    //             result[i].name +"</td><td>" +
    //             result[i].jiage + "</td><td>" +
    //             result[i].mianji + "</td><td>" +
    //             result[i].huxing + "</td><td>" +
    //             result[i].zhuangxiu + "</td><td>" +
    //             result[i].louceng + "</td><td>" +
    //             result[i].riqi + "</td><td>" +
    //             result[i].leixing + "</td><td>" +
    //             result[i].lvhualv + "</td><td>" +
    //             result[i].guanlifei + "</td><td>" +
    //             result[i].wuye + "</td><td>" +
    //             result[i].kaifashang + "</td><td>" +
    //             result[i].louti + "</td>").appendTo('#records_table tbody');
    //     });
    //
    //     // 表格分页系统
    //     // 1. 通过dataTable API销毁
    //     // 2. 通过url重新渲染页面
    //     // dataTable 对象
    //     // var table = initTable();
    //     // table.fnDraw();
    // }
}

function eCharts(){

    $.ajax({
        type: "get", //请求方式
        url: "http://localhost:8080/zhongyuan/zhongyuanloupans/ershoufangaverageprice", //地址，就是json文件的请求路径
        dataType: "json", //数据类型可以为 text xml json  script  jsonp
        success: function (result) { //返回的参数就是 action里面所有的有get和set方法的参数
            if (result.length == 0) {
                $("#alert").html("<div class=\"alert alert-info text-center fade in\" role=\"alert\" id=\"alert\">该商圈未找到房源<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button></div>")
            } else {
                // 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(document.getElementById('mycanvas'));

                option = {
                    title: {
                        text: '南京各区二手房的平均房价'
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
