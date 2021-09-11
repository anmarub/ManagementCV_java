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

import Class.clsTypeDocument;

/**
 *
 * @author andres.rubiano
 */
public class modelTypeDocument {
 
    DbData ParametrosConexion;


    public modelTypeDocument() {
        ParametrosConexion = new DbData();
    }

    public boolean createtipoDocumento(clsTypeDocument tipoDocumento){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            
            String sqlTipoDocumento = "INSERT INTO type_document (code_type, name_document) VALUES (?,?)";
            PreparedStatement asignarTipoDocumento = conexionBD.prepareStatement(sqlTipoDocumento, Statement.RETURN_GENERATED_KEYS);
            
            asignarTipoDocumento.setString(1, tipoDocumento.getCodeType());
            asignarTipoDocumento.setString(2, tipoDocumento.getNameDocument());

            int insertarFiles = asignarTipoDocumento.executeUpdate();

            if(insertarFiles > 0){
                
                ResultSet generarKeys = asignarTipoDocumento.getGeneratedKeys();
            }
            System.out.println("Modelo Crear: Respuesta Correcta del Servidor");
            return true;

        } catch (SQLException errors) {
            System.out.println("Modelo Crear: Error en la conexion: " + " " +errors.getMessage());
            return false;
        }
    }

    public clsTypeDocument searchtipoDocumento(String cod_tipoDocumento){
        clsTypeDocument tipoDocumento = null;
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            
            String sqlTDocumento = "SELECT code_type, name_document FROM type_document WHERE code_type = ?";
            PreparedStatement asignarTipoDocumento = conexionBD.prepareStatement(sqlTDocumento);
            
            asignarTipoDocumento.setString(1, cod_tipoDocumento);
            ResultSet respuesta = asignarTipoDocumento.executeQuery();

            while(respuesta.next()){

                String CodTipoDocumento = respuesta.getString(1);
                String nameTipoDocumento = respuesta.getString(2);
                
                tipoDocumento = new clsTypeDocument(nameTipoDocumento, CodTipoDocumento);

            }
            System.out.println("Modelo Actulizar: Respuesta Correcta del Servidor");
            return tipoDocumento;
        } catch (Exception errors) {
            System.out.println("Modelo Actulizar: Error en la conexion: " + " " +errors.getMessage());
            return tipoDocumento;
        }
    }

    public boolean updatetipoDocumento(clsTypeDocument tipoDocumento){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            String sqlTDocumento = "UPDATE type_document SET name_document = ? WHERE code_type = ?";
            PreparedStatement asignarTipoDocumento = conexionBD.prepareStatement(sqlTDocumento);
            
            asignarTipoDocumento.setString(1, tipoDocumento.getNameDocument());
            asignarTipoDocumento.setString(2, tipoDocumento.getCodeType());

            int ActualizarFila = asignarTipoDocumento.executeUpdate();
            System.out.println("Modelo Actualizar: Respuesta Correcta del Servidor");

            return ActualizarFila > 0;

        } catch (Exception errors) {
            System.out.println("Modelo Actualizar: Error en la conexion: " + " " +errors.getMessage());
            return false;
        }

    }

    public boolean deletetipoDocumento(String tipoDocumento){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            String sqlTDocumento = "DELETE FROM type_document WHERE code_type = ?";
            PreparedStatement asignarTipoDocumento = conexionBD.prepareStatement(sqlTDocumento);
            asignarTipoDocumento.setString(1, tipoDocumento);

            int ActualizarFila = asignarTipoDocumento.executeUpdate();
            
            System.out.println("Modelo Eliminar: Respuesta Correcta del Servidor");
        
            return ActualizarFila > 0;
        } catch (Exception e) {

            System.out.println("Modelo Eliminar: Error en la conexion: " + " " +e.getMessage());
            return false;
        }
    }

    public LinkedList<clsTypeDocument> ListTipoDocumentos(){
        LinkedList<clsTypeDocument> listTipoDocumento = new LinkedList<>();
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            
            String ConsultaBusqueda = "SELECT code_type, name_document FROM type_document";
            PreparedStatement TipoDocumento = conexionBD.prepareStatement(ConsultaBusqueda);
            ResultSet respuesta = TipoDocumento.executeQuery();
            
            while(respuesta.next()){
                String codigoGenero = respuesta.getString(1);
                String nombreGenero = respuesta.getString(2);

                clsTypeDocument Genero = new clsTypeDocument(nombreGenero, codigoGenero);
                listTipoDocumento.add(Genero);
            }
            System.out.println("Modelo lista Tipo Documento: Respuesta Correcta del Servidor");
            return listTipoDocumento;
        } catch(Exception error){
            System.out.println("Modelo lista Tipo Documento: Error en la conexion: " + " " +error.getMessage());
            return listTipoDocumento;
            }
    }

}
