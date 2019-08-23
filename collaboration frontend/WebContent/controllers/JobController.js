myApp.controller("JobController",function($scope,$https,$location,$rootScope)
{
 $scope.job={"jobId":0,"designation":"","description":"","companyName":"","location":"","ctc":0,"lastdateforApply":"","skills":""};
 
 $scope.jobs;

$scope.publishJob=function()
{
 console.log('Iam in publishJob Function');
 console.log($scope.job);
 
 $http.post('http://localhost:8036/middleware/addJob',$scope.job)
 .then(function(response)
		 {
	 alert("Job Posted");
		 },function(errorresponse)
		 {
			 alert("Error Occured While Posting Job");
		 });
}

function showJobs()
{
 console.log('I am in ShowJobs');
 $http.get('http://localhost:8036/middleware/showAllJobs')
 .then(function(response)
		 {
	 $scope.jobs=response.data;
		 },function(errorresponse)
		 {
			 alert("Error Occured While Posting Job");
		 
		 });
 }

 showAllJobs();


});