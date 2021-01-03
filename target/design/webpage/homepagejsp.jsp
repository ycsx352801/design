<%--
  Created by IntelliJ IDEA.
  User: 27655
  Date: 2020/12/31
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Flower</title>
    <link rel="stylesheet" href="css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="webpage/homepagecss.css"/>
</head>
<body>
<%String email=(String)request.getAttribute("email");%>
<form name="form" action="" method="get">
<!--顶部区域-->
<div class="head">
    <div class="head-thefirst">
        <!--头部图片-->
        <div class="head-img">
            <img src="webpage/picture/头部图片.jpg" width="1500px" height="300px"/>
        </div>
        <!--搜索区域-->
        <div class="head-search">
            <input type="text" placeholder="请输入想要搜索的内容" />
            <a href=""><i class="fa fa-search" style="color:white"></i></a>
        </div>
    </div>
    <!--菜单栏-->
        <div class="head-down">
            <div class="head-menu">
                <li>
                    <a href="">首页</a>
                </li>
                <li>
                    <a href="/design/PersonalServlet?email=<%=email%>" onclick="form.submit();">个人主页</a>
                </li>
            </div>
        </div>
</div>
</form>
<!--正文区域-->
<div class="content">
    <!--轮播区域-->
    <div class="rotation">
        <div class="picture">
            <a class="show" href="/design/ChoiceServlet?picture=<%="webpage/picture/礼物/花好月圆.jpg"%>&fname=<%="花好月圆"%>&email=<%=email%>">
                <img src="webpage/picture/礼物/花好月圆.jpg" width="700px" height="600px" />
            </a>
            <a href="/design/ChoiceServlet?picture=<%="webpage/picture/花篮/平淡岁月.jpg"%>&fname=<%="平淡岁月"%>&email=<%=email%>">
                <img src="webpage/picture/花篮/平淡岁月.jpg" width="700px" height="600px" />
            </a>
            <a href="/design/ChoiceServlet?picture=<%="webpage/picture/礼物/我如此爱你.jpg"%>&fname=<%="我如此爱你"%>&email=<%=email%>">
                <img src="webpage/picture/礼物/我如此爱你.jpg" width="700px" height="600px" />
            </a>
            <a href="/design/ChoiceServlet?picture=<%="webpage/picture/礼物/永生花.jpg"%>&fname=<%="永生花"%>&email=<%=email%>">
                <img src="webpage/picture/礼物/永生花.jpg" width="700px" height="600px" />
            </a>
            <a href="/design/ChoiceServlet?picture=<%="webpage/picture/礼物/永生玫瑰.jpg"%>&fname=<%="永生玫瑰"%>&email=<%=email%>">
                <img src="webpage/picture/礼物/永生玫瑰.jpg" width="700px" height="600px" />
            </a>
        </div>
        <div class="circle">
            <li class="color"></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </div>
    </div>
    <script src="webpage/homepagejs.js" type="text/javascript" charset="UTF-8"></script>
    <!--精品推荐-->
    <div class="video">
        <h3>精品推荐</h3>
        <div>
            <li class=""><a href="/design/ChoiceServlet?picture=<%="webpage/picture/礼物/一鹿有你.jpg"%>&fname=<%="一鹿有你"%>&email=<%=email%>">
                <img src="webpage/picture/礼物/一鹿有你.jpg" width="290px" height="260px" />
            </a></li>
            <li><a href="/design/ChoiceServlet?picture=<%="webpage/picture/礼物/一鹿有你.jpg"%>&fname=<%="一鹿有你"%>&email=<%=email%>">一鹿（路）有你永生花小夜灯</a></li>
        </div>
        <div>
            <li><a href="/design/ChoiceServlet?picture=<%="webpage/picture/礼物/如此爱你.jpg"%>&fname=<%="如此爱你"%>&email=<%=email%>">
                <img src="webpage/picture/礼物/如此爱你.jpg" width="290px" height="260px" >
            </a></li>
            <li><a href="/design/ChoiceServlet?picture=<%="webpage/picture/礼物/如此爱你.jpg"%>&fname=<%="如此爱你"%>&email=<%=email%>">如此爱你-口红款</a></li>
        </div>
        <div>
            <li><a href="/design/ChoiceServlet?picture=<%="webpage/picture/花束/初心不负.jpg"%>&fname=<%="初心不负"%>&email=<%=email%>">
                <img src="webpage/picture/花束/初心不负.jpg" width="290px" height="260px" />
            </a></li>
            <li><a href="/design/ChoiceServlet?picture=<%="webpage/picture/花束/初心不负.jpg"%>&fname=<%="初心不负"%>&email=<%=email%>">韩式系列/初心不负</a></li>
        </div>
        <div>
            <li><a href="/design/ChoiceServlet?picture=<%="webpage/picture/花束/你笑起来真好看.jpg"%>&fname=<%="你笑起来真好看"%>&email=<%=email%>">
                <img src="webpage/picture/花束/你笑起来真好看.jpg" width="290px" height="260px" />
            </a></li>
            <li><a href="/design/ChoiceServlet?picture=<%="webpage/picture/花束/你笑起来真好看.jpg"%>&fname=<%="你笑起来真好看"%>&email=<%=email%>">韩式系列/你笑起来真好看</a></li>
        </div>
    </div>
    <!--热门推荐-->
    <div class="hotspot">
        <h3>热门推荐</h3>
        <hr>
        <div>
            <div>
                <li><img src="webpage/picture/礼物/十二星座/白羊座.jpg" width="270px" height="216px" /></li>
                <li><a href="/design/ChoiceServlet?picture=<%="webpage/picture/礼物/十二星座/白羊座.jpg"%>&fname=<%="白羊座"%>&email=<%=email%>">
                    十二星座蓝玫瑰系列/白羊座
                </a></li>
            </div>
        </div>
        <div>
            <div>
                <li><img src="webpage/picture/礼物/十二星座/金牛座.jpg" width="270px" height="216px" /></li>
                <li><a href="/design/ChoiceServlet?picture=<%="webpage/picture/礼物/十二星座/金牛座.jpg"%>&fname=<%="金牛座"%>&email=<%=email%>">
                    十二星座蓝玫瑰系列/金牛座
                </a></li>
            </div>
        </div>
        <div>
            <div>
                <li><img src="webpage/picture/礼物/十二星座/双子座.jpg" width="270px" height="216px" /></li>
                <li><a href="/design/ChoiceServlet?picture=<%="webpage/picture/礼物/十二星座/双子座.jpg"%>&fname=<%="双子座"%>&email=<%=email%>">
                    十二星座蓝玫瑰系列/双子座
                </a></li>
            </div>
        </div>
        <div>
            <div>
                <li><img src="webpage/picture/礼物/十二星座/巨蟹座.jpg" width="270px" height="216px" /></li>
                <li><a href="/design/ChoiceServlet?picture=<%="webpage/picture/礼物/十二星座/巨蟹座.jpg"%>&fname=<%="巨蟹座"%>&email=<%=email%>">
                    十二星座蓝玫瑰系列/巨蟹座
                </a></li>
            </div>
        </div>
        <div>
            <div>
                <li><img src="webpage/picture/礼物/十二星座/摩羯座.jpg" width="270px" height="216px" /></li>
                <li><a href="/design/ChoiceServlet?picture=<%="webpage/picture/礼物/十二星座/摩羯座.jpg"%>&fname=<%="摩羯座"%>&email=<%=email%>">
                    十二星座蓝玫瑰系列/摩羯座
                </a></li>
            </div>
        </div>
    </div>
</div>
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
