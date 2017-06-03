package by.krukouski.core.service;

import java.util.List;

import by.krukouski.core.prime.exceptions.AlgorithmServiceExeption;
import by.krukouski.thesisfront.dto.AlgorithmInfoDTO;
import by.krukouski.thesisfront.dto.AlgorithmTimeInfo;

public interface AlgorithmService {

	public boolean probabilityTest(AlgorithmInfoDTO algorithmInfoDTO, List<AlgorithmTimeInfo> timeInfo) throws AlgorithmServiceExeption;	
}
