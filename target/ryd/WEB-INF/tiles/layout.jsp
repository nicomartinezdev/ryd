<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
    <html>
       <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>${title}</title>
        </head>
        <body leftmargin="0"
            topmargin="0" marginwidth="0" marginheight="0">
            <table border="0" cellpadding="2" cellspacing="2" align="center" width="100%" height="100%">
                <tr>
                    <td height="30" colspan="2">
                        <tiles:insertAttribute name="header" />
                    </td>
                </tr>
                <tr>
                    <td width="10%">
                        <tiles:insertAttribute name="menu" />
                    </td>
                    <td width="90%">
                        <tiles:insertAttribute  name="body" />
                    </td>
                </tr>
                <tr valign="bottom">
                    <td height="30" colspan="2">
                        <tiles:insertAttribute name="footer" />
                   </td>
                </tr>
            </table>
        </body>
    </html>