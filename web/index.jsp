<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>疫情地图展示</title>
    <style>
        #myEcharts {
            width: 800px;
            height: 500px;
            border: solid 1px red;
            margin: 0 auto;
        }
    </style>
    <!-- 引入 echarts.js -->
    <script src="dist_echarts.js"></script>
    <script src="jquery.min.js"></script>
    <!--引入中国的地图数据js文件，引入后会自动注册地图名字和数据-->
    <script src="test_data_map_js_china.js"></script>

</head>

<body>
<!--为echarts准备一个dom容器-->
<div id="myEcharts"></div>

<div id="datetime">
    <script>
        setInterval("document.getElementById('datetime').innerHTML=new Date().toLocaleString();", 1000);
    </script>
</div>
<script>
    //初始化echarts实例
    var myChart = echarts.init(document.getElementById('myEcharts'));
    // 指定图表的配置项和数据
    option = {
        title: {
            text: '中国疫情图',
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['中国疫情图']
        },
        visualMap: {
            type: 'piecewise',
            pieces: [
                { min: 1000, max: 1000000, label: '大于等于1000人', color: '#372a28' },
                { min: 500, max: 999, label: '确诊500-999人', color: '#4e160f' },
                { min: 100, max: 499, label: '确诊100-499人', color: '#974236' },
                { min: 10, max: 99, label: '确诊10-99人', color: '#ee7263' },
                { min: 1, max: 9, label: '确诊1-9人', color: '#f5bba7' },
            ],
            color: ['#E0022B', '#E09107', '#A3E00B']
        },
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                mark: { show: true },
                dataView: { show: true, readOnly: false },
                restore: { show: true },
                saveAsImage: { show: true }
            }
        },
        roamController: {
            show: true,
            left: 'right',
            mapTypeControl: {
                'china': true
            }
        },
        series: [
            {
                name: '确诊数',
                type: 'map',
                mapType: 'china',
                roam: false,
                label: {
                    show: true,
                    color: 'rgb(249, 249, 249)'
                },
                data: [{value:0,name:'无'}]
            }
        ]
    };
    //6.ajax发起数据请求
    $.ajax({
        type : "post",
        async : true, //异步请求（同步请求将会锁住浏览器，其他操作须等请求完成才可执行）
        url : "${pageContext.request.contextPath}/BarServlet", //请求发送到TestServlet
        data : {},
        dataType : "json", //返回数据形式为json

        //7.请求成功后接收数据name+num两组数据
        success : function(result) {
            var servicedata=[];
            //result为服务器返回的json对象
            if (result) {
                //8.取出数据存入数组
                for (var i = 0; i < result.length; i++) {
                    var time =result.time
                    var obj=new Object();
                    obj.name=result[i].province
                    obj.value=result[i].total
                    servicedata[i]=obj;//迭代取出类别数据并填入类别数组
                }
                myChart.hideLoading(); //隐藏加载动画

                //9.覆盖操作-根据数据加载数据图表
                myChart.setOption({
                    series : [ {
                        // 根据名字对应到相应的数据
                        data : servicedata
                    } ]
                });
            }

        },
        error : function(errorMsg) {
            //请求失败时执行该函数
            alert("图表请求数据失败!");
            myChart.hideLoading();
        }
    })

    //使用指定的配置项和数据显示图表
    myChart.setOption(option);
</script>
</body>

</html>