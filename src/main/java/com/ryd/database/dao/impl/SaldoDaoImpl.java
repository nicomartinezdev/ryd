package com.ryd.database.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ryd.database.dao.SaldoDao;
import com.ryd.entidades.Saldo;

@Repository ("saldoDao")
public class SaldoDaoImpl extends HibernateDaoSupport implements SaldoDao {

	private DataSource dataSource;
	 
	public Saldo get(int saldoId) {
		 Session session = getSession();
         return (Saldo)session.get(Saldo.class, new Integer(saldoId));
	}

	@SuppressWarnings("unchecked")
	public List<Saldo> list() {
		return getHibernateTemplate().find("from Saldo");
	}

	public int save(Saldo saldo) {
		 Integer id = (Integer)getHibernateTemplate().save(saldo);
         return id.intValue();
	}

	public void update(Saldo saldo) {
		getHibernateTemplate().update(saldo);
	}
	
	public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
