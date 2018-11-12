$(document).ready(function () {
    // 公共页面提取导入
    $(function () {
        $('#main-header').load("common/main-header.html");
        $('#main-sidebar').load("common/main-sidebar.html", function () {
            $('#sidebar_fenxi').addClass('active');
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
        url: "http://localhost:8080/zhongyuan/zhongyuanloupans/numofloupans", //地址，就是json文件的请求路径
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
                    backgroundColor: '#2c343c',

                    title: {
                        text: '房源数量饼状图(楼盘)',
                        left: 'center',
                        top: 20,
                        textStyle: {
                            color: '#ccc'
                        }
                    },

                    tooltip : {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },

                    visualMap: {
                        show: false,
                        min: 80,
                        max: 600,
                        inRange: {
                            colorLightness: [0, 1]
                        }
                    },
                    series : [
                        {
                            name:'楼盘数量',
                            type:'pie',
                            radius : '60%',
                            center: ['50%', '50%'],
                            data:data.sort(function (a, b) { return a.value - b.value; }),
                            roseType: 'radius',
                            label: {
                                normal: {
                                    textStyle: {
                                        color: 'rgba(255, 255, 255, 0.3)'
                                    }
                                }
                            },
                            labelLine: {
                                normal: {
                                    lineStyle: {
                                        color: 'rgba(255, 255, 255, 0.3)'
                                    },
                                    smooth: 0.2,
                                    length: 10,
                                    length2: 20
                                }
                            },
                            itemStyle: {
                                normal: {
                                    color: '#c23531',
                                    shadowBlur: 200,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            },

                            animationType: 'scale',
                            animationEasing: 'elasticOut',
                            animationDelay: function (idx) {
                                return Math.random() * 200;
                            }
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
        url: "http://localhost:8080/zhongyuan/zhongyuanloupans/numofershoufangs", //地址，就是json文件的请求路径
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
                    backgroundColor: '#2c343c',

                    title: {
                        text: '房源数量饼状图(二手房)',
                        left: 'center',
                        top: 20,
                        textStyle: {
                            color: '#ccc'
                        }
                    },

                    tooltip : {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },

                    visualMap: {
                        show: false,
                        min: 80,
                        max: 600,
                        inRange: {
                            colorLightness: [0, 1]
                        }
                    },
                    series : [
                        {
                            name:'楼盘数量',
                            type:'pie',
                            radius : '60%',
                            center: ['50%', '50%'],
                            data:data.sort(function (a, b) { return a.value - b.value; }),
                            roseType: 'radius',
                            label: {
                                normal: {
                                    textStyle: {
                                        color: 'rgba(255, 255, 255, 0.3)'
                                    }
                                }
                            },
                            labelLine: {
                                normal: {
                                    lineStyle: {
                                        color: 'rgba(255, 255, 255, 0.3)'
                                    },
                                    smooth: 0.2,
                                    length: 10,
                                    length2: 20
                                }
                            },
                            itemStyle: {
                                normal: {
                                    color: '#c23531',
                                    shadowBlur: 200,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            },

                            animationType: 'scale',
                            animationEasing: 'elasticOut',
                            animationDelay: function (idx) {
                                return Math.random() * 200;
                            }
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
        url: "http://localhost:8080/zhongyuan/zhongyuanloupans/numofzufangs", //地址，就是json文件的请求路径
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
                    backgroundColor: '#2c343c',

                    title: {
                        text: '房源数量饼状图(租房)',
                        left: 'center',
                        top: 20,
                        textStyle: {
                            color: '#ccc'
                        }
                    },

                    tooltip : {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },

                    visualMap: {
                        show: false,
                        min: 80,
                        max: 600,
                        inRange: {
                            colorLightness: [0, 1]
                        }
                    },
                    series : [
                        {
                            name:'楼盘数量',
                            type:'pie',
                            radius : '60%',
                            center: ['50%', '50%'],
                            data:data.sort(function (a, b) { return a.value - b.value; }),
                            roseType: 'radius',
                            label: {
                                normal: {
                                    textStyle: {
                                        color: 'rgba(255, 255, 255, 0.3)'
                                    }
                                }
                            },
                            labelLine: {
                                normal: {
                                    lineStyle: {
                                        color: 'rgba(255, 255, 255, 0.3)'
                                    },
                                    smooth: 0.2,
                                    length: 10,
                                    length2: 20
                                }
                            },
                            itemStyle: {
                                normal: {
                                    color: '#c23531',
                                    shadowBlur: 200,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            },

                            animationType: 'scale',
                            animationEasing: 'elasticOut',
                            animationDelay: function (idx) {
                                return Math.random() * 200;
                            }
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
