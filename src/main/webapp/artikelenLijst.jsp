<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Atikelen</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <div class="container">
        <h1>Artikelen</h1>
    <table class="table table-striped">
        <input class="form-control"
                type="text" readonly="readonly" name="klantId"
                value="<c:out value="${klantId}" />" />
        <input class="form-control"
                type="text" readonly="readonly" name="bestellingId"
                value="<c:out value="${bestellingId}" />" />
        <tbody>
            <c:forEach items="${artikelLijst}" var="artikel">
                <tr>
                    <td><c:out value="${artikel.artikelNaam}" /></td>
                    <td><c:out value="${artikel.artikelPrijs}" /></td>
                    <td><a href="BestellingController?action=add&klantId=<c:out value="${klantId}"/>&bestellingId=<c:out value="${bestellingId}"/>&artikelId=<c:out value="${artikel.artikelID}"/>">kies</a>
                    </td>
            </c:forEach>
        </tbody>
        
    </table>
</div>

</body>
</html>