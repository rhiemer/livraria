package br.com.caelum.livraria.excecao;

public abstract class ExcecaoDaAplicacao extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8955006752047797531L;

	
	public ExcecaoDaAplicacao() {
		super();
	}

	public ExcecaoDaAplicacao(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ExcecaoDaAplicacao(String arg0) {
		super(arg0);
	}

	public ExcecaoDaAplicacao(Throwable arg0) {
		super(arg0);
	}

}
