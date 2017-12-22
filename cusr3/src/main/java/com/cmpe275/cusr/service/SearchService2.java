package com.cmpe275.cusr.service;

import com.cmpe275.cusr.model.Cancelledtrains;
import com.cmpe275.cusr.model.Trains;
import com.cmpe275.cusr.repositories.CancelledtrainsRepository;
import com.cmpe275.cusr.repositories.TrainsRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import java.time.*;
import java.util.Timer;


@Service
@Transactional
public class SearchService2 {

	@Autowired
	private TrainsRepository2 trainsRepository2;

	@Autowired CancelledtrainsRepository cancelledtrainsRepository;

	public List<Trains> getAllTrains(){

		List<Trains> allTrains = new ArrayList<>();
		trainsRepository2.findAll().forEach((allTrains::add));
//		for(Trains t: allTrains){
//			System.out.println(t.getName());
//		}
		return allTrains;
	}

	public List<Trains> searchTrains(Character startStation, String startTime, Character endStation, Character trainType, String date){

		Character direction = null;
		LocalTime st = LocalTime.parse(startTime);
		List<Trains> trains = new ArrayList<>();
		List<Trains> trains2 = new ArrayList<>();

		if (Character.getNumericValue(startStation) - Character.getNumericValue(endStation) < 0)
			direction = 'S';
		else
			direction = 'N';

		if (startStation == 'A')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndA(direction,trainType,startTime);
		if (startStation == 'B')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndB(direction,trainType,startTime);
		if (startStation == 'C')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndC(direction,trainType,startTime);
		if (startStation == 'D')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndD(direction,trainType,startTime);
		if (startStation == 'E')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndE(direction,trainType,startTime);
		if (startStation == 'F')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndF(direction,trainType,startTime);
		if (startStation == 'G')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndG(direction,trainType,startTime);
		if (startStation == 'H')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndH(direction,trainType,startTime);
		if (startStation == 'I')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndI(direction,trainType,startTime);
		if (startStation == 'J')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndJ(direction,trainType,startTime);
		if (startStation == 'K')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndK(direction,trainType,startTime);
		if (startStation == 'L')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndL(direction,trainType,startTime);
		if (startStation == 'M')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndM(direction,trainType,startTime);
		if (startStation == 'N')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndN(direction,trainType,startTime);
		if (startStation == 'O')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndO(direction,trainType,startTime);
		if (startStation == 'P')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndP(direction,trainType,startTime);
		if (startStation == 'Q')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndQ(direction,trainType,startTime);
		if (startStation == 'R')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndR(direction,trainType,startTime);
		if (startStation == 'S')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndS(direction,trainType,startTime);
		if (startStation == 'T')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndT(direction,trainType,startTime);
		if (startStation == 'U')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndU(direction,trainType,startTime);
		if (startStation == 'V')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndV(direction,trainType,startTime);
		if (startStation == 'W')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndW(direction,trainType,startTime);
		if (startStation == 'X')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndX(direction,trainType,startTime);
		if (startStation == 'Y')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndY(direction,trainType,startTime);
		if (startStation == 'Z')
			trains = trainsRepository2.findByDirectionAndTrainTypeAndStartTimeAndZ(direction,trainType,startTime);
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

	public String getstationTime(String trainname, Character stationName){

		if (stationName == 'A')
			return trainsRepository2.getStationTimeA(trainname);
		if (stationName == 'B')
			return trainsRepository2.getStationTimeB(trainname);
		if (stationName == 'C')
			return trainsRepository2.getStationTimeC(trainname);
		if (stationName == 'D')
			return trainsRepository2.getStationTimeD(trainname);
		if (stationName == 'E')
			return trainsRepository2.getStationTimeE(trainname);
		if (stationName == 'F')
			return trainsRepository2.getStationTimeF(trainname);
		if (stationName == 'G')
			return trainsRepository2.getStationTimeG(trainname);
		if (stationName == 'H')
			return trainsRepository2.getStationTimeH(trainname);
		if (stationName == 'I')
			return trainsRepository2.getStationTimeI(trainname);
		if (stationName == 'J')
			return trainsRepository2.getStationTimeJ(trainname);
		if (stationName == 'K')
			return trainsRepository2.getStationTimeK(trainname);
		if (stationName == 'L')
			return trainsRepository2.getStationTimeL(trainname);
		if (stationName == 'M')
			return trainsRepository2.getStationTimeM(trainname);
		if (stationName == 'N')
			return trainsRepository2.getStationTimeN(trainname);
		if (stationName == 'O')
			return trainsRepository2.getStationTimeO(trainname);
		if (stationName == 'P')
			return trainsRepository2.getStationTimeP(trainname);
		if (stationName == 'Q')
			return trainsRepository2.getStationTimeQ(trainname);
		if (stationName == 'R')
			return trainsRepository2.getStationTimeR(trainname);
		if (stationName == 'S')
			return trainsRepository2.getStationTimeS(trainname);
		if (stationName == 'T')
			return trainsRepository2.getStationTimeT(trainname);
		if (stationName == 'U')
			return trainsRepository2.getStationTimeU(trainname);
		if (stationName == 'V')
			return trainsRepository2.getStationTimeV(trainname);
		if (stationName == 'W')
			return trainsRepository2.getStationTimeW(trainname);
		if (stationName == 'X')
			return trainsRepository2.getStationTimeX(trainname);
		if (stationName == 'Y')
			return trainsRepository2.getStationTimeY(trainname);
		if (stationName == 'Z')
			return trainsRepository2.getStationTimeZ(trainname);

		return null;

	}

}

