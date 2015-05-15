package br.com.caelum.livraria.managedbean;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.negocio.AutorController;
import br.com.caelum.livraria.negocio.LivroController;

@Named
@ViewScoped
public class LivroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Livro livro = new Livro();
	private Integer novoAutorId;

	@Inject
	private AutorController autorController;

	@Inject
	private LivroController livroController;

	@Inject
	private FacesContext facesContext;

	public Livro getLivro() {
		return livro;
	}

	public List<Livro> getLivros() {
		return livroController.listaTodos();
	}

	public List<Autor> getAutores() {
		return autorController.listaTodos();
	}

	public Set<Autor> getAutoresDoLivro() {
		return this.livro.getAutores();
	}

	public void gravarAutor() {
		Autor novoAutor = autorController.buscaPorId(novoAutorId);
		this.livro.adicionaAutor(novoAutor);
	}

	public void gravar() {

		if (livro.getAutores().isEmpty()) {
			facesContext.addMessage("autor", new FacesMessage(
					"Livro deve ter pelo menos um Autor"));
			return;
		}

		livroController.adiciona(this.livro);

		this.livro = new Livro();
	}

	public void comecaComDigitoUm(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException {
		String valor = value.toString();
		if (!valor.startsWith("1")) {
			throw new ValidatorException(new FacesMessage(
					"Deveria começar com 1"));
		}
	}

	public Integer getNovoAutorId() {
		return novoAutorId;
	}

	public void setNovoAutorId(Integer novoAutorId) {
		this.novoAutorId = novoAutorId;
	}

}
