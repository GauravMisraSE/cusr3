package com.cmpe275.cusr.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpe275.cusr.model.Cancelledtrains;
import com.cmpe275.cusr.model.Trains;
import com.cmpe275.cusr.repositories.CancelledtrainsRepository;
import com.cmpe275.cusr.repositories.TrainsRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.*;


@Service
@Transactional
public class SearchService {

	@Autowired
	private TrainsRepository trainsRepository;
	@Autowired CancelledtrainsRepository cancelledtrainsRepository;

	public List<Trains> getAllTrains(){

		List<Trains> allTrains = new ArrayList<>();
		trainsRepository.findAll().forEach((allTrains::add));
		for(Trains t: allTrains){
			System.out.println(t.getName());
		}
		return allTrains;
	}
	
	public void setStations(List<Trains> trains, Character startStation, Character endStation)
	{
		for(Trains t: trains){
			t.setendStation(endStation);
			t.setstartStation(startStation);
		}
	}

	public List<Trains> searchTrains(Character startStation, String startTime, Character endStation, Character trainType, String date, String exactTime){

		
		Character direction = null;
		LocalTime st = LocalTime.parse(startTime);
		List<Trains> trains = null;
		List<Trains> trains2 = new ArrayList<>();
		if (Character.getNumericValue(startStation) - Character.getNumericValue(endStation) < 0)
			direction = 'S';
		else
			direction = 'N';
		System.out.println("direction: " + direction);
		System.out.println("trainType: " + trainType);
		System.out.println("endStation: " + endStation);
		System.out.println("startTime: " + startTime);
		System.out.println("startTime: " +exactTime);
	
		//System.out.println("endTime: " +endTime);
		//exact time and any
		if((trainType != null && trainType == 'A') && (exactTime != null && exactTime.equals("Y"))) {

			if (startStation == 'A') {
				trains = trainsRepository.findAnyByAExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'B') {
				trains = trainsRepository.findAnyByBExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'C') {
				trains = trainsRepository.findAnyByCExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'D') {
				trains = trainsRepository.findAnyByDExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'E') {
				trains = trainsRepository.findAnyByEExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'F') {
				trains = trainsRepository.findAnyByFExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'G') {
				trains = trainsRepository.findAnyByGExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'H') {
				trains = trainsRepository.findAnyByHExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'I') {
				trains = trainsRepository.findAnyByIExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'J') {
				trains = trainsRepository.findAnyByJExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'K') {
				trains = trainsRepository.findAnyByKExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'L') {
				trains = trainsRepository.findAnyByLExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'M') {
				trains = trainsRepository.findAnyByMExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'N') {
				trains = trainsRepository.findAnyByNExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'O') {
				trains = trainsRepository.findAnyByOExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'P') {
				trains = trainsRepository.findAnyByPExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'Q') {
				trains = trainsRepository.findAnyByQExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'R') {
				trains = trainsRepository.findAnyByRExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'S') {
				trains = trainsRepository.findAnyBySExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'T') {
				trains = trainsRepository.findAnyByTExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'U') {
				trains = trainsRepository.findAnyByUExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'V') {
				trains = trainsRepository.findAnyByVExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'W') {
				trains = trainsRepository.findAnyByWExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'X') {
				trains = trainsRepository.findAnyByXExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'Y') {
				trains = trainsRepository.findAnyByYExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'Z') {
				trains = trainsRepository.findAnyByZExact(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
		}
		else if (trainType != null && trainType == 'A') {
			if (startStation == 'A') {
				trains = trainsRepository.findAnyByA(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'B') {
				trains = trainsRepository.findAnyByB(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'C') {
				trains = trainsRepository.findAnyByC(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'D') {
				trains = trainsRepository.findAnyByD(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'E') {
				trains = trainsRepository.findAnyByE(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'F') {
				trains = trainsRepository.findAnyByF(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'G') {
				trains = trainsRepository.findAnyByG(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'H') {
				trains = trainsRepository.findAnyByH(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'I') {
				trains = trainsRepository.findAnyByI(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'J') {
				trains = trainsRepository.findAnyByJ(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'K') {
				trains = trainsRepository.findAnyByK(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'L') {
				trains = trainsRepository.findAnyByL(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'M') {
				trains = trainsRepository.findAnyByM(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'N') {
				trains = trainsRepository.findAnyByN(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'O') {
				trains = trainsRepository.findAnyByO(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'P') {
				trains = trainsRepository.findAnyByP(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'Q') {
				trains = trainsRepository.findAnyByQ(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'R') {
				trains = trainsRepository.findAnyByR(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'S') {
				trains = trainsRepository.findAnyByS(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'T') {
				trains = trainsRepository.findAnyByT(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'U') {
				trains = trainsRepository.findAnyByU(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'V') {
				trains = trainsRepository.findAnyByV(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'W') {
				trains = trainsRepository.findAnyByW(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'X') {
				trains = trainsRepository.findAnyByX(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'Y') {
				trains = trainsRepository.findAnyByY(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'Z') {
				trains = trainsRepository.findAnyByZ(direction,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
		}
		
		else {
		//Exact Time Check
		if(exactTime != null && exactTime.equals("Y"))
		{
			if (startStation == 'A') {
				trains = trainsRepository.findByA(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'B') {
				trains = trainsRepository.findByB(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'C') {
				trains = trainsRepository.findByC(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'D') {
				trains = trainsRepository.findByD(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'E') {
				trains = trainsRepository.findByE(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'F') {
				trains = trainsRepository.findByF(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'G') {
				trains = trainsRepository.findByG(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'H') {
				trains = trainsRepository.findByH(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'I') {
				trains = trainsRepository.findByI(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'J') {
				trains = trainsRepository.findByJ(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'K') {
				trains = trainsRepository.findByK(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'L') {
				trains = trainsRepository.findByL(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'M') {
				trains = trainsRepository.findByM(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'N') {
				trains = trainsRepository.findByN(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'O') {
				trains = trainsRepository.findByO(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'P') {
				trains = trainsRepository.findByP(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'Q') {
				trains = trainsRepository.findByQ(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'R') {
				trains = trainsRepository.findByR(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'S') {
				trains = trainsRepository.findByS(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'T') {
				trains = trainsRepository.findByT(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'U') {
				trains = trainsRepository.findByU(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'V') {
				trains = trainsRepository.findByV(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'W') {
				trains = trainsRepository.findByW(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'X') {
				trains = trainsRepository.findByX(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'Y') {
				trains = trainsRepository.findByY(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			if (startStation == 'Z') {
				trains = trainsRepository.findByZ(direction,trainType,endStation,startTime);
				setStations(trains,startStation,endStation);
			}
			
		}
		
		else
		{
		
		if (startStation == 'A') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndA(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'B') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndB(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'C') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndC(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'D') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndD(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'E') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndE(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'F') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndF(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'G') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndG(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'H') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndH(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'I') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndI(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'J') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndJ(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'K') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndK(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'L') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndL(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'M') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndM(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'N') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndN(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'O') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndO(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'P') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndP(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'Q') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndQ(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'R') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndR(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'S') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndS(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		
		if (startStation == 'T') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndT(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'U') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndU(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'V') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndV(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'W') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndW(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'X') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndX(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'Y') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndY(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'Z') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndZ(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		}
		}
		List<Cancelledtrains> ct = new ArrayList<>();
		cancelledtrainsRepository.findAll().forEach((ct::add));
		for (Cancelledtrains c: ct){

			if (date.equals(c.getDate())){

				for (Trains t: trains){
					if (t.getName().equals(c.getName()))
						trains2.add(t);
				}
			}
		}
		List<Trains> trains3 = new ArrayList<>();
		for (Trains t: trains){
			if (trains2.contains(t)){}
			else{
				trains3.add(t);
			}
		}
	
		
		return trains3;
	}
}
