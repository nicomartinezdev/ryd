package com.ryd.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.ryd.model.MovimientoFiltroForm;
import com.ryd.service.MovimientoService;

public class MovimientoController extends SimpleFormController {
	private MovimientoService movimientoService;

	 public MovimientoController(){
       setCommandClass(MovimientoFiltroForm.class);
       setCommandName("command");       
   }
	
	@Override
	protected ModelAndView showForm(HttpServletRequest request,
			HttpServletResponse response, BindException errors)
			throws Exception {
		 Map<String, Object> dataModelMap = new HashMap<String, Object>();
        dataModelMap.put("list", movimientoService.list());
        request.setAttribute("command", new MovimientoFiltroForm());
        return new ModelAndView("movimientoListado", "model", dataModelMap);
	}
	
	 public ModelAndView onSubmit (HttpServletRequest request, HttpServletResponse response,
            Object command, BindException errors) throws Exception {
        Map<String, Object> dataModelMap = new HashMap<String, Object>();
        MovimientoFiltroForm form = (MovimientoFiltroForm)command;
        dataModelMap.put("list", movimientoService.buscar(form.getClienteId(), form.getFecha()));
        request.setAttribute("command", form);
        return new ModelAndView("movimientoListado", "model", dataModelMap);
    }

	public void setMovimientoService(MovimientoService movimientoService) {
		this.movimientoService = movimientoService;
	}

}
