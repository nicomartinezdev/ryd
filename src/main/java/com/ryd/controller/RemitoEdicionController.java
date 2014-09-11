package com.ryd.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.ryd.entidades.Remito;
import com.ryd.model.RemitoFiltroForm;
import com.ryd.model.RemitoForm;
import com.ryd.service.ProductoService;
import com.ryd.service.RemitoService;


public class RemitoEdicionController extends SimpleFormController {

	private RemitoService remitoService;
	private ProductoService productoService;

	public RemitoEdicionController() {
		setCommandClass(RemitoForm.class);
		setCommandName("command");
	}

	@Override
	protected ModelAndView showForm(HttpServletRequest request,
			HttpServletResponse response, BindException errors)
			throws Exception {
		Map<String, Object> dataModelMap = new HashMap<String, Object>();
		int remitoId = ServletRequestUtils.getIntParameter(request,
				"remitoId", 0);

		if (remitoId > 0) {
			request.setAttribute("method", "update");
			request.setAttribute("update", true);
		}

		dataModelMap.put("productos", productoService.list());
		ModelAndView mav = new ModelAndView("remitoEdicion");
		mav.addAllObjects(errors.getModel());
		mav.addObject("model", dataModelMap);
		return mav;

	}

	public ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		Map<String, Object> dataModelMap = new HashMap<String, Object>();
		RemitoForm form = (RemitoForm) command;
		Remito remito = remitoService.llenarRemito(form);
		if ("save".equals(request.getParameter("method"))) {
			remitoService.save(remito);
		} else {
			remitoService.update(remito);
		}
		dataModelMap.put("list", remitoService.list());
		request.setAttribute("command", new RemitoFiltroForm());
		return new ModelAndView("remitoListado", "model", dataModelMap);
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		int remitoId = ServletRequestUtils.getIntParameter(request,
				"remitoId", 0);
		RemitoForm form = new RemitoForm();
		request.setAttribute("method", "save");
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
