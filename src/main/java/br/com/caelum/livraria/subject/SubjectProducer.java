package br.com.caelum.livraria.subject;

import javax.enterprise.inject.Produces;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class SubjectProducer {

	@Produces
	public Subject subjectProducer() {
		return SecurityUtils.getSubject();
	}

}
