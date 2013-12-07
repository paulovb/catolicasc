<?php
    if($_SERVER["REQUEST_METHOD"] == "POST")
	{
		// username and password sent from Form 
		$user_mail=addslashes($_POST['login']); 
		$user_password=addslashes($_POST['password']);
	}
?>