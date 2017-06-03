<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${not empty testResult}">
<div class="columns">
	<div class="column">
		<div class="modal is-active">
  			<div class="modal-background"></div>
  			<div class="modal-content">
  				<div class="card" style="padding: 5%;">
  					<div class="card-image">
     					<div class="chart-container">
							<canvas id="myChart"></canvas>
						</div>
  					</div>
  					<div class="card-content">
    					<h1 class="title is-1 has-text-centered">
  						<c:choose>
  							<c:when test="${testResult}">
  								Number is prime
  							</c:when>
  							<c:otherwise>
  								Number isn't prime
  							</c:otherwise>
  						</c:choose>
  						</h1>
  						
  						<textarea class="textarea" placeholder="Textarea"><c:out value="${number}" /></textarea>
  					</div>
				</div>    			
  			</div>
  			<button class="modal-close"></button>
		</div>
	</div>
</div>
</c:if>

<h1 class="title has-text-centered" style="margin-bottom: 70px;">Probabilistic tests of simplicity</h1>
 
<div class="columns is-mobile">
	<div class="column is-half is-offset-one-quarter">
		<springform:form action="${contextPath}/checkNumber" method="POST" commandName="algorithmInfoDTO">
			
			<div class="field is-horizontal" style="margin-bottom: 30px;">
  				<div class="field-label is-normal">
    				<springform:label path="number" class="label">Number</springform:label>
  				</div>
  				<div class="field-body">
    				<div class="field">
      					<div class="control">
        					<springform:textarea path="number" class="textarea" id="number_area" placeholder="Enter number" onkeyup="countChar(this)"></springform:textarea>
        					<div id="charNum">0</div>
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
    
function countChar(val) {
    var len = val.value.length;
    $('#charNum').text(len);
};
    
</script>
<script>
	
	/* var labelsName = ["Red", "Green", "Orange"];
	var dataInfo = [12, 19, 3];
	var backgroundColorList = [
		'rgba(75, 192, 192, 0.2)',
		'rgba(153, 102, 255, 0.2)',
		'rgba(255, 159, 64, 0.2)'
	];
	var borderColorList = [
		'rgba(255,99,132,1)',
		'rgba(54, 162, 235, 1)',
		'rgba(255, 206, 86, 1)'
	]; */
	var labelsName = [];
	var dataInfo = [];
	var backgroundColorList = [
		'rgba(75, 192, 192, 0.2)',
		'rgba(153, 102, 255, 0.2)',
		'rgba(255, 159, 64, 0.2)',
		'rgba(255,99,132,1)',
		'rgba(54, 162, 235, 1)',
		'rgba(255, 206, 86, 1)'
		
	];
	var borderColorList = [
		'rgba(75, 192, 192, 0.2)',
		'rgba(153, 102, 255, 0.2)',
		'rgba(255, 159, 64, 0.2)',
		'rgba(255,99,132,1)',
		'rgba(54, 162, 235, 1)',
		'rgba(255, 206, 86, 1)'
	];
	<c:forEach items="${timeInfo}" var="time">
		labelsName.push("${time.name}");
		dataInfo.push(${time.duration});
	</c:forEach>
	var data = {
		labels: labelsName,
		datasets: [{
			label: 'Probabiliti test time',
			data: dataInfo,
			backgroundColor: backgroundColorList,
			borderColor: borderColorList,
			borderWidth: 1
		}]
	};




	window.onload = function() {
		var ctx = document.getElementById("myChart");
		var myChart = new Chart(ctx, {
			type: 'bar',
			data: data,
			options: {
    			scales: {
        			yAxes: [{
            			ticks: {
                			beginAtZero:true
          				}
        			}]
    			},
    			events: ['click']
			}
			});
		};
	

</script>