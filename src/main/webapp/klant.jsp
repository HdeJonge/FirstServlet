<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Add new user</title>
</head>
<body>


    <div class="container">    
        <h1>Klant</h1>
    <form method="POST" action='KlantController' name="frmAddUser">
        <div class="form-group">
            <label>User ID :</label> 
            <input class="form-control"
                type="text" readonly="readonly" name="id"
                value="<c:out value="${klant.klantId}" />" /> 
        </div>
        <div class="form-group">
            <label>Voornaam :</label>
            <input class="form-control"
                type="text" name="vnaam"
                value="<c:out value="${klant.voornaam}" />" />
        </div>
        <div class="form-group">
            <label>Achternaam :</label>
            <input class="form-control"
                type="text" name="anaam"
                value="<c:out value="${klant.achternaam}" />" />
        </div>
        <div class="form-group">
            <label>Tussenvoegsel :</label>
            <input class="form-control"
                type="text" name="tv"
                value="<c:out value="${klant.tussenvoegsel}" />" />
        </div>
        <div class="form-group">
            <label> Email :</label>
            <input class="form-control"
                type="text" name="email"
                value="<c:out value="${klant.email}" />" />
        </div>
        <input type="submit" value="Submit" class="btn btn-default"/>
        
        <a class="btn btn-default" href="BestellingController?action=lijstBestellingen&klantId=<c:out value="${klant.klantId}"/>" role="button">Bestellingen</a>
        <a href="KlantController?action=delete&Id=<c:out value="${bestelling.bestellingID}"/>">Bestelling2</a>
               
    </div>

    </form>
    </div>
</body>
</html>