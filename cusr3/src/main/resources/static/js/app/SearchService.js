'use strict';

angular.module('crudApp').factory('SearchService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {
            var factory = {
            		searchTrains: searchTrains,
            		searchTrains1: searchTrains1,
            		searchTrainsRet:searchTrainsRet,
            		chkAvailable:chkAvailable
            };

            return factory;
          
            function searchTrains() {
           		  var deferred = $q.defer();
                  $http.get(urls.TRAIN_SEARCH_API + "all")
                      .then(
                          function (response) {
                              console.log('Fetched successfully!');
                           
                              deferred.resolve(response.data);
                          },
                          function (errResponse) {
                              console.error('Error while searching');
                              deferred.reject(errResponse);
                          }
                      );
                  return deferred.promise;
                  //return response.data;
            }
            
            function searchTrains1(params) {
                var deferred = $q.defer();
                var res = '';
                $http.get(urls.TRAIN_SEARCH_API + params)
                    .then(
                        function (response) {
                            console.log('Search successful');
                            console.log(response.data);
                            $localStorage.results = response.data;
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while searching');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
               // return res;
            }
            
            function searchTrainsRet(params) {
                var deferred = $q.defer();
                var res = '';
                $http.get(urls.TRAIN_SEARCH_API + params)
                    .then(
                        function (response) {
                            console.log('Search successful');
                            console.log(response.data);
                            $localStorage.resultsRet = response.data;
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while searching');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
               // return res;
            }
            
            function chkAvailable(params) {
                var deferred = $q.defer();
                var res = '';
                //CHANGE API URL
                $http.get(urls.TICKET_AVAIL_API + params)
                    .then(
                        function (response) {
                            console.log('chk availability -successful');
                            console.log(response.data);
                            $localStorage.available = response.data;
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while checking availability');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            
            }
        }
    ]);