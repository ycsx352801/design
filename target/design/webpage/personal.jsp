<%@ page import="com.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--普通用户个人中心--%>
<html>
<head>
    <meta charset="UTF-8">
    <title>personal</title>
    <link rel="stylesheet" type="text/css" href="webpage/personalcss.css"/>
    <script>
        function validate(){
            var bu=document.getElementById("bu").value;
            if (bu!=''){
                alert("保存成功！");
            }
        }
    </script>
</head>
<body>
<%
    User user=(User)request.getAttribute("user");
    String email=user.getUser_email();
    String date=(String)request.getAttribute("date");
%>
<from name="form" action="" method="get" onsubmit="return validate()">
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
        <li><a href="/design/UnpurchasedServlet?email=<%=email%>">查看未购买订单</a></li>
        <li><a href="/design/PurchasedServlet?email=<%=email%>">查看已购买订单</a></li>
        <li class="li"><a href="">个人信息</a></li>
    </div>
    <div class="information">
        <div class="text">
            <table class="table" align="left" cellspacing="0">
                <tr>
                    <td width="200px" height="50px">用户名：</td>
                    <td width="500px" height="50px"><input type="text" id="name" value='<%=user.getUser_name()%>'></td>
                </tr>
                <tr>
                    <td width="200px" height="50px">邮箱：</td>
                    <td width="500px" height="50px"><%=user.getUser_email()%></td>
                </tr>
                <tr>
                    <td width="200px" height="50px">密码：</td>
                    <td width="500px" height="50px"><input type="password" id="password" value='<%=user.getUser_pwd()%>'></td>
                </tr>
                <tr>
                    <td width="200px" height="50px">联系电话：</td>
                    <td width="500px" height="50px"><input type="text" id="phone" value='<%=user.getUser_phone()%>'></td>
                </tr>
                <tr>
                    <td width="200px" height="50px">已购买订单：</td>
                    <td width="500px" height="50px"><%=user.getUser_purchased()%></td>
                </tr>
                <tr>
                    <td width="200px" height="50px">未购买订单：</td>
                    <td width="500px" height="50px"><%=user.getUser_unpurchased()%></td>
                </tr>
                <tr>
                    <td width="200px" height="50px">创建时间：</td>
                    <td width="500px" height="50px"><%=date%></td>
                </tr>
            </table>
        </div>
        <script type="text/javascript">
            function per() {
                var name=document.getElementById("name").value;
                var password=document.getElementById("password").value;
                var phone=document.getElementById("phone").value;
                location.href="/design/PersonalSaveServlet?email=<%=email%>&name="+name+"&password="+password+"&phone="+phone;
            }
        </script>
        <div class="button">
            <button type="submit">
                <a href="javascript:per()" id="bu" value="1">
                    保存
                </a>
            </button>
        </div>
    </div>
</div>
</from>
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
