<%@ page import="java.util.List" %>
<%@ page import="com.bean.Flower" %>
<%@ page import="com.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--查看鲜花信息--%>
<html>
<head>
    <meta charset="UTF-8">
    <title>FlowerInformation</title>
    <link rel="stylesheet" type="text/css" href="webpage/flowercss.css"/>
</head>
<body>
<%
    List<Flower> list=(List<Flower>)request.getAttribute("list");
    String email=(String)request.getAttribute("email");
%>
<from name="form" action="" method="get">
    <!--顶部区域-->
    <div class="head">
        <div class="head-thefirst">
            <!--头部图片-->
            <div class="head-img">
                <img src="webpage/picture/头部图片.jpg" width="1500px" height="300px"/>
            </div>
        </div>
        <!--菜单栏-->
        <div class="head-down">
            <div class="head-menu">
                <%
                    String[] str=email.split("@");
                    if(!str[1].equals("itoffer.cn")){
                %>
                <li>
                    <a href="/design/HomepageServlet?email=<%=email%>" onclick="form.submit();">首页</a>
                </li>
                <%}%>
                <li>
                    <a href="">个人主页</a>
                </li>
            </div>
        </div>
    </div>
    <!--正文区域-->
    <div class="content">
        <div class="title">
            <li class="li"><a href="">查看鲜花信息</a></li>
            <%
                if(str[1].equals("itoffer.cn")){
            %>
            <li><a href="/design/UpdateServlet?email=<%=email%>">修改鲜花信息</a></li>
            <li><a href="/design/InsertServlet?email=<%=email%>">添加鲜花信息</a></li>
            <li><a href="/design/DeleteServlet?email=<%=email%>">删除鲜花信息</a></li>
            <li><a href="/design/OrderServlet?email=<%=email%>">查看订单</a></li>
            <%}else{%>
            <li><a href="/design/UnpurchasedServlet?email=<%=email%>">查看未购买订单</a></li>
            <li><a href="/design/PurchasedServlet?email=<%=email%>">查看已购买订单</a></li>
            <%}
                if(str[1].equals("itoffer.cn")){
            %>
            <li ><a href="/design/ClerkPersonalServlet?email=<%=email%>">个人信息</a></li>
            <%}else{%>
            <li ><a href="/design/PersonalServlet?email=<%=email%>">个人信息</a></li>
            <%}%>
        </div>
        <div class="information">
            <table class="table" border="1px" cellspacing="0px">
                <tr align="center">
                    <td width="200px">编号</td>
                    <td width="200px">名称</td>
                    <td width="200px">种类</td>
                    <td width="200px">数量</td>
                    <td width="200px">单价</td>
                </tr>
                <%
                    for(Flower flower:list){
                %>
                <tr align="center">
                    <td width="200px"><%=flower.getFlower_id()%></td>
                    <td width="200px"><%=flower.getFlower_name()%></td>
                    <td width="200px"><%=flower.getFlower_type()%></td>
                    <td width="200px"><%=flower.getFlower_number()%></td>
                    <td width="200px"><%=flower.getFlower_price()%></td>
                </tr>
                <%}%>
            </table>
        </div>
    </div>
</from>
</body>
</html>

