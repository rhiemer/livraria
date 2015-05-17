package br.com.caelum.livraria.dominio.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.dominio.AutorService;
import br.com.caelum.livraria.excecao.AutorException;
import br.com.caelum.livraria.infraestrutura.AutorDAO;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorServiceImpl implements AutorService {

	@Inject
	private AutorDAO autorDAO;

	@Override
	public void adicionaAutor(Autor autor) {
		try {
			autorDAO.adiciona(autor);
		} catch (Exception e) {
			throw new AutorException(e);
		}

	}

	@Override
	public List<Autor> listaTodosAutores() {
		return autorDAO.listaTodos();
	}

	@Override
	public Autor buscaAutorPorCodigo(Integer autorId) {
		return autorDAO.buscaPorId(autorId);
	}

}
