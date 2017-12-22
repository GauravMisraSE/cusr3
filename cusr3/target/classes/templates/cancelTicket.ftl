<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Please enter your Ticket Id to cancel the ticket</span></div>
        <br>
        <br>
        			<input type="text" ng-model="bookticketctrl.cancelTicketId" id="ticketId" placeholder="Ticket Id"/> 
        	<br>
        	<br>
        	<button type="button" ng-click="bookticketctrl.cancelTicket()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Cancel Ticket</button>
    </div>
</div>