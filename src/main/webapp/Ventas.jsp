<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/estiloVentas.css">
<link>
</head>
<body>
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
	
	<%! String nombre ="" , cedula="", codigoUno="", productoUno="",precioUno="",productoDos="",precioDos="",codigoDos="",
	
	productoTres="", precioTres="", codigoTres="", cantidadUno="",cantidadDos="",cantidadTres="",totalVenta="",
	
	totalIva="", total="", consecutivo = "";
	
	
	
	%>
	
	<%
	if(request.getParameter("cedula")!= null){
		
		cedula = request.getParameter("cedula");
		nombre =request.getParameter("nombre");
	}
	if(request.getParameter("codigoUno")!= null) {
		codigoUno = request.getParameter("codigoUno");
		productoUno = request.getParameter("productoUno");
		 
				
	}
	
	if (request.getParameter("codigoUno") != null ){
		precioUno = request.getParameter("precioUno");
		cantidadUno = request.getParameter("cantidadUno");
	} 
	
	if(request.getParameter("codigoDos")!= null){
		
		codigoDos = request.getParameter("codigoDos");
		productoDos =request.getParameter("productoDos");
		precioDos= request.getParameter("precioDos");
		cantidadDos=request.getParameter("cantidadDos");
	
	}
	
	
	
if(request.getParameter("codigoTres")!= null){
		
		codigoTres = request.getParameter("codigoTres");
		productoTres =request.getParameter("productoTres");
		precioTres= request.getParameter("precioTres");
		cantidadTres = request.getParameter("cantidadTres");



	}


totalVenta = request.getParameter("totalVenta");
totalIva = request.getParameter("totalIva");
total = request.getParameter("total");
consecutivo = request.getParameter("consecutivo");


	

	%>

		<form action="Ventas"  method="post">
			<div class="contenedor">

				<label for="">cedula</label> <input type="text" name="cedula"
					placeholder="cedula del cliente" value="<%= cedula%>">

				<div>
					<input type="submit" name="consulta" value="consultar">
				</div>

				<label for="">cliente</label>
				
				 <input type="text" name="cliente"placeholder="nombre del cliente" value="<%=nombre%>"> 
					
				<label for="">consecutivo</label> <input type="text" name="consecutivo"
					value="<%=consecutivo %>">

			</div>
			<div class="contenedorProductos">
				<div>
					<label for="">cod. producto</label>
				</div>
				<div>
					<label for=""></label>
				</div>
				<div>
					<label for="">Nombre producto</label>
				</div>
				<div>
					<label for="">cantidad</label>
				</div>
				<div>
					<label for="">valor total</label>
				</div>
				<div>
					<input type="text" name="cod.producto" value="<%=codigoUno%>">
				</div>
				<div>
					<input type="submit" name="consultarProductoUno" value="consultar">
				</div>
				<div>
					<input type="text" name="productoUno" value="<%=productoUno%>">
				</div>
				<div>
					<input type="text" name="cantidadUno" value="<%=cantidadUno%>">
					<input type="submit" name="darCantidadUno" value="darPrecio">
				</div>
				<div>
					<input type="text" name="valorUno" value="<%=precioUno%>">
				</div>
				<div>
					<input type="text" name="codigoProductoDos" value="<%=codigoDos %>">
				</div>
				<div>
					<input type="submit" name="consultarProductoDos" value="consultar">
				</div>
				<div>
					<input type="text" name="productoDos" value="<%=productoDos %>">
				</div>
				<div>
					<input type="text" name="cantidadDos" value="<%=cantidadDos %>">
					<input type="submit" name="darCantidadDos" value="darPrecio">
				</div>
				<div>
					<input type="text" name="precioDos" value="<%=precioDos %>">
				</div>
				<div>
					<input type="text" name="codigoProductoTres" value="<%=codigoTres %>">
				</div>
				<div>
					<input type="submit" name="consultarProductoTres" value="consultar">
				</div>
				<div>
					<input type="text" name="productoTres" value="<%=productoTres%>">
				</div>
				<div>
					<input type="text" name="cantidadTres" value="<%=cantidadTres %>">
					<input type="submit" name="darCantidadTres" value="darPrecio">
				</div>
				<div>
					<input type="text" name="valorTres" value="<%=precioTres %>">
				</div>

				<div>
					<label></label>
				</div>
				<div>
					<label></label>
				</div>
				<div>
					<label></label>
				</div>

				<div>
					<label>Total de venta</label>
				</div>
				<div>
					<input type="text" name="totalVenta" value=<%=totalVenta%>>
				</div>
				<div>
					<label></label>
				</div>
				<div>
					<label></label>
				</div>
				<div>
					<label></label>
				</div>

				<div>
					<label>Total de iva</label>
				</div>
				<div>
					<input type="text" name="totalIva" value=<%=totalIva %>>
				</div>
				<div>
					<label></label>
				</div>
				<div>
					<label></label>
				</div>
				<div>
					<input type="submit" name="darTotal" value="Dar Total">
				</div>

				<div>
					<label>Total con iva</label>
				</div>
				<div>
					<input type="text" name="total" value=<%=total %>>
				</div>
			</div>

		</form>
	</main>




</body>
</html>