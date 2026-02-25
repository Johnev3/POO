/**
 * Clase Atencion
 */
public class Atencion {
    /**
     *
     * @param paciente objeto de tipo paciente
     */
    public void procesarIngreso(Paciente paciente) {
        /**
         * variable tipo cadena que almacena el pabellon
         */
        String pabellon;
        /**
         * variable cadena que almacena la eps del paciente
         */
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
