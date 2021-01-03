<%@ page import="com.bean.Flower" %><%--
  Created by IntelliJ IDEA.
  User: 27655
  Date: 2021/1/2
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Case</title>
    <link rel="stylesheet" type="text/css" href="webpage/choicecss.css"/>
    <script>
        function validate(){
            var number=document.getElementById("number").value;
            var num=document.getElementById("num").value;
            if(number==''){
                alert("请添加购买数量");
                return  false;
            }else if(number>num){
                alert("购买数量大于库存");
                return  false;
            } else{
                alert("已加入购物车");
                return  true;
            }
        }
    </script>
</head>
<body>
<%
    Flower flower=(Flower)request.getAttribute("flower");
    String email=(String)request.getAttribute("email");
    String picture=(String)request.getAttribute("picture");
%>
<input id="num" type="text" value='<%=flower.getFlower_number()%>' hidden/>
<!--顶部区域-->
<div class="head">
    <!--头部图片-->
    <div class="head-img">
        <img src="webpage/picture/头部图片.jpg" width="1500px" height="300px"/>
    </div>
</div>
<!--正文区域-->
<form action="/design/ChoiceSaveServlet" method="get" onsubmit="return validate()">
    <input type="text" name="fname" value='<%=flower.getFlower_name()%>' hidden/>
    <input type="text" name="email" value='<%=email%>' hidden/>
    <input type="text" name="picture" value='<%=picture%>' hidden/>
    <div class="content">
        <!--图片区域-->
        <div class="rotation">
            <a class="show" href=""><img src="<%=picture%>" width="600px" height="500px" /></a>
        </div>
        <!--文字区域-->
        <div class="text">
            <!--花名-->
            <div class="title">
                <li><%=flower.getFlower_name()%></li>
            </div>
            <!--售价-->
            <div class="price">
                <li class="price-pr">售价</li>
                <li class="money">￥<%=flower.getFlower_price()%></li>
            </div>
            <!--花朵信息-->
            <div class="information">
                <li>种类：<%=flower.getFlower_type()%></li>
                <li>数量：<%=flower.getFlower_number()%></li>
            </div>
            <div class="explain">
                <li>购买数量：<input id="number" type="text" name="number" value="1"></li>
                <li>配送说明：不配送</li>
            </div>
            <div class="shopping">
                <button class="bu" type="submit">加入购物车</button>
            </div>
        </div>
    </div>
</form>
<!--尾部区域-->
<hr class="hr" width="1500px">
<div class="bottom">
    <div class="picture">
        <img src="webpage/picture/图标.png" width="130px" height="150px"/>
    </div>
    <div class="div1">
        <li><font size="24" face="黑体">热门导航</font></li>
        <a><li>网站首页</li></a>
        <a><li>订单查询</li></a>
    </div>
    <div class="div2">
        <li><font size="24" face="黑体">客户服务</font></li>
        <a><li>关于我们</li></a>
        <a><li>售后服务</li></a>
        <a><li>配送说明</li></a>
        <a><li>服务声明</li></a>
    </div>
</div>
</body>
</html>

