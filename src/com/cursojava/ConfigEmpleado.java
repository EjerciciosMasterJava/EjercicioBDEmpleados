package com.cursojava;

public enum ConfigEmpleado {

	CONEXION("jdbc:mysql://localhost:3306/bdempleados"),
	USER("root"),
	PASS("abc123.")
	
	;
	
	private String value;
	
	private ConfigEmpleado(String s) {
		this.value = s;
	}
	
	public String getValue() {
		return value;
	}
}
