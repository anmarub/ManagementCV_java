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
public class clsCities {
    private int idCity;
    private String nameCity;
    private String codDane;
    private int idDepartament;
    private clsDepartament departamento;

    public clsCities(int idCity, String nameCity, String codDane, int idDepartament, clsDepartament departamento) {
        this.idCity = idCity;
        this.nameCity = nameCity;
        this.codDane = codDane;
        this.idDepartament = idDepartament;
        this.departamento = departamento;

    }

    /**
     * @return the nameCity
     */
    public String getNameCity() {
        return nameCity;
    }

    /**
     * @param nameCity the nameCity to set
     */
    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
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

    /**
     * @return the idDepartament
     */
    public int getIdDepartament() {
        return idDepartament;
    }

    /**
     * @param idDepartament the idDepartament to set
     */
    public void setIdDepartament(int idDepartament) {
        this.idDepartament = idDepartament;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public clsDepartament getDepartamento() {
        return departamento;
    }

    public void setDepartamento(clsDepartament departamento) {
        this.departamento = departamento;
    }

    
    
        
    
}
