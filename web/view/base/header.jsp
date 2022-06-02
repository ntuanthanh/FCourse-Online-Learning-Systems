<%-- 
    Document   : header
    Created on : May 23, 2022, 8:25:07 AM
    Author     : pv
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <script src ="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.min.js"></script>
        <style>
            .name-banner{
                color : green;
                font-weight: 900;
                text-align: center;
                font-size: 20px;
            }
            .header-second{
                margin-top: 5px;
                background-color: #F57F20;
                box-shadow: 0 0 10px 5px #DFDFDA;
            }
            .color-menu a:hover{
                color : black !important;
            }
            .color-menu a{
                color : white !important;
            }
        </style>
    </head>
    <body>
        <header>
            <div class="header-frist">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-7">
                            <div class="row">
                                <div class="col-md-4">
                                    <img src="${pageContext.request.contextPath}/images/header/logo-main.png" width="50px" height="50px" alt="" />
                                    <span class="name-banner">Edu-FCourse</span>
                                </div>
                                <div class="col-md-8">
                                    <ul class="nav">
                                        <li class="nav-item">
                                            <a class="nav-link" href="#">Ask a Question<img src="${pageContext.request.contextPath}/images/header/ask.png" style="margin-bottom: 6px; margin-left: 2px;" width="20px" height="20px" alt=""/></a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="#">Course@gmail.com<img src="${pageContext.request.contextPath}/images/header/email.png" style="margin-bottom: 6px; margin-left: 2px;" width="20px" height="20px" alt=""/></a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-5">
                            <c:if test = "${sessionScope.user != null}">                                                         
                                <ul class="nav">
                                   <li class="nav-item"> 
                                    <a class="nav-link" href="${pageContext.request.contextPath}/myregistration">My Registration<img src="${pageContext.request.contextPath}/images/header/shopping-cart.png" style="margin-bottom: 6px; margin-left: 2px;" width="20px" height="20px" alt=""/></a>
                                   </li>
                                   <li class="nav-item"> 
                                    <a class="nav-link" href="${pageContext.request.contextPath}/mycourse">My Course<img src="${pageContext.request.contextPath}/images/header/online-course.png" style="margin-bottom: 6px; margin-left: 2px;" width="20px" height="20px" alt=""/></a>
                                   </li>       
                                    <li class="nav-item">
                                        <a class="nav-link" href="${pageContext.request.contextPath}/user/profile">${sessionScope.user.fullName}<img src="${pageContext.request.contextPath}/images/header/icons8-user.png" style="margin-bottom: 8px;" width="20px" height="20px" alt=""/></a> 
                                    </li>   
                                    <li class="nav-item">
                                        <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout<img src="${pageContext.request.contextPath}/images/header/icons8-logout-16.png" width="20px" style="margin-bottom: 6px;" height="20px" alt=""/></a>
                                    </li>
                                </ul>
                             </c:if>
                            <c:if test = "${sessionScope.user == null}">
                                <div style="display: flex; justify-content: flex-end">
                                    <img src="${pageContext.request.contextPath}/images/header/user.png" width="20px" height="20px" style="margin-top: 10px; margin-right: 5px" alt="" />
                                    <a class=" btn btn-primary" href="${pageContext.request.contextPath}/login">Login</a>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container-fluid">
                <div class="row header-second">
                    <div class="col-md-12">
                        <nav class="navbar navbar-expand-lg navbar-light">
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                                <ul class="navbar-nav mr-auto">
                                    <li class="nav-item color-menu">
                                        <a class="nav-link" href="${pageContext.request.contextPath}/home">Home</a>
                                    </li>
                                    <li class="nav-item color-menu">
                                        <a class="nav-link" href="${pageContext.request.contextPath}/course/list">Our courses</a>
                                    </li>
                                    <li class="nav-item color-menu">
                                        <a class="nav-link" href="#">Blogs</a>
                                    </li>
                                    <li class="nav-item color-menu">
                                        <a class="nav-link" href="#">About us</a>
                                    </li>
                                    <li class="nav-item color-menu">
                                        <a class="nav-link" href="#">Contact</a>
                                    </li>
<!--                                    <li class="nav-item color-menu">
                                        <a class="nav-link" href="${pageContext.request.contextPath}/admin/dashboard">Admin site(link tam)</a>
                                    </li>-->
                                </ul>
                                <form class="form-inline">
                                    <input class="form-control mr-sm-2" placeholder="Search Courses">
                                    <button class="btn btn-warning" type="submit">Search</button>
                                </form>
                            </div>
                        </nav>
                    </div>
                </div>
            </div> 
        </header>
    </body>
</html>
