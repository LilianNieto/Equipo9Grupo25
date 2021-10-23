<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>

  <title>Tienda Generica</title>
  <link rel="stylesheet" href="./estilo.css">
  <script src="./script.js" defer></script>
  
</head>

<body onload="menutienda()">

 <div class="menu">
 <%! String usuario="",nombre="",correo="",cedula="", contra="", estado=""; %>
 <%! String nombrecliente="", correocliente="",telefonocliente="",direccioncliente="",cedulacliente="", estadocliente=""; %>
 <%! String nit="", ciudadproveedor="", direccionproveedor="", nombreproveedor="", telefonoproveedor=""; %>
     
     <p data-target="#usuario">Usuario</p>
     <p data-target="#clientes">Clientes</p>
     <p data-target="#proveedores">Proveedores</p>
     <p data-target="#productos">Productos</p>
     <p data-target="#ventas">Ventas</p>
     <p data-target="#reportes">Reportes</p>
	 
  </div>

  <div class="content">
     
      <div data-content id="usuario">
      <form action="Usuarios" method="post">
       <% if(request.getParameter("ceduUsuario")!=null){
    	  
    	  cedula=request.getParameter("ceduUsuario");
    	  correo=request.getParameter("correoElectUsuario");
    	  nombre=request.getParameter("nombrecompletoUsuario");
    	  usuario=request.getParameter("usuar");
    	  contra=request.getParameter("contrasUsuario");
    	  estado="disabled";
    	  
      }
  %>
	      
    	<p>Cedula: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp
          <input type="text" name="ceduUsuario" value="<%=cedula%>" <%=estado%> required> 
          <input type="hidden" name="cod" value="<%=cedula%>" >
          
          &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp
          
          Usuario: &nbsp; &nbsp; &nbsp <input type="text" name="usuar" value="<%=usuario%>" required><br/>
          
          </p>
		
          <p>
          <br/>
          Nombre completo: &nbsp <input type="text" name="nombrecompletoUsuario" value="<%=nombre%>" required>
          
          &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp
          Contrase&ntilde;a: <input type="text" name="contrasUsuario" value="<%=contra%>" required>
          <br/>
          </p>

          <p>
          <br/>
          Correo Electronico: <input type="text" name="correoElectUsuario" value="<%=correo%>"required>
          <br/>
          <br/>
          </p>
          
         
          
          <input type="submit" name="botonCrear" value=" Crear ">
          &nbsp; &nbsp
          
          
          <input type="submit" name="botonActualizar" value=" Actualizar ">
          &nbsp; &nbsp
          
          <input type="submit" name="botonBorrar" value=" Borrar ">  
          <br/>
          <br/>
          <br/>
    
    
     </form>
     
     <hr>
       <form action="Usuarios" method="post">
       <fieldset>
       <br/>
       <legend> Consultar Usuario  </legend>
       <div>
       <label>Cedula: </label> <input type="text" name="codigo" required>
        <input type="submit" name="botonConsultar" value=" Consultar " >
          &nbsp; &nbsp
        <br/>
        </div>
        <br/>
        </fieldset>
        </form>
       
       
          
      </div>

      <div data-content id="clientes">
	      
       <form action="Clientes" method="post">
       <% if(request.getParameter("ceduCliente")!=null){
    	  
    	  cedulacliente=request.getParameter("ceduCliente");
    	  telefonocliente=request.getParameter("telefonCliente");
    	  nombrecliente=request.getParameter("nombrecompletoCliente");
    	  correocliente=request.getParameter("correoElectronCliente");
    	   direccioncliente=request.getParameter("direccionCliente");
    	  
    	  estadocliente="disabled";
    	  
      }
     %>
	       
          <p>Cedula: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp
          <input type="text" name="ceduCliente" value="<%=cedulacliente%>" <%=estadocliente%> required> 
          <input type="hidden" name="codcliente" value="<%=cedulacliente%>" >
          
          &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp
          Telefono: &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp
          <input type="text" name="telefonCliente" value="<%=telefonocliente%>" required></p>
			 <br/>
          <p>Nombre completo: &nbsp 
          <input type="text" name="nombrecompletoCliente" value="<%=nombrecliente%>" required>
          &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp
          Correo Electronico: <input type="text" name="correoElectronCliente" value="<%=correocliente%>" required></p>
			 <br/>
          <p>Direccion:&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp
          <input type="text" name="direccionCliente" value="<%=direccioncliente%>" required></p>

             <br/>
                <br/>
          <input type="submit" name="botonCrear" value=" Crear ">
          &nbsp; &nbsp
          <input type="submit" name="botonActualizar" value=" Actualizar ">
          &nbsp; &nbsp
          <input type="submit" name="botonBorrar" value=" Borrar ">
         <br/>
         <br/>
         </form>
     
     <hr>
       <form action="Clientes" method="post">
       <fieldset>
       <br/>
       <legend> Consultar Cliente  </legend>
       <div>
       <label>Cedula: </label> <input type="text" name="codigo2" required>
        <input type="submit" name="botonConsultar" value=" Consultar " >
          &nbsp; &nbsp
        <br/>
        </div>
        <br/>
        </fieldset>
        </form>
          
      </div>

      <div data-content id="proveedores">
       <form action="Proveedores" method="post">
       <% if(request.getParameter("nitProveedor")!=null){
    	  
    	    nit =request.getParameter("nitProveedor");
			ciudadproveedor=request.getParameter("ciudadProveedor");
			direccionproveedor =request.getParameter("direccionProvedor");
			nombreproveedor =request.getParameter("nombreProveedor");
			telefonoproveedor =request.getParameter("telefonProveedor");
    	  estado="disabled";
    	  
      }
  %>
	  
          <p>NIT: &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp
          <input type="text" name="nitProveedor" value="<%=nit%>"  required>
          &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp
          Telefono: &nbsp<input type="text" name="telefonProveedor" value="<%=telefonoproveedor%>"></p>
			<br/>
          <p>Nombre Proveedor: &nbsp <input type="text" name="nombreProveedor" value="<%=nombreproveedor%>"  required>
          &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp
          Ciudad: &nbsp; &nbsp <input type="text" name="ciudadProveedor" value="<%=ciudadproveedor%>"  required></p>
			<br/>
          <p>Direccion:&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp
          <input type="text" name="direccionProvedor" value="<%=direccionproveedor%>"  required></p>
         <br/>
          <br/>
          <input type="submit" name="botonConsultar" value=" Consultar ">
          &nbsp; &nbsp
          <br/>
           <br/>
          <input type="submit" name="botonCrear" value=" Crear ">
          &nbsp; &nbsp
          <br/>
           <br/>
          <input type="submit" name="botonActualizar" value=" Actualizar ">
          &nbsp; &nbsp
          <br/>
           <br/>
          <input type="submit" name="botonBorrar" value=" Borrar ">
          <br/>
      </div>

      <div data-content id="productos">
          <p>Nombre Proveedor: &nbsp <input type="text" size = "40" name="nombreProveedor">
          &nbsp; &nbsp; &nbsp; &nbsp; &nbsp

          <input type="submit" name="botonExaminar" value="Examinar">
          &nbsp; &nbsp
          <p>
             &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp
             <input type="submit" name="botonCargar" value="Cargar">
          </p>
      </div> 
	      
	      
       <div data-content id="ventas">
        
          <p>Cedula:&nbsp<input type="text" size = "10" name="ceduVenta">
          <input type="submit" name="botonConsultar1" value="Consultar">
          &nbsp; &nbsp
          Cliente: &nbsp <input type="text" name="clienteVenta">
          &nbsp; &nbsp
          Consec.: &nbsp <input type="text" size = "10" name="consecVenta"></p><br>

          <p>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp Cod.Product &nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp; 
             &nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp Nombre Producto &nbsp; &nbsp;&nbsp;&nbsp Cant. &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp Vir.Total

          <p>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp<input type="text" size = "10" name="codProduct1">&nbsp<input type="submit" name="botonConsultar2" value="Consultar">
             &nbsp; &nbsp<input type="text" name="nomProduct1">&nbsp<input type="text" size = "1" name="cant1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp<input type="text" size =                "10" name="virTot1">

          <p>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp<input type="text" size = "10" name="codProduct2">&nbsp<input type="submit" name="botonConsultar3" value="Consultar">
             &nbsp; &nbsp<input type="text" name="nomProduct2">&nbsp<input type="text" size = "1" name="cant2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp<input type="text" size =                "10" name="virTot1">

          <p>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp<input type="text" size = "10" name="codProduct3">&nbsp<input type="submit"name="botonConsultar3"                                  value="Consultar"> &nbsp; &nbsp<input type="text" name="nomProduct3">&nbsp<input type="text" size = "1" name="cant3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp<input                type="text" size = "10" name="virTot1"></p>

          <p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;                 &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;                  &nbsp; &nbsp; &nbsp Total venta: &nbsp<input type="text" size = "10" name="totVenta"></p>

          <p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;                 &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;                  &nbsp; &nbsp; &nbsp; &nbsp; &nbspTotal IVA: &nbsp<input type="text" size = "10" name="totVenta"></p>

          <p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;                 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp <input type="submit" name="botonConfirmar" value="Confirmar">&nbsp; &nbsp;                   &nbsp Total con IVA: &nbsp<input type="text" size = "10" name="totVentaIva"></p>
       
      </div>

       <div data-content id="reportes">
         <center>
             <p><input type="submit" size = "50" name="botonListUsuario" value="Listado de usuarios"></p>
             <p><input type="submit" size = "50" name="botonListClient" value="Listado de clientes"></p>
             <p><input type="submit"  name="botonVentaClient" value="Ventas por cliente"></p>
          </center>
      </div>   
     
  

	<div data-content id="Productos">

		<%!String codigo_producto = "", nitproveedor = "", nombre_producto = "";
	int Ivacompra = 1, precio_compra = 1, precio_venta = 1;%>
		<%
	if (request.getParameter("codigo_producto") != null) {
		nitproveedor = request.getParameter("nitproveedor");
		nombre_producto = request.getParameter("nombre_producto");
		codigo_producto = request.getParameter("codigo_producto");
		Ivacompra = Integer.parseInt(request.getParameter("Ivacompra"));
		precio_compra = Integer.parseInt(request.getParameter("precio_compra"));
		precio_venta = Integer.parseInt(request.getParameter("precio_venta"));
		estado = "disabled";
	}
	%>
		<h1>Modulo Productos</h1>
		<form action="productos" method="post">
			<div>
				<label>Codigo Producto: </label><input type="text"
					name="codigo_producto" value="<%=codigo_producto%>" <%=estado%>
					required="required">
			</div>
			<div>
				<input type="hidden" name="cod" value="<%=codigo_producto%>">
			</div>
			<div>
				<label>Nit Proveedor: </label><input type="text" name="Nit"
					value="<%=nitproveedor%>" required>
			</div>
			<div>
				<label>Nombre Producto: </label><input type="text"
					name="NomProducto" value="<%=nombre_producto%>" required>
			</div>
			<div>
				<label>Iva compra: </label><input type="number" name="IvaComp"
					value="<%=Ivacompra%>">
			</div>
			<div>
				<label>Precio Compra: </label><input type="number" name="PrecioCom"
					value="<%=precio_compra%>">
			</div>
			<div>
				<label>Precio Venta: </label><input type="number" name="PrecioVenta"
					value="<%=precio_venta%>">
			</div>
			<div>
				<input type="submit" name="Insertar" value="Registrar"> <input
					type="submit" name="Actualizar" value="Actualizar"> <input
					type="submit" name="Eliminar" value="Eliminar"> <input
					type="submit" name="Borrar" value="Borrar">
			</div>
		</form>
		<hr>
		<form action="producto" method="post">
			<fieldset>
				<legend>Consultar: </legend>
			</fieldset>
			<div>
				<label>Codigo_producto: </label><input type="text" name="Codigo">
				<input type="submit" name="consultar" value="Consultar">
			</div>
		</form>
		<%
	if (request.getParameter("men") != null) {
		String mensaje = request.getParameter("men");
		out.print("<script>alert('" + mensaje + "');</script>");
	}
	%>

		<hr>
		<form action="producto" method="post" enctype="multipart/form-data">
			<div>
				<label>Archivo: </label><input type="file" value="Examinar"
					name="archivo">
			</div>
			<input type="submit" value="Cargar Archivo" name="cargar">
		</form>
	</div>
 </div>
</body>
</html>
