<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
    <html>
       <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<link rel=stylesheet href="css/ryd.css" type="text/css">
            <title>R&D Grafica</title>
            <style type="text/css">
	           	.menu ul{
				list-style-type: none;
				margin: 0;
				padding: 0;
				margin-bottom: 0; /*bottom spacing between each UL and rest of content*/
				}
				
				.menu ul li{
				padding-bottom: 2px; /*bottom spacing between menu items*/
				}
				
				.menu ul li a{
				font: bold 12px Arial;
				color: green;
				background: #E9E9E9;
				display: block;
				padding: 5px 0;
				line-height: 17px;
				padding-left: 8px; /*link text is indented 8px*/
				text-decoration: none;
				}

				.menu ul li a:hover{ /*hover state CSS*/
				color: white;
				background: black;
				}

            </style>
        </head>
        <body leftmargin="0"
            topmargin="0" marginwidth="0" marginheight="0" class="bodystyle">
            <table border="0" cellpadding="2" cellspacing="2" align="center" width="100%" height="100%">
                <tr>
                    <td height="30">
                        <table cellspacing="0" cellpadding="0" width="100%" border="0" class="header">
			                <tr>
			                	<td>ADMINISTRADOR R&D GRAFICA</td>
			                	<td rowspan="3" align="right" style="padding-right:5px"><img src="imagenes/logo2_chico.jpg" /></td>
			                </tr>
			                <tr>
			  	    	    	<td class="headercell">R&D Grafica</td>
			                </tr>
			                <tr>
			    	            <td class="headercell">Administracion de Cuentas</td>
			                </tr>
			            </table>
                    </td>
                </tr>
                <tr>
                    <td>
                    	<table width="75%" border="0" cellspacing="0" cellpadding="5" class="menu">
   							<tr>
								<td class="formstyled">Clientes</td>
								<td width="40%">
								<ul>
									<li><a href="clienteListado.htm">Listado de Clientes</a></li>
									<li><a href="clienteEdicion.htm">Crear Cliente</a></li>
								</ul>
								</td>
							</tr>
							<tr>
								<td class="formstyled">Movimientos</td>
								<td width="40%">
								<ul>
									<li><a href="movimientoListado.htm">Listado de Movimientos</a></li>
									<li><a href="movimientoEdicion.htm">Crear Movimiento</a></li>
								</ul>
								</td>
							</tr>
							<tr>
								<td class="formstyled">Remitos</td>
								<td width="40%">
								<ul>
									<li><a href="remitoListado.htm">Listado de Remitos</a></li>
									<li><a href="remitoEdicion.htm">Crear Remito</a></li>
								</ul>
								</td>
							</tr>
                    	</table>
                     </td>
                </tr>
                <tr valign="bottom">
                    <td height="30">
                        <table cellspacing="0" cellpadding="0" width="100%" border="0" class="footer">
			                <tr>
			                	<td class="copyright">Copyright by Nicolas Martinez</td>
			                	<td align="right"><img src="imagenes/firma.jpg" /></td>
			                </tr>
			            </table>
                   </td>
                </tr>
            </table>
        </body>
    </html>