<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Admin</span></div>
        <table>
        <tr>
        <td><h4>&nbsp Cancel Train &nbsp<h4> </td>
        
        	<td>&nbsp<input type="text" ng-model="adminctrl.cancelTrainId" id="ticketId" placeholder="Enter Train Id" required ng-pattern="adminctrl.onlyIntegers"/>&nbsp &nbsp</td>
        	<td>
        <datepicker>
  			<input ng-model="date" type="text" date-format="medium" class="ng-pristine ng-valid ng-empty ng-touched"/>
		</datepicker></td>
			<td>&nbsp<button type="button" ng-click="adminctrl.cancelTrain()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Submit</button></td>
		</tr>
	
      
        	<br>
        	<br>
        	<tr>
        	<td><h4>&nbsp Reset Train Capacity &nbsp<h4> </td>
        <td>&nbsp<input type="text" ng-model="adminctrl.capacity" id="ticketId" placeholder="Enter Train Capacity" required ng-pattern="adminctrl.onlyIntegers"/>&nbsp &nbsp</td>
        <td>&nbsp<button type="button" ng-click="adminctrl.resetCapacity()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Submit</button>
        	<br>
        	<br>
        	</td>
        	</table>
    </div>
</div>