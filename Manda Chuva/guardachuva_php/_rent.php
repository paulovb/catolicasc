<?php
require_once 'header.php';
?>

		<div id="st-container" class="st-container st-effect-3">

			<!-- content push wrapper -->
			<div class="st-pusher">
				<!--
				example menus
				these menus will be under the push wrapper
				-->
				<?php
				require_once './sidebar.php';
				?>
				
				<div class="st-content">
					<!-- this is the wrapper for the content -->
					<div class="st-content-inner">
						<!-- extra div for emulating position:fixed of the menu -->
						<!-- Top Navigation -->
						<div class="codrops-top clearfix">
							<div id="st-trigger-effects">
								<button class="codrops-icon codrops-icon-prev" data-effect="st-effect-3">
									Menu
								</button>
							</div>
						</div>

						<header class="codrops-header">
							<h1>Empréstimo</h1>
						</header>
						<div class="main clearfix">

							<?php					
								require_once './kendoui/wrappers/php/lib/Kendo/Autoload.php';				
							?>
					    
					        <div id="customer" class="k-content">
					            <div id="grid"></div>
					            <script>
					                $(document).ready(function() {
					                	
					                	var webserviceurl = "./php/src/webservice/rent.php";
					                	
					                	kendo.culture("pt-BR");
					                	
					                    $("#grid").kendoGrid({
					                        dataSource: {
					                            transport: {
					                                read: { 
					                                	url: (webserviceurl+"/read"),
					                                	dataType: "json"
					                                },
					                                update: {
					                                	url:  webserviceurl+"/update",
					                                	type: "POST",
					                                	dataType: "json"
					                                },
					                                create: {
					                                	url:  webserviceurl+"/create",
					                                	type: "POST",
					                                	dataType: "json"
					                                },
					                                destroy: {
					                                	url:  webserviceurl+"/delete",
					                                	type: "POST",
					                                	dataType: "json"
					                                }
					                            },
					                            schema: {
										            data: "data",
										            model: {
										                id: "id",
										                fields: {
										                	name  : { validation: { required: true}},
					                                        cpf   : { validation: { required: true}},
					                                        email : { validation: { required: true}}
										                }
										            }
										        },
					                            pageSize: 10,
					                            paging: true,
					                            filtering: true,
					                            sorting: true
					                        },
					                        height: 540,
					                        toolbar: [{ name: "create", text: "Novo Emprétimo" }],
					                        sortable: true,
					                        pageable: true,
					                        columns: [{
					                                field: "name",
					                                title: "Nome",
					                                width: 180
					                            }, {
					                                field: "cpf",
					                                title: "CPF",
					                                width: 80
					                            }, {
					                                field: "email",
					                                title: "E-mail",
					                                width: 100
					                            }, {
					                                field: "dt_create",
					                                title: "Empréstimo",
					                                format: "{0:dd/MM/yyyy}",
					                                width: 100
					                            }, {
					                                field: "dt_return",
					                                title: "Devolução",
					                                format: "{0:dd/MM/yyyy}",
					                                width: 100
					                            }, { 
					                            	command: [{ name: "edit", text: { edit:"Editar", update:"Salvar", cancel:"Cancelar"}}, { name: "destroy", text: "Excluir" }], width: "80px" 
					                            }],
					                       	editable: "inline"
					                    });
					                });
					            </script>
					        </div>

							
						</div><!-- /main -->
					</div><!-- /st-content-inner -->
				</div><!-- /st-content -->
			</div><!-- /st-pusher -->
		</div><!-- /st-container -->

<?php
require_once 'footer.php';
?>