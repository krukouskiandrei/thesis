package by.krukouski.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.krukouski.core.prime.algorithms.ProbabilityAlgorithm;
import by.krukouski.core.prime.exceptions.AlgorithmServiceExeption;
import by.krukouski.core.prime.exceptions.ProbabilityAlgorithmException;
import by.krukouski.core.prime.symbols.Symbols;
import by.krukouski.core.service.AlgorithmService;
import by.krukouski.core.utils.TimeTracker;
import by.krukouski.thesisfront.dto.AlgorithmInfoDTO;
import by.krukouski.thesisfront.dto.AlgorithmTimeInfo;
import by.krukouski.thesisfront.dto.PrimeNumberInfo;

@Service
public class AlgorithmServiceImpl implements AlgorithmService{

	@Autowired
	@Qualifier("definitionsJacobiAlgorithm")
	Symbols definitionsJacobiAlgorithm;
	
	@Autowired
	@Qualifier("binaryJacobiAlgorithm")
	Symbols binaryJacobiAlgorithm;
	
	@Autowired
	@Qualifier("ordinaryJacobiAlgorithm")
	Symbols ordinaryJacobiAlgorithm;
	
	@Autowired
	@Qualifier("lebesgueJacobiAlgorithm")
	Symbols lebesgueJacobiAlgorithm;
	
	@Autowired
	@Qualifier("mlognJacobiAlgorithm")
	Symbols mlognJacobiAlgorithm;
	
	@Autowired
	@Qualifier("solovayStrassenTest")
	ProbabilityAlgorithm solovayStrassenTest;
	
	@Autowired
	@Qualifier("millerRabinTest")
	ProbabilityAlgorithm millerRabinTest;
	
	public boolean probabilityTest(AlgorithmInfoDTO algorithmInfoDTO, List<AlgorithmTimeInfo> timeInfo) throws AlgorithmServiceExeption {
		boolean result = false;
		
		if(algorithmInfoDTO.getAllAlgorithms()) {
			return checkAllTests(algorithmInfoDTO, timeInfo);
		}
		
		PrimeNumberInfo primeNumberInfo = parseAlgorithmInfo(algorithmInfoDTO);
		try{
			if(algorithmInfoDTO.getTestName().equals("SS")) {
				result = solovayStrassenTest.checkNumber(primeNumberInfo);
				AlgorithmTimeInfo algorithmTimeInfo = new AlgorithmTimeInfo();
				if(algorithmInfoDTO.getJacobiAlgorithm().equals("AD")) {
					algorithmTimeInfo.setName("S-S, definition algorithm");
				} else if(algorithmInfoDTO.getJacobiAlgorithm().equals("BA")) {
					algorithmTimeInfo.setName("S-S, binary algorithm");
				} else if(algorithmInfoDTO.getJacobiAlgorithm().equals("UA")) {
					algorithmTimeInfo.setName("S-S, ordinary algorithm");
				} else if(algorithmInfoDTO.getJacobiAlgorithm().equals("AL")) {
					algorithmTimeInfo.setName("S-S, lebesgue algorithm");
				} else {
					algorithmTimeInfo.setName("S-S, MLogN algorithm");
				}
				algorithmTimeInfo.setDuration(TimeTracker.getInstance().getDuration().toMillis());
				timeInfo.add(algorithmTimeInfo);
			}else {
				result = millerRabinTest.checkNumber(primeNumberInfo);
				AlgorithmTimeInfo algorithmTimeInfo = new AlgorithmTimeInfo();
				algorithmTimeInfo.setName("M-R");
				algorithmTimeInfo.setDuration(TimeTracker.getInstance().getDuration().toMillis());
				timeInfo.add(algorithmTimeInfo);
			}
		}catch(ProbabilityAlgorithmException e) {
			System.out.println("Errrrorrororror!!!!!!!!");
			throw new AlgorithmServiceExeption();
		}
		
		return result;
	}
	
	private boolean checkAllTests(AlgorithmInfoDTO algorithmInfoDTO, List<AlgorithmTimeInfo> timeInfo) throws AlgorithmServiceExeption {
		boolean result = false;
		
		PrimeNumberInfo primeNumberInfo = parseAlgorithmInfo(algorithmInfoDTO);
		try{
			/*AlgorithmTimeInfo algorithmTimeInfo1 = new AlgorithmTimeInfo();*/
			
			primeNumberInfo.setProbability(algorithmInfoDTO.getProbability(), 2);
			
			/*primeNumberInfo.setJacobiAlgorithm(definitionsJacobiAlgorithm);
			result = solovayStrassenTest.checkNumber(primeNumberInfo);
			algorithmTimeInfo1.setName("DA");
			algorithmTimeInfo1.setDuration(TimeTracker.getInstance().getDuration().toMillis());
			timeInfo.add(algorithmTimeInfo1);*/
			
			AlgorithmTimeInfo algorithmTimeInfo2 = new AlgorithmTimeInfo();
			
			primeNumberInfo.setJacobiAlgorithm(binaryJacobiAlgorithm);
			result = solovayStrassenTest.checkNumber(primeNumberInfo);
			algorithmTimeInfo2.setName("BA");
			algorithmTimeInfo2.setDuration(TimeTracker.getInstance().getDuration().toMillis());
			timeInfo.add(algorithmTimeInfo2);
			
			AlgorithmTimeInfo algorithmTimeInfo3 = new AlgorithmTimeInfo();
			
			primeNumberInfo.setJacobiAlgorithm(ordinaryJacobiAlgorithm);
			result = solovayStrassenTest.checkNumber(primeNumberInfo);
			algorithmTimeInfo3.setName("OA");
			algorithmTimeInfo3.setDuration(TimeTracker.getInstance().getDuration().toMillis());
			timeInfo.add(algorithmTimeInfo3);
			
			AlgorithmTimeInfo algorithmTimeInfo4 = new AlgorithmTimeInfo();
			
			primeNumberInfo.setJacobiAlgorithm(lebesgueJacobiAlgorithm);
			result = solovayStrassenTest.checkNumber(primeNumberInfo);
			algorithmTimeInfo4.setName("LA");
			algorithmTimeInfo4.setDuration(TimeTracker.getInstance().getDuration().toMillis());
			timeInfo.add(algorithmTimeInfo4);
			
			AlgorithmTimeInfo algorithmTimeInfo6 = new AlgorithmTimeInfo();
			
			primeNumberInfo.setJacobiAlgorithm(mlognJacobiAlgorithm);
			result = solovayStrassenTest.checkNumber(primeNumberInfo);
			algorithmTimeInfo6.setName("LogA");
			algorithmTimeInfo6.setDuration(TimeTracker.getInstance().getDuration().toMillis());
			timeInfo.add(algorithmTimeInfo6);
			
			primeNumberInfo.setProbability(algorithmInfoDTO.getProbability(), 4);
			
			AlgorithmTimeInfo algorithmTimeInfo5 = new AlgorithmTimeInfo();
			
			result = millerRabinTest.checkNumber(primeNumberInfo);
			algorithmTimeInfo5.setName("M-R");
			algorithmTimeInfo5.setDuration(TimeTracker.getInstance().getDuration().toMillis());
			timeInfo.add(algorithmTimeInfo5);			
				
			
		}catch(ProbabilityAlgorithmException e) {
			System.out.println("Errrrorrororror!!!!!!!!");
			throw new AlgorithmServiceExeption();
		}
		return result;
	}

	private PrimeNumberInfo parseAlgorithmInfo(AlgorithmInfoDTO algorithmInfoDTO) {
		PrimeNumberInfo primeNumberInfo = new PrimeNumberInfo();
		
		primeNumberInfo.setPrimeNumber(algorithmInfoDTO.getNumber());
		
		if(algorithmInfoDTO.getTestName().equals("SS")) {
			primeNumberInfo.setProbability(algorithmInfoDTO.getProbability(), 2);
			if(algorithmInfoDTO.getJacobiAlgorithm().equals("AD")) {
				primeNumberInfo.setJacobiAlgorithm(definitionsJacobiAlgorithm);
			} else if(algorithmInfoDTO.getJacobiAlgorithm().equals("BA")) {
				primeNumberInfo.setJacobiAlgorithm(binaryJacobiAlgorithm);
			} else if(algorithmInfoDTO.getJacobiAlgorithm().equals("UA")) {
				primeNumberInfo.setJacobiAlgorithm(ordinaryJacobiAlgorithm);
			} else if(algorithmInfoDTO.getJacobiAlgorithm().equals("AL")) {
				primeNumberInfo.setJacobiAlgorithm(lebesgueJacobiAlgorithm);
			} else {
				primeNumberInfo.setJacobiAlgorithm(mlognJacobiAlgorithm);
			}
		} else {
			primeNumberInfo.setProbability(algorithmInfoDTO.getProbability(), 4);
		}
		return primeNumberInfo;
	}
	
}
