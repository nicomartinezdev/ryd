 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="clienteView.title" text="default text" /></title>
    </head>

    <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" class="bodystyle">

        <form:form action="clienteView.htm" method="post" commandName="command" cssClass="feedbackform">

          <table width="95%" border="0" cellspacing="0" cellpadding="5" >
       
            <tr>
              <td class="formstyled">Razon Social</td>
                <td width="40%">
                     <form:input path="razonSocial" maxlength="100" size="50" readonly="true" />
                </td>
            </tr>
            <tr>
             <td class="formstyled">CUIT/CUIL/DNI</td>
                <td width="40%">
                     <form:input path="cuit" maxlength="15" readonly="true" />
                </td>
            </tr>
             <tr>
             <td class="formstyled">Direccion</td>
                <td width="40%">
                     <form:input path="direccion" maxlength="100" size="50" readonly="true" />
                </td>
            </tr>
            <tr>
              <td class="formstyled">Tel. Laboral</td>
                <td width="40%">
                     <form:input path="telLaboral" maxlength="20" readonly="true" />
                </td>
            </tr>
             <tr>
              <td class="formstyled">Tel. Particular</td>
                <td width="40%">
                     <form:input path="telParticular" maxlength="20" readonly="true" />
                </td>
            </tr>
             <tr>
              <td class="formstyled">Celular</td>
                <td width="40%">
                     <form:input path="celular" maxlength="20" readonly="true" />
                </td>
            </tr>
             <tr>
             <td class="formstyled">Nextel</td>
                <td width="40%">
                     <form:input path="nextel" maxlength="10" readonly="true" />
                </td>
            </tr>
             <tr>
              <td class="formstyled">Mail</td>
                <td width="40%">
                     <form:input path="mail" maxlength="50" size="50" readonly="true" />
                </td>
            </tr>
             <tr>
              <td class="formstyled">Contacto</td>
                <td width="40%">
                     <form:input path="contacto" maxlength="50" size="50" readonly="true" />
                </td>
            </tr>
             <tr>
              <td class="formstyled">Observaciones</td>
                <td width="40%" align="left">
                     <form:textarea path="observaciones" cols="50" rows="5" id="observaciones" readonly="true" />
                </td>
            </tr>
            <tr>
             <td class="formstyled">Estado de Cuenta</td>
                <td width="40%">
                     <form:input path="montoSaldo" readonly="true" />
                     <form:hidden path="saldoId" />
                </td>
            </tr>
          </table>
         
            <form:hidden path="clienteId" id="clienteId"/>
        </form:form>
    </body>
</html>