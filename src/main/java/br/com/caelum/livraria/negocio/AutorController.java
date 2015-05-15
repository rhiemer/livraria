package br.com.caelum.livraria.negocio;

import java.util.List;

import br.com.caelum.livraria.modelo.Autor;

public interface AutorController extends Controller {
	
	public void adiciona(Autor autor);	

	public List<Autor> listaTodos();

	public Autor buscaPorId(Integer autorId);
	
	
	

}
