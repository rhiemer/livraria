package br.com.caelum.livraria.excecao;


public abstract class ExcecaoNaoEsperada extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8955006752047797531L;

	public ExcecaoNaoEsperada(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ExcecaoNaoEsperada(String arg0) {
		super(arg0);
	}

	public ExcecaoNaoEsperada(Throwable arg0) {
		super(arg0);
	}

}
