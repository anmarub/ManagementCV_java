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
public class clsTypeDocument {
    
    private String nameDocument;
    private String codeType;
    clsEmployed employee;
    
    public clsTypeDocument(String nameDocument, String codeType){
        this.nameDocument = nameDocument;
        this.codeType = codeType;
    
    }

    /**
     * @return the nameDocument
     */
    public String getNameDocument() {
        return nameDocument;
    }

    /**
     * @param nameDocument the nameDocument to set
     */
    public void setNameDocument(String nameDocument) {
        this.nameDocument = nameDocument;
    }

    /**
     * @return the codeType
     */
    public String getCodeType() {
        return codeType;
    }

    /**
     * @param codeType the codeType to set
     */
    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    
    
    
}
