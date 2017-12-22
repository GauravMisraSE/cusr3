//package cusr.repos;
//
////import cusr.model.Tickets2;
//import cusr.model.Tickets;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//
//import java.util.List;
//
//public interface TicketsRepository extends CrudRepository<Tickets, Long> {
//
//
////	@Query(nativeQuery = true, value = "select sum(pc) from tickets2 where tickets2.tn = :train and tickets2.jd = :jdate and ((begin >= :start and begin < :end) or (stop > :start and stop <= :end)) ")
////	Integer checkEmptyBetweenOnward(@Param("start") int start,
////	                              @Param("end") int end,
////	                              @Param("train") String train,
////	                              @Param("jdate") String jdate);
////
////	@Query(nativeQuery = true, value = "select sum(pc) from tickets2 where tickets2.tn = :train and tickets2.jd = :jdate and ((begin < :start) and (stop > :end)) ")
////	Integer checkEmptyBetweenOnward2(@Param("start") int start,
////	                                @Param("end") int end,
////	                                @Param("train") String train,
////	                                @Param("jdate") String jdate);
////
////	@Query(nativeQuery = true, value = "select sum(pc) from tickets2 where tickets2.tn = :train and tickets2.jd = :jdate and ((begin <= :start and begin > :end) or (stop < :start and stop >= :end)) ")
////	Integer checkEmptyBetweenReturn(@Param(value = "start") int start,
////	                            @Param(value = "end") int end,
////	                            @Param(value = "train") String train,
////	                            @Param(value = "jdate") String jdate);
////
////	@Query(nativeQuery = true, value = "select sum(pc) from tickets2 where tickets2.tn = :train and tickets2.jd = :jdate and ((begin > :start) and (stop < :end)) ")
////	Integer checkEmptyBetweenReturn2(@Param(value = "start") int start,
////	                                @Param(value = "end") int end,
////	                                @Param(value = "train") String train,
////	                                @Param(value = "jdate") String jdate);
////
////	List<Tickets2> findByTnAndJd(String tn, String jd);
////
////	@Query(nativeQuery = true, value = "delete from tickets2 where tickets2.tid = :tid")
////	void removerecord(@Param(value = "tid") Long tid);
//
//
//}
//
package com.cmpe275.cusr.repositories;

import com.cmpe275.cusr.model.Tickets;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketsRepository extends CrudRepository<Tickets, Long> {


	@Query(nativeQuery = true, value = "select sum(pass_count) from tickets where tickets.train = :train and tickets.jdate = :jdate and ((start >= :start and start < :end) or (end > :start and end <= :end)) ")
	Integer checkEmptyBetweenOnward(@Param("start") int start,
	                                @Param("end") int end,
	                                @Param("train") String train,
	                                @Param("jdate") String jdate);

	@Query(nativeQuery = true, value = "select sum(pass_count) from tickets where tickets.train = :train and tickets.jdate = :jdate and ((start < :start) and (end > :end)) ")
	Integer checkEmptyBetweenOnward2(@Param("start") int start,
	                                 @Param("end") int end,
	                                 @Param("train") String train,
	                                 @Param("jdate") String jdate);

	@Query(nativeQuery = true, value = "select sum(pass_count) from tickets where tickets.train = :train and tickets.jdate = :jdate and ((start <= :start and start > :end) or (end < :start and end >= :end)) ")
	Integer checkEmptyBetweenReturn(@Param(value = "start") int start,
	                                @Param(value = "end") int end,
	                                @Param(value = "train") String train,
	                                @Param(value = "jdate") String jdate);

	@Query(nativeQuery = true, value = "select sum(pass_count) from tickets where tickets.train = :train and tickets.jdate = :jdate and ((start > :start) and (end < :end)) ")
	Integer checkEmptyBetweenReturn2(@Param(value = "start") int start,
	                                 @Param(value = "end") int end,
	                                 @Param(value = "train") String train,
	                                 @Param(value = "jdate") String jdate);


	List<Tickets> findByTrainAndJdate(String train, String jdate);

//	void deleteByTktidIn(List<Long> tktid);
//
//	List<Tickets> findByTrainAndJdate(String train, String jdate);


}