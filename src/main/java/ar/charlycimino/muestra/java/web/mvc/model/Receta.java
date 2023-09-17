package ar.charlycimino.muestra.java.web.mvc.model;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */

public final class Receta {

    private int id;
    private String nombre;
    private String foto;
    private String instrucciones;
    private static final String FOTO_DEFAULT = "placeholder.png";
    
    public Receta() {
        this(0, "", FOTO_DEFAULT, "");
    }

    public Receta(int id, String nombre, String foto, String instrucciones) {
        setId(id);
        setNombre(nombre);
        setFoto(foto);
        setInstrucciones(instrucciones);
    }    
   
    public Receta(String nombre, String foto, String instrucciones) {
        this(0, nombre, foto, instrucciones);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        UtilExceptions.checkNumeroNegativo(0, "El id de una receta no puede ser negativo");
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        UtilExceptions.checkObjetoNulo(nombre, "El nombre de una receta no puede ser nulo");
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        if (foto != null && !foto.isBlank()) {
            this.foto = foto;
        } else if (!tieneFoto()) {
            this.foto = FOTO_DEFAULT;
        }        
    }
    
    public boolean tieneFoto() {
        return !this.foto.equals(FOTO_DEFAULT);
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        UtilExceptions.checkObjetoNulo(nombre, "Las instrucciones de una receta no pueden ser nulas");
        this.instrucciones = instrucciones;
    }
    
    @Override
    public String toString() {
        return "Receta{" + "id=" + id + ", nombre=" + nombre + ", foto=" + foto + ", instrucciones=" + instrucciones + '}';
    }

    
}
