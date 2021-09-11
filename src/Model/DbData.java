/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


/**
 *
 * @author andres.rubiano
 */
public class DbData {
    
    private final String driver = "com.mysql.jdbc.Driver";
    private final String usuario = "wcb1_app";
    private final String password = "eg9FBIyR";
    private final String url = "jdbc:mysql://wuawi.com:3306/wcb1_admincv";
    
    
    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }
    

    
}
