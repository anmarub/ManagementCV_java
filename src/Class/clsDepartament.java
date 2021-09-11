/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author andres.rubiano
 */
public class clsDepartament {
    
    private String nameDepartament;
    private String codDane;
    
    public clsDepartament(String nameDepartament, String codDane){
        this.nameDepartament = nameDepartament;
        this.codDane = codDane;
    }

    /**
     * @return the nameDepartament
     */
    public String getNameDepartament() {
        return nameDepartament;
    }

    /**
     * @param nameDepartament the nameDepartament to set
     */
    public void setNameDepartament(String nameDepartament) {
        this.nameDepartament = nameDepartament;
    }

    /**
     * @return the codDane
     */
    public String getCodDane() {
        return codDane;
    }

    /**
     * @param codDane the codDane to set
     */
    public void setCodDane(String codDane) {
        this.codDane = codDane;
    }
    
    
    
}
