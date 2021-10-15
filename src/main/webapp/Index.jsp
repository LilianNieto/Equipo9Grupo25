<%@page import="Controlador.Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tienda Generica</title>
<link rel="stylesheet" href="estiloLogin.css">
</head>
<section class="form-login">
<h5>Bienvenidos a la Tienda Generia</h5>
<form action="Login" method="post">
<div>
<label>Usuario: </label><input class="controls" type="text" name="usuario">
</div>
<div>
<label>Contrase&ntilde;a: </label><input class="controls" type="password" name="clave">
</div>
<div>
<input class="buttons" type="submit" name="enviar" value="Aceptar">
<input class="buttons" type="button" name="enviar" value="Cancelar">
</div>
</section>
</form>

</body>
</html>
