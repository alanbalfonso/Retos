package reto7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

public class cafetera {
    private BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    private int capacidadMaximaAgua;
    private int capacidadMaximaCafe;
    private int capacidadMaximaAzucar;
    
    private int cantidadActualAgua;
    private int cantidadActualCafe;
    private int cantidadActualAzucar;

    private int conteoVasosCafe;
    private ArrayList<vasoCafe> detalleVasosVendidos = new ArrayList<vasoCafe>();
    private ArrayList<vasoCafe> compraActual = new ArrayList<vasoCafe>();

    private vasoCafe[] tiposVasosCafetera;
    
    public cafetera(int capacidadMaximaAgua, int capacidadMaximaCafe, int capacidadMaximaAzucar) {
        this.capacidadMaximaAgua = capacidadMaximaAgua;
        this.capacidadMaximaCafe = capacidadMaximaCafe;
        this.capacidadMaximaAzucar = capacidadMaximaAzucar;

        cantidadActualAgua = capacidadMaximaAgua;
        cantidadActualCafe = capacidadMaximaCafe;
        cantidadActualAzucar = capacidadMaximaAzucar;

        conteoVasosCafe = 0;

        tiposVasosCafetera = new vasoCafe[6];
        tiposVasosCafetera[0] = new vasoCafe(120, 30, 1, "Vaso de cafe pequeño sin azucar", false, 0, 10.50);
        tiposVasosCafetera[1] = new vasoCafe(120, 30, 2, "Vaso de cafe pequeño con azucar", true, 5, 14.50);
        tiposVasosCafetera[2] = new vasoCafe(220, 50, 3, "Vaso de cafe mediano con azucar", true, 10, 24.50);
        tiposVasosCafetera[3] = new vasoCafe(220, 50, 4, "Vaso de cafe mediano sin azucar", false, 0, 34.50);
        tiposVasosCafetera[4] = new vasoCafe(320, 80, 5, "Vaso de cafe grande con azucar", true, 15, 34.50);
        tiposVasosCafetera[5] = new vasoCafe(320, 80, 6, "Vaso de cafe grande sin azucar", false, 0, 39.50);
    }
    //solo se utiliza dentro de comprar()
    public void servirTaza(vasoCafe vasoAServir){
        cantidadActualAgua -= vasoAServir.getCapacidadAgua();
        cantidadActualCafe -= vasoAServir.getCapacidadCafe();
        //restar el azucar solo si contiene azucar la taza
        if(vasoAServir.getContieneAzucar()){
            cantidadActualAzucar -= vasoAServir.getCapacidadAzucar();
        }
        compraActual.add(vasoAServir);
        detalleVasosVendidos.add(vasoAServir);
        conteoVasosCafe++;
    }
    public void agregarCafe() throws IOException {
        System.out.println("Indique la cantidad de café a agregar: ");
        int cantidadAgregarCafe = Integer.parseInt(entrada.readLine());
        int sumaCafe = cantidadActualCafe + cantidadAgregarCafe;
        
        if (sumaCafe > capacidadMaximaCafe) {
            System.out.println("No se puede agregar más café, la cafetera se desbordaría.");
            System.out.println("Solo se puede agregar: " + (capacidadMaximaCafe - cantidadActualCafe) + " gramos.");
        } else {
            cantidadActualCafe += cantidadAgregarCafe;
            System.out.println("Se agregaron " + cantidadAgregarCafe + " gramos de café.");
            System.out.println("Cantidad actual de café: " + cantidadActualCafe + " gramos.");
        }
    }
    
    //limpieza de maquina
    public void vaciarInsumos(){
        cantidadActualAgua = 0;
        cantidadActualCafe = 0;
        cantidadActualAzucar = 0;
        System.out.println("Insumos vaciados");
    }

    public void mostrarInsumos(){
        System.out.println("Cantidad de agua disponible: " + cantidadActualAgua + "ml (3 litros maximo).");
        System.out.println("Cantidad de cafe disponible: " + cantidadActualCafe + "grs (2 kilos maximo).");
        System.out.println("Cantidad de azucar disponible: " + cantidadActualAzucar + "grs (2 kilos maximo).");
    }

    //compra de cafe
    public void comprar() throws IOException {
        compraActual.clear();
        System.out.println("---MENU DE COMPRA DE CAFETECMI---");
        System.out.println("Bienvenido al sistema de compra de la cafetera");
        System.out.println("Indica la cantidad de vasos que vas a comprar: ");
        int cantidadTazas = Integer.parseInt(entrada.readLine());
        
        for (int i = 0; i < cantidadTazas; i++) {
            System.out.println("\nElige el tipo de vaso de café a comprar (1-6): ");
            System.out.println(tiposVasosCafetera[0].getTipoVaso() +".- " + tiposVasosCafetera[0].getNombreTipoVaso() + " - Precio: $"+ tiposVasosCafetera[0].getPrecioVaso());
            System.out.println(tiposVasosCafetera[1].getTipoVaso() +".- " + tiposVasosCafetera[1].getNombreTipoVaso() + " - Precio: $" + tiposVasosCafetera[1].getPrecioVaso());
            System.out.println(tiposVasosCafetera[2].getTipoVaso() +".- " + tiposVasosCafetera[2].getNombreTipoVaso() + " - Precio: $"+ tiposVasosCafetera[2].getPrecioVaso());
            System.out.println(tiposVasosCafetera[3].getTipoVaso() +".- " + tiposVasosCafetera[3].getNombreTipoVaso() + " - Precio: $" + tiposVasosCafetera[3].getPrecioVaso());
            System.out.println(tiposVasosCafetera[4].getTipoVaso() +".- " + tiposVasosCafetera[4].getNombreTipoVaso() + " - Precio: $"+ tiposVasosCafetera[4].getPrecioVaso());
            System.out.println(tiposVasosCafetera[5].getTipoVaso() +".- " + tiposVasosCafetera[5].getNombreTipoVaso() + " - Precio: $" + tiposVasosCafetera[5].getPrecioVaso());
            int opcion = Integer.parseInt(entrada.readLine());
            
            if (opcion >= 1 && opcion <= 6) {
                vasoCafe vaso = tiposVasosCafetera[opcion - 1];
                //si hay suficiente de cada insumo hacer la operación, si no, no hacerla
                if (cantidadActualAgua >= vaso.getCapacidadAgua() && cantidadActualCafe >= vaso.getCapacidadCafe() && cantidadActualAzucar >= vaso.getCapacidadAzucar()) {
                    servirTaza(vaso);
                    System.out.println("Taza de café servida: " + vaso.getNombreTipoVaso() + "\n");
                } else {
                    System.out.println("Lo siento, no hay suficientes ingredientes para servir esta taza de café.");
                }
            } else {
                System.out.println("Opción inválida, por favor elige una opción válida (1-6).");
            }
        }
    }

    //realizar el calculo del cambio que se hara al usuario una vez comprado
    public void cambioPago() throws IOException {
        // Mostrar la cuenta detallada de los vasos de café vendidos
        System.out.println("\n---CUENTA SENCILLA DE SU PEDIDO---");
        for (int i = 0; i < compraActual.size(); i++) {
            vasoCafe vaso = compraActual.get(i);
            System.out.println("Taza " + (i + 1) + ": " + vaso.getNombreTipoVaso() + " - Precio: $" + vaso.getPrecioVaso());
        }
        
        // Calcular el total a pagar
        double totalPagar = 0;
        for (vasoCafe vaso : compraActual) {
            totalPagar += vaso.getPrecioVaso();
        }
        System.out.println("Total a pagar: $" + totalPagar);
        
        // Solicitar al usuario que ingrese la cantidad de dinero pagada
        System.out.println("CON CUANTO DINERO VA A PAGAR?");
        double montoPagado = Double.parseDouble(entrada.readLine());

        // Convertir a centavos para evitar errores
        int totalPagarCentavos = (int) (totalPagar * 100);
        int montoPagadoCentavos = (int) (montoPagado * 100);
        
        // Verificar si el monto pagado es suficiente
        if (montoPagadoCentavos >= totalPagarCentavos) {
            // Calcular el cambio
            int cambioCentavos = montoPagadoCentavos - totalPagarCentavos;
            //conversor de centavos a pesos
            System.out.println("Cambio a devolver: $" + cambioCentavos / 100.0);

            // Calcular cantidad de monedas de cada denominación
            int[] denominaciones = {1000, 500, 200, 100, 50}; // centavos
            int[] cantidadMonedas = new int[5];
            
            for (int i = 0; i < denominaciones.length; i++) {
                if (cambioCentavos >= denominaciones[i]) {
                    cantidadMonedas[i] = cambioCentavos / denominaciones[i];
                    cambioCentavos -= cantidadMonedas[i] * denominaciones[i];
                }
            }
            
            // Mostrar el desglose de monedas
            String[] nombresDenominaciones = {"$10", "$5", "$2", "$1", "50c"};
            for (int i = 0; i < denominaciones.length; i++) {
                System.out.println("Cantidad de monedas de " + nombresDenominaciones[i] + ": " + cantidadMonedas[i]);
            }
            System.out.println("GRACIAS POR COMPRAR EN CAFETECMI \n");
        } else {
            System.out.println("Lo siento, el monto pagado es insuficiente. Se necesita pagar $" + totalPagar);
        }
    }    
    
    public boolean verificarPagoSuficiente(double montoPagado, double totalPagar) {
        return montoPagado >= totalPagar;
    }

    //sumar el total de dinero recogido de las ventas para el reporte final
    public double calcularTotalVenta() {
        double totalVenta = 0;
        for (vasoCafe vaso : detalleVasosVendidos) {
            totalVenta += vaso.getPrecioVaso();
        }
        return totalVenta;
    }
    
    /*
     * Getters y setters
     */
    public int getCapacidadMaximaAgua() {
        return capacidadMaximaAgua;
    }

    public void setCapacidadMaximaAgua(int capacidadMaximaAgua) {
        this.capacidadMaximaAgua = capacidadMaximaAgua;
    }

    public int getCapacidadMaximaCafe() {
        return capacidadMaximaCafe;
    }

    public void setCapacidadMaximaCafe(int capacidadMaximaCafe) {
        this.capacidadMaximaCafe = capacidadMaximaCafe;
    }

    public int getCapacidadMaximaAzucar() {
        return capacidadMaximaAzucar;
    }

    public void setCapacidadMaximaAzucar(int capacidadMaximaAzucar) {
        this.capacidadMaximaAzucar = capacidadMaximaAzucar;
    }

    public int getCantidadActualAgua() {
        return cantidadActualAgua;
    }

    public void setCantidadActualAgua(int cantidadActualAgua) {
        this.cantidadActualAgua = cantidadActualAgua;
    }

    public int getCantidadActualCafe() {
        return cantidadActualCafe;
    }

    public void setCantidadActualCafe(int cantidadActualCafe) {
        this.cantidadActualCafe = cantidadActualCafe;
    }

    public int getCantidadActualAzucar() {
        return cantidadActualAzucar;
    }

    public void setCantidadActualAzucar(int cantidadActualAzucar) {
        this.cantidadActualAzucar = cantidadActualAzucar;
    }

    public int getConteoVasosCafe() {
        return conteoVasosCafe;
    }

    public void setConteoVasosCafe(int conteoVasosCafe) {
        this.conteoVasosCafe = conteoVasosCafe;
    }

    public ArrayList<vasoCafe> getDetalleVasosVendidos() {
        return detalleVasosVendidos;
    }

    public void setDetalleVasosVendidos(ArrayList<vasoCafe> detalleVasosVendidos) {
        this.detalleVasosVendidos = detalleVasosVendidos;
    }
    
}
