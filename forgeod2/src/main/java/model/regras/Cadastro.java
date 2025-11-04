package model.regras;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Old;
import model.Pocket;
import model.enums.Alinhamento;
import model.enums.Conceito;
import model.enums.Habitat;
import model.enums.Tamanho;

public class Cadastro {
    private static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Teste com Pocket
        List<Pocket> monstroPackage = new ArrayList<Pocket>();
        
        Pocket bugbear = new Pocket("bugbear", "Criatura humanóide grande e peluda", 3, 13, 9, 0);
        Pocket drakold = new Pocket("drakold", "Dragão menor", 1, 12, 6, 0);
        Pocket dragaoVermelho = new Pocket("Dragão Vermelho", "Dragão ancião poderoso", 5, 19, 9, 0);
        
        monstroPackage.add(bugbear);
        monstroPackage.add(drakold);
        monstroPackage.add(dragaoVermelho);

        // Exibir lista de Pocket
        System.out.println("=== MONSTROS POCKET ===");
        monstroPackage.stream().forEach(monstro -> 
            System.out.printf("[%d] %s || TP:%d || PV:%d || CA:%d || MV:%d || IN:%d\n", 
                monstro.getID(),
                monstro.getNome(),
                monstro.getTestePersonagem(), 
                monstro.getPontosVida(),
                monstro.getArmadura(),
                monstro.getMovimento(),
                monstro.getIniciativa())
        );

        // Teste com Old
        List<Old> bestiarioOld = new ArrayList<>();
        Old monstroOld = cadastrarMonstro();
        bestiarioOld.add(monstroOld);
        
        System.out.println("\n=== MONSTRO OLD CADASTRADO ===");
        exibirListaSimples(bestiarioOld);
    }
    
    // Método para exibir lista de Old
    public static void exibirListaSimples(List<Old> monstroPackage) {
        System.out.println("📋 LISTA DE MONSTROS OLD (" + monstroPackage.size() + " monstros)");
        System.out.println("=" .repeat(50));
        
        if (monstroPackage.isEmpty()) {
            System.out.println("Nenhum monstro cadastrado.");
            return;
        }
        
        for (int i = 0; i < monstroPackage.size(); i++) {
            Old monstro = monstroPackage.get(i);
            System.out.printf("[%d] ID: %d | %s | %s | %s\n", 
                i + 1, 
                monstro.getID(), 
                monstro.getNome(), 
                monstro.getConceito(), 
                monstro.getTamanho()
            );
        }
    }

    // Método para cadastrar monstro Old
    public static Old cadastrarMonstro() {
        Old monstro = new Old();

        System.out.println("\n=== CADASTRO DE MONSTRO OLD ===");
        
        monstro.setId();
        
        // Nome
        System.out.print("Nome do monstro: ");
        monstro.setNome(input.nextLine());
        
        // Conceito
        monstro.setConceito(escolherConceito());
        
        // Habitat
        monstro.setHabitat(escolherHabitat());
        
        // Tamanho
        monstro.setTamanho(escolherTamanho());
        
        // Alinhamento
        monstro.setAlinhamento(escolherAlinhamento());
        
        // Atributos numéricos
        System.out.print("Experiência: ");
        monstro.setExperiencia(input.nextInt());
        
        System.out.print("Movimento (metros): ");
        monstro.setMovimento(input.nextInt() + "m");
        
        System.out.print("Moral: ");
        monstro.setMoral(input.nextInt());
        
        System.out.print("Armadura: ");
        monstro.setArmadura(input.nextInt());
        
        System.out.print("Dado de Vida (quantidade de dados): ");
        int qtdDados = input.nextInt();
        System.out.print("Dado de Vida (faces do dado): ");
        int facesDado = input.nextInt();
        monstro.setDadoVida(qtdDados + "d" + facesDado);
        
        System.out.print("Jogada de Proteção: ");
        monstro.setJogadaProtecao(input.nextInt());
        
        input.nextLine(); // Limpar buffer
        
        // Ataques
        List<String> ataques = Arrays.asList(
            "1x Patada +2 (1d4)",
            "CORRER: pode correr com movimento 20 durante um turno, ou 12 durante 2 turnos",
            "CARGA: carrega até 2.500 moedas"
        );
        monstro.setAtaques(ataques);

        System.out.println("✅ Monstro Old cadastrado com sucesso!");
        return monstro;
    }
    
    // Métodos auxiliares para escolha de enums
    private static Conceito escolherConceito() {
        System.out.println("\n=== CONCEITO ===");
        Conceito[] conceitos = Conceito.values();
        for (int i = 0; i < conceitos.length; i++) {
            System.out.printf("[%d] %s\n", i + 1, conceitos[i].toString());
        }
        System.out.print("Escolha o conceito: ");
        int escolha = input.nextInt();
        input.nextLine(); // Limpar buffer
        
        if (escolha > 0 && escolha <= conceitos.length) {
            return conceitos[escolha - 1];
        } else {
            System.out.println("Escolha inválida, usando ANIMAL como padrão.");
            return Conceito.ANIMAL;
        }
    }
    
    private static Habitat escolherHabitat() {
        System.out.println("\n=== HABITAT ===");
        Habitat[] habitats = Habitat.values();
        for (int i = 0; i < habitats.length; i++) {
            System.out.printf("[%d] %s\n", i + 1, habitats[i].toString());
        }
        System.out.print("Escolha o habitat: ");
        int escolha = input.nextInt();
        input.nextLine(); // Limpar buffer
        
        if (escolha > 0 && escolha <= habitats.length) {
            return habitats[escolha - 1];
        } else {
            System.out.println("Escolha inválida, usando PLANICIES como padrão.");
            return Habitat.PLANICIES;
        }
    }
    
    private static Tamanho escolherTamanho() {
        System.out.println("\n=== TAMANHO ===");
        Tamanho[] tamanhos = Tamanho.values();
        for (int i = 0; i < tamanhos.length; i++) {
            System.out.printf("[%d] %s\n", i + 1, tamanhos[i].toString());
        }
        System.out.print("Escolha o tamanho: ");
        int escolha = input.nextInt();
        input.nextLine(); // Limpar buffer
        
        if (escolha > 0 && escolha <= tamanhos.length) {
            return tamanhos[escolha - 1];
        } else {
            System.out.println("Escolha inválida, usando MEDIO como padrão.");
            return Tamanho.MEDIO;
        }
    }
    
    private static Alinhamento escolherAlinhamento() {
        System.out.println("\n=== ALINHAMENTO ===");
        Alinhamento[] alinhamentos = Alinhamento.values();
        for (int i = 0; i < alinhamentos.length; i++) {
            System.out.printf("[%d] %s\n", i + 1, alinhamentos[i].toString());
        }
        System.out.print("Escolha o alinhamento: ");
        int escolha = input.nextInt();
        input.nextLine(); // Limpar buffer
        
        if (escolha > 0 && escolha <= alinhamentos.length) {
            return alinhamentos[escolha - 1];
        } else {
            System.out.println("Escolha inválida, usando ORDEIROS como padrão.");
            return Alinhamento.ORDEIROS;
        }
    }
    
    // Método para cadastrar Pocket (se necessário)
    public static Pocket cadastrarMonstroPocket() {
        System.out.println("\n=== CADASTRO DE MONSTRO POCKET ===");
        
        System.out.print("Nome: ");
        String nome = input.nextLine();
        
        System.out.print("Descrição: ");
        String descricao = input.nextLine();
        
        System.out.print("Teste de Personagem: ");
        int tp = input.nextInt();
        
        System.out.print("Armadura: ");
        int armadura = input.nextInt();
        
        System.out.print("Movimento: ");
        int movimento = input.nextInt();
        
        System.out.print("Iniciativa: ");
        int iniciativa = input.nextInt();
        
        input.nextLine(); // Limpar buffer
        
        return new Pocket(nome, descricao, tp, armadura, movimento, iniciativa);
    }
}