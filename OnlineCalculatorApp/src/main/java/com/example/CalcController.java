package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {
	@Autowired
CalcService cls;
	

	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@PostMapping("/calculate")
	public String performOperation(@RequestParam("n1") double n1,@RequestParam("n2") double n2,@RequestParam("operation") String opt,Model model) {
		double res;
		switch(opt) {
		
		case "add" -> res=cls.add(n1, n2);
		case "sub"-> res=cls.sub(n1, n2);
		case "mul"->res=cls.mul(n1, n2);
		case "div"->res=cls.div(n1, n2);
		case "mod"->res=cls.mod(n1, n2);
		default ->{
			model.addAttribute("error", "Invalid Opertion");
			return "result";
		}
		
		}
		
		model.addAttribute("res", res);
		model.addAttribute("operation", opt);
		return "result";
		
		
		
		
	
	}
	
	
	
}
