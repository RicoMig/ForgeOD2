package model;

import java.util.List;
import java.util.Random;
import model.enums.Tamanho;

public class Pocket implements Monstros {
    private static Random generate = new Random();
    private Long id;
    private String nome;
    private String descricao;
    private int pontosVida;
    private int testePersonagem;
    private int armadura;
    private int movimento;
    private int iniciativa;
    private List<String> ataque;

    public Pocket(Long id, String nome, String descricao, int testePersonagem, int armadura, int movimento, Tamanho tamanho) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.testePersonagem = testePersonagem;
        this.pontosVida = testePersonagem * 5;
        this.armadura = armadura;
        this.movimento = movimento;
        setIniciativa(tamanho);
    }

    @Override
    public Long getID() {
        return this.id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public int getTestePersonagem() {
        return testePersonagem;
    }

    public int getArmadura() {
        return armadura;
    }

    public int getMovimento() {
        return movimento;
    }

    public int getIniciativa() {
        return iniciativa;
    }

    public List<String> getAtaque() {
        return ataque;
    }

    public void setAtaque(List<String> ataque) {
        this.ataque = ataque;
    }
    
    public void setMovimento(int movimento) {
        this.movimento = movimento;
    }

    public void setIniciativa(Tamanho tamanho) {
        if (tamanho == null) {
            this.iniciativa = 0;
            return;
        }
        
        switch (tamanho) {
            case MIUDO:
            case PEQUENO:
                this.iniciativa = 8;
                break;
            case MEDIO:
                this.iniciativa = 5;
                break;
            case GRANDE:
            case IMENSO:
            case COLOSSAL:
                this.iniciativa = 2;
                break;
            default:
                this.iniciativa = 0;
        }
    }

    @Override
    public String toString() {
        return "[" + id + "] " + nome + " {" + pontosVida + ", " + testePersonagem + ", " + movimento + ", " + armadura + ", " + iniciativa + "}";
    }
}