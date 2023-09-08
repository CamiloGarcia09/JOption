package MaquinaExpendedora.Dominio;

public class Snack {
    private String nombre;
    private int codigo;
    private long precio;
    protected int cantidad;

    public Snack(String nombre, int codigo, long precio, int cantidad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.cantidad=cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public long getPrecio() {
        return precio;
    }

    public int getCantidad() {

        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}