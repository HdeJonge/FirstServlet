<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Artikelen</title>

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
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
        <div class="container">
            <h1>Bestellingen</h1>
            <table class="table table-striped">
                <input class="form-control" type="text" readonly="readonly" name="klantId" value="<c:out value="${klantId}" />" />
                        <input class="form-control" type="text" readonly="readonly" name="bestellingId"
                value="<c:out value="${bestellingId}" />" />
                <tbody>
                    <c:forEach items="${bestellingArtikelLijst}" var="bestellingArtikel">
                        <tr>
                            <td><c:out value="${bestellingArtikel.ID}" /></td>
                            <td><c:out value="${bestellingArtikel.artikel.artikelNaam}" /></td>
                            <td><c:out value="${bestellingArtikel.artikel.artikelPrijs}" /></td>
                            <td><c:out value="${bestellingArtikel.aantal}" /></td>
                            <td><a href="BestellingController?action=open&klantId=<c:out value="${klantId}"/>&bestellingId=<c:out value="${bestelling.bestellingID}"/>">Open</a></td>
                            <td><a href="BestellingController?action=edit&klantId=<c:out value="${klantId}"/>&bestellingId=<c:out value="${bestelling.bestellingID}"/>">Update</a></td>
                            <td><a href="BestellingController?action=delete&klantId=<c:out value="${klantId}"/>&bestellingId=<c:out value="${bestelling.bestellingID}"/>">Delete</a></td></tr>
                        </c:forEach>
                </tbody>
            </table>
            <a class="btn btn-default" role="button" href="BestellingController?action=choose&bestellingId=<c:out value="${bestellingId}"/>&klantId=<c:out value="${klantId}"/>">artikel toevoegen</a>
        </div>
    </body>
</html>
