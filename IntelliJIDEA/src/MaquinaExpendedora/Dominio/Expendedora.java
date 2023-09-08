package MaquinaExpendedora.Dominio;
import java.util.List;
import java.util.ArrayList;


public class Expendedora {
    private List<Snack> snacks;


    public Expendedora() {
        this.snacks = new ArrayList<>();
    }


    public void agregarUnSnack(Snack snack){
        Snack s = this.buscarSnackPorNombre(snack.getNombre());
        Snack ss = this.buscarSnackPorCodigo(snack.getCodigo());

        if (this.snacks.size()> 11 ){
            System.out.println("No se agregó " + snack.getNombre() + " la maquina ya tiene 12 productos");
        }
        else if (s != null){
            System.out.println("No se agregó " + snack.getNombre() + ", ya existe dentro de la maquina");
        }
        else if (snack.getCantidad()>=7){
            System.out.println("No se agregó " + snack.getNombre() + ", ya tiene 6 unidades en la maquina");
        }
        else if (ss != null) {
            System.out.println("No se agregó " + snack.getNombre() + ", este codigo ya existe");
        }
        else{
            this.snacks.add(snack);
            System.out.println("Se agregó " + snack.getNombre() + " correctamente");
        }
    }


    public boolean sacarUnaUnidadPorCodigo(int codigo){
        Snack s = this.buscarSnackPorCodigo(codigo);

        if (s==null){
            System.out.println("");
            System.out.println("El codigo no existe");
            return false;
        }
        else if (s.getCantidad()>0){
            int i = s.getCantidad();
            i-=1;
            s.setCantidad(i);
            System.out.println("");
            System.out.println("Se ha retirado correctamente");
            this.mostrarlistaSnacks(this.snacks);
            return true;
        }
        else {
            System.out.println("");
            System.out.println("");
            System.out.println("No se puede sacar una unidad de " + s.getNombre() + " su cantidad es 0.");
            this.mostrarlistaSnacks(this.snacks);
            return false;
        }
    }


    public boolean sacarUnaUnidadPorNombre(String nombre){
        Snack s = this.buscarSnackPorNombre(nombre);

        if (s==null){
            System.out.println("");
            System.out.println("El nombre no existe");
            return false;
        }

        if (s.getCantidad()>0){
            int i = s.getCantidad();
            i-=1;
            s.setCantidad(i);
            System.out.println("");
            System.out.println("Se ha retirado correctamente");
            this.mostrarlistaSnacks(this.snacks);
            return true;
        }
        System.out.println("");
        System.out.println("");
        System.out.println("No se puede sacar una unidad de " + s.getNombre() + " su cantidad es 0.");
        this.mostrarlistaSnacks(this.snacks);
        return false;
    }


    public void aumentarCantidadDeSnacksPorCodigo(int codigo){
        Snack s = this.buscarSnackPorCodigo(codigo);

        if (s==null){
            System.out.println("");
            System.out.println("El codigo no existe");
        }

        int i = s.getCantidad();
        i+=1;
        s.setCantidad(i);
        System.out.println("");
        System.out.println("Se ha aumentado correctamente");
        this.mostrarlistaSnacks(this.snacks);
    }


    public void aumentarCantidadDeSnacksPorNombre(String nombre){
        Snack s = this.buscarSnackPorNombre(nombre);

        if (s==null){
            System.out.println("");
            System.out.println("El Snack " + nombre + " no existe");
            this.mostrarlistaSnacks(this.snacks);
        }
        else {
            int i = s.getCantidad();
            i+=1;
            s.setCantidad(i);
            System.out.println("");
            System.out.println("Se ha aumendado correctamente");
            this.mostrarlistaSnacks(this.snacks);
        }

    }


    public boolean quitarUnSnack(int codigo){
        Snack s = this.buscarSnackPorCodigo(codigo);

        if (s != null) {
            this.snacks.remove(s);
            System.out.println("");
            System.out.println("Se ha eliminado el Snack");
            this.mostrarlistaSnacks(this.snacks);
            return true;
        }
        System.out.println("");
        System.out.println("Este codigo no existe, no es posible eliminar un Snack");
        this.mostrarlistaSnacks(this.snacks);
        return false;
    }


    public int obtenerCantidadDeSnack(int codigo){
        Snack s = this.buscarSnackPorCodigo(codigo);

        if (s!=null){
            System.out.println("");
            System.out.println("La cantidad de " + s.getNombre() + " es: " + s.getCantidad() + " unidades");
            return s.getCantidad();
        }
        System.out.println("");
        System.out.println("El producto no se encuentra en la maquina");
        return 0;
    }


    public List<Snack> SnacksAgotados(){
        List<Snack> snackNombre = new ArrayList<>();

        for (Snack snack : this.snacks) {
            if (snack.getCantidad()==0){
                snackNombre.add(snack);
            }
        }
        System.out.println("");
        System.out.println("");
        System.out.println("Estos son los productos agotados");
        mostrarlistaSnacks(snackNombre);
        return snackNombre;
    }


    public List<Snack> SnacksDisponibles(){
        List<Snack> snackNombre = new ArrayList<>();
        System.out.println("");
        System.out.println("");
        System.out.println("Estos son los productos disponibles");

        for (Snack snack : this.snacks) {
            if (snack.getCantidad()!=0){
                snackNombre.add(snack);
                System.out.println("   El nombre es: " + snack.getNombre() + " La cantidad es: " + snack.getCantidad());
            }
        }
        return snackNombre;
    }

    // Se utiliza el metodo burbuja para organizar la lista
    public List<Snack> ordenarValorMayorAMenor(List<Snack> lista) {
        int n = lista.size();
        boolean intercambio;

        do {
            intercambio = false;
            for (int i = 1; i < n; i++) {
                if (lista.get(i - 1).getPrecio() < lista.get(i).getPrecio()) {

                    Snack temp = lista.get(i - 1);
                    lista.set(i - 1, lista.get(i));
                    lista.set(i, temp);
                    intercambio = true;
                }
            }
        } while (intercambio);
        System.out.println("");
        System.out.println("");
        System.out.println("Lista ordenada de mayor a menor dependiendo su precio $");
        mostrarlistaSnacks(lista);
        return lista;
    }

    // Se utiliza el metodo burbuja para organizar la lista
    public List<Snack> ordenarCantidadMenorAMayor(List<Snack> lista){
        int n = lista.size();
        boolean intercambio;

        do {
            intercambio = false;
            for (int i = 1; i < n; i++) {
                if (lista.get(i - 1).getCantidad() > lista.get(i).getCantidad()) {

                    Snack temp = lista.get(i - 1);
                    lista.set(i - 1, lista.get(i));
                    lista.set(i, temp);
                    intercambio = true;
                }
            }
        } while (intercambio);
        System.out.println("");
        System.out.println("");
        System.out.println("Lista ordenada de menor a mayor dependiendo su cantidad");
        mostrarlistaSnacks(lista);
        return lista;
    }


    public Snack buscarSnackPorNombre(String nombreABuscar){

        for (Snack snack : this.snacks) {
            if (snack.getNombre().equalsIgnoreCase(nombreABuscar)) {
                return snack;
            }
        }
        return null;
    }


    public Snack buscarSnackPorCodigo(int codigoABuscar){

        for (Snack snack : this.snacks) {
            if (snack.getCodigo()==(codigoABuscar)) {
                return snack;
            }
        }
        return null;
    }


    public void mostrarlistaSnacks(List<Snack>list){

        System.out.println("");
        System.out.println("");

        for (Snack s : list) {
            System.out.println("   Nombre: " + s.getNombre() + "  Cantidad: " + s.getCantidad() + "  Codigo: " + s.getCodigo() + " Precio " + s.getPrecio());
        }
    }


    public List<Snack> getSnacks() {
        return snacks;
    }
}