package model;

import java.util.ArrayList;
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
    private List<Ataque> ataques;

    public Pocket(Long id, String nome, String descricao, int testePersonagem, int bonus, int armadura, int movimento, Tamanho tamanho) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.testePersonagem = testePersonagem;
        this.pontosVida = (testePersonagem * 5)+bonus;
        this.armadura = armadura-2;
        this.movimento = movimento;
        this.ataques = new ArrayList<>();
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

    public List<Ataque> getAtaque() {
        return ataques;
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

    public String viewWindow(){
        String window = "";
        window +="\n".repeat(5);
        window += "=".repeat(50)+"\n";
        window += nome+"\n";
        window += descricao+"\n";
        window += "-".repeat(50)+"\n";
        window += "TP: " +testePersonagem+" CA: "+armadura+" MV: "+movimento+" PV: "+ pontosVida+"\n";
        window += "-".repeat(50)+"\n";

        for(Ataque a: ataques){
            window+= a+"\n";
        }
        
        window += "=".repeat(50)+"\n";

        return window;
    }

    public void adicionarAtaque(Ataque ataque) {
        if (ataque != null) {
            this.ataques.add(ataque);
        }
    }

    public void adicionarAtaques(List<Ataque> ataquePackage) {
        if (ataquePackage != null) {
            this.ataques.addAll(ataquePackage);
        }
    }

    @Override
    public String toString() {
        return "[" + id + "] " + nome + " {" + pontosVida + ", " + testePersonagem + ", " + movimento + ", " + armadura + ", " + iniciativa + "}";
    }
}