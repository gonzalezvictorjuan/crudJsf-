package qap.mock.contacto;

import java.io.Serializable;

/**
 *
 * @author siete
 */
public class Contacto implements Serializable {
    //*** AbstractEntity ***
    private Integer id;
    private String propietario;
    private String modulo;
    private String categoria;
    private String etiqueta = "";
    private String cod;
    private String nombre;
    private String notas;
    private String estado;
    private String fileLink; 
    
    private String nombreCorto;
    private String genero = GENERO_NEUTRO;
    private String domicilio;
    private String localidad;
    private String telefono;
    private String correo;
    private String docTipo;
    private String docNro;
    private String condIva;
    
    // Constantes
    private static final String GENERO_NEUTRO  = "Neutro";
    private static final String ESTADO_INICIAL = "Activo";
    
    public Contacto() {
        this.genero = GENERO_NEUTRO;
        this.estado = ESTADO_INICIAL;
    }

    public Contacto(Integer id) {
        this.id = id;
        this.genero = GENERO_NEUTRO;
        this.estado = ESTADO_INICIAL;
    }

    public Contacto(Integer id, String propietario, String modulo, String cod, String nombre) {
        this.id = id;
        this.propietario = propietario;
        this.modulo = modulo;
        this.cod = cod;
        this.nombre = nombre;
        this.nombreCorto = nombre;
        this.genero = GENERO_NEUTRO;
        this.estado = ESTADO_INICIAL;
    }

    public Contacto(Integer id, String propietario, String modulo, String categoria, 
                    String etiqueta, String cod, String nombre, String notas, 
                    String nombreCorto, String domicilio, String localidad, String telefono, 
                    String correo, String docTipo, String docNro, String condIva) {
        this.id = id;
        this.propietario = propietario;
        this.modulo = modulo;
        this.categoria = categoria;
        this.etiqueta = etiqueta;
        this.cod = cod;
        this.nombreCorto = nombreCorto;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.localidad = localidad;
        this.telefono = telefono;
        this.correo = correo;
        this.docTipo = docTipo;
        this.docNro = docNro;
        this.condIva = condIva;
        this.notas = notas;
    }
    
    public String getFileName() {
        // Devuelve el nombre de archivo para ese contacto
        String path = this.propietario+"/contactos/"+this.modulo+"/";
        String file = this.nombreCorto;
        
        return path + file;
    }
    
    public String getImageLink() {
        if ( (fileLink == null) || ( fileLink.isEmpty() )) {
            return getDefaultImage();
        }
        return fileLink;
    }

    private String getDefaultImage() {
        if ( "Empresa".equals(genero) )
            return "genericos/contactos/empresa.png";
        else if ( "Hombre".equals(genero) )
            return "genericos/contactos/hombre.png";
        else if ( "Mujer".equals(genero) )
            return "genericos/contactos/mujer.png";
        else
            return "genericos/contactos/neutro.png";
    }
    
    // Getters y Setters
    public String getNombreCorto() {
        return nombreCorto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDocTipo() {
        return docTipo;
    }

    public void setDocTipo(String docTipo) {
        this.docTipo = docTipo;
    }

    public String getDocNro() {
        return docNro;
    }

    public void setDocNro(String docNro) {
        this.docNro = docNro;
    }

    public String getCondIva() {
        return condIva;
    }

    public void setCondIva(String condIva) {
        this.condIva = condIva;
    }

    @Override
    public boolean equals(Object object) { // OJO creo que se puede eliminar y usar el de abstract, hay que ver omo funciona el instanceof
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacto)) {
            return false;
        }
        Contacto other = (Contacto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public Contacto clone(){
        Contacto newItem = new Contacto(
            id, propietario, modulo, categoria, etiqueta, cod, nombre, notas, 
            nombreCorto, domicilio, localidad, telefono, correo, docTipo, docNro, condIva);
        return newItem;
    }   
    
}
