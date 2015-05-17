package br.com.caelum.livraria.infraestrutura.beans;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import br.com.caelum.livraria.infraestrutura.Crud;

public abstract class CrudComJPAImpl<T, K> implements Crud<T, K> {

	private Class<T> classe;

	@PersistenceContext
	private EntityManager em;

	public CrudComJPAImpl() {
		super();
		classe = getClassCrud();

	}

	@SuppressWarnings("unchecked")
	private Class<T> getClassCrud() {
		Type sc = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) sc;
		Type[] ata = pt.getActualTypeArguments();
		return (Class<T>) ata[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.caelum.livraria.dao.DAO#adiciona(T)
	 */

	@Override
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void adiciona(T t)  {

		em.persist(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.caelum.livraria.dao.DAO#remove(T)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void remove(T t) {
		em.remove(em.merge(t));
		em.flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.caelum.livraria.dao.DAO#atualiza(T)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void atualiza(T t) {
		em.merge(t);
		em.flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.caelum.livraria.dao.DAO#listaTodos()
	 */
	@Override
	public List<T> listaTodos() {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).getResultList();

		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.caelum.livraria.dao.DAO#buscaPorId(K)
	 */
	@Override
	public T buscaPorId(K id) {
		T instancia = em.find(classe, id);
		return instancia;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.caelum.livraria.dao.DAO#contaTodos()
	 */
	@Override
	public int contaTodos() {
		long result = (Long) em.createQuery(
				"select count(n) from " + classe.getName() + " n")
				.getSingleResult();

		return (int) result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.caelum.livraria.dao.DAO#listaTodosPaginada(int, int)
	 */
	@Override
	public List<T> listaTodosPaginada(int firstResult, int maxResults) {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();

		return lista;
	}

}
