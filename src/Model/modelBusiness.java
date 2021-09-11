/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Class.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author andres.rubiano
 */
public class modelBusiness {
    
    DbData ParametrosConexion;

    public modelBusiness() {
        
        this.ParametrosConexion = new DbData();
    }
    
        public boolean createEmpresa(clsBusiness empresa){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            String consultaEmpresa = "INSERT INTO business(nit, name_business, address, city) VALUES(?,?,?,?)";
            PreparedStatement declararEmpresa = conexionBD.prepareStatement(consultaEmpresa, Statement.RETURN_GENERATED_KEYS);
            
            declararEmpresa.setString(1, empresa.getNit());
            declararEmpresa.setString(2, empresa.getNameBusiness());
            declararEmpresa.setString(3, empresa.getAddress());
            declararEmpresa.setString(4, empresa.getCity());

            int insertarFilas = declararEmpresa.executeUpdate();
            if(insertarFilas > 0){
                ResultSet generatedKeys = declararEmpresa.getGeneratedKeys();
            }
            System.out.println("Modelo Crear: Respuesta Correcta del Servido");
            return true;
        }catch(SQLException error){
            System.out.println("Modelo Crear: Error en la conexion: " + " " +error.getMessage());
            return false;
            }
    }
        
        public clsBusiness searchEmpresa(int codigo){
        clsBusiness empresa = null;
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            String ConsultaBusqueda = "SELECT id, nit, name_business, address, city FROM business WHERE id = ?";
            PreparedStatement declararEmpresa = conexionBD.prepareStatement(ConsultaBusqueda);
            declararEmpresa.setInt(1, codigo);
            ResultSet respuesta = declararEmpresa.executeQuery();
            while(respuesta.next()){
                int idEmpresa = respuesta.getInt(1);
                String nit = respuesta.getString(2);
                String nombreEmpresa = respuesta.getString(3);
                String direccion = respuesta.getString(4);
                String ciudad = respuesta.getString(5);
                
                empresa = new clsBusiness(idEmpresa, nit, nombreEmpresa, direccion, ciudad);
            }
            System.out.println("Modelo Buscar: Respuesta Correcta del Servido");
            return empresa;
        } catch(Exception error){
                System.out.println("Modelo Buscar: Error en la conexion: " + " " +error.getMessage());
                return empresa;
                }
    }

    public boolean updateEmpresa(clsBusiness empresa){
        try(Connection conexionBD = DriverManager.getConnection(ParametrosConexion.getUrl(), ParametrosConexion.getUsuario(), ParametrosConexion.getPassword())){
            String actualizarEmpresa = "UPDATE business SET nit = ?, name_business = ?, address = ?, city = ? WHERE id = ?";
            PreparedStatement declararEmpresa = conexionBD.prepareStatement(actualizarEmpresa);
            
            
            declararEmpresa.setString(1, empresa.getNit());
            declararEmpresa.setString(2, empresa.getNameBusiness());
            declararEmpresa.setString(3, empresa.getAddress());
            declararEmpresa.setString(4, empresa.getCity());
            declararEmpresa.setInt(5, empresa.getIdBusiness());
            
            int ActualizarFilasPet = declararEmpresa.executeUpdate();
            
            System.out.println("Modelo Actualizar: Respuesta Correcta del Servido");
            return ActualizarFilasPet > 0;

        }catch(SQLException errors){
            
            System.out.println("Modelo Actualizar: Error en la conexion:" + " " + errors.getMessage());
            return false;
            
            }

    }
    
    //Consulta para generar los datos de las ciudades en el combobox
    public LinkedList<clsCities> ListCities(){
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
