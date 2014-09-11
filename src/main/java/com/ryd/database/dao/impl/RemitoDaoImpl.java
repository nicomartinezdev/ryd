package com.ryd.database.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ryd.database.dao.RemitoDao;
import com.ryd.entidades.Cliente;
import com.ryd.entidades.Remito;

@Repository("remitoDao")
public class RemitoDaoImpl extends HibernateDaoSupport implements RemitoDao {

	private DataSource dataSource;
	
	public Remito get(int remitoId) {
		Session session = getSession();
        return (Remito)session.get(Remito.class, new Integer(remitoId));
	}

	@SuppressWarnings("unchecked")
	public List<Remito> list() {
		return getHibernateTemplate().find("from Remito");
	}

	@SuppressWarnings("unchecked")
	public List<Remito> listarPorCliente(int clienteId) {
		 Session session = getSession();
         Criteria crit = session.createCriteria(Remito.class)
             .add(Expression.eq("cliente", new Cliente(clienteId)));
         return crit.list();
	}

	public int save(Remito remito) {
		Integer id = (Integer)getHibernateTemplate().save(remito);
        return id.intValue();
	}

	public void update(Remito remito) {
		getHibernateTemplate().update(remito);
	}

	public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
