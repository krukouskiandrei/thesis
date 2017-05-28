<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page session="false" contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8" />
    <link type="text/css" rel="stylesheet" href="resources/css/bulma.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="resources/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="resources/js/main.js"></script>
</head>
<body>

    
    <div id="header">
        <t:insertAttribute name="header"/>
    </div>
    <div id="content" style="padding-top: 5%;">
    	<t:insertAttribute name="body"/>
    </div>
    <div id="footer">
        <t:insertAttribute name="footer"/>
    </div>
    

</body>
</html>