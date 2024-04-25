package com.cursojava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class Ejercicio1 {

	public static final String SELECT_EMPLEADO_POR_NOMBRE = PeticionesBDEmpleado.SELECT_EMPLEADO_POR_NOMBRE.getValue();
	public static final String SELECT_EMPLEADO_POR_APELLIDO = PeticionesBDEmpleado.SELECT_EMPLEADO_POR_APELLIDO.getValue();
	public static final String DELETE_EMPLEADO_POR_ID = PeticionesBDEmpleado.DELETE_EMPLEADO_POR_ID.getValue();
	public static final String INSERT_EMPLEADO = PeticionesBDEmpleado.INSERT_EMPLEADO.getValue();
	public static final String UPDATE_EMPLEADO = PeticionesBDEmpleado.UPDATE_EMPLEADO.getValue();
	
	public static void main(String[] args) {


		String nombre = "pepe";
		
		GestionEmpleado gestion = new GestionEmpleado();
		
		//gestion.mostrarEmpleadoPorNombre(SELECT_EMPLEADO_POR_NOMBRE, nombre);

		//gestion.deleteEmpleadoPorId(DELETE_EMPLEADO_POR_ID, 3);
		
		//gestion.insertEmpleado(INSERT_EMPLEADO, nombre, nombre, LocalDate.now(), 2000);
		
		//gestion.updateEmpleado(UPDATE_EMPLEADO, "jose", "gomez", LocalDate.now(), 2000, 5);
		
		GestionEmpleado.mostrarEmpleadosPorApellido(SELECT_EMPLEADO_POR_APELLIDO, "%gomez%");
		
	}


}
