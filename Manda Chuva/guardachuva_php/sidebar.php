<nav class="st-menu st-effect-3" id="menu-3">
	
	<h2 class="icon">
		<?php
			$email=$_SESSION['system_user_mail'];
			$grav_url="http://www.gravatar.com/avatar/".md5(strtolower(trim($email)))."&s=80";
		?>
		<img src="<?php echo $grav_url; ?>" alt="" />
		<p><a href="./_user.php"><? echo $_SESSION['system_user_name']; ?></a></p>
	</h2>
	<ul>
		<li>
			<a class="icon icon-display" href="./index.php">Inicio</a>
		</li>
		<li>
			<a class="icon icon-calendar" href="./_calendar.php">Agenda</a>
		</li>
		<li>
			<a class="icon icon-user" href="./_customer.php">Cliente</a>
		</li>
		<li>
			<a class="icon icon-tag" href="./_product.php">Produtos</a>
		</li>
		<li>
			<a class="icon icon-shop" href="./_rent.php">Empréstimos</a>
		</li>
		<li>
			<a class="icon icon-settings" href="./_settings.php">Configurações</a>
		</li>
		<li>
			<a class="icon" href="./logoff.php">Sair</a>
		</li>
	</ul>
</nav>