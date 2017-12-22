'use strict';

angular.module('crudApp').controller('SearchController',
    ['SearchService', '$scope', '$localStorage','$location','$window', function( SearchService, $scope, $localStorage, $location, $window) {

        var self = this;
       self.count = 0;
        self.user = {};
        self.users=[];
    
        self.submit = submit;
        self.storeLocal = storeLocal;
        self.returnSearch = returnSearch;
        self.chkAvailable = chkAvailable;
        self.bookTkt = bookTkt;
        self.cancelBooking = cancelBooking;
        self.returnSeats = returnSeats;
        self.reset = reset;
        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;
        self.params = '';
        self.availParams='';
    
        
       //populate drop downs 
        self.stationNames = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'.split('');
        self.passengers = '12345'.split('');
        self.trainTime = '06:00,06:15,06:30,06:45,07:00,07:15,07:30,07:45,08:00,08:15,08:30,08:35,08:40,08:45,09:00,09:15,09:30,09:45,10:00,10:15,10:30,10:45,11:00,11:15,11:30,11:45,12:00,12:15,12:30,12:45,13:00,13:15,13:30,13:45,14:00,14:15,14:30,14:45,15:00,15:15,15:30,15:45,16:00,16:15,16:30,16:45,17:00,17:15,17:30,17:45,18:00,18:15,18:30,18:45,19:00,19:15,19:30,19:45,20:00,20:15,20:30,20:45,21:00'.split(',');
        self.ticketType = 'Any,Regular,Express'.split(',');
        self.connectionType = 'Any,None,One'.split(',');
       
        self.results = [];
        //Set default screen values
        $scope.selectedFromStation = "A";
        $scope.selectedToStation = "A";
        $scope.selectedPassengers = "1";
        $scope.selectedFromTime = "06:00";
        $scope.selectedToTime = "06:00";
        $scope.selectedTicketType = 'Any';
        $scope.selectedConnection = 'Any';
        $scope.chkExactTime = 'N';
        $scope.date = new Date();
        $scope.date1 = new Date();
        $scope.chkSelected = 'NO';
        $scope.depTrainType = '';
        $scope.retTrainType = '';
        
        var arr = [];
        var ticketSelected=[];
        var avail = '' ;
        
        $scope.GetValue = function () {
        	//alert($scope.selectedDirection);
        	
        	$scope.roundtripval = 0;
        	 var flag =0;
        	 var count = 0;
        	 var resArray = [];
        	 var dirArray=[];
          	if($scope.selectedDirection == "roundtrip"){
          		$scope.roundtripval = 1;
          		//alert($localStorage.results.length);
          		//alert($localStorage.resultsnew.length);
          	   for (var j = 0; j < $localStorage.results.length; j++) {
          		 if (count > 2){
         			 alert("Please select only two trains");
         			 flag =1;
         			 break;
         		  }
         		  else
         			  {
         			  if ($localStorage.results[j].Selected) {
                      	   count = count+1;
                      	   if(dirArray[0] == $localStorage.results[j].direction)
                      		   {
                      		   alert("You have selected 2 southbound trains");
                      		   flag =1;
                      		   }
                      	   else
                      		   {
                      		  // checkAvailable($localStorage.results[j].name, $localStorage.results[j])
                      	   resArray.push($localStorage.results[j]);
                      	   dirArray.push($localStorage.results[j].direction);
                      		   }
         			  }
         			  }
          		 if(flag == 1)
        			  break;
          		 }
          		 
          	}
          	else
          		// if oneway
          		{
          	  for (var i = 0; i < $localStorage.results.length; i++) {
          		   flag =0;
         		  if (count > 1){
         			 alert("Please select only one train");
         			 flag=1;
         			 break;
         		  }
         		  else
         			  {
         			  if ($localStorage.results[i].Selected) {
         				 // alert($localStorage.results[i].name);
         			   chkAvailable1($localStorage.results[i].name, $localStorage.results[i].direction);
         			 // alert("avail: " + $localStorage.available);
         			   if($localStorage.available > 0){
                      	  count = count+1;
                      	   resArray.push($localStorage.results[i]);
         			  }
         			   else{
         				  flag =1;
         				 alert("No seats available");
         				 break;
         				   }
         			   }
         			  }
         		  if(flag == 1)
         			  break;
          	  }
                
         	 
        }
         
          	ticketSelected = resArray;
          	//alert(JSON.stringify(ticketSelected));
          	 for (var k = 0; k < ticketSelected.length; k++) {
          		 //check direction selected in search filter
          		 //check directoin of selected train in result , compare to fix order
          		 $scope.depTrainType = ticketSelected[0].trainType;
                 $scope.depTrainNo = ticketSelected[0].name;
                
          		if($scope.selectedDirection == "roundtrip"){
          		$scope.retTrainNo = ticketSelected[1].name;
          		$scope.retTrainType = ticketSelected[1].trainType;
          		}
          		 //alert("depTrainType: " + $scope.depTrainType);
                // alert("retTrainType: " + $scope.retTrainType);
          		break;
          	 }
          	 for (var m = 0; m < ticketSelected.length; m++) {
          		 //check direction selected in search filter
          		 //check directoin of selected train in result , compare to fix order
          		 //dept to
          		if(ticketSelected[m].endStation == 'A')
          			$scope.depToTime = ticketSelected[m].a;
          		if(ticketSelected[m].endStation == 'B')
          			$scope.depToTime = ticketSelected[m].b;
          		if(ticketSelected[m].endStation == 'C')
          			$scope.depToTime = ticketSelected[m].c;
          		if(ticketSelected[m].endStation == 'D')
          			$scope.depToTime = ticketSelected[m].d;
          		if(ticketSelected[m].endStation == 'E')
          			$scope.depToTime = ticketSelected[m].e;
          		if(ticketSelected[m].endStation == 'F')
          			$scope.depToTime = ticketSelected[m].f;
          		if(ticketSelected[m].endStation == 'G')
          			$scope.depToTime = ticketSelected[m].g;
          		if(ticketSelected[m].endStation == 'H')
          			$scope.depToTime = ticketSelected[m].h;
          		if(ticketSelected[m].endStation == 'I')
          			$scope.depToTime = ticketSelected[m].i;
          		if(ticketSelected[m].endStation == 'J')
          			$scope.depToTime = ticketSelected[m].j;
          		if(ticketSelected[m].endStation == 'K')
          			$scope.depToTime = ticketSelected[m].k;
          		if(ticketSelected[m].endStation == 'L')
          			$scope.depToTime = ticketSelected[m].l;
          		if(ticketSelected[m].endStation == 'M')
          			$scope.depToTime = ticketSelected[m].m;
          		if(ticketSelected[m].endStation == 'N')
          			$scope.depToTime = ticketSelected[m].n;
          		if(ticketSelected[m].endStation == 'O')
          			$scope.depToTime = ticketSelected[m].o;
          		if(ticketSelected[m].endStation == 'P')
          			$scope.depToTime = ticketSelected[m].p;
          		if(ticketSelected[m].endStation == 'Q')
          			$scope.depToTime = ticketSelected[m].q;
          		if(ticketSelected[m].endStation == 'R')
          			$scope.depToTime = ticketSelected[m].r;
          		if(ticketSelected[m].endStation == 'S')
          			$scope.depToTime = ticketSelected[m].s;
          		if(ticketSelected[m].endStation == 'T')
          			$scope.depToTime = ticketSelected[m].t;
          		if(ticketSelected[m].endStation == 'U')
          			$scope.depToTime = ticketSelected[m].u;
          		if(ticketSelected[m].endStation == 'V')
          			$scope.depToTime = ticketSelected[m].v;
          		if(ticketSelected[m].endStation == 'W')
          			$scope.depToTime = ticketSelected[m].w;
          		if(ticketSelected[m].endStation == 'X')
          			$scope.depToTime = ticketSelected[m].x;
          		if(ticketSelected[m].endStation == 'Y')
          			$scope.depToTime = ticketSelected[m].y;
          		if(ticketSelected[m].endStation == 'Z')
          			$scope.depToTime = ticketSelected[m].z;
          		break;
          	 }
        	 for (var m = 0; m < ticketSelected.length; m++) {
          		//dept from
          		if(ticketSelected[m].startStation == 'A')
          			$scope.depFromTime = ticketSelected[m].a;
          		if(ticketSelected[m].startStation == 'B')
          			$scope.depFromTime = ticketSelected[m].b;
          		if(ticketSelected[m].startStation == 'C')
          			$scope.depFromTime = ticketSelected[m].c;
          		if(ticketSelected[m].startStation == 'D')
          			$scope.depFromTime = ticketSelected[m].d;
          		if(ticketSelected[m].startStation == 'E')
          			$scope.depFromTime = ticketSelected[m].e;
          		if(ticketSelected[m].startStation == 'F')
          			$scope.depFromTime = ticketSelected[m].f;
          		if(ticketSelected[m].startStation == 'G')
          			$scope.depFromTime = ticketSelected[m].g;
          		if(ticketSelected[m].startStation == 'H')
          			$scope.depFromTime = ticketSelected[m].h;
          		if(ticketSelected[m].startStation == 'I')
          			$scope.depFromTime = ticketSelected[m].i;
          		if(ticketSelected[m].startStation == 'J')
          			$scope.depFromTime = ticketSelected[m].j;
          		if(ticketSelected[m].startStation == 'K')
          			$scope.depFromTime = ticketSelected[m].k;
          		if(ticketSelected[m].startStation == 'L')
          			$scope.depFromTime = ticketSelected[m].l;
          		if(ticketSelected[m].startStation == 'M')
          			$scope.depFromTime = ticketSelected[m].m;
          		if(ticketSelected[m].startStation == 'N')
          			$scope.depFromTime = ticketSelected[m].n;
          		if(ticketSelected[m].startStation == 'O')
          			$scope.depFromTime = ticketSelected[m].o;
          		if(ticketSelected[m].startStation == 'P')
          			$scope.depFromTime = ticketSelected[m].p;
          		if(ticketSelected[m].startStation == 'Q')
          			$scope.depFromTime = ticketSelected[m].q;
          		if(ticketSelected[m].startStation == 'R')
          			$scope.depFromTime = ticketSelected[m].r;
          		if(ticketSelected[m].startStation == 'S')
          			$scope.depFromTime = ticketSelected[m].s;
          		if(ticketSelected[m].startStation == 'T')
          			$scope.depFromTime = ticketSelected[m].t;
          		if(ticketSelected[m].startStation == 'U')
          			$scope.depFromTime = ticketSelected[m].u;
          		if(ticketSelected[m].startStation == 'V')
          			$scope.depFromTime = ticketSelected[m].v;
          		if(ticketSelected[m].startStation == 'W')
          			$scope.depFromTime = ticketSelected[m].w;
          		if(ticketSelected[m].startStation == 'X')
          			$scope.depFromTime = ticketSelected[m].x;
          		if(ticketSelected[m].startStation == 'Y')
          			$scope.depFromTime = ticketSelected[m].y;
          		if(ticketSelected[m].startStation == 'Z')
          			$scope.depFromTime = ticketSelected[m].z;
          		break;
        	 }
          		//arr to
        		if($scope.selectedDirection == "roundtrip"){
        	 for (var m = 0; m < ticketSelected.length; m++) {
          		if(ticketSelected[m+1].endStation == 'A')
          			$scope.retToTime = ticketSelected[m+1].a;
          		if(ticketSelected[m+1].endStation == 'B')
          			$scope.retToTime = ticketSelected[m+1].b;
          		if(ticketSelected[m+1].endStation == 'C')
          			$scope.retToTime = ticketSelected[m+1].c;
          		if(ticketSelected[m+1].endStation == 'D')
          			$scope.retToTime = ticketSelected[m+1].d;
          		if(ticketSelected[m+1].endStation == 'E')
          			$scope.retToTime = ticketSelected[m+1].e;
          		if(ticketSelected[m+1].endStation == 'F')
          			$scope.retToTime = ticketSelected[m+1].f;
          		if(ticketSelected[m+1].endStation == 'G')
          			$scope.retToTime = ticketSelected[m+1].g;
          		if(ticketSelected[m+1].endStation == 'H')
          			$scope.retToTime = ticketSelected[m+1].h;
          		if(ticketSelected[m+1].endStation == 'I')
          			$scope.retToTime = ticketSelected[m+1].i;
          		if(ticketSelected[m+1].endStation == 'J')
          			$scope.retToTime = ticketSelected[m+1].j;
          		if(ticketSelected[m+1].endStation == 'K')
          			$scope.retToTime = ticketSelected[m+1].k;
          		if(ticketSelected[m+1].endStation == 'L')
          			$scope.retToTime = ticketSelected[m+1].l;
          		if(ticketSelected[m+1].endStation == 'M')
          			$scope.retToTime = ticketSelected[m+1].m;
          		if(ticketSelected[m+1].endStation == 'N')
          			$scope.retToTime = ticketSelected[m+1].n;
          		if(ticketSelected[m+1].endStation == 'O')
          			$scope.retToTime = ticketSelected[m+1].o;
          		if(ticketSelected[m+1].endStation == 'P')
          			$scope.retToTime = ticketSelected[m+1].p;
          		if(ticketSelected[m+1].endStation == 'Q')
          			$scope.retToTime = ticketSelected[m+1].q;
          		if(ticketSelected[m+1].endStation == 'R')
          			$scope.retToTime = ticketSelected[m+1].r;
          		if(ticketSelected[m+1].endStation == 'S')
          			$scope.retToTime = ticketSelected[m+1].s;
          		if(ticketSelected[m+1].endStation == 'T')
          			$scope.retToTime = ticketSelected[m+1].t;
          		if(ticketSelected[m+1].endStation == 'U')
          			$scope.retToTime = ticketSelected[m+1].u;
          		if(ticketSelected[m+1].endStation == 'V')
          			$scope.retToTime = ticketSelected[m+1].v;
          		if(ticketSelected[m+1].endStation == 'W')
          			$scope.retToTime = ticketSelected[m+1].w;
          		if(ticketSelected[m+1].endStation == 'X')
          			$scope.retToTime = ticketSelected[m+1].x;
          		if(ticketSelected[m+1].endStation == 'Y')
          			$scope.retToTime = ticketSelected[m+1].y;
          		if(ticketSelected[m+1].endStation == 'Z')
          			$scope.retToTime = ticketSelected[m+1].z;
          		break;
        	 }
        		}
          		//dept from
        		if($scope.selectedDirection == "roundtrip"){
        	 for (var m = 0; m < ticketSelected.length; m++) {
          		if(ticketSelected[m+1].startStation == 'A')
          			$scope.retFromTime = ticketSelected[m+1].a;
          		if(ticketSelected[m+1].startStation == 'B')
          			$scope.retFromTime = ticketSelected[m+1].b;
          		if(ticketSelected[m+1].startStation == 'C')
          			$scope.retFromTime = ticketSelected[m+1].c;
          		if(ticketSelected[m+1].startStation == 'D')
          			$scope.retFromTime = ticketSelected[m+1].d;
          		if(ticketSelected[m+1].startStation == 'E')
          			$scope.retFromTime = ticketSelected[m+1].e;
          		if(ticketSelected[m+1].startStation == 'F')
          			$scope.retFromTime = ticketSelected[m+1].f;
          		if(ticketSelected[m+1].startStation == 'G')
          			$scope.retFromTime = ticketSelected[m+1].g;
          		if(ticketSelected[m+1].startStation == 'H')
          			$scope.retFromTime = ticketSelected[m+1].h;
          		if(ticketSelected[m+1].startStation == 'I')
          			$scope.retFromTime = ticketSelected[m+1].i;
          		if(ticketSelected[m+1].startStation == 'J')
          			$scope.retFromTime = ticketSelected[m+1].j;
          		if(ticketSelected[m+1].startStation == 'K')
          			$scope.retFromTime = ticketSelected[m+1].k;
          		if(ticketSelected[m+1].startStation == 'L')
          			$scope.retFromTime = ticketSelected[m+1].l;
          		if(ticketSelected[m+1].startStation == 'M')
          			$scope.retFromTime = ticketSelected[m+1].m;
          		if(ticketSelected[m+1].startStation == 'N')
          			$scope.retFromTime = ticketSelected[m+1].n;
          		if(ticketSelected[m+1].startStation == 'O')
          			$scope.retFromTime = ticketSelected[m+1].o;
          		if(ticketSelected[m+1].startStation == 'P')
          			$scope.retFromTime = ticketSelected[m+1].p;
          		if(ticketSelected[m+1].startStation == 'Q')
          			$scope.retFromTime = ticketSelected[m+1].q;
          		if(ticketSelected[m+1].startStation == 'R')
          			$scope.retFromTime = ticketSelected[m+1].r;
          		if(ticketSelected[m+1].startStation == 'S')
          			$scope.retFromTime = ticketSelected[m+1].s;
          		if(ticketSelected[m+1].startStation == 'T')
          			$scope.retFromTime = ticketSelected[m+1].t;
          		if(ticketSelected[m+1].startStation == 'U')
          			$scope.retFromTime = ticketSelected[m+1].u;
          		if(ticketSelected[m+1].startStation == 'V')
          			$scope.retFromTime = ticketSelected[m+1].v;
          		if(ticketSelected[m+1].startStation == 'W')
          			$scope.retFromTime = ticketSelected[m+1].w;
          		if(ticketSelected[m+1].startStation == 'X')
          			$scope.retFromTime = ticketSelected[m+1].x;
          		if(ticketSelected[m+1].startStation == 'Y')
          			$scope.retFromTime = ticketSelected[m+1].y;
          		if(ticketSelected[m+1].startStation == 'Z')
          			$scope.retFromTime = ticketSelected[m+1].z;
          		break;
        	 }
        		}
          	 if(flag == 0){
          	storeLocal();
          	 }
        }
        
        
        //adding to local storage 
        function storeLocal() {
        //	$scope.trainNumber = val;
      
        //	self.passdata={userId:10, depTrainType:$scope.depTrainType, depTrainNo:$scope.trainNumber,depFrom:$scope.selectedFromStation,depTo:$scope.selectedToStation,depDate:"10-Dec-2017",depFromTime:$scope.selectedFromTime,depToTime:$scope.selectedToTime,retTrainNo:"1",retFrom:"M",retTo:"B",retDate:"10-Dec-2017",retFromTime:"0815",retToTime:"1000", retTrip:"1", noOfPassengers:$scope.selectedPassengers, baseFare:3,totalFare:15};
        	self.passdata={userEmail:"",
        			depTrainNo:$scope.depTrainNo,
        			depDate:$scope.date, 
        			depFromTime:$scope.depFromTime, 
        			depToTime: $scope.depToTime,
        			depFrom:$scope.selectedFromStation,
        			depTo: $scope.selectedToStation,
        			passengerCount:$scope.selectedPassengers,
        			retTrainNo:$scope.retTrainNo,
        			retDate:$scope.date1,
        			retFromTime:$scope.retFromTime,
        			retToTime:$scope.retToTime,
        			retFrom: $scope.selectedToStation, 
        			retTo: $scope.selectedFromStation,
        			retTrip:$scope.roundtripval,
        			depTrainType:$scope.depTrainType,
            		retTrainType:$scope.retTrainType};
        	
        	$localStorage.ticket = self.passdata;
        //alert (JSON.stringify($localStorage.ticket));
        	//$location.path("/bookTicket");
        var host = $window.location.host;
        //alert(host);
        var landingUrl = "http://" + host + "/cusr/#/bookTicket";
        //alert(landingUrl);
        $window.location.href = landingUrl;
        }

        function cancelBooking(){
        	  var host = $window.location.host;
            
              var redirUrl = "http://" + host + "/cusr/#/cancelTicket";
             // alert(redirUrl);
              
              $window.location.href = redirUrl;
        }
        
        function bookTkt(val) {
        	$localStorage.ticket = self.passdata;
        }
        
        //return search results 
        function returnSearch()
        {
        //	return $localStorage.results;
        	if($scope.selectedDirection == "roundtrip"){
        		//alert('in');
        		//$scope.rs = $localStorage.resultsnew;
        		//$scope.rs = $localStorage.resultsnew;
        		//alert("rows: " + JSON.stringify(	$scope.rs));
        		return 	$scope.rs;
        		
        	}
        	else{
        		//return $localStorage.results;
        		
        		return $scope.rs;
        	}
        		
        }
        //check availability
        function chkAvailable(trainNm, dir) {
        	var startTime = '';
        	var trainType = '';
        	if($scope.selectedTicketType == "Any"){
         		trainType = 'A';
         		$scope.depTrainType = trainType;
                $scope.retTrainType = trainType;
         	}
         	else if ($scope.selectedTicketType == "Express") {
         		trainType ='E';
         		$scope.depTrainType = trainType;
                $scope.retTrainType = trainType;
			}       
         	else{
         		trainType ='S';
         		$scope.depTrainType = trainType;
                $scope.retTrainType = trainType;
         	}
        	 $scope.depTrainType=trainType;
         startTime = $scope.selectedFromTime +':00';
         var dirn = '';
         if (($scope.selectedFromStation.charCodeAt(0) - $scope.selectedToStation.charCodeAt(0)) < 0)
        	 	dirn = 'S';
 		else
 			dirn = 'N';
       
         if(dirn == dir){
        	self.availParams = '?from='+$scope.selectedFromStation+
        	'&upto='+ $scope.selectedToStation+
        	'&trainName='+trainNm+
        	'&journeyDate='+$scope.date
        	  //alert(	self.availParams);
        }
        else
        	{
         self.availParams = '?from='+$scope.selectedFromStation+
        	'&upto='+ $scope.selectedToStation+
        	'&trainName='+trainNm+
        	'&journeyDate='+$scope.date1
      	 // alert(	self.availParams);
        	}
        	
        	self.available = SearchService.chkAvailable(self.availParams).then(function(promise) {
        		alert("Seats available: " + JSON.stringify($localStorage.available));
        	});
    
        }
        
        function returnSeats()
        {
       
        	if($localStorage.available == undefined){
        		
            		alert("Seats available: 5");
            		}
        		
        	else
        		{
        		alert("Seats available: " + JSON.stringify($localStorage.available));}
        }
        
        //another
        //check availability
        function chkAvailable1(trainNm, dir) {
        	var startTime = '';
        	var trainType = '';
        	if($scope.selectedTicketType == "Any"){
         		trainType = 'A';
         		$scope.depTrainType = trainType;
                $scope.retTrainType = trainType;
         	}
         	else if ($scope.selectedTicketType == "Express") {
         		trainType ='E';
         		$scope.depTrainType = trainType;
                $scope.retTrainType = trainType;
			}       
         	else{
         		trainType ='S';
         		$scope.depTrainType = trainType;
                $scope.retTrainType = trainType;
         	}
        	
        	 $scope.depTrainType=trainType;
         startTime = $scope.selectedFromTime +':00';
         var dirn = '';
         if (($scope.selectedFromStation.charCodeAt(0) - $scope.selectedToStation.charCodeAt(0)) < 0)
        	 	dirn = 'S';
 		else
 			dirn = 'N';
       
         if(dirn == dir){
        	self.availParams = '?from='+$scope.selectedFromStation+
        	'&upto='+ $scope.selectedToStation+
        	'&trainName='+trainNm+
        	'&journeyDate='+$scope.date
        	  //alert(	self.availParams);
        }
        else
        	{
         self.availParams = '?from='+$scope.selectedFromStation+
        	'&upto='+ $scope.selectedToStation+
        	'&trainName='+trainNm+
        	'&journeyDate='+$scope.date1
      	 // alert(	self.availParams);
        	}
        	
        	self.available = SearchService.chkAvailable(self.availParams).then(function(promise) {
        		//alert("Seats available: " + JSON.stringify($localStorage.available));
        		avail = $localStorage.available;
        	
        	});
    
        }
        

        //on submit of search
        function submit() {
        
        	$localStorage.results = [];
        $localStorage.resultsnew = [];
        $scope.rs = [];
        	if($scope.selectedFromStation == $scope.selectedToStation){
        		alert("Please select different station names");
        		return;
        	}
        	else{
        		var trainType = '';
     		var startTime = '';
     		//self.params = '?startStation=A&startTime=06:00:00&endStation=C&trainType=S&date=';
     	   //alert($scope.selectedTicketType);
     		if($scope.selectedTicketType == "Any"){
     		trainType = 'A';
     		$scope.depTrainType = trainType;
            $scope.retTrainType = trainType;
            //alert($scope.depTrainType);
     		
     		}
     		else if ($scope.selectedTicketType == "Express") {
     		trainType ='E';
     		$scope.depTrainType = trainType;
            $scope.retTrainType = trainType;
     		}       
     		else{
     		trainType ='S';
     		$scope.depTrainType = trainType;
            $scope.retTrainType = trainType;
     		}
     		startTime = $scope.selectedFromTime +':00';
         	if($scope.selectedDirection == "roundtrip")
      		 {
         		
         		var returnTime = '';
         		returnTime = $scope.selectedToTime +':00';
         		
         		self.params = '?startStation='+$scope.selectedFromStation+'&startTime='+startTime+'&endStation='+$scope.selectedToStation+'&trainType='+trainType+'&date='+$scope.date+'&exactTime='+$scope.chkExactTime;
         		//alert(self.params);
         		var a = [];
         		SearchService.searchTrains1(self.params).then(function(promise){
         			a = $localStorage.results;
         			//alert("a: " + a.length);
         			self.params = '?startStation='+$scope.selectedToStation+'&startTime='+returnTime+'&endStation='+$scope.selectedFromStation+'&trainType='+trainType+'&date='+$scope.date1+'&exactTime='+$scope.chkExactTime;
             		SearchService.searchTrainsRet(self.params).then(function(promise) {
             		var b = [];
             		var c = [];
             		b = $localStorage.resultsRet;
             		//alert("b: " + b.length);
             		c = a.concat(b);
             		//alert (JSON.stringify($localStorage.results));
             		//alert(a.length);
             		
             		//alert("c: " + c.length);
             		$localStorage.results = c;
             		$scope.rs = $localStorage.results;
             		//return $localStorage.results;
             		});
         		});
         		
         		
         		
      		 }
         	else
         		{
         		self.params = '?startStation='+$scope.selectedFromStation+'&startTime='+startTime+'&endStation='+$scope.selectedToStation+'&trainType='+trainType+'&date='+$scope.date+'&exactTime='+$scope.chkExactTime;
         		//alert(self.params);
         		SearchService.searchTrains1(self.params).then(function(promise){
         			$scope.rs = $localStorage.results;
         		});
         		}

          	//alert (JSON.stringify($localStorage.results));
         	//$scope.dt = SearchService.searchTrains1(self.params);
         	//alert(self.results[0].name);
         	//$scope.results = SearchService.searchTrains1(self.params);
//            alert($scope.selectedFromStation);
//            alert($scope.selectedToStation);
//            alert($scope.selectedDirection);
//            alert($scope.date);
//            alert($scope.date1);
//            alert($scope.selectedPassengers);
//            alert($scope.selectedFromTime);
//            alert($scope.selectedToTime);
//            alert($scope.selectedTicketType);
//            alert($scope.selectedConnection);
//            alert($scope.chkExactTime);
        	}
        }
        

        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.user={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);