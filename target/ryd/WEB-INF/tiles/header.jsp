 <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
    <html>
        <head>
            <title><tiles:getAsString name="title" ignore="true" /></title>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<link rel=stylesheet href="css/ryd.css" type="text/css">
			<link rel=stylesheet href="css/displaytag.css" type="text/css">
        </head>
        <body leftmargin="0"
            topmargin="0" marginwidth="0" marginheight="0">
            <table cellspacing="0" cellpadding="0" width="100%" border="0" class="header">
                <tr>
                	<td>ADMINISTRADOR R&D GRAFICA</td>
                	<td rowspan="3" align="right" style="padding-right:5px"><img src="imagenes/logo2_chico.jpg" /></td>
                </tr>
                <tr>
  	    	    	<td class="headercell">${pgTitle}</td>
                </tr>
                <tr>
    	            <td class="headercell">${pgSubTitle}</td>
                </tr>
            </table>
        </body>
    </html>