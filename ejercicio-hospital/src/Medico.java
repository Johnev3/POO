import java.util.ArrayList;
import java.util.List;

public class Medico extends Persona{
    private String especialidad;
    private String numeroRegistro;
    private List<Paciente> pacientesAsignados = new ArrayList<Paciente>();

    public Medico(String nombre, String dni, int edad, String genero, String especialidad, String numeroRegistro) {
        super(nombre, dni, edad, genero);
        this.especialidad = especialidad;
        this.numeroRegistro = numeroRegistro;
    }

    public void asignarPaciente(Paciente paciente){
        pacientesAsignados.add(paciente);
    }

    public void revisarPacientes(){
        System.out.println("\nDr. "+nombre+" revisando la lista de pacientes: ");
        for(Paciente paciente:pacientesAsignados){
            System.out.println("- Paciente: "+ paciente.nombre);
        }
    }

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

    @Override
    void presentacion() {
        System.out.println("[Medico] Dr. "+nombre+" - Especialidad: "+especialidad);
    }


}
