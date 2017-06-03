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
	@Qualifier("solovayStrassenTest")
	ProbabilityAlgorithm solovayStrassenTest;
	
	@Autowired
	@Qualifier("millerRabinTest")
	ProbabilityAlgorithm millerRabinTest;
	
	public boolean probabilityTest(AlgorithmInfoDTO algorithmInfoDTO, List<AlgorithmTimeInfo> timeInfo) throws AlgorithmServiceExeption {
		boolean result = false;;
		PrimeNumberInfo primeNumberInfo = parseAlgorithmInfo(algorithmInfoDTO);
		try{
			if(algorithmInfoDTO.getTestName().equals("SS")) {
				result = solovayStrassenTest.checkNumber(primeNumberInfo);
				AlgorithmTimeInfo algorithmTimeInfo = new AlgorithmTimeInfo();
				if(algorithmInfoDTO.getJacobiAlgorithm().equals("AD")) {
					algorithmTimeInfo.setName("S-S, definition algorithm");
				} else if(algorithmInfoDTO.getJacobiAlgorithm().equals("BA")) {
					algorithmTimeInfo.setName("S-S, binary algorithm");
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

	private PrimeNumberInfo parseAlgorithmInfo(AlgorithmInfoDTO algorithmInfoDTO) {
		PrimeNumberInfo primeNumberInfo = new PrimeNumberInfo();
		
		primeNumberInfo.setPrimeNumber(algorithmInfoDTO.getNumber());
		
		if(algorithmInfoDTO.getTestName().equals("SS")) {
			primeNumberInfo.setProbability(algorithmInfoDTO.getProbability(), 2);
			if(algorithmInfoDTO.getJacobiAlgorithm().equals("AD")) {
				primeNumberInfo.setJacobiAlgorithm(definitionsJacobiAlgorithm);
			} else {
				primeNumberInfo.setJacobiAlgorithm(binaryJacobiAlgorithm);
			}			
		} else {
			primeNumberInfo.setProbability(algorithmInfoDTO.getProbability(), 4);
		}
		return primeNumberInfo;
	}
	
}
