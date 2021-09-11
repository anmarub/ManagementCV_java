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

import Class.clsGender;

/**
 *
 * @author andres.rubiano
 */
public class modelGender {

    DbData ParametrosConexion;

    public modelGender() {
        this.ParametrosConexion = new DbData();
    }

    public boolean createGenero(clsGender genero){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            
            String sqlgenero = "INSERT INTO gender (code_gender, name_gender, initials) VALUES (?,?,?)";
            PreparedStatement asignarGenero = conexionBD.prepareStatement(sqlgenero, Statement.RETURN_GENERATED_KEYS);
            
            asignarGenero.setString(1, genero.getCodeGender());
            asignarGenero.setString(2, genero.getNameGender());
            asignarGenero.setString(3, genero.getInitials());

            int insertarFiles = asignarGenero.executeUpdate();

            if(insertarFiles > 0){
                
                ResultSet generarKeys = asignarGenero.getGeneratedKeys();
            }
            System.out.println("Modelo Crear: Respuesta Correcta del Servidor");
            return true;

        } catch (SQLException errors) {
            System.out.println("Modelo Crear: Error en la conexion: " + " " +errors.getMessage());
            return false;
        }
    }

    public clsGender searchGenero(String cod_Genero){
        clsGender genero = null;
        
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            String sqlGenero = "SELECT code_gender, name_gender, initials FROM gender WHERE code_gender = ?";
            PreparedStatement asignarGenero = conexionBD.prepareStatement(sqlGenero);
            asignarGenero.setString(1, cod_Genero);
            ResultSet respuesta = asignarGenero.executeQuery();

            while(respuesta.next()){

                String CodGender = respuesta.getString(1);
                String nameGender = respuesta.getString(2);
                String initials = respuesta.getString(3);
                
                genero = new clsGender(CodGender, nameGender, initials);

            }
            System.out.println("Modelo Actulizar: Respuesta Correcta del Servidor");
            return genero;
        } catch (Exception errors) {
            System.out.println("Modelo Actulizar: Error en la conexion: " + " " +errors.getMessage());
            return genero;
        }
    }

    public boolean updateGenero(clsGender genero){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            String sqlGenero = "UPDATE gender SET name_gender = ?, initials = ? WHERE code_gender = ?";
            PreparedStatement asignarGenero = conexionBD.prepareStatement(sqlGenero);
            
            asignarGenero.setString(1, genero.getNameGender());
            asignarGenero.setString(2, genero.getInitials());
            asignarGenero.setString(3, genero.getCodeGender());

            int ActualizarFila = asignarGenero.executeUpdate();
            System.out.println("Modelo Actualizar: Respuesta Correcta del Servidor");

            return ActualizarFila > 0;

        } catch (Exception errors) {
            System.out.println("Modelo Actualizar: Error en la conexion: " + " " +errors.getMessage());
        }
        return true;

    }

    public boolean deleteGenero(String genero){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            String sqlGenero = "DELETE FROM gender WHERE code_gender = ?";
            PreparedStatement asignarGenero = conexionBD.prepareStatement(sqlGenero);
            asignarGenero.setString(1, genero);

            int ActualizarFila = asignarGenero.executeUpdate();
            
            System.out.println("Modelo Eliminar: Respuesta Correcta del Servidor");
        
            return ActualizarFila > 0;
        } catch (Exception e) {

            System.out.println("Modelo Eliminar: Error en la conexion: " + " " +e.getMessage());
            return false;
        }
    }

    public LinkedList<clsGender> ListGenero(){
        LinkedList<clsGender> listGenero = new LinkedList<>();
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            
            String ConsultaBusqueda = "SELECT code_gender, name_gender, initials FROM gender";
            PreparedStatement genero = conexionBD.prepareStatement(ConsultaBusqueda);
            ResultSet respuesta = genero.executeQuery();
            
            while(respuesta.next()){
                String codigoGenero = respuesta.getString(1);
                String nombreGenero = respuesta.getString(2);
                String initials = respuesta.getString(3);

                clsGender Genero = new clsGender(codigoGenero, nombreGenero, initials);
                listGenero.add(Genero);
            }
            System.out.println("Modelo lista Generos: Respuesta Correcta del Servidor");
            return listGenero;
        } catch(Exception error){
                System.out.println("Modelo lista Generos: Error en la conexion: " + " " +error.getMessage());
                return listGenero;
                }
    }    
}
