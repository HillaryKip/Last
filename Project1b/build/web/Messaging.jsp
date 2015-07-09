<%-- 
    Document   : Messaging
    Created on : Jul 8, 2015, 11:07:27 AM
    Author     : Kipngetich
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultation</title>
        <link href="assets/plugins/bootstrap/bootstrap.css" rel="stylesheet" />
        <link href="mycss/chatbox/bootstrap.css" rel="stylesheet" style type="text/css">
        <link href="mycss/chatbox/chatbox.css" rel="stylesheet" style type="text/css">
    </head>
    <body style="overflow-x: hidden; background-color: #EFEEEE;">
        <jsp:include page="Header.jsp"></jsp:include>
        <div class="container" style="margin-top:180px;">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="portlet portlet-default">
                        <div class="portlet-heading">
                            <div class="portlet-title">
                                <h4> Kipngetich Hillary </h4>
                            </div>
                                                       <div class="clearfix"></div>
                        </div>
                        <div id="chat" class="panel-collapse collapse in">
                            <div>
                                <div class="portlet-body" style="overflow-y: auto; width: auto; height: 200px;">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <p class="text-center text-muted small">January 1, 2014 at 12:23 PM</p>
                                        </div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="media">
                                                <a class="pull-left" href="#">
                                                    <img class="media-object img-circle" src="image/username2.png" alt="" style="width: 20px; height: 20px;">
                                                </a>
                                                <div class="media-body">
                                                    <h4 class="media-heading">Kipngetich Hillary
                                                        <span class="small pull-right">12:23 PM</span>
                                                    </h4>
                                                    <p>Hi, I wanted to make sure you got the latest product report. Did Roddy get it to you?</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <hr>
                                    
                                </div>
                            </div>
                            <div class="portlet-footer">
                                <form role="form">
                                    <div class="form-group">
                                        <textarea class="form-control" placeholder="Enter message..."></textarea>
                                    </div>
                                    <div class="form-group">
                                        <input type="submit" class="btn btn-default pull-right" value="Send">
                                        <div class="clearfix"></div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.col-md-4 -->
            </div>
        </div> 
        <script type="text/javascript" src="mycss/chatbox/jquery-1.10.2.min.js"></script> 
        <script type="text/javascript" src="mycss/chatbox/bootstrap.min.js"></script> 
    </body>
</html>
