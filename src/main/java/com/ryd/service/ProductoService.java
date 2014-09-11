package com.ryd.service;

import java.util.List;

import com.ryd.entidades.Producto;

public interface ProductoService {
	public Producto get(int productoId);
	public List<Producto> list();
}
