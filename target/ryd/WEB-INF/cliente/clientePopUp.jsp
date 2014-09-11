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
                	<display:table id="item" pagesize="10" name="model.list" requestURI="clienteListado.htm" sort="list" defaultsort="1">
                       	<display:column title="Razon Social" sortable="true">
                       		<a href="javascript:returnPopUpValue(${item.clienteId},'${item.razonSocial}');">${item.razonSocial}</a>
                       	</display:column>
                   	</display:table>
                </div>
        		<input type="hidden" id="popUp" name="popUp" value="${popUp}" />
            </form:form>
        </body>
    </html>