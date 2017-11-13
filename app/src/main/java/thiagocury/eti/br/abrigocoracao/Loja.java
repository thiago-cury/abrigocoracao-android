package thiagocury.eti.br.abrigocoracao;

import java.io.Serializable;

/**
 * Created by Rafael Kern on 29/12/2015.
 */
public class Loja implements Serializable {

    private String foto1 = "http://www.loja101viralatas.com.br/files/medias/zoom-22.png";
    private String foto2 = "http://www.loja101viralatas.com.br/files/medias/zoom-14.png";
    private String foto3 = "http://www.loja101viralatas.com.br/files/medias/detail-caneca-cao.jpeg";
    private String foto4 = "http://www.loja101viralatas.com.br/files/medias/zoom-15.png";
    private String foto5 = "http://www.loja101viralatas.com.br/files/medias/zoom-13.png";
    private String foto6 = "http://www.loja101viralatas.com.br/files/medias/zoom-12.png";

    public Loja() {
    }

    public Loja(String foto1, String foto2, String foto3, String foto4, String foto5, String foto6) {
        this.foto1 = foto1;
        this.foto2 = foto2;
        this.foto3 = foto3;
        this.foto4 = foto4;
        this.foto5 = foto5;
        this.foto6 = foto6;
    }

    public String getFoto1() {
        return foto1;
    }

    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }

    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }

    public String getFoto3() {
        return foto3;
    }

    public void setFoto3(String foto3) {
        this.foto3 = foto3;
    }

    public String getFoto4() {
        return foto4;
    }

    public void setFoto4(String foto4) {
        this.foto4 = foto4;
    }

    public String getFoto5() {
        return foto5;
    }

    public void setFoto5(String foto5) {
        this.foto5 = foto5;
    }

    public String getFoto6() {
        return foto6;
    }

    public void setFoto6(String foto6) {
        this.foto6 = foto6;
    }

    @Override
    public String toString() {
        return "Loja{" +
                "foto1='" + foto1 + '\'' +
                ", foto2='" + foto2 + '\'' +
                ", foto3='" + foto3 + '\'' +
                ", foto4='" + foto4 + '\'' +
                ", foto5='" + foto5 + '\'' +
                ", foto6='" + foto6 + '\'' +
                '}';
    }
}//fecha classe
