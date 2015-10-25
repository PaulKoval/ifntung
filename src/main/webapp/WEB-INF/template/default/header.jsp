<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:url value="/resources/css/main.css" var="mainCss" />
<spring:url value="/resources/js/general.js" var="mainJS" />
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script src="<c:url value="/resources/js/general.js" />"></script>


    <link rel="stylesheet" href="https://dev.getlaunched.io/assets/plugins/icomoon/style.css">
    <link rel="stylesheet" href="https://dev.getlaunched.io/assets/plugins/bootstrap/css/bootstrap.min.css">

    <link rel="stylesheet" href="https://dev.getlaunched.io/assets/plugins/bootstrap-datepicker/css/datepicker3.css">
    <link rel="stylesheet" href="https://dev.getlaunched.io/assets/plugins/bootstrap-select/bootstrap-select.min.css">
    <link rel="stylesheet" href="https://dev.getlaunched.io/assets/plugins/bootstro.js/bootstro.min.css">
    <link rel="stylesheet" href="https://dev.getlaunched.io/assets/plugins/wysihtml5/bootstrap3-wysihtml5.css">

            <link rel="stylesheet" href="https://dev.getlaunched.io/assets/css/whitelabel/10/style.css">
    
    <link rel="stylesheet" href="https://dev.getlaunched.io/assets/css/style.css?1444485149">
    <link rel="stylesheet" href="https://dev.getlaunched.io/assets/css/_tmp.css">

<!-- <div id="header">
    Header a<br/>
        <c:out value="${headerMessage}"/>
</div> -->

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>


<header>

	<div class="page-header navbar navbar-fixed-top">
		<div class="container page-header-inner">
            <div class="page-logo ">
                 <a href="dashboard"><img src="/springmvc/resources/img/logo.png" alt="" height="39">&nbsp;<label> Human resources</label></a>
            </div>
			<div class="hor-menu" role="navigation">
				<ul class="nav navbar-nav">
                    <li class="active guide" data-bootstro-title="Dashboard" data-bootstro-content="You always can return to dashboard here" data-bootstro-width="350px" data-bootstro-placement="bottom" data-bootstro-step="1">
                            <a href="dashboard" class="">Dashboard<span class="selected" hidden-xs=""></span></a>
                    </li>
                    <li class="" data-bootstro-title="Step 3" data-bootstro-content="Here you can see your startups and projects" data-bootstro-width="400px" data-bootstro-placement="bottom" data-bootstro-step="2" data-original-title="" title="">
                        <a class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown" data-href="#">My action list <i class="glyphicon glyphicon-chevron-down" aria-hidden="true"></i> <span class="selected hidden-xs"></span></a>
                        <ul class="dropdown-menu pull-left">
                            <li class=""><a href="dashboard">Dashboard</a></li>
							<li class=""><a href="humans">Human resources list</a></li>
                            <li class=""><a href="search">Search</a></li>
                            <li class=""><a href="companies">Companies</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
			<div class="top-menu">
                <ul class="nav navbar-nav pull-right count menu-handler">
                    <li class="dropdown dropdown-extended">
                        <a href="javascript:void(0);" class="responsive-toggler"><i class="icon-menu2"></i></a>
                    </li>
                </ul>
				<ul class="nav navbar-nav pull-right">
					<!-- BEGIN USER LOGIN DROPDOWN -->
					<li class="dropdown dropdown-extended dropdown-user" data-bootstro-title="Step 5" data-bootstro-content="Here you will find all important information about your account and reach the overview of your invited friends. You want to take full advantage of getLaunched? Then here you get the exclusive " entrepreneur"="" account!"="" data-bootstro-width="400px" data-bootstro-placement="bottom" data-bootstro-step="4" data-original-title="" title="">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" style="padding: 14px 6px 7px 14px;" data-hover="dropdown" data-close-others="true">
							<i class="glyphicon glyphicon-user" aria-hidden="true"></i>
							<span class="username">${headerMessage}</span> <i class="glyphicon glyphicon-chevron-down" aria-hidden="true"></i>
						</a>
						<ul class="dropdown-menu extended">
							<li>
								<p>
									<strong>${headerMessage}</strong>
								</p>
							</li>
							<c:if test="${Access == \"1\"}"><li><a href="admin"><i class="glyphicon glyphicon-home"></i> Admin dashboard</a></li></c:if> 
							<li><a href="logout"><i class="glyphicon glyphicon-off"></i> Logout</a></li>
						</ul>
					</li>
					<!-- END USER LOGIN DROPDOWN -->
                </ul>
            </div>
        </div>
    </div>
</header>