<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="remitoEdicion.title"
	text="default text" /></title>
<script language="javascript">
	
	function agregarProducto(divProducto) {
		if (divProducto == 10) {
			alert('Disculpe. No puede agregar mas de 10 productos por remito.');
			return;
		}
		var nombre = "producto" + divProducto;
		document.getElementById(nombre).style.display = 'block';
	}

	function mostrarProductos() {
		var cantProductos = <%=request.getAttribute("cantProductos")%>;
		for ( var i = 0; i < cantProductos; i++) {
			agregarProducto(i);
		}
	}
	
	function popUpClientes(){
	        window.open("./clienteListado.htm?popUp=true","Clientes","width=800,height=600,scrollbars=YES");
	    }
	   
	function setValues(id, name){
		document.forms[0].clienteId.value = id;
		document.forms[0].razonSocial.value = name;
		window.focus();
	}

</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"
	class="bodystyle">
<script type='text/JavaScript' src='calendario/scw.js'></script>
<form:form action="remitoEdicion.htm" method="post"
	commandName="command" cssClass="feedbackform">

	<table width="95%" border="0" cellspacing="0" cellpadding="5">
		<tr>
			<td class="formstyled">Fecha</td>
			<td width="40%"><form:input path="fecha" maxlength="0" /> <img
				src="imagenes/datepicker.jpg"
				onclick="scwShow (scwID('fecha'), event);" style="cursor: pointer;" /></td>
		</tr>
		<tr>
			<td align="right" width="20%"></td>
			<td width="40%"><form:errors path="fecha" cssClass="error" /></td>
		</tr>
		<tr>
			<td class="formstyled">Cliente</td>
			<td width="40%"><form:hidden path="clienteId" /> <form:input
				path="razonSocial" maxlength="0" /><img src="imagenes/select.jpg"
				onclick="javascript:popUpClientes();" style="cursor: pointer;"
				alt="Seleccionar Cliente" align="top" /></td>
		</tr>
		<tr>
			<td align="right" width="20%"></td>
			<td width="40%"><form:errors path="razonSocial" cssClass="error" />
			</td>
		</tr>
		<tr>
			<td class="formstyled">Productos</td>
			<td width="40%">
			<div id="producto0">
			<table width="95%" border="0" cellspacing="0" cellpadding="5">
				<tr>
					<td class="tdProducto">Tipo</td>
					<td valign="top"><form:select
						path="productos[0].producto.productoId" id="productoId">
						<form:option value="0">Elija...</form:option>
						<form:options items="${model.productos}" itemLabel="descripcion"
							itemValue="productoId" />
					</form:select></td>
					<td class="tdProducto">Cant.</td>
					<td valign="top"><form:input path="productos[0].cantidad"
						size="3" /></td>
					<td class="tdProducto">Detalle</td>
					<td valign="top"><form:textarea path="productos[0].detalle"
						cols="30" rows="2" id="detalle0"
						onkeydown="javascript:checklength(200, 'detalle0');" /> <img
						src="imagenes/mas.jpg" onclick="javascript:agregarProducto(1);"
						style="cursor: pointer;" alt="Agregar Producto" align="top" /></td>
				</tr>
				<tr>
					<td colspan="2"><form:errors
						path="productos[0].producto.productoId" cssClass="error" /></td>
					<td colspan="2"><form:errors path="productos[0].cantidad"
						cssClass="error" /></td>
					<td colspan="2"><form:errors path="productos[0].detalle"
						cssClass="error" /></td>
				</tr>
			</table>
			</div>
			<div id="producto1" style="display: none;">
			<table width="95%" border="0" cellspacing="0" cellpadding="5">
				<tr>
					<td class="tdProducto">Tipo</td>
					<td valign="top"><form:select
						path="productos[1].producto.productoId" id="productoId">
						<form:option value="0">Elija...</form:option>
						<form:options items="${model.productos}" itemLabel="descripcion"
							itemValue="productoId" />
					</form:select></td>
					<td class="tdProducto">Cant.</td>
					<td valign="top"><form:input path="productos[1].cantidad"
						size="3" /></td>
					<td class="tdProducto">Detalle</td>
					<td valign="top"><form:textarea path="productos[1].detalle"
						cols="30" rows="2" id="detalle1"
						onkeydown="javascript:checklength(200, 'detalle1');" /> <img
						src="imagenes/mas.jpg" onclick="javascript:agregarProducto(2);"
						style="cursor: pointer;" alt="Agregar Producto" align="top" /></td>
				</tr>
				<tr>
					<td colspan="2"><form:errors
						path="productos[1].producto.productoId" cssClass="error" /></td>
					<td colspan="2"><form:errors path="productos[1].cantidad"
						cssClass="error" /></td>
					<td colspan="2"><form:errors path="productos[1].detalle"
						cssClass="error" /></td>
				</tr>
			</table>
			</div>
			<div id="producto2" style="display: none;">
			<table width="95%" border="0" cellspacing="0" cellpadding="5">
				<tr>
					<td class="tdProducto">Tipo</td>
					<td valign="top"><form:select
						path="productos[2].producto.productoId" id="productoId">
						<form:option value="0">Elija...</form:option>
						<form:options items="${model.productos}" itemLabel="descripcion"
							itemValue="productoId" />
					</form:select></td>
					<td class="tdProducto">Cant.</td>
					<td valign="top"><form:input path="productos[2].cantidad"
						size="3" /></td>
					<td class="tdProducto">Detalle</td>
					<td valign="top"><form:textarea path="productos[2].detalle"
						cols="30" rows="2" id="detalle2"
						onkeydown="javascript:checklength(200, 'detalle2');" /> <img
						src="imagenes/mas.jpg" onclick="javascript:agregarProducto(3);"
						style="cursor: pointer;" alt="Agregar Producto" align="top" /></td>
				</tr>
				<tr>
					<td colspan="2"><form:errors
						path="productos[2].producto.productoId" cssClass="error" /></td>
					<td colspan="2"><form:errors path="productos[2].cantidad"
						cssClass="error" /></td>
					<td colspan="2"><form:errors path="productos[2].detalle"
						cssClass="error" /></td>
				</tr>
			</table>
			</div>
			<div id="producto3" style="display: none;">
			<table width="95%" border="0" cellspacing="0" cellpadding="5">
				<tr>
					<td class="tdProducto">Tipo</td>
					<td valign="top"><form:select
						path="productos[3].producto.productoId" id="productoId">
						<form:option value="0">Elija...</form:option>
						<form:options items="${model.productos}" itemLabel="descripcion"
							itemValue="productoId" />
					</form:select></td>
					<td class="tdProducto">Cant.</td>
					<td valign="top"><form:input path="productos[3].cantidad"
						size="3" /></td>
					<td class="tdProducto">Detalle</td>
					<td valign="top"><form:textarea path="productos[3].detalle"
						cols="30" rows="2" id="detalle3"
						onkeydown="javascript:checklength(200, 'detalle3');" /> <img
						src="imagenes/mas.jpg" onclick="javascript:agregarProducto(4);"
						style="cursor: pointer;" alt="Agregar Producto" align="top" /></td>
				</tr>
				<tr>
					<td colspan="2"><form:errors
						path="productos[3].producto.productoId" cssClass="error" /></td>
					<td colspan="2"><form:errors path="productos[3].cantidad"
						cssClass="error" /></td>
					<td colspan="2"><form:errors path="productos[3].detalle"
						cssClass="error" /></td>
				</tr>
			</table>
			</div>
			<div id="producto4" style="display: none;">
			<table width="95%" border="0" cellspacing="0" cellpadding="5">
				<tr>
					<td class="tdProducto">Tipo</td>
					<td valign="top"><form:select
						path="productos[4].producto.productoId" id="productoId">
						<form:option value="0">Elija...</form:option>
						<form:options items="${model.productos}" itemLabel="descripcion"
							itemValue="productoId" />
					</form:select></td>
					<td class="tdProducto">Cant.</td>
					<td valign="top"><form:input path="productos[4].cantidad"
						size="3" /></td>
					<td class="tdProducto">Detalle</td>
					<td valign="top"><form:textarea path="productos[4].detalle"
						cols="30" rows="2" id="detalle4"
						onkeydown="javascript:checklength(200, 'detalle4');" /> <img
						src="imagenes/mas.jpg" onclick="javascript:agregarProducto(5);"
						style="cursor: pointer;" alt="Agregar Producto" align="top" /></td>
				</tr>
				<tr>
					<td colspan="2"><form:errors
						path="productos[4].producto.productoId" cssClass="error" /></td>
					<td colspan="2"><form:errors path="productos[4].cantidad"
						cssClass="error" /></td>
					<td colspan="2"><form:errors path="productos[4].detalle"
						cssClass="error" /></td>
				</tr>
			</table>
			</div>
			<div id="producto5" style="display: none;">
			<table width="95%" border="0" cellspacing="0" cellpadding="5">
				<tr>
					<td class="tdProducto">Tipo</td>
					<td valign="top"><form:select
						path="productos[5].producto.productoId" id="productoId">
						<form:option value="0">Elija...</form:option>
						<form:options items="${model.productos}" itemLabel="descripcion"
							itemValue="productoId" />
					</form:select></td>
					<td class="tdProducto">Cant.</td>
					<td valign="top"><form:input path="productos[5].cantidad"
						size="3" /></td>
					<td class="tdProducto">Detalle</td>
					<td valign="top"><form:textarea path="productos[5].detalle"
						cols="30" rows="2" id="detalle5"
						onkeydown="javascript:checklength(200, 'detalle5');" /> <img
						src="imagenes/mas.jpg" onclick="javascript:agregarProducto(6);"
						style="cursor: pointer;" alt="Agregar Producto" align="top" /></td>
				</tr>
				<tr>
					<td colspan="2"><form:errors
						path="productos[5].producto.productoId" cssClass="error" /></td>
					<td colspan="2"><form:errors path="productos[5].cantidad"
						cssClass="error" /></td>
					<td colspan="2"><form:errors path="productos[5].detalle"
						cssClass="error" /></td>
				</tr>
			</table>
			</div>
			<div id="producto6" style="display: none;">
			<table width="95%" border="0" cellspacing="0" cellpadding="5">
				<tr>
					<td class="tdProducto">Tipo</td>
					<td valign="top"><form:select
						path="productos[6].producto.productoId" id="productoId">
						<form:option value="0">Elija...</form:option>
						<form:options items="${model.productos}" itemLabel="descripcion"
							itemValue="productoId" />
					</form:select></td>
					<td class="tdProducto">Cant.</td>
					<td valign="top"><form:input path="productos[6].cantidad"
						size="3" /></td>
					<td class="tdProducto">Detalle</td>
					<td valign="top"><form:textarea path="productos[6].detalle"
						cols="30" rows="2" id="detalle6"
						onkeydown="javascript:checklength(200, 'detalle6');" /> <img
						src="imagenes/mas.jpg" onclick="javascript:agregarProducto(7);"
						style="cursor: pointer;" alt="Agregar Producto" align="top" /></td>
				</tr>
				<tr>
					<td colspan="2"><form:errors
						path="productos[6].producto.productoId" cssClass="error" /></td>
					<td colspan="2"><form:errors path="productos[6].cantidad"
						cssClass="error" /></td>
					<td colspan="2"><form:errors path="productos[6].detalle"
						cssClass="error" /></td>
				</tr>
			</table>
			</div>
			<div id="producto7" style="display: none;">
			<table width="95%" border="0" cellspacing="0" cellpadding="5">
				<tr>
					<td class="tdProducto">Tipo</td>
					<td valign="top"><form:select
						path="productos[7].producto.productoId" id="productoId">
						<form:option value="0">Elija...</form:option>
						<form:options items="${model.productos}" itemLabel="descripcion"
							itemValue="productoId" />
					</form:select></td>
					<td class="tdProducto">Cant.</td>
					<td valign="top"><form:input path="productos[7].cantidad"
						size="3" /></td>
					<td class="tdProducto">Detalle</td>
					<td valign="top"><form:textarea path="productos[7].detalle"
						cols="30" rows="2" id="detalle7"
						onkeydown="javascript:checklength(200, 'detalle7');" /> <img
						src="imagenes/mas.jpg" onclick="javascript:agregarProducto(8);"
						style="cursor: pointer;" alt="Agregar Producto" align="top" /></td>
				</tr>
				<tr>
					<td colspan="2"><form:errors
						path="productos[7].producto.productoId" cssClass="error" /></td>
					<td colspan="2"><form:errors path="productos[7].cantidad"
						cssClass="error" /></td>
					<td colspan="2"><form:errors path="productos[7].detalle"
						cssClass="error" /></td>
				</tr>
			</table>
			</div>
			<div id="producto8" style="display: none;">
			<table width="95%" border="0" cellspacing="0" cellpadding="5">
				<tr>
					<td class="tdProducto">Tipo</td>
					<td valign="top"><form:select
						path="productos[8].producto.productoId" id="productoId">
						<form:option value="0">Elija...</form:option>
						<form:options items="${model.productos}" itemLabel="descripcion"
							itemValue="productoId" />
					</form:select></td>
					<td class="tdProducto">Cant.</td>
					<td valign="top"><form:input path="productos[8].cantidad"
						size="3" /></td>
					<td class="tdProducto">Detalle</td>
					<td valign="top"><form:textarea path="productos[8].detalle"
						cols="30" rows="2" id="detalle8"
						onkeydown="javascript:checklength(200, 'detalle8');" /> <img
						src="imagenes/mas.jpg" onclick="javascript:agregarProducto(9);"
						style="cursor: pointer;" alt="Agregar Producto" align="top" /></td>
				</tr>
				<tr>
					<td colspan="2"><form:errors
						path="productos[8].producto.productoId" cssClass="error" /></td>
					<td colspan="2"><form:errors path="productos[8].cantidad"
						cssClass="error" /></td>
					<td colspan="2"><form:errors path="productos[8].detalle"
						cssClass="error" /></td>
				</tr>
			</table>
			</div>
			<div id="producto9" style="display: none;">
			<table width="95%" border="0" cellspacing="0" cellpadding="5">
				<tr>
					<td class="tdProducto">Tipo</td>
					<td valign="top"><form:select
						path="productos[9].producto.productoId" id="productoId">
						<form:option value="0">Elija...</form:option>
						<form:options items="${model.productos}" itemLabel="descripcion"
							itemValue="productoId" />
					</form:select></td>
					<td class="tdProducto">Cant.</td>
					<td valign="top"><form:input path="productos[9].cantidad"
						size="3" /></td>
					<td class="tdProducto">Detalle</td>
					<td valign="top"><form:textarea path="productos[9].detalle"
						cols="30" rows="2" id="detalle9"
						onkeydown="javascript:checklength(200, 'detalle9');" /> <img
						src="imagenes/mas.jpg" onclick="javascript:agregarProducto(10);"
						style="cursor: pointer;" alt="Agregar Producto" align="top" /></td>
				</tr>
				<tr>
					<td colspan="2"><form:errors
						path="productos[9].producto.productoId" cssClass="error" /></td>
					<td colspan="2"><form:errors path="productos[9].cantidad"
						cssClass="error" /></td>
					<td colspan="2"><form:errors path="productos[9].detalle"
						cssClass="error" /></td>
				</tr>
			</table>
			</div>
			</td>
		</tr>
		<tr>
			<td class="formstyled">Importe</td>
			<td width="40%"><form:input path="importe" /></td>
		</tr>
		<tr>
			<td align="right" width="20%"></td>
			<td width="40%"><form:errors path="importe" cssClass="error" />
			</td>
		</tr>
		<tr>
			<td class="formstyled">Observaciones</td>
			<td width="40%" align="left"><form:textarea path="observaciones"
				cols="50" rows="5" id="observaciones"
				onkeydown="javascript:checklength(500, 'observaciones');"
				onkeyup="javascript:caracteresDisponibles();" /></td>
		</tr>
		<tr>
			<td></td>
			<td width="40%"><font size="1">Caracteres disponibles:</font><input
				type='text' align="left" size='3' id='disp' name='disp' readonly />
			</td>
		</tr>
		<tr>
			<td align="right" width="20%"></td>
			<td width="20%"><input type="submit" value="Guardar"
				class="formbutton" /></td>
		</tr>
	</table>

	<form:hidden path="remitoId" id="remitoId" />
	<input type="hidden" id="method" name="method" value="${method}" />
	<p align="center"><a href="./remitoListado.htm">Regresar</a></p>
</form:form>
</body>
<script language="javascript">
	document.getElementById('disp').value = 500;
	if (
<%=request.getAttribute("update")%>
	) {
		mostrarProductos();
	}
</script>
</html>