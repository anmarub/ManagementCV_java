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
public class clsMaritalStatus {
 
    private String codeMaritalStatus;
    private String nameStatus;
    clsEmployed employee;
    
    public clsMaritalStatus(String nameStatus, String codeMaritalStatus){
        this.nameStatus = nameStatus;
        this.codeMaritalStatus = codeMaritalStatus;
    }

    /**
     * @return the nameStatus
     */
    public String getNameStatus() {
        return nameStatus;
    }

    /**
     * @param nameStatus the nameStatus to set
     */
    public void setNameStatus(String nameStatus) {
        this.nameStatus = nameStatus;
    }

    /**
     * @return the codeMaritalStatus
     */
    public String getCodeMaritalStatus() {
        return codeMaritalStatus;
    }

    /**
     * @param codeMaritalStatus the codeMaritalStatus to set
     */
    public void setCodeMaritalStatus(String codeMaritalStatus) {
        this.codeMaritalStatus = codeMaritalStatus;
    }
    
    
    
    
}
