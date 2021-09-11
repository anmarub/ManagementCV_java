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

import Class.clsTypeReference;

/**
 *
 * @author andres.rubiano
 */
public class modelTypeReference {
    
    DbData ParametrosConexion;

    public modelTypeReference() {
        ParametrosConexion = new DbData();
    }

    public boolean createTipoReferencia(clsTypeReference tipoReferencia){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            
            String sqlTReferencia = "INSERT INTO type_reference (code_reference, name_reference) VALUES (?,?)";
            PreparedStatement asignarTReferencia = conexionBD.prepareStatement(sqlTReferencia, Statement.RETURN_GENERATED_KEYS);
            
            asignarTReferencia.setString(1, tipoReferencia.getCodeReference());
            asignarTReferencia.setString(2, tipoReferencia.getNameReference());

            int insertarFiles = asignarTReferencia.executeUpdate();

            if(insertarFiles > 0){
                
                ResultSet generarKeys = asignarTReferencia.getGeneratedKeys();
            }
            System.out.println("Modelo Crear: Respuesta Correcta del Servidor");
            return true;

        } catch (SQLException errors) {
            System.out.println("Modelo Crear: Error en la conexion: " + " " +errors.getMessage());
            return false;
        }
    }

    public clsTypeReference searchTipoReferencia(String cod_TipoReferencia){
        clsTypeReference referencia = null;
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            String sqlTReferencia = "SELECT code_reference, name_reference FROM type_reference WHERE code_reference = ?";
            PreparedStatement asignarTReferencia = conexionBD.prepareStatement(sqlTReferencia);
            asignarTReferencia.setString(1, cod_TipoReferencia);
            ResultSet respuesta = asignarTReferencia.executeQuery();

            while(respuesta.next()){

                String CodGender = respuesta.getString(1);
                String nameGender = respuesta.getString(2);
                
                referencia = new clsTypeReference(CodGender, nameGender);

            }
            System.out.println("Modelo Actulizar: Respuesta Correcta del Servidor");
            return referencia;
        } catch (Exception errors) {
            System.out.println("Modelo Actulizar: Error en la conexion: " + " " +errors.getMessage());
            return referencia;
        }
    }

    public boolean updateTipoReferencia(clsTypeReference tipoReferencia){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            String sqlTReferencia = "UPDATE type_reference SET name_reference = ? WHERE code_reference = ?";
            PreparedStatement asignarTReferencia = conexionBD.prepareStatement(sqlTReferencia);
            
            asignarTReferencia.setString(1, tipoReferencia.getNameReference());
            asignarTReferencia.setString(2, tipoReferencia.getCodeReference());

            int ActualizarFila = asignarTReferencia.executeUpdate();
            System.out.println("Modelo Actualizar: Respuesta Correcta del Servidor");

            return ActualizarFila > 0;

        } catch (Exception errors) {
            System.out.println("Modelo Actualizar: Error en la conexion: " + " " +errors.getMessage());
            return false;
        }

    }

    public boolean deleteTipoReferencia(String TipoReferencia){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            String sqlTReferencia = "DELETE FROM type_reference WHERE code_reference = ?";
            PreparedStatement asignarTReferencia = conexionBD.prepareStatement(sqlTReferencia);
            asignarTReferencia.setString(1, TipoReferencia);

            int ActualizarFila = asignarTReferencia.executeUpdate();
            
            System.out.println("Modelo Eliminar: Respuesta Correcta del Servidor");
        
            return ActualizarFila > 0;
        } catch (Exception e) {

            System.out.println("Modelo Eliminar: Error en la conexion: " + " " +e.getMessage());
            return false;
        }
    }

    public LinkedList<clsTypeReference> listTypoReferencias(){
        LinkedList<clsTypeReference> listTipoReferencia = new LinkedList<>();
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            
            String ConsultaBusqueda = "SELECT code_reference, name_reference FROM type_reference";
            PreparedStatement referencia = conexionBD.prepareStatement(ConsultaBusqueda);
            ResultSet respuesta = referencia.executeQuery();
            
            while(respuesta.next()){
                String codigoTReferencia = respuesta.getString(1);
                String nombreTReferencia = respuesta.getString(2);

                clsTypeReference TReferencia = new clsTypeReference(codigoTReferencia, nombreTReferencia);
                listTipoReferencia.add(TReferencia);
            }
            System.out.println("Modelo lista Tipo Referencias: Respuesta Correcta del Servidor");
            return listTipoReferencia;
        } catch(Exception error){
            System.out.println("Modelo lista Tipos Referencias: Error en la conexion: " + " " +error.getMessage());
            return listTipoReferencia;
            }
    }


}
