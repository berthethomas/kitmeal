<%-- 
    Document   : form
    Created on : 12 sept. 2017, 14:06:07
    Author     : thomasberthe
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fr.imie.kitmeal.beans.RecipeIngredientBean"%>
<!DOCTYPE html>
<html>

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Kitmeal | Recette</title>

        <link href="${pageContext.servletContext.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.servletContext.contextPath}/assets/font-awesome/css/font-awesome.css" rel="stylesheet">
        <link href="${pageContext.servletContext.contextPath}/assets/css/plugins/iCheck/custom.css" rel="stylesheet">
        <link href="${pageContext.servletContext.contextPath}/assets/css/plugins/steps/jquery.steps.css" rel="stylesheet">
        <link href="${pageContext.servletContext.contextPath}/assets/css/animate.css" rel="stylesheet">
        <link href="${pageContext.servletContext.contextPath}/assets/css/style.css" rel="stylesheet">


        <style>

            .wizard > .content > .body  {position: relative; }

        </style>
    </head>

    <body>
        <div id="wrapper">

            <nav class="navbar-default navbar-static-side" role="navigation">
                <div class="sidebar-collapse">
                    <ul class="nav metismenu" id="side-menu">
                        <li class="nav-header">
                            <div class="dropdown profile-element"> <span>
                                    <img alt="image" class="img-circle" src="${pageContext.servletContext.contextPath}/assets/img/profile_small.jpg" />
                                </span>
                                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                    <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">David Williams</strong>
                                        </span> <span class="text-muted text-xs block">Options <b class="caret"></b></span> </span> </a>
                                <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                    <li><a href="profile.html">Profil</a></li>
                                    <li><a href="contacts.html">Contacts</a></li>
                                    <li><a href="mailbox.html">Mailbox</a></li>
                                    <li class="divider"></li>
                                    <li><a href="login.html">Déconnexion</a></li>
                                </ul>
                            </div>
                            <div class="logo-element">
                                Logo Kitmeal
                            </div>
                        </li>
                        <li class="active">
                            <a href="index.html"><i class="fa fa-th-large"></i> <span class="nav-label">Evènements</span></a>
                        </li>
                        <li class="active">
                            <a href="index.html"><i class="fa fa-th-large"></i> <span class="nav-label">Frigo</span></a>
                        </li>
                        <li class="active">
                            <a href="index.html"><i class="fa fa-th-large"></i> <span class="nav-label">Recettes</span></a>
                        </li>
                        <li class="active">
                            <a href="${pageContext.servletContext.contextPath}/app/users"><i class="fa fa-th-large"></i> <span class="nav-label">Familles</span></a>
                        </li>
                        <li class="active">
                            <a href="index.html"><i class="fa fa-th-large"></i> <span class="nav-label">Infos personnels</span></a>
                        </li>
                        <li class="active">
                            <a href="index.html"><i class="fa fa-th-large"></i> <span class="nav-label">Gestion admin</span> <span class="fa arrow"></span></a>
                        </li>                
                    </ul>
                </div>
            </nav>

            <div id="page-wrapper" class="gray-bg">
                <div class="row border-bottom">
                    <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                        <div class="navbar-header">
                            <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                            <form role="search" class="navbar-form-custom" action="search_results.html">
                                <div class="form-group">
                                    <input type="text" placeholder="Rechercher..." class="form-control" name="top-search" id="top-search">
                                </div>
                            </form>
                        </div>
                        <ul class="nav navbar-top-links navbar-right">
                            <li>
                                <span class="m-r-sm text-muted welcome-message">KITmeal</span>
                            </li>
                            <li class="dropdown">
                                <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                                    <i class="fa fa-envelope"></i>  <span class="label label-warning">16</span>
                                </a>
                                <ul class="dropdown-menu dropdown-messages">
                                    <li>
                                        <div class="dropdown-messages-box">
                                            <a href="profile.html" class="pull-left">
                                                <img alt="image" class="img-circle" src="${pageContext.servletContext.contextPath}/assets/img/a7.jpg">
                                            </a>
                                            <div class="media-body">
                                                <small class="pull-right">Il y a 46h</small>
                                                <strong>Papy</strong> Vous à envoyé un message. <br>
                                                <small class="text-muted">Il y a 3 jours à 17:58 - 10.06.2014</small>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <div class="dropdown-messages-box">
                                            <a href="profile.html" class="pull-left">
                                                <img alt="image" class="img-circle" src="${pageContext.servletContext.contextPath}/assets/img/a4.jpg">
                                            </a>
                                            <div class="media-body ">
                                                <small class="pull-right text-navy">Il y a 5h</small>
                                                <strong>Chris Johnatan Overtunk</strong> Vous à envoyé un message. <br>
                                                <small class="text-muted">Hier à 1:21 - 11.06.2014</small>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <div class="dropdown-messages-box">
                                            <a href="profile.html" class="pull-left">
                                                <img alt="image" class="img-circle" src="${pageContext.servletContext.contextPath}/assets/img/profile.jpg">
                                            </a>
                                            <div class="media-body ">
                                                <small class="pull-right">Il y a 23h</small>
                                                <strong>Monica Smith</strong> Vous à envoyé un message. <br>
                                                <small class="text-muted">Il y a 2 ago à 14:30 - 11.06.2014</small>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <div class="text-center link-block">
                                            <a href="mailbox.html">
                                                <i class="fa fa-envelope"></i> <strong>Voir tous les messages</strong>
                                            </a>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                                    <i class="fa fa-bell"></i>  <span class="label label-primary">8</span>
                                </a>
                                <ul class="dropdown-menu dropdown-alerts">
                                    <li>
                                        <a href="mailbox.html">
                                            <div>
                                                <i class="fa fa-envelope fa-fw"></i> Vous avez 16 messages
                                                <span class="pull-right text-muted small">Il y a 4 minutes</span>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a href="profile.html">
                                            <div>
                                                <i class="fa fa-inbox fa-fw"></i> 3 Nouveaux évênements
                                                <span class="pull-right text-muted small">Il y a 12 minutes</span>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <div class="text-center link-block">
                                            <a href="notifications.html">
                                                <strong>Voir toutes les alertes</strong>
                                                <i class="fa fa-angle-right"></i>
                                            </a>
                                        </div>
                                    </li>
                                </ul>
                            </li>


                            <li>
                                <a href="login.html">
                                    <i class="fa fa-sign-out"></i> Déconnexion
                                </a>
                            </li>
                        </ul>

                    </nav>
                </div>
                <div class="row wrapper border-bottom white-bg page-heading">
                    <div class="col-lg-12">
                        <h2>Gestion des recettes</h2>
                        <ol class="breadcrumb">
                            <li>
                                <a href="${pageContext.servletContext.contextPath}/home">Home</a>
                            </li>
                            <li>
                                <a href="${pageContext.servletContext.contextPath}/app/recipes">Recettes</a>
                            </li>
                            <li class="active">
                                <strong>Gestions</strong>
                            </li>
                        </ol>
                    </div>
                </div>
                <div class="wrapper wrapper-content animated fadeInRight">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="ibox">
                                <div class="ibox-title">
                                    <h5>Ajouter une recette</h5>
                                    <div class="ibox-tools">
                                        <a class="collapse-link">
                                            <i class="fa fa-chevron-up"></i>
                                        </a>
                                        <a class="close-link">
                                            <i class="fa fa-times"></i>
                                        </a>
                                    </div>
                                </div>
                                <div class="ibox-content">

                                    <s:form modelAttribute="bean" id="form" action="${pageContext.servletContext.contextPath}/app/recipes/create/${bean}" method="POST" class="wizard-big">
                                        <h1>Recette</h1>
                                        <fieldset>
                                            <h2>Détails de la recette</h2>
                                            <div class="row">
                                                <div class="col-lg-8">
                                                    <div class="form-group">
                                                        <label>Nom *</label>
                                                        <s:input name="recipe.nom" id="recipe.nom" path="recipe.nom" type="text" value='${bean.recipe.nom}' class="form-control required" />
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Description *</label>
                                                        <s:textarea name="recipe.description" id="recipe.description" path="recipe.description" type="text" value='${bean.recipe.description}' class="form-control required" />
                                                    </div>
                                                </div>
                                            </div>

                                        </fieldset>
                                        <h1>Ingrédients</h1>
                                        <fieldset>
                                            <h2>Ingrédients de la recette</h2>
                                            <c:forEach items="${ingredients}" var="ingredient">
                                                <s:checkbox  name="ingredient.idIngredient" id="ingredient.idIngredient${ingredient.idIngredient}" path="ingredient.idIngredient" label="${ingredient.nom}" value='${ingredient.idIngredient}' class="form-control required" />
                                            </c:forEach>
                                        </fieldset>
                                    </s:form>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>

                <div class="footer">
                    <div class="pull-right">
                        Créé et développé par <strong>Laura Souchu</strong> & <strong>Thomas Berthé</strong>
                    </div>
                    <div>
                        <strong>Copyright</strong> KITmeal &copy; 2017
                    </div>
                </div>

            </div>
        </div>



        <!-- Mainly scripts -->
        <script src="${pageContext.servletContext.contextPath}/assets/js/jquery-2.1.1.js"></script>
        <script src="${pageContext.servletContext.contextPath}/assets/js/bootstrap.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/assets/js/plugins/metisMenu/jquery.metisMenu.js"></script>
        <script src="${pageContext.servletContext.contextPath}/assets/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

        <!-- Custom and plugin javascript -->
        <script src="${pageContext.servletContext.contextPath}/assets/js/inspinia.js"></script>
        <script src="${pageContext.servletContext.contextPath}/assets/js/plugins/pace/pace.min.js"></script>

        <!-- Steps -->
        <script src="${pageContext.servletContext.contextPath}/assets/js/plugins/staps/jquery.steps.min.js"></script>

        <!-- Jquery Validate -->
        <script src="${pageContext.servletContext.contextPath}/assets/js/plugins/validate/jquery.validate.min.js"></script>
    </body>

    <script>
        $(document).ready(function () {
            $("#wizard").steps();
            $("#form").steps({
                bodyTag: "fieldset",
                onStepChanging: function (event, currentIndex, newIndex)
                {
                    // Always allow going backward even if the current step contains invalid fields!
                    if (currentIndex > newIndex)
                    {
                        return true;
                    }

                    // Forbid suppressing "Warning" step if the user is to young
                    if (newIndex === 3 && Number($("#age").val()) < 18)
                    {
                        return false;
                    }

                    var form = $(this);

                    // Clean up if user went backward before
                    if (currentIndex < newIndex)
                    {
                        // To remove error styles
                        $(".body:eq(" + newIndex + ") label.error", form).remove();
                        $(".body:eq(" + newIndex + ") .error", form).removeClass("error");
                    }

                    // Disable validation on fields that are disabled or hidden.
                    form.validate().settings.ignore = ":disabled,:hidden";

                    // Start validation; Prevent going forward if false
                    return form.valid();
                },
                onStepChanged: function (event, currentIndex, priorIndex)
                {
                    // Suppress (skip) "Warning" step if the user is old enough.
                    if (currentIndex === 2 && Number($("#age").val()) >= 18)
                    {
                        $(this).steps("next");
                    }

                    // Suppress (skip) "Warning" step if the user is old enough and wants to the previous step.
                    if (currentIndex === 2 && priorIndex === 3)
                    {
                        $(this).steps("previous");
                    }
                },
                onFinishing: function (event, currentIndex)
                {
                    var form = $(this);

                    // Disable validation on fields that are disabled.
                    // At this point it's recommended to do an overall check (mean ignoring only disabled fields)
                    form.validate().settings.ignore = ":disabled";

                    // Start validation; Prevent form submission if false
                    return form.valid();
                },
                onFinished: function (event, currentIndex)
                {
                    var form = $(this);

                    // Submit form input
                    form.submit();
                }
            }).validate({
                errorPlacement: function (error, element)
                {
                    element.before(error);
                },
                rules: {
                    confirm: {
                        equalTo: "#password"
                    }
                }
            });
        });
    </script>
</html>

