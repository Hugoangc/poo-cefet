public class Quarto {
    private int numeroHospedes;
    private String tipoQuarto;
    private ArrayList<Date> uso; // dias que o quarto está ocupado

    public Quarto(int numeroHospedes, String tipoQuarto) {
        this.numeroHospedes = numeroHospedes;
        this.tipoQuarto = tipoQuarto;
    }

    private static criarQuarto(int numeroHospedes) {
        if (numeroHospedes == 2) tipoQuarto = "Casal";
        tipoQuarto = "Solteiro";
    }

    public boolean isAvaiable(Date d) {
        for (int i = 0; i < uso.size(); i++) {
            if (d.compareTo(uso.at(i)) == 0) return false;
        }
        return true;
    }

    public int getnumeroHospedes() {
        return numeroHospedes;
    }
    public void setnumeroHospedes(int numeroHospedes) {
        this.numeroHospedes = numeroHospedes;
    }
    public String gettipoQuarto() {
        return tipoQuarto;
    }
    public void settipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }
}