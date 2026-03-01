/**
 * Clase paciente
 */
public class Paciente extends Persona{
    /**
     * Numero historial paciente
     */
    private int numeroHistorial;
    /**
     * eps del paciente
     */
    private String eps;
    /**
     * saldo del paciente
     */
    private double saldoDisponible;
    /**
     * sintoma del paciente
     */
    private String sintoma;

    /**
     *
     * @param nombre nombre paciente
     * @param dni documento paciente
     * @param edad edad paciente
     * @param genero genero paciente
     * @param numeroHistorial numero de historial paciente
     * @param eps eps del paciente
     * @param saldoDisponible saldo paciente
     * @param sintoma sintoma paciente
     */
    public Paciente(String nombre, String dni, int edad, String genero, int numeroHistorial, String eps, double saldoDisponible, String sintoma) {
        /**
         * atributos heredados de la clase Persona
         */
        super(nombre, dni, edad, genero);
        this.numeroHistorial = numeroHistorial;
        this.eps = eps;
        this.saldoDisponible = saldoDisponible;
        this.sintoma = sintoma;
    }

    /**
     * Funcion que retorna el sintoma del paciente
     * @return sintoma
     */
    public String mostrarSintoma(){
        return sintoma;
    }

    /**
     * Metodo para verificar el presupuesto
     * @param costoConsulta costo de la consulta
     */
    public void verificarPresupuesto(double costoConsulta){
        String estado = (costoConsulta<saldoDisponible) ? "Éxito" : "Rechazado (fondos insuficientes";
        System.out.println("El paciente "+nombre+" intenta pagar $"+costoConsulta+". Saldo actual: $"+saldoDisponible+" -> Resultado: "+estado);
    }

    /**
     * getter atributo eps
     * @return eps
     */
    public String getEps() {
        return eps;
    }

    /**
     * Metodo abstracto presentacion
     */
    @Override
    String presentacion() {
        return "[Paciente] "+nombre+" - EPS: "+eps+" - Sintoma: "+sintoma;
    }
}
