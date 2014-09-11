package com.ryd.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ryd.model.MovimientoForm;

public class MovimientoFormValidator implements Validator{

	@Override
	public boolean supports(@SuppressWarnings("rawtypes") Class arg0) {
		return MovimientoForm.class.equals(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fecha", "error.vacio");
		
		MovimientoForm form = (MovimientoForm) object;
		
		if (form.getClienteId() <= 0) {
			errors.rejectValue("clienteId", "error.vacio");
		}
		
		if (form.getMonto() <= 0) {
			errors.rejectValue("monto", "error.valorMayorACero");
		}
	}

}
