package br.com.caelum.livraria.dominio.beans;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import br.com.caelum.livraria.dominio.UsuarioService;
import br.com.caelum.livraria.excecao.SenhaInvalidaException;
import br.com.caelum.livraria.excecao.UsuarioNaoCadastradoException;
import br.com.caelum.livraria.infraestrutura.UsuarioDAO;
import br.com.caelum.livraria.modelo.Usuario;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {

	@Inject
	private UsuarioDAO usuarioDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.caelum.livraria.dominio.beans.UsuarioService#adicionariUsuario
	 * (br.com.caelum.livraria.modelo.Usuario)
	 */
	@Override
	public void adicionariUsuario(Usuario usuario) {
		usuarioDao.adiciona(usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.caelum.livraria.dominio.beans.UsuarioService#login(java.lang.String
	 * , java.lang.String)
	 */

	@Override
	public Usuario buscarUsuarioPeloLogin(String login) {
		return usuarioDao.buscarUsuarioPeloLogin(login);
	}

	@Override
	public void logar(String login, String senha)
			throws UsuarioNaoCadastradoException, SenhaInvalidaException {
		Usuario usuario = null;
		try {
			usuario = buscarUsuarioPeloLogin(login);
		} catch (NoResultException e) {
			throw new UsuarioNaoCadastradoException();
		}

		if (!usuario.getSenha().equals(senha))
			throw new SenhaInvalidaException();
	}

}
