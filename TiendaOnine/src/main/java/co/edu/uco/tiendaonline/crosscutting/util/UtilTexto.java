package co.edu.uco.tiendaonline.crosscutting.util;

public class UtilTexto {
	
	public static final String VACIO = "";
	
	private UtilTexto() {
		super();
	}
	
	public static final String obtenerValorDefecto(final String valor,final String valorDefecto) {
		return UtilObjeto.obtenerValorDefecto(valor, valorDefecto);
	}
	
	public static final String obtenerValorDefecto(final String valor) {
		return obtenerValorDefecto(valor,VACIO);
	}
	
	public static final String aplicarTrim(final String valor) {
		return obtenerValorDefecto(valor).trim();
	}
	
	public static final boolean igualSinTrim(final String valorUno, final String valorDos) {
		return obtenerValorDefecto(valorDos).equals(obtenerValorDefecto(valorDos));
	}
	
	public static final boolean igualConTrim(final String valorUno, final String valorDos) {
		return aplicarTrim(valorDos).equals(aplicarTrim(valorDos));
	}
	
	public static final boolean igualSinTrimIgnoreCase(final String valorUno, final String valorDos) {
		return obtenerValorDefecto(valorDos).equalsIgnoreCase(obtenerValorDefecto(valorDos));
	}
	
	public static final boolean igualConTrimIgnoreCase(final String valorUno, final String valorDos) {
		return aplicarTrim(valorDos).equalsIgnoreCase(aplicarTrim(valorDos));
	}
	
	public static final boolean estaNulo(final String valor) {
		return 	UtilObjeto.esNulo(valor);
	}
	
	public static final boolean estaVacio(final String valor) {
		return igualConTrim(valor, VACIO);
	}
	
}
