<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <title>Perfil</title>
        <link rel="shortcut icon" href="../favicon.ico"> 


        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/web/kendo.common.min.css'/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/web/kendo.uniform.min.css'/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/page.css'/>" />


        <script src="<c:url value='/resources/js/modernizr.custom.63321.js'/>"></script>

        <!-- jquery and kendo javascript. jquery MUST be first. -->
        <script src="<c:url value='/resources/js/jquery.min.js'/>"/></script>
    <script src="<c:url value='/resources/js/kendo.all.min.js'/>"/></script>

<!--[if lte IE 7]><style>.main{display:none;} .support-note .note-ie{display:block;}</style><![endif]-->

<style>	
    body {
        background: #cdcdcd url(<c:url value='/resources/image/dance.jpg'/>) no-repeat center top;
        -webkit-background-size: cover;
        -moz-background-size: cover;
        background-size: cover;
    }

</style>
</head>

<body>

    <c:url value="/shared/create" var="createUrl" />
    <c:url value="/shared/read" var="readUrl" />
    <c:url value="/shared/update" var="updateUrl" />
    <c:url value="/shared/destroy" var="destroyUrl" />

    <div class="container">	

        <div class="main">

            <div class="content" class="k-content">
    
            </div>
            <div class="side">
                <nav class="dr-menu">
                    <div class="dr-trigger"><span class="dr-icon dr-icon-menu"></span><a class="dr-label">Menu</a></div>
                    <ul>
                        <li><a class="dr-icon dr-icon-user" href="<c:url value="/user/" />">admin</a></li>
                        <li><a class="dr-icon dr-icon-camera" href="<c:url value="/locale/"/>">Palcos</a></li>
                        <li><a class="dr-icon dr-icon-heart dr-menu-current" href="<c:url value="/event/"/>">Apresentaç&otilde;es</a></li>
                        <li><a class="dr-icon dr-icon-bullhorn" href="<c:url value="/shared/"/>">Publicaç&otilde;es</a></li>
                        <!--                            <li><a class="dr-icon dr-icon-download" href="#">Downloads</a></li>
                                                    <li><a class="dr-icon dr-icon-settings" href="#">Settings</a></li>-->
                        <li><a class="dr-icon dr-icon-switch" href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div><!-- /container -->

    <script src="<c:url value='/resources/js/ytmenu.js'/>"></script>

    

</body>
</html>