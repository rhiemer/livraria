package br.com.caelum.livraria.autenticador;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

import br.com.caelum.livraria.dominio.UsuarioService;
import br.com.caelum.livraria.excecao.SenhaInvalidaException;
import br.com.caelum.livraria.excecao.UsuarioNaoCadastradoException;

public class Autenticador implements Realm {

	private UsuarioService getService() {
		Properties props = new Properties();
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		try {
			InitialContext ctx = new InitialContext(props);
			UsuarioService service = (UsuarioService) ctx
					.lookup("java:module/UsuarioServiceImpl");
			return service;
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public String getName() {
		return getClass().getName();
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		return true;
	}

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)
			throws AuthenticationException {
		UsernamePasswordToken usernameToken = (UsernamePasswordToken) token;
		String login = usernameToken.getUsername();
		String senha = new String(usernameToken.getPassword());
		UsuarioService service = getService();
		try {
			service.logar(login, senha);
		} catch (UsuarioNaoCadastradoException | SenhaInvalidaException e) {
			throw new AuthenticationException();
		}

		AuthenticationInfo info = new SimpleAuthenticationInfo(login, senha,
				getName());

		return info;
	}
}
