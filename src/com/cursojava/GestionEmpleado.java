package com.cursojava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class GestionEmpleado {
	
	private static final String CONN = ConfigEmpleado.CONEXION.getValue();
	private static final String USER = ConfigEmpleado.USER.getValue();
	private static final String PWD = ConfigEmpleado.PASS.getValue();

	public static void mostrarEmpleadoPorNombre(String query, String nombre) {
		try (Connection conn = DriverManager.getConnection(CONN, USER, PWD);
				PreparedStatement ps = getPersonasPorNombre(query, nombre, conn); ResultSet rs = ps.executeQuery();) {
			mostrarEmpleados(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void mostrarEmpleadosPorApellido(String query, String apellido) {
		try (Connection conn = DriverManager.getConnection(CONN, USER, PWD);
				PreparedStatement ps = getPersonasPorNombre(query, apellido, conn); ResultSet rs = ps.executeQuery();) {
			mostrarEmpleados(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteEmpleadoPorId(String query, int id) {
		try  (Connection conn = DriverManager.getConnection(CONN, USER, PWD);
				PreparedStatement ps = conn.prepareStatement(query);
				){
			ps.setInt(1, id);
			int ret = ps.executeUpdate();
			if(ret > 0) {
				System.out.println("Se ha borrado al empleado con id " + id);
			}else {
				System.out.println("No habia ningun empleado con el id " + id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void insertEmpleado(String query, String nombre, String apellido, LocalDate fechaNacimiento, Integer salario) {
		try  (Connection conn = DriverManager.getConnection(CONN, USER, PWD);
				PreparedStatement ps = conn.prepareStatement(query);
				){
			ps.setString(1, nombre);
			ps.setString(2, apellido);
			ps.setDate(3, java.sql.Date.valueOf(fechaNacimiento));
			ps.setInt(4, salario);
			int ret = ps.executeUpdate();
			if(ret > 0) {
				System.out.println("Se ha insertado al empleado con nombre = " + nombre);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateEmpleado(String query, String nombre, String apellido, LocalDate fechaNacimiento, Integer salario, Integer idUsuario) {
		try  (Connection conn = DriverManager.getConnection(CONN, USER, PWD);
				PreparedStatement ps = conn.prepareStatement(query);
				){
			ps.setString(1, nombre);
			ps.setString(2, apellido);
			ps.setDate(3, java.sql.Date.valueOf(fechaNacimiento));
			ps.setInt(4, salario);
			ps.setInt(5, idUsuario);
			int ret = ps.executeUpdate();
			if(ret > 0) {
				System.out.println("Se ha actualizado al empleado con nombre = " + nombre);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void mostrarEmpleados(ResultSet rs) throws SQLException {
		// Iteramos sobre el ResultSet y mostramos los datos por pantalla
		while (rs.next()) {
			System.out.print("nombre = " + rs.getString("nombre"));
			System.out.print(", apellido = " + rs.getString("apellido"));
			System.out.print(", fecha nacimiento = " + rs.getDate("fecha_nacimiento"));
			System.out.println(", salario = " + rs.getInt("salario"));
		}
	}

	/**
	 * PreparedStatement para seleccionar una persona en la base de datos por su
	 * nombre
	 * 
	 * @param sql    la query
	 * @param nombre el nombre de la persona a buscar
	 * @param conn   la conexion
	 * @return el PreparedStatement para luego ejecutarlo
	 * @throws SQLException
	 */
	public static PreparedStatement getPersonasPorNombre(String sql, String nombre, Connection conn)
			throws SQLException {
		// Instanciar el PreparedStatement con la Conexion y la query
		PreparedStatement ps = conn.prepareStatement(sql);
		// Asignar el nombre en la primera variable de la query
		ps.setString(1, nombre);
		return ps;
	}
}
