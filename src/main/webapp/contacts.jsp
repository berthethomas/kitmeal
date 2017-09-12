<%-- 
    Document   : contacts
    Created on : 11 sept. 2017, 16:55:16
    Author     : Laura
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fr.imie.kitmeal.beans.UserBean"%>
<!DOCTYPE html>
<html>

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Kitmeal | Famille</title>


    </head>

    <body>

    <c:forEach items="${bean}" var="item">
        ${item.nom}<br>
    </c:forEach>






</body>

</html>

