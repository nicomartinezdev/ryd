package com.ryd.database.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ryd.database.dao.ClienteDao;
import com.ryd.entidades.Cliente;
import com.ryd.entidades.Saldo;

@Repository ("clienteDao")
public class ClienteDaoImpl extends HibernateDaoSupport implements ClienteDao {

	private DataSource dataSource;
	
	public Cliente get(int clienteId) {
		Session session = getSession();
        return (Cliente)session.get(Cliente.class, new Integer(clienteId));
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> list() {
		return getHibernateTemplate().find("from Cliente");
	}

	public int save(Cliente cliente) {
		Integer id = (Integer)getHibernateTemplate().save(cliente);
        return id.intValue();
	}

	public void update(Cliente cliente) {
		getHibernateTemplate().update(cliente);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> buscar(String razonSocial) {
		 Session session = getSession();
         StringBuffer sb = new StringBuffer("from Cliente");
         if (StringUtils.isNotEmpty(razonSocial)) {
             sb.append(" where lower(razonSocial) like :razonSocial");
         }
         Query query = session.createQuery(sb.toString());
         if (StringUtils.isNotEmpty(razonSocial)) {
             query.setParameter("razonSocial", "%" + razonSocial.toLowerCase() + "%");
         }
         return query.list();
	}
	
	 @SuppressWarnings("unchecked")
     public boolean validarRazonSocial(int clienteId, String razonSocial) {
         boolean returnValue = false;
         Session session = getSession();
         Criteria crit = session.createCriteria(Cliente.class)
             .add(Expression.eq("razonSocial", razonSocial))
             .add(Expression.ne("clienteId", clienteId));

         List<Cliente> result = crit.list();
         if (result.size() > 0) {
             returnValue = true;
         }
         return returnValue;
     }
	

	public Cliente getBySaldo(int saldoId) {
		Session session = getSession();
        Cliente cliente = null;
		Criteria crit = session.createCriteria(Cliente.class)
            .add(Expression.eq("saldo", new Saldo(saldoId)));
        @SuppressWarnings("unchecked")
		List<Cliente> result = crit.list();
        if (result.size() > 0) {
        	cliente = result.get(0);
        }
		return cliente;
	}
	 
	public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
