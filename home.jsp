<%-- 
    Document   : home
    Created on : Sep 5, 2018, 8:43:24 AM
    Author     : Amritha Giri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="#" method="post" id="form">
            <img src="req.png" onclick="Request()"/>
            <img src="reg.png" onclick="Reg()"><br/>
        </form>
        <script>
            function Request() {
                document.getElementById("form").action="/labevalaws/index.html";
            document.getElementById("form").submit();
            }
            function Reg() {
                document.getElementById("form").action="/labevalaws/registered";
            document.getElementById("form").submit();
            }
            </script>
    </body>
</html>
