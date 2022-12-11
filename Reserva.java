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

    public static boolean makeReserva(Quarto q, Date d, int numberOfGuests) {
        if (q.getnumberOfGuests() >= numberOfGuests + 1) {
            if (q.isAvailable(d)) {
                Reserva r = new Reserva(q, d, numberOfGuests);
                return true;
            }
        }
        return false;
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
