package professor;

import java.awt.image.BufferedImage;
import minhasaladeaulaproto.ExibirDados;

public class Apresentacao implements ExibirDados{
    //ATRIBUTOS
    private String bio;
    private String metodologia;
    private BufferedImage logotipo;
    private int id;
    
    //GETTERS AND SETTERS
    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    public BufferedImage getLogotipo() {
        return logotipo;
    }

    public void setLogotipo(BufferedImage logotipo) {
        this.logotipo = logotipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    //METÓDO HERDADO PARA EXIBIR DADOS DA APRESENTAÇÃO DO PROFESSOR
    @Override
    public void exibirResumo() {
        System.out.println("  Bio: "+this.getBio());
        System.out.println("  Metodologia: "+this.getMetodologia());
    }
        
}
