package com.ryd.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.ryd.entidades.Movimiento;
import com.ryd.model.MovimientoFiltroForm;
import com.ryd.model.MovimientoForm;
import com.ryd.service.MovimientoService;

public class MovimientoEdicionController extends SimpleFormController {
	private MovimientoService movimientoService;

	public MovimientoEdicionController() {
		setCommandClass(MovimientoForm.class);
		setCommandName("command");
	}

	@Override
	protected ModelAndView showForm(HttpServletRequest request,
			HttpServletResponse response, BindException errors)
			throws Exception {
		Map<String, Object> dataModelMap = new HashMap<String, Object>();
		int movimientoId = ServletRequestUtils.getIntParameter(request,
				"movimientoId", 0);

		if (movimientoId > 0) {
			request.setAttribute("method", "update");
		}

		ModelAndView mav = new ModelAndView("movimientoEdicion");
		mav.addAllObjects(errors.getModel());
		mav.addObject("model", dataModelMap);
		return mav;

	}

	public ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		Map<String, Object> dataModelMap = new HashMap<String, Object>();
		MovimientoForm form = (MovimientoForm) command;
		Movimiento movimiento = movimientoService.llenarMovimiento(form);
		if ("save".equals(request.getParameter("method"))) {
			movimientoService.save(movimiento);
		} else {
			movimientoService.update(movimiento);
		}
		dataModelMap.put("list", movimientoService.list());
		request.setAttribute("command", new MovimientoFiltroForm());
		return new ModelAndView("movimientoListado", "model", dataModelMap);
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		int movimientoId = ServletRequestUtils.getIntParameter(request,
				"movimientoId", 0);
		MovimientoForm form = new MovimientoForm();
		request.setAttribute("method", "save");
		if (movimientoId > 0) {
			form = movimientoService.llenarForm(movimientoId);
		}
		return form;
	}

	public void setMovimientoService(MovimientoService movimientoService) {
		this.movimientoService = movimientoService;
	}

}
