<div class="panel" >
<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Search Trains </span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	             <div class="form-actions col-md-12">
	                     <button type="button"  ng-click="ctrl.cancelBooking();" class="btn btn-cancel col-md-2" >Cancel Booking</button>
	                    </div>
	                 <div class="col-md-4 row" >
    							<input type="radio" name="occurrence" ng-model="selectedDirection" value="oneway" ng-checked ="true" ng-click="showHideTest=false"/>
    							<label for="oneway">One way</label>
    							<input type="radio" name="occurrence" ng-model="selectedDirection" value="roundtrip" ng-click="showHideTest=true"/>
    							<label for="round">Roundtrip</label>
    							
					</div>
	                <div class="row"></br></div></br>
	                <div class="row col-md-12" >
	                    <div class="form-group">
	                       <div class="col-md-4">
	                       	<label class="control-lable">Travelling from</label>
	                       	<div class="">
	                       	<select class="col-md-5 form-control" ng-model= "selectedFromStation" ng-options="x for x in {{ctrl.stationNames}}">
	                  		<!--<option value="">-- SELECT --</option>-->
							</select>
	                        </div>
	                       </div>
	                       
	                       <div class="col-md-4">
	                         <label class="control-lable">Travelling to</label>
	                         <div class="">
  								<select class="col-md-5 form-control" ng-model= "selectedToStation" ng-options="x for x in {{ctrl.stationNames}}">
	                       	</select>
	                       </div>
	                    	  </div>
	                    	  
	                    	  <div class="col-md-4">
	                         <label class="control-lable">Passengers</label>
	                         <div class="">
  							 <select class="col-xs-3 form-control_new" ng-model= "selectedPassengers" ng-options="x for x in {{ctrl.passengers}}">
  							 
	                       	</select>
	                        </div>
	                    	  </div>
	                    	  
	                    	 </div>
	               </div
	               </div>

	                  <div class="row col-md-12">
	                    <br>
	                    <div class="form-group">
	                    
	                    <div class="col-md-2">	
        						<label>Departure Date</label>
        						<datepicker>
  								<input ng-model="date" type="text" date-format="medium" class="form-control_new col-md-12 ng-pristine ng-valid ng-empty ng-touched"/>
							</datepicker>
						</div>
						
						<div class="col-md-2">
	                         <label class="control-lable">Departure Time</label>
	                         <div class="">
  								 <select class="col-xs-12 form-control_new" ng-model= "selectedFromTime" ng-options="x for x in {{ctrl.trainTime}}">
  								 </select>
	                        </div>
	                    	  </div>	
						 <div ng-show="showHideTest" ng-model="showHideTest">
						<div class="col-md-2">
        						<label class="">Returning Date</label>
        						<datepicker>
  								<input ng-model="date1" type="text" class="form-control_new col-md-12 ng-pristine ng-valid ng-empty ng-touched"/>
							</datepicker>
						</div>
						
						<div class="col-md-2">
	                         <label class="control-lable">Returning Time</label>
	                         	<div class="">
  									 <select class="col-xs-12 form-control_new" ng-model= "selectedToTime" ng-options="x for x in {{ctrl.trainTime}}">
  									
  									 </select>
	                        		</div>
	                    	 </div>
	                    	 </div>
	                    
	                    	<div class="col-md-12">
	                    <br>
	                    <div class="form-group">
	                       
						<div class="col-md-2">
	                         <label class="control-lable">Ticket Type</label>
	                          <div class="">
  							 <select class="col-xs-12 form-control_new" ng-model= "selectedTicketType" ng-options="x for x in {{ctrl.ticketType}}">
  							 
  							  </select>
	                        </div>
	                    	  </div>	

						<div class="col-md-2">
	                         <label class="control-lable">Connections</label>
	                         <div class="">
  							 <select class="col-xs-12 form-control_new" ng-model= "selectedConnection" ng-options="x for x in {{ctrl.connectionType}}">
  							
  							  </select>
	                        </div>
	                    	  </div>
	                    	  
	                    	  </br></br>
	                    	  
						<div class="col-md-2">
    							<input type="checkbox" ng-model= "chkExactTime" ng-true-value="'Y'" ng-false-value="'N'">
    							<label>Exact Time</label>
  						</div>
  						
					</div>
					</div>
				</div>
		</div>
		</div>
		</br></br>
		
	                <div class="row">
	                    <div class="form-actions col-md-12">
	                     <button type="button" ng-click="ctrl.submit();showHideTest1=true; " class="btn btn-warning col-md-1" >Search</button>
	                    </div>
	                </div>
	       
        </form>
	           
</div>

 <div class="panel" ng-show="showHideTest1" ng-model="showHideTest1">
        <div class="panel-heading"><span class="lead">Trains From Station {{selectedFromStation}} </span></div>
		<div class="panel-body">
			<div class="table-responsive">
			
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>TRAIN#</th>
		                 <th>TYPE</th>
		                <th>DEPARTURE</th>
		                <th>ARRIVAL</th>
		                <th width="100"></th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		             <tr ng-show="ctrl.returnSearch().length!=0" ng-repeat="u in ctrl.returnSearch()">
		                <td>{{u.name}}</td>
		                <td>{{u.trainType}}</td>
		                 <!--<td>{{u.startStation}}</td>
		                <td>{{u.endStation}}</td>-->
		                <td ng-if="u.startStation === 'A'">{{u.a}}</td>
		                <td ng-if="u.startStation === 'B'">{{u.b}}</td>
		                <td ng-if="u.startStation === 'C'">{{u.c}}</td>
		                <td ng-if="u.startStation === 'D'">{{u.d}}</td>
		                
		                <td ng-if="u.startStation === 'E'">{{u.e}}</td>
		                <td ng-if="u.startStation === 'F'">{{u.f}}</td>
		                <td ng-if="u.startStation === 'G'">{{u.g}}</td>
		                <td ng-if="u.startStation === 'H'">{{u.h}}</td>
		                
		                <td ng-if="u.startStation === 'I'">{{u.i}}</td>
		                <td ng-if="u.startStation === 'J'">{{u.j}}</td>
		                <td ng-if="u.startStation === 'K'">{{u.k}}</td>
		                <td ng-if="u.startStation === 'L'">{{u.l}}</td>
		                
		                <td ng-if="u.startStation === 'M'">{{u.m}}</td>
		                <td ng-if="u.startStation === 'N'">{{u.n}}</td>
		                <td ng-if="u.startStation === 'O'">{{u.o}}</td>
		                <td ng-if="u.startStation === 'P'">{{u.p}}</td>
		                
		                <td ng-if="u.startStation === 'Q'">{{u.q}}</td>
		                <td ng-if="u.startStation === 'R'">{{u.r}}</td>
		                <td ng-if="u.startStation === 'S'">{{u.s}}</td>
		                <td ng-if="u.startStation === 'T'">{{u.t}}</td>
		                
		                <td ng-if="u.startStation === 'U'">{{u.u}}</td>
		                <td ng-if="u.startStation === 'V'">{{u.v}}</td>
		                <td ng-if="u.startStation === 'W'">{{u.w}}</td>
		                <td ng-if="u.startStation === 'X'">{{u.x}}</td>
		                
		                <td ng-if="u.startStation === 'Y'">{{u.y}}</td>
		                <td ng-if="u.startStation === 'Z'">{{u.z}}</td>
		                
		                <td ng-if="u.endStation === 'A'">{{u.a}}</td>
		                <td ng-if="u.endStation === 'B'">{{u.b}}</td>
		                <td ng-if="u.endStation === 'C'">{{u.c}}</td>
		                <td ng-if="u.endStation === 'D'">{{u.d}}</td>
		                
		                <td ng-if="u.endStation === 'E'">{{u.e}}</td>
		                <td ng-if="u.endStation === 'F'">{{u.f}}</td>
		                <td ng-if="u.endStation === 'G'">{{u.g}}</td>
		                <td ng-if="u.endStation === 'H'">{{u.h}}</td>
		                
		                <td ng-if="u.endStation === 'I'">{{u.i}}</td>
		                <td ng-if="u.endStation === 'J'">{{u.j}}</td>
		                <td ng-if="u.endStation === 'K'">{{u.k}}</td>
		                <td ng-if="u.endStation === 'L'">{{u.l}}</td>
		                
		                <td ng-if="u.endStation === 'M'">{{u.m}}</td>
		                <td ng-if="u.endStation === 'N'">{{u.n}}</td>
		                <td ng-if="u.endStation === 'O'">{{u.o}}</td>
		                <td ng-if="u.endStation === 'P'">{{u.p}}</td>
		                
		                <td ng-if="u.endStation === 'Q'">{{u.q}}</td>
		                <td ng-if="u.endStation === 'R'">{{u.r}}</td>
		                <td ng-if="u.endStation === 'S'">{{u.s}}</td>
		                <td ng-if="u.endStation === 'T'">{{u.t}}</td>
		                
		                <td ng-if="u.endStation === 'U'">{{u.u}}</td>
		                <td ng-if="u.endStation === 'V'">{{u.v}}</td>
		                <td ng-if="u.endStation === 'W'">{{u.w}}</td>
		                <td ng-if="u.endStation === 'X'">{{u.x}}</td>
		                
		                <td ng-if="u.endStation === 'Y'">{{u.y}}</td>
		                <td ng-if="u.endStation === 'Z'">{{u.z}}</td>
		              
		                <td><button type="button"  ng-click="ctrl.chkAvailable(u.name,u.direction);" class="btn btn-success">Check Availability</button></td>
		              <td> <input type="checkbox" ng-model= "u.Selected" ng-checked ="flase">
    							<label>Select</label></td>
		           </tr>
		         
		          <tr>
		          <td ng-show="ctrl.returnSearch().length!=0">
  			  <button type="button" ng-click="GetValue()" class="btn btn-warning col-md-6">Book</button>
  			  </td></tr>
  			<tr>
        <td ng-show="ctrl.returnSearch().length==0">
            No results found!                
        </td>
    </tr>
		            </tbody>
		           
		        </table>		
		        
		                
			</div>
		</div>
    </div>
    	    </div> 
		</div>	
    </div>
    </div>
   