'use strict';

angular.module('crudApp').controller('AdminController',
    ['AdminService', '$scope','$location','$window',  function( AdminService, $scope, $location, $window) {

        var self = this;
        
        self.cancelTrain = cancelTrain;
        self.resetCapacity = resetCapacity;
        self.cancelTrainId ='';
        self.capacity ='';
        $scope.date = new Date();
       
        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;
        
        function cancelTrain() {
    		AdminService.cancelTrain(self.cancelTrainId,$scope.date);
        }
        
        function resetCapacity() {
    		//alert("Reset Capacity");
    		//alert(self.Capacity);
    		AdminService.resetCapacity(self.capacity);
        }

    }
    ]);