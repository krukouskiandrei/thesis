package by.krukouski.thesisfront.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.krukouski.PrimeNumberThread;
import by.krukouski.core.prime.exceptions.AlgorithmServiceExeption;
import by.krukouski.core.service.AlgorithmService;
import by.krukouski.thesisfront.dto.AlgorithmInfoDTO;
import by.krukouski.thesisfront.dto.AlgorithmTimeInfo;

@Controller
public class MainController {

	@Autowired
	AlgorithmService algorithmService;
	
	PrimeNumberThread thread = new PrimeNumberThread();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mainPage(Model model) {
		model.addAttribute(new AlgorithmInfoDTO());
		if(!thread.isAlive()){
			thread.start();
		}
		return "primerecognaizer";
	}
	
	@RequestMapping(value = "bignumbers", method = RequestMethod.GET)
	public String getBigNumberPage(Model model) {
		BigInteger primeNumber = thread.getPrimeNumber();
		model.addAttribute("primeNumber", primeNumber);
		return "bigprimenumbers";
	}
	
	@RequestMapping(value = "checkNumber", method = RequestMethod.POST)
	public String checkNumber(@Valid AlgorithmInfoDTO algorithmInfo, BindingResult result, Model model) {
		if(result.hasErrors()){
			return "primerecognaizer";
		}
		boolean testResult = false;
		List<AlgorithmTimeInfo> timeInfo = new ArrayList<AlgorithmTimeInfo>();
		try{
			testResult = algorithmService.probabilityTest(algorithmInfo, timeInfo);
		} catch(AlgorithmServiceExeption e) {
			//throw Exception
		}
		model.addAttribute(new AlgorithmInfoDTO());
		model.addAttribute("testResult", testResult);
		model.addAttribute("number", algorithmInfo.getNumber());
		model.addAttribute("timeInfo", timeInfo);
		return "primerecognaizer";
	}
	
}
