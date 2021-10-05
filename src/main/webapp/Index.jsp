<%@page import="Controlador.Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Bienvenidos a la Tienda Generia</h1>
<form action="Login" method="post">
<div><label> Usuario: </label><input type="text" name="usuario"></div>
<div><label> Contraseña: </label><input type="password" name="clave"></div>
<div><input type="submit" name="enviar" value="Aceptar">

<input type="button" name="enviar" value="Cancelar">
 
</div>
</form>

</body>
</html>