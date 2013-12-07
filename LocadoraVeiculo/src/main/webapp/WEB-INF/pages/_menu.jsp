<%-- 
    Document   : _menu
    Created on : Nov 15, 2013, 7:33:30 PM
    Author     : paulo
--%>

<%@page import="br.org.pucsc.locadora.util.MD5Util"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>

<nav class="st-menu st-effect-3" id="menu-3">
    <h2 class="icon">
        <img id="img_avatar" alt="" src="http://www.gravatar.com/avatar/<%= MD5Util.md5Hex("paulo.bischof@gmail.com") %>.jpg?s=80" />    
        <p><a href="/user">Paulo Vitor Bischof</a></p>             
    </h2>
    <ul>
        <li>
            <a class="icon icon-display" href="${pageContext.request.contextPath}/welcome/">Inicio</a>
        </li>
        <li>
            <a class="icon icon-t-shirt" href="${pageContext.request.contextPath}/cliente/">Cliente</a>
        </li>
        <li>
            <a class="icon icon-truck" href="${pageContext.request.contextPath}/carro/">Carro</a>
        </li>
        <li>
            <a class="icon icon-tag" href="${pageContext.request.contextPath}/categoria/">Categoria</a>
        </li>
        <li>
            <a class="icon icon-banknote" href="${pageContext.request.contextPath}/precolocacao/">Tabela de Preço</a>
        </li>
        <li>
            <a class="icon icon-shop" href="${pageContext.request.contextPath}/locacao/">Locação</a>
        </li>
        <li>
            <a class="icon icon-shop" href="${pageContext.request.contextPath}/devolucao/">Devolução</a>
        </li>

        <li>
            <a class="icon icon-lock" href="${pageContext.request.contextPath}/logoff">Sair</a>
        </li>
    </ul>
</nav>