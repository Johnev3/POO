public class Paciente extends Persona{
    private int numeroHistorial;
    private String eps;
    private double saldoDisponible;
    private String sintoma;

    public Paciente(String nombre, String dni, int edad, String genero, int numeroHistorial, String eps, double saldoDisponible, String sintoma) {
        super(nombre, dni, edad, genero);
        this.numeroHistorial = numeroHistorial;
        this.eps = eps;
        this.saldoDisponible = saldoDisponible;
        this.sintoma = sintoma;
    }

    public String mostrarSintoma(){
        return sintoma;
    }

    public void verificarPresupuesto(double costoConsulta){
        String estado = (costoConsulta<saldoDisponible) ? "Éxito" : "Rechazado (fondos insuficientes";
        System.out.println("El paciente "+nombre+" intenta pagar $"+costoConsulta+". Saldo actual: $"+saldoDisponible+" -> Resultado: "+estado);
    }

    public String getEps() {
        return eps;
    }

    @Override
    void presentacion() {
        System.out.println("[Paciente] "+nombre+" - EPS: "+eps+" - Sintoma: "+sintoma);
    }
}
