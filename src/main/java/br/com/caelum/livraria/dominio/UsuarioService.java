package br.com.caelum.livraria.dominio;

import br.com.caelum.livraria.excecao.SenhaInvalidaException;
import br.com.caelum.livraria.excecao.UsuarioNaoCadastradoException;
import br.com.caelum.livraria.modelo.Usuario;


public interface UsuarioService {

	public abstract void adicionariUsuario(Usuario usuario);

	public abstract void logar(String login, String senha)
			throws UsuarioNaoCadastradoException, SenhaInvalidaException;

	public abstract Usuario buscarUsuarioPeloLogin(String login);

}