public class Acceso
{
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;
    private String ip;
    private String web; 
    private int http;
    
       public Acceso(String logEntrada)
    {
        
        
        String fechaYHora[] = logEntrada.split(" ");
        ip =(fechaYHora[0]);
        
        ano = Integer.parseInt(fechaYHora[1].substring(1,5));
        mes = Integer.parseInt(fechaYHora[2]);
        dia = Integer.parseInt(fechaYHora[3]);
        hora = Integer.parseInt(fechaYHora[4]);
        minutos = Integer.parseInt(fechaYHora[5].substring(0,1));
        web =fechaYHora[6];
        http=Integer.parseInt(fechaYHora[7].substring(1,2)); 
        
    }
    
        public String getIp() 
    {
        return ip;
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
    
    public String getWeb(){
        return web;
    }
    
    public int getHttp(){
        return http;
    }
}