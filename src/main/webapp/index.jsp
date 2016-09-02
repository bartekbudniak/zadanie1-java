<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Formularz rat kredytu</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <div class="jumbotron">
	<h1>Kredyty</h1>      
  </div>

	<h2>Wypełnij formularz, aby otrzymać harmonogram rat kredytu.</h2>
	<button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">Wypełnij formularz</button>
    <div id="demo" class="collapse">
    <br>
        <form class="form-horizontal" role="form" method="get" action="harmonogram">
            <div class="form-group">
              <label class="col-sm-4 control-label" for="usr">Wnioskowana kwota kredytu:</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="usr" placeholder="wpisz kwotę w zł" name="kwota" required>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label" for="usr">Ilość rat w miesiącach:</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="usr" placeholder="wpisz ilość rat" name="raty" required>
                </div>
            </div>
             <div class="form-group">
                <label class="col-sm-4 control-label" for="usr">Oprocentowanie w skali roku:</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="usr" placeholder="wpisz oprocentowanie" name="oprocentowanie" required>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label" for="usr">Opłata stała:</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="usr" placeholder="wpisz opłatę stałą w zł" name="oplata" required>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label" for="usr">Rodzaj rat:</label>
                <div class="col-sm-8">
                    <select class="form-control" name="rodzaj">
                      <option value="malejaca">malejąca</option>
                      <option value="stala" checked>stała</option>
                    </select>
                </div>
            </div>
            <div class="form-group">        
              <div class="col-sm-offset-4 col-sm-8">
                <input type="submit" class="btn btn-success" name="wyslij" value="Zatwierdź i wyślij"><br>
              </div>
            </div>
        </form>
    </div> 
    	     
</div>

    
    
<script>
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();   
});
</script>
</body>
</html>