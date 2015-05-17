package br.com.caelum.livraria.managedbean;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

@Model
public class LoginBean {

	private String login;
	private String senha;

	;

	@Inject
	private FacesContext facesContext;

	@Inject
	private Subject user;

	public String logar() {

		try {
			UsernamePasswordToken token = new UsernamePasswordToken(login,
					senha);
			user.login(token);

		} catch (AuthenticationException e) {
			facesContext.addMessage(null, new FacesMessage(
					"Login ou senha inválidos!"));
			return null;
		}

		return "/private/home?faces-redirect=true";
	}

	public String logout() {

		user.logout();

		return "/public/login?faces-redirect=true";
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
