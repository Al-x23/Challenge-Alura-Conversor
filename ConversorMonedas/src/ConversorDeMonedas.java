public class ConversorDeMonedas {

    public static double convertir(Moneda origen, String destinoCodigo) {
        double tipoCambio = ConversorAPI.obtenerTipoCambio(destinoCodigo);

        if (tipoCambio == 0.0) {
            System.out.println("No se pudo obtener el tipo de cambio.");
            return 0.0;
        }

        double resultado = origen.getValor() * tipoCambio;
        System.out.println(origen + " equivale a " + resultado + " " + destinoCodigo);
        return resultado;
    }
}
