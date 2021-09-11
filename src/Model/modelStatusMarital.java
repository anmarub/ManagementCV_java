/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import Class.clsMaritalStatus;

/**
 *
 * @author andres.rubiano
 */
public class modelStatusMarital {
    
    DbData ParametrosConexion;

    
    public modelStatusMarital() {
        ParametrosConexion = new DbData();
    }

    public boolean createestadoCivil(clsMaritalStatus estadoCivil){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            
            String sqlestadoCivil = "INSERT INTO marital_status (code_marital_status, name_status) VALUES (?,?)";
            PreparedStatement asignarEstadoCivil = conexionBD.prepareStatement(sqlestadoCivil, Statement.RETURN_GENERATED_KEYS);
            
            asignarEstadoCivil.setString(1, estadoCivil.getCodeMaritalStatus());
            asignarEstadoCivil.setString(2, estadoCivil.getNameStatus());

            int insertarFiles = asignarEstadoCivil.executeUpdate();

            if(insertarFiles > 0){
                
                ResultSet generarKeys = asignarEstadoCivil.getGeneratedKeys();
            }
            System.out.println("Modelo Crear: Respuesta Correcta del Servidor");
            return true;

        } catch (SQLException errors) {
            System.out.println("Modelo Crear: Error en la conexion: " + " " +errors.getMessage());
            return false;
        }
    }

    public clsMaritalStatus searchestadoCivil(String cod_estadoCivil){
        clsMaritalStatus estadoCivil = null;
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            String sqlEstCivil = "SELECT code_marital_status, name_status FROM marital_status WHERE code_marital_status = ?";
            
            PreparedStatement asignarEstadoCivil = conexionBD.prepareStatement(sqlEstCivil);
            
            asignarEstadoCivil.setString(1, cod_estadoCivil);
            
            ResultSet respuesta = asignarEstadoCivil.executeQuery();

            while(respuesta.next()){

                String codEstadoCivil = respuesta.getString(1);
                String namEstadoCivil = respuesta.getString(2);
                
                estadoCivil = new clsMaritalStatus(namEstadoCivil, codEstadoCivil);

            }
            System.out.println("Modelo Actulizar: Respuesta Correcta del Servidor");
            return estadoCivil;
        } catch (Exception errors) {
            System.out.println("Modelo Actulizar: Error en la conexion: " + " " +errors.getMessage());
            return estadoCivil;
        }
    }

    public boolean updateestadoCivil(clsMaritalStatus estadoCivil){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            String sqlEstCivil = "UPDATE marital_status SET name_status = ? WHERE code_marital_status = ?";
            PreparedStatement asignarEstadoCivil = conexionBD.prepareStatement(sqlEstCivil);
            
            asignarEstadoCivil.setString(1, estadoCivil.getNameStatus());
            asignarEstadoCivil.setString(2, estadoCivil.getCodeMaritalStatus());

            int ActualizarFila = asignarEstadoCivil.executeUpdate();

            System.out.println("Modelo Actualizar: Respuesta Correcta del Servidor");

            return ActualizarFila > 0;

        } catch (Exception errors) {
            System.out.println("Modelo Actualizar: Error en la conexion: " + " " +errors.getMessage());
        }
        return true;

    }

    public boolean deleteEstadoCivil(String estadoCivil){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            
            String sqlEstCivil = "DELETE FROM marital_status WHERE code_marital_status = ?";
            PreparedStatement asignarEstadoCivil = conexionBD.prepareStatement(sqlEstCivil);
            
            asignarEstadoCivil.setString(1, estadoCivil);

            int ActualizarFila = asignarEstadoCivil.executeUpdate();
            
            System.out.println("Modelo Eliminar: Respuesta Correcta del Servidor");
        
            return ActualizarFila > 0;
        } catch (Exception e) {

            System.out.println("Modelo Eliminar: Error en la conexion: " + " " +e.getMessage());
            return false;
        }
    }


    public LinkedList<clsMaritalStatus> ListEstadoCivil(){
        LinkedList<clsMaritalStatus> listEstadoCivil = new LinkedList<>();
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            
            String ConsultaBusqueda = "SELECT code_marital_status, name_status FROM marital_status";
            PreparedStatement estadoCivil = conexionBD.prepareStatement(ConsultaBusqueda);
            ResultSet respuesta = estadoCivil.executeQuery();
            
            while(respuesta.next()){

                String codigoEstadoCivil = respuesta.getString(1);
                String nombreEstadoCivil = respuesta.getString(2);

                clsMaritalStatus EstadoCivil = new clsMaritalStatus(nombreEstadoCivil, codigoEstadoCivil);
                listEstadoCivil.add(EstadoCivil);
            }
            System.out.println("Modelo lista Estado Civil: Respuesta Correcta del Servidor");
            return listEstadoCivil;
        } catch(Exception error){
                System.out.println("Modelo lista Estado Civil: Error en la conexion: " + " " +error.getMessage());
                return listEstadoCivil;
                }
 
        }
    
}

