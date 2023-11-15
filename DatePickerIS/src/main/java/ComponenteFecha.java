import java.time.LocalDate;

public interface ComponenteFecha {

    public LocalDate getDate() throws FechaException;
    public void setDate(int day, int month, int year) ;

}