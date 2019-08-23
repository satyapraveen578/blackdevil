myApp.controller("FriendController",function($scope,$http,$location,$rootScope)
{
  $scope.friend={"friendId":0,"username":"","friendusername":"","status":""};
  
$scope.friendList;

$scope.pendingFriendList;

$scope.suggestedFriendList;

function showFriendList()
{
	console.log('I am in FriendList');
	
	$http.get('https://localhost:8036/middleware/showFriendList/'+$rootScope.currentUser.username)
	.then(function(response){
		$scope.friendList=response.data;
	},function(errorresponse){
		alert("Error Occured");
		});
	
	}

 function showPendingFriendList()
 {
	 
 }
 
 function showSuggestedFriendList()
 {
	 
 }
	
showPendingFriendList();
showSuggestedFriendList();
showFriendList();
});

		