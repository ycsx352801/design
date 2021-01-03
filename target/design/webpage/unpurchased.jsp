<%@ page import="java.util.List" %>
<%@ page import="com.bean.Flower" %>
<%@ page import="com.bean.Unpurchased" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--查看鲜花信息--%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Unpurchased</title>
    <link rel="stylesheet" type="text/css" href="webpage/unpurchasedcss.css"/>
</head>
<body>
<%
    List<Unpurchased> list=(List<Unpurchased>)request.getAttribute("list");
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
                <li>
                    <a href="/design/HomepageServlet?email=<%=email%>" onclick="form.submit();">首页</a>
                </li>
                <li>
                    <a href="">个人主页</a>
                </li>
            </div>
        </div>
    </div>
    <!--正文区域-->
    <div class="content">
        <div class="title">
            <li><a href="/design/FlowerServlet?email=<%=email%>">查看鲜花信息</a></li>
            <li class="li"><a href="">查看未购买订单</a></li>
            <li><a href="/design/PurchasedServlet?email=<%=email%>">查看已购买订单</a></li>
            <li ><a href="/design/PersonalServlet?email=<%=email%>">个人信息</a></li>
        </div>
        <div class="information">
            <table class="table" border="1px" cellspacing="0px">
                <tr align="center">
                    <td width="110px">编号</td>
                    <td width="110px">用户名</td>
                    <td width="110px">邮箱</td>
                    <td width="110px">手机号</td>
                    <td width="110px">鲜花名称</td>
                    <td width="110px">购买数量</td>
                    <td width="110px">单价</td>
                    <td width="110px">总价</td>
                    <td width="110px"></td>
                    <td width="110px"></td>
                </tr>
                <%
                    for(Unpurchased unpurchased:list){
                %>
                <tr align="center">
                    <td width="110px"><%=unpurchased.getUnpurchased_id()%></td>
                    <td width="110px"><%=unpurchased.getUnpurchased_name()%></td>
                    <td width="110px"><%=unpurchased.getUnpurchased_email()%></td>
                    <td width="110px"><%=unpurchased.getUnpurchased_phone()%></td>
                    <td width="110px"><%=unpurchased.getUnpurchased_fname()%></td>
                    <td width="110px"><%=unpurchased.getUnpurchased_number()%></td>
                    <td width="110px"><%=unpurchased.getUnpurchased_price()%></td>
                    <td width="110px"><%=unpurchased.getUnpurchased_toprice()%></td>
                    <td width="110px"><a class="a" href="/design/UnpurchasedUpdateServlet?email=<%=email%>&fname=<%=unpurchased.getUnpurchased_fname()%>">购买</a></td>
                    <td width="110px"><a class="a" href="/design/UnpurchasedDeleteServlet?email=<%=email%>&fname=<%=unpurchased.getUnpurchased_fname()%>">删除</a></td>
                </tr>
                <%}%>
            </table>
        </div>
    </div>
</from>
</body>
</html>

