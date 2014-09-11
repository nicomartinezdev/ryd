package com.ryd.service.impl;

import java.util.List;

import com.ryd.database.dao.ProductoDao;
import com.ryd.entidades.Producto;
import com.ryd.service.ProductoService;

public class ProductoServiceImpl implements ProductoService {

	private ProductoDao productoDao;
	
	public Producto get(int productoId) {
		return productoDao.get(productoId);
	}

	public List<Producto> list() {
		return productoDao.list();
	}

	public ProductoDao getProductoDao() {
		return productoDao;
	}

	public void setProductoDao(ProductoDao productoDao) {
		this.productoDao = productoDao;
	}

}
