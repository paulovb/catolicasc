<?php
    session_start();
	if (!isset($_SESSION['system_user_mail'])) {
	    header("Location: ./login.php");
		exit(0);
	}
?>