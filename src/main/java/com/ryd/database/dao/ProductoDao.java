package com.ryd.database.dao;

import java.util.List;

import com.ryd.entidades.Producto;

public interface ProductoDao {
	public Producto get(int productoId);
	public List<Producto> list();
}
