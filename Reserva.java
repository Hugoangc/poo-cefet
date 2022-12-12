public class Reserva {
    private Quarto q;
    private int numberOfDays;
    private int numberOfGuests;

    private Reserva(Quarto q, int numberOfGuests) {
        this.q = q;
        this.numberOfGuests = numberOfGuests;
    }

    public static void makeReserve(Quarto q, int numberOfGuests) {
        if (q.getNumberOfGuests() >= numberOfGuests + 1) {
            if (q.isVacancy()) {
                Reserva r = new Reserva(q, numberOfGuests);
                q.setVacancy(false);
            }
        }
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
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
