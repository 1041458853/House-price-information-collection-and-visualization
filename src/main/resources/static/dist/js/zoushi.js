$(document).ready(function () {
    // 公共页面提取导入
    $(function () {
        $('#main-header').load("common/main-header.html");
        $('#main-sidebar').load("common/main-sidebar.html", function () {
            $('#sidebar_zoushi').addClass('active');
        });
        // footer 引入会导致错版
        $('#main-footer').load("common/main-footer.html");
        // 商圈自动补全
        // getBizcircleName();
    });
    loupan();
    ershoufang();
    zufang();
});


function loupan(){
    $.ajax({
        type: "get", //请求方式
        url: "http://localhost:8080/zhongyuan/historylp", //地址，就是json文件的请求路径
        dataType: "json", //数据类型可以为 text xml json  script  jsonp
        success: function (result) { //返回的参数就是 action里面所有的有get和set方法的参数
            if (result.length == 0) {
                $("#alert").html("<div class=\"alert alert-info text-center fade in\" role=\"alert\" id=\"alert\">该商圈未找到房源<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button></div>")
            } else {
                //转化返回的json的格式
                var data =  new Array();
                var j = 0;
                $.each(result, function (i,item) {
                    data[j] = {value:item,name:i};
                    j++;
                });
                // 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(document.getElementById('mycanvas0'));

                option = {
                    title: {
                        text: '楼盘平均价格走势（元/平）'
                    },
                    tooltip : {
                        trigger: 'axis',
                        axisPointer: {
                            type: 'cross',
                            label: {
                                backgroundColor: '#6a7985'
                            }
                        }
                    },
                    legend: {
                        data:['玄武','秦淮','鼓楼','建邺','雨花台','栖霞','浦口','六合','江宁','溧水','高淳']
                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {}
                        }
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    xAxis : [
                        {
                            type : 'category',
                            boundaryGap : false,
                            data : result.dates
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value',
                            axisLabel: {
                                formatter: '{value} '
                            },
                        }
                    ],
                    series : [
                        {
                            name:'玄武',
                            type:'line',
                            areaStyle: {},
                            data:result.XUANWU
                        },
                        {
                            name:'秦淮',
                            type:'line',
                            areaStyle: {},
                            data:result.QINHUAI
                        },
                        {
                            name:'鼓楼',
                            type:'line',
                            areaStyle: {},
                            data:result.GULOU
                        },
                        {
                            name:'建邺',
                            type:'line',
                            areaStyle: {normal: {}},
                            data:result.JIANYE
                        },
                        {
                            name:'雨花台',
                            type:'line',
                            areaStyle: {normal: {}},
                            data:result.YUHUATAI
                        },
                        {
                            name:'浦口',
                            type:'line',
                            areaStyle: {normal: {}},
                            data:result.PUKOU
                        },
                        {
                            name:'六合',
                            type:'line',
                            areaStyle: {normal: {}},
                            data:result.LIUHE
                        },
                        {
                            name:'江宁',
                            type:'line',
                            areaStyle: {normal: {}},
                            data:result.JIANGNING
                        },
                        {
                            name:'溧水',
                            type:'line',
                            areaStyle: {normal: {}},
                            data:result.LISHUI
                        },
                        {
                            name:'高淳',
                            type:'line',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'top'
                                }
                            },
                            areaStyle: {normal: {}},
                            data:result.GAOCHUN
                        }
                    ]
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

function ershoufang(){
    $.ajax({
        type: "get", //请求方式
        url: "http://localhost:8080/zhongyuan/historyesf", //地址，就是json文件的请求路径
        dataType: "json", //数据类型可以为 text xml json  script  jsonp
        success: function (result) { //返回的参数就是 action里面所有的有get和set方法的参数
            if (result.length == 0) {
                $("#alert").html("<div class=\"alert alert-info text-center fade in\" role=\"alert\" id=\"alert\">该商圈未找到房源<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button></div>")
            } else {
                //转化返回的json的格式
                var data =  new Array();
                var j = 0;
                $.each(result, function (i,item) {
                    data[j] = {value:item,name:i};
                    j++;
                });
                // 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(document.getElementById('mycanvas1'));

                option = {
                    title: {
                        text: '二手房平均价格走势(万)'
                    },
                    tooltip : {
                        trigger: 'axis',
                        axisPointer: {
                            type: 'cross',
                            label: {
                                backgroundColor: '#6a7985'
                            }
                        }
                    },
                    legend: {
                        data:['玄武','秦淮','鼓楼','建邺','雨花台','栖霞','浦口','六合','江宁','溧水','高淳']
                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {}
                        }
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    xAxis : [
                        {
                            type : 'category',
                            boundaryGap : false,
                            data : result.dates
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value',
                            axisLabel: {
                                formatter: '{value} '
                            },
                        }
                    ],
                    series : [
                        {
                            name:'玄武',
                            type:'line',
                            areaStyle: {},
                            data:result.XUANWU
                        },
                        {
                            name:'秦淮',
                            type:'line',
                            areaStyle: {},
                            data:result.QINHUAI
                        },
                        {
                            name:'鼓楼',
                            type:'line',
                            areaStyle: {},
                            data:result.GULOU
                        },
                        {
                            name:'建邺',
                            type:'line',
                            areaStyle: {normal: {}},
                            data:result.JIANYE
                        },
                        {
                            name:'雨花台',
                            type:'line',
                            areaStyle: {normal: {}},
                            data:result.YUHUATAI
                        },
                        {
                            name:'浦口',
                            type:'line',
                            areaStyle: {normal: {}},
                            data:result.PUKOU
                        },
                        {
                            name:'六合',
                            type:'line',
                            areaStyle: {normal: {}},
                            data:result.LIUHE
                        },
                        {
                            name:'江宁',
                            type:'line',
                            areaStyle: {normal: {}},
                            data:result.JIANGNING
                        },
                        {
                            name:'溧水',
                            type:'line',
                            areaStyle: {normal: {}},
                            data:result.LISHUI
                        },
                        {
                            name:'高淳',
                            type:'line',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'top'
                                }
                            },
                            areaStyle: {normal: {}},
                            data:result.GAOCHUN
                        }
                    ]
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

function zufang(){
    $.ajax({
        type: "get", //请求方式
        url: "http://localhost:8080/zhongyuan/historyzf", //地址，就是json文件的请求路径
        dataType: "json", //数据类型可以为 text xml json  script  jsonp
        success: function (result) { //返回的参数就是 action里面所有的有get和set方法的参数
            if (result.length == 0) {
                $("#alert").html("<div class=\"alert alert-info text-center fade in\" role=\"alert\" id=\"alert\">该商圈未找到房源<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button></div>")
            } else {
                //转化返回的json的格式
                var data =  new Array();
                var j = 0;
                $.each(result, function (i,item) {
                    data[j] = {value:item,name:i};
                    j++;
                });
                // 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(document.getElementById('mycanvas2'));

                option = {
                    title: {
                        text: '房租平均价格走势(元/月)'
                    },
                    tooltip : {
                        trigger: 'axis',
                        axisPointer: {
                            type: 'cross',
                            label: {
                                backgroundColor: '#6a7985'
                            }
                        }
                    },
                    legend: {
                        data:['玄武','秦淮','鼓楼','建邺','雨花台','栖霞','浦口','六合','江宁','溧水','高淳']
                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {}
                        }
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    xAxis : [
                        {
                            type : 'category',
                            boundaryGap : false,
                            data : result.dates
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value',
                            axisLabel: {
                                formatter: '{value} '
                            },
                        }
                    ],
                    series : [
                        {
                            name:'玄武',
                            type:'line',
                            areaStyle: {},
                            data:result.XUANWU
                        },
                        {
                            name:'秦淮',
                            type:'line',
                            areaStyle: {},
                            data:result.QINHUAI
                        },
                        {
                            name:'鼓楼',
                            type:'line',
                            areaStyle: {},
                            data:result.GULOU
                        },
                        {
                            name:'建邺',
                            type:'line',
                            areaStyle: {normal: {}},
                            data:result.JIANYE
                        },
                        {
                            name:'雨花台',
                            type:'line',
                            areaStyle: {normal: {}},
                            data:result.YUHUATAI
                        },
                        {
                            name:'浦口',
                            type:'line',
                            areaStyle: {normal: {}},
                            data:result.PUKOU
                        },
                        {
                            name:'六合',
                            type:'line',
                            areaStyle: {normal: {}},
                            data:result.LIUHE
                        },
                        {
                            name:'江宁',
                            type:'line',
                            areaStyle: {normal: {}},
                            data:result.JIANGNING
                        },
                        {
                            name:'溧水',
                            type:'line',
                            areaStyle: {normal: {}},
                            data:result.LISHUI
                        },
                        {
                            name:'高淳',
                            type:'line',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'top'
                                }
                            },
                            areaStyle: {normal: {}},
                            data:result.GAOCHUN
                        }
                    ]
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


