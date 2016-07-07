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
    <title>Bootstrap 101 Template</title>

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
        <h1>Klanten</h1>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>User Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>tussenvoegsel</th>
                <th>Email</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${klanten}" var="klant">
                <tr>
                    <td><c:out value="${klant.klantId}" /></td>
                    <td><c:out value="${klant.voornaam}" /></td>
                    <td><c:out value="${klant.achternaam}" /></td>
                    <td><c:out value="${klant.tussenvoegsel}" /></td>
                    
                    <td><c:out value="${klant.email}" /></td>
                    <td><a href="KlantController?action=edit&klantId=<c:out value="${klant.klantId}"/>">Update</a></td>
                    <td><a href="KlantController?action=delete&klantId=<c:out value="${klant.klantId}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>    
        <a class="btn btn-default" href="KlantController?action=insert" role="button">Add User</a>
  </div>

</body>
</html>