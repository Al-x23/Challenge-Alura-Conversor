import java.util.Scanner;

public class PrincipalMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lista = """
                **********************************
                Sea bievenido(a) al conversor de monedas!!!
                ¿Qué conversión desea realizar?
                1)Dolar => Peso Argentino
                2)Peso Argentíno => Dolar
                3)Dólar => Real Brasileño
                4)Real Brasileño => Dólar
                5)Dolar => Peso Colombiano
                6)Peso Colombiano => Dolar
                7)Salir
                Elija una opción válida:
                **********************************""";
        while (true) {
            System.out.println(lista);
            int opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 6) {
                System.out.println("Ingrese el valor que desea convertir:");
                double valor = scanner.nextDouble();

                Moneda origen = null;
                String destinoCodigo = "";

                switch (opcion) {
                    case 1 -> {
                        origen = new Moneda("USD", valor);
                        destinoCodigo = "ARS";

                    }
                    case 2 -> {
                        origen = new Moneda("ARS", valor);
                        destinoCodigo = "USD";
                    }
                    case 3 -> {
                        origen = new Moneda("USD", valor);
                        destinoCodigo = "BRL";
                    }
                    case 4 -> {
                        origen = new Moneda("BRL", valor);
                        destinoCodigo = "USD";
                    }
                    case 5 -> {
                        origen = new Moneda("USD", valor);
                        destinoCodigo = "COP";
                    }
                    case 6 -> {
                        origen = new Moneda("COP", valor);
                        destinoCodigo = "USD";
                    }

                    default -> System.out.println("Opción inválida, intente de nuevo");
                }
                if (origen != null) {
                    ConversorDeMonedas.convertir(origen, destinoCodigo);
                }
            } else if (opcion == 7) {
                System.out.println("Gracias por usar el conversor de monedas! Que tenga buen día :D");
                break;
            } else {
                System.out.println("Error, elija una opción válida.");
            }
        }
        scanner.close();
    }
}