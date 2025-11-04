package model;

import java.util.List;
import java.util.Random;
import model.enums.*;

public class Old implements Monstros {
    private Long id;
    private String nome; 
    private char tesouro;
    private int experiencia;
    private String movimento;
    private int moral;
    private int armadura;
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
    public Old(String nome,int experiencia,int movimento,int moral,int armadura,int qtdDado, int nFaces, int jogadaProtecao, Alinhamento alinhamento, Conceito conceito, Habitat habitat, Tamanho tamanho) {
        this.nome = nome;
        this.experiencia = experiencia;
        this.movimento = movimento+"m";
        this.moral = moral;
        this.armadura = armadura;
        this.dadoVida = qtdDado+"d"+nFaces;
        this.alinhamento = alinhamento;
        this.conceito = conceito;
        this.habitat = habitat;
        this.tamanho = tamanho;
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

    public String getMovimento() {
        return movimento;
    }

    public void setMovimento(String movimento) {
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

    public void setAlinhamento(Alinhamento alinhamento) {
        this.alinhamento = alinhamento;
    }

    public Conceito getConceito() {
        return conceito;
    }

    public void setConceito(Conceito conceito) {
        this.conceito = conceito;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    // Método toString para exibição
    @Override
    public String toString() {
        return getDescricao();
    } 

    @Override
    public Long getID(){
        return this.id;
    }

}