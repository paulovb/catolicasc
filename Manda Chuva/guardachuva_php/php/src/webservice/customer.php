<?php
   	
	require '../../lib/Slim/Slim.php';
	require '../../lib/redbean/config.php';	
		
	\Slim\Slim::registerAutoloader();
	
	$app = new \Slim\Slim();
	$app->response()->header('Content-Type', 'application/json;charset=utf-8');
	
	$app->get('/read','read');
	$app->post('/create','create');
	$app->post('/update','update');
	$app->post('/delete','delete');

	$app->run();
			
	function read()
	{		
		header("Content-type: application/json");
		
		$result = R::getAll( 'select * from customer' );
		
		echo "{\"data\":". json_encode($result) ."}";
	}
	
	function create()
	{	
		$id = mysql_real_escape_string($_POST["id"]);
		$name = mysql_real_escape_string($_POST["name"]);
		$cpf = mysql_real_escape_string($_POST["cpf"]);
		$email = mysql_real_escape_string($_POST["email"]);
		
		$customer = R::dispense('customer');
		
		$customer->name  = $name;
		$customer->cpf   = $cpf;
		$customer->email = $email;
		 
		$result = R::load('customer', R::store($customer));
	
		header("Content-type: application/json");
		
		echo json_encode($result);
		
	}
	
	function update()
	{		
		$id = mysql_real_escape_string($_POST["id"]);
		$name = mysql_real_escape_string($_POST["name"]);
		$cpf = mysql_real_escape_string($_POST["cpf"]);
		$email = mysql_real_escape_string($_POST["email"]);
		
		$customer = R::load('customer',$id);
		
		$customer->name  = $name;
		$customer->cpf   = $cpf;
		$customer->email = $email;
		 
		$result = R::load('customer', R::store($customer));
	
		header("Content-type: application/json");
		
		echo json_encode($result);
	}
	
	function delete()
	{		
		$id = mysql_real_escape_string($_POST["id"]);
	
		$customer = R::load('customer',$id);
		 	
		R::trash($customer);
	}