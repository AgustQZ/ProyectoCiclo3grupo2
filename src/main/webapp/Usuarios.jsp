<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuarios</title>
<link rel="stylesheet" href="css/estilosUsuarios.css">
</head>
<body>
<%if(request.getParameter("mensaje")!=null){
	String mensaje = request.getParameter("mensaje");
	out.print("<script>alert('"+mensaje+"');</script>");}%>
	
<%!String cedula=""; String nombre="", correo="", pass="", user="";%>

<%if(request.getParameter("cedula")!=null){
	cedula = request.getParameter("cedula");
	nombre = request.getParameter("nombre");
	correo = request.getParameter("correo");
	pass = request.getParameter("pass");
	user = request.getParameter("user");}%>
	
<div class="titulo">
        <h1>Tienda Generica</h1>
    </div>
    <header>
        <nav>
            <ul>
                <li>
                    <a href="#">Usuarios</a>
                </li>
                <li>
                    <a href="#">Clientes</a>
                </li>
                <li>
                    <a href="# ">Proveedores</a>
                </li>
                <li>
                    <a href="# ">Productos</a>
                </li>
                <li>
                    <a href="# ">Ventas</a>
                </li>
                <li>
                    <a href="# ">Reportes</a>
                </li>
            </ul>
        </nav>
    </header>

    <div class="contendor-fluid">
        <form action="Usuarios" method="post">
            <div class="contenedorIN">
                <div>
                    <label for="">Cedula</label>
                    <label for="">Nombre Completo</label>
                    <label for="">Correo Electronico</label>
                </div>
                <div>
                    <input type="number" name="cedula" value="<%=cedula%>">
                    <input type="text" name="nombre" value="<%=nombre%>">
                    <input type="email" name="correo" value="<%=correo%>">
                </div>
                <div>
                    <label for="">Usuario</label>
                    <label for="">Contraseña</label>
                </div>
                <div>
                    <input type="text" name="user" value="<%=user%>">
                    <input type="password" name="pass" value="<%=pass%>">
                </div>
            </div>
            <div class="contenedorBotones">
                <input type="submit" name="crear" value="Crear">
                <input type="submit" name="consultar" value="Consultar">
                <input type="submit" name="actualizar" value="Actualizar">
                <input type="submit" name="eliminar" value="Eliminar">
            </div>
        </form>
    </div>
</body>
</html>