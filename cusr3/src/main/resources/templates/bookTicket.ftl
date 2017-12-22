  <div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead"> Purchase Ticket </span></div>
		<div class="panel-body">

 		     <table width = "100%" border = "0">
          		<tr valign = "top">
          			<td   width = "50">        
					<h4>Departure Trip</h4>
					<div class="table-responsive">
		        			<table class="table table-hover">
		            			<thead>
		            			<tr>
		              			<th>Train #</th>		           
		               			 <th>From</th>
		               			 <th>To</th>
		               			 <th>Date</th>
		               			 <th>Departure Time</th>
		               			 <th>Arrival Time</th>
		               			 <th width="100"></th>
		               			 <th width="100"></th>
		            			</tr>
		           		    </thead>
		           			 <tr>
		              			 <td>{{bookticketctrl.getSearchDetails().depTrainNo}}</td>
		               			 <td>{{bookticketctrl.getSearchDetails().depFrom}}</td>
		               			 <td>{{bookticketctrl.getSearchDetails().depTo}}</td>
		               			 <td>{{bookticketctrl.getSearchDetails().depDate}}</td>		               			
		               			 <td>{{bookticketctrl.getSearchDetails().depFromTime}}</td>
		               		     <td>{{bookticketctrl.getSearchDetails().depToTime}}</td>
		           			 </tr>
		       			</table>		
					</div>
					<div ng-switch on={{bookticketctrl.getSearchDetails().retTrip}}>	
					<div ng-switch-when="1">
					<h4>Return Trip</h4>
					<div class="table-responsive">
		        			<table class="table table-hover">
		            		<thead>
		            			<tr>
		              			<th>Train #</th>		           
		               			 <th>From</th>
		               			 <th>To</th>
		               			 <th>Date</th>
		               			 <th>Departure Time</th>
		               			 <th>Arrival Time</th>
		               			 <th width="100"></th>
		               			 <th width="100"></th>
		            	   		</tr>
		            	   		</thead>
		           		    </thead>
		           			 <tr>
		              			 <td>{{bookticketctrl.getSearchDetails().retTrainNo}}</td>
		               			 <td>{{bookticketctrl.getSearchDetails().retFrom}}</td>
		               			 <td>{{bookticketctrl.getSearchDetails().retTo}}</td>
		               			 <td>{{bookticketctrl.getSearchDetails().retDate}}</td>		               			
		               			 <td>{{bookticketctrl.getSearchDetails().retFromTime}}</td>
		               		     <td>{{bookticketctrl.getSearchDetails().retToTime}}</td>
		           			 </tr>
		       			 </table>				
		       		 </div>
		       		 </div>
		       		 </div>
            </td>

			<td bgcolor = "#eee" width = "50" height = "100">
			   <center>
               <h4> Fare Summary </h4>
               <table class="table table-hover">
               <tr> 
               		<th> Base Fare </th> <td>$ {{bookticketctrl.calculateFare()*bookticketctrl.getSearchDetails().passengerCount}}</td>
               </tr>
               <tr> 
               		<th> Number of Passengers </th> <td> {{bookticketctrl.getSearchDetails().passengerCount}}</td>
               </tr>
               <tr> 
               		<th> Transaction Fee </th> <td>$ 1</td>
               </tr>
               <tr> 
               	<th> Total Fare </th> <td>$ {{bookticketctrl.calculateFare()*bookticketctrl.getSearchDetails().passengerCount+1}}</td>
               </tr>
               </table>
               </center>
            </td>

           </tr>
          </table>
          			<h4> Enter Passenger Names </h4>
          			<br>
		            <tr>		            
	                <td> <div class="row"  ng-repeat="i in getPassengerCount(number) track by $index">         
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="Pssenger">Passenger {{$index+1}}</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="bookticketctrl.passengers.fname[$index+1]" id="fname[$index+1]" class="form-control input-sm" placeholder="First Name"/>
							    <br>
	                            <input type="text" ng-model="bookticketctrl.passengers.lname[$index+1]" id="lname[$index+1]" class="form-control input-sm" placeholder="Last Name"/>
	                        </div>
	                    </div>
	                </div>
				    </td>
		            </tr>

						<button type="button" ng-click="bookticketctrl.submit()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Book</button>
						<button type="button" ng-click="bookticketctrl.submit()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Cancel</button>
						
		   </div>	
    </div>
 