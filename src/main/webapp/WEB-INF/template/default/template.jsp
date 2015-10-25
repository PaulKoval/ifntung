<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${page-title} - without HTML escaping provided by c:out</title>
    <style type="text/css">
    
 
     
    </style>
</head>
<body>
    <div class="page">
        <tiles:insertAttribute name="header" />
        <div class="content">
        	<tiles:insertAttribute name="body_header" />
            <tiles:insertAttribute name="body" />
            <tiles:insertAttribute name="body_footer" />
        </div>
        <tiles:insertAttribute name="footer" />
    </div>
</body>
</html>