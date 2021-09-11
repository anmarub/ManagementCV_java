/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.LinkedList;

import Class.clsTypeDocument;
import Model.modelTypeDocument;

/**
 *
 * @author andres.rubiano
 */
public class ctlTypeDocument {
    modelTypeDocument modelTipoDocumento;

    public ctlTypeDocument() {
        this.modelTipoDocumento = new modelTypeDocument();
    }

    public boolean createTipoDocumento(clsTypeDocument tipoDocumento){
        try{
                this.modelTipoDocumento.createtipoDocumento(tipoDocumento);
                System.out.println("Controlador Genero: Informacion Llamada Correctamente ");
            return true;
        }catch(Exception errors){
            System.out.println("Error Crear Genero: " + errors);
            return false;
            }
    }
    
    public clsTypeDocument searchTipoDocumento(String codigo){
        clsTypeDocument TipoDocumento = null;
        try{
            TipoDocumento = this.modelTipoDocumento.searchtipoDocumento(codigo);
                System.out.println("Controlador Genero: Informacion Llamada Correctamente ");
            return TipoDocumento;
        }catch(Exception errors){
            System.out.println("Error Buscar Genero: " + errors);
            return null;
                }
    }

    public boolean updateTipoDocumento(clsTypeDocument tipoDocumento){
        try{
                this.modelTipoDocumento.updatetipoDocumento(tipoDocumento);
                System.out.println("Controlador Genero: Informacion Llamada Correctamente ");
            return true;
        }catch(Exception errors){
            System.out.println("Error Actualizar Genero: " + errors);
            return false;
            }

    }

    public boolean deleteTipoDocumento(String cod_TipoDocumento){
        try{
                this.modelTipoDocumento.deletetipoDocumento(cod_TipoDocumento);
                System.out.println("Controlador Genero: Informacion Llamada Correctamente ");
            return true;
        }catch(Exception errors){
            System.out.println("Error Buscar Genero: " + errors);
            return false;
                }
    }
    
    public LinkedList<clsTypeDocument> ListTipoDocumentos(){
        LinkedList<clsTypeDocument> listGenero = null;
        try {
            listGenero = this.modelTipoDocumento.ListTipoDocumentos();
            System.out.println("Controlador Genero: Paso controlado correcto!!");
            return listGenero;
            
        } catch (Exception e) {
            System.out.println("Controlador: Error Lista Genero: " + e);
            return listGenero;
        }
    }
    
    
}
