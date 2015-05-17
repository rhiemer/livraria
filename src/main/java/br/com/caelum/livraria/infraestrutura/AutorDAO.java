package br.com.caelum.livraria.infraestrutura;

import java.util.List;

import br.com.caelum.livraria.modelo.Autor;

public interface AutorDAO extends Repositorio {

	public void adiciona(Autor autor);

	public List<Autor> listaTodos();

	public Autor buscaPorId(Integer autorId);

}