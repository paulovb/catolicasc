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
							<h1>Cadastro de Produtos</h1>
						</header>
						<div class="main clearfix">

							<?php					
								require_once './kendoui/wrappers/php/lib/Kendo/Autoload.php';				
							?>
					    
					        <div id="customer" class="k-content">
					            <div id="grid"></div>
					            <script>
					                $(document).ready(function() {
					                	
					                	kendo.culture("pt-BR");
					                	
					                	var webserviceurl = "./php/src/webservice/product.php";
					                	
					                    $("#grid").kendoGrid({
					                        dataSource: {
					                            transport: {
					                                read: { 
					                                	url: (webserviceurl+"/read"),
					                                	dataType: "json"
					                                },
					                                update: {
					                                	url: webserviceurl+"/update",
					                                	type: "POST",
					                                	dataType: "json"
					                                },
					                                create: {
					                                	url: webserviceurl+"/create",
					                                	type: "POST",
					                                	dataType: "json"
					                                },
					                                destroy: {
					                                	url: webserviceurl+"/delete",
					                                	type: "POST",
					                                	dataType: "json"
					                                }
					                            },
					                            schema: {
										            data: "data",
										            model: {
										                id: "id",
										                fields: {
										                	name  : { nullable: true },
					                                        codigo : { validation: { required: true}},
					                                        dt_create : { editable: false}
										                }
										            }
										        },
					                            pageSize: 10,
					                            paging: true,
					                            filtering: true,
					                            sorting: true
					                        },
					                        height: 540,
					                        toolbar: [{ name: "create", text: "Novo Produto" }],
					                        sortable: true,
					                        pageable: true,
					                        columns: [{
					                                field: "codigo",
					                                title: "Código",
					                                width: 60
					                            }, {
					                                field: "name",
					                                title: "Produto (Opcional)",
					                                width: 80
					                            }, {
					                                field: "dt_create",
					                                title: "Vigência",
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