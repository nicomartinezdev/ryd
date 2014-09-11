package com.ryd.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.ryd.entidades.Cliente;
import com.ryd.model.ClienteFiltroForm;
import com.ryd.model.ClienteForm;
import com.ryd.service.ClienteService;

@Controller
public class ClienteEdicionController extends SimpleFormController {

	private ClienteService clienteService;

	public ClienteEdicionController() {
		setCommandClass(ClienteForm.class);
		setCommandName("command");
	}

	@Override
	protected ModelAndView showForm(HttpServletRequest request,
			HttpServletResponse response, BindException errors)
			throws Exception {
		Map<String, Object> dataModelMap = new HashMap<String, Object>();
		int clienteId = ServletRequestUtils.getIntParameter(request,
				"clienteId", 0);

		if (clienteId > 0) {
			request.setAttribute("method", "update");
			request.setAttribute("update", true);
		}

		ModelAndView mav = new ModelAndView("clienteEdicion");
		mav.addAllObjects(errors.getModel());
		mav.addObject("model", dataModelMap);
		return mav;
	}

	public ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		Map<String, Object> dataModelMap = new HashMap<String, Object>();
		ClienteForm form = (ClienteForm) command;
		Cliente cliente = clienteService.llenarCliente(form);

		if ("save".equals(request.getParameter("method"))) {
			clienteService.save(cliente);
		} else {
			clienteService.update(cliente);
		}

		dataModelMap.put("list", clienteService.list());
		request.setAttribute("command", new ClienteFiltroForm());
		return new ModelAndView("clienteListado", "model", dataModelMap);
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		int clienteId = ServletRequestUtils.getIntParameter(request,
				"clienteId", 0);
		ClienteForm form = new ClienteForm();
		request.setAttribute("method", "save");
		if (clienteId > 0) {
			form = clienteService.llenarForm(clienteId);
		}
		return form;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

}
