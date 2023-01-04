package Tabla;

import TDA_Lista.ListaEnlazadaServices;
import Modelo.Datos_Persona;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jaime Mendoza
 */
public class Datos_Tabla extends AbstractTableModel {

    ListaEnlazadaServices<Datos_Persona> listaDatos = new ListaEnlazadaServices<>();

    public ListaEnlazadaServices<Datos_Persona> getListaDatos() {
        return listaDatos;
    }

    public void setListaDatos(ListaEnlazadaServices<Datos_Persona> listaDatos) {
        this.listaDatos = listaDatos;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return listaDatos.getSize();
    }

    @Override
    public String getColumnName(int column) {
        switch (column)
        {
            case 0:
                return "Nombre";
            case 1:
                return "Cedula";
            case 2:
                return "Nombre Impuesto";
            case 3:
                return "Estado Impuesto";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        Datos_Persona Datos = listaDatos.obtenerDato(arg0);
        switch (arg1)
        {
            case 0:
                return Datos.getNombre();
            case 1:
                return Datos.getCedula();
            case 2:
                return Datos.getNombreImp();
            case 3:
                return Datos.getEstadoImp();
            default:
                return null;
        }
    }
}
