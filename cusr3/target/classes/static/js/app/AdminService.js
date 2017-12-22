'use strict';

angular.module('crudApp').factory('AdminService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

        var factory = {
        		cancelTrain: cancelTrain,
        		resetCapacity: resetCapacity
        };

        return factory;
        
        function cancelTrain(cancelTrainId, date) {
    		self.params ='?cancelTrainId='+cancelTrainId+'&date='+date;
        $http.put(urls.TRAIN_CANCEL_API + params)
            .then(
                function (response) {
                	alert("Train has been cancelled");
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                		alert("Invalid Train Id");
                   console.error('Error while cancelling Ticket : '+errResponse.data.errorMessage);
                   deferred.reject(errResponse);
                }
            );
        alert("After Method called");
        return deferred.promise;
        }
 
        function resetCapacity(capacity) {
    		self.params ='?newCapacity='+capacity;
        $http.put(urls.RESET_CAPACITY_API + params)
            .then(
                function (response) {
                	alert("Capacity has been reset");
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                		alert("Encountered an error while resetting the capacity");
                   console.error('Error while cancelling Ticket : '+errResponse.data.errorMessage);
                   deferred.reject(errResponse);
                }
            );
        alert("After Method called");
        return deferred.promise;
        }        
        
    }
]);