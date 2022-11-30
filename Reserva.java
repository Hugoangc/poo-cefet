public class Reserva {
    private Date data;
    private Cliente c;
    private Quarto q;
    private int numeroAcompanhantes;

    private Reserva(Cliente c, Quarto q, Date data, int numeroAcompanhantes) {
        this.c = c;
        this.q = q;
        this.data = data;
        this.numeroAcompanhantes = numeroAcompanhantes
    }

    public static Reserva criarReserva(Cliente c, Quarto q, Date data, int numeroAcompanhantes) {
        if (q.getnumeroHospedes() >= numeroAcompanhantes + 1) {
            if (q.isAvaiable(data)) {
                return Reserva r = new Reserva(c, q, data, numeroAcompanhantes);
            }
        }
        return null;
    }
}
