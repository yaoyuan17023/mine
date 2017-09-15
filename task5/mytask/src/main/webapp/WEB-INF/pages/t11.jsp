<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: 姚远
  Date: 2017/9/4
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>职业殿堂</title>

</head>

<body>
<header>
    <tiles:insertDefinition name="task4-head2" />
</header>

<div class="container">

    <div class="nav-title">首页&gt;职业</div>
    <div class="nav-bar">
        <span class="">方向：</span>
        <a class="nav-bar-a a-selected" href="">全部</a>
        <a class="nav-bar-a" href="">前端开发</a>
        <a class="nav-bar-a" href="">后端开发</a>
        <a class="nav-bar-a" href="">移动开发</a>
        <a class="nav-bar-a" href="">整站开发</a>
        <a class="nav-bar-a" href="">运营维护</a>
    </div>




    <div class="caption">
        <h4>前端开发方向</h4>
    </div>

    <div class="row">
        <c:forEach items="${beforeEnd}" var="beforeEnd">
            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

                <div class="warp-border">
                    <div class="clearfix">
                        <div class="icon-people"><img src="${beforeEnd.picture}"></div>
                        <div class="text">
                            <h4 class="">${beforeEnd.profession}</h4>
                            <p class="text-present">${beforeEnd.introduce}</p>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">门槛 <img src="${beforeEnd.level}"></div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">难易程度 <img src="${beforeEnd.difficulty}"><img src="${beforeEnd.difficulty}"></div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${beforeEnd.period}</span>年</div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${beforeEnd.need}</span>家公司需要</div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="leftWarp">
                            薪资待遇
                        </div>
                        <div class="rightWarp">
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">0-1年</div>
                                <div class="rightWarp-wages">${beforeEnd.money1}</div>
                            </div>
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">1-3年</div>
                                <div class="rightWarp-wages">${beforeEnd.money2}</div>
                            </div>
                            <div class="rightWarp-class border-bottom">
                                <div class="rightWarp-year">3-5年</div>
                                <div class="rightWarp-wages">${beforeEnd.money3}</div>
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <b class="text-b">有${css}人正在学</b>
                    </div>
                    <div class="warp-class2">
                        <p class="text-p">${beforeEnd.tips}</p>
                    </div>

                    <div class="flip-container">
                        <p class="flip-title">${beforeEnd.hiddenName}</p>
                        <p class="flip-text">${beforeEnd.hiddenIntroduce}</p>
                    </div>
                </div>

            </div>
        </c:forEach>

    </div>




    <div class="caption">
        <h4>后端开发方向</h4>
    </div>

    <div class="row padding-bottom">
    <c:forEach items="${afterEnd}" var="afterEnd">
        <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

            <div class="warp-border">
                <div class="clearfix">
                    <div class="icon-people"><img src="${afterEnd.picture}"></div>
                    <div class="text">
                        <h4 class="">${afterEnd.profession}</h4>
                        <p class="text-present">${afterEnd.introduce}</p>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">门槛 <img src="${afterEnd.level}"></div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">难易程度 <img src="${afterEnd.difficulty}"><img src="${afterEnd.difficulty}"><img src="${afterEnd.difficulty}"><img src="${afterEnd.difficulty}"></div>
                    </div>
                </div>
                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${afterEnd.period}</span>年</div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${afterEnd.need}</span>家公司需要</div>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="leftWarp">
                        薪资待遇
                    </div>
                    <div class="rightWarp">
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">${afterEnd.money1}</div>
                        </div>
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">1-3年</div>
                            <div class="rightWarp-wages">${afterEnd.money2}</div>
                        </div>
                        <div class="rightWarp-class border-bottom">
                            <div class="rightWarp-year">3-5年</div>
                            <div class="rightWarp-wages">${afterEnd.money3}</div>
                        </div>
                    </div>
                </div>

                <div class="warp-class2">
                    <b class="text-b">有${java}人正在学</b>
                </div>
                <div class="warp-class2">
                    <p class="text-p">${afterEnd.tips}</p>
                </div>

                <div class="flip-container">
                    <p class="flip-title">${afterEnd.hiddenName}</p>
                    <p class="flip-text">${afterEnd.hiddenIntroduce}</p>
                </div>
            </div>

        </div>
    </c:forEach>
        </div>
</div>
</body>
<tiles:insertDefinition name="task4-footer" />
</html>
