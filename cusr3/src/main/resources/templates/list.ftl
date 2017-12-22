<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">User </span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="userctrl.successMessage">{{userctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="userctrl.errorMessage">{{userctrl.errorMessage}}</div>
	            <form ng-submit="userctrl.submit()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="userctrl.user.id" />
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Name</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="userctrl.user.name" id="uname" class="username form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="age">Age</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="userctrl.user.age" id="age" class="form-control input-sm" placeholder="Enter your Age." required ng-pattern="userctrl.onlyIntegers"/>
	                        </div>
	                    </div>
	                </div>
	
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="salary">Salary</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="userctrl.user.salary" id="salary" class="form-control input-sm" placeholder="Enter your Salary." required ng-pattern="userctrl.onlyNumbers"/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="{{!userctrl.user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
	                        <button type="button" ng-click="userctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Users </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>ID</th>
		                <th>NAME</th>
		                <th>AGE</th>
		                <th>SALARY</th>
		                <th width="100"></th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="u in userctrl.getAllUsers()">
		                <td>{{u.id}}</td>
		                <td>{{u.name}}</td>
		                <td>{{u.age}}</td>
		                <td>{{u.salary}}</td>
		                <td><button type="button" ng-click="userctrl.editUser(u.id)" class="btn btn-success custom-width">Edit</button></td>
		                <td><button type="button" ng-click="userctrl.removeUser(u.id)" class="btn btn-danger custom-width">Remove</button></td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>