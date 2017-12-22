<!DOCTYPE html>

<html lang="en" ng-app="crudApp">
    <head>
        <title>${title}</title>
     
     
        <link href="css/angular-datepicker.css" rel="stylesheet"/>
        <link href="css/app.css" rel="stylesheet"/>
        <link href="css/bootstrap.css" rel="stylesheet"/>
    </head>
    <body>

        <div ui-view></div>
        <script src="js/lib/custom.js" ></script>
        <script src="js/lib/angular.min.js" ></script>
        <script src="js/lib/angular-ui-router.min.js" ></script>
        <script src="js/lib/localforage.min.js" ></script>
        <script src="js/lib/ngStorage.min.js"></script>
        <script src="js/lib/angular-datepicker.js"></script>
        <script src="js/app/app.js"></script>
        <script src="js/app/SearchController.js"></script>
        <script src="js/app/SearchService.js"></script>
        <script src="js/app/UserService.js"></script>
        <script src="js/app/UserController.js"></script>
        <script src="js/app/BookTicketService.js"></script>
        <script src="js/app/BookTicketController.js"></script>   
        <script src="js/app/AdminController.js"></script>
        <script src="js/app/AdminService.js"></script>      
    </body>
</html>