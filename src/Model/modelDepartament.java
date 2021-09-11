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

import Class.clsDepartament;

/**
 *
 * @author andres.rubiano
 */
public class modelDepartament {

    DbData ParametrosConexion;

    public modelDepartament() {
        this.ParametrosConexion = new DbData();
    }

    public boolean createDepartament(clsDepartament departamento){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            
            String sqlDto = "INSERT INTO departament (cod_dane, name_departament) VALUES (?,?)";
            PreparedStatement asignarDto = conexionBD.prepareStatement(sqlDto, Statement.RETURN_GENERATED_KEYS);
            
            asignarDto.setString(1, departamento.getCodDane());
            asignarDto.setString(2, departamento.getNameDepartament());

            int insertarFiles = asignarDto.executeUpdate();

            if(insertarFiles > 0){
                
                ResultSet generarKeys = asignarDto.getGeneratedKeys();
            }
            System.out.println("Modelo Crear: Respuesta Correcta del Servidor");
            return true;

        } catch (SQLException errors) {
            System.out.println("Modelo Crear: Error en la conexion: " + " " +errors.getMessage());
            return false;
        }
    }

    public clsDepartament searchDepartament(String cod_departament){
        clsDepartament departamento = null;
        
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            String sqlDto = "SELECT cod_dane, name_departament FROM departament WHERE cod_dane = ?";
            PreparedStatement asignarDto = conexionBD.prepareStatement(sqlDto);
            asignarDto.setString(1, cod_departament);
            ResultSet respuesta = asignarDto.executeQuery();

            while(respuesta.next()){

                String CodDtoDane = respuesta.getString(1);
                String nameDto = respuesta.getString(2);
                
                departamento = new clsDepartament(nameDto, CodDtoDane);

            }
            System.out.println("Modelo Crear: Respuesta Correcta del Servidor");
            return departamento;
        } catch (Exception errors) {
            System.out.println("Modelo Crear: Error en la conexion: " + " " +errors.getMessage());
            return departamento;
        }
        
    }

    public boolean updateDepartament(clsDepartament departament){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            String sqlDto = "UPDATE departament SET cod_dane = ?, name_departament = ? WHERE id = ?";
            PreparedStatement asignarDto = conexionBD.prepareStatement(sqlDto);
            
            asignarDto.setString(1, departament.getCodDane());
            asignarDto.setString(2, departament.getNameDepartament());

            int ActualizarFila = asignarDto.executeUpdate();
            System.out.println("Modelo Crear: Respuesta Correcta del Servidor");

            return ActualizarFila > 0;

        } catch (Exception errors) {
            System.out.println("Modelo Crear: Error en la conexion: " + " " +errors.getMessage());
            return false;
        }
        
    }

    public boolean deleteDepartament(String cod_departament){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            String sqlDto = "DELETE FROM departament WHERE cod_dane = ?";
            PreparedStatement asignarDto = conexionBD.prepareStatement(sqlDto);
            asignarDto.setString(1, cod_departament);

            int ActualizarFila = asignarDto.executeUpdate();
            
            System.out.println("Modelo Eliminar: Respuesta Correcta del Servidor");
        
            return ActualizarFila > 0;
        } catch (Exception e) {

            System.out.println("Modelo Eliminar: Error en la conexion: " + " " +e.getMessage());
            return false;
        }

    }

    public LinkedList<clsDepartament> ListDepartamentos(){
        LinkedList<clsDepartament> listDepartamentos = new LinkedList<>();
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            
            String ConsultaBusqueda = "SELECT id, name_departament, cod_dane FROM departament";
            PreparedStatement departament = conexionBD.prepareStatement(ConsultaBusqueda);
            ResultSet respuesta = departament.executeQuery();
            
            while(respuesta.next()){
                int idDepartamento = respuesta.getInt(1);
                String nomDepartamento = respuesta.getString(2);
                String codDane = respuesta.getString(3);

                clsDepartament departamento = new clsDepartament(nomDepartamento, codDane);
                listDepartamentos.add(departamento);
            }
            System.out.println("Modelo lista Departamentos: Respuesta Correcta del Servidor");
            return listDepartamentos;
        } catch(Exception error){
                System.out.println("Modelo lista Departamentos: Error en la conexion: " + " " +error.getMessage());
                return listDepartamentos;
                }
    }
    
}
