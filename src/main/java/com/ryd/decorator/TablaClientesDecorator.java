package com.ryd.decorator;

import org.displaytag.decorator.TableDecorator;

import com.ryd.entidades.Cliente;

public class TablaClientesDecorator extends TableDecorator {
    
    public String getSaldo() {
        Cliente cliente = (Cliente)getCurrentRowObject();
        String monto = "<span style=\"color:red;font-weight:bold;\">$ "+cliente.getSaldo().getMonto()+"</span>";
        if (cliente.getSaldo().esPositivo()) {
        	monto = "<span style=\"color:green;font-weight:bold;\">$ "+cliente.getSaldo().getMonto()+"</span>";
        }
        return monto;
    }
}
