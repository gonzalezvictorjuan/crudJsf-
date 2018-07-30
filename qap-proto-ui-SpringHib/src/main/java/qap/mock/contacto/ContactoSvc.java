package qap.mock.contacto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author christian
 */
public class ContactoSvc implements Serializable {
        
    public String getTestData() {

        return "JSF/Primefaces 6.1 + Spring 4.3.10 Integration";

    }
    
    public List getItems(String propietario, String modulo) {
        
        return ContactoMock.mockList(propietario, modulo);
                
    }
    
}
