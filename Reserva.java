package poo_final;
import java.util.Date;

public class Reserva {
    private Quarto q;
    private Date date;
    private int days; 
    private int numberOfDays;
    private int numberOfGuests;
    private Hospede h;
    private double total;
   

    public Reserva(Quarto q, int numberOfGuests, Hospede h, Date d, int days) {
        this.q = q;
        this.numberOfGuests = numberOfGuests;
        this.h = h;
        this.date = d;
        this.days = days;
        
    }
    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Hospede getH() {
        return h;
    }

    public void setH(Hospede h) {
        this.h = h;
    }

    public Quarto getQ() {
        return q;
    }

    public void setQ(Quarto q) {
        this.q = q;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
    
}