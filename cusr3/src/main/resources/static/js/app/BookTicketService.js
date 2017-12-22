'use strict';

angular.module('crudApp').factory('BookTicketService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

        var factory = {
            createTicket: createTicket,
            loadSearchDetails: loadSearchDetails,
            getSearchDetails: getSearchDetails,
            calculateFare:calculateFare,
            cancelTicket:cancelTicket
        };

        return factory;
        var fare = 0;
        var finalfare = 0;
        self.params = '';
        
        function createTicket(ticket,passengers) {
        		//alert("Method called");
            var deferred = $q.defer();
            var passengerList="";
            var i;
            var ticketInfo={userId:10, depTrainNo:"2",depFrom:"B",depTo:"M",depDate:"10-Dec-2017",depFromTime:"0815",depToTime:"1000",retTrainNo:"1",retFrom:"M",retTo:"B",retDate:"10-Dec-2017",retFromTime:"0915",retToTime:"1000", noOfPassengers:1,totalFare:15};
            //var ticketInfo={userId:10, depTrainNo:"3",depFrom:"B",depTo:"M",depDate:"10-Dec-2017",depFromTime:"0915",depToTime:"1000", noOfPassengers:2,totalFare:fare};
            ticket = $localStorage.ticket;
            //alert(ticket.userId);
                        
            //alert(passengers.fname[1]);  
            
            var depfrom = $localStorage.ticket.depFrom.charCodeAt(0);
            var depto = $localStorage.ticket.depTo.charCodeAt(0);
            var retfrom = $localStorage.ticket.retFrom.charCodeAt(0);
            var retto = $localStorage.ticket.retTo.charCodeAt(0);
            //alert("from"+$localStorage.ticket.depFrom);
            //alert("to"+$localStorage.ticket.depTo);
            for (i = 1; i <= $localStorage.ticket.passengerCount; i++) { 
        		passengerList += "<tr><td>Passenger"+ i+":"+ passengers.fname[i] +" "+ passengers.lname[i]+"</td></tr>";
            }
            
            //alert("final fare is "+finalfare);
            self.params = '?userEmail='+$localStorage.ticket.userEmail
            +'&depTrainNo='+$localStorage.ticket.depTrainNo
            +'&depDate='+$localStorage.ticket.depDate
            +'&depFromTime='+$localStorage.ticket.depFromTime
            +'&depToTime='+$localStorage.ticket.depToTime
            +'&depFromAscii='+depfrom
            +'&depToAscii='+depto
            +'&depFrom='+$localStorage.ticket.depFrom
            +'&depTo='+$localStorage.ticket.depTo
            +'&passengerList='+passengerList
            +'&passengerCount='+$localStorage.ticket.passengerCount
            +'&retTrainNo='+$localStorage.ticket.retTrainNo
            +'&retDate='+$localStorage.ticket.retDate
            +'&retFromTime='+$localStorage.ticket.retFromTime
            +'&retToTime='+$localStorage.ticket.retToTime
            +'&retFromAscii='+retfrom
            +'&retToAscii='+retto
            +'&retFrom='+$localStorage.ticket.retFrom
            +'&retTo='+$localStorage.ticket.retTo            
            +'&fare='+finalfare
            +'&depTrainType='+$localStorage.ticket.depTrainType
            +'&retTrainType='+$localStorage.ticket.retTrainType
            +'&retTrip='+$localStorage.ticket.retTrip;
            
          //  alert(self.params);  
            
            
           // alert(passengerList);
            
            ticket.passengerList=passengerList;
            
            $http.post(urls.TICKET_SEARCH_API + params)
                .then(
                    function (response) {
                    	alert("Your ticket has been booked");
                        deferred.resolve(response.data);
                    },
                    function (errResponse) {
                    		//alert("Error creating");
                       console.error('Error while creating Ticket : '+errResponse.data.errorMessage);
                       deferred.reject(errResponse);
                    }
                );
          //  alert("After Method called");
            return deferred.promise;
  
        }
        

        function cancelTicket(cancelTicketId) {
        	var today = new Date();
    		//alert("Method called");  
    		//alert(cancelTicketId); 
    		//alert(today);
    		var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
    		//alert(date);
    		var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
    		//alert(time);
    		var dateTime = date+' '+time;

    		self.params ='?cancelTicketId='+cancelTicketId
    		+'&sysdate='+dateTime;
    		
        $http.post(urls.TICKET_CANCEL_API + params)
            .then(
                function (response) {
                	alert("Your ticket has been cancelled");
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                		alert("Invalid Ticket Id");
                   console.error('Error while cancelling Ticket : '+errResponse.data.errorMessage);
                   deferred.reject(errResponse);
                }
            );
       // alert("After Method called");
        return deferred.promise;

    }
        
        function loadSearchDetails() {
            console.log('Fetching ticket details');
            var deferred = $q.defer();
            localStorage.removeItem("ticket");
            var ticketInfo={userId:10, depTrainNo:"3",depFrom:"A",depTo:"M",depDate:"10-Dec-2017",depFromTime:"0815",depToTime:"1000",retTrainNo:"1",retFrom:"M",retTo:"B",retDate:"10-Dec-2017",retFromTime:"0815",retToTime:"1000", retTrip:"1", noOfPassengers:1, baseFare:3,totalFare:15};
            //var ticketInfo={userId:10, depTrainNo:"3",depFrom:"B",depTo:"M",depDate:"10-Dec-2017",depFromTime:"0915",depToTime:"1000",depTrainType:"E", noOfPassengers:2, baseFare:3,totalFare:15,retTrip:"0"};
            //$localStorage.ticket = ticketInfo;
            
            $http.get(urls.USER_SERVICE_API)
                .then(
                    function (response) {
                        console.log('Fetched successfully ticket details');
                        //$localStorage.ticket = ticketInfo;
                        deferred.resolve(response);
                    },
                    function (errResponse) {
                        console.error('Error while loading');
                        deferred.reject(errResponse);
                    }
                );
            return deferred.promise;
        }

        function getSearchDetails(){
            //alert (JSON.stringify($localStorage.ticket));
            return $localStorage.ticket;
        }
        
       function calculateFare(){
    	        var from = $localStorage.ticket.depFrom;
    	        var to = $localStorage.ticket.depTo;
    	        var stops= Math.abs(from.charCodeAt(0) - to.charCodeAt(0));
    	        var rem = (stops%5);
    	        var quo = parseInt(stops/5);
    	        var depFare ='';
    	        var retFare ='';
    	        if ($localStorage.ticket.depTrainType === "S"){
	    	        if(stops<5){
	    	        	depFare= '1';
	    	        }
	    	        else if(rem!=0){
	    	        	depFare= (quo+1);
	    	        }
	    	        else {
	    	        	depFare= quo;
	    	        	}
	    	        fare = depFare;
    	        }
    	        if ($localStorage.ticket.depTrainType === "E"){
	    	        if(stops<5){
	    	        	depFare= '2';
	    	        }
	    	        else if(rem!=0){
	    	        	depFare= (quo*2+2);
	    	        }
	    	        else {
	    	        	depFare= quo*2;
	    	        	}
	    	        fare = depFare;
    	        }
    	        if ($localStorage.ticket.retTrip == "1"){
        	        if ($localStorage.ticket.retTrainType == "S"){
    	    	        if(stops<5){
    	    	        	retFare= '1';
    	    	        }
    	    	        else if(rem!=0){
    	    	        	retFare= (quo+1);
    	    	        }
    	    	        else {
    	    	        	retFare= quo;
    	    	        	}
        	        }
        	        if ($localStorage.ticket.retTrainType == "E"){
    	    	        if(stops<5){
    	    	        	retFare= '2';
    	    	        }
    	    	        else if(rem!=0){
    	    	        	retFare= (quo*2+2);
    	    	        }
    	    	        else {
    	    	        	retFare= quo*2;
    	    	        	}
        	        }
        	        fare = depFare + retFare;
    	        }
    	        finalfare = fare*$localStorage.ticket.passengerCount+1;
    	        return fare;
        }
        
    }
]);