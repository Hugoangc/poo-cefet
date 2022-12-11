import java.util.Date;

public class Reserva {
    private Date data;
    private Quarto q;
    private int numberOfGuests;

    private Reserva(Quarto q, Date d, int numberOfGuests) {
        this.q = q;
        this.data = d;
        this.numberOfGuests = numberOfGuests;
    }

    public static void makeReserve(Quarto q, Date d, int numberOfGuests) {
        if (q.getNumberOfGuests() >= numberOfGuests + 1) {
            if (Quarto.isAvailable(d)) {
                Reserva r = new Reserva(q, d, numberOfGuests);
                Quarto.getVacancy().add(d);
            }
        }
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
