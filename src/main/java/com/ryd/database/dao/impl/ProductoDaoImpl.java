package com.ryd.database.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ryd.database.dao.ProductoDao;
import com.ryd.entidades.Producto;

@Repository ("productoDao")
public class ProductoDaoImpl extends HibernateDaoSupport implements ProductoDao {

	private DataSource dataSource;
	
	public Producto get(int productoId) {
		Session session = getSession();
        return (Producto)session.get(Producto.class, new Integer(productoId));
	}

	@SuppressWarnings("unchecked")
	public List<Producto> list() {
		return getHibernateTemplate().find("from Producto");
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
