package br.com.caelum.livraria.dominio.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.dominio.LivroService;
import br.com.caelum.livraria.excecao.LivroException;
import br.com.caelum.livraria.infraestrutura.LivroDAO;
import br.com.caelum.livraria.modelo.Livro;

@Stateless
public class LivroServiceImpl implements LivroService {

	@Inject
	private LivroDAO dao;

	@Override
	public void adicionaLivro(Livro livro) throws LivroException {
		try {
			dao.adiciona(livro);
		} catch (Exception e) {
			throw new LivroException(e);
		}

	}

	@Override
	public List<Livro> listaTodosOsLivros() {
		return dao.listaTodos();
	}

}
