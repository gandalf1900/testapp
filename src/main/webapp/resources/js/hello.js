function blogs($scope, $http) {
    $http.get('http://localhost:8080/testapp/rest/blogs/all').
        success(function(data) {
            $scope.blog = data;
            $scope.blog = data;
        });
}