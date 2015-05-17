package br.com.caelum.livraria.infraestrutura.beans;

import javax.ejb.Stateless;

import br.com.caelum.livraria.infraestrutura.AutorDAO;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorDAOImpl extends CrudComJPAImpl<Autor, Integer> implements AutorDAO {

}
