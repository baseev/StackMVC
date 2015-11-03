<html class="no-js" lang="en">
<head>
<title>
	My StackMVC application
</title>

</head>

<body>
<div>My Stack MVC Application</div>
<div data-ng-controller="indexCtrl">

<a href="/#!/stack-mvc">Home</a>
||
<a href="/#!/stack-mvc/set-size">Set Size</a>
||
<a href="/#!/stack-mvc/push">Push</a>
||
<a href="/#!/stack-mvc/pop">Pop</a>
||
<a href="/#!/stack-mvc/list">List</a>

<div ng-view></div>

</div>

<!-- 
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.js"></script>
 -->
<script type="text/javascript" src="/static/js/angular.js"></script>
<script type="text/javascript" src="/static/js/angular-route.js"></script>
<script type="text/javascript" src="/static/js/angular-resource.js"></script>
<script type="text/javascript" src="/static/js/app.js"></script>

</body>
</html>