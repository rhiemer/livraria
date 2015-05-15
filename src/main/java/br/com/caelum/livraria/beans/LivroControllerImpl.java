package br.com.caelum.livraria.beans;

import javax.ejb.Stateless;

import br.com.caelum.livraria.crud.CrudComJPAImpl;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.negocio.LivroController;

@Stateless
public class LivroControllerImpl extends CrudComJPAImpl<Livro, Integer> implements LivroController {

}
