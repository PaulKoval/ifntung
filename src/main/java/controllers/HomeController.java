package controllers;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.springmvc.Circle;
import net.codejava.springmvc.Shape;
import net.codejava.springmvc.dao.CompanyDAO;
import net.codejava.springmvc.dao.CustomerDAO;
import net.codejava.springmvc.dao.IndustryDAO;
import net.codejava.springmvc.model.Company;
import net.codejava.springmvc.model.Customer;
import net.codejava.springmvc.model.Industry;
import net.codejava.springmvc.dao.UserDAO;
import net.codejava.springmvc.model.User;
import net.codejava.springmvc.Auth;

import models.FirstPdf;

 
/**
 * Handles requests for the application home page.
 */
@Controller
@Scope("session")
public class HomeController {
	
	public static List<String> userInformation = new ArrayList<String>(); 
	public static List<String> userAccess = new ArrayList<String>();

	public List<String> user = new ArrayList<String>();
	
	public HomeController(){
		userInformation = user;
	}
	
	Auth Auth = new Auth();
	 
	
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    
    @Scope("session")
    @RequestMapping(value = {"/", "/humans"}, method = RequestMethod.GET)
    public String home(Locale locale, Model model, HttpServletRequest request, HttpSession httpSession) {
        logger.info("Welcome home! The client locale is {}.", locale);
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        attr.getRequest().getSession(true).getAttribute("Auth");
        
        try {
        	
        	//FirstPdf pdf = new FirstPdf();
        	//pdf.main(array("sdf"));
        	
            String Session = attr.getRequest().getSession().getAttribute("Auth").toString();
            
        	if(Auth.checkAuth(Session)){
        		
        		//System.out.println(user);
        		
            	//System.out.println(attr.getRequest().getSession(true).getAttribute("Auth"));

            	Date date = new Date();
                DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
                 
                String formattedDate = dateFormat.format(date);
                
                ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
           	 
                CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
                
                List<Customer> customerList = new ArrayList<Customer>();

                int limit = 15;
                customerList = customerDAO.findCustomers(limit, 0);
                Map<Integer,HashMap<String,String>> ResultMap = new HashMap<Integer, HashMap<String,String>>();
                ResultMap = customerDAO.SQLquery("SELECT * FROM CUSTOMER LIMIT 15 OFFSET 0");
                int count = customerDAO.countCustomers();
                int pagination = (int)Math.ceil(count / limit);
                
                model.addAttribute("pagination", pagination);
                model.addAttribute("customerlist", customerList);
                model.addAttribute("ResultMap", ResultMap);
                model.addAttribute("page-title", "Home");
                model.addAttribute("serverTime", formattedDate );

                return "home";
        	} else {
        		return "auth";
        	}
        	
        } catch (Throwable t) {

        	System.out.println(t);
            return "auth";
            
        }
    	
    }
     
    @Scope("session")
	 @RequestMapping(value="/auth", method = RequestMethod.GET)
	    public String auth(Locale locale, Model model, HttpServletRequest request) {
	        logger.info("Welcome home! The client locale is {}.", locale);
	        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	       
	        attr.getRequest().getSession(true).getAttribute("Auth");
	        
	        try {
	        	
	        		String Session = attr.getRequest().getSession().getAttribute("Auth").toString();
	        			return "redirect:/dashboard";	
	        		
	        } catch (Throwable q) { 
		        
		        return "auth";
		        }
	    }
    
    @Scope("session")
    @RequestMapping(value="/login", method = RequestMethod.POST)
	public String register(Locale locale, Model model, HttpServletRequest request){
    	
    	logger.info("Welcome home! The client locale is {}.", locale);
    	ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        User userCheck = new User();
        
        attr.getRequest().getSession(true).getAttribute("Auth");
        
        try {
        	
        		String Session = attr.getRequest().getSession().getAttribute("Auth").toString();
        			return "redirect:/dashboard";	
        		
        } catch (Throwable q) {
        	
	        try {
	        	
		            ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		            UserDAO userDao = (UserDAO) context.getBean("userDAO");
		            String email = request.getParameter("email").toString();
		            String password = request.getParameter("password").toString();
		            
		            List<User> userList = new ArrayList<User>();
		            
		            userList = userDao.findUserByEmail(email);
		            userCheck = userList.get(0);
		            
		            if(userCheck.getEmail().equals(email) && userCheck.getPassword().equals(password)){
			            request.getSession().setAttribute("Auth", "Authorized");
			            user.add(userCheck.getName().toString());
			            user.add(userCheck.getEmail().toString());
			            user.add(userCheck.getAccess().toString());
						return "redirect:/dashboard";
		            } else {
		            	return "redirect:/auth";
		            }
		            
	        } catch (Throwable t) {
	        	System.out.println(t);
				return "redirect:/auth";
	        }
	    	
        }
			
	}
    
    @Scope("session")
    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
    public String dashboard(Locale locale, Model model, HttpServletRequest request, HttpSession httpSession) {
        logger.info("Welcome home! The client locale is {}.", locale);
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        attr.getRequest().getSession(true).getAttribute("Auth");
        
        try {
        	
            String Session = attr.getRequest().getSession().getAttribute("Auth").toString();
            
        	if(Auth.checkAuth(Session)){
            	System.out.println(attr.getRequest().getSession(true).getAttribute("Auth"));

            	Date date = new Date();
                DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
                 
                String formattedDate = dateFormat.format(date);
                

                return "dashboard";
        	} else {
        		return "auth";
        	}
        	
        } catch (Throwable t) {

        	System.out.println(t);
            return "auth";
            
        }
    	
    }
    
    @Scope("session")
    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public String admin(Locale locale, Model model, HttpServletRequest request, HttpSession httpSession) {
        logger.info("Welcome home! The client locale is {}.", locale);
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        attr.getRequest().getSession(true).getAttribute("Auth");
        
        try {
        	
            String Session = attr.getRequest().getSession().getAttribute("Auth").toString();
            String Admin = userInformation.get(2).toString();
            System.out.println(Admin);
        	if(Auth.checkAuth(Session) && Admin.equals("1")){
                
        		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
              	 
                CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
                
                Map<Integer,HashMap<String,String>> ResultMap = new HashMap<Integer, HashMap<String,String>>();
                ResultMap = customerDAO.SQLquery("SELECT * FROM user");

                model.addAttribute("UserList", ResultMap);
                
                return "admin";
        	} else {
        		return "auth";
        	}
        	
        } catch (Throwable t) {

        	System.out.println(t);
            return "auth";
            
        }
    	
    }
    
    @RequestMapping("/add_user")
    public ModelAndView add_human(HttpServletRequest request) {
	 
		ModelAndView model = new ModelAndView("add_user");
		
		return model;
		
    }
    
    @Scope("session")
    @RequestMapping(value="/save_user", method = RequestMethod.POST)
	public String saveUser(Locale locale, Model model, HttpServletRequest request){
    	
        try {
        	
        	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
        	CompanyDAO companyDAO = (CompanyDAO) context.getBean("companyDAO");
        	
        	String sql = "";
				
        	String Name = request.getParameter("Name");
        	String Email = request.getParameter("Email");
            String Password = request.getParameter("Password");
            String Access = request.getParameter("Access");
            
            sql = "INSERT INTO user (Name, Email, Password, Access) VALUES ('"+Name+"', '"+Email+"', '"+Password+"', '"+Access+"')";
            System.out.println(sql);
            companyDAO.insertUser(sql);
        	
        } catch (Throwable q) {
        	
        }
        return "redirect:/admin";	
	}
    
    @RequestMapping("/edit_user")
    public ModelAndView edit_customer(HttpServletRequest request) {
	 	int ID = Integer.parseInt(request.getParameter("userID"));
	 	
	 	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

		CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
		Map<Integer,HashMap<String,String>> ResultMap = new HashMap<Integer, HashMap<String,String>>();
        ResultMap = customerDAO.SQLquery("SELECT * FROM user WHERE ID = "+ID);
		System.out.println(ResultMap);
		
		ModelAndView model = new ModelAndView("edit_user");
		
		model.addObject("ResultMap", ResultMap.get(0));
		
		return model;
    }
    
    @Scope("session")
    @RequestMapping(value="/save_edited_user", method = RequestMethod.POST)
	public String editCustomer(Locale locale, Model model, HttpServletRequest request){
    	
        try {
        	
        	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
        	CompanyDAO companyDAO = (CompanyDAO) context.getBean("companyDAO");
        	
            int ID = Integer.parseInt(request.getParameter("ID"));
        	String Name = request.getParameter("Name").toString();
            String Email = request.getParameter("Email");
            String Password = request.getParameter("Password");
            String Access = request.getParameter("Access");
           
            String sql = "UPDATE user SET " 
	    				+ "  NAME     = '"+Name+"'"
	    				+ ", Email    = '"+Email+"'"
	    				+ ", Password = '"+Password+"'"
	    				+ ", Access   = '"+Access+"'"
	    				+ "  WHERE ID = "+ID;
            
            companyDAO.update(sql);
        	
        } catch (Throwable q) {
        	
        }
        return "redirect:/admin";	
	}
    
    @Scope("session")
    @RequestMapping(value="/delete_user", method = RequestMethod.GET)
	public String deleteCustomer(Locale locale, Model model, HttpServletRequest request){
    	
        try {
        	
        	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
        	CompanyDAO companyDAO = (CompanyDAO) context.getBean("companyDAO");
        	
            int ID = Integer.parseInt(request.getParameter("id"));
            String sql = "DELETE FROM user WHERE ID = "+ID;
            
            companyDAO.deleteManual(sql);
        } catch (Throwable q) {
        	
        }
        return "redirect:/admin";	
	}
    
    @Scope("session")
    @RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Locale locale, Model model, HttpServletRequest request){
    	
    	ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        attr.getRequest().getSession(true).getAttribute("Auth");
        
        try {
        	
        	 String Session = attr.getRequest().getSession().getAttribute("Auth").toString();
        	 if(Auth.checkAuth(Session)){
        		 request.getSession().removeAttribute("Auth");
        	 }
		    
        } catch (Throwable q) {
        	
        }
        return "redirect:/dashboard";	
	}
    
    @Scope("session")
    @RequestMapping(value = {"/companies"}, method = RequestMethod.GET)
    public String company(Locale locale, Model model, HttpServletRequest request, HttpSession httpSession) {
		
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        attr.getRequest().getSession(true).getAttribute("Auth");
        
        try {
        	
            String Session = attr.getRequest().getSession().getAttribute("Auth").toString();
            
        	if(Auth.checkAuth(Session)){
        		
        		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
           	 
                CompanyDAO companyDAO = (CompanyDAO) context.getBean("companyDAO");
                
                CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
                
                Map<Integer,HashMap<String,String>> ResultMap = new HashMap<Integer, HashMap<String,String>>();
                ResultMap = customerDAO.SQLquery("SELECT * FROM CUSTOMER WHERE Assigned != \"\" ");
                
                List<Company> companyList = new ArrayList<Company>();

                int limit = 15;
                companyList = companyDAO.findCompany(limit, 0);
                
                int count = companyDAO.countCompany();
                int pagination = (int)Math.ceil(count / limit);
                System.out.println(pagination);
                System.out.println(companyList);
                model.addAttribute("pagination", pagination);
                model.addAttribute("companyList", companyList);
                model.addAttribute("page-title", "Home");
                model.addAttribute("CustomerList", ResultMap);

                return "company";
        	} else {
        		return "auth";
        	}
        	
        } catch (Throwable t) {

            return "auth";
            
        }
    	
    }
    
}