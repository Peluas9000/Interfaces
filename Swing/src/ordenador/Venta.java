package ordenador;



import java.util.List;
public class Venta {
    private String nombreCliente;
    private String localidad;
    private String procesador;
    private String memoria;
    private String monitor;
    private String discoDuro;
    private java.util.List<String> opciones;

    public Venta(String nombreCliente, String localidad, String procesador, String memoria, String monitor, String discoDuro, java.util.List<String> opciones) {
        this.nombreCliente = nombreCliente;
        this.localidad = localidad;
        this.procesador = procesador;
        this.memoria = memoria;
        this.monitor = monitor;
        this.discoDuro = discoDuro;
        this.opciones = opciones;
    }

    public String getNombreCliente() { return nombreCliente; }
    public String getLocalidad() { return localidad; }
    public String getProcesador() { return procesador; }
    public String getMemoria() { return memoria; }
    public String getMonitor() { return monitor; }
    public String getDiscoDuro() { return discoDuro; }
    public java.util.List<String> getOpciones() { return opciones; }
}
