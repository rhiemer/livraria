package br.com.caelum.livraria.dominio;

import java.util.List;

import br.com.caelum.livraria.modelo.Livro;

public interface LivroService extends Dominio {

	void adicionaLivro(Livro livro);

	List<Livro> listaTodosOsLivros();

}
