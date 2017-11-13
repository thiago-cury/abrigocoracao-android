package thiagocury.eti.br.abrigocoracao;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PetJSON {

    @SerializedName("idPet")
    @Expose
    private String idPet;
    @SerializedName("QRCodePet")
    @Expose
    private String QRCodePet;
    @SerializedName("nomePet")
    @Expose
    private String nomePet;
    @SerializedName("anoNascAprox")
    @Expose
    private String anoNascAprox;
    @SerializedName("sexo")
    @Expose
    private String sexo;
    @SerializedName("porte")
    @Expose
    private String porte;
    @SerializedName("temperamento")
    @Expose
    private String temperamento;
    @SerializedName("fotoPet")
    @Expose
    private String fotoPet;
    @SerializedName("tipo")
    @Expose
    private String tipo;
    @SerializedName("estaCastrado")
    @Expose
    private String estaCastrado;
    @SerializedName("estaPasseando")
    @Expose
    private String estaPasseando;
    @SerializedName("setor")
    @Expose
    private String setor;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("historia")
    @Expose
    private String historia;
    @SerializedName("necessidadesEspeciais")
    @Expose
    private String necessidadesEspeciais;
    @SerializedName("obs")
    @Expose
    private String obs;
    @SerializedName("podePassear")
    @Expose
    private String podePassear;
    @SerializedName("dataCadastro")
    @Expose
    private String dataCadastro;
    @SerializedName("horaCadastro")
    @Expose
    private String horaCadastro;
    @SerializedName("temPadrinho")
    @Expose
    private String temPadrinho;

    /**
     *
     * @return
     *     The idPet
     */
    public String getIdPet() {
        return idPet;
    }

    /**
     *
     * @param idPet
     *     The idPet
     */
    public void setIdPet(String idPet) {
        this.idPet = idPet;
    }

    /**
     *
     * @return
     *     The QRCodePet
     */
    public String getQRCodePet() {
        return QRCodePet;
    }

    /**
     *
     * @param QRCodePet
     *     The QRCodePet
     */
    public void setQRCodePet(String QRCodePet) {
        this.QRCodePet = QRCodePet;
    }

    /**
     *
     * @return
     *     The nomePet
     */
    public String getNomePet() {
        return nomePet;
    }

    /**
     *
     * @param nomePet
     *     The nomePet
     */
    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    /**
     *
     * @return
     *     The anoNascAprox
     */
    public String getAnoNascAprox() {
        return anoNascAprox;
    }

    /**
     *
     * @param anoNascAprox
     *     The anoNascAprox
     */
    public void setAnoNascAprox(String anoNascAprox) {
        this.anoNascAprox = anoNascAprox;
    }

    /**
     *
     * @return
     *     The sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     *
     * @param sexo
     *     The sexo
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     *
     * @return
     *     The porte
     */
    public String getPorte() {
        return porte;
    }

    /**
     *
     * @param porte
     *     The porte
     */
    public void setPorte(String porte) {
        this.porte = porte;
    }

    /**
     *
     * @return
     *     The temperamento
     */
    public String getTemperamento() {
        return temperamento;
    }

    /**
     *
     * @param temperamento
     *     The temperamento
     */
    public void setTemperamento(String temperamento) {
        this.temperamento = temperamento;
    }

    /**
     *
     * @return
     *     The fotoPet
     */
    public String getFotoPet() {
        return fotoPet;
    }

    /**
     *
     * @param fotoPet
     *     The fotoPet
     */
    public void setFotoPet(String fotoPet) {
        this.fotoPet = fotoPet;
    }

    /**
     *
     * @return
     *     The tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     *     The tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @return
     *     The estaCastrado
     */
    public String getEstaCastrado() {
        return estaCastrado;
    }

    /**
     *
     * @param estaCastrado
     *     The estaCastrado
     */
    public void setEstaCastrado(String estaCastrado) {
        this.estaCastrado = estaCastrado;
    }

    /**
     *
     * @return
     *     The estaPasseando
     */
    public String getEstaPasseando() {
        return estaPasseando;
    }

    /**
     *
     * @param estaPasseando
     *     The estaPasseando
     */
    public void setEstaPasseando(String estaPasseando) {
        this.estaPasseando = estaPasseando;
    }

    /**
     *
     * @return
     *     The setor
     */
    public String getSetor() {
        return setor;
    }

    /**
     *
     * @param setor
     *     The setor
     */
    public void setSetor(String setor) {
        this.setor = setor;
    }

    /**
     *
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     *     The historia
     */
    public String getHistoria() {
        return historia;
    }

    /**
     *
     * @param historia
     *     The historia
     */
    public void setHistoria(String historia) {
        this.historia = historia;
    }

    /**
     *
     * @return
     *     The necessidadesEspeciais
     */
    public String getNecessidadesEspeciais() {
        return necessidadesEspeciais;
    }

    /**
     *
     * @param necessidadesEspeciais
     *     The necessidadesEspeciais
     */
    public void setNecessidadesEspeciais(String necessidadesEspeciais) {
        this.necessidadesEspeciais = necessidadesEspeciais;
    }

    /**
     *
     * @return
     *     The obs
     */
    public String getObs() {
        return obs;
    }

    /**
     *
     * @param obs
     *     The obs
     */
    public void setObs(String obs) {
        this.obs = obs;
    }

    /**
     *
     * @return
     *     The podePassear
     */
    public String getPodePassear() {
        return podePassear;
    }

    /**
     *
     * @param podePassear
     *     The podePassear
     */
    public void setPodePassear(String podePassear) {
        this.podePassear = podePassear;
    }

    /**
     *
     * @return
     *     The dataCadastro
     */
    public String getDataCadastro() {
        return dataCadastro;
    }

    /**
     *
     * @param dataCadastro
     *     The dataCadastro
     */
    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     *
     * @return
     *     The horaCadastro
     */
    public String getHoraCadastro() {
        return horaCadastro;
    }

    /**
     *
     * @param horaCadastro
     *     The horaCadastro
     */
    public void setHoraCadastro(String horaCadastro) {
        this.horaCadastro = horaCadastro;
    }

    /**
     *
     * @return
     *     The temPadrinho
     */
    public String isTemPadrinho() { return temPadrinho; }

    /**
     *
     * @param temPadrinho
     *     The temPadrinho
     */
    public void setTemPadrinho(String temPadrinho) { this.temPadrinho = temPadrinho; }
}