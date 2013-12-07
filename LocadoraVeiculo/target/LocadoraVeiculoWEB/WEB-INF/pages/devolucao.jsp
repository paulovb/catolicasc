<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>

    <%@ include file="_header.jsp" %>
    <%@ include file="_menu.jsp" %>

    
    <c:url value="/carro/read" var="createUrlCarro" />
    
    <c:url value="/devolucao/readNotReturned" var="readUrl" />
    <c:url value="/devolucao/updateDevolution" var="updateUrl" />

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
                <p><strong>Devolução</strong> de veículos</p>
            </header>
            
            <script>
                function timeEditor(container, options) {
                    $('<input data-text-field="' + options.field + '" data-value-field="' + options.field + '" data-bind="value:' + options.field + '" data-format="' + options.format + '"/>')
                            .appendTo(container)
                            .kendoTimePicker({});
                }

                function dateTimeEditor(container, options) {
                    $('<input data-text-field="' + options.field + '" data-value-field="' + options.field + '" data-bind="value:' + options.field + '" data-format="' + options.format + '"/>')
                            .appendTo(container)
                            .kendoDateTimePicker({});
                }
            </script>
            
            <div class="main clearfix">
                
                 <div class="content" class="k-content">
                    <kendo:grid name="grid" pageable="true" sortable="true" scrollable="true" selectable="true" reorderable="true" resizable="true" height="500">
                        <kendo:grid-editable mode="inline"/>
                        <kendo:grid-columns>
                            
                            <kendo:grid-column title="Carro" field="idcarro" width="150px">
                                <kendo:grid-column-values value="${carros}"/>
                            </kendo:grid-column>
                            
                            <kendo:grid-column title="Cliente" field="idcliente" width="150px">
                                <kendo:grid-column-values value="${clientes}"/>
                            </kendo:grid-column>
                            
                            <kendo:grid-column title="Km Total" field="km" width="70px"/>
                            
                            <kendo:grid-column title="Preço" field="preco" width="70px"/>
                            
                            <kendo:grid-column title="Empréstimo" field="dtcreate" width="140px" template="#= dtcreate == null ? '' : kendo.toString(new Date(dtcreate), 'dd/MM/yyyy HH:mm') #"/> 
                            
                            <kendo:grid-column title="Devolução" field="dtdevolucao" width="150px" editor="dateTimeEditor" format="{0:dd/MM/yyyy HH:mm}"
                                               template="#= dtdevolucao == null ? '' : kendo.toString(new Date(dtdevolucao), 'dd/MM/yyyy HH:mm') #"/>
                          
                            
                            <kendo:grid-column title="&nbsp;" width="140px" >
                                <kendo:grid-column-command>
                                    <kendo:grid-column-commandItem name="edit" text="Devolver" />
                                </kendo:grid-column-command>
                            </kendo:grid-column>
                        </kendo:grid-columns>
                        <kendo:dataSource pageSize="20">
                            <kendo:dataSource-transport>
                                <kendo:dataSource-transport-read url="${readUrl}" dataType="json" type="GET" contentType="application/json"/>
                                <kendo:dataSource-transport-update url="${updateUrl}" dataType="json" type="POST" contentType="application/json" />
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
                                        
                                       
                                        <kendo:dataSource-schema-model-field name="idcarro" editable="false" nullable="false" defaultValue="1">
                                        </kendo:dataSource-schema-model-field>
                                        
                                        <kendo:dataSource-schema-model-field name="idcliente" editable="false" nullable="false" defaultValue="1">
                                        </kendo:dataSource-schema-model-field>
                                        
                                        <kendo:dataSource-schema-model-field name="km" editable="false" nullable="false">
                                        </kendo:dataSource-schema-model-field>

                                        <kendo:dataSource-schema-model-field name="preco" editable="false" nullable="true">
                                        </kendo:dataSource-schema-model-field>
                                        
                                        <kendo:dataSource-schema-model-field name="dtcreate" editable="false" nullable="true">
                                        </kendo:dataSource-schema-model-field>
                                        
                                        <kendo:dataSource-schema-model-field name="dtdevolucao" editable="true" nullable="false">
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