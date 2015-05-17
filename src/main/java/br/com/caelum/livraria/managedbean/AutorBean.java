package br.com.caelum.livraria.managedbean;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.livraria.dominio.AutorService;
import br.com.caelum.livraria.modelo.Autor;

@Model
public class AutorBean {

	private Autor autor = new Autor();

	@Inject
	private AutorService autorService;

	public Autor getAutor() {
		return autor;
	}

	public String gravar() {

		autorService.adicionaAutor(this.autor);

		this.autor = new Autor();

		return "/private/livro?faces-redirect=true";
	}
}
