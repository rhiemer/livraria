package br.com.caelum.livraria.crud;

import java.util.List;

public interface Crud<T, K> {

	public void adiciona(T t);

	public void remove(T t);

	public void atualiza(T t);

	public List<T> listaTodos();

	public T buscaPorId(K id);

	public int contaTodos();

	public List<T> listaTodosPaginada(int firstResult, int maxResults);

}
