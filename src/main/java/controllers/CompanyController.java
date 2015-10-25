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

import jxl.write.WriteException;
import net.codejava.springmvc.dao.CompanyDAO;
import net.codejava.springmvc.dao.CustomerDAO;
import net.codejava.springmvc.dao.IndustryDAO;
import net.codejava.springmvc.model.Company;
import net.codejava.springmvc.model.Customer;
import net.codejava.springmvc.model.Industry;
import net.codejava.springmvc.Auth;

import models.WriteExcel;
import models.FirstPdf;
import models.SimpleReportExample;

@Controller
public class CompanyController {
	
	Auth Auth = new Auth();

	@RequestMapping("/add_company")
    public ModelAndView add_human(HttpServletRequest request) {
	 
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		IndustryDAO industryDAO = (IndustryDAO) context.getBean("industryDAO");
		 List<Industry> industries = new ArrayList<Industry>();

         int limit = 15;
         industries = industryDAO.getIndustriesList();
		
		ModelAndView model = new ModelAndView("add_company");
		model.addObject("industryList", industries);
		return model;
		
    }
	
	@Scope("session")
    @RequestMapping(value="/save_company", method = RequestMethod.POST)
	public String addCustomer(Locale locale, Model model, HttpServletRequest request){
    	
        try {
        	
        	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
        	CompanyDAO companyDAO = (CompanyDAO) context.getBean("companyDAO");
        	
            int ID = 0;
        	String name = request.getParameter("name").toString();
        	String industry = request.getParameter("industry");
            String country = request.getParameter("country");
            
            Company company = new Company(ID, name, industry, country);
            companyDAO.insert(company);
        	
        } catch (Throwable q) {
        	
        }
        return "redirect:/companies";	
	}
	
	@RequestMapping("/edit_company")
    public ModelAndView edit_customer(HttpServletRequest request) {
	 	int ID = Integer.parseInt(request.getParameter("companyID"));
	 	
	 	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

        Map<String,String> company = new HashMap<String,String>();
   	 
        CompanyDAO companyDAO = (CompanyDAO) context.getBean("companyDAO");
     
        company = companyDAO.findCurrentCompanyById(ID);
        
		IndustryDAO industryDAO = (IndustryDAO) context.getBean("industryDAO");
		List<Industry> industries = new ArrayList<Industry>();
		industries = industryDAO.getIndustriesList();
		
		CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
		Map<Integer,HashMap<String,String>> ResultMap = new HashMap<Integer, HashMap<String,String>>();
        ResultMap = customerDAO.SQLquery("SELECT * FROM companies WHERE ID = "+ID);
		System.out.println(ResultMap);
		
		ModelAndView model = new ModelAndView("edit_company");
		model.addObject("companyData", company);
		model.addObject("industryList", industries);
		model.addObject("ResultMap", ResultMap.get(0));
		/**
		 * 	<c:forEach items="${countries}" var="country">
	     * 	<option value="${country.key}">${country.value}</option>
	     *	</c:forEach>
		 */
		return model;
    }
	
	@Scope("session")
    @RequestMapping(value="/save_edited_company", method = RequestMethod.POST)
	public String editCustomer(Locale locale, Model model, HttpServletRequest request){
    	
        try {
        	
        	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
        	CompanyDAO companyDAO = (CompanyDAO) context.getBean("companyDAO");
        	
            int ID = Integer.parseInt(request.getParameter("ID"));
        	String name = request.getParameter("name").toString();
            String industry = request.getParameter("industry");
            String country = request.getParameter("country");
            String From = request.getParameter("ageFrom");
            String To = request.getParameter("ageTo");
            String Gender = request.getParameter("Gender");
            String requireCountry = request.getParameter("requireCountry");
            String City = request.getParameter("City");
            String Experience = request.getParameter("Experience");
            String Education = request.getParameter("Education");
            String Count = request.getParameter("Count");
            
            HashMap<String,String> HashMap = new HashMap<String, String>();
            HashMap.put("ID", Integer.toString(ID));
            HashMap.put("Name", name);
            HashMap.put("Country", country);
            HashMap.put("Industry", industry);
            HashMap.put("Gender", Gender);
            HashMap.put("City", City);
            HashMap.put("requireCountry", requireCountry);
            HashMap.put("From", From);
            HashMap.put("To", To);
            HashMap.put("Experience", Experience);
            HashMap.put("Education", Education);
            HashMap.put("Count", Count);
            
            String sql = "UPDATE companies SET " +
    				"NAME = '"+HashMap.get("Name")+"'"
    				+ ", Gender = '"+HashMap.get("Gender")+"'"
    				+ ", Country = '"+HashMap.get("Country")+"'"
    				+ ", Industry = '"+HashMap.get("Industry")+"'"
    				+ ", City = '"+HashMap.get("City")+"'"
    				+ ", requireCountry = '"+HashMap.get("requireCountry")+"'"
    				+ ", companies.From = '"+HashMap.get("From")+"'"
    				+ ", companies.To = '"+HashMap.get("To")+"'"
    				+ ", Experience = '"+HashMap.get("Experience")+"'"
    				+ ", Education = '"+HashMap.get("Education")+"'"
    				+ ", Count = '"+HashMap.get("Count")+"'"
    				+ " WHERE ID = "+HashMap.get("ID");
            
            companyDAO.update(sql);
        	
        } catch (Throwable q) {
        	
        }
        return "redirect:/companies";	
	}
	
	@Scope("session")
    @RequestMapping(value="/delete_company", method = RequestMethod.GET)
	public String deleteCustomer(Locale locale, Model model, HttpServletRequest request){
    	
        try {
        	
        	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
        	CompanyDAO companyDAO = (CompanyDAO) context.getBean("companyDAO");
        	
            int ID = Integer.parseInt(request.getParameter("id"));
            companyDAO.delete(ID);
        
        } catch (Throwable q) {
        	
        }
        return "redirect:/companies";	
	}
	
	@RequestMapping(value = "/printCustomerList",headers = "Accept=application/json",  method = RequestMethod.POST,  produces="text/plain")
	@ResponseBody
    public String print_customerList(HttpServletRequest request) throws WriteException, IOException {
	 	String pdf_data = request.getParameter("pdf").toString();
	 	FirstPdf pdf = new FirstPdf();
		String link = pdf.writePdfFromHtml(pdf_data, "test2");
		
		return link;
    }
	
	@RequestMapping("/getHumans")
    public ModelAndView getHumans(HttpServletRequest request) {
	 	
	 	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

		IndustryDAO industryDAO = (IndustryDAO) context.getBean("industryDAO");
		List<Industry> industries = new ArrayList<Industry>();
		industries = industryDAO.getIndustriesList();
		
		CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
		Map<Integer,HashMap<String,String>> ResultMap = new HashMap<Integer, HashMap<String,String>>();
        ResultMap = customerDAO.SQLquery("SELECT * FROM customer");
		

		//WriteExcel excel = new WriteExcel(ResultMap);
		
        
		ModelAndView model = new ModelAndView("list2pdf");
		model.addObject("industryList", industries);
		model.addObject("ResultMap", ResultMap);
		return model;
    }
	
	@RequestMapping(value = "/printExcel",headers = "Accept=application/json",  method = RequestMethod.GET,  produces="text/plain")
	@ResponseBody
    public String writeExcel(HttpServletRequest request) throws WriteException, IOException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
		Map<Integer,HashMap<String,String>> ResultMap = new HashMap<Integer, HashMap<String,String>>();
        ResultMap = customerDAO.SQLquery("SELECT * FROM customer");
		
        WriteExcel excel = new WriteExcel(ResultMap);
        
		return "Ok";
    }
	
	
	@RequestMapping(value = "/printJasper",headers = "Accept=application/json",  method = RequestMethod.GET,  produces="text/plain")
	@ResponseBody
    public String writeJasper(HttpServletRequest request) throws WriteException, IOException {
		
        SimpleReportExample JReports = new SimpleReportExample();
		
		return "Ok";
    }
}
