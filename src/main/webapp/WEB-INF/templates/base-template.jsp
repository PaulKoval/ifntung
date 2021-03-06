<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <tiles:getAsString name="title" />
        </title>
        <link rel="stylesheet" href="/css/style.css" type="text/css"/>
    </head>
    <body>

        <tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="navigation" />
        <tiles:insertAttribute name="content" />
        <tiles:insertAttribute name="footer" />

    </body>
</html>