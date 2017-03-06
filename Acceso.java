public class Acceso
{
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;
    
    public Acceso(String logEntrada)
    {
        
        
        String fechaYHora[] = logEntrada.split(" ");
       
        
        ano = Integer.parseInt(fechaYHora[0]);
        mes = Integer.parseInt(fechaYHora[1]);
        dia = Integer.parseInt(fechaYHora[2]);
        hora = Integer.parseInt(fechaYHora[3]);
        minutos = Integer.parseInt(fechaYHora[4]);
       
        
    }
    
    public int getAno() 
    {
        return ano;
    }
    
    public int getMes()
    {
        return mes;
    }
    
    public int getDia()
    {
        return dia;
    }
    
    public int getHora()
    {
        return hora;
    }
    
    public int getMinutos()
    {
        return minutos;
    }
}