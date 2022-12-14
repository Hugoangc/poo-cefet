
package poo_final;

import java.time.LocalDate;
import java.util.Date;

public class Reserva {
    private Quarto q;
    private Date date; //
    private int days; // ambos nao sao realmente necessarios
    private int numberOfDays;
    private int numberOfGuests;
    private Hospede h;
    private static double total;
   

    private Reserva(Quarto q, int numberOfGuests, Hospede h, Date d, int days) {
        this.q = q;
        this.numberOfGuests = numberOfGuests;
        this.h = h;
        this.date = d;
        this.days = days;
        
    }

    public static void makeReserve(Quarto q, Date d, int numberOfGuests, Hospede h, int days) {
        if (q.getNumberOfGuests() >= numberOfGuests) { // mudanca: +1 dps do numberOfGuests, nao lembro a logica, perguntar a dupla
            if (q.isVacancy()) {
                q.setVacancy(false);
                h.setTotal(days * 50 + 25 * numberOfGuests);
                q.Occupied(d, days);
                Reserva r = new Reserva(q, numberOfGuests, h, d, days);
                Hotel.Reservas.add(r);
            }
        }
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