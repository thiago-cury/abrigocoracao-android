package thiagocury.eti.br.abrigocoracao;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * Created by thiagocury on 21/12/15.
 */
public class Evento implements Serializable{

    private int idEvento;
    private String titulo;
    private String descricao;
    private String local;
    private String data;
    private String horaInicio;
    private String horaFim;
    private String imagem;
    private String tipo;

    public Evento() {
    }

    public Evento(int idEvento, String titulo, String descricao, String local, String data, String horaInicio, String horaFim, String imagem, String tipo) {
        this.idEvento = idEvento;
        this.titulo = titulo;
        this.descricao = descricao;
        this.local = local;
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.imagem = imagem;
        this.tipo = tipo;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "idEvento=" + idEvento +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", local='" + local + '\'' +
                ", data='" + data + '\'' +
                ", horaInicio='" + horaInicio + '\'' +
                ", horaFim='" + horaFim + '\'' +
                ", imagem='" + imagem + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
