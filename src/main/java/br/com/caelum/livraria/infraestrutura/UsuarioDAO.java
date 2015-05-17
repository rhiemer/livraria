package br.com.caelum.livraria.infraestrutura;

import br.com.caelum.livraria.modelo.Usuario;

public interface UsuarioDAO extends Repositorio {

	void adiciona(Usuario usuario);

	public Usuario buscarUsuarioPeloLogin(String login);

}
