package controllers;

import net.codejava.springmvc.Circle;
import net.codejava.springmvc.Shape;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.ui.Model;

@Controller
public class MainController {


	/*@Autowired
	@Qualifier("shake")
	private Shape Sk;
	
	@Autowired
	@Qualifier("circle")
	private Shape Sc;*/
	
	@Autowired
	@Qualifier("circle")
	public Shape circle;
	

	
	public MainController()
		{
		
		
		}
	
	public static final String BACE_PAGE = "/base-template.page";
    public static final String BACE_VIEW = "base-template";
	
	public static final String INDEX_PAGE = "/index.page";
    public static final String INDEX_VIEW = "main";

    public static final String INFO_PAGE = "/info.page";
    public static final String INFO_VIEW = "info";

    @RequestMapping(value=BACE_PAGE)
    public ModelAndView base(Model model) {

    	model.addAttribute("title", "Message from main controller to main page!");

       model.addAttribute("message", "Message from main controller to main page!");

       return new ModelAndView(BACE_VIEW);
   }
    
    @RequestMapping(value=INDEX_PAGE)
     public ModelAndView index(Model model) {

        model.addAttribute("message", "Message from main controller to main page!");

        return new ModelAndView(INDEX_VIEW);
    }

    @RequestMapping(value=INFO_PAGE)
     public ModelAndView info(Model model) {

        model.addAttribute("message", "Message from main controller to info page!");

        return new ModelAndView(INFO_VIEW);
    }
	
	
	
	@RequestMapping(value="/default.page", method = RequestMethod.GET)
	public ModelAndView defaultShape()
		{
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("message", circle.square());
			modelAndView.addObject("perimeter", circle.square());
			
			modelAndView.setViewName("view");
			
			return modelAndView;
		}
	
	/*@RequestMapping(value="/shape", method = RequestMethod.GET)
	public ModelAndView shape(HttpServletRequest request)
		{
			
			double radius = Double.parseDouble(request.getParameter("radius"));
		
			Shape circle = new Circle(radius);
			
			this.modelAndView.addObject("message", username);
			this.modelAndView.addObject("perimeter", username);
			
			this.modelAndView.setViewName("view");
			
			return this.modelAndView;
		}
	
	@RequestMapping(value="/shake", method = RequestMethod.GET)
	public ModelAndView shake()
		{
			
			this.modelAndView.addObject("message", Sk.square());
			this.modelAndView.addObject("perimeter", Sh.perimeter());
			
			this.modelAndView.setViewName("view");
			
			return this.modelAndView;
		}*/
	
	@RequestMapping(value="/circle.page", method = RequestMethod.POST)
	public ModelAndView circle(HttpServletRequest request)
		{
			ModelAndView modelAndView = new ModelAndView();
			
			double radius = Double.parseDouble(request.getParameter("radius"));
		
			Shape circle = new Circle(radius);
			
			modelAndView.addObject("message", circle.square());
			modelAndView.addObject("perimeter", circle.square());
			
			modelAndView.setViewName("view");
			
			return modelAndView;
		}
	
}
