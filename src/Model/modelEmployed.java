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
import Class.clsEmployed;

/**
 *
 * @author andres.rubiano
 */
public class modelEmployed {

    DbData ParametrosConexion;
  
    public modelEmployed() {
        this.ParametrosConexion = new DbData();
    }

    public boolean createEmpleado(clsEmployed employed){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            
            String sqlEmpleado = "INSERT INTO employed (id, identity_number, firts_name, second_name, firts_lastname, second_lastname, birth_date, address, neighborhood, phone, cellphone, email, id_identity_type, id_business, id_marital_status, id_gender, id_city, id_departament) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement asignarEmpleado = conexionBD.prepareStatement(sqlEmpleado, Statement.RETURN_GENERATED_KEYS);
            
            asignarEmpleado.setInt(1, employed.getIdEmployed());
            asignarEmpleado.setString(2, employed.getIdentityNumber());
            asignarEmpleado.setString(3, employed.getFirtsName());
            asignarEmpleado.setString(4, employed.getSecondName());
            asignarEmpleado.setString(5, employed.getFirtsLastname());
            asignarEmpleado.setString(6, employed.getSecondLastname());
            asignarEmpleado.setString(7, employed.getBirthDate());
            asignarEmpleado.setString(8, employed.getAddress());
            asignarEmpleado.setString(9, employed.getNeighborhood());
            asignarEmpleado.setString(10, employed.getPhone());
            asignarEmpleado.setString(11, employed.getCellphone());
            asignarEmpleado.setString(12, employed.getEmail());
            asignarEmpleado.setInt(13, employed.getIdIdentityType());
            asignarEmpleado.setInt(14, employed.getIdBusiness());
            asignarEmpleado.setInt(15, employed.getIdMaritalStatus());
            asignarEmpleado.setInt(16, employed.getIdGender());
            asignarEmpleado.setInt(17, employed.getIdCity());
            asignarEmpleado.setInt(18, employed.getIdDepartament());



            int insertarFiles = asignarEmpleado.executeUpdate();

            if(insertarFiles > 0){
                
                ResultSet generarKeys = asignarEmpleado.getGeneratedKeys();
            }
            System.out.println("Modelo Crear: Respuesta Correcta del Servidor");
            return true;

        } catch (SQLException errors) {
            System.out.println("Modelo Crear: Error en la conexion: " + " " +errors.getMessage());
            return false;
        }
    }

    public clsEmployed searchEmpleado(String codEmpleado){
        clsEmployed empleado = null;
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            String sqlEmpleado = "SELECT id, identity_number, firts_name, second_name, firts_lastname, second_lastname, birth_date, address, neighborhood, phone, cellphone, email, id_identity_type, id_business, id_marital_status, id_gender, id_city, id_departament FROM employed WHERE identity_number = ?";
            PreparedStatement asignarEmpleado = conexionBD.prepareStatement(sqlEmpleado);
            asignarEmpleado.setString(1, codEmpleado);
            ResultSet respuesta = asignarEmpleado.executeQuery();

            while(respuesta.next()){

                int idEmpleado = respuesta.getInt(1);
                String numeroDoc = respuesta.getString(2);
                String primerNom = respuesta.getString(3);
                String segundNom = respuesta.getString(4);
                String primerApell = respuesta.getString(5);
                String segundoApell = respuesta.getString(6);
                String fechaNacimiento = respuesta.getString(7);
                String direccion = respuesta.getString(8);
                String barrio = respuesta.getString(9);
                String telFijo = respuesta.getString(10);
                String celular = respuesta.getString(11);
                String correo = respuesta.getString(12);
                int idTipoDocumento = respuesta.getInt(13);
                int idEmpresa = respuesta.getInt(14);
                int idEstadoCivil = respuesta.getInt(15);
                int idGenero = respuesta.getInt(16);
                int idCiudad = respuesta.getInt(17);
                int idDepartamento = respuesta.getInt(18);
                
                
                empleado = new clsEmployed(idEmpleado, numeroDoc, primerNom, segundNom, primerApell, segundoApell, fechaNacimiento, direccion, barrio, telFijo, celular, correo, idTipoDocumento, idEmpresa, idEstadoCivil, idGenero, idCiudad, idDepartamento, null);

            }
            System.out.println("Modelo Crear: Respuesta Correcta del Servidor");
            return empleado;
        } catch (Exception errors) {
            System.out.println("Modelo Crear: Error en la conexion: " + " " +errors.getMessage());
            return empleado;
        }

    }

    public boolean updateEmpleado(clsEmployed employed){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            String sqlEmpleado = "UPDATE employed SET identity_number = ?, firts_name = ?, second_name = ?, firts_lastname = ?, second_lastname = ?, birth_date = ?, address = ?, neighborhood = ?, phone = ?, cellphone = ?, email = ?, id_identity_type = ?, id_business = ?, id_marital_status = ?, id_gender = ?, id_city = ?, id_departament = ? WHERE id = ?";
            PreparedStatement asignarEmpleado = conexionBD.prepareStatement(sqlEmpleado);
            
            asignarEmpleado.setString(1, employed.getIdentityNumber());
            asignarEmpleado.setString(2, employed.getFirtsName());
            asignarEmpleado.setString(3, employed.getSecondName());
            asignarEmpleado.setString(4, employed.getFirtsLastname());
            asignarEmpleado.setString(5, employed.getSecondLastname());
            asignarEmpleado.setString(6, employed.getBirthDate());
            asignarEmpleado.setString(7, employed.getAddress());
            asignarEmpleado.setString(8, employed.getNeighborhood());
            asignarEmpleado.setString(9, employed.getPhone());
            asignarEmpleado.setString(10, employed.getCellphone());
            asignarEmpleado.setString(11, employed.getEmail());
            asignarEmpleado.setInt(12, employed.getIdIdentityType());
            asignarEmpleado.setInt(13, employed.getIdBusiness());
            asignarEmpleado.setInt(14, employed.getIdMaritalStatus());
            asignarEmpleado.setInt(15, employed.getIdGender());
            asignarEmpleado.setInt(16, employed.getIdCity());
            asignarEmpleado.setInt(17, employed.getIdDepartament());
            asignarEmpleado.setInt(18, employed.getIdEmployed());

            int ActualizarFila = asignarEmpleado.executeUpdate();
            System.out.println("Modelo Crear: Respuesta Correcta del Servidor");

            return ActualizarFila > 0;

        } catch (Exception errors) {
            System.out.println("Modelo Crear: Error en la conexion: " + " " +errors.getMessage());
            return false;
        }
    }

    public boolean deleteEmpleado(String codEmpleado){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            String sqlEmpleado = "DELETE FROM employed WHERE identity_number = ?";
            PreparedStatement asignarEmpleado = conexionBD.prepareStatement(sqlEmpleado);
            asignarEmpleado.setString(1, codEmpleado);

            int ActualizarFila = asignarEmpleado.executeUpdate();
            
            System.out.println("Modelo Eliminar: Respuesta Correcta del Servidor");
        
            return ActualizarFila > 0;
        } catch (Exception e) {

            System.out.println("Modelo Eliminar: Error en la conexion: " + " " +e.getMessage());
            return false;
        }
    }

    public LinkedList<clsEmployed> ListEmpleado(){
        LinkedList<clsEmployed> listEmpleado = new LinkedList<>();
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            
            String ConsultaBusqueda = "SELECT a.id, identity_number, firts_name, second_name, firts_lastname, second_lastname, birth_date, address, neighborhood, phone, cellphone, email, id_identity_type, id_business, id_marital_status, id_gender, id_city, a.id_departament, b.name_departament, b.cod_dane FROM employed a INNER JOIN departament b ON a.id_departament = b.id ORDER BY a.id";
            PreparedStatement employed = conexionBD.prepareStatement(ConsultaBusqueda);
            ResultSet respuesta = employed.executeQuery();
            
            while(respuesta.next()){
                int idEmpleado = respuesta.getInt(1);
                String numeroDoc = respuesta.getString(2);
                String primerNom = respuesta.getString(3);
                String segundNom = respuesta.getString(4);
                String primerApell = respuesta.getString(5);
                String segundoApell = respuesta.getString(6);
                String fechaNacimiento = respuesta.getString(7);
                String direccion = respuesta.getString(8);
                String barrio = respuesta.getString(9);
                String telFijo = respuesta.getString(10);
                String celular = respuesta.getString(11);
                String correo = respuesta.getString(12);
                int idTipoDocumento = respuesta.getInt(13);
                int idEmpresa = respuesta.getInt(14);
                int idEstadoCivil = respuesta.getInt(15);
                int idGenero = respuesta.getInt(16);
                int idCiudad = respuesta.getInt(17);
                int idDepartamento = respuesta.getInt(18);
                
                String nameDepartamento = respuesta.getString(19);
                String codDane = respuesta.getString(20);

                clsDepartament departamento = new clsDepartament(nameDepartamento, codDane);
                clsEmployed employedo = new clsEmployed(idEmpleado, numeroDoc, primerNom, segundNom, primerApell, segundoApell, fechaNacimiento, direccion, barrio, telFijo, celular, correo, idTipoDocumento, idEmpresa, idEstadoCivil, idGenero, idCiudad, idDepartamento, departamento);
                listEmpleado.add(employedo);
            }
            System.out.println("Modelo lista Empleados: Respuesta Correcta del Servidor");
            return listEmpleado;
        } catch(Exception error){
                System.out.println("Modelo lista Empleados: Error en la conexion: " + " " +error.getMessage());
                return listEmpleado;
                }
    }
    
}
