<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>

    <%@ include file="_header.jsp" %>
    <%@ include file="_menu.jsp" %>

    <c:url value="/categoria/create" var="createUrl" />
    <c:url value="/categoria/read" var="readUrl" />
    <c:url value="/categoria/update" var="updateUrl" />
    <c:url value="/categoria/destroy" var="destroyUrl" />

    <div class="st-content">
        <div class="st-content-inner">
            <div class="codrops-top clearfix">
                <div id="st-trigger-effects">
                    <button class="codrops-icon codrops-icon-prev" data-effect="st-effect-3">
                        Menu
                    </button>
                </div>
            </div>
            
            <header class="codrops-header">
                <p>Cadastro de <strong>Categoria</strong></p>
            </header>
            
            <div class="main clearfix">
                
                 <div class="content" class="k-content">
                    <kendo:grid name="grid" pageable="true" sortable="true" scrollable="true" selectable="true" reorderable="true" resizable="true" height="500">
                        <kendo:grid-editable mode="inline"/>
                        <kendo:grid-toolbar>
                            <kendo:grid-toolbarItem name="create" text="Nova Categoria"/>
                        </kendo:grid-toolbar>
                        <kendo:grid-columns>
                            <kendo:grid-column title="Nome" field="nome" width="180px"/>
                            <kendo:grid-column title="&nbsp;" width="160px" >
                                <kendo:grid-column-command>
                                    <kendo:grid-column-commandItem name="edit" text="Editar" />
                                    <kendo:grid-column-commandItem name="destroy" text="Excluir"/>
                                </kendo:grid-column-command>
                            </kendo:grid-column>
                        </kendo:grid-columns>
                        <kendo:dataSource pageSize="20">
                            <kendo:dataSource-transport>
                                <kendo:dataSource-transport-create url="${createUrl}" dataType="json" type="POST" contentType="application/json" />
                                <kendo:dataSource-transport-read url="${readUrl}" dataType="json" type="GET" contentType="application/json"/>
                                <kendo:dataSource-transport-update url="${updateUrl}" dataType="json" type="POST" contentType="application/json" />
                                <kendo:dataSource-transport-destroy url="${destroyUrl}" dataType="json" type="POST" contentType="application/json" />
                                <kendo:dataSource-transport-parameterMap>
                                    <script>
                                        function parameterMap(options, type) {
                                            return JSON.stringify(options);
                                        }
                                    </script>
                                </kendo:dataSource-transport-parameterMap>
                            </kendo:dataSource-transport>
                            <kendo:dataSource-schema>
                                <kendo:dataSource-schema-model id="id">
                                    <kendo:dataSource-schema-model-fields>

                                        <kendo:dataSource-schema-model-field name="nome" type="string">
                                            <kendo:dataSource-schema-model-field-validation required="true" />
                                        </kendo:dataSource-schema-model-field>

                                    </kendo:dataSource-schema-model-fields>
                                </kendo:dataSource-schema-model>
                            </kendo:dataSource-schema>
                        </kendo:dataSource>
                    </kendo:grid>
                </div>
            </div>
        </div>
    </div>
    
    <%@ include file="_footer.jsp" %>