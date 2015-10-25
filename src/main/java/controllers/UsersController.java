package controllers;

import java.text.DateFormat;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.springmvc.dao.CompanyDAO;
import net.codejava.springmvc.dao.CustomerDAO;
import net.codejava.springmvc.dao.IndustryDAO;
import net.codejava.springmvc.model.Customer;
import net.codejava.springmvc.model.Industry;
import net.codejava.springmvc.model.User;

import models.FirstPdf;

@Controller
public class UsersController {

	 
	 @RequestMapping("/list")
	    public ModelAndView home(HttpServletRequest request) {
		 	int page = Integer.parseInt(request.getParameter("page"));
		 	System.out.println(page);
		 	
		 	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
          	 
            CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
            
            List<Customer> customerList = new ArrayList<Customer>();

            int limit = 15;
            int offset = limit * page;
            
            customerList = customerDAO.findCustomers(limit, offset);
		 	
			ModelAndView model = new ModelAndView("list");
			model.addObject("customerList", customerList);

			
			return model;
	    }
	 
	 @RequestMapping("/edit_customer")
	    public ModelAndView edit_customer(HttpServletRequest request) {
		 	int ID = Integer.parseInt(request.getParameter("userID"));
		 	
		 	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

	        Map<String,String> user = new HashMap<String,String>();
       	 
	        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
         
	        user = customerDAO.findCurrentCustomerById(ID);
	        
	        IndustryDAO industryDAO = (IndustryDAO) context.getBean("industryDAO");
			List<Industry> industries = new ArrayList<Industry>();
			industries = industryDAO.getIndustriesList();
		 	
			ModelAndView model = new ModelAndView("edit_customer");
			model.addObject("userData", user);
			model.addObject("industryList", industries);
			/**
			 * 	<c:forEach items="${countries}" var="country">
		     * 	<option value="${country.key}">${country.value}</option>
		     *	</c:forEach>
			 */
			return model;
	    }
	 
	 @RequestMapping("/add_human")
	    public ModelAndView add_human(HttpServletRequest request) {
		 
			ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
			IndustryDAO industryDAO = (IndustryDAO) context.getBean("industryDAO");
			List<Industry> industries = new ArrayList<Industry>();
			industries = industryDAO.getIndustriesList();
			
			ModelAndView model = new ModelAndView("add_customer");
			model.addObject("industryList", industries);
			
			
			return model;
			
	    }
	 
	 @Scope("session")
	    @RequestMapping(value="/save_edit_customer", method = RequestMethod.POST)
		public String editCustomer(Locale locale, Model model, HttpServletRequest request){
	    	
	        try {
	        	
	        	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	        	CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
	        	
	            int ID = Integer.parseInt(request.getParameter("ID"));
	        	String name = request.getParameter("name").toString();
	            int age = Integer.parseInt(request.getParameter("age"));
	            String industry = request.getParameter("industry").toString();
	            String LastName = request.getParameter("LastName").toString();
	            String Gender = request.getParameter("Gender").toString();
	            String Phone = request.getParameter("Phone").toString();
	            String Email = request.getParameter("Email").toString();
	            String Country = request.getParameter("Country").toString();
	            String City = request.getParameter("City").toString();
	            String Experience = request.getParameter("Experience").toString();
	            String Education = request.getParameter("Education").toString();
	            
	            HashMap<String,String> HashMap = new HashMap<String, String>();
	            HashMap.put("ID", Integer.toString(ID));
	            HashMap.put("Name", name);
	            HashMap.put("Age", Integer.toString(age));
	            HashMap.put("Industry", industry);
	            HashMap.put("LastName", LastName);
	            HashMap.put("Gender", Gender);
	            HashMap.put("Phone", Phone);
	            HashMap.put("Email", Email);
	            HashMap.put("Country", Country);
	            HashMap.put("City", City);
	            HashMap.put("Experience", Experience);
	            HashMap.put("Education", Education);
	            
	            //Customer user = new Customer(ID, name, age);
	            System.out.println(HashMap);
	            customerDAO.update(HashMap);
	        	
	        } catch (Throwable q) {
	        	System.out.println(q);
	        }
	        return "redirect:/humans";	
		}
	 
	 @Scope("session")
	    @RequestMapping(value="/add_customer", method = RequestMethod.POST)
		public String addCustomer(Locale locale, Model model, HttpServletRequest request){
	    	
	        try {
	        	
	        	/**/
	        	
	        	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	        	CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
	        	
	            int ID = 0;
	            String name = request.getParameter("name").toString();
	            int age = Integer.parseInt(request.getParameter("age"));
	            String industry = request.getParameter("industry").toString();
	            String LastName = request.getParameter("LastName").toString();
	            String Gender = request.getParameter("Gender").toString();
	            String Phone = request.getParameter("Phone").toString();
	            String Email = request.getParameter("Email").toString();
	            String Country = request.getParameter("Country").toString();
	            String City = request.getParameter("City").toString();
	            String Experience = request.getParameter("Experience").toString();
	            String Education = request.getParameter("Education").toString();
	            
	            HashMap<String,String> HashMap = new HashMap<String, String>();
	            HashMap.put("ID", Integer.toString(ID));
	            HashMap.put("Name", name);
	            HashMap.put("Age", Integer.toString(age));
	            HashMap.put("Industry", industry);
	            HashMap.put("LastName", LastName);
	            HashMap.put("Gender", Gender);
	            HashMap.put("Phone", Phone);
	            HashMap.put("Email", Email);
	            HashMap.put("Country", Country);
	            HashMap.put("City", City);
	            HashMap.put("Experience", Experience);
	            HashMap.put("Education", Education);
	            
	            customerDAO.insert(HashMap);
	        	
	        } catch (Throwable q) {
	        	
	        }
	        return "redirect:/humans";	
		}
	 
	 @Scope("session")
	    @RequestMapping(value="/delete_customer", method = RequestMethod.GET)
		public String deleteCustomer(Locale locale, Model model, HttpServletRequest request){
	    	
	        try {
	        	
	        	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	        	CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
	        	
	            int ID = Integer.parseInt(request.getParameter("id"));
	            System.out.println(ID);
	        	/*String name = request.getParameter("name").toString();
	            int age = Integer.parseInt(request.getParameter("age"));
	            
	            Customer user = new Customer(ID, name, age);*/
	            customerDAO.delete(ID);
	        
	        } catch (Throwable q) {
	        	
	        }
	        return "redirect:/humans";	
		}
	 
	 @Scope("session")
	    @RequestMapping(value="/unjoin_company", method = RequestMethod.GET)
		public String unjoinCustomer(Locale locale, Model model, HttpServletRequest request){
	    	
	        try {
	        	
	        	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	        	CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
	        	
	            int ID = Integer.parseInt(request.getParameter("id"));
	        	/*String name = request.getParameter("name").toString();
	            int age = Integer.parseInt(request.getParameter("age"));
	            
	            Customer user = new Customer(ID, name, age);*/

	            String sql = "UPDATE customer SET Assigned = \"\" WHERE CUST_ID = "+ID;
	            customerDAO.unjoinCustomer(sql);
	            
	            ID = Integer.parseInt(request.getParameter("companyID"));
	            sql = "UPDATE companies SET Count = Count + 1 WHERE ID = "+ID;
	            customerDAO.unjoinCustomer(sql);
	        
	        } catch (Throwable q) {
	        	
	        }
	        return "redirect:/companies";	
		}
	 
	 @Scope("session")
	    @RequestMapping(value = {"/search"}, method = RequestMethod.GET)
	    public String dashboard(Locale locale, Model model, HttpServletRequest request, HttpSession httpSession) {
	        
	        try {
	        	
	        	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	        	CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
	        	
	        	Map<Integer,HashMap<String,String>> ResultMap = new HashMap<Integer, HashMap<String,String>>();
                ResultMap = customerDAO.SQLquery("SELECT companies.*,  NameIndustry FROM companies LEFT JOIN industry"
				+ " ON companies.Industry = industry.ID ");
                System.out.println(ResultMap);
                
                Map<Integer,HashMap<String,String>> ResultIndustry = new HashMap<Integer, HashMap<String,String>>();
                ResultIndustry = customerDAO.SQLquery("SELECT * FROM industry");
                
                model.addAttribute("ResultMap", ResultMap);
                model.addAttribute("ResultIndustry", ResultIndustry);
	        	
	            return "search";
	        } catch (Throwable t) {

	        	System.out.println(t);
	            return "search";
	            
	        }
	    	
	    }
	 
	 @Scope("session")
	    @RequestMapping(value="/search_list", method = RequestMethod.GET)
		public ModelAndView searchList(HttpServletRequest request){
		 	
		 ModelAndView model = new ModelAndView("searchList");
	        try {
	        	
				String industry = request.getParameter("industry").toString();
				
				ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
				CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
				
				Map<Integer,HashMap<String,String>> ResultMap = new HashMap<Integer, HashMap<String,String>>();
                ResultMap = customerDAO.SQLquery("SELECT companies.*,  NameIndustry FROM companies LEFT JOIN industry"
				+ " ON companies.Industry = industry.ID WHERE companies.Industry = "+industry);
                
                
                
                model.addObject("ResultMap", ResultMap);
					
	        	
	        } catch (Throwable q) {

	        	return model;
	        }
	        return model;
		}
	 
	 @Scope("session")
	    @RequestMapping(value="/connect_human_company", method = RequestMethod.GET)
		public ModelAndView connectHumanCompany(HttpServletRequest request){
		 	
		 
		 ModelAndView model = new ModelAndView("searchByCompany");
	        try {
	        	
	        	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	        	CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
	        	CompanyDAO companyDAO = (CompanyDAO) context.getBean("companyDAO");
	        	
	            int ID = Integer.parseInt(request.getParameter("campaignID"));
	            int UserID = Integer.parseInt(request.getParameter("customerID"));
	        	
	            HashMap<String,String> HashMap = new HashMap<String, String>();
	            HashMap.put("ID", Integer.toString(ID));
	            
	            String sql = "UPDATE companies SET Count = Count -1 WHERE ID = "+ID;
	            
	            companyDAO.update(sql);
	            
	            sql = "UPDATE customer SET Assigned = '"+ID+"' WHERE CUST_ID = "+UserID;
	            
	            companyDAO.update(sql);
	            
	        } catch (Throwable q) {
	        	return model;
	        }
		 return model;
	 }
	 
	 @Scope("session")
	    @RequestMapping(value="/search_humans_params", method = RequestMethod.GET)
		public ModelAndView searchByCampaign(HttpServletRequest request){
		 	
		 ModelAndView model = new ModelAndView("searchByCompany");
	        try {
	        	
	        	String sql = "SELECT * FROM companies WHERE";
	        	
				
				sql += " ID = "+request.getParameter("ID");

	            //System.out.println(sql);
				ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
				CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
				
				Map<Integer,HashMap<String,String>> ResultMap = new HashMap<Integer, HashMap<String,String>>();
                ResultMap = customerDAO.SQLquery(sql);
                
                Map<String,String> searchMap = new HashMap<String,String>();
				searchMap = ResultMap.get(0);
				
				String FindSql = "SELECT * FROM customer WHERE";
				
				if(searchMap.get("Industry") != ""){
					FindSql += " `Industry` = '" + searchMap.get("Industry").trim() +"'";
					FindSql += " AND";
				}
				if(searchMap.get("Experience") != ""){
					FindSql += " `Experience` = '" + searchMap.get("Experience").trim() +"'";
					FindSql += " AND";
				}
				if(searchMap.get("Education") != ""){
					FindSql += " `Education` = '" + searchMap.get("Education").trim() +"'";
					FindSql += " AND";
				}
				if(searchMap.get("Country") != ""){
					FindSql += " `Country` = '" + searchMap.get("requireCountry").trim() +"'";
					FindSql += " AND";
				}
				if(searchMap.get("Gender") != ""){
					FindSql += " `Gender` = '" + searchMap.get("Gender").trim() +"'";
					FindSql += " AND";
				}
				if(searchMap.get("City") != ""){
					FindSql += " `City` = '" + searchMap.get("City").trim() +"'";
					FindSql += " AND";
				}
				if(searchMap.get("From") != ""){
					FindSql += " `AGE` >= " + searchMap.get("From") +"";
					FindSql += " AND";
					FindSql += " `AGE` <= " + searchMap.get("To") +"";
					FindSql += " AND";
				}
				FindSql += " CUST_ID > 0 AND Assigned = \"\" ";

				Map<Integer,HashMap<String,String>> ResultSearch = new HashMap<Integer, HashMap<String,String>>();
                ResultMap = customerDAO.SQLquery(FindSql);

				System.out.println(ResultMap);
				model.addObject("userData", ResultMap);
					
	        	
	        } catch (Throwable q) {

	        	return model;
	        }
	        return model;
		}
	 
	 private List<String> getList() {

			List<String> list = new ArrayList<String>();
			list.add("List A");
			list.add("List B");
			list.add("List C");
			list.add("List D");
			list.add("List 1");
			list.add("List 2");
			list.add("List 3");

			return list;

		}
}
