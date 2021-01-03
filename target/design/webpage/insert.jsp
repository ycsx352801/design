<%@ page import="java.util.List" %>
<%@ page import="com.bean.Flower" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--查看鲜花信息--%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert</title>
    <link rel="stylesheet" type="text/css" href="webpage/insertcss.css"/>
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
            <li><a href="/design/UpdateServlet?email=<%=email%>">修改鲜花信息</a></li>
            <li class="li"><a href="">添加鲜花信息</a></li>
            <li><a href="/design/DeleteServlet?email=<%=email%>">删除鲜花信息</a></li>
            <li><a href="/design/OrderServlet?email=<%=email%>">查看订单</a></li>
            <li ><a href="/design/ClerkPersonalServlet?email=<%=email%>">个人信息</a></li>
        </div>
        <div class="information">
            <div class="insert">
                <label>名称:</label>
                <input type="text" id="name"/>
                <label>种类:</label>
                <input type="text" id="type"/>
                <label>数量:</label>
                <input type="text" id="number"/>
                <label>单价:</label>
                <input type="text" id="price"/>
                <script type="text/javascript">
                    function per() {
                        var name=document.getElementById("name").value;
                        var type=document.getElementById("type").value;
                        var number=document.getElementById("number").value;
                        var price=document.getElementById("price").value;
                        location.href="/design/FInsertServlet?email=<%=email%>&name="+name+"&type="+type+"&number="+number+"&price="+price;
                    }
                </script>
                <button type="submit"><a href="javascript:per()">添加</a></button>
            </div>
            <div class="ti">
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
    </div>
</from>
</body>
</html>

