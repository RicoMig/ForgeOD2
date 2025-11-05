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
        List<Old> oldPackage = new ArrayList<Old>();
        List<Pocket>pocketPackage = new ArrayList<Pocket>();
        

        Old harpia = new Old("Harpia",420,6,10,15,7,0,7,Alinhamento.CAOTICOS,Conceito.HUMANOIDE_MONSTRUOSO,Habitat.FLORESTA,Tamanho.MEDIO);

        Old goblin = new Old("Goblin",15,6,7,11,1,-1,5,Alinhamento.CAOTICOS,Conceito.HUMANOIDE,Habitat.QUALQUER,Tamanho.PEQUENO);

        Old wyvern = new Old("Wyvern",460,9,9,17,7,0,12,Alinhamento.NEUTROS,Conceito.DRAGAO,Habitat.FLORESTA,Tamanho.IMENSO);
        
        oldPackage.add(harpia);
        oldPackage.add(goblin);
        oldPackage.add(wyvern);

        for(Old o : oldPackage){
            pocketPackage.add(oldTOpocket(o));
        }

        System.out.println("\n\n\n==================== Old Dragon 2nd ====================");
        oldPackage.forEach(old -> System.out.println(old));
        System.out.println("\n\n\n==================== Pocket Dragon ====================");
        pocketPackage.forEach(pocket -> System.out.println(pocket));
    }
    
    public static Old createOld(){

        return new Old(
            null,
            0,
            0,
            0,
            0,
            0,
            0,
            0, 
            null,
            null, 
            null,
            null
        );
    }

    public static Pocket createPocket(){
        return new Pocket(
            null, 
            null,
            0,
            0, 
            0, 
            0
        );
    }

    public static Pocket oldTOpocket(Old monster){

        return new Pocket(
            monster.getNome(), 
            monster.getDescricao(),
            monster.getQtdDadoVida()*5,
            monster.getArmadura()-2,
            monster.getMovimento(),
            0
            //caso monster.getTamanho == Tamanho.MIUDO retorna 8;
            //caso monster.getTamanho == Tamanho.PEQUENO retorna 8;
            //caso monster.getTamanho == Tamanho.MEDIA retorna 5;
            //caso monster.getTamanho == Tamanho.GRANDE retorna 2;
            //caso monster.getTamanho == Tamanho.IMENSA retorna 2;
            //caso monster.getTamanho == Tamanho.COLOSSAL retorna 2;
        );
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
        monstro.setMovimento(input.nextInt());
        
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