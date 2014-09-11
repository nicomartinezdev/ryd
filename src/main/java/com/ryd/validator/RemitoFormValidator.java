package com.ryd.validator;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ryd.entidades.ProductoRemito;
import com.ryd.model.RemitoForm;

public class RemitoFormValidator implements Validator{

	public boolean supports(@SuppressWarnings("rawtypes") Class arg0) {
		return RemitoForm.class.equals(arg0);
	}

	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "razonSocial", "error.vacio");
		
		RemitoForm form = (RemitoForm) object;
		
		if (StringUtils.isEmpty(form.getFecha())) {
			errors.rejectValue("fecha", "error.vacio");
		}
		/*int i = 0;
		for (ProductoRemito pr : form.getProductos()) {
			if (pr != null) {
				if (pr.getCantidad() < 0) {
					errors.rejectValue("productos["+i+"].cantidad", "error.valorMayorACero");
				}
				if (StringUtils.isEmpty(pr.getDetalle())) {
					errors.rejectValue("productos["+i+"].detalle", "error.vacio");
				}
				if (pr.getProducto().getProductoId() <= 0) {
					errors.rejectValue("productos["+i+"].producto.productoId", "error.vacio");
				}
			}
			i++;
		}*/
		
	}
}
