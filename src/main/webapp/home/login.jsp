<%-- 
    Document   : login
    Created on : 13 sept. 2017, 10:04:56
    Author     : Laura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>INSPINIA | Login</title>

    <link href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="${pageContext.servletContext.contextPath}/css/animate.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet">

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">KITmeal</h1>

            </div>
            
            <p>Connexion</p>
            <form class="m-t" role="form" action="index.html">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Identifiant" required="">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Mot de passe" required="">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">Connexion</button>

            </form>
            
        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="${pageContext.servletContext.contextPath}/js/jquery-2.1.1.js"></script>
    <script src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>

</body>

</html>