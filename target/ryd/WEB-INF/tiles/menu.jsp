<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Menu</title>
        </head>
       
        <body leftmargin="0"
            topmargin="0" marginwidth="0" marginheight="0">
            
			<div class="urbangreymenu">
				<h3 class="headerbar"><spring:message code="menu.menu" text="default text" /></h3>
				<ul>
					<li><a href="clienteListado.htm">Clientes</a></li>
					<li><a href="clienteEdicion.htm"> >> Crear Cliente</a></li>
					<li><a href="movimientoListado.htm">Movimientos</a></li>
					<li><a href="movimientoEdicion.htm"> >> Crear Movimiento</a></li>
					<li><a href="remitoListado.htm">Remitos</a></li>
					<li><a href="remitoEdicion.htm"> >> Crear Remito</a></li>
					<li><a href="index.jsp"><spring:message code="menu.menu" text="default text" /></a></li>
					<li><a href="#">&nbsp;</a></li>
					<li><a href="#">&nbsp;</a></li>
					<li><a href="#">&nbsp;</a></li>
					<li><a href="#">&nbsp;</a></li>
					<li><a href="#">&nbsp;</a></li>
					<li><a href="#">&nbsp;</a></li>
				</ul>
			</div>
   
        </body>

    </html>