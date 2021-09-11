/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.LinkedList;

import Class.clsDepartament;
import Model.modelDepartament;

/**
 *
 * @author andres.rubiano
 */
public class ctlDepartament {

    modelDepartament modeloDepartamento;
    
    public ctlDepartament() {
        this.modeloDepartamento = new modelDepartament();
    }

    public boolean createDepartament(clsDepartament departamento){
        try{
                this.modeloDepartamento.createDepartament(departamento);
                System.out.println("Controlador: Informacion Llamada Correctamente ");
            return true;
        }catch(Exception errors){
            System.out.println("Error Crear Ciudad: " + errors);
            return false;
            }
    }
    
    public clsDepartament searchDepartament(String codigo){
        clsDepartament departamento = null;
        try{
            departamento = this.modeloDepartamento.searchDepartament(codigo);
                System.out.println("Controlador: Informacion Llamada Correctamente ");
            return departamento;
        }catch(Exception errors){
            System.out.println("Error Buscar Ciudad: " + errors);
            return null;
                }
    }

    public boolean updateDepartament(clsDepartament departamento){
        try{
                this.modeloDepartamento.updateDepartament(departamento);
                System.out.println("Controlador: Informacion Llamada Correctamente ");
            return true;
        }catch(Exception errors){
            System.out.println("Error Actualizar Departamento: " + errors);
            return false;
            }

    }

    public boolean deleteDepartament(String cod_departament){
        try{
                this.modeloDepartamento.deleteDepartament(cod_departament);
                System.out.println("Controlador: Informacion Llamada Correctamente ");
            return true;
        }catch(Exception errors){
            System.out.println("Error Buscar Ciudad: " + errors);
            return false;
                }
    }
    
    public LinkedList<clsDepartament> ListDepartament(){
        LinkedList<clsDepartament> listDepartamentos = null;
        try {
            listDepartamentos = this.modeloDepartamento.ListDepartamentos();
            System.out.println("Controlador: Paso controlado correcto!!");
            return listDepartamentos;
            
        } catch (Exception e) {
            System.out.println("Controlador: Error Lista Departamentos: " + e);
            return listDepartamentos;
        }
    }
    
}
