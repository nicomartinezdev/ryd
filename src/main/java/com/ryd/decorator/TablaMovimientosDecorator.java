package com.ryd.decorator;

import org.displaytag.decorator.TableDecorator;

import com.ryd.entidades.Movimiento;

public class TablaMovimientosDecorator extends TableDecorator {
    
    public String getMonto() {
        Movimiento movimiento = (Movimiento)getCurrentRowObject();
        String importe= "<span style=\"color:green;font-weight:bold;\">$ "+movimiento.getMonto()+"</span>";
        return importe;
    }
}
