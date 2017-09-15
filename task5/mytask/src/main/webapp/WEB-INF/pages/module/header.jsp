<%--
  Created by IntelliJ IDEA.
  User: 姚远
  Date: 2017/9/6
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<head>
    <tiles:insertAttribute name="cssresources"/>
    <div class="container  hidden-xs">
        <div class="row header-top">
            <p class="col-xs-12 col-sm-6 col-md-6 col-lg-6">客服电话:010-594-78634</p>
            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-right">
                <div>
                    <a href="#" target="_blank"> <img alt=""  src="${pageContext.request.contextPath}/t10/imges/54537.png"></a>
                    <a href="#" target="_blank"><img alt=""  src="${pageContext.request.contextPath}/t10/imges/45678678.png"></a>
                    <a href="#" target="_blank"> <img alt=""  src="${pageContext.request.contextPath}/t10/imges/54375483543.png"></a>
                </div>
            </div>
        </div>
    </div>

    <nav class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header">
                <a href="#" class="navbar-brand">
                    <img src="${pageContext.request.contextPath}/t10/imges/logo.png" alt="Brand" class="img-responsive">
                </a>
                <button data-target="#open-nav" data-toggle="collapse" class="navbar-toggle btn-primary collapsed" aria-expanded="false">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div id="open-nav" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
                <ul class="nav navbar-nav navbar-right text-center list-inline">
                    <li><a href="${pageContext.request.contextPath}/home">首页</a></li>
                    <li><a href="${pageContext.request.contextPath}/u/job">职业</a></li>
                    <li><a href="">推荐</a></li>
                    <li><a href="">关于</a></li>
                </ul>
            </div>

        </div>
    </nav>
</head>

