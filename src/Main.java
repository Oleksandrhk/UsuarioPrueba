import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    private static final String ARCHIVO = "usuarios.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Nombre: ");
            String nombre = sc.nextLine();

            System.out.println("Edad: ");
            int edad = sc.nextInt();

            System.out.println("Salario: ");
            double salario = sc.nextDouble();

            if (nombre.isEmpty() || edad < 0 || salario < 0) {
                System.out.println("Datos inválidos!!!");
                return;
            }

            Usuario usuario = new Usuario(nombre, edad, salario);

            guardarUsuario(usuario);

            System.out.println("\n Datos guardados: ");
            leerUsuarios();
        } catch (InputMismatchException e) {
            System.out.println("Error: debes introducir números válidos");
        } catch (IOException e) {
            System.out.println("Error al manejar el archivo: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    public static void guardarUsuario(Usuario usuario) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true));
        bw.write(usuario.toFileString());
        bw.newLine();
        bw.close();
    }

    public static void leerUsuarios() {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                Usuario u = Usuario.fromString(linea);
                System.out.println(u);
            }
        } catch (FileNotFoundException e) {
            System.out.println("archivo no encontrado");
        }catch (IOException e){
            System.out.println("Error al leer el archivo");
        }
    }
}
