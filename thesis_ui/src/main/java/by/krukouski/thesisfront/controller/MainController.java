package by.krukouski.thesisfront.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.krukouski.thesisfront.dto.AlgorithmInfo;

@Controller
public class MainController {

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mainPage(Model model) {
		model.addAttribute(new AlgorithmInfo());
		return "primerecognaizer";
	}
	
	@RequestMapping(value = "bignumbers", method = RequestMethod.GET)
	public String getBigNumberPage(Model model) {
		return "bigprimenumbers";
	}
	
	@RequestMapping(value = "checkNumber", method = RequestMethod.POST)
	public String checkNumber(@Valid AlgorithmInfo algorithmInfo, BindingResult result, Model model) {
		if(result.hasErrors()){
			return "primerecognaizer";
		}
		model.addAttribute(new AlgorithmInfo());
		return "primerecognaizer";
	}
	
}
