/**
 * Clase MedicoCirugano
 */
public class MedicoCirugano extends Medico implements ICirugano{
    /**
     * numero de quirofano asignado
     */
    int numeroQuirofano;

    /**
     *
     * @param nombre nombre del cirgunano
     * @param dni documento del cirgunano
     * @param edad edad del cirugano
     * @param genero genero del cirugano
     * @param especialidad especilidad del cirugano
     * @param numeroRegistro numero de registro del cirugano
     * @param numeroQuirofano numero de quirofano asignado
     */
    public MedicoCirugano(String nombre, String dni, int edad, String genero, String especialidad, String numeroRegistro,int numeroQuirofano) {
        /**
         * atributos heredados de la clase medico
         */
        super(nombre, dni, edad, genero, especialidad, numeroRegistro);
        this.numeroQuirofano = numeroQuirofano;
    }

    /**
     * Metodo de interfaz validar quirofano
     * @param estado estado del quirofano
     */
    @Override
    public String validarQuirofano(boolean estado) {
        if(estado){
            return "El cirujano "+nombre+" esta operando en en quirofano "+numeroQuirofano;
        }else{
            return "El quirofano "+numeroQuirofano+" no esta listo";
        }
    }
}
