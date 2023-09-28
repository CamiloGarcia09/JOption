package CalculadoraJOption.Dominio;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculadora {

    private static JCheckBox checkBox = new JCheckBox("¿Redondear?");
    private static JPanel panel = new JPanel(new BorderLayout());
    private static JLabel etiqueta = new JLabel("Selecciona una operación:");

    private static ImageIcon logo = new ImageIcon(Calculadora.class.getResource("Calculadora.png"));
    private static Object[] Operaciones = Arrays.asList("Sumar", "Restar", "Multiplicar", "Dividir").toArray();
    public static final int SUMAR=0;
    public static final int RESTAR=1;
    public static final int MULTIPLICAR=2;
    public static final int DIVIDIR=3;
    public static List<Integer> numeros = new ArrayList<>();



    public static int sumar (List<Integer> numeros){
        LLenadoDeLista();
        int resultado = 0;
        for (int contenidoLista : numeros){
            resultado += contenidoLista;
        }

        numeros.clear();
        return resultado;
    }


    public static int restar (List<Integer> numeros){
        LLenadoDeLista();
        int resultado = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            resultado -= numeros.get(i);
        }
        numeros.clear();
        return resultado;
    }


    public static int multiplicar (List<Integer> numeros){
        LLenadoDeLista();
        int resultado = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            resultado *= numeros.get(i);
        }
        numeros.clear();
        return resultado;
    }


    public static float dividir (List<Integer> numeros){
        LLenadoDeLista();
        float resultado = numeros.get(0);

        for (int i = 1; i < numeros.size(); i++) {
            resultado /= numeros.get(i);
        }
        if (checkBox.isSelected()){
            resultado = Math.round(resultado);

        }
        numeros.clear();
        return resultado;
    }


    public static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Calculadora",0,logo);
    }


    public static int mostrarMenu() {

        panel.add(etiqueta, BorderLayout.CENTER);
        panel.add(checkBox, BorderLayout.SOUTH);


        int opcion = JOptionPane.showOptionDialog(null,panel,"Calculadora",0,
            0,logo,Operaciones,0);

        if (opcion == JOptionPane.CLOSED_OPTION) {
            System.exit(opcion);
        }

        return opcion;
    }

    public static List<Integer> LLenadoDeLista() {
        int x = verificarNumero("Cuantos numeros quieres operar");
        for (int i = 0; i < x; i++) {
            numeros.add(verificarNumero("Ingresa un numero"));
        }
        return numeros;
    }




    public static void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Calculadora",0,logo);
    }


    public static int verificarNumero(String mensaje) {
        int numeroIngresado = 0;
        boolean validacion = false;

        do {
            try {
                numeroIngresado = Integer.parseInt((String) JOptionPane.showInputDialog(null,
                        mensaje,"Calculadora", 0, logo,null,null));

                validacion = true;

            } catch (NumberFormatException exception) {
                mostrarMensajeError("No es un numero. Intenta otra vez.");
            }
        } while (!validacion);

        return numeroIngresado;
    }

    public List<Integer> getNumeros() {
        return numeros;
    }
}
