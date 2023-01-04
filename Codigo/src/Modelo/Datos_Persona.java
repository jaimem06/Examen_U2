package Modelo;

/**
 * @author Jaime Mendoza
 */
public class Datos_Persona {

    private String Nombre;
    private String Cedula;
    private String NombreImp;
    private String EstadoImp;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombreImp() {
        return NombreImp;
    }

    public void setNombreImp(String NombreImp) {
        this.NombreImp = NombreImp;
    }

    public String getEstadoImp() {
        return EstadoImp;
    }

    public void setEstadoImp(String EstadoImp) {
        this.EstadoImp = EstadoImp;
    }

    public Datos_Persona(String nombre, String cedula, String nombreimp, String estadoimp) {
        this.Nombre = nombre;
        this.Cedula = cedula;
        this.NombreImp = nombreimp;
        this.EstadoImp = estadoimp;
    }

    public Datos_Persona() {
    }

    @Override
    public String toString() {
        return "Datos_Persona{" + "nombre=" + Nombre + ", cedula=" + Cedula + ", nombreimp=" + NombreImp + ", estadoimp=" + EstadoImp + '}';
    }

}
