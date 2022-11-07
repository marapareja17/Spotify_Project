import controller.Controller;
import model.DbManager;

import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\tSPOTIFY MANAGER\n");
        Controller controlador = new Controller();

        while (true){
            System.out.println("\nArtistas disponibles: ");
            System.out.println(controlador.ShowArtists());
            System.out.println("\n1: Añadir artista\n2: Almacenar artista\n3: Cerrar");
            Scanner scan = new Scanner(System.in);
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
                    try {controlador.StoreArtists(name2);} catch (Exception e) {}
                    System.out.println("\nEl artista se ha almacenado correctamente :)");

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
