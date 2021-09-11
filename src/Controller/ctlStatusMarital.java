/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.LinkedList;

import Class.clsMaritalStatus;
import Model.modelStatusMarital;

/**
 *
 * @author andres.rubiano
 */
public class ctlStatusMarital {
    modelStatusMarital modelEstadoCivil;

    public ctlStatusMarital() {
        this.modelEstadoCivil = new modelStatusMarital();
    }

    public boolean createEstadoCivil(clsMaritalStatus estadoCivil){
        try{
                this.modelEstadoCivil.createestadoCivil(estadoCivil);
                System.out.println("Controlador Genero: Informacion Llamada Correctamente ");
            return true;
        }catch(Exception errors){
            System.out.println("Error Crear Estado Civil: " + errors);
            return false;
            }
    }
    
    public clsMaritalStatus searchEstadoCivil(String codigo){
        clsMaritalStatus EstadoCivil = null;
        try{
            EstadoCivil = this.modelEstadoCivil.searchestadoCivil(codigo);
                System.out.println("Controlador Estado Civil: Informacion Llamada Correctamente ");
            return EstadoCivil;
        }catch(Exception errors){
            System.out.println("Error Buscar Estado Civil: " + errors);
            return null;
                }
    }

    public boolean updateEstadoCivil(clsMaritalStatus estadoCivil){
        try{
                this.modelEstadoCivil.updateestadoCivil(estadoCivil);
                System.out.println("Controlador Estado Civil: Informacion Llamada Correctamente ");
            return true;
        }catch(Exception errors){
            System.out.println("Error Actualizar Estado Civil: " + errors);
            return false;
            }

    }

    public boolean deleteEstadoCivil(String cod_EstadoCivil){
        try{
                this.modelEstadoCivil.deleteEstadoCivil(cod_EstadoCivil);
                System.out.println("Controlador Estado Civil: Informacion Llamada Correctamente ");
            return true;
        }catch(Exception errors){
            System.out.println("Error Buscar Estado Civil: " + errors);
            return false;
                }
    }
    
    public LinkedList<clsMaritalStatus> ListEstadoCivil(){
        LinkedList<clsMaritalStatus> listGenero = null;
        try {
            listGenero = this.modelEstadoCivil.ListEstadoCivil();
            System.out.println("Controlador Estado Civil: Paso controlado correcto!!");
            return listGenero;
            
        } catch (Exception e) {
            System.out.println("Controlador: Error Lista Estado Civil: " + e);
            return listGenero;
        }
    }
  
}
