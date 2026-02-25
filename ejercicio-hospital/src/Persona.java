public abstract class Persona {
    protected String nombre;
    protected String dni;
    protected int edad;
    protected String genero;

    public Persona(String nombre, String dni, int edad, String genero) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.genero = genero;
    }

    abstract void presentacion();
}
