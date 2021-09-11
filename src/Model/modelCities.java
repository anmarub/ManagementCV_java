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

import Class.*;

/**
 *
 * @author andres.rubiano
 */
public class modelCities {
    
    DbData ParametrosConexion;

    public modelCities() {
        
        this.ParametrosConexion = new DbData();
    }

    public boolean createCiudad(clsCities ciudad){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            
            String sqlCiudad = "INSERT INTO cities(cod_dane, name_city, id_departament) VALUES (?,?,?)";
            PreparedStatement asignarCiudad = conexionBD.prepareStatement(sqlCiudad, Statement.RETURN_GENERATED_KEYS);
            
            asignarCiudad.setString(1, ciudad.getCodDane());
            asignarCiudad.setString(2, ciudad.getNameCity());
            asignarCiudad.setInt(3, ciudad.getIdDepartament());

            int insertarFiles = asignarCiudad.executeUpdate();
            if(insertarFiles > 0){
                
                ResultSet generarKeys = asignarCiudad.getGeneratedKeys();
            }
            System.out.println("Modelo Crear: Respuesta Correcta del Servido");
            return true;

        } catch (SQLException errors) {
            System.out.println("Modelo Crear: Error en la conexion: " + " " +errors.getMessage());
            return false;
        }
    }

    public clsCities searchCiudad(String cod_ciudad){
        clsCities ciudad = null;
        clsDepartament departamento = null;
        
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            String sqlCiudad = "SELECT a.id, a.cod_dane, a.name_city, a.id_departament, b.cod_dane, b.name_departament FROM cities a INNER JOIN departament b ON a.id_departament = b.id WHERE a.cod_dane = ?";
            PreparedStatement asignarCiudad = conexionBD.prepareStatement(sqlCiudad);
            asignarCiudad.setString(1, cod_ciudad);
            ResultSet respuesta = asignarCiudad.executeQuery();

            while(respuesta.next()){

                int idCity = respuesta.getInt(1);
                String codigoDane = respuesta.getString(2);
                String nombreCiudad = respuesta.getString(3);
                int idDepartamento = respuesta.getInt(4);

                String CodDtoDane = respuesta.getString(5);
                String nameDto = respuesta.getString(6);
                
                departamento = new clsDepartament(nameDto, CodDtoDane);
                ciudad = new clsCities(idCity, nombreCiudad, codigoDane, idDepartamento, departamento);
            }
            System.out.println("Modelo Crear: Respuesta Correcta del Servidor");
            return ciudad;
        } catch (Exception errors) {
            System.out.println("Modelo Crear: Error en la conexion: " + " " +errors.getMessage());
            return ciudad;
        }
        
    }

    public boolean updateCiudad(clsCities ciudad){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            String sqlCiudad = "UPDATE cities SET cod_dane = ?, name_city = ?, id_departament = ? WHERE id = ?";
            PreparedStatement asignarCiudad = conexionBD.prepareStatement(sqlCiudad);
            
            asignarCiudad.setString(1, ciudad.getCodDane());
            asignarCiudad.setString(2, ciudad.getNameCity());
            asignarCiudad.setInt(3, ciudad.getIdDepartament());
            asignarCiudad.setInt(4, ciudad.getIdCity());

            int ActualizarFila = asignarCiudad.executeUpdate();
            System.out.println("Modelo Crear: Respuesta Correcta del Servidor");

            return ActualizarFila > 0;

        } catch (Exception errors) {
            System.out.println("Modelo Crear: Error en la conexion: " + " " +errors.getMessage());
        }
        return true;
    }

    public boolean deleteCiudad(String cod_ciudad){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            String sqlCiudad = "DELETE FROM cities WHERE cod_dane = ?";
            PreparedStatement asignarCiudad = conexionBD.prepareStatement(sqlCiudad);
            asignarCiudad.setString(1, cod_ciudad);

            int ActualizarFila = asignarCiudad.executeUpdate();
            
            System.out.println("Modelo Eliminar: Respuesta Correcta del Servidor");
        
            return ActualizarFila > 0;
        } catch (Exception e) {

            System.out.println("Modelo Eliminar: Error en la conexion: " + " " +e.getMessage());
            return false;
        }
        
    }

    public LinkedList<clsCities> ListCiudades(){
        LinkedList<clsCities> listCities = new LinkedList<>();
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            
            String ConsultaBusqueda = "SELECT a.id, a.cod_dane, a.name_city, a.id_departament, b.cod_dane, b.name_departament FROM cities a INNER JOIN departament b ON a.id_departament = b.id";
            PreparedStatement declararcity = conexionBD.prepareStatement(ConsultaBusqueda);
            ResultSet respuesta = declararcity.executeQuery();
            while(respuesta.next()){
                int idCity = respuesta.getInt(1);
                String codDane = respuesta.getString(2);
                String nombreCity = respuesta.getString(3);
                int idDepartamento = respuesta.getInt(4);

                String CodDtoDane = respuesta.getString(5);
                String nameDto = respuesta.getString(6);

                clsDepartament departamento = new clsDepartament(nameDto, CodDtoDane);
                clsCities ciudad = new clsCities(idCity, nombreCity, codDane, idDepartamento, departamento);
                listCities.add(ciudad);
            }
            System.out.println("Modelo lista Ciudades: Respuesta Correcta del Servido");
            return listCities;
        } catch(Exception error){
                System.out.println("Modelo lista Ciudades: Error en la conexion: " + " " +error.getMessage());
                return listCities;
                }
    }

    

    
}
