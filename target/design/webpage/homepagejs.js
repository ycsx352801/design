var circle=document.querySelectorAll(".circle li");
var picture=document.querySelectorAll(".picture a");
var rotation=document.querySelector(".rotation");
console.log(circle,picture,rotation);
//1、鼠标移到按钮切换对应图片
for(let i=0;i<circle.length;i++)
{
    var li=circle[i];
    li.onmouseenter=function(){
        //当移动时，把i即被指定的按钮下标，赋值给index即可
        index=i;
        //循环遍历所有的li按钮，并清空颜色类名
        for(let j=0;j<circle.length;j++)
        {
            circle[j].className="";
            picture[j].className="";
        }
        //给点击的按钮添加颜色类名
        circle[i].className="color";
        picture[i].className="show";
    }
}
//2、自动轮播，定时器
//图片下标位置，默认为0
var index=0;
var time=null;
//页面加载时，调用一次
playTime();
function playTime(){
    time=setInterval(function(){
        //每过两秒，下标加1，跳到下一张
        index++;
        //当图片走完最后一张，跳到第一张
        if(index==picture.length)
            index=0;
        for(let j=0;j<circle.length;j++)
        {
            circle[j].className="";
            picture[j].className="";
        }
        circle[index].className="color";
        picture[index].className="show";
    },2000)
}
//3、当鼠标移入rotation时，停止轮播，清除定时器
rotation.onmouseenter=function(){
    clearInterval(time);
}
//4、当鼠标移出rotation时，继续轮播，重新调用定时器
rotation.onmouseleave=function(){
    playTime();
}