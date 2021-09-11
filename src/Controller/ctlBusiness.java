/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.LinkedList;

import Class.*;
import Model.*;

/**
 *
 * @author andres.rubiano
 */
public class ctlBusiness {
    
    private modelBusiness modelEmpresa;

    public ctlBusiness() {
        
        this.modelEmpresa = new modelBusiness();
    }
    
    public boolean createEmpresa(clsBusiness empresa){
        try{
                boolean value = this.modelEmpresa.createEmpresa(empresa);
                System.out.println("Controlador: Informacion Llamada Correctamente ");
            return value;
        }catch(Exception errors){
            System.out.println("Error Crear Empresa: " + errors);
            return false;
            }
    }
    
    public clsBusiness searchEmpresa(int codigo){
        clsBusiness empresa = null;
        try{
                empresa = this.modelEmpresa.searchEmpresa(codigo);
                System.out.println("Controlador: Informacion Llamada Correctamente ");
            return empresa;
        }catch(Exception errors){
            System.out.println("Error Buscar Empresa: " + errors);
            return null;
                }
    }

    public boolean updateEmpresa(clsBusiness empresa){
        try{
                boolean value = this.modelEmpresa.updateEmpresa((clsBusiness)empresa);
                System.out.println("Controlador: Informacion Llamada Correctamente ");
            return value;
        }catch(Exception errors){
            System.out.println("Error Actualizar Empresa: " + errors);
            return false;
            }

    }


    public LinkedList<clsCities> ListCities(){
        LinkedList<clsCities> listCities = null;
        try{
                listCities = this.modelEmpresa.ListCities();
                System.out.println("Controlador: Informacion Llamada Correctamente ");
                return listCities;

        }catch(Exception errors){
            System.out.println("Error Lista Ciudades: " + errors);
                return listCities;
                }
    }
    
    
}
