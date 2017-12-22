package com.cmpe275.cusr.controller;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cmpe275.cusr.model.Cancelledtrains;
import com.cmpe275.cusr.model.Ticket;
import com.cmpe275.cusr.model.Tickets;
import com.cmpe275.cusr.model.Trains;

import com.cmpe275.cusr.service.AvailabilityService;
import com.cmpe275.cusr.service.EmailService;
import com.cmpe275.cusr.service.SearchService;
import com.cmpe275.cusr.service.TicketService;
import com.cmpe275.cusr.service.TrainCancellationService;
import com.cmpe275.cusr.util.CustomErrorType;
import java.time.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);



	@Autowired
	SearchService searchService; 
	
	@Autowired
	TicketService ticketService;
	
	@Autowired
	private AvailabilityService availabilityService;
	
	@Autowired
	TrainCancellationService trainCancellationService;
	
	@Autowired
	EmailService emailService;

	
	// return all train objects
		@RequestMapping(method = RequestMethod.GET, value = "/search/all")
		public List<Trains> allTrains(){
			return searchService.getAllTrains();
		}

		// retrieving the list of train options based on journey times
		// check the request parameters while integration
		@RequestMapping(method = RequestMethod.GET, value = "/search")
		public List<Trains> trains(@RequestParam(value = "startStation") Character startStation,
		                           @RequestParam(value = "startTime") String startTime,
		                           @RequestParam(value = "endStation") Character endStation,
		                           @RequestParam(value = "trainType", required=false) Character trainType,
		                           @RequestParam(value = "date") String date,
		                           @RequestParam(value = "exactTime", required=false) String exactTime) {
		 	System.out.println(date);
			 date=convertDate(date);

			List<Trains> trainOptions = searchService.searchTrains(startStation, startTime, endStation, trainType, date, exactTime);

			return trainOptions;
		}
		
		public String convertDate(String strDate) {
		String str = strDate;
	    	String[] array = str.split(" ");
	    	String newdate;
	    	String newtime;
	    	String reformattedStr ="";
	    	newdate = array[3] + "-" + array[1]+ "-" + array[2];
	    	newtime = array[4] ;
	    //	System.out.println(newdate+" " +newtime);
	    	SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MMM-dd");
	    	SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
	    	try {

	    	    reformattedStr = myFormat.format(fromUser.parse(newdate));
	        	System.out.println(reformattedStr);
	        	return reformattedStr;
	    	} catch (Exception e) {
	    	    e.printStackTrace();
	    	}
	     	return reformattedStr;
		}

		// -------------------Check Availability-------------------------------------------
		@RequestMapping(method = RequestMethod.GET, value = "/availability")
		public int checkAvailabilty(
		                           @RequestParam(value = "from") Character from,
		                           @RequestParam(value = "upto") Character upto,
		                           @RequestParam(value = "trainName") String train,
		                           @RequestParam(value = "journeyDate") String journeyDate) {


			journeyDate = convertDate(journeyDate);
			int availability = availabilityService.checkAvailability(from, upto, train, journeyDate);
			return availability;
		}

		// -------------------Change Train Capacity-------------------------------------------
		// allows changing of train capacity
		@RequestMapping(method = RequestMethod.PUT, value = "/updateCapacity")
		public Boolean updateCapacity(@RequestParam(value = "newCapacity") Integer capacity){
			System.out.println("Updating train capacity");
			availabilityService.setCapacity(capacity);
			return true;
		}
		
		//-------------------cancel train-------------------------------------------
		@RequestMapping(method = RequestMethod.PUT, value = "/trainCancellation")
		public Boolean addTrain(@RequestParam(value = "cancelTrainId") String name,
		                        @RequestParam(value = "date") String date){
			System.out.println("train name"+name);
			System.out.println("Date"+date);
			String newDate=convertDate(date);
			Cancelledtrains ct = new Cancelledtrains();
			ct.setName(name); 
			ct.setDate(newDate);
			System.out.println(ct);

			trainCancellationService.cancelTrainObj(ct);

			Boolean save = trainCancellationService.cancelTrain(ct);
			return save;
		}
		// -------------------Cancel a Ticket-------------------------------------------
		
		@RequestMapping(value = "/cancel/", method = RequestMethod.POST)
		public ResponseEntity<?> cancelTicket(
                @RequestParam(value = "cancelTicketId",required = false) String ticketId,
                @RequestParam(value = "sysdate",required = false) String sysdate)  {
			
			logger.info("Cancelling Ticket... : {}");
			System.out.println("Call");
			System.out.println(sysdate);
			
			Long ticketIdNew;
			ticketIdNew = Long.parseLong(ticketId);
			System.out.println("Cancel Ticket");
			int result = ticketService.cancelTicket(ticketIdNew, sysdate);
			if (result == 0) {
			return new ResponseEntity<String>(HttpStatus.OK);
			}
			else 
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

		}
		
		// -------------------Book a Ticket-------------------------------------------
		
				@RequestMapping(value = "/ticket/", method = RequestMethod.POST)
				public ResponseEntity<?> bookTicket(
		                @RequestParam(value = "userEmail",required = false) String userEmail,
		                @RequestParam(value = "depTrainNo",required = false) String depTrainNo,
		                @RequestParam(value = "depDate",required = false) String depDate,
		                @RequestParam(value = "depFromTime",required = false) String depFromTime,
		                @RequestParam(value = "depToTime",required = false) String depToTime,
		                @RequestParam(value = "depFromAscii",required = false) String depFromAscii,
		                @RequestParam(value = "depToAscii",required = false) String depToAscii,
		                @RequestParam(value = "depFrom",required = false) String depFrom,
		                @RequestParam(value = "depTo",required = false) String depTo,
		                @RequestParam(value = "passengerList",required = false) String passengerList,
		                @RequestParam(value = "passengerCount",required = false) String passengerCount, 
		                @RequestParam(value = "retTrainNo",required = false) String retTrainNo,
		                @RequestParam(value = "retDate",required = false) String retDate,
		                @RequestParam(value = "retFromTime",required = false) String retFromTime,
		                @RequestParam(value = "retToTime",required = false) String retToTime,
		                @RequestParam(value = "retFromAscii",required = false) String retFromAscii,
		                @RequestParam(value = "retToAscii",required = false) String retToAscii,
		                @RequestParam(value = "retFrom",required = false) String retFrom,
		                @RequestParam(value = "depTo",required = false) String retTo,
		                @RequestParam(value = "fare",required = false) String fare,
		                @RequestParam(value = "depTrainType",required = false) String depTrainType,
		                @RequestParam(value = "retTrainType",required = false) String retTrainType,
		                @RequestParam(value = "retTrip",required = false) String retTrip) throws AddressException, MessagingException {
					
					depDate = convertDate(depDate);
					
					logger.info("Creating Ticket... : {}");
					System.out.println("ticket details");
					System.out.println("retTrip"+retTrip);
					
					Tickets ticket=new Tickets();
					  //depfrom = $localStorage.ticket.depFrom.charCodeAt(0);
			           //depto = $localStorage.ticket.depTo.charCodeAt(0);
					userEmail = "sneha.vadakkemadathil@sjsu.edu";
					ticket.setEmail(userEmail);
					ticket.setTrain(depTrainNo);
					
					ticket.setJdate(depDate);
					ticket.setEtime(depToTime);
					ticket.setStime(depFromTime);
					System.out.println("B4 depTo" + depTo);
					ticket.setEnd(Integer.parseInt(depToAscii));
					System.out.println("af depTo" + depFrom);
					ticket.setStart(Integer.parseInt(depFromAscii));
					System.out.println("af depFrom" + depFrom);
					System.out.println("af passengerCount" + passengerCount);
					System.out.println("af fare" + fare);
					ticket.setPass_count(Integer.parseInt(passengerCount));
					System.out.println("af passengerCount" + passengerCount);
					ticket.setFare(Double.parseDouble(fare));
					System.out.println("af fare" + fare);
					System.out.println("af depTrainType" + depTrainType);

					System.out.println("Train Type"+depTrainType.charAt(0));
					ticket.setTraintype(depTrainType.charAt(0));
					System.out.println("Values set");

					
					Long dep_id = ticketService.bookTicket(ticket);
					Long ret_id = null;
					
					System.out.println("After method call");		
					
					if (retTrip.equals("1")) {
						Tickets ticketRet=new Tickets();
						retDate = convertDate(retDate);
						userEmail ="sneha.vadakkemadathil@sjsu.edu";
						ticketRet.setEmail(userEmail);
						System.out.println("1");
						ticketRet.setTrain(retTrainNo);
						System.out.println("2");
						ticketRet.setJdate(retDate);
						System.out.println("3");
						ticketRet.setEtime(retToTime);
						System.out.println("4");
						ticketRet.setStime(retFromTime);
						System.out.println("5");
						ticketRet.setEnd(Integer.parseInt(retToAscii));
						System.out.println("6");
						ticketRet.setStart(Integer.parseInt(retFromAscii));
						System.out.println("7");
						ticketRet.setPass_count(Integer.parseInt(passengerCount));
						ticketRet.setFare(Double.parseDouble(fare));
						ticketRet.setTraintype(retTrainType.charAt(0));
						ret_id = ticketService.bookTicket(ticketRet);
					}
					

					
			        // outgoing message information
			        String mailTo = userEmail;
			 
			        // message contains HTML markups
			        String message = "<i>Greetings!</i><br>";
			        
			        if (retTrip.equals("1")) {
			        message +="<body style=\"margin: 0; padding: 0;\">\r\n" + 
			        		" <table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
			        		"  <tr>\r\n" + 
			        		"   <td>\r\n" + 
			        		"<table align=\"center\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">\r\n" + 
			        		" <tr><td align=\"center\" bgcolor=\"#70bbd9\" style=\"padding: 40px 0 30px 0;\">\r\n" + 
			        		" <img src=\"http://preview.ibb.co/grPFem/Train.jpg\" alt=\"Booking Details\" width=\"500\" height=\"230\" border=\"0\" style=\"display: block;\" />\r\n" + 
			        		"</td>\r\n" + 
			        		"</tr>\r\n" + 
			        		" <tr>\r\n" + 
			        		"<td bgcolor=\"#ffffff\" style=\"padding: 40px 30px 40px 30px;\">\r\n" + 
			        		" <h1> Onward Ticket#"+dep_id+"<br>Return Ticket#"+ret_id+"<br><br>Passenger Details </h1>\r\n" + 
			        		" <table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"width:100%;font-family:Verdana;font-size: 15px\">\r\n" + 
			        		passengerList +"\r\n" + 
			        		" </table>\r\n" + 
			        		"</td>\r\n" + 
			        		" </tr>\r\n" + 
			        		" <tr>\r\n" + 
			        		"  <td bgcolor=\"#ffffff\" style=\"padding: 40px 30px 40px 30px;\">\r\n" + 
			        		"    <h1> Travel Itenary</h1>\r\n" + 
			        		" <table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
			        		"  <tr>\r\n" + 
			        		"   <td><pre font-family: Verdana, \"Bitstream Vera Sans\", Geneva, sans-serif;><span style=\"font-size: 15px\">\r\n" + 
			        		"    Departure      "+depFrom+"      --->      "+depTo+" <br>    "+depDate+"    "+depFromTime+"         "+depToTime+"\r\n" + 
			        		"   </td></pre>\r\n" + 
			        		"  </tr>\r\n" + 
			        		"  <tr>\r\n" + 
			        		"   <td><pre font-family: Verdana, \"Bitstream Vera Sans\", Geneva, sans-serif;><span style=\"font-size: 15px\">\r\n"+ 
			        		"    Return         " + retFrom+"      --->      "+retTo+" <br>    "+retDate+"    "+retFromTime+"         "+retToTime+"\r\n" + 
			        		"   </td></pre>\r\n" + 
			        		"  </tr>\r\n" + 
			        		" </table>\r\n" + 
			        		"  </td>\r\n" + 
			        		" </tr>\r\n" + 
			        		"  <tr>\r\n" +  
			        		" <td>Fare:   $"+ fare+" </td>"+
			        		" </tr>\r\n" + 
			        		"</body>";
			        }
			        else{
			                message +="<body style=\"margin: 0; padding: 0;\">\r\n" + 
			        		" <table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
			        		"  <tr>\r\n" + 
			        		"   <td>\r\n" + 
			        		"<table align=\"center\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">\r\n" + 
			        		" <tr><td align=\"center\" bgcolor=\"#70bbd9\" style=\"padding: 40px 0 30px 0;\">\r\n" + 
			        		" <img src=\"http://preview.ibb.co/grPFem/Train.jpg\" alt=\"Booking Details\" width=\"500\" height=\"230\" border=\"0\" style=\"display: block;\" />\r\n" + 
			        		"</td>\r\n" + 
			        		"</tr>\r\n" + 
			        		" <tr>\r\n" + 
			        		"<td bgcolor=\"#ffffff\" style=\"padding: 40px 30px 40px 30px;\">\r\n" + 
			        		" <h1> Ticket#"+dep_id+"<br>Passenger Details </h1>\r\n" + 
			        		" <table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"width:100%;font-family:Verdana;font-size: 15px;\">\r\n" + 
			        		passengerList +"\r\n" + 
			        		" </table>\r\n" + 
			        		"</td>\r\n" + 
			        		" </tr>\r\n" + 
			        		" <tr>\r\n" + 
			        		"  <td bgcolor=\"#ffffff\" style=\"padding: 40px 30px 40px 30px;\">\r\n" + 
			        		"    <h1> Travel Itenary</h1>\r\n" + 
			        		" <table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
			        		"  <tr>\r\n" + 
			        		"   <td><pre font-family: Verdana, \"Bitstream Vera Sans\", Geneva, sans-serif;><span style=\"font-size: 15px\">\r\n" + 
			        		"    Departure      "+depFrom+"      --->      "+depTo+" <br>    "+depDate+"    "+depFromTime+"         "+depToTime+"\r\n" + 
			        		"   </td></pre>\r\n" + 
			        		"  </tr>\r\n" + 
			        		" </table>\r\n" + 
			        		"  </td>\r\n" + 
			        		" </tr>\r\n" + 
			        		"  <tr>\r\n" +
			        		" <td>Fare:   $"+ fare+" </td>"+
			        		" </tr>\r\n" + 
			        		"</body>";
			        }

			        userEmail = "gaurav.misra@sjsu.edu";
			        emailService.sendRebookingConfirmation(userEmail, message);
					System.out.println("Create Ticket");
					return new ResponseEntity<String>(HttpStatus.OK);
				}
				
	
	

}