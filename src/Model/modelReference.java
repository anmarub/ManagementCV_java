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

import Class.clsReference;

/**
 *
 * @author andres.rubiano
 */
public class modelReference {
    DbData ParametrosConexion;

    public modelReference() {
        this.ParametrosConexion = new DbData();
    }

    public boolean createReferencia(clsReference referencia){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            
            String sqlRef = "INSERT INTO reference (code_reference, firts_name, phone, cellphone, email) VALUES (?,?,?,?,?)";
            PreparedStatement asignarRef = conexionBD.prepareStatement(sqlRef, Statement.RETURN_GENERATED_KEYS);
            
            asignarRef.setString(1, referencia.getCodeReference());
            asignarRef.setString(2, referencia.getFirtsName());
            asignarRef.setString(2, referencia.getPhone());
            asignarRef.setString(2, referencia.getCellPhone());
            asignarRef.setString(2, referencia.getEmail());

            int insertarFiles = asignarRef.executeUpdate();

            if(insertarFiles > 0){
                
                ResultSet generarKeys = asignarRef.getGeneratedKeys();
            }
            System.out.println("Modelo Crear: Respuesta Correcta del Servidor");
            return true;

        } catch (SQLException errors) {
            System.out.println("Modelo Crear: Error en la conexion: " + " " +errors.getMessage());
            return false;
        }
    }

    public clsReference searchReferencia(String cod_Referencia){
        clsReference referencia = null;
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            String sqlRef = "SELECT id, code_reference, firts_name, phone, cellphone, email FROM reference WHERE code_reference = ?";
            PreparedStatement asignarRef = conexionBD.prepareStatement(sqlRef);
            asignarRef.setString(1, cod_Referencia);
            ResultSet respuesta = asignarRef.executeQuery();

            while(respuesta.next()){

                int idRef = respuesta.getInt(1);
                String codRef = respuesta.getString(2);
                String nombreRef = respuesta.getString(3);
                String telefonoRef = respuesta.getString(4);
                String movilRef = respuesta.getString(5);
                String emailRef = respuesta.getString(6);
                
                referencia = new clsReference(idRef, codRef, nombreRef, telefonoRef, movilRef, emailRef);

            }
            System.out.println("Modelo Crear: Respuesta Correcta del Servidor");
            return referencia;
        } catch (Exception errors) {
            System.out.println("Modelo Crear: Error en la conexion: " + " " +errors.getMessage());
            return referencia;
        }
    }

    public boolean updateReferencia(clsReference referencia){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            String sqlRef = "UPDATE reference SET code_reference = ?, firts_name = ?, phone = ?, cellphone = ?, email = ? WHERE id = ?";
            PreparedStatement asignarRef = conexionBD.prepareStatement(sqlRef);
            
            asignarRef.setString(1, referencia.getCodeReference());
            asignarRef.setString(2, referencia.getFirtsName());
            asignarRef.setString(3, referencia.getPhone());
            asignarRef.setString(4, referencia.getCellPhone());
            asignarRef.setString(5, referencia.getEmail());
            asignarRef.setInt(6, referencia.getIdReference());

            int ActualizarFila = asignarRef.executeUpdate();
            System.out.println("Modelo Crear: Respuesta Correcta del Servidor");

            return ActualizarFila > 0;

        } catch (Exception errors) {
            System.out.println("Modelo Crear: Error en la conexion: " + " " +errors.getMessage());
            return false;
        }
    }
    
    public boolean deleteReferencia(String referencia){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            String sqlRef = "DELETE FROM referencia WHERE code_reference = ?";
            PreparedStatement asignarRef = conexionBD.prepareStatement(sqlRef);
            asignarRef.setString(1, referencia);

            int ActualizarFila = asignarRef.executeUpdate();
            
            System.out.println("Modelo Eliminar: Respuesta Correcta del Servidor");
        
            return ActualizarFila > 0;
        } catch (Exception e) {

            System.out.println("Modelo Eliminar: Error en la conexion: " + " " +e.getMessage());
            return false;
        }
    }

    public LinkedList<clsReference> ListReferencias(){
        LinkedList<clsReference> listReferencia = new LinkedList<>();
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            
            String ConsultaBusqueda = "SELECT id, code_reference, firts_name, phone, cellphone, email FROM reference";
            PreparedStatement referencia = conexionBD.prepareStatement(ConsultaBusqueda);
            ResultSet respuesta = referencia.executeQuery();
            
            while(respuesta.next()){

                int idRef = respuesta.getInt(1);
                String codRef = respuesta.getString(2);
                String nombreRef = respuesta.getString(3);
                String telefonoRef = respuesta.getString(4);
                String movilRef = respuesta.getString(5);
                String emailRef = respuesta.getString(6);

                clsReference Ireferencia = new clsReference(idRef, codRef, nombreRef, telefonoRef, movilRef, emailRef);
                listReferencia.add(Ireferencia);
            }
            System.out.println("Modelo lista Referencias: Respuesta Correcta del Servidor");
            return listReferencia;
        } catch(Exception error){
                System.out.println("Modelo lista Referencias: Error en la conexion: " + " " +error.getMessage());
                return listReferencia;
                }
    }
   
}
