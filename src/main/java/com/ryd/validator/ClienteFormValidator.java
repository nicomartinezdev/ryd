package com.ryd.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ryd.model.ClienteForm;
import com.ryd.service.ClienteService;

public class ClienteFormValidator implements Validator{

	private ClienteService clienteService;
	
	public boolean supports(@SuppressWarnings("rawtypes") Class arg0) {
		return ClienteForm.class.equals(arg0);
	}

	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "razonSocial", "error.vacio");
		
		ClienteForm form = (ClienteForm) object;
		if (clienteService.validarRazonSocial(form.getClienteId(), form.getRazonSocial())) {
			errors.rejectValue("razonSocial", "error.razonSocial.duplicado");
		}
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

}
