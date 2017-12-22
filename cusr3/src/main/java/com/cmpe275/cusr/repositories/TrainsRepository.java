package com.cmpe275.cusr.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cmpe275.cusr.model.Trains;
import com.cmpe275.cusr.service.SearchService;

import java.time.LocalTime;
import java.util.List;


public interface TrainsRepository extends CrudRepository<Trains, String> {

	List<Trains> findByDirection(Character direction);
	
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.A = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByAExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime
	                                                         
	                                                     );
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.B = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByBExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.C = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByCExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.D = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByDExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.E = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByEExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.F = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByFExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.G = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByGExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.H = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByHExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.I = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByIExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.J = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByJExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.K = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByKExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.L = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByLExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.M = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByMExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.N = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByNExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.O = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByOExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.P = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByPExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.Q = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByQExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.R = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByRExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.S = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyBySExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.T = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByTExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.U = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByUExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.V = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByVExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.W = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByWExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.X = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByXExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.Y = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByYExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.Z = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByZExact(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	
	/////////////////////////
	
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.A >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByA(@Param("direction") Character direction,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.B >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByB(@Param("direction") Character direction,
	                                                         
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.C >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByC(@Param("direction") Character direction,
	                                                        
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.D >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByD(@Param("direction") Character direction,
	                                                          
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.E >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByE(@Param("direction") Character direction,
	                                                        
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.F >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByF(@Param("direction") Character direction,
	                                                         
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.G >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByG(@Param("direction") Character direction,
	                                                        
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.H >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByH(@Param("direction") Character direction,
	                                                       
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.I >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByI(@Param("direction") Character direction,
	                                                     
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.J >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByJ(@Param("direction") Character direction,
	                                                        
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.K >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByK(@Param("direction") Character direction,
	                                                         
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.L >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByL(@Param("direction") Character direction,
	                                                         
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.M >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByM(@Param("direction") Character direction,
	                                                         
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.N >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByN(@Param("direction") Character direction,
	                                                      
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.O >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByO(@Param("direction") Character direction,
	                                                        
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.P >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByP(@Param("direction") Character direction,
	                                                      
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.typeIN ('S','E') and trains.Q >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByQ(@Param("direction") Character direction,
	                                                        
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.R >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByR(@Param("direction") Character direction,
	                                                   
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.S >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByS(@Param("direction") Character direction,
	                                                        
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.T >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByT(@Param("direction") Character direction,
	                                                         
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.U >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByU(@Param("direction") Character direction,
	                                                          
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.V >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByV(@Param("direction") Character direction,
	                                                        
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.W >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByW(@Param("direction") Character direction,
	                                                        
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.X >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByX(@Param("direction") Character direction,
	                                                         
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.Y >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByY(@Param("direction") Character direction,
	                                                       
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type IN ('S','E') and trains.Z >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findAnyByZ(@Param("direction") Character direction,
	                                                      
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	
	
	
	
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.A = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByA(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.B = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByB(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.C = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByC(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.D = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByD(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.E = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByE(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.F = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByF(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.G = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByG(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.H = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByH(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.I = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByI(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.J = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByJ(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.K = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByK(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.L = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByL(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.M = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByM(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.N = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByN(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.O = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByO(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.P = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByP(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.Q = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByQ(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.R = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByR(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.S = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByS(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.T = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByT(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.U = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByU(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.V = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByV(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.W = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByW(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.X = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByX(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.Y = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByY(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.Z = :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByZ(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);
	
	
	
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.A >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndA(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.B >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndB(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.C >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndC(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.D >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndD(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.E >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndE(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.F >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndF(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.G >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndG(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.H >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndH(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.I >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndI(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.J >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndJ(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.K >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndK(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.L >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndL(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.M >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndM(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.N >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndN(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.O >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndO(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.P >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndP(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.Q >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndQ(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.R >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndR(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.S >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndS(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.T >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndT(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.U >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndU(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.V >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndV(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.W >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndW(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.X >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndX(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.Y >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndY(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.Z >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndZ(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);



}
