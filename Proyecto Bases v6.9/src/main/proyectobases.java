package main;
import RespaldosBD.InicioSesion;

public class proyectobases 
{    
    public static void main(String[] args) 
    {
        InicioSesion re=new InicioSesion(); //Abre la ventana de la clase Respaldos
        re.cargarUsuarios();
        re.setVisible(true);
        
    }
}