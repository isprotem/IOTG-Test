var phonecatApp = angular.module('phonecatApp', []);

phonecatApp.controller('PhoneListCtrl', function ($scope) {
  $scope.phones = [
    {'name': 'Nexus S',
     'snippet': 'Fast just got faster with Nexus S.'},
    {'name': 'Motorola XOOM™ with Wi-Fi',
     'snippet': 'The Next, Next Generation tablet.'},
    {'name': 'MOTOROLA XOOM™',
     'snippet': 'The Next, Next Generation tablet.'}
  ];
});


var grsApp = angular.module('grsApp', []);

grsApp.controller('LocationCtrl', function ($scope, $http) { 
    $http.get('/location'). 
    then(function(data) { 
    	alert(JSON.stringify(data));
        $scope.locations = data; 
    }); 
});

grsApp.controller('FirstResponderCtrl', function ($scope, $http) { 
    $http.get('/firstResponders'). 
    then(function(data) { 
    	//alert(JSON.stringify(data));
        $scope.responders = data; 
    }); 
});

grsApp.controller('EquipmentCtrl', function ($scope, $http) { 
    $http.get('/getEquipments'). 
    then(function(data) { 
    	//alert(JSON.stringify(data));
        $scope.equipments = data; 
    }); 
});


grsApp.controller('LifeCycleManagementCtrl', function ($scope, $http) { 
    $http.get('/getLifeCycleManagementInfo'). 
    then(function(data) { 
    	//alert(JSON.stringify(data.data));
        $scope.incidentInfo = data.data; 
    }); 
});