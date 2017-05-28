<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<nav class="nav has-shadow">
  <div class="container">
    <div class="nav-left">
      <a class="nav-item">
        <img src="resources/css/img/logo1.PNG" alt="Prime recognaizer logo">
      </a>      
    </div>
    	
	<div id="menu" class="nav-center">
      <a href="${contextPath}/" class="nav-item is-tab">Home</a>
      <a href="${contextPath}/bignumbers" class="nav-item is-tab">Big prime number</a>      
    </div>
    
  </div>
</nav>
