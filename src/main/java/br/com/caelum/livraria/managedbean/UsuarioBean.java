package br.com.caelum.livraria.managedbean;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import br.com.caelum.livraria.dominio.UsuarioService;
import br.com.caelum.livraria.modelo.Usuario;

@Model
public class UsuarioBean {

	private Usuario usuario = new Usuario();

	@Inject
	private Subject user;

	@Inject
	private UsuarioService usuarioService;

	public String gravar() {

		usuarioService.adicionariUsuario(usuario);

		UsernamePasswordToken token = new UsernamePasswordToken(
				usuario.getLogin(), usuario.getSenha());
		user.login(token);

		this.usuario = new Usuario();

		return "/public/login?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
