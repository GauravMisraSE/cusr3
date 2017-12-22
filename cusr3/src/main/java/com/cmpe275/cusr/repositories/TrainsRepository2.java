package com.cmpe275.cusr.repositories;

import com.cmpe275.cusr.model.Trains;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalTime;
import java.util.List;

public interface TrainsRepository2 extends CrudRepository<Trains, String> {

	List<Trains> findByDirection(Character direction);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.A >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndA(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.B >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndB(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.C >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndC(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.D >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndD(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.E >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndE(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.F >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndF(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.G >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndG(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.H >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndH(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.I >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndI(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.J >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndJ(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.K >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndK(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.L >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndL(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.M >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndM(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.N >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndN(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.O >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndO(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.P >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndP(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.Q >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndQ(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.R >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndR(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.S >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndS(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.T >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndT(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.U >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndU(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.V >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndV(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.W >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndW(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.X >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndX(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.Y >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndY(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.Z >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndZ(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select A from trains where trains.name = :trainname")
	String getStationTimeA(@Param("trainname") String trainname);

	@Query(nativeQuery = true, value = "select B from trains where trains.name = :trainname")
	String getStationTimeB(@Param("trainname") String trainname);

	@Query(nativeQuery = true, value = "select C from trains where trains.name = :trainname")
	String getStationTimeC(@Param("trainname") String trainname);

	@Query(nativeQuery = true, value = "select D from trains where trains.name = :trainname")
	String getStationTimeD(@Param("trainname") String trainname);

	@Query(nativeQuery = true, value = "select E from trains where trains.name = :trainname")
	String getStationTimeE(@Param("trainname") String trainname);

	@Query(nativeQuery = true, value = "select F from trains where trains.name = :trainname")
	String getStationTimeF(@Param("trainname") String trainname);

	@Query(nativeQuery = true, value = "select G from trains where trains.name = :trainname")
	String getStationTimeG(@Param("trainname") String trainname);

	@Query(nativeQuery = true, value = "select H from trains where trains.name = :trainname")
	String getStationTimeH(@Param("trainname") String trainname);

	@Query(nativeQuery = true, value = "select I from trains where trains.name = :trainname")
	String getStationTimeI(@Param("trainname") String trainname);

	@Query(nativeQuery = true, value = "select J from trains where trains.name = :trainname")
	String getStationTimeJ(@Param("trainname") String trainname);

	@Query(nativeQuery = true, value = "select K from trains where trains.name = :trainname")
	String getStationTimeK(@Param("trainname") String trainname);

	@Query(nativeQuery = true, value = "select L from trains where trains.name = :trainname")
	String getStationTimeL(@Param("trainname") String trainname);

	@Query(nativeQuery = true, value = "select M from trains where trains.name = :trainname")
	String getStationTimeM(@Param("trainname") String trainname);

	@Query(nativeQuery = true, value = "select N from trains where trains.name = :trainname")
	String getStationTimeN(@Param("trainname") String trainname);

	@Query(nativeQuery = true, value = "select O from trains where trains.name = :trainname")
	String getStationTimeO(@Param("trainname") String trainname);

	@Query(nativeQuery = true, value = "select P from trains where trains.name = :trainname")
	String getStationTimeP(@Param("trainname") String trainname);

	@Query(nativeQuery = true, value = "select Q from trains where trains.name = :trainname")
	String getStationTimeQ(@Param("trainname") String trainname);

	@Query(nativeQuery = true, value = "select R from trains where trains.name = :trainname")
	String getStationTimeR(@Param("trainname") String trainname);

	@Query(nativeQuery = true, value = "select S from trains where trains.name = :trainname")
	String getStationTimeS(@Param("trainname") String trainname);

	@Query(nativeQuery = true, value = "select T from trains where trains.name = :trainname")
	String getStationTimeT(@Param("trainname") String trainname);

	@Query(nativeQuery = true, value = "select U from trains where trains.name = :trainname")
	String getStationTimeU(@Param("trainname") String trainname);

	@Query(nativeQuery = true, value = "select V from trains where trains.name = :trainname")
	String getStationTimeV(@Param("trainname") String trainname);

	@Query(nativeQuery = true, value = "select W from trains where trains.name = :trainname")
	String getStationTimeW(@Param("trainname") String trainname);

	@Query(nativeQuery = true, value = "select X from trains where trains.name = :trainname")
	String getStationTimeX(@Param("trainname") String trainname);

	@Query(nativeQuery = true, value = "select Y from trains where trains.name = :trainname")
	String getStationTimeY(@Param("trainname") String trainname);

	@Query(nativeQuery = true, value = "select Z from trains where trains.name = :trainname")
	String getStationTimeZ(@Param("trainname") String trainname);






}
