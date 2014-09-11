package com.ryd.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.ryd.model.RemitoFiltroForm;
import com.ryd.service.RemitoService;

@Controller
public class RemitoController extends SimpleFormController {

	private RemitoService remitoService;

	 public RemitoController(){
        setCommandClass(RemitoFiltroForm.class);
        setCommandName("command");       
    }
	
	@Override
	protected ModelAndView showForm(HttpServletRequest request,
			HttpServletResponse response, BindException errors)
			throws Exception {
		 Map<String, Object> dataModelMap = new HashMap<String, Object>();
         dataModelMap.put("list", remitoService.list());
         request.setAttribute("command", new RemitoFiltroForm());
         return new ModelAndView("remitoListado", "model", dataModelMap);
	}
	
	 public ModelAndView onSubmit (HttpServletRequest request, HttpServletResponse response,
             Object command, BindException errors) throws Exception {
         Map<String, Object> dataModelMap = new HashMap<String, Object>();
         RemitoFiltroForm form = (RemitoFiltroForm)command;
         dataModelMap.put("list", remitoService.listarPorCliente(form.getClienteId()));
         request.setAttribute("command", form);
         return new ModelAndView("remitoListado", "model", dataModelMap);
     }
	
	 public void setRemitoService(RemitoService remitoService) {
		this.remitoService = remitoService;
	}

}
