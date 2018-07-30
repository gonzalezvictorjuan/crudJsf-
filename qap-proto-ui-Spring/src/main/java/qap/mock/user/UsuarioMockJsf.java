package qap.mock.user;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author siete
 */
@ManagedBean(name = "id") // creado en faces-config
@SessionScoped
public class UsuarioMockJsf implements Serializable {

    private String user;
    private String password;
    private boolean logged = false;

    private static final String LOGIN_VIEW  = "/index";
    private static final String LOGOUT_VIEW = "/index";
    private static final String HOME_VIEW   = "/home";

    public UsuarioMockJsf() {
    }

    public String prepareLogin() {
        return LOGIN_VIEW;
    }

    public String doLogin()  {       
        this.setLogged(true);        
        return HOME_VIEW; // usa la pagina definida en spring-security 
    }

    public String doLogout() {
        this.setLogged(false);
        return LOGOUT_VIEW; // usa la pagina definida en spring-security ?
    }
    
    public String getCurrentUser() {
        return "demo";
    }
    
    // Getters y Setters
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }
    
    
}
