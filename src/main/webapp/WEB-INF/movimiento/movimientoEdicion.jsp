<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="movimientoEdicion.title"
	text="default text" /></title>
<script language="javascript">
	
	function popUpClientes() {
		window.open("./clienteListado.htm?popUp=true", "Clientes",
				"width=800,height=600,scrollbars=YES");
	}

	function setValues(id, name) {
		document.forms[0].clienteId.value = id;
		document.forms[0].razonSocial.value = name;
		window.focus();
	}

</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"
	class="bodystyle">
<script type='text/JavaScript' src='calendario/scw.js'></script>
<form:form action="movimientoEdicion.htm" method="post"
	commandName="command" cssClass="feedbackform">

	<table width="95%" border="0" cellspacing="0" cellpadding="5">
		<tr>
			<td class="formstyled">Fecha</td>
			<td width="40%"><form:input path="fecha" maxlength="0" /> <img
				src="imagenes/datepicker.jpg"
				onclick="scwShow (scwID('fecha'), event);" /></td>
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
			<td class="formstyled">Monto</td>
			<td width="40%"><form:input path="monto" /></td>
		</tr>
		<tr>
			<td align="right" width="20%"></td>
			<td width="40%"><form:errors path="monto" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right" width="20%"></td>
			<td width="20%"><input type="submit" value="Guardar"
				class="formbutton" /></td>
		</tr>
	</table>

	<form:hidden path="movimientoId" id="movimientoId" />
	<input type="hidden" id="method" name="method" value="${method}" />
	<p align="center"><a href="./movimientoListado.htm">Regresar</a></p>
</form:form>
</body>
</html>