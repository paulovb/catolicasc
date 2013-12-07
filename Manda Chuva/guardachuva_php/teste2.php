<!DOCTYPE html>
<html lang="en">
	<head>

		<link href="kendoui/styles/kendo.common.min.css" rel="stylesheet" />
		<link href="kendoui/styles/kendo.silver.min.css" rel="stylesheet" />
		<script src="kendoui/js/jquery.min.js"></script>
		<script src="kendoui/js/kendo.all.min.js"></script>

	</head>
	<body>
		

<?php
							require_once './php/DataSourceResult.php';
							require_once './kendoui/wrappers/php/lib/Kendo/Autoload.php';
							
							if ($_SERVER['REQUEST_METHOD'] == 'POST') {
							    header('Content-Type: application/json');
							
							    $request = json_decode(file_get_contents('php://input'));
							
							    $result = new DataSourceResult('mysql:host=localhost;port=3306;dbname=dbguardachuva','root','root');
							
							    $type = $_GET['type'];
							
							    $columns = array('id', 'cpf', 'name', 'email');
							
							    switch($type) {
							        case 'create':
							            $result = $result->create('customer', $columns, $request->models, 'id');
							            break;
							        case 'read':
										//$result = R::getAll( 'select * from customer' );
							            $result = $result->read('customer', $columns, $request);
            							break;
							        case 'update':
							            $result = $result->update('customer', $columns, $request->models, 'id');
							            break;
							        case 'destroy':
							            $result = $result->destroy('customer', $request->models, 'id');
							            break;
							    }
							
							    echo json_encode($result, JSON_NUMERIC_CHECK);
							
							    exit;
							}
							
							$transport = new \Kendo\Data\DataSourceTransport();
							
							$create = new \Kendo\Data\DataSourceTransportCreate();
							
							$create->url('_customer.php?type=create')
							     ->contentType('application/json')
							     ->type('POST');
							
							$read = new \Kendo\Data\DataSourceTransportRead();
							
							$read->url('_customer.php?type=read')
							     ->contentType('application/json')
							     ->type('POST');
							
							$update = new \Kendo\Data\DataSourceTransportUpdate();
							
							$update->url('_customer.php?type=update')
							     ->contentType('application/json')
							     ->type('POST');
							
							$destroy = new \Kendo\Data\DataSourceTransportDestroy();
							
							$destroy->url('_customer.php?type=destroy')
							     ->contentType('application/json')
							     ->type('POST');
							
							$transport->create($create)
							          ->read($read)
							          ->update($update)
							          ->destroy($destroy)
							          ->parameterMap('function(data) {
							              return kendo.stringify(data);
							          }');
							
							$model = new \Kendo\Data\DataSourceSchemaModel();
							
							$idField = new \Kendo\Data\DataSourceSchemaModelField('id');
							$idField->type('number')
							               ->editable(false)
							               ->nullable(true);
			   
							$nameField = new \Kendo\Data\DataSourceSchemaModelField('name');
							$nameField->type('string')
							                 ->validation(array('required' => true));
							
							$cpfField = new \Kendo\Data\DataSourceSchemaModelField('cpf');
							$cpfField->type('string')
							                 ->validation(array('required' => true));
							
							$emailField = new \Kendo\Data\DataSourceSchemaModelField('email');
							$emailField->type('string')
							                 ->validation(array('required' => true))
							               ->nullable(true);
							
							
							
							$model->id('id')
								->addField($idField)
							    ->addField($cpfField)
							    ->addField($nameField)
							    ->addField($emailField);
							
							$schema = new \Kendo\Data\DataSourceSchema();
							$schema->data('data')
							       ->errors('errors')
							       ->model($model)
							       ->total('total');
							
							$dataSource = new \Kendo\Data\DataSource();
							
							$dataSource->transport($transport)
							           ->batch(true)
							           ->pageSize(10)
							           ->schema($schema);
							
							$grid = new \Kendo\UI\Grid('grid');
							
							$name = new \Kendo\UI\GridColumn();
							$name->field('name')
										->width(360)
							            ->title('Nome');
							
							$cpf = new \Kendo\UI\GridColumn();
							$cpf->field('cpf')
							          ->width(200)
							          ->title('CPF');
									  
							$email = new \Kendo\UI\GridColumn();
							$email->field('email')
										->width(300)
							            ->title('E-mail');							
							
							$command = new \Kendo\UI\GridColumn();
							$command->addCommandItem('edit')
							        ->addCommandItem('destroy')
							        ->title('&nbsp;')
							        ->width(172);
							
							$grid->addColumn($name, $cpf, $email, $command)
							     ->dataSource($dataSource)
							     ->addToolbarItem(new \Kendo\UI\GridToolbarItem('create'))
							     ->height(500)
							     ->editable('inline')
							     ->pageable(true);
							
							echo $grid->render();
							?>