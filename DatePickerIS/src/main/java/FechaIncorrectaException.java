public class FechaIncorrectaException extends FechaException{
    public FechaIncorrectaException(String s) {
        super(s);
    }

    //Imposible -> dia q no existe
    //Incorrecta -> dia al que no le corresponda
}
