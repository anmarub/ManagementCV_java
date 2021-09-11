/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.LinkedList;

import Class.clsTypeReference;
import Model.modelTypeReference;



/**
 *
 * @author andres.rubiano
 */
public class ctlTypeReference {
    modelTypeReference modelTipoReferencia;

    public ctlTypeReference() {
        this.modelTipoReferencia = new modelTypeReference();
    }

    public boolean createTipoReferencia(clsTypeReference tipoReferencia){
        try{
                this.modelTipoReferencia.createTipoReferencia(tipoReferencia);
                System.out.println("Controlador Tipo Referencia: Informacion Llamada Correctamente ");
            return true;
        }catch(Exception errors){
            System.out.println("Error Crear Tipo Referencia: " + errors);
            return false;
            }
    }
    
    public clsTypeReference searchTipoReferencia(String codigo){
        clsTypeReference TipoReferencia = null;
        try{
            TipoReferencia = this.modelTipoReferencia.searchTipoReferencia(codigo);
                System.out.println("Controlador Tipo Referencia: Informacion Llamada Correctamente ");
            return TipoReferencia;
        }catch(Exception errors){
            System.out.println("Error Buscar Tipo Referencia: " + errors);
            return null;
                }
    }

    public boolean updateTipoReferencia(clsTypeReference tipoReferencia){
        try{
                this.modelTipoReferencia.updateTipoReferencia(tipoReferencia);
                System.out.println("Controlador Tipo Referencia: Informacion Llamada Correctamente ");
            return true;
        }catch(Exception errors){
            System.out.println("Error Actualizar Tipo Referencia: " + errors);
            return false;
            }

    }

    public boolean deleteTipoReferencia(String cod_TipoReferencia){
        try{
                this.modelTipoReferencia.deleteTipoReferencia(cod_TipoReferencia);
                System.out.println("Controlador Tipo Referencia: Informacion Llamada Correctamente ");
            return true;
        }catch(Exception errors){
            System.out.println("Error Eliminar Tipo Referencia: " + errors);
            return false;
                }
    }
    
    public LinkedList<clsTypeReference> listTypeReferences(){
        LinkedList<clsTypeReference> listReferencia = null;
        try {
            listReferencia = this.modelTipoReferencia.listTypoReferencias();
            System.out.println("Controlador Tipo Referencia: Paso controlado correcto!!");
            return listReferencia;
            
        } catch (Exception e) {
            System.out.println("Controlador: Error Lista Tipo Referencia: " + e);
            return listReferencia;
        }
    }
    
}
