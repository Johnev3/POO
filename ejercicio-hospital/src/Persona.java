public abstract class Persona {
    /**
     * nombre persona
     */
    protected String nombre;
    /**
     * documento persona
     */
    protected String dni;
    /**
     * edad persona
     */
    protected int edad;
    /**
     * genero persona
     */
    protected String genero;

    /**
     *
     * @param nombre nombre persona
     * @param dni documento persona
     * @param edad edad persona
     * @param genero genero persona
     */
    public Persona(String nombre, String dni, int edad, String genero) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.genero = genero;
    }

    /**
     * Metodo abstracto presentacion
     */
    abstract String presentacion();
}
