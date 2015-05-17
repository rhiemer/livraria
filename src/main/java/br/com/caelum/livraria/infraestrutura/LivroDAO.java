package br.com.caelum.livraria.infraestrutura;

import java.util.List;

import br.com.caelum.livraria.modelo.Livro;


public interface LivroDAO extends Repositorio {

	void adiciona(Livro livro);

	List<Livro> listaTodos();


}
