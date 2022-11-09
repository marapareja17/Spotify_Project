import controller.Controller;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    private static String clientId;
    private static String clientSecret;
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nBienvenido al programa, primero que nada voy " +
                "a necesitar sus credenciales para poder iniciar el proceso");
        System.out.println("\nIntoduzca su Client Id: ");
        clientId = scan.next();
        System.out.println("\nIntroduzca su Client Secret: ");
        clientSecret = scan.next();
        System.out.println("\nAhora si, empecemos...");
        System.out.println("\n\t--------- SPOTIFY MANAGER ---------\n");
        Controller controlador = new Controller(clientId, clientSecret);
        /*controlador.storeArtists("Melendi");
        controlador.close();*/

        while (true){
            System.out.println("\nArtistas disponibles: ");
            System.out.println(controlador.ShowArtists());
            System.out.println("\n1: Añadir artista\n2: Almacenar artista\n3: Cerrar");
            scan = new Scanner(System.in);
            int input = scan.nextInt();

            switch (input){
                case 1:
                    System.out.print("Inserte el nombre del artista: ");
                    String name = scan.next();
                    System.out.print("Inserte la id del artista: ");
                    String id = scan.next();
                    controlador.addArtists(name,id);
                    break;
                case 2:
                    System.out.print("Inserte el nombre del artista: ");
                    String name2 = scan.next();
                    try {controlador.storeArtists(name2);} catch (Exception e) {}
                    System.out.println("\nEl artista se ha almacenado correctamente :)");
                    controlador.close();
                    break;
                case 3:
                    exit(0);
                default:
                    System.out.println("Opción no disponible :(");
                    break;
            }
        }
    }
}
