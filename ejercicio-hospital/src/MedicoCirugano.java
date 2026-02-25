public class MedicoCirugano extends Medico implements ICirugano{
    int numeroQuirofano;
    public MedicoCirugano(String nombre, String dni, int edad, String genero, String especialidad, String numeroRegistro,int numeroQuirofano) {
        super(nombre, dni, edad, genero, especialidad, numeroRegistro);
        this.numeroQuirofano = numeroQuirofano;
    }

    @Override
    public void validarQuirofano(boolean estado) {
        if(estado){
            System.out.println("El cirujano "+nombre+" esta operando en en quirofano "+numeroQuirofano);
        }else{
            System.out.println("El quirofano "+numeroQuirofano+" no esta listo");
        }
    }
}
