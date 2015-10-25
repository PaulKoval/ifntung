<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

<script>
$('.page-header').remove();
</script>
		

<div class="row">
	<form class="form-horizontal" method="post" action="login" onsubmit="formhash();">
    	<input type="hidden" name="action" value="register">
    	<input type="hidden" name="p1" id="p1" value="">
    	<input type="hidden" name="p2" id="p2" value="">
    	<div class="col-sm-8 col-sm-offset-2 login-block" style="display: block;">
    		<div class="box shadow">
        		<div class="box-header">
            		<h3>Login</h3>
        		</div>
        		<div class="box-body">
	            	<div class="form-group">
	                	<label class="col-md-4 control-label">E-mail address</label>
		                <div class="col-md-8">
		                    <div class="input-icon">
		                        <input class="form-control" type="email" name="email" id="username" value="">
		                    </div>
		                </div>
	            	</div>
		            <div class="form-group">
		                <label class="col-md-4 control-label">Password</label>
		                <div class="col-md-8">
		                    <div class="input-icon">
		                        <input class="form-control" type="password" name="password" id="password1" value="">
		                    </div>
		                </div>
		            </div>
		            <div class="form-group login">
		                <label class="col-md-4 control-label">&nbsp;</label>
		                <div class="col-md-8">
		                    <div class="row">
		                        <div class="col-md-12 col-sm-12 col-xs-12">
		                            <div class="pull-left">
		                                <div class="switch">
		                                    <input id="stay-connected" class="cmn-toggle cmn-toggle-round" type="checkbox" name="autologin" value="1">
		                                    <label for="stay-connected"></label>
		                                </div>
		                            </div>
		                            <div class="col-md-10 col-sm-10 col-xs-10 label-login-text">Stay connected</div>
		                        </div>
		
		
		                        <div class="col-md-12 col-sm-12 col-xs-12">
		
		                            <div class="switch">
		                                <input id="guide-show" class="cmn-toggle cmn-toggle-round" type="checkbox" value="1" name="hide_guide">
		                                <label for="guide-show"></label>
		                            </div>
		
		                            <div class="col-md-10 col-sm-10 col-xs-10 label-login-text">Do not show the guide at login</div>
		                        </div>
		                    </div>
		                </div>
		            </div>
		            <script>
		                $('#username').focus();
		            </script>
        		</div>
        		<div class="box-footer">
            		<div class="form-group">
                		<div class="col-md-3 col-xs-12 col-md-offset-4">
                    		<button type="submit" class="btn btn-primary btn-lg col-xs-12">Login</button>
                		</div>
            		</div>
        		</div>
    		</div>
    	</div>
		<p class="text-center"><a class="btn btn-primary registration" href="javascript:;">No account yet? Register here</a></p>
	</form>
	
	<form class="form-horizontal" method="post" action="register" onsubmit="formhash();">
	    <input type="hidden" name="action" value="register">
	    <input type="hidden" name="p1" id="p1" value="">
	    <input type="hidden" name="p2" id="p2" value="">
	    <div class="row">
			<div class="col-md-8 col-sm-offset-2 reg-block" style="display: none;">
				<div class="row plans">
				    <div class="box shadow">
				        <div class="box-body">
				            <h3>Registration</h3>
				            <div class="form-group">
				                <label class="col-md-5 control-label">First name</label>
				                <div class="col-md-7">
				                    <input class="form-control" type="text" name="firstname" value="" placeholder="">
				                </div>
				            </div>
				            <div class="form-group">
				                <label class="col-md-5 control-label">Last name</label>
				                <div class="col-md-7">
				                    <input class="form-control" type="text" name="lastname" value="" placeholder="">
				                </div>
				            </div>
				            <div class="form-group">
				                <label class="col-md-5 control-label">E-mail address</label>
				                <div class="col-md-7">
				                <input class="form-control" type="text" name="email" value="">
				                </div>
				            </div>
				            <div class="form-group">
				                <label class="col-md-5 control-label">Password</label>
				                <div class="col-md-7">
				                    <input class="form-control" type="password" id="password1" value="">
				                </div>
				            </div>
				            <div class="form-group">
				                <label class="col-md-5 control-label">Repeat password</label>
				                <div class="col-md-7">
				                    <input class="form-control" type="password" id="password2" value="">
				                </div>
				            </div>
				        </div>
				        <div class="box-footer">
				            <div class="form-group">
				                <div class="col-md-3 col-md-offset-5 col-xs-12">
				                    <button type="submit" class="btn btn-primary btn-lg col-xs-12">Register</button>
				                </div>
				            </div>
				        </div>
				        <div class="" id="status"></div>
				    </div>
				</div>
			</div>
		</div>
	</form>
</div>
    </tiles:putAttribute>
</tiles:insertDefinition>