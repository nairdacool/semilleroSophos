package com.telmex.tienda.exeptions;

public class ConexionNoDisponible extends AssertionError {
	
	private static String conexionNoDisponible = "la conexion no pudo ser establecida";
	
	public static String getconexionNoDisponible() {
		return conexionNoDisponible;
	}
	
	public ConexionNoDisponible(String menssage, Throwable cause) {
		super(menssage, cause);
	}
}
