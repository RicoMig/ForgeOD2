package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.enums.*;

public class Old implements Monstros {
    Random generate = new Random();

    private Long id;
    private String nome; 
    private String descricao;
    private char tesouro;
    private int experiencia;
    private int movimento;
    private int moral;
    private int armadura;
    private int qtdDadoVida;
    private String dadoVida;
    private int jogadaProtecao;
    private List<Ataque> ataques;
    private Alinhamento alinhamento;
    private Conceito conceito;
    private Habitat habitat;
    private Tamanho tamanho;
    private int bonus;
    
    // Construtor
    public Old() {
        this.ataques = new ArrayList<>();
        this.id = generate.nextLong(1, 9999);
    }

    // Construtor com nome
    public Old(String nome, int experiencia, int movimento, int moral, int armadura, 
               int qtdDado, int bonus, int jogadaProtecao, int alinhamento, 
               int conceito, int habitat, int tamanho) {
        this.id = generate.nextLong(1, 9999);
        this.nome = nome;
        this.experiencia = experiencia;
        this.movimento = movimento;
        this.moral = moral;
        this.armadura = armadura;
        this.qtdDadoVida = qtdDado;
        this.bonus = bonus;
        this.dadoVida = qtdDadoVida + "+" + bonus;
        this.jogadaProtecao = jogadaProtecao;
        this.ataques = new ArrayList<>();
        
        setAlinhamento(alinhamento);
        setConceito(conceito);
        setHabitat(habitat);
        setTamanho(tamanho);
    }

    // Implementação dos métodos da interface Monstros
    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    // Getters e Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdDadoVida() {
        return qtdDadoVida;
    }

    public void setQtdDadoVida(int qtdDadoVida) {
        this.qtdDadoVida = qtdDadoVida;
        updateDadoVida();
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
        updateDadoVida();
    }

    private void updateDadoVida() {
        this.dadoVida = qtdDadoVida + "+" + bonus;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public char getTesouro() {
        return tesouro;
    }

    public void setTesouro(char tesouro) {
        this.tesouro = tesouro;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getMovimento() {
        return movimento;
    }

    public void setMovimento(int movimento) {
        this.movimento = movimento;
    }

    public int getMoral() {
        return moral;
    }

    public void setMoral(int moral) {
        this.moral = moral;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public String getDadoVida() {
        return dadoVida;
    }

    public void setDadoVida(String dadoVida) {
        this.dadoVida = dadoVida;
    }

    public int getJogadaProtecao() {
        return jogadaProtecao;
    }

    public void setJogadaProtecao(int jogadaProtecao) {
        this.jogadaProtecao = jogadaProtecao;
    }

    public Alinhamento getAlinhamento() {
        return alinhamento;
    }

    public void setAlinhamento(int a) {
        switch (a) {
            case 1: 
                this.alinhamento = Alinhamento.ORDEIRO;
                break;
            case 2:
                this.alinhamento = Alinhamento.NEUTRO;
                break;
            case 3:
                this.alinhamento = Alinhamento.CAOTICO;
                break;
            default:
                this.alinhamento = Alinhamento.NEUTRO; // Default value
        }
    }

    public void setAlinhamento(Alinhamento alinhamento) {
        this.alinhamento = alinhamento;
    }

    public Conceito getConceito() {
        return conceito;
    }

    public void setConceito(int c) {
        switch (c) {
            case 1: this.conceito = Conceito.HUMANOIDE; break;
            case 2: this.conceito = Conceito.HUMANOIDE_MONSTRUOSO; break;
            case 3: this.conceito = Conceito.GIGANTE; break;
            case 4: this.conceito = Conceito.ANIMAL; break;
            case 5: this.conceito = Conceito.INSETO; break;
            case 6: this.conceito = Conceito.CONSTRUCTO; break;
            case 7: this.conceito = Conceito.MORTO_VIVO; break;
            case 8: this.conceito = Conceito.PLANTA; break;
            case 9: this.conceito = Conceito.GOSMA; break;
            case 10: this.conceito = Conceito.DRAGAO; break;
            case 11: this.conceito = Conceito.BESTAS; break;
            default: this.conceito = Conceito.HUMANOIDE; // Default value
        }
    }

    public void setConceito(Conceito conceito) {
        this.conceito = conceito;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(int h) {
        switch (h) {
            case 1: this.habitat = Habitat.QUALQUER; break;
            case 2: this.habitat = Habitat.PLANICIES; break;
            case 3: this.habitat = Habitat.COLINAS; break;
            case 4: this.habitat = Habitat.MONTANHAS; break;
            case 5: this.habitat = Habitat.PANTANOS; break;
            case 6: this.habitat = Habitat.GELEIRAS; break;
            case 7: this.habitat = Habitat.DESERTOS; break;
            case 8: this.habitat = Habitat.FLORESTA; break;
            case 9: this.habitat = Habitat.SUBTERRANEOS; break;
            case 10: this.habitat = Habitat.OCEANOS; break;
            case 11: this.habitat = Habitat.EXTRAPLANAR; break;
            default: this.habitat = Habitat.QUALQUER; // Default value
        }
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(int t) {
        switch (t) {
            case 1: this.tamanho = Tamanho.MIUDO; break;
            case 2: this.tamanho = Tamanho.PEQUENO; break;
            case 3: this.tamanho = Tamanho.MEDIO; break;
            case 4: this.tamanho = Tamanho.GRANDE; break;
            case 5: this.tamanho = Tamanho.IMENSO; break;
            case 6: this.tamanho = Tamanho.COLOSSAL; break;
            default: this.tamanho = Tamanho.MEDIO; // Default value
        }
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public List<Ataque> getAtaques() {
        return ataques;
    }

    public void setAtaques(List<Ataque> ataques) {
        this.ataques = ataques;
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

    public void removerAtaque(Ataque ataque) {
        this.ataques.remove(ataque);
    }

    public void removerAtaque(int index) {
        if (index >= 0 && index < ataques.size()) {
            this.ataques.remove(index);
        }
    }
   
    public String monstroWindow() {
        StringBuilder window = new StringBuilder();
        window.append("=".repeat(50)).append("\n");
        window.append(nome).append("\n");
        window.append("-".repeat(50)).append("\n");
        window.append(conceito).append(", ").append(tamanho).append(", ").append(alinhamento).append(", ").append(habitat).append("\n");
        window.append("-".repeat(50)).append("\n");
        window.append("Encontro: ?(?) Experiência:").append(experiencia).append("\n");
        window.append("Tesouro: ").append(tesouro).append(" Movimento:").append(movimento).append("\n");
        window.append("-".repeat(50)).append("\n");
        window.append("DV[PV]:").append(qtdDadoVida).append("[").append(qtdDadoVida * 5).append("] CA:").append(armadura).append(" JP:").append(jogadaProtecao).append(" MO:").append(moral).append("\n");
        window.append("-".repeat(50)).append("\n");
        for (Ataque a : ataques) {
            window.append(a.toString()).append("\n");
        }
        window.append("=".repeat(50));
        return window.toString();
    }

    // Método toString para exibição
    @Override
    public String toString() {
        return "[" + id + "] " + nome + " {" + tamanho + ", " + habitat + ", " + qtdDadoVida + "}";
    }

    @Override
    public Long getID() {
        return this.id;
    }
}