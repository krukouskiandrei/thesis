<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form"%>
<div class="columns">
	<div class="column">
		<div class="modal is-active">
  			<div class="modal-background"></div>
  			<div class="modal-content">
    			<div class="chart-container">
					<canvas id="myChart"></canvas>
				</div>
  			</div>
  			<button class="modal-close"></button>
		</div>
	</div>
</div>


<h1 class="title has-text-centered" style="margin-bottom: 70px;">Probabilistic tests of simplicity</h1>
 
<div class="columns is-mobile">
	<div class="column is-half is-offset-one-quarter">
		<springform:form action="${contextPath}/checkNumber" method="POST" commandName="algorithmInfo">
			
			<div class="field is-horizontal" style="margin-bottom: 30px;">
  				<div class="field-label is-normal">
    				<springform:label path="number" class="label">Number</springform:label>
  				</div>
  				<div class="field-body">
    				<div class="field">
      					<div class="control">
        					<springform:textarea path="number" class="textarea" id="number_area" placeholder="Enter number"></springform:textarea>
      					</div>
      					<springform:errors path="number">
      						<p id="invalid_number" class="help is-danger">Invalid format of number</p>
      					</springform:errors>
      					
    				</div>
  				</div>
			</div>
			
			<div class="field is-horizontal" style="margin-bottom: 30px;">
  				<div class="field-label is-normal">
    				<springform:label path="probability" class="label">Probability</springform:label>
  				</div>
  				<div class="field-body">
    				<div class="field">
      					<div class="control">
      						<springform:input path="probability"  id="probability_area" class="input" type="text" placeholder="0.5" />
      					</div>
      					<springform:errors path="probability">
      						<p id="invalid_probability" class="help is-danger">Invalid format of number</p>
      					</springform:errors>
    				</div>
  				</div>
			</div>
			
			<div class="field is-horizontal" style="margin-bottom: 30px;">
  				<div class="field-label is-normal">
    				<springform:label path="testName" class="label">Probabilistic test</springform:label>
  				</div>
  				<div class="field-body">
    				<div class="field is-grouped">
      					<div class="control">
        					<div class="select is-fullwidth">
          						<springform:select path="testName">
            						<springform:option value="SS">Solovay-Strassen</springform:option>
            						<springform:option value="MR">Miller-Rabin</springform:option>
            					</springform:select>
        					</div>
      					</div>
   				 	</div>
    				<div class="field is-horizontal">
    					<div class="field-label is-normal">
    						<springform:label path="jacobiAlgorithm" class="label">Jacobi</springform:label>
    					</div>
    					<div class="field-body">
      					<div class="control">
        					<div class="select is-fullwidth">
          						<springform:select path="jacobiAlgorithm">
            						<springform:option value="AD">Algorithm-definitions</springform:option>
            						<springform:option value="BA">Binary algorithm</springform:option>
            						<springform:option value="UA">Usual algorithm</springform:option>
            						<springform:option value="AL">Algorithm Lebesgue</springform:option>
            						<springform:option value="OA">O(M(n)log n) algorithm</springform:option>
          						</springform:select>
        					</div>
      					</div>
      					</div>
      					
   					 </div>
  				</div>
			</div>
			
			<div class="field is-horizontal" style="margin-bottom: 30px;">
  				<div class="field-label">
    				<springform:label path="allAlgorithms" class="label">Check all algorithms?</springform:label>
  				</div>
  				<div class="field-body">
    				<div class="field is-narrow">
      					<div class="control">
        					<label class="radio">
          						<springform:radiobutton path="allAlgorithms" value="true"/>
          						Yes
        					</label>
        					<label class="radio">
          						<springform:radiobutton path="allAlgorithms" value="false" checked="true"/>
          						No
        					</label>
      					</div>
    				</div>
  				</div>
			</div>
			
			<div class="field is-horizontal" style="margin-bottom: 30px;">
  				<div class="field-label">
    				<!-- Left empty for spacing -->
  				</div>
  				<div class="field-body">
    				<div class="field">
      					<div class="control">
        					<button id="main_button" class="button is-primary">
          						Check
        					</button>
      					</div>
    				</div>
  				</div>
			</div>
			
		</springform:form>
  	</div>
</div>
 
 
 
 	
<script>

$('#menu a:nth-child(1)').addClass('is-active');

if($('#invalid_number').length) {
	$('#number_area').addClass('is-danger');
}

if($('#invalid_probability').length) {
	$('#probability_area').addClass('is-danger');
}
    
</script>
<script>
	window.onload = function() {
		var ctx = document.getElementById("myChart");
		var myChart = new Chart(ctx, {
			type: 'bar',
			data: {
    				labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange", "Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
    				datasets: [{
        			label: '# of Votes',
        			data: [12, 19, 3, 5, 2, 3, 12, 19, 3, 5, 2, 3],
        			backgroundColor: [
            				'rgba(255, 99, 132, 0.2)',
            				'rgba(54, 162, 235, 0.2)',
            				'rgba(255, 206, 86, 0.2)',
            				'rgba(75, 192, 192, 0.2)',
            				'rgba(153, 102, 255, 0.2)',
            				'rgba(255, 159, 64, 0.2)',
            				'rgba(255, 99, 132, 0.2)',
            				'rgba(54, 162, 235, 0.2)',
            				'rgba(255, 206, 86, 0.2)',
            				'rgba(75, 192, 192, 0.2)',
            				'rgba(153, 102, 255, 0.2)',
            				'rgba(255, 159, 64, 0.2)'
        				],
        			borderColor: [
            				'rgba(255,99,132,1)',
            				'rgba(54, 162, 235, 1)',
            				'rgba(255, 206, 86, 1)',
            				'rgba(75, 192, 192, 1)',
            				'rgba(153, 102, 255, 1)',
            				'rgba(255, 159, 64, 1)',
            				'rgba(255,99,132,1)',
            				'rgba(54, 162, 235, 1)',
            				'rgba(255, 206, 86, 1)',
            				'rgba(75, 192, 192, 1)',
            				'rgba(153, 102, 255, 1)',
            				'rgba(255, 159, 64, 1)'
        			],
        			borderWidth: 1
    			}]
			},
			options: {
    			scales: {
        			yAxes: [{
            			ticks: {
                			beginAtZero:true
          			  }
        			}]
    			},
    			events: ['click'],
    			tooltips: {
        			mode: 'x'
    			}
			}
		});
	};

</script>