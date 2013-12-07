<?php

   	require '../../lib/redbean/config.php';	
	
	class CustomerDAO {
		
		public function findAll() {
				
			$result = R::getAll( 'select * from customer' );
			
			return $result;
		}
		
		
	}
