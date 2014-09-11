 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="display" uri="http://displaytag.sf.net/el"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="movimientoListado.title" text="default text" /></title>
    <script type="text/javascript">
	    
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
    <body leftmargin="0"
        topmargin="0" marginwidth="0" marginheight="0" class="bodystyle">
           <script type='text/JavaScript' src='calendario/scw.js'></script>
           <form:form action="movimientoListado.htm" method="post" commandName="command">

                <div id="filter" align="center">
                    <table align="center">
                        <tr>
                        	<td>Fecha</td>
                        	<td><form:input path="fecha" maxlength="0"/>
                        		<img src="imagenes/datepicker.jpg"
								onclick="scwShow (scwID('fecha'), event);" style="cursor:pointer;" /></td>
                            <td>Cliente</td>
                            <td><form:hidden path="clienteId"/>
                 				 <form:input path="razonSocial" maxlength="0"/>
               					 <img src="imagenes/select.jpg"
							onclick="javascript:popUpClientes();" style="cursor:pointer;" alt="Seleccionar Cliente" align="top"/> </td>
                            <td><input type="submit" value="Buscar"/></td>   
                        </tr>
                    </table>
                </div>

                <div id="table1" align="center">
                    <display:table id="item" pagesize="10" name="model.list" requestURI="movimientoListado.htm" sort="list" defaultsort="1" decorator="com.ryd.decorator.TablaMovimientosDecorator">
                        <display:column title="Fecha" property="fecha" sortable="true" format="{0,date,dd/MM/yyyy}"/>
                        <display:column title="Cliente" property="cliente.razonSocial" sortable="true"/>
                        <display:column title="Monto" property="monto" sortable="true"/>
                        <display:column paramProperty="movimientoId" paramId="movimientoId" href="./movimientoEdicion.htm">
                            <img src="imagenes/edit.jpg"
							 style="cursor:pointer;" alt="Editar Movimiento" align="top"/>
                        </display:column>
                        <display:column paramProperty="movimientoId" paramId="movimientoId" href="./movimientoDelete.htm">
                           <img src="imagenes/borrar.jpg"
							style="cursor:pointer;" alt="Eliminar Movimiento" align="top" />
                        </display:column>
                    </display:table>
                </div>
       
                <br/>
                <p align="center">
                    <a href="./movimientoEdicion.htm">Crear Nuevo Movimiento</a>
                </p>
               
            </form:form>
        </body>
    </html>