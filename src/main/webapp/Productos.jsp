<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos</title>
<link rel="stylesheet" href="css/estiloProductos.css">
</head>
<body>
	<%!int nit = 0;
	String nombre = "", ciudad = "", direccion = "", telefono = "", estado = "";%>

	<%
	if (request.getParameter("nit") != null) {
		nit = Integer.parseInt(request.getParameter("nit"));
		nombre = request.getParameter("nombre");
		direccion = request.getParameter("direccion");
		telefono = request.getParameter("telefono");
		ciudad = request.getParameter("ciudad");
		/* estado= "disabled"; */
		estado = request.getParameter("estado");
	}
	%>

	<div class="titulo">
		<h1>Tienda Generica</h1>
	</div>
	<header>
		<nav>
			<ul>
				<li><a href="Usuarios.jsp">Usuarios</a></li>
				<li><a href="Cliente.jsp">Clientes</a></li>
				<li><a href="Proveedores.jsp">Proveedores</a></li>
				<li><a href="# ">Productos</a></li>
				<li><a href="# ">Ventas</a></li>
				<li><a href="# ">Reportes</a></li>
			</ul>
		</nav>
	</header>
	<main>
		<div class="contendor-fluid">
			<form action="Productos" method="post" enctype="multipart/form-data">

				<div class="contenedorIN">
					<div>
						<label for="">Nombre del archivo</label>
					</div>
					
					<div class="boton">
						<input type="file" name="archivo" value="Examinar">

					</div>

				</div>
				<div class="contenedorBotones">

					<input type="submit" name="cargar" value="Cargar">
				</div>
			</form>
		</div>
	</main>
	<%
if(request.getParameter("mensaje")!=null){
	String mensaje = request.getParameter("mensaje");
	out.print("<script>alert('"+mensaje+"');</script>");	
}
%>
</body>
</html>