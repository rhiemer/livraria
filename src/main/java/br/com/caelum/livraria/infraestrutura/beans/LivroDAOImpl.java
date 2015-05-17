package br.com.caelum.livraria.infraestrutura.beans;

import javax.ejb.Stateless;

import br.com.caelum.livraria.infraestrutura.LivroDAO;
import br.com.caelum.livraria.modelo.Livro;

@Stateless
public class LivroDAOImpl extends CrudComJPAImpl<Livro, Integer> implements
		LivroDAO {

}
