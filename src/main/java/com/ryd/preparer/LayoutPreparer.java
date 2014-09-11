package com.ryd.preparer;

import javax.servlet.http.HttpServletRequest;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparer;
import org.springframework.web.servlet.support.RequestContext;

public class LayoutPreparer implements ViewPreparer {

    public void execute(TilesRequestContext context, AttributeContext attributeContext)
            throws PreparerException {
        String title = attributeContext.getAttribute("title").toString();
        String pgTitle = attributeContext.getAttribute("pgTitle").toString();
        String pgSubTitle = attributeContext.getAttribute("pgSubTitle").toString();
        String confirmValue = attributeContext.getAttribute("confirmValue").toString();
       
        RequestContext ctx = new RequestContext((HttpServletRequest)context.getRequest());
       
        context.getRequestScope().put("title", ctx.getMessage(title));
        context.getRequestScope().put("pgTitle", ctx.getMessage(pgTitle));
        context.getRequestScope().put("pgSubTitle", ctx.getMessage(pgSubTitle));
        context.getRequestScope().put("confirmValue", ctx.getMessage(confirmValue));
    }

}