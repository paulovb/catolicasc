<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <title>Locadora de Veículos</title>

        <link rel="stylesheet" type="text/css" href="<c:url value="${pageContext.request.contextPath}/../resources/css/normalize.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="${pageContext.request.contextPath}/../resources/css/demo.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="${pageContext.request.contextPath}/../resources/css/component.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="${pageContext.request.contextPath}/../resources/css/home.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="${pageContext.request.contextPath}/../resources/css/button.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="${pageContext.request.contextPath}/../resources/css/graph.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="${pageContext.request.contextPath}/../resources/css/icons.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='${pageContext.request.contextPath}/../resources/css/page.css'/>" />

        <link rel="stylesheet" type="text/css" href="<c:url value='${pageContext.request.contextPath}/../resources/kendo/css/kendo.common.min.css'/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value='${pageContext.request.contextPath}/../resources/kendo/css/kendo.flat.min.css'/>"/>


        <script src="<c:url value='${pageContext.request.contextPath}/../resources/js/modernizr.custom.js'/>"></script>
        <script src="<c:url value='${pageContext.request.contextPath}/../resources/js/jquery.min.js'/>"/></script>
        <script src="<c:url value='${pageContext.request.contextPath}/../resources/kendo/js/kendo.all.min.js'/>"/></script>

<!--[if lte IE 7]><style>.main{display:none;} .support-note .note-ie{display:block;}</style><![endif]-->


</head>

<body onload='document.f.j_username.focus();'>
    <div class="container">

        <header class="logo">
            <br>
            <br>
        </header>

        <section class="main">

            <style>
                dd {
                    margin: 0px 0px 20px 0px;
                }

                body {
                    font-family: sans-serif;
                    background: #000000 url("resources/img/delorean.jpg") center no-repeat ;
                }
                .logo {
                    text-align: center;
                    margin: 0 auto;
                    padding: 40px;
                    font-size: 20px;
                }
                .signup {
                    width: 300px;
                    margin: 0 auto;
                }
                .signup .k-textbox, 
                .signup .k-widget {
                    width: 100%;
                }

                form {
                    padding: 10px;
                }
                
                input[type="submit"] {
                    width: 60px;
                    margin: 0 auto;        
                    text-align: center;           
                }

                .header {
                    text-align: center;
                }

                .k-info-colored {
                    padding: 10px;
                    margin: 10px;
                }
            </style>
            <div class="k-block signup">
                <div class="k-header header">Login</div>
                <c:if test="${not empty error}">
                    <div class="k-block k-info-colored">
                        <strong>Ops! </strong>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                    </div>
                </c:if>
                
                <form class="form_login" name='f' action="<c:url value='j_spring_security_check' />"
                      method='POST'>
                    <dl>
                        <dt><label for="j_username">E-mail:</label></dt>
                        <dd>
                            <span class="k-textbox">
                                <input id="j_username" name="j_username" type="text" data-bind="value: j_username" />
                            </span>  
                        </dd>
                        <dt><label for="j_password">Senha:</label></dt>
                        <dd>
                            <span class="k-textbox">
                                <input id="j_password" name="j_password" type="password" data-bind="value: j_password" />
                            </span>
                        </dd>
                    </dl>

                    <input class="k-button" type="submit" name="submit" value="Entrar">
                    
                </form>
            </div>
    </div>



</section>

</div>
<!-- jQuery if needed -->
<script src="<c:url value='${pageContext.request.contextPath}/../resources/js/modernizr.custom.js'/>"></script>
<script src="<c:url value='${pageContext.request.contextPath}/../resources/js/classie.js'/>"></script>
<script src="<c:url value='${pageContext.request.contextPath}/../resources/js/sidebarEffects.js'/>"></script>
<script src="<c:url value='${pageContext.request.contextPath}/../resources/js/dateformat.js'/>"></script>

</body>
</html>