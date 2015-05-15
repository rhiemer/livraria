package br.com.caelum.livraria.beans;

import javax.ejb.Stateless;

import br.com.caelum.livraria.crud.CrudComJPAImpl;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.negocio.AutorController;

@Stateless
public class AutorControllerImpl extends CrudComJPAImpl<Autor, Integer> implements
		AutorController {

}
