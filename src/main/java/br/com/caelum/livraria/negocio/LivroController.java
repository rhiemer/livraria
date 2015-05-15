package br.com.caelum.livraria.negocio;

import java.util.List;

import br.com.caelum.livraria.modelo.Livro;


public interface LivroController extends Controller {

	void adiciona(Livro livro);

	List<Livro> listaTodos();


}
