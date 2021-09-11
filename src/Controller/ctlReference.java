/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.modelReference;
import java.util.LinkedList;

import Class.clsReference;

/**
 *
 * @author andres.rubiano
 */
public class ctlReference {
    modelReference modelReferencias;

    public ctlReference() {
        this.modelReferencias = new modelReference();
    }
    
    public boolean createReferencias(clsReference Referencias){
        try{
                boolean value = this.modelReferencias.createReferencia(Referencias);
                System.out.println("Controlador Referencias: Informacion Llamada Correctamente ");
            return value;
        }catch(Exception errors){
            System.out.println("Error Crear Referencias: " + errors);
            return false;
            }
    }
    
    public clsReference searchReferencias(String codigo){
        clsReference Referencias = null;
        try{
            Referencias = this.modelReferencias.searchReferencia(codigo);
                System.out.println("Controlador Referencias: Informacion Llamada Correctamente ");
            return Referencias;
        }catch(Exception errors){
            System.out.println("Error Buscar Referencias: " + errors);
            return null;
                }
    }

    public boolean updateReferencias(clsReference Referencias){
        try{
                boolean value = this.modelReferencias.updateReferencia(Referencias);
                System.out.println("Controlador Referencias: Informacion Llamada Correctamente ");
            return value;
        }catch(Exception errors){
            System.out.println("Error Actualizar Referencias: " + errors);
            return false;
            }

    }

    public boolean deleteReferencias(String cod_Referencias){
        try{
                boolean value = this.modelReferencias.deleteReferencia(cod_Referencias);
                System.out.println("Controlador Referencias: Informacion Llamada Correctamente ");
            return value;
        }catch(Exception errors){
            System.out.println("Error Buscar Referencias: " + errors);
            return false;
                }
    }
    
    public LinkedList<clsReference> ListReferencias(){
        LinkedList<clsReference> listReferencias = null;
        try {
            listReferencias = this.modelReferencias.ListReferencias();
            System.out.println("Controlador Referencias: Paso controlado correcto!!");
            return listReferencias;
            
        } catch (Exception e) {
            System.out.println("Controlador: Error Lista Referencias: " + e);
            return listReferencias;
        }
    }
    
}
