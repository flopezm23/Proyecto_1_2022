/*
Fernando Omar Lopez Morales
 */
import java.util.Date;

public class Bitacora extends ColaServicio {
    int correlativo;
    String nitSoporte;
    Date fechaHora;
    String mensaje;
    String evento;

    public Bitacora(int correlativo, String nitSoporte, Date fechaHora, String mensaje, String evento) {
        this.correlativo=correlativo;
        this.nitSoporte = nitSoporte;
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
        this.evento = evento;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public String getNitSoporte() {
        return nitSoporte;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getEvento() {
        return evento;
    }

    public void setNitSoporte(String nitSoporte) {
        this.nitSoporte = nitSoporte;
    }
    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    //para mostrar la bitacora
    public String toString() {
        System.out.println("#"+getCorrelativo()+" Nit: "+getNitSoporte()+" Mensaje: "+getMensaje()+" Evento: "+getEvento()+" Fecha y Hora: "+getFechaHora());

        return null;
    }
}
