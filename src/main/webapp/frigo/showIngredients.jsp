<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fr.imie.kitmeal.beans.IngredientBean"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>INSPINIA | Calendar</title>

    <link href="${pageContext.servletContext.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/assets/font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="${pageContext.servletContext.contextPath}/assets/css/plugins/iCheck/custom.css" rel="stylesheet">

    <link href="${pageContext.servletContext.contextPath}/assets/css/plugins/fullcalendar/fullcalendar.css" rel="stylesheet">
    <link href=".${pageContext.servletContext.contextPath}/assets/css/plugins/fullcalendar/fullcalendar.print.css" rel='stylesheet' media='print'>

    <link href="${pageContext.servletContext.contextPath}/assets/css/animate.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/assets/css/style.css" rel="stylesheet">

</head>

<body>

<div id="wrapper">

<nav class="navbar-default navbar-static-side" role="navigation">
                <div class="sidebar-collapse">
                    <ul class="nav metismenu" id="side-menu">
                        <li class="nav-header">
                            <div class="dropdown profile-element"> <span>
                                    <img alt="image" class="img-circle" src="../assets/img/profile_small.jpg" />
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
                            <a href="contacts.html"><i class="fa fa-th-large"></i> <span class="nav-label">Familles</span></a>
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
                                                <img alt="image" class="img-circle" src="../assets/img/a7.jpg">
                                            </a>
                                            <div class="media-body">
                                                <small class="pull-right">46h ago</small>
                                                <strong>Mike Loreipsum</strong> started following <strong>Monica Smith</strong>. <br>
                                                <small class="text-muted">3 days ago at 7:58 pm - 10.06.2014</small>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <div class="dropdown-messages-box">
                                            <a href="profile.html" class="pull-left">
                                                <img alt="image" class="img-circle" src="../assets/img/a4.jpg">
                                            </a>
                                            <div class="media-body ">
                                                <small class="pull-right text-navy">5h ago</small>
                                                <strong>Chris Johnatan Overtunk</strong> started following <strong>Monica Smith</strong>. <br>
                                                <small class="text-muted">Yesterday 1:21 pm - 11.06.2014</small>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <div class="dropdown-messages-box">
                                            <a href="profile.html" class="pull-left">
                                                <img alt="image" class="img-circle" src="../assets/img/profile.jpg">
                                            </a>
                                            <div class="media-body ">
                                                <small class="pull-right">23h ago</small>
                                                <strong>Monica Smith</strong> love <strong>Kim Smith</strong>. <br>
                                                <small class="text-muted">2 days ago at 2:30 am - 11.06.2014</small>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <div class="text-center link-block">
                                            <a href="mailbox.html">
                                                <i class="fa fa-envelope"></i> <strong>Read All Messages</strong>
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
                                                <i class="fa fa-envelope fa-fw"></i> You have 16 messages
                                                <span class="pull-right text-muted small">4 minutes ago</span>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a href="profile.html">
                                            <div>
                                                <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                                <span class="pull-right text-muted small">12 minutes ago</span>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a href="grid_options.html">
                                            <div>
                                                <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                                <span class="pull-right text-muted small">4 minutes ago</span>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <div class="text-center link-block">
                                            <a href="notifications.html">
                                                <strong>See All Alerts</strong>
                                                <i class="fa fa-angle-right"></i>
                                            </a>
                                        </div>
                                    </li>
                                </ul>
                            </li>


                            <li>
                                <a href="login.html">
                                    <i class="fa fa-sign-out"></i> Log out
                                </a>
                            </li>
                        </ul>

                    </nav>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-12">
        <h2>Evènements</h2>
        <ol class="breadcrumb">
            <li>
                <a href="#">Home</a>
            </li>
            <li>
                Evènements
            </li>
        </ol>
        <a href="${pageContext.servletContext.contextPath}/app/userIngredients/create" type="button" class="btn btn-w-m btn-primary pull-right"><i class="fa fa-plus-circle"></i> Créer un ingrédient</a>

    </div>
    
</div>

<div class="wrapper wrapper-content">
    <div class="row animated fadeInDown">
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
            <div class="ibox float-e-margins">
                <div class="ibox-content">

                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>Nom des ingrédients</th>
                            <th>Actions</th>
                            
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${bean}" var="item">
                        <tr>
                            <td>${item.nom}</td>
                            <td><a href="${pageContext.servletContext.contextPath}/app/userIngredients/update/${item.idIngredient}"><i class="fa fa-wrench"></i></a></td>
                            <td><a href="${pageContext.servletContext.contextPath}/app/userIngredients/removeIngredient/${item.idIngredient}"><i class="fa fa-trash"></i></a></td>

                        </tr>
                        </c:forEach> 
                        </tbody>
                    </table>

                        </div>

              
                
                <!--<div class="ibox-content">
                    <div id="calendar"></div>
                </div>-->
                
               
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <div class="pull-right">
        10GB of <strong>250GB</strong> Free.
    </div>
    <div>
        <strong>Copyright</strong> Example Company &copy; 2014-2017
    </div>
</div>

</div>
</div>

<!-- Mainly scripts -->
<script src="${pageContext.servletContext.contextPath}/assets/js/plugins/fullcalendar/moment.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/assets/js/jquery-2.1.1.js"></script>
<script src="${pageContext.servletContext.contextPath}/assets/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/assets/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${pageContext.servletContext.contextPath}/assets/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="${pageContext.servletContext.contextPath}/assets/js/inspinia.js"></script>
<script src="${pageContext.servletContext.contextPath}/assets/js/plugins/pace/pace.min.js"></script>

<!-- jQuery UI custom -->
<script src="${pageContext.servletContext.contextPath}/assets/js/jquery-ui.custom.min.js"></script>

<!-- iCheck -->
<script src="${pageContext.servletContext.contextPath}/assets/js/plugins/iCheck/icheck.min.js"></script>

<!-- Full Calendar -->
<script src="${pageContext.servletContext.contextPath}/assets/js/plugins/fullcalendar/fullcalendar.min.js"></script>

<script>

    $(document).ready(function() {

            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green'
            });

        /* initialize the external events
         -----------------------------------------------------------------*/


        $('#external-events div.external-event').each(function() {

            // store data so the calendar knows to render an event upon drop
            $(this).data('event', {
                title: $.trim($(this).text()), // use the element's text as the event title
                stick: true // maintain when user navigates (see docs on the renderEvent method)
            });

            // make the event draggable using jQuery UI
            $(this).draggable({
                zIndex: 1111999,
                revert: true,      // will cause the event to go back to its
                revertDuration: 0  //  original position after the drag
            });

        });


        /* initialize the calendar
         -----------------------------------------------------------------*/
        var date = new Date();
        var d = date.getDate();
        var m = date.getMonth();
        var y = date.getFullYear();

        $('#calendar').fullCalendar({
            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'month,agendaWeek,agendaDay'
            },
            editable: true,
            droppable: true, // this allows things to be dropped onto the calendar
            drop: function() {
                // is the "remove after drop" checkbox checked?
                if ($('#drop-remove').is(':checked')) {
                    // if so, remove the element from the "Draggable Events" list
                    $(this).remove();
                }
            },
            
        
         /* data = 
       
            {
                title: "${item.nom}",
                start: "${item.dateDebut}",
                end: "${item.dateFin}"
            },
    
            events.push(data); */
    
            
            
            
        });


    });

</script>
</body>

</html>

