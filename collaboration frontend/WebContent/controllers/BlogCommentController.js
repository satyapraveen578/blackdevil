myApp.controller("BlogCommentController",function($scope,$http,$location,$rootScope)
{
	$scope.friend={"blogId":0,"blogname":"","username":"","status":"","blogContent":"","createDate":"","likes":0,"dislikes":0};
	
	$scope.blogComments;
	
	$scope.blogComment={"commentId":0,"commentText":"","username":"","commentDate":"","blogId":0};
	
	function loadAllComments()
	{
		console.log('I am in Comments');
		

	 	   $http.get('http://localhost:8036/middleWare/getAllBlogComments',$rootScope.blogId)
	 	   .then(function(response)
	 	   {
	 		  $scope.blogComments=response.data;
	 	   });
		
	}
      function blogInfo()
      {
    	  console.log('I am in Comments');
  		

	 	   $http.get('http://localhost:8036/middleWare/getBlog/',$rootScope.blogId)
	 	   .then(function(response)
	 	   {
	 		  $scope.blog=response.data;
	 	   });
    	  
      }
      $scope.addComment=function()
      {
    	  console.log('I am in Adding Comment');	  
    	  $scope.blogComment.blogId=$rootScope.blogId;
    	  $scope.blogComment.username=$rootScope.currentUser.username;
    	  $http.get('http://localhost::8036/middleWare/addComment/',$scope.blogComment)
	 	   .then(function(response)
	 	   {
    	       alert("Blog Comment Added");
    	       loadAllComments();
    	       bloginfo();
    	      
    	       
	 	   });
      }
      loadAllComments();
      bloginfo();
     
	});