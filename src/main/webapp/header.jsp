<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="./styles/app.css"/>
    </head>
    <body>
    <%@ page isELIgnored="false" %>
        <h1><%= application.getAttribute("applicationLabel") %></h1>
        <h2>${applicationScope.applicationLabel}</h2>