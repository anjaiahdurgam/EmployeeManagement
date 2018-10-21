

<!DOCTYPE html>
<html>
<head>
<title>Learning Bootstrap</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
 


    <style type="text/css">
        body { background: url(assets/bglight.png); }
        .hero-unit { background-color: #fff; }
        .center { display: block; margin: 0 auto; }
        .container1
 {
     background-color: yellowgreen;
 }

.jumbotron {
    position: relative;
    padding: 40px 0;
    color: #fff;
    text-align: center;
    text-shadow: 0 1px 3px rgba(0,0,0,.4), 0 0 30px rgba(0,0,0,.075);
    background: #020031;
    background: -moz-linear-gradient(45deg, #020031 0%, #6d3353 100%);
    background: -webkit-gradient(linear, left bottom, right top, color-stop(0%,#020031), color-stop(100%,#6d3353));
    background: -webkit-linear-gradient(45deg, #020031 0%,#6d3353 100%);
    background: -o-linear-gradient(45deg, #020031 0%,#6d3353 100%);
    background: -ms-linear-gradient(45deg, #020031 0%,#6d3353 100%);
    background: linear-gradient(45deg, #020031 0%,#6d3353 100%);
    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#020031', endColorstr='#6d3353',GradientType=1 );
    -webkit-box-shadow: inset 0 3px 7px rgba(0,0,0,.2), inset 0 -3px 7px rgba(0,0,0,.2);
    -moz-box-shadow: inset 0 3px 7px rgba(0,0,0,.2), inset 0 -3px 7px rgba(0,0,0,.2);
    box-shadow: inset 0 3px 7px rgba(0,0,0,.2), inset 0 -3px 7px rgba(0,0,0,.2);
}
/*
.jumbotron::after {
    content: '';
    display: block;
    position: relative; /* changed by me */
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    background: url(../img/bs-docs-masthead-pattern.png) repeat center center;
    opacity: .4;
}
.jumbotron {
    margin-bottom: 0px;
    background-image: src(images/screenshot.png);
    background-position: 0% 25%;
    background-size: cover;
    background-repeat: no-repeat;
    color: white;
    text-shadow: black 0.3em 0.3em 0.3em;
}
.profile-img-card {
    width: 96px;
    height: 96px;
    margin: 0 auto 10px;
    display: block;
    -moz-border-radius: 50%;
    -webkit-border-radius: 50%;
    border-radius: 50%;
}
.btn-signin {
    /*background-color: #4d90fe; */
    background-color: #ff6600;
    /* background-color: linear-gradient(rgb(104, 145, 162), rgb(12, 97, 33));*/
    padding: 0px;
    font-weight: 700;
    font-size: 14px;
    height: 36px;
    -moz-border-radius: 3px;
    -webkit-border-radius: 3px;
    border-radius: 3px;
    border: none;
    -o-transition: all 0.218s;
    -moz-transition: all 0.218s;
    -webkit-transition: all 0.218s;
    transition: all 0.218s;
}
.card-container.card {
    width: 350px;
    padding: 40px 40px;
}
body, html {
    height: 100%;
    background-repeat: no-repeat;
    background-image: linear-gradient(rgb(255, 230, 209), rgb(146, 164, 133));
}
.card {
    background-color: #F7F7F7;
    /* just in case there no content*/
    padding: 20px 25px 30px;
    margin: 0 auto 25px;
    margin-top: 50px;
    /* shadows and rounded borders */
    -moz-border-radius: 2px;
    -webkit-border-radius: 2px;
    border-radius: 2px;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}
.card-container.card {
    width: 350px;
    padding: 40px 40px;
}
/*
Free App template for Bootstrap 3
Code snippet by maridlcrmn for Bootsnipp.com
Follow me on Twitter @maridlcrmn
Image credits: unsplash.com
Image placeholders: placemi.com
*/


.mt-100 {
    margin-top: 100px; 
}
.mb-100 {
    margin-bottom: 100px;
}

.icon {
    width: 32px;
    height: 32px;
    text-align: center;
    padding: 7px 8px;
    border: 2px solid;
    border-radius: 50%;
}

.header {
    padding-top: 50px;
    background-color: #eee;
    overflow: hidden;
}
.footer {
    color: #887;
    background-color: #eee;
    padding-top: 30px;
    padding-bottom: 30px;
}

.content {
    position: relative;
    display: table;
    width: 100%;
    min-height: 100vh;
}
.pull-middle {
    display: table-cell;
    vertical-align: middle;
}

.btn {
    padding-left: 25px;
    padding-right: 25px;
}
.btn-circle {
    border-radius: 20px;
}

.input-group input {
    border: 0;
    box-shadow: none;
    padding-right: 30px;
}
.input-group input:focus,
.input-group input:active {
    outline: 0;
    box-shadow: none;
}
.input-group-btn:last-child>.btn {
    z-index: 2;
    margin-left: -18px;   
    border-radius: 20px;
}

.phone {
    position: relative;
    max-width: 276px;
    margin: 80px auto;
    padding: 45px 9px 68px;
    border: 2px solid #ddd;
    border-radius: 20px;
    background-color: #222;
    box-shadow: 20px 20px 40px #887;
}
#li{
color:white;
}

    </style>
</head>
<body>
<div class="wrapper">
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navigation">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand text-uppercase" href="#">Grey Campus <span class="label label-success text-capitalize">Free</span></a>
        </div>
    
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navigation">
            <ul class="nav navbar-nav navbar-right">
                     
                <li><a href="#" id="li" class="manager">Manager</a></li>
                <li><a href="#" id="li" class="employee">Employee</a></li>
                <li><a href="#" id="li" class="hr">Hr</a></li>
                 <li><a href="#"></a></li>
                <li><a href="#"></a></li>
                 <li><a href="#"></a></li>
                <li><a href="#"></a></li>
                <li><a href="#"></a></li>
                 <li><a href="#"></a></li>
                <li><a href="#"></a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Features</a></li>
                <li><button type="button" class="btn btn-success navbar-btn btn-circle">Sign in</button></li>
            </ul>
        </div>
      </div>
    </nav>
   
    <section class="section">
        <div class="container">
            <div class="row">
               <div class="col-md-4 col-md-offset-1 text-center mt-100 mb-100">
                                  </div>
                <div class="col-md-5 col-md-offset-1">
                    <div class="content">
                     
                    </div>
                </div>
            </div>
        </div>
    </section>
 
    <footer class="footer text-center">
        <div class="container">
            <small>� Copyright 2015. Crafted with love by <a href="https://www.twitter.com/maridlcrmn">@maridlcrmn</a></small>
        </div>
    </footer>
</div>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<script>
 $(document).ready(function(){

	  $(".manager").click(function(e){
		
		   $(".content").load("dummy.html");
	  })
 });
 </script>
</body>

</html>
