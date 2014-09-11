package com.ryd.database.dao.impl;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ryd.database.dao.MovimientoDao;
import com.ryd.entidades.Cliente;
import com.ryd.entidades.Movimiento;

@Repository ("movimientoDao")
public class MovimientoDaoImpl extends HibernateDaoSupport implements MovimientoDao {

	private DataSource dataSource;
	
	public Movimiento get(int movimientoId) {
		Session session = getSession();
        return (Movimiento)session.get(Movimiento.class, new Integer(movimientoId));
	}

	@SuppressWarnings("unchecked")
	public List<Movimiento> list() {
		return getHibernateTemplate().find("from Movimiento");
	}

	@SuppressWarnings("unchecked")
	public List<Movimiento> buscar(int clienteId, Date fecha) {
		Session session = getSession();
        Criteria crit = session.createCriteria(Movimiento.class)
            .add(Expression.eq("cliente", new Cliente(clienteId)));
        if (fecha != null) {
        	crit.add(Expression.eq("fecha", fecha));
        }
		return crit.list();
	}

	public int save(Movimiento movimiento) {
		Integer id = (Integer)getHibernateTemplate().save(movimiento);
        return id.intValue();
	}

	public void update(Movimiento movimiento) {
		getHibernateTemplate().update(movimiento);
	}

	public void delete(Movimiento movimiento) {
		getHibernateTemplate().delete(movimiento);
	}
	
	public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
