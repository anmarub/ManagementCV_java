/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.LinkedList;

import Class.clsGender;
import Model.modelGender;

/**
 *
 * @author andres.rubiano
 */
public class ctlGender {

    modelGender modeloGenero;

    public ctlGender() {
        this.modeloGenero = new modelGender();
    }

    public boolean createGenero(clsGender genero){
        try{
                this.modeloGenero.createGenero(genero);
                System.out.println("Controlador Genero: Informacion Llamada Correctamente ");
            return true;
        }catch(Exception errors){
            System.out.println("Error Crear Genero: " + errors);
            return false;
            }
    }
    
    public clsGender searchGenero(String codigo){
        clsGender genero = null;
        try{
            genero = this.modeloGenero.searchGenero(codigo);
                System.out.println("Controlador Genero: Informacion Llamada Correctamente ");
            return genero;
        }catch(Exception errors){
            System.out.println("Error Buscar Genero: " + errors);
            return null;
                }
    }

    public boolean updateGenero(clsGender genero){
        try{
                this.modeloGenero.updateGenero(genero);
                System.out.println("Controlador Genero: Informacion Llamada Correctamente ");
            return true;
        }catch(Exception errors){
            System.out.println("Error Actualizar Genero: " + errors);
            return false;
            }

    }

    public boolean deleteGenero(String cod_genero){
        try{
                this.modeloGenero.deleteGenero(cod_genero);
                System.out.println("Controlador Genero: Informacion Llamada Correctamente ");
            return true;
        }catch(Exception errors){
            System.out.println("Error Buscar Genero: " + errors);
            return false;
                }
    }
    
    public LinkedList<clsGender> ListGenero(){
        LinkedList<clsGender> listGenero = null;
        try {
            listGenero = this.modeloGenero.ListGenero();
            System.out.println("Controlador Genero: Paso controlado correcto!!");
            return listGenero;
            
        } catch (Exception e) {
            System.out.println("Controlador: Error Lista Genero: " + e);
            return listGenero;
        }
    }
    
}
