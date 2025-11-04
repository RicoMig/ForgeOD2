package model;

import java.util.List;
import java.util.Random;

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

    public Pocket(String nome, String descricao, int testePersonagem, int armadura, int movimento, int iniciativa) {
        this.id = generate.nextLong(1, 9999);
        this.nome = nome;
        this.descricao = descricao;
        this.testePersonagem = testePersonagem;
        this.pontosVida = testePersonagem * 5;
        this.armadura = armadura;
        this.movimento = movimento;
        this.iniciativa = iniciativa;
    }

    // 🔥 IMPLEMENTAÇÃO OBRIGATÓRIA da interface Monstros
    @Override
    public Long getID() {  // ← Note: getID() com D maiúsculo
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

    // Seus outros getters (não fazem parte da interface)
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

    // Setters se necessário
    public void setAtaque(List<String> ataque) {
        this.ataque = ataque;
    }
    
    public void setMovimento(int movimento) {
        this.movimento = movimento;
    }
}