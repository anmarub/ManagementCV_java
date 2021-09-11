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
public class clsBusiness {
    
    private int idBusiness;
    private String nit;
    private String nameBusiness;
    private String address;
    private String city;

    //Constructor de la clase Business

    public clsBusiness(int idBusiness, String nit, String nameBusiness, String address, String city) {
        this.idBusiness = idBusiness;
        this.nit = nit;
        this.nameBusiness = nameBusiness;
        this.address = address;
        this.city = city;
    }
            
    
    /**
     * @return the nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * @return the nameBusiness
     */
    public String getNameBusiness() {
        return nameBusiness;
    }

    /**
     * @param nameBusiness the nameBusiness to set
     */
    public void setNameBusiness(String nameBusiness) {
        this.nameBusiness = nameBusiness;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the idBusiness
     */
    public int getIdBusiness() {
        return idBusiness;
    }

    /**
     * @param idBusiness the idBusiness to set
     */
    public void setIdBusiness(int idBusiness) {
        this.idBusiness = idBusiness;
    }
    
    
}
