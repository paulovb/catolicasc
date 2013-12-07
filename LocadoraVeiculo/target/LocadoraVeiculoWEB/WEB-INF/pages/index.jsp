<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <title>Educacional</title>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/normalize.css'/>" />
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/demo.css'/>" />
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/icons.css'/>" />
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/component.css'/>" />

        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/web/kendo.common.min.css'/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/web/kendo.uniform.min.css'/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/page.css'/>" />

        <script src="<c:url value='/resources/js/jquery.min.js'/>"/></script>
        <script src="<c:url value='/resources/js/kendo.all.min.js'/>"/></script>
        <script src="<c:url value='/resources/js/cultures/kendo.culture.pt-BR.min.js'/>" type="text/javascript"></script>
        <script src="<c:url value='/resources/js/modernizr.custom.js'/>"></script>

</head>
<body>
    <div id="st-container" class="st-container">
        <div class="st-pusher">
            <nav class="st-menu st-effect" id="menu">
                <h2 class="icon icon-lab">Sidebar</h2>
                <ul>
                    <li><a class="icon icon-data" href="#">Data Management</a></li>
                    <li><a class="icon icon-location" href="#">Location</a></li>
                    <li><a class="icon icon-study" href="#">Study</a></li>
                    <li><a class="icon icon-photo" href="#">Collections</a></li>
                    <li><a class="icon icon-wallet" href="#">Credits</a></li>
                </ul>
            </nav>

            <div class="st-content"><!-- this is the wrapper for the content -->
                <div class="st-content-inner"><!-- extra div for emulating position:fixed of the menu -->
                    <!-- Top Navigation -->
                    <div class="codrops-top clearfix">
                        <a class="codrops-icon codrops-icon-prev" href="http://tympanus.net/Tutorials/3DShadingWithBoxShadows/"><span>Previous Demo</span></a>
                        <span class="right"><a class="codrops-icon codrops-icon-drop" href="http://tympanus.net/codrops/?p=16292"><span>Back to the Codrops Article</span></a></span>
                    </div>
                    <header class="codrops-header">
                        <h1>Sidebar Transitions <span>Transition effects for off-canvas views</span></h1>
                    </header>
                    <div class="main clearfix">
                        <div id="st-trigger-effects" class="column">
                            <button data-effect="st-effect-1">Slide in on top</button>
                            <button data-effect="st-effect-2">Reveal</button>
                            <button data-effect="st-effect-3">Push</button>
                            <button data-effect="st-effect-4">Slide along</button>
                            <button data-effect="st-effect-5">Reverse slide out</button>
                            <button data-effect="st-effect-6">Rotate pusher</button>
                            <button data-effect="st-effect-7">3D rotate in</button>
                            <button data-effect="st-effect-8">3D rotate out</button>
                            <button data-effect="st-effect-9">Scale down pusher</button>
                            <button data-effect="st-effect-10">Scale Up</button>
                            <button data-effect="st-effect-11">Scale &amp; rotate pusher</button>
                            <button data-effect="st-effect-12">Open door</button>
                            <button data-effect="st-effect-13">Fall down</button>
                            <button data-effect="st-effect-14">Delayed 3D Rotate</button>
                        </div>
                        <div class="column">
                            <p>Sidebar menus or off-canvas navigations can be revealed in many creative ways.</p>
                            <p>Here is some inspiration for showing them in style using CSS transitions.</p>
                        </div>
                        <div class="info">
                            <p>If you enjoyed this demo you might also like:</p>
                            <p><a href="http://tympanus.net/Development/HeaderEffects/">On Scroll Header Effects</a></p>
                            <p><a href="http://tympanus.net/Development/PageTransitions/">A Collection of Page Transitions</a></p>
                        </div>
                    </div><!-- /main -->
                </div><!-- /st-content-inner -->
            </div><!-- /st-content -->
        </div>
    </div>

</body>
</html>