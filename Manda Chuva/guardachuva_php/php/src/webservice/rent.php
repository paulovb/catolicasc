<?php
   	
	require '../../lib/Slim/Slim.php';
	require '../../lib/redbean/config.php';	
		
	\Slim\Slim::registerAutoloader();
	
	$app = new \Slim\Slim();
	$app->response()->header('Content-Type', 'application/json;charset=utf-8');
	
	$app->get('/read','read');

	$app->run();
			
	function read()
	{		
		header("Content-type: application/json");
		
		$result = R::getAll( 'select * from rent' );
		
		echo "{\"data\":". json_encode($result) ."}";
	}
	
	