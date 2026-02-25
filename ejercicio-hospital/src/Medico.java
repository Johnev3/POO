import java.util.ArrayList;
import java.util.List;

/**
 * Clase Medico
 */
public class Medico extends Persona{
    /**
     * especialidad del medico
     */
    private String especialidad;
    /**
     * nuemero de registro del medico
     */
    private String numeroRegistro;
    /**
     * Lista de los pacientes asignados
     */
    private List<Paciente> pacientesAsignados = new ArrayList<Paciente>();

    /**
     *
     * @param nombre nombre medico
     * @param dni dni medico
     * @param edad edad medico
     * @param genero genero medico
     * @param especialidad especialidad medico
     * @param numeroRegistro numero de registro medico
     */
    public Medico(String nombre, String dni, int edad, String genero, String especialidad, String numeroRegistro) {
        /**
         * atributos heredados de la clase Persona
         */
        super(nombre, dni, edad, genero);
        this.especialidad = especialidad;
        this.numeroRegistro = numeroRegistro;
    }

    /**
     * Metodo asignar Pacientes
     * agrega el paciente a la lista del medico
     * @param paciente objeto de tipo Paciente
     */
    public void asignarPaciente(Paciente paciente){
        pacientesAsignados.add(paciente);
    }

    /**
     * Metodo revisar Pacientes
     * Muestra la lista de los pacientes a revisar
     */
    public void revisarPacientes(){
        System.out.println("\nDr. "+nombre+" revisando la lista de pacientes: ");
        for(Paciente paciente:pacientesAsignados){
            System.out.println("- Paciente: "+ paciente.nombre);
        }
    }

    /**
     * Metodo asignarPrioridad
     * Recorre la lista de pacientes y determina el nivel de prioridad
     */
    public void asignarPrioridad(){
        for(Paciente paciente:pacientesAsignados){
            String sintoma = paciente.mostrarSintoma();
            int prioridad = 0;
            switch (sintoma){
                case "Infarto":
                    prioridad = 1;
                    break;
                case "Dolor":
                    prioridad = 2;
                    break;
                case "Fiebre":
                    prioridad = 3;
                    break;
            }
            System.out.println("El Dr. "+nombre+" evaluo el sintoma ["+sintoma+"] y asigno Prioridad ["+prioridad+"]");
        }
    }

    /**
     * metodo abstracto presentacion
     */
    @Override
    void presentacion() {
        System.out.println("[Medico] Dr. "+nombre+" - Especialidad: "+especialidad);
    }


}
