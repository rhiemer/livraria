package br.com.caelum.livraria.infraestrutura;

import java.util.List;

public interface Crud<T, K> extends Repositorio {

	public void adiciona(T t);

	public void remove(T t);

	public void atualiza(T t);

	public List<T> listaTodos();

	public T buscaPorId(K id);

	public int contaTodos();

	public List<T> listaTodosPaginada(int firstResult, int maxResults);

}
