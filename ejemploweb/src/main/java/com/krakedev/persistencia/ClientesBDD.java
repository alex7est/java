package com.krakedev.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.entidades.Cliente;
import com.krakedev.excepciones.KrakedevExcepcion;
import com.krakedev.utils.ConexionBDD;

public class ClientesBDD {

	public void insertar(Cliente cliente) throws KrakedevExcepcion {
		Connection con = null;

		try {
			con = ConexionBDD.obtenerConexion();
			if (con != null) {
				System.out.println("CONECTADO");
				try {
					PreparedStatement ps = con
							.prepareStatement("insert into clientes(cedula, nombre, numerohijos) values(?,?,?)");
					ps.setString(1, cliente.getCedula());
					ps.setString(2, cliente.getNombre());
					ps.setInt(3, cliente.getNumeroHijos());

					ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new KrakedevExcepcion("Error al insertar cliente");
				}
			} else {
				System.out.println("ERROR AL OBTENER CONEXION");
			}
		} catch (KrakedevExcepcion e) {
			throw e;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void actualizar(Cliente cliente) throws KrakedevExcepcion {
		Connection con = null;

		try {
			con = ConexionBDD.obtenerConexion();
			if (con != null) {
				System.out.println("CONECTADO");
				try {
					PreparedStatement ps = con
							.prepareStatement("UPDATE clientes SET nombre = ?, numerohijos = ? WHERE cedula = ?");
					ps.setString(1, cliente.getNombre());
					ps.setInt(2, cliente.getNumeroHijos());
					ps.setString(3, cliente.getCedula());

					int filasActualizadas = ps.executeUpdate();
					if (filasActualizadas == 0) {
						throw new KrakedevExcepcion(
								"El cliente con la cédula " + cliente.getCedula() + " no fue encontrado.");
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new KrakedevExcepcion("Error al actualizar cliente. Detalle: " + e.getMessage());
				}
			} else {
				System.out.println("ERROR AL OBTENER CONEXION");
			}
		} catch (KrakedevExcepcion e) {
			throw e;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public ArrayList<Cliente> recuperarTodos() throws KrakedevExcepcion {
		ArrayList<Cliente> clientes = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = ConexionBDD.obtenerConexion();
			if (con != null) {
				System.out.println("CONECTADO");
				ps = con.prepareStatement("SELECT cedula, nombre, numerohijos FROM clientes");
				rs = ps.executeQuery();

				while (rs.next()) {
					String cedula = rs.getString("cedula");
					String nombre = rs.getString("nombre");
					int numeroHijos = rs.getInt("numerohijos");

					Cliente cliente = new Cliente(cedula, nombre, numeroHijos);
					clientes.add(cliente);
				}
			} else {
				System.out.println("ERROR AL OBTENER CONEXION");
			}
		} catch (KrakedevExcepcion e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevExcepcion("Error al consultar. Detalle: " + e.getMessage());
		} finally {			
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return clientes;
	}
	
	public Cliente buscarPorPK(String cedulaBusqueda) throws KrakedevExcepcion {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Cliente cliente = null;
		
		try {
			con = ConexionBDD.obtenerConexion();
			if (con != null) {
				System.out.println("CONECTADO");
				ps = con.prepareStatement("SELECT cedula, nombre, numerohijos FROM clientes WHERE cedula = ?;");
				ps.setString(1, cedulaBusqueda);
				rs = ps.executeQuery();
				
				if (rs.next()) {
					String cedula = rs.getString("cedula");
					String nombre = rs.getString("nombre");
					int numeroHijos = rs.getInt("numerohijos");

					cliente = new Cliente(cedula, nombre, numeroHijos);					
				}
			} else {
				System.out.println("ERROR AL OBTENER CONEXION");
			}
		} catch (KrakedevExcepcion e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevExcepcion("Error al consultar. Detalle: " + e.getMessage());
		} finally {			
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return cliente;
	}
	
	public ArrayList<Cliente> buscarPorNumeroHijos(int numeroHijos) throws KrakedevExcepcion {
        ArrayList<Cliente> clientesConHijos = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConexionBDD.obtenerConexion();
            if (con != null) {
                ps = con.prepareStatement("SELECT * FROM clientes WHERE numerohijos >= ?");
                ps.setInt(1, numeroHijos);
                rs = ps.executeQuery();

                while (rs.next()) {
                    String cedula = rs.getString("cedula");
                    String nombre = rs.getString("nombre");
                    int numHijos = rs.getInt("numerohijos");

                    Cliente cliente = new Cliente(cedula, nombre, numHijos);
                    clientesConHijos.add(cliente);
                }
            } else {
                System.out.println("ERROR AL OBTENER CONEXION");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new KrakedevExcepcion("Error al buscar clientes por número de hijos. Detalle: " + e.getMessage());
        } finally {            
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return clientesConHijos;
    }
	
}
