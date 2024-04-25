package com.cursojava;

public enum PeticionesBDEmpleado {

	SELECT_EMPLEADO_POR_NOMBRE ("SELECT * FROM empleados WHERE nombre = ?;"),
	SELECT_EMPLEADO_POR_APELLIDO ("SELECT * FROM empleados WHERE apellido LIKE ?;"),
	DELETE_EMPLEADO_POR_ID ("DELETE FROM empleados WHERE id_empleado = ?;"),
	INSERT_EMPLEADO ("INSERT INTO empleados (nombre, apellido, fecha_nacimiento, salario) VALUES (?,?,?,?);"),
	UPDATE_EMPLEADO ("UPDATE empleados SET nombre = ?, apellido = ?, fecha_nacimiento = ?, salario = ? WHERE id_empleado = ?;")
	
	;
	
	private String value;
	
	private PeticionesBDEmpleado(String s) {
		this.value = s;
	}
	
	public String getValue() {
		return value;
	}
}
