public class Atencion {
    public void procesarIngreso(Paciente paciente) {
        String pabellon;
        String eps = paciente.getEps();

        switch (eps){
            case "Sura":
                pabellon = "Pabellon A";
                break;
            case "Nueva EPS":
                pabellon = "Pabellon B";
                break;
            case "Compensar":
                pabellon = "Pabellon C";
                break;
            default:
                pabellon = "Pabellon D";
                break;
        }
        System.out.println("Paciente asignado a "+pabellon);
    }
}
