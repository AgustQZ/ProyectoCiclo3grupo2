<%@page import="Controlador.ConexionSQL"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/estilosLogin.css">
</head>
<body>
<form action="Login" method="post" class="contenedor01">
        <h1>Bienvenido a la Tienda Gen�rica</h1>
        <div class="contenedorIN">
            <div>
                <label for="">Usuario</label>
                <label for="">Contrase�a</label>
            </div>
            <div>
                <input type="text" name="user">
                <input type="password" name="pass">
            </div>
        </div>
        <div class="contenedorBotones">
            <input type="submit" name="enviar" value="Ingresar">
            <input type="button" value="Cancelar">
        </div>
    </form>
</body>
</html>