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
public class clsTypeReference {
    private String codeReference;
    private String nameReference;
    
    public clsTypeReference(String codeReference, String nameReference){
        this.codeReference = codeReference;
        this.nameReference = nameReference;
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

    /**
     * @return the nameReference
     */
    public String getNameReference() {
        return nameReference;
    }

    /**
     * @param nameReference the nameReference to set
     */
    public void setNameReference(String nameReference) {
        this.nameReference = nameReference;
    }
    
    
}
