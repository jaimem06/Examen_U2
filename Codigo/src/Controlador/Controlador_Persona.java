package Controlador;

import TDA_Lista.ListaEnlazadaServices;
import TDA_Lista.TipoOrdenacion;
import Modelo.Datos_Persona;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jaime Mendoza
 */
public class Controlador_Persona {

    Datos_Persona Personaprueba = new Datos_Persona();
    ListaEnlazadaServices<Datos_Persona> listaDatos = new ListaEnlazadaServices<>();
    Datos_Persona[] DatosArreglo = new Datos_Persona[20];

    public Datos_Persona[] getDatosArreglo() {
        return DatosArreglo;
    }

    public void setDatosArreglo(Datos_Persona[] DatosArreglo) {
        this.DatosArreglo = DatosArreglo;
    }

    public Datos_Persona getPersonaprueba() {
        return Personaprueba;
    }

    public void setPersonaprueba(Datos_Persona Personaprueba) {
        this.Personaprueba = Personaprueba;
    }

    public ListaEnlazadaServices<Datos_Persona> getListaDatos() {
        return listaDatos;
    }

    public void setListaDatos(ListaEnlazadaServices<Datos_Persona> listaDatos) {
        this.listaDatos = listaDatos;
    }

    public Controlador_Persona() {
    }

    public String[] nombre() {
        String[] nombreAleatorio = new String[20];

        String[] nombres =
        {
            "Mendoza Jaime", "Armijos Johnny", "Lopez Juan", "Cabrera Alejandro", "Oviedo Maluma", "Escobar Pablo", "Valdez Ramon",
            "Alvarado Cristian", "Remache Alexander", "Orosco Leonardo"
        };
        for (int i = 0; i < 20; i++)
        {
            nombreAleatorio[i] = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1)))];
        }
        return nombreAleatorio;
    }

    public String[] cedula() {
        String[] cedulaaleatorio = new String[20];

        String[] cedulas =
        {
            "1303753618",
            "1706172648",
            "0100967652",
            "1103037048",
            "1704997012",
            "1714818299",
            "1713627071",
            "0200982163",
            "0913537742",
            "0401197298",
            "0702648551",
            "1715241434",
            "0917385288",
            "1103756134",
            "0601646623",
            "1103201461",
            "0102051349",
            "1713580221",
            "0601899396",
            "1305267542"
        };
        for (int i = 0; i < 20; i++)
        {
            cedulaaleatorio[i] = cedulas[(int) (Math.floor(Math.random() * ((cedulas.length - 1) - 0 + 1)))];
        }
        return cedulaaleatorio;
    }

    public String[] nombreimp() {
        String[] impuestoaleatorio = new String[20];

        String[] impuestos =
        {
            "Impuesto a la Renta", "Impuestos a los Combustibles", "Impuesto Tierras Rurales", "Impuesto a los Vehículos", "Impuesto a la Salida de Divisas",
            "Regalías a la actividad minera", "Impuesto a las Ventas y Servicios IVA"
        };
        for (int i = 0; i < 20; i++)
        {
            impuestoaleatorio[i] = impuestos[(int) (Math.floor(Math.random() * ((impuestos.length - 1) - 0 + 1)))];
        }
        return impuestoaleatorio;
    }

    public String[] estadoimp() {
        String[] estadoaleatorio = new String[20];

        String[] estados =
        {
            "PAGADO", "PENDIENTE"
        };
        for (int i = 0; i < 20; i++)
        {
            estadoaleatorio[i] = estados[(int) (Math.floor(Math.random() * ((estados.length - 1) - 0 + 1)))];
        }
        return estadoaleatorio;
    }

    public ListaEnlazadaServices<Datos_Persona> guardarLista() {
        Datos_Persona cuenta;
        for (int i = 0; i < 20; i++)
        {
            cuenta = (new Datos_Persona(nombreimp()[i], cedula()[i], nombre()[i], estadoimp()[i]));
            listaDatos.insertarAlInicio(cuenta);
            setListaDatos(listaDatos);
        }
        return getListaDatos();
    }

    public void ordenarShell(String atributo, TipoOrdenacion ordenacion) {
        try
        {
            getListaDatos().getLista().ordenarShell(atributo, ordenacion);
        } catch (Exception ex)
        {
            Logger.getLogger(Controlador_Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ordenarQuickShort(String atributo, TipoOrdenacion ordenacion) {
        try
        {
            getListaDatos().getLista().ordenarQuickShort(atributo, ordenacion);
        } catch (Exception ex)
        {
            Logger.getLogger(Controlador_Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
