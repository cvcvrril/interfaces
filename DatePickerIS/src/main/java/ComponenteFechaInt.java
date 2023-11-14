import java.time.LocalDate;

public interface ComponenteFechaInt {
    LocalDate getFecha() throws FechaException;
    void setFecha(String anyo,String mes,int dia);
}