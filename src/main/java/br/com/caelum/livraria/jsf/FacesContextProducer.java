package br.com.caelum.livraria.jsf;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

public class FacesContextProducer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7943377870547538372L;

	@Produces
	@RequestScoped
	public FacesContext facesContextProducer() {
		return FacesContext.getCurrentInstance();
	}

}
