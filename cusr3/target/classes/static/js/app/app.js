var app = angular.module('crudApp',['ui.router','ngStorage','720kb.datepicker']);

app.constant('urls', {
    BASE: 'http://localhost:8080/cusr',
    USER_SERVICE_API : 'http://localhost:8080/cusr/api/user/',
    TRAIN_SEARCH_API : 'http://localhost:8080/cusr/api/search',
    TICKET_SEARCH_API : 'http://localhost:8080/cusr/api/ticket/',
    TICKET_AVAIL_API: 'http://localhost:8080/cusr/api/availability/',
    	TRAIN_CANCEL_API: 'http://localhost:8080/cusr/api/trainCancellation/',
    	TICKET_CANCEL_API : 'http://localhost:8080/cusr/api/cancel/',
    	RESET_CAPACITY_API : 'http://localhost:8080/cusr/api/updateCapacity/'
	
//	 BASE: 'http://localhost:8080/',
//	 USER_SERVICE_API : 'http://localhost:8080/api/user/',
//	 TRAIN_SEARCH_API : 'http://localhost:8080/api/search',
//	 TICKET_SEARCH_API : 'http://localhost:8080/api/ticket/',
//	 TICKET_AVAIL_API: 'http://localhost:8080/api/availability/',
//	 TRAIN_CANCEL_API: 'http://localhost:8080/api/trainCancellation/',
//	 TICKET_CANCEL_API : 'http://localhost:8080/api/cancel/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {
	  $stateProvider
	   .state('home', {
	          url: '/',
	          templateUrl: 'partials/search',
	          controller:'SearchController',
	          controllerAs:'ctrl'
	      })
	   .state('bookTicket', {
	          url: '/bookTicket',
	          templateUrl: 'partials/bookTicket',
	          controller:'BookTicketController',
	          controllerAs:'bookticketctrl',
              resolve: {
                  users: function ($q, BookTicketService) {
                      console.log('Load Booking Details');
                      var deferred = $q.defer();
                      BookTicketService.loadSearchDetails().then(deferred.resolve, deferred.resolve);
                      return deferred.promise;
                  }
              }
	      })
	   .state('ticketSuccess', {
	          url: '/ticketSuccess',
	          templateUrl: 'partials/ticketSuccess',
	          controller:'BookTicketController',
	          controllerAs:'bookticketctrl'
	      })
	   .state('ticketError', {
	          url: '/ticketError',
	          templateUrl: 'partials/ticketError',
	          controller:'BookTicketController',
	          controllerAs:'bookticketctrl'
	      })
	  .state('cancelTicket', {
	          url: '/cancelTicket',
	          templateUrl: 'partials/cancelTicket',
	          controller:'BookTicketController',
	          controllerAs:'bookticketctrl'
	      })
	  .state('admin', {
	          url: '/admin',
	          templateUrl: 'partials/admin',
	          controller:'AdminController',
	          controllerAs:'adminctrl'
	      });
        $urlRouterProvider.otherwise('/');
    }]);

