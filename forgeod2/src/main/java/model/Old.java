package model;

import java.util.List;
import java.util.Random;
import model.enums.*;

public class Old implements Monstros {
    Random generate = new Random();

    private Long id;
    private String nome; 
    private char tesouro;
    private int experiencia;
    private int movimento;
    private int moral;
    private int armadura;
    private int qtdDadoVida;
    private String dadoVida;
    private int jogadaProtecao;
    private List<String> ataques; 
    private Alinhamento alinhamento;
    private Conceito conceito;
    private Habitat habitat;
    private Tamanho tamanho;

    
    // Construtor
    public Old() {
        // Inicializações padrão
    }

    // Construtor com nome
    public Old(String nome,int experiencia,int movimento,int moral,int armadura,int qtdDado, int bonus, int jogadaProtecao, int alinhamento, int conceito, int habitat, int tamanho) {
        this.id = generate.nextLong(1, 9999);
        this.nome = nome;
        this.experiencia = experiencia;
        this.movimento = movimento;
        this.moral = moral;
        this.armadura = armadura;
        this.qtdDadoVida = qtdDado;
        this.dadoVida = qtdDadoVida+"+"+bonus;
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
        return String.format("%s - %s %s que habita %s", nome, tamanho, conceito , habitat);
    }

    // Getters e Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdDadoVida(){
        return qtdDadoVida;
    }

    public void setId(){
        Random numID = new Random();
        this.id = numID.nextLong(1,9999);
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

    public List<String> getAtaques() {
        return ataques;
    }

    public void setAtaques(List<String> ataques) {
        this.ataques = ataques;
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

            case 3:
            this.alinhamento = Alinhamento.CAOTICO;
        }

    }

    public Conceito getConceito() {
        return conceito;
    }

    public void setConceito(int c) {
        switch (c) {
            case 1: this.conceito = Conceito.HUMANOIDE;
            case 2: this.conceito = Conceito.HUMANOIDE_MONSTRUOSO;
            case 3: this.conceito = Conceito.GIGANTE;
            case 4: this.conceito = Conceito.ANIMAL;
            case 5: this.conceito = Conceito.INSETO;
            case 6: this.conceito = Conceito.CONSTRUCTO;
            case 7: this.conceito = Conceito.MORTO_VIVO;
            case 8: this.conceito = Conceito.PLANTA;
            case 9: this.conceito = Conceito.GOSMA;
            case 10: this.conceito = Conceito.DRAGAO;
            case 11: this.conceito = Conceito.BESTAS;
        }
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(int h) {

        switch (h) {
            case 1: this.habitat = Habitat.QUALQUER;
            case 2: this.habitat = Habitat.PLANICIES;
            case 3: this.habitat = Habitat.COLINAS;
            case 4: this.habitat = Habitat.MONTANHAS;
            case 5: this.habitat = Habitat.PANTANOS;
            case 6: this.habitat = Habitat.GELEIRAS;
            case 7: this.habitat = Habitat.DESERTOS;
            case 8: this.habitat = Habitat.FLORESTA;
            case 9: this.habitat = Habitat.SUBTERRANEOS;
            case 10: this.habitat = Habitat.OCEANOS;
            case 11: this.habitat = Habitat.EXTRAPLANAR;
        }
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(int t) {
        
        
        switch (t) {
            case 1: this.tamanho = Tamanho.MIUDO;
            case 2: this.tamanho = Tamanho.PEQUENO;
            case 3: this.tamanho = Tamanho.MEDIO;
            case 4: this.tamanho = Tamanho.GRANDE;
            case 5: this.tamanho = Tamanho.IMENSO;
            case 6: this.tamanho = Tamanho.COLOSSAL;
           
        }
    }

    // Método toString para exibição
    @Override
    public String toString() {
        return "["+id+"] "+ nome +" {"+tamanho+ ", "+habitat+", " +qtdDadoVida+"}";
    } 

    @Override
    public Long getID(){
        return this.id;
    }

}