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
        <title>Bestelling</title>

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
    </head>
    <body>
        <div class="container">    
            <h1>Bestelling</h1>            
            <form method="POST" action='BestellingController' name="frmAddUser">
                <input class="form-control"
                       type="text" readonly="readonly" name="klantId"
                       value="<c:out value="${klantId}" />" />

                <div class="form-group">
                    <label>Bestelling ID :</label> 
                    <input class="form-control"
                           type="text" readonly="readonly" name="bestellingId"
                           value="<c:out value="${bestelling.bestellingID}" />" /> 

                </div>
                <div class="form-group">
                    <label>TotaalPrijs :</label>
                    <input class="form-control"
                           type="text" name="totaalPrijs"
                           value="<c:out value="${bestelling.totaalPrijs}" />" />
                </div>

                <input type="submit" value="Submit" class="btn btn-default"/>
                <a class="btn btn-default" href="BestellingController?action=insert&klantId=<c:out value="${klantId}"/>" role="button">niet gebruiken</a>
            </form>
        </div>
    </body>
</html>