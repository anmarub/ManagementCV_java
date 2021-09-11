/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.LinkedList;

import Class.clsEmployed;
import Model.modelEmployed;

/**
 *
 * @author andres.rubiano
 */
public class ctlEmployed {
    modelEmployed modeloEmpleado;

    public ctlEmployed() {
        this.modeloEmpleado = new modelEmployed();
    }
    
    public boolean createEmpleado(clsEmployed empleado){
        try{
                boolean value = this.modeloEmpleado.createEmpleado(empleado);
                System.out.println("Controlador: Informacion Llamada Correctamente ");
            return value;
        }catch(Exception errors){
            System.out.println("Error Crear Empleado: " + errors);
            return false;
            }
    }
    
    public clsEmployed searchEmpleado(String codigo){
        clsEmployed empleado = null;
        try{
            empleado = this.modeloEmpleado.searchEmpleado(codigo);
                System.out.println("Controlador: Informacion Llamada Correctamente ");
            return empleado;
        }catch(Exception errors){
            System.out.println("Error Buscar Empleado: " + errors);
            return null;
                }
    }

    public boolean updateEmpleado(clsEmployed empleado){
        try{
                boolean value = this.modeloEmpleado.updateEmpleado(empleado);
                System.out.println("Controlador: Informacion Llamada Correctamente ");
            return value;
        }catch(Exception errors){
            System.out.println("Error Actualizar Empleados: " + errors);
            return false;
            }

    }

    public boolean deleteEmpleado(String cod_departament){
        try{
                this.modeloEmpleado.deleteEmpleado(cod_departament);
                System.out.println("Controlador: Informacion Llamada Correctamente ");
            return true;
        }catch(Exception errors){
            System.out.println("Error Buscar Empleado: " + errors);
            return false;
                }
    }
    
    public LinkedList<clsEmployed> ListEmpleado(){
        LinkedList<clsEmployed> listEmpleadoos = null;
        try {
            listEmpleadoos = this.modeloEmpleado.ListEmpleado();
            System.out.println("Controlador: Paso controlado correcto!!");
            return listEmpleadoos;
            
        } catch (Exception e) {
            System.out.println("Controlador: Error Lista Empleados: " + e);
            return listEmpleadoos;
        }
    }
    
}
