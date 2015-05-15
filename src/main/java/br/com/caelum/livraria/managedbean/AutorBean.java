package br.com.caelum.livraria.managedbean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.negocio.AutorController;

@Named
@RequestScoped
public class AutorBean {

	private Autor autor = new Autor();

	@Inject
	private AutorController autorController;

	public Autor getAutor() {
		return autor;
	}

	public void gravar() {

		autorController.adiciona(this.autor);

		this.autor = new Autor();
	}
}
