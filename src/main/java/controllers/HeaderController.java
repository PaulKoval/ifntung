package controllers;
import java.io.Console;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.ViewPreparerSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import controllers.HomeController;


@Controller("headerController")
public class HeaderController extends ViewPreparerSupport{

	//Creating object of class, - for getting data from home controller
	HomeController Home = new HomeController();
	
    @Override
    public void execute(TilesRequestContext tilesContext, AttributeContext attributeContext ) {
    	
    	String userName;
    	String Access;
    	try{
    		 userName =  Home.userInformation.get(0).toString();
    		 Access =  Home.userInformation.get(2).toString();
    	} catch (Throwable t) {
    		 userName =  "User";
    		 Access = "";
    	}
    	
        // Get access to model parameters from MainController as example
        String message = (String) tilesContext.getRequestScope().get("message");
        tilesContext.getRequestScope().put("headerMessage", userName);
        tilesContext.getRequestScope().put("Access", Access);
        
    }

}
