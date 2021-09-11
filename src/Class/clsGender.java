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
public class clsGender {
    
    private String codeGender;
    private String nameGender;
    private String initials;
    clsEmployed employee;

    public clsGender(String codeGender, String nameGender, String initials) {
        this.codeGender = codeGender;
        this.nameGender = nameGender;
        this.initials = initials;

    }
    
    

    /**
     * @return the nameGender
     */
    public String getNameGender() {
        return nameGender;
    }

    /**
     * @param nameGender the nameGender to set
     */
    public void setNameGender(String nameGender) {
        this.nameGender = nameGender;
    }

    /**
     * @return the initials
     */
    public String getInitials() {
        return initials;
    }

    /**
     * @param initials the initials to set
     */
    public void setInitials(String initials) {
        this.initials = initials;
    }

    /**
     * @return the codeGender
     */
    public String getCodeGender() {
        return codeGender;
    }

    /**
     * @param codeGender the codeGender to set
     */
    public void setCodeGender(String codeGender) {
        this.codeGender = codeGender;
    }
    
    
}
