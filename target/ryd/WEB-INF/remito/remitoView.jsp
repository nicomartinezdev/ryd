<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="remitoView.title"
	text="default text" /></title>
<script language="javascript">
	
	function agregarProducto(divProducto) {
		var nombre = "producto" + divProducto;
		document.getElementById(nombre).style.display = 'block';
	}

	function mostrarProductos() {
		var cantProductos = <%=request.getAttribute("cantProductos")%>;
		for ( var i = 0; i < cantProductos; i++) {
			agregarProducto(i);
		}
	}
	
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"
	class="bodystyle">
<script type='text/JavaScript' src='calendario/scw.js'></script>
<form:form action="remitoView.htm" method="post"
	commandName="command" cssClass="feedbackform">

	<table width="95%" border="0" cellspacing="0" cellpadding="5">
		<tr>
			<td class="formstyled">Fecha</td>
			<td width="40%"><form:input path="fecha" maxlength="0" readonly="true" /></td>
		</tr>
		<tr>
			<td class="formstyled">Cliente</td>
			<td width="40%"><form:hidden path="clienteId" /> <form:input
				path="razonSocial" maxlength="0"  readonly="true" /></td>
		</tr>
		<tr>
			<td class="formstyled">Productos</td>
			<td width="40%">
			<div id="producto0">
			<table width="95%" border="0" cellspacing="0" cellpadding="5">
				<tr>
					<td class="tdProducto">Tipo</td>
					<td valign="top"><form:select
						path="productos[0].producto.productoId" id="productoId" disabled="true">
						<form:options items="${model.productos}" itemLabel="descripcion"
							itemValue="productoId" />
					</form:select></td>
					<td class="tdProducto">Cant.</td>
					<td valign="top"><form:input path="productos[0].cantidad"
						size="3" readonly="true" /></td>
					<td class="tdProducto">Detalle</td>
					<td valign="top"><form:textarea path="productos[0].detalle"
						cols="30" rows="2" id="detalle0"
						 readonly="true" /></td>
				</tr>
			</table>
			</div>
			<div id="producto1" style="display: none;">
			<table width="95%" border="0" cellspacing="0" cellpadding="5">
				<tr>
					<td class="tdProducto">Tipo</td>
					<td valign="top"><form:select
						path="productos[1].producto.productoId" id="productoId" disabled="true" >
						<form:options items="${model.productos}" itemLabel="descripcion"
							itemValue="productoId" />
					</form:select></td>
					<td class="tdProducto">Cant.</td>
					<td valign="top"><form:input path="productos[1].cantidad"
						size="3" readonly="true" /></td>
					<td class="tdProducto">Detalle</td>
					<td valign="top"><form:textarea path="productos[1].detalle"
						cols="30" rows="2" id="detalle1"
						 readonly="true" /></td>
				</tr>
			</table>
			</div>
			<div id="producto2" style="display: none;">
			<table width="95%" border="0" cellspacing="0" cellpadding="5">
				<tr>
					<td class="tdProducto">Tipo</td>
					<td valign="top"><form:select
						path="productos[2].producto.productoId" id="productoId" disabled="true">
						<form:options items="${model.productos}" itemLabel="descripcion"
							itemValue="productoId" />
					</form:select></td>
					<td class="tdProducto">Cant.</td>
					<td valign="top"><form:input path="productos[2].cantidad"
						size="3" readonly="true" /></td>
					<td class="tdProducto">Detalle</td>
					<td valign="top"><form:textarea path="productos[2].detalle"
						cols="30" rows="2" id="detalle2"
						 readonly="true" /></td>
				</tr>
			</table>
			</div>
			<div id="producto3" style="display: none;">
			<table width="95%" border="0" cellspacing="0" cellpadding="5">
				<tr>
					<td class="tdProducto">Tipo</td>
					<td valign="top"><form:select
						path="productos[3].producto.productoId" id="productoId" disabled="true">
						<form:options items="${model.productos}" itemLabel="descripcion"
							itemValue="productoId" />
					</form:select></td>
					<td class="tdProducto">Cant.</td>
					<td valign="top"><form:input path="productos[3].cantidad"
						size="3"  readonly="true" /></td>
					<td class="tdProducto">Detalle</td>
					<td valign="top"><form:textarea path="productos[3].detalle"
						cols="30" rows="2" id="detalle3"
						 readonly="true" /></td>
				</tr>
			</table>
			</div>
			<div id="producto4" style="display: none;">
			<table width="95%" border="0" cellspacing="0" cellpadding="5">
				<tr>
					<td class="tdProducto">Tipo</td>
					<td valign="top"><form:select
						path="productos[4].producto.productoId" id="productoId" disabled="true">
						<form:options items="${model.productos}" itemLabel="descripcion"
							itemValue="productoId" />
					</form:select></td>
					<td class="tdProducto">Cant.</td>
					<td valign="top"><form:input path="productos[4].cantidad"
						size="3" readonly="true" /></td>
					<td class="tdProducto">Detalle</td>
					<td valign="top"><form:textarea path="productos[4].detalle"
						cols="30" rows="2" id="detalle4"
						readonly="true"/></td>
				</tr>
			</table>
			</div>
			<div id="producto5" style="display: none;">
			<table width="95%" border="0" cellspacing="0" cellpadding="5">
				<tr>
					<td class="tdProducto">Tipo</td>
					<td valign="top"><form:select
						path="productos[5].producto.productoId" id="productoId" disabled="true">
						<form:options items="${model.productos}" itemLabel="descripcion"
							itemValue="productoId" />
					</form:select></td>
					<td class="tdProducto">Cant.</td>
					<td valign="top"><form:input path="productos[5].cantidad"
						size="3" readonly="true"/></td>
					<td class="tdProducto">Detalle</td>
					<td valign="top"><form:textarea path="productos[5].detalle"
						cols="30" rows="2" id="detalle5"
						readonly="true"/></td>
				</tr>
			</table>
			</div>
			<div id="producto6" style="display: none;">
			<table width="95%" border="0" cellspacing="0" cellpadding="5">
				<tr>
					<td class="tdProducto">Tipo</td>
					<td valign="top"><form:select
						path="productos[6].producto.productoId" id="productoId" disabled="true">
						<form:options items="${model.productos}" itemLabel="descripcion"
							itemValue="productoId" />
					</form:select></td>
					<td class="tdProducto">Cant.</td>
					<td valign="top"><form:input path="productos[6].cantidad"
						size="3" readonly="true"/></td>
					<td class="tdProducto">Detalle</td>
					<td valign="top"><form:textarea path="productos[6].detalle"
						cols="30" rows="2" id="detalle6"
						readonly="true"/></td>
				</tr>
			</table>
			</div>
			<div id="producto7" style="display: none;">
			<table width="95%" border="0" cellspacing="0" cellpadding="5">
				<tr>
					<td class="tdProducto">Tipo</td>
					<td valign="top"><form:select
						path="productos[7].producto.productoId" id="productoId" disabled="true">
						<form:options items="${model.productos}" itemLabel="descripcion"
							itemValue="productoId" />
					</form:select></td>
					<td class="tdProducto">Cant.</td>
					<td valign="top"><form:input path="productos[7].cantidad"
						size="3" readonly="true"/></td>
					<td class="tdProducto">Detalle</td>
					<td valign="top"><form:textarea path="productos[7].detalle"
						cols="30" rows="2" id="detalle7"
						readonly="true"/></td>
				</tr>
			</table>
			</div>
			<div id="producto8" style="display: none;">
			<table width="95%" border="0" cellspacing="0" cellpadding="5">
				<tr>
					<td class="tdProducto">Tipo</td>
					<td valign="top"><form:select
						path="productos[8].producto.productoId" id="productoId" disabled="true">
						<form:options items="${model.productos}" itemLabel="descripcion"
							itemValue="productoId" />
					</form:select></td>
					<td class="tdProducto">Cant.</td>
					<td valign="top"><form:input path="productos[8].cantidad"
						size="3" readonly="true"/></td>
					<td class="tdProducto">Detalle</td>
					<td valign="top"><form:textarea path="productos[8].detalle"
						cols="30" rows="2" id="detalle8"
						readonly="true"/></td>
				</tr>
			</table>
			</div>
			<div id="producto9" style="display: none;">
			<table width="95%" border="0" cellspacing="0" cellpadding="5">
				<tr>
					<td class="tdProducto">Tipo</td>
					<td valign="top"><form:select
						path="productos[9].producto.productoId" id="productoId" disabled="true">
						<form:options items="${model.productos}" itemLabel="descripcion"
							itemValue="productoId" />
					</form:select></td>
					<td class="tdProducto">Cant.</td>
					<td valign="top"><form:input path="productos[9].cantidad"
						size="3" readonly="true"/></td>
					<td class="tdProducto">Detalle</td>
					<td valign="top"><form:textarea path="productos[9].detalle"
						cols="30" rows="2" id="detalle9"
						readonly="true"/></td>
				</tr>
			</table>
			</div>
			</td>
		</tr>
		<tr>
			<td class="formstyled">Importe</td>
			<td width="40%"><form:input path="importe" readonly="true"/></td>
		</tr>
		<tr>
			<td class="formstyled">Observaciones</td>
			<td width="40%" align="left"><form:textarea path="observaciones"
				cols="50" rows="5" id="observaciones"
				readonly="true"/></td>
		</tr>
	</table>

	<form:hidden path="remitoId" id="remitoId" />
</form:form>
</body>
<script language="javascript">
	mostrarProductos();
</script>
</html>