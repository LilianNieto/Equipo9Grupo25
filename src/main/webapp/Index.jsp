<%@page import="Controlador.Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tienda Generica</title>
</head>
<body background="tom-brunberg-D4ZtZX1UeAI-unsplash.jpg">
<center>
<h1 style="color:white">Bienvenidos a la Tienda Generia</h1>
<form action="Login" method="post">
<div style="color:white"><font size=5><label> Usuario: </label><input type="text" name="usuario"></font></div>
<div style="color:white"><font size=5><label> Contraseña: </label><input type="password" name="clave"></font></div>
<div><input type="submit" name="enviar" value="Aceptar">

<input type="button" name="enviar" value="Cancelar">
</center>
</div>
</form>

</body>
</html>
