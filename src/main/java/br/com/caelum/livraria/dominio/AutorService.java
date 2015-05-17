package br.com.caelum.livraria.dominio;

import java.util.List;

import br.com.caelum.livraria.modelo.Autor;

public interface AutorService extends Dominio {

	public void adicionaAutor(Autor autor);

	public List<Autor> listaTodosAutores();

	public Autor buscaAutorPorCodigo(Integer autorId);

}
