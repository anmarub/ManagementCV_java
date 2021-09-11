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
public class clsReference {
    private int idReference;
    private String codeReference;
    private String firtsName;
    private String phone;
    private String cellPhone;
    private String email;

    public clsReference(int idReference, String codeReference, String firtsName, String phone, String cellPhone, String email) {
        this.idReference = idReference;
        this.codeReference = codeReference;
        this.firtsName = firtsName;
        this.phone = phone;
        this.cellPhone = cellPhone;
        this.email = email;
    }


    
    

    /**
     * @return the firtsName
     */
    public String getFirtsName() {
        return firtsName;
    }

    /**
     * @param firtsName the firtsName to set
     */
    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the cellPhone
     */
    public String getCellPhone() {
        return cellPhone;
    }

    /**
     * @param cellPhone the cellPhone to set
     */
    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the idReference
     */
    public int getIdReference() {
        return idReference;
    }

    /**
     * @param idReference the idReference to set
     */
    public void setIdReference(int idReference) {
        this.idReference = idReference;
    }

    /**
     * @return the codeReference
     */
    public String getCodeReference() {
        return codeReference;
    }

    /**
     * @param codeReference the codeReference to set
     */
    public void setCodeReference(String codeReference) {
        this.codeReference = codeReference;
    }
    
    
    
}
