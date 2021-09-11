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
public class clsEmployed {
    private int idEmployed;
    private String identityNumber;
    private String firtsName;
    private String secondName;
    private String firtsLastname;
    private String secondLastname;
    private String birthDate;
    private String address;
    private String neighborhood;
    private String phone;
    private String cellphone;
    private String email;
    private int idIdentityType; 
    private int idBusiness; 
    private int idMaritalStatus; 
    private int idGender; 
    private int idCity;
    private int idDepartament;
    private clsTypeDocument tipoDocumento;
    private clsBusiness Empresa;
    private clsReference referencia;
    private clsMaritalStatus estadoCivil;
    private clsGender genero;
    private clsCities ciudad;
    private clsDepartament departamento;
    



    public clsEmployed(int idEmployed, String identityNumber, String firtsName, String secondName, String firtsLastname,
            String secondLastname, String birthDate, String address, String neighborhood, String phone,
            String cellphone, String email, int idIdentityType, int idBusiness, int idMaritalStatus,
            int idGender, int idCity, int idDepartament, clsDepartament departamento) {
        this.idEmployed = idEmployed;
        this.identityNumber = identityNumber;
        this.firtsName = firtsName;
        this.secondName = secondName;
        this.firtsLastname = firtsLastname;
        this.secondLastname = secondLastname;
        this.birthDate = birthDate;
        this.address = address;
        this.neighborhood = neighborhood;
        this.phone = phone;
        this.cellphone = cellphone;
        this.email = email;
        this.idIdentityType = idIdentityType;
        this.idBusiness = idBusiness;
        this.idMaritalStatus = idMaritalStatus;
        this.idGender = idGender;
        this.idCity = idCity;
        this.idDepartament = idDepartament;
        this.departamento = departamento;
    }

    /**
     * @return the identityNumber
     */
    public String getIdentityNumber() {
        return identityNumber;
    }

    /**
     * @param identityNumber the identityNumber to set
     */
    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
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
     * @return the secondName
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * @param secondName the secondName to set
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
     * @return the firtsLastname
     */
    public String getFirtsLastname() {
        return firtsLastname;
    }

    /**
     * @param firtsLastname the firtsLastname to set
     */
    public void setFirtsLastname(String firtsLastname) {
        this.firtsLastname = firtsLastname;
    }

    /**
     * @return the secondLastname
     */
    public String getSecondLastname() {
        return secondLastname;
    }

    /**
     * @param secondLastname the secondLastname to set
     */
    public void setSecondLastname(String secondLastname) {
        this.secondLastname = secondLastname;
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
     * @return the neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * @param neighborhood the neighborhood to set
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     * @return the birthDate
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the cellphone
     */
    public String getCellphone() {
        return cellphone;
    }

    /**
     * @param cellphone the cellphone to set
     */
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
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
     * @return the idEmployed
     */
    public int getIdEmployed() {
        return idEmployed;
    }

    /**
     * @param idEmployed the idEmployed to set
     */
    public void setIdEmployed(int idEmployed) {
        this.idEmployed = idEmployed;
    }

    /**
     * @return the idIdentityType
     */
    public int getIdIdentityType() {
        return idIdentityType;
    }

    /**
     * @param idIdentityType the idIdentityType to set
     */
    public void setIdIdentityType(int idIdentityType) {
        this.idIdentityType = idIdentityType;
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

    /**
     * @return the idMaritalStatus
     */
    public int getIdMaritalStatus() {
        return idMaritalStatus;
    }

    /**
     * @param idMaritalStatus the idMaritalStatus to set
     */
    public void setIdMaritalStatus(int idMaritalStatus) {
        this.idMaritalStatus = idMaritalStatus;
    }

    /**
     * @return the idGender
     */
    public int getIdGender() {
        return idGender;
    }

    /**
     * @param idGender the idGender to set
     */
    public void setIdGender(int idGender) {
        this.idGender = idGender;
    }

    /**
     * @return the idCity
     */
    public int getIdCity() {
        return idCity;
    }

    /**
     * @param idCity the idCity to set
     */
    public void setIdCity(int idCity) {
        this.idCity = idCity;
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

    /**
     * @return the tipoDocumento
     */
    public clsTypeDocument getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param tipoDocumento the tipoDocumento to set
     */
    public void setTipoDocumento(clsTypeDocument tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * @return the Empresa
     */
    public clsBusiness getEmpresa() {
        return Empresa;
    }

    /**
     * @param Empresa the Empresa to set
     */
    public void setEmpresa(clsBusiness Empresa) {
        this.Empresa = Empresa;
    }

    /**
     * @return the referencia
     */
    public clsReference getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(clsReference referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the estadoCivil
     */
    public clsMaritalStatus getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(clsMaritalStatus estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * @return the genero
     */
    public clsGender getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(clsGender genero) {
        this.genero = genero;
    }

    /**
     * @return the ciudad
     */
    public clsCities getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(clsCities ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the departamento
     */
    public clsDepartament getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(clsDepartament departamento) {
        this.departamento = departamento;
    }
    
    
}
