<?php
		require_once './kendoui/wrappers/php/include/chart_data.php';
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
							<h1>Empréstimo de <strong>Guarda-chuva</strong> de Joinville</h1>
						</header>
						<div class="main clearfix">

							<div id="st-trigger-effects" class="column">

								<?php
									$series = new \Kendo\Dataviz\UI\ChartSeriesItem();
									$series->field('value')
									       ->name('United States');
									
									$valueAxis = new \Kendo\Dataviz\UI\ChartValueAxisItem();
									
									$valueAxis->labels(array('format' => '{0}%'))
									          ->line(array('visible' => false));
									
									$categoryAxis = new \Kendo\Dataviz\UI\ChartCategoryAxisItem();
									
									$categoryAxis->field('year')
									             ->majorGridLines(array('visible' => false));
									
									$tooltip = new \Kendo\Dataviz\UI\ChartTooltip();
									$tooltip->visible(true)
									        ->format('{0}%')
									        ->template('#= category # - #= value #%');
									
									$dataSource = new \Kendo\Data\DataSource();
									
									$dataSource->data(chart_united_states_internet_usage());
									
									$chart_rent = new \Kendo\Dataviz\UI\Chart('chart_rent');
									$chart_rent->title(array('text' => 'Número de empréstimos'))
									      ->dataSource($dataSource)
									      ->legend(array('visible' => false))
									      ->addSeriesItem($series)
									      ->addValueAxisItem($valueAxis)
									      ->addCategoryAxisItem($categoryAxis)
									      ->seriesDefaults(array(
									          'type' => 'area',
									          'labels' => array(
									              'visible' => true,
									              'format'=> '{0}%',
									              'background' => 'transparent'
									          )
									      ))
									      ->tooltip($tooltip);
									
									echo $chart_rent->render();
								?>
								
							</div>
							<div class="column">
									<?php
									$total = new \Kendo\Dataviz\UI\ChartSeriesItem();
									$total->name('Total Visits')
									      ->data(array(56000, 63000, 74000, 91000, 117000, 138000));
									
									$unique = new \Kendo\Dataviz\UI\ChartSeriesItem();
									$unique->name('Unique visitors')
									       ->data(array(52000, 34000, 23000, 48000, 67000, 83000));
									
									$valueAxis = new \Kendo\Dataviz\UI\ChartValueAxisItem();
									$valueAxis->line(array('visible' => false));
									
									$categoryAxis = new \Kendo\Dataviz\UI\ChartCategoryAxisItem();
									$categoryAxis->categories(array('Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun'))
									             ->majorGridLines(array('visible' => false));
									
									$tooltip = new \Kendo\Dataviz\UI\ChartTooltip();
									$tooltip->visible(true)
									        ->template('#= series.name #: #= value #');
									
									$chart_rent_rain = new \Kendo\Dataviz\UI\Chart('chart_rent_rain');
									$chart_rent_rain->addSeriesItem($total, $unique)
									      ->addValueAxisItem($valueAxis)
									      ->addCategoryAxisItem($categoryAxis)
									      ->legend(array('position' => 'bottom'))
									      ->seriesDefaults(array('type' => 'column'))
									      ->chartArea(array('background' => 'transparent'))
									      ->title(array('text' => 'Empréstimos X Índice Pluviométrico'))
									      ->tooltip($tooltip);
									
									echo $chart_rent_rain->render();
									?>
									
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