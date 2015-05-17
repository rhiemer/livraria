package br.com.caelum.livraria.infraestrutura.beans;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.infraestrutura.UsuarioDAO;
import br.com.caelum.livraria.modelo.Usuario;

public class UsuarioDAOImpl extends CrudComJPAImpl<Usuario, Integer> implements
		UsuarioDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Usuario buscarUsuarioPeloLogin(String login) {
		TypedQuery<Usuario> query = em.createNamedQuery(
				"Usuario.buscarUsuariPeloLogin", Usuario.class);
		query.setParameter("login", login);
		return query.getSingleResult();
	}
}
