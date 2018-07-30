package qap.mock.contacto;

import qap.crud.CrudFilterOptions;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author christian
 */
//@ManagedBean(name="contactos") // creado en faces-config
//@SessionScoped
public class ContactoJsf implements Serializable {
    //@Autowired //via faces-config
    ContactoSvc svc; 
            
    // lista
    private final CrudFilterOptions filter;
    private List items;
    private Contacto selected;

    public ContactoJsf() {
        this.filter = filterOptions();
    }

    public void setSvc(ContactoSvc svc) {
        this.svc = svc;
    }
    
    public String getSvcTestData() {
        return svc.getTestData();
    }

    public CrudFilterOptions getFilter() {
        return filter;
    }

    public List<Contacto> getItems() {
        if (items == null) {
            //items = ContactoMock.mockList("demo", "Alumnos");
            items = svc.getItems("demo", "Alumnos-svc");
        }
        return items;
    }

    public Contacto getSelected() {
        return selected;
    }

    public void setSelected(Contacto selected) {
        this.selected = selected;
    }

    public void refresh() {
        //nada x ahora
    }

    // filter
    static public CrudFilterOptions filterOptions() {
        CrudFilterOptions filter = new CrudFilterOptions();
        
        filter.setModulos(    Arrays.asList("Alumnos", "Docentes") );
        filter.setCategorias( Arrays.asList("Activo", "Inactivo") );
        filter.setEtiquetas(  Arrays.asList("Matematica II - 2017", "Historia I - 2016", "Geografia I - 2016") );
        filter.setVistas(     Arrays.asList("Fotos", "Lista", "Info") );
        
        return filter;
    }
    
}
