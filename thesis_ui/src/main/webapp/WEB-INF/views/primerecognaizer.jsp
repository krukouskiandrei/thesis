<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form"%>
<div class="columns">
	<div class="column">
		<div class="modal">
  			<div class="modal-background"></div>
  			<div class="modal-content">
    			<p class="image is-4by3">
      				<img src="http://bulma.io/images/placeholders/1280x960.png">
    			</p>
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

    
</script>
