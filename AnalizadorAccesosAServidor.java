import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class AnalizadorAccesosAServidor
{
    private ArrayList<Acceso> accesos;

    public AnalizadorAccesosAServidor() 
    {
        accesos = new ArrayList<>();
    }

    public void analizarArchivoDeLog(String archivo)
    {
        accesos.clear();
        File archivoALeer = new File(archivo);
        try {
            Scanner sc = new Scanner(archivoALeer);
            while (sc.hasNextLine()) {
                String lineaLeida = sc.nextLine();               

                Acceso accesoActual = new Acceso(lineaLeida);               

                accesos.add(accesoActual);
            }
            sc.close();
        }
        catch (Exception e) {
            System.out.println("Ocurrio algun error al leer el archivo.");
        }
    }

    public int obtenerHoraMasAccesos() 
    {
        int valorADevolver = -1;

        if (!accesos.isEmpty()) {
            int[] accesosPorHora = new int[24];

            for (Acceso accesoActual : accesos) {
                int horaAccesoActual = accesoActual.getHora();
                accesosPorHora[horaAccesoActual] = accesosPorHora[horaAccesoActual] + 1;
            }

            int numeroDeAccesosMasAlto = accesosPorHora[0];
            int horaDeAccesosMasAlto = 0;
            for (int i = 0; i < accesosPorHora.length; i++) {
                if (accesosPorHora[i] >= numeroDeAccesosMasAlto) {
                    numeroDeAccesosMasAlto = accesosPorHora[i];
                    horaDeAccesosMasAlto = i;
                }
            }

            valorADevolver = horaDeAccesosMasAlto;                      
        }

        return valorADevolver;
    }

    public String paginaWebMasSolicitada() 
    {
        String pagMasVisitada=null;
        int numTotalVisitas=0;
        if (!accesos.isEmpty()) {
            //primer blucle lento:
            for(Acceso accesoActual: accesos){
                //segundo bucle rapìdo:
                int visitasActuales=0;
                String pagComparada=accesoActual.getWeb();
                for(Acceso accesoContado : accesos){
                    if(pagComparada.equals(accesoContado.getWeb())){
                        visitasActuales++;
                    }
                }
                if(visitasActuales>=numTotalVisitas){
                    numTotalVisitas=visitasActuales;
                    pagMasVisitada=pagComparada;
                }

            }
        }
        else{
            System.out.println("No hay datos leidos");
        }

        return pagMasVisitada;
    }

    public String clienteConMasAccesosExitosos()
    {
        String ipConMasVisitas=null;
        int numHttp=0;
        int numTotalVisitas=0;
        if (!accesos.isEmpty()) {
            //primer blucle lento:
            
            for(Acceso accesoActual: accesos){
                //segundo bucle rapìdo:
         
                int visitasActuales=0;
                String ipComparada=accesoActual.getWeb();
                for(Acceso accesoContado : accesos){
                    if(ipComparada.equals(accesoContado.getIp()) && 2==accesoActual.getHttp() && 2==accesoContado.getHttp()){
                        visitasActuales++;
                    }
                }
                if(visitasActuales>=numTotalVisitas){
                    numTotalVisitas=visitasActuales;
                    ipConMasVisitas=ipComparada;
                }

            }
        }
        else{
            System.out.println("No hay datos leidos");
        }
        
        return ipConMasVisitas;
    }

}
