package com.ryd.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.ryd.model.RemitoForm;
import com.ryd.service.ProductoService;
import com.ryd.service.RemitoService;

public class RemitoViewController extends SimpleFormController {

	private RemitoService remitoService;
	private ProductoService productoService;
	
	public RemitoViewController() {
		setCommandClass(RemitoForm.class);
		setCommandName("command");
	}

	@Override
	protected ModelAndView showForm(HttpServletRequest request,
			HttpServletResponse response, BindException errors)
			throws Exception {
		Map<String, Object> dataModelMap = new HashMap<String, Object>();
		
		dataModelMap.put("productos", productoService.list());
		ModelAndView mav = new ModelAndView("remitoView");
		mav.addAllObjects(errors.getModel());
		mav.addObject("model", dataModelMap);
		return mav;
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		int remitoId = ServletRequestUtils.getIntParameter(request,
				"remitoId", 0);
		RemitoForm form = new RemitoForm();
		if (remitoId > 0) {
			form = remitoService.llenarForm(remitoId);
		}
		request.setAttribute("cantProductos", form.getProductos().size());
		return form;
	}

	public void setRemitoService(RemitoService remitoService) {
		this.remitoService = remitoService;
	}

	public void setProductoService(ProductoService productoService) {
		this.productoService = productoService;
	}
	
}
