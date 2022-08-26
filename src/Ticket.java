/*
Fernando Omar Lopez Morales
 */
public class Ticket extends ColaServicio {
    String nitUsuario;
    int id;
    String problema;
    String estado;
    String cola;

    public Ticket(String nitUsuario, int id, String problema, String estado,String cola) {
        this.nitUsuario = nitUsuario;
        this.id = id;
        this.problema = problema;
        this.estado = estado;
        this.cola = cola;
    }

    public String getNitUsuario() {
        return nitUsuario;
    }

    public int getId() {
        return id;
    }

    public String getProblema() {
        return problema;
    }

    public String getEstado() {
        return estado;
    }

    public String getCola() {
        return cola;
    }

    public void setNitUsuario(String nitUsuario) {
        this.nitUsuario = nitUsuario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCola(String cola) {
        this.cola = cola;
    }

}
