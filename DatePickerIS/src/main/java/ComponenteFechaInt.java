import java.time.LocalDate;

public interface ComponenteFechaInt {
    LocalDate getFecha() throws FechaException;
    void setFecha(int anyo,int mes,int dia);
}