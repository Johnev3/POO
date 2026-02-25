import java.util.ArrayList;
import java.util.List;

public class gestionHospital {
    public static void main(String[] args) {
        Medico cardiologo = new Medico("Julian alcazares","10547474",36,"Masculino","Cardiologo","3434214");
        Medico pediatra = new Medico("Daniela roman","1035366",29,"Femenino","pediatra","564536");
        Medico oncologo = new Medico("Juan pablo gomez","10934646",43,"Masculino","oncologo","784564");
        Medico neurocirugano = new Medico("Daniel lopez","10643322",39,"Masculino","neurocirugano","835353");

        MedicoCirugano neurocirujano1 = new MedicoCirugano("Daniel Lopez", "10643322", 39, "Masculino", "Neurocirugano", "835353", 1);
        MedicoCirugano neurocirujano2 = new MedicoCirugano("Maria Garcia", "20456789", 45, "Femenino", "Neurocirugano", "924464", 2);
        MedicoCirugano neurocirujano3 = new MedicoCirugano("Carlos Ruiz", "30567891", 52, "Masculino", "Neurocirugano", "746242", 3);
        MedicoCirugano neurocirujano4 = new MedicoCirugano("Ana Martinez", "40678912", 37, "Femenino", "Neurocirugano", "658131", 4);

        System.out.println("Presentacion de medicos\n");

        cardiologo.presentacion();
        pediatra.presentacion();
        oncologo.presentacion();
        neurocirugano.presentacion();

        Paciente p1 = new Paciente("Juan Gómez", "1001", 35, "M", 101, "Sanitas", 200.0, "Infarto");
        Paciente p2 = new Paciente("Lucía Lara", "1002", 28, "F", 102, "Sura", 30.0, "Fiebre");
        Paciente p3 = new Paciente("Carlos Ruiz", "1003", 45, "M", 103, "Compensar", 150.0, "Dolor");
        Paciente p4 = new Paciente("María Torres", "1004", 52, "F", 104, "Nueva EPS", 80.0, "Infarto");
        Paciente p5 = new Paciente("Pedro Molina", "1005", 19, "M", 105, "Sanitas", 10.0, "Fiebre");
        Paciente p6 = new Paciente("Sofía Castro", "1006", 67, "F", 106, "Sura", 300.0, "Dolor");
        Paciente p7 = new Paciente("Andrés Vega", "1007", 41, "M", 107, "Compensar", 55.0, "Infarto");
        Paciente p8 = new Paciente("Valentina Ríos", "1008", 33, "F", 108, "Nueva EPS", 120.0, "Fiebre");
        Paciente p9 = new Paciente("Felipe Mora", "1009", 58, "M", 109, "Sanitas", 0.0, "Dolor");
        Paciente p10 = new Paciente("Daniela Cruz", "1010", 24, "F", 110, "Sura", 500.0, "Infarto");
        Paciente p11 = new Paciente("Ricardo León", "1011", 71, "M", 111, "Compensar", 45.0, "Fiebre");
        Paciente p12 = new Paciente("Camila Vargas", "1012", 30, "F", 112, "Nueva EPS", 90.0, "Dolor");

        List<Paciente> pacientes = new ArrayList<>();
        pacientes.add(p1);
        pacientes.add(p2);
        pacientes.add(p3);
        pacientes.add(p4);
        pacientes.add(p5);
        pacientes.add(p6);
        pacientes.add(p7);
        pacientes.add(p8);
        pacientes.add(p9);
        pacientes.add(p10);
        pacientes.add(p11);
        pacientes.add(p12);

        System.out.println("\nPresentacion de pacientes\n");


        for(Paciente paciente:pacientes){
            paciente.presentacion();
        }

        /**
         * Asignar pacientes
         */

        cardiologo.asignarPaciente(p1);
        cardiologo.asignarPaciente(p2);
        cardiologo.asignarPaciente(p3);
        pediatra.asignarPaciente(p4);
        pediatra.asignarPaciente(p5);
        pediatra.asignarPaciente(p6);
        oncologo.asignarPaciente(p7);
        oncologo.asignarPaciente(p8);
        oncologo.asignarPaciente(p9);
        neurocirugano.asignarPaciente(p10);
        neurocirugano.asignarPaciente(p11);
        neurocirugano.asignarPaciente(p12);

        /**
         * mostrar lista pecientes asignados
         */
        cardiologo.revisarPacientes();
        pediatra.revisarPacientes();
        oncologo.revisarPacientes();
        neurocirugano.revisarPacientes();

        /**
         * Evaluacion sintomas
         */
        cardiologo.asignarPrioridad();
        pediatra.asignarPrioridad();
        oncologo.asignarPrioridad();
        neurocirugano.asignarPrioridad();

        p1.verificarPresupuesto(50);
        p2.verificarPresupuesto(50);
        p3.verificarPresupuesto(100);
        p4.verificarPresupuesto(200);

        neurocirujano1.validarQuirofano(true);

        Atencion gestion = new Atencion();
        gestion.procesarIngreso(p1);
        gestion.procesarIngreso(p2);
    }
}
