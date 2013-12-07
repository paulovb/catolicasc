<?php
require_once 'header.php';
?>

		<div id="st-container" class="st-container st-effect-3">

			<!-- content push wrapper -->
			<div class="st-pusher">
				<!--
				example menus
				these menus will be under the push wrapper
				-->
				<?php
				require_once './sidebar.php';
				?>
				
				<div class="st-content">
					<!-- this is the wrapper for the content -->
					<div class="st-content-inner">
						<!-- extra div for emulating position:fixed of the menu -->
						<!-- Top Navigation -->
						<div class="codrops-top clearfix">
							<div id="st-trigger-effects">
								<button class="codrops-icon codrops-icon-prev" data-effect="st-effect-3">
									Menu
								</button>
							</div>
						</div>

						<header class="codrops-header">
							<h1>Sidebar Transitions <span>Transition effects for off-canvas views</span></h1>
						</header>
						<div class="main clearfix">

							<div id="st-trigger-effects" class="column">

							
								
							</div>
							<div class="column">
									
								<p>
									Here is some inspiration for showing them in style using CSS transitions.
								</p>
							</div>
								<div class="info">
								<p>
									If you enjoyed this demo you might also like:
								</p>
							</div>
						</div><!-- /main -->
					</div><!-- /st-content-inner -->
				</div><!-- /st-content -->
			</div><!-- /st-pusher -->
		</div><!-- /st-container -->

<?php
require_once 'footer.php';
?>