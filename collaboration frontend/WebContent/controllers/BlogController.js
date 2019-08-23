myApp.controller("BlogController",function($scope,$http,$location,$rootScope)
{

$scope.blog={"blogId":"0","blogName":"","blogContent":"","username":"","createDate":"","status":"","likes":"0","dislikes":"0"};
	
$scope.blogDetail;

$rootScope.blog1;

$rootScope.blogId;

$scope.addBlog=function()
{
   console.log('Iam in Add Blog');
   
   $scope.blog.username=$rootScope.currentUser.username;
   
   $http.post('http://localhost:8036/middleware/addBlog',$scope.blog)
   .then(function(response){
	   alert("Blog Added");
	   showAllBlogs();
   },function(errorresponse){
	   alert("Error Occured While Blog Adding");
   });
}

$scope.showComments(blogId)
{
	$rootScope.blogId=blogId;
	$location.path("/blogComments");
	}


$scope.updateBog=function()
{
console.og('Iam in Update Blog');

$rootScope.blog1.username=$rootScope.currentUser.username;

$http.post('http://localhost:8036/middleware/updateBlog',$rootScope.blog1)
.then(function(response){
	alert("Blog Updated");
$location.path("/showBlog");
},function(errorresponse){
alert("Error Occured While Blog Updating");
});
}

$scope.incrementLikes=function(blogId)
{
    console.log('Iam in Increment Likes');
    
    $http.get('http://localhost:8036/middleware/incrementLikes/'+blogId)
    .then(function(response)
     {
    	alert("-Thank You for Liking the Blog!!!");
    	showAllBlogs();
    },function(errorresponse)
    {
    	alert("Error Occured While Incremently Likes the Blogs");
    });
}

$scope.incrementDislikes=function(blogId)
{
  console.log('Iam in Increment Likes');
  
  $http.get('http://localhost:8036/middleware/incrementDislikes/'+blogId)
  .then(function(response)
		  {
	  alert("-oops we will try to Improve.Thanksfor Feedback!!!");
	  showAllBlogs();
		  },function(errorresponse)
		  {
			  alert("Error Occured While Incrementing Dislikes the Blogs");
		  });
}


 function showAllBlogs()
 {
	 console.log('Iam in show All Blogs');
	 
	 $http.get('http://localhost:8036/middleware/showAllBlogs')
	 .then(function(response){
		 $scope.blogDetail=response.data;
	 },function(errorresponse){
		 alert("Error Occured While Blog Retriving the Blogs");
	 });
 }
 
 showAllBlogs();
 
 
});		