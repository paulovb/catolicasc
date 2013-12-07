<?php

    if($_SERVER["REQUEST_METHOD"] == "POST" )
	{
		if (strlen($_POST['login']) > 1) {
			
			$user_mail=addslashes($_POST['login']); 
			$user_password=addslashes($_POST['password']);
						
			require 'php/lib/redbean/config.php';
			
			$user = R::getRow('select * from user where email= :user_mail and password= :user_password', array(':user_mail' => $user_mail , ':user_password' => $user_password));
			
			if ($user) {
				
				$user = json_decode (json_encode ($user), FALSE);
				
				session_start();
				$_SESSION['system_user_mail'] = $user->email;
				$_SESSION['system_user_name'] = $user->name;
				$_SESSION['system_user_id']   = $user->id;
				
				header("Location: ./index.php");
				exit(0);
			}
		}
	}
?>

<!DOCTYPE html>
<html lang="en">
    <head>
		<meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <title>Login</title>
        <meta name="description" content="Página de login" />
        <meta name="keywords" content="css3, login, form, custom, input, submit, button, html5, placeholder" />
        <meta name="author" content="Paulo Vitor Bischof" />
        <link rel="shortcut icon" href="../favicon.ico">
        <link rel="stylesheet" type="text/css" href="css/login.css" />
        <script src="js/jquery.min.js"></script>
		<script src="js/modernizr.custom.js"></script>
		<!--[if lte IE 7]><style>.main{display:none;} .support-note .note-ie{display:block;}</style><![endif]-->
    </head>
    <body>
        <div class="container">
		
			<!-- Codrops top bar -->
            <div class="codrops-top">
                <a href="./faq.php">
                	Como funciona?
                </a>
                <span class="right">
                    <a href="./contact.php">
                        <strong>Contato</strong>
                    </a>
                </span>
            </div><!--/ Codrops top bar -->
			
			<header>
			
				<h1>Empréstimo de <strong>Guarda-Chuva</strong> de Joinville</h1>
				<h2>Para acessar é necessário efetuar o login</h2>
								
			</header>
			
			<section class="main">
				<form class="form-1" method="post" action="">
					<p class="field">
						<input type="text" name="login" placeholder="E-mail">
						<i class="icon-user icon-large"></i>
					</p>
						<p class="field">
							<input type="password" name="password" placeholder="Senha">
							<i class="icon-lock icon-large"></i>
					</p>
					<p class="submit">
						<button type="submit" name="submit"><i class="icon-arrow-right icon-large"></i></button>
					</p>
				</form>
			</section>
        </div>
        
    </body>
</html>