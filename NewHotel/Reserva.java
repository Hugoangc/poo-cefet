
package poo_final;

import java.time.LocalDate;
import java.util.Date;

public class Reserva {
    private Quarto q;
    private int numberOfDays;
    private int numberOfGuests;
    private Hospede h;
    private static double total;

    private Reserva(Quarto q, int numberOfGuests, Hospede h) {
        this.q = q;
        this.numberOfGuests = numberOfGuests;
        this.h = h;
    }

    public static void makeReserve(Quarto q, Date d, int numberOfGuests, Hospede h, int days) {
        if (q.getNumberOfGuests() >= numberOfGuests) { // +1 dps do numberOfGuests
            if (q.isVacancy()) {
                Reserva r = new Reserva(q, numberOfGuests, h);
                q.setVacancy(false);
                h.setTotal(days * 50 + 25 * numberOfGuests);
               // Hospede.registerGuest(h.getNome(), h.getCPF());
               q.Ocupado(d, days);
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
}