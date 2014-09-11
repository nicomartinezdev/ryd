package com.ryd.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.ryd.entidades.Movimiento;
import com.ryd.model.MovimientoFiltroForm;
import com.ryd.service.MovimientoService;

public class MovimientoDeleteController extends AbstractController {

	private MovimientoService movimientoService;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int movimientoId = ServletRequestUtils.getIntParameter(request,
				"movimientoId", 0);
		Map<String, Object> dataModelMap = new HashMap<String, Object>();
		Movimiento movimiento = movimientoService.get(movimientoId);
		movimientoService.delete(movimiento);
		dataModelMap.put("list", movimientoService.list());
		request.setAttribute("command", new MovimientoFiltroForm());
		return new ModelAndView("movimientoListado", "model", dataModelMap);
	}

	public void setMovimientoService(MovimientoService movimientoService) {
		this.movimientoService = movimientoService;
	}

}
