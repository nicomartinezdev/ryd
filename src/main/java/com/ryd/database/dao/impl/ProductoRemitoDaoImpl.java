package com.ryd.database.dao.impl;

import javax.sql.DataSource;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ryd.database.dao.ProductoRemitoDao;
import com.ryd.entidades.ProductoRemito;

@Repository("productoRemitoDao")
public class ProductoRemitoDaoImpl extends HibernateDaoSupport implements ProductoRemitoDao {

	private DataSource dataSource;
	
	public int save(ProductoRemito productoRemito) {
		Integer id = (Integer)getHibernateTemplate().save(productoRemito);
	    return id.intValue();
	}

	public void update(ProductoRemito productoRemito) {
		getHibernateTemplate().update(productoRemito);
	}
	
	public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
