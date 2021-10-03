<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proveedores</title>
<link rel="stylesheet" href="css/estilosUsuarios.css">

</head>
<body>
<!-- creación de String globales -->
<%!int nit=0; String nombre="", ciudad="", direccion="", telefono="", estado="";%>

<%

if(request.getParameter("nit")!=null){
	nit = Integer.parseInt(request.getParameter("nit"));
	nombre = request.getParameter("nombre");
	direccion= request.getParameter("direccion");
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
                <li>
                    <a href="Usuarios.jsp">Usuarios</a>
                </li>
                <li>
                    <a href="Cliente.jsp">Clientes</a>
                </li>
                <li>
                    <a href="Proveedores.jsp">Proveedores</a>
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
        <form action="Proveedores" method="post">
            <div class="contenedorIN">
                <div>
                    <label for="">Nit</label>
                    <label for="">Nombre Completo</label>
                    <label for="">Direccion</label>
                </div>
                <div>
                    <input type="text" name="nit" value="<%=nit%>" <%=estado%>>
                    <input type="hidden" name="code" value="<%=nit%>">
                    <input type="text" name="nombre" value="<%=nombre%>">
                    <input type="text" name="direccion" value="<%=direccion%>">
                </div>
                <div>
                    <label for="">Telefono</label>
                    <label for="">Ciudad</label>
                </div>
                <div>
                    <input type="text" name="telefono" value="<%=telefono%>">
                    <input type="text" name="ciudad" value="<%=ciudad%>">
                </div>
            </div>
            <div class="contenedorBotones">
                <input type="submit" name="crear" value="Crear">
                <input type="submit" name="consultar" value="Consultar">
                <input type="submit" name="actualizar" value="Actualizar">
                <input type="submit" name="eliminar" value="Eliminar">
                <input type="submit" name="limpiar" value="Limpiar">
            </div>
        </form>
    </div>
    
    
   <!--muestra de mensaje  de error por script -->
<%
if(request.getParameter("mensaje")!=null){
	String mensaje = request.getParameter("mensaje");
	out.print("<script>alert('"+mensaje+"');</script>");	
}
%>
</body>
</html>