package com.ryd.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.ryd.model.ClienteForm;
import com.ryd.service.ClienteService;

public class ClienteViewController extends SimpleFormController {

	private ClienteService clienteService;
	
	public ClienteViewController() {
		setCommandClass(ClienteForm.class);
		setCommandName("command");
	}
	
	@Override
	protected ModelAndView showForm(HttpServletRequest request,
			HttpServletResponse response, BindException errors)
			throws Exception {
		Map<String, Object> dataModelMap = new HashMap<String, Object>();
		ModelAndView mav = new ModelAndView("clienteView");
		mav.addAllObjects(errors.getModel());
		mav.addObject("model", dataModelMap);
		return mav;
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		int clienteId = ServletRequestUtils.getIntParameter(request,
				"clienteId", 0);
		ClienteForm form = new ClienteForm();
		if (clienteId > 0) {
			form = clienteService.llenarForm(clienteId);
		}
		return form;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

}
