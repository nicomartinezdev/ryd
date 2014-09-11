package com.ryd.decorator;

import org.displaytag.decorator.TableDecorator;

import com.ryd.entidades.Remito;

public class TablaRemitosDecorator extends TableDecorator {
    
    public String getImporte() {
        Remito remito = (Remito)getCurrentRowObject();
        String importe= "<span style=\"color:green;font-weight:bold;\">$ "+remito.getImporte()+"</span>";
        return importe;
    }
}
