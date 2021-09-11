/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.LinkedList;

import Class.clsCities;
import Model.modelCities;

/**
 *
 * @author andres.rubiano
 */
public class ctlCities {
    
    private modelCities modelCiudades;

    
    public ctlCities() {
        
        this.modelCiudades = new modelCities();
    }


    public boolean createCiudad(clsCities ciudad){
        try{
                boolean value = this.modelCiudades.createCiudad(ciudad);
                System.out.println("Controlador: Informacion Llamada Correctamente ");
            return value;
        }catch(Exception errors){
            System.out.println("Error Crear Ciudad: " + errors);
            return false;
            }
    }
    
    public clsCities searchCiudad(String codigo){
        clsCities ciudad = null;
        try{
                ciudad = this.modelCiudades.searchCiudad(codigo);
                System.out.println("Controlador: Informacion Llamada Correctamente ");
            return ciudad;
        }catch(Exception errors){
            System.out.println("Error Buscar Ciudad: " + errors);
            return null;
                }
    }

    public boolean updateCiudad(clsCities ciudad){
        try{
                boolean value = this.modelCiudades.updateCiudad((clsCities)ciudad);
                System.out.println("Controlador: Informacion Llamada Correctamente ");
            return value;
        }catch(Exception errors){
            System.out.println("Error Actualizar Ciudad: " + errors);
            return false;
            }

    }

    public boolean deleteCiudad(String codigo){
        try{
                boolean value = this.modelCiudades.deleteCiudad(codigo);
                System.out.println("Controlador: Informacion Llamada Correctamente ");
            return value;
        }catch(Exception errors){
            System.out.println("Error Buscar Ciudad: " + errors);
            return false;
                }
    }

    public LinkedList<clsCities> ListCiudades(){
        LinkedList<clsCities> listCities = null;
        try{
                listCities = this.modelCiudades.ListCiudades();
                System.out.println("Controlador: Informacion Llamada Correctamente ");
                return listCities;

        }catch(Exception errors){
            System.out.println("Error Lista Ciudades: " + errors);
                return listCities;
                }
    }
}
