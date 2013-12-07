<?php
   	
	require '../../lib/Slim/Slim.php';
	require '../../lib/redbean/config.php';	
		
	\Slim\Slim::registerAutoloader();
	
	$app = new \Slim\Slim();
	$app->response()->header('Content-Type', 'application/json;charset=utf-8');
	
	$app->get('/read','read');
	$app->get('/read/:id','readRow');
	$app->post('/create','create');
	$app->post('/update','update');
	$app->post('/delete','delete');

	$app->run();
	
	function read()
	{		
		$result = R::getAll( 'select * from product' );

		header("Content-type: application/json");
		
		echo "{\"data\":". json_encode($result) ."}";
	}
	
	function readRow($id)
	{	
		$result = R::load('product', $id);
	
		header("Content-type: application/json");
		
		echo $result;
	}	
	
	function create()
	{	
		$id = mysql_real_escape_string($_POST["id"]);
		$name = mysql_real_escape_string($_POST["name"]);
		$codigo = mysql_real_escape_string($_POST["codigo"]);
		
		$product = R::dispense('product');
		
		$product->name  = $name;
		$product->codigo = $codigo;
		 
		$result = R::load('product', R::store($product));
	
		header("Content-type: application/json");
		
		echo json_encode($result);
		
	}
	
	function update()
	{		
		$id = mysql_real_escape_string($_POST["id"]);
		$name = mysql_real_escape_string($_POST["name"]);
		$codigo = mysql_real_escape_string($_POST["codigo"]);
		
		$product = R::load('product',$id);
		
		$product->name  = $name;
		$product->codigo = $codigo;
		 
		$result = R::load('product', R::store($product));
	
		header("Content-type: application/json");
		
		echo json_encode($result);
	}
	
	function delete()
	{		
		$id = mysql_real_escape_string($_POST["id"]);
	
		$product = R::load('product',$id);
		 	
		R::trash($product);
	}