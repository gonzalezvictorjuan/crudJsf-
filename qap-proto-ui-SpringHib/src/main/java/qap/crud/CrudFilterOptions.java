package qap.crud;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author christian
 */
public class CrudFilterOptions implements Serializable {
    
    //private String propietario;
    private String modulo;
    private String categoria;
    private String etiqueta;    
    private String vista;

    private List modulos;
    private List categorias;
    private List etiquetas;    
    private List vistas;
    
    private boolean filtroEtiqueta = true;   
   
    // Getters & Setters
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

    public String getVista() {
        return vista;
    }

    public void setVista(String vista) {
        this.vista = vista;
    }

    public List getModulos() {
        return modulos;
    }

    public void setModulos(List modulos) {
        this.modulos = modulos;

        // asigna el primer modulo como default
        if ( !modulos.isEmpty() ) {
            modulo = (String) modulos.get(0);
        }
    }

    public List getCategorias() {
        return categorias;
    }

    public void setCategorias(List categorias) {
        this.categorias = categorias;
        // asigna la primer categoria como default
        if ( !categorias.isEmpty() ) {
            categoria = (String) categorias.get(0);
        }
    }

    public List getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List etiquetas) {
        this.etiquetas = etiquetas;
        // asigna la primer etiqueta como default
        if ( !etiquetas.isEmpty() ) {
            etiqueta = (String) etiquetas.get(0);
        }
    }

    public List getVistas() {
        return vistas;
    }

    public void setVistas(List vistas) {
        this.vistas = vistas;
        // asigna la primer vista como default
        if ( !vistas.isEmpty() ) {
            vista = (String) vistas.get(0);
        }
    }

    public boolean isFiltroEtiqueta() {
        return filtroEtiqueta;
    }

    public void setFiltroEtiqueta(boolean filtroEtiqueta) {
        this.filtroEtiqueta = filtroEtiqueta;
    }
    
}
