<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<div class="columns is-mobile">
  <div class="column is-half is-offset-one-quarter">
  
  <h1 class="title is-1 has-text-centered">Generated prime number</h1>  						
  <textarea class="textarea" placeholder="Textarea"><c:out value="${primeNumber}" /></textarea>
  
  <div class="columns is-mobile" style="margin-top: 5%;">
  	<div class="column is-half is-offset-one-quarter has-text-centered">
  		<a href="${contextPath}/bignumbers" class="button is-primary is-outlined is-large">Get new number</a>
  	</div>
  </div>
  </div>
</div>


<script>

    $('#menu a:nth-child(2)').addClass('is-active');
      
</script>