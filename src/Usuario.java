public class Usuario {
    private String nombre;
    private int edad;
    private double salario;

    public Usuario( String nombre, int edad, double salario){
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String toFileString(){
        return nombre + ", " + edad + ", " + salario;
    }

    public static Usuario fromString(String linea){
        String[] partes = linea.split(", ");
        return new Usuario(
                partes[0],
                Integer.parseInt(partes[1]),
                Double.parseDouble(partes[2])
        );
    }

    @Override
    public String toString(){
        return "Nombre: " + nombre + ", Edad: " + edad + ", Salario: " + salario;
    }

}
