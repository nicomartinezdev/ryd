package com.ryd.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.ryd.model.ClienteFiltroForm;
import com.ryd.service.ClienteService;

@Controller
public class ClienteController extends SimpleFormController {
	
	private ClienteService clienteService;

	 public ClienteController(){
         setCommandClass(ClienteFiltroForm.class);
         setCommandName("command");       
     }
	 
	@Override
	protected ModelAndView showForm(HttpServletRequest request,
			HttpServletResponse response, BindException errors)
			throws Exception {
		 String view = "clienteListado";
		 Map<String, Object> dataModelMap = new HashMap<String, Object>();
         dataModelMap.put("list", clienteService.list());
         request.setAttribute("command", new ClienteFiltroForm());
         if ("true".equals(request.getParameter("popUp"))) {
        	 view = "clientePopUp";
        	 request.setAttribute("popUp", "true");
         }
         return new ModelAndView(view, "model", dataModelMap);
	}
	
	 public ModelAndView onSubmit (HttpServletRequest request, HttpServletResponse response,
             Object command, BindException errors) throws Exception {
		 String view = "clienteListado";
         Map<String, Object> dataModelMap = new HashMap<String, Object>();
         ClienteFiltroForm form = (ClienteFiltroForm)command;
         dataModelMap.put("list", clienteService.buscar(form.getRazonSocial()));
         request.setAttribute("command", form);
         if ("true".equals(request.getParameter("popUp"))) {
        	 view = "clientePopUp";
        	 request.setAttribute("popUp", "true");
         }
         return new ModelAndView(view, "model", dataModelMap);
     }

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
}
