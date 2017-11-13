package thiagocury.eti.br.abrigocoracao;

/**
 * Created by thiagocury on 21/12/15.
 */

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventoJSON {

    @SerializedName("idEvento")
    @Expose
    private String idEvento;
    @SerializedName("titulo")
    @Expose
    private String titulo;
    @SerializedName("descricao")
    @Expose
    private String descricao;
    @SerializedName("local")
    @Expose
    private String local;
    @SerializedName("data")
    @Expose
    private String data;
    @SerializedName("horaInicio")
    @Expose
    private String horaInicio;
    @SerializedName("horaFim")
    @Expose
    private String horaFim;
    @SerializedName("imagem")
    @Expose
    private String imagem;
    @SerializedName("tipo")
    @Expose
    private String tipo;

    /**
     *
     * @return
     * The idEvento
     */
    public String getIdEvento() {
        return idEvento;
    }

    /**
     *
     * @param idEvento
     * The idEvento
     */
    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    /**
     *
     * @return
     * The titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     *
     * @param titulo
     * The titulo
     */
    public void setTitulo(String titulo) {
        this.titulo= titulo;
    }

    /**
     *
     * @return
     * The descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     *
     * @param descricao
     * The descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     *
     * @return
     * The local
     */
    public String getLocal() {
        return local;
    }

    /**
     *
     * @param local
     * The local
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     *
     * @return
     * The data
     */
    public String getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     *
     * @return
     * The horaInicio
     */
    public String getHoraInicio() {
        return horaInicio;
    }

    /**
     *
     * @param horaInicio
     * The horaInicio
     */
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     *
     * @return
     * The horaFim
     */
    public String getHoraFim() {
        return horaFim;
    }

    /**
     *
     * @param horaFim
     * The horaFim
     */
    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    /**
     *
     * @return
     * The imagem
     */
    public String getImagem() {
        return imagem;
    }

    /**
     *
     * @param imagem
     * The imagem
     */
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    /**
     *
     * @return
     * The tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     * The tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}