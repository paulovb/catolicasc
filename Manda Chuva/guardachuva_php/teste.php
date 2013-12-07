<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link href="./kendoui/styles/kendo.common.min.css" rel="stylesheet" />
    <link href="./kendoui/styles/kendo.silver.min.css" rel="stylesheet" />
    <script src="./kendoui/js/jquery.min.js"></script>
    <script src="./kendoui/js/kendo.all.min.js"></script>
</head>
<body>
    <?php

		require_once './kendoui/wrappers/php/lib/Kendo/Autoload.php';				
	?>
    
        <div id="customer" class="k-content">
            <div id="grid"></div>
            <script>
                $(document).ready(function() {
                	
                	kendo.culture("pt-BR");
                	
                    $("#grid").kendoGrid({
                        dataSource: {
                            transport: {
                                read: "./php/customer/read.php",
                                update: {
                                	url: "./php/customer/update.php",
                                	type: "POST"
                                },
                                create: {
                                	url: "./php/customer/create.php",
                                	type: "POST"
                                },
                                destroy: {
                                	url: "./php/customer/delete.php",
                                	type: "POST"
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
                            serverPaging: true,
                            serverFiltering: true,
                            serverSorting: true
                        },
                        height: 430,
                        toolbar: ["create"],
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
                                width: 150
                            }, { 
                            	command: ["edit", "destroy"], width: "172px" 
                            }],
                       	editable: "inline"
                    });
                });
            </script>
        </div>

</body>
</html>