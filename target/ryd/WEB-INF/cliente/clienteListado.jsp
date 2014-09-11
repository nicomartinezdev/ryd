 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="display" uri="http://displaytag.sf.net/el"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="clienteListado.title" text="default text" /></title>
    <script type="text/javascript">
	    function returnPopUpValue(id, name) {
	        if (opener && !opener.closed && opener.setValues){
	            opener.setValues(id, name);
	        }
	        window.close();
	    }
	    
	    function verCliente(id){
	        window.open("./clienteView.htm?clienteId="+id,"Clientes","width=800,height=600,scrollbars=YES");
	    }
	    
	</script>
    </head>
    <body leftmargin="0"
        topmargin="0" marginwidth="0" marginheight="0" class="bodystyle">
           
           <form:form action="clienteListado.htm" method="post" commandName="command">

                <div id="filter" align="center">
                    <table align="center">
                        <tr>
                            <td>Razon Social</td>
                            <td><form:input path="razonSocial"/></td>
                            <td><input type="submit" value="Buscar"/></td>   
                        </tr>
                    </table>
                </div>
                
                <div id="table1" align="center">
			      	<display:table id="item" pagesize="10" name="model.list" requestURI="clienteListado.htm" sort="list" defaultsort="1" decorator="com.ryd.decorator.TablaClientesDecorator">
                        <display:column title="Razon Social" property="razonSocial" sortable="true"/>
                        <display:column title="Saldo" property="saldo" class="monto" sortable="true" format="$ {0,number,0.00}" />
                        <display:column paramProperty="clienteId" paramId="clienteId" href="./clienteEdicion.htm">
                           <img src="imagenes/edit.jpg"
							 style="cursor:pointer;" alt="Editar Cliente" align="top"/>
                        </display:column>
                        <display:column>
                           <img src="imagenes/eye.jpg"
							 style="cursor:pointer;" alt="Ver Cliente" align="top" onclick="javascript:verCliente(${item.clienteId})" />
                        </display:column>
                    </display:table>
                </div>
       
                <br/>
                <p align="center">
                    <a href="./clienteEdicion.htm">Crear Nuevo Cliente</a>
                </p>
            </form:form>
        
        </body>
    </html>