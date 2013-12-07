<%@page import="br.org.pucsc.locadora.util.MD5Util"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<!DOCTYPE html>
<html lang="en" class="js no-csstransforms3d" style="">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Locadora de Veículos</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="resources/css/normalize.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="resources/css/demo.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="resources/css/component.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="resources/css/home.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="resources/css/button.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="resources/css/graph.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="resources/css/icons.css"/>">

    </head>
    <body>		
        <div id="st-container" class="st-container st-effect-3">
            <div class="st-pusher">
                
                <%@ include file="_menu.jsp" %>

                <div class="st-content">
                    <div class="st-content-inner">
                        <div class="codrops-top clearfix">
                            <div id="st-trigger-effects">
                                <button class="codrops-icon codrops-icon-prev" data-effect="st-effect-3">
                                    Menu
                                </button>
                                <span class="codrops-icon">
                                    Locadora de Veículos
                                </span>
                            </div>
                        </div>

                        <div class="main clearfix">

                            

                        </div>
                    </div>
                </div>
                        
                        
                        
                        
            </div>
        </div>

        <script src="<c:url value="resources/js/modernizr.custom.js"/>"></script>
        <script src="<c:url value="resources/js/classie.js"/>"></script>
        <script src="<c:url value="resources/js/sidebarEffects.js"/>"></script>
        <script src="<c:url value="resources/js/dateformat.js"/>"></script>

    </body>
</html>