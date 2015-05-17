package br.com.caelum.livraria.managedbean;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.shiro.subject.Subject;

@Named
@SessionScoped
public class SubjectBean {

	@Inject
	private Subject user;

	public String getLoginUsuario() {
		if (user == null || user.getPrincipal() == null)
			return null;
		else
			return user.getPrincipal().toString();
	}

}
