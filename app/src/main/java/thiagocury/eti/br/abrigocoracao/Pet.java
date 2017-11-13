package thiagocury.eti.br.abrigocoracao;

import java.io.Serializable;

/**
 * Created by thiagocury on 27/11/15.
 */
public class Pet implements Serializable{

    private int idPet;
    private String QRCodePet;
    private String nomePet;
    private int anoNascAprox;
    private String sexo;
    private String porte;
    private String temperamento;
    private String fotoPet;
    private String tipo;
    private boolean estaCastrado;
    private boolean estaPasseando;
    private String setor;
    private String status;
    private String historia;
    private String necessidadesEspeciais;
    private String obs;
    private boolean podePassear;
    private String dataCadastro;
    private String horaCadastro;
    private String temPadrinho;

    public Pet() {
    }

    public Pet(int idPet, String QRCodePet, String nomePet, int anoNascAprox, String sexo, String porte, String temperamento, String fotoPet, String tipo, boolean estaCastrado, boolean estaPasseando, String setor, String status, String historia, String necessidadesEspeciais, String obs, boolean podePassear, String dataCadastro, String horaCadastro, String temPadrinho) {
        this.idPet = idPet;
        this.QRCodePet = QRCodePet;
        this.nomePet = nomePet;
        this.anoNascAprox = anoNascAprox;
        this.sexo = sexo;
        this.porte = porte;
        this.temperamento = temperamento;
        this.fotoPet = fotoPet;
        this.tipo = tipo;
        this.estaCastrado = estaCastrado;
        this.estaPasseando = estaPasseando;
        this.setor = setor;
        this.status = status;
        this.historia = historia;
        this.necessidadesEspeciais = necessidadesEspeciais;
        this.obs = obs;
        this.podePassear = podePassear;
        this.dataCadastro = dataCadastro;
        this.horaCadastro = horaCadastro;
        this.temPadrinho = temPadrinho;
    }

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public String getQRCodePet() {
        return QRCodePet;
    }

    public void setQRCodePet(String QRCodePet) {
        this.QRCodePet = QRCodePet;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public int getAnoNascAprox() {
        return anoNascAprox;
    }

    public void setAnoNascAprox(int anoNascAprox) {
        this.anoNascAprox = anoNascAprox;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getTemperamento() {
        return temperamento;
    }

    public void setTemperamento(String temperamento) {
        this.temperamento = temperamento;
    }

    public String getFotoPet() {
        return fotoPet;
    }

    public void setFotoPet(String fotoPet) {
        this.fotoPet = fotoPet;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEstaCastrado() {
        return estaCastrado;
    }

    public void setEstaCastrado(boolean estaCastrado) {
        this.estaCastrado = estaCastrado;
    }

    public boolean isEstaPasseando() {
        return estaPasseando;
    }

    public void setEstaPasseando(boolean estaPasseando) {
        this.estaPasseando = estaPasseando;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getNecessidadesEspeciais() {
        return necessidadesEspeciais;
    }

    public void setNecessidadesEspeciais(String necessidadesEspeciais) {
        this.necessidadesEspeciais = necessidadesEspeciais;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public boolean isPodePassear() {
        return podePassear;
    }

    public void setPodePassear(boolean podePassear) {
        this.podePassear = podePassear;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getHoraCadastro() {
        return horaCadastro;
    }

    public void setHoraCadastro(String horaCadastro) {
        this.horaCadastro = horaCadastro;
    }

    public String isTemPadrinho() {
        return temPadrinho;
    }

    public void setTemPadrinho(String temPadrinho) {
        this.temPadrinho = temPadrinho;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "idPet=" + idPet +
                ", QRCodePet='" + QRCodePet + '\'' +
                ", nomePet='" + nomePet + '\'' +
                ", anoNascAprox=" + anoNascAprox +
                ", sexo='" + sexo + '\'' +
                ", porte='" + porte + '\'' +
                ", temperamento='" + temperamento + '\'' +
                ", fotoPet='" + fotoPet + '\'' +
                ", tipo='" + tipo + '\'' +
                ", estaCastrado=" + estaCastrado +
                ", estaPasseando=" + estaPasseando +
                ", setor='" + setor + '\'' +
                ", status='" + status + '\'' +
                ", historia='" + historia + '\'' +
                ", necessidadesEspeciais='" + necessidadesEspeciais + '\'' +
                ", obs='" + obs + '\'' +
                ", podePassear=" + podePassear +
                ", dataCadastro='" + dataCadastro + '\'' +
                ", horaCadastro='" + horaCadastro + '\'' +
                ", temPadrinho=" + temPadrinho +
                '}';
    }
}