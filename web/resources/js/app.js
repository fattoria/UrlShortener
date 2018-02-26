var app = angular.module('url_shortener', ['angularUtils.directives.dirPagination']);

app.controller('listdata',function($scope, $http){
	$scope.hashs = [{"hash_link":'jRa',"uri":"http://facebook.com/","created_at":Date.parse("2018-02-25T23:09:21+00:00")},
        {"hash_link":'jRa',"uri":"http://facebook.com/","created_at":Date.parse("2018-10-25T23:09:21+00:00")},
        {"hash_link":'jRa',"uri":"http://facebook.com/","created_at":Date.parse("2017-02-25T23:09:21+00:00")},
        {"hash_link":'jRa',"uri":"http://facebook.com/","created_at":Date.parse("2018-02-24T23:09:21+00:00")},
        {"hash_link":'jRa',"uri":"http://facebook.com/","created_at":Date.parse("2018-02-25T08:20:21+00:00")}];
	
	$scope.sort = function(keyname){
	    if ($scope.sortKey == keyname) {
            $scope.reverse = !$scope.reverse;
        } else {
            $scope.sortKey = keyname;
            $scope.reverse = false;
        }
	}

    $scope.edit = function(hash){

    }

    $scope.remove = function(hash){
        $scope.hashs =  $scope.hashs.filter(e => e !== hash);
    }
});