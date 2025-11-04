import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Old;
import model.enums.Alinhamento;
import model.enums.Conceito;
import model.enums.Habitat;
import model.enums.Tamanho;

public class menu {
    private static List<Old> bestiario = new ArrayList<>();
    
    public static void main(String[] args) {
        menuTela();
    }

    private static void menuTela(){
        Scanner input = new Scanner(System.in);
        
        String menuLayout = "";
        menuLayout += "========================================\n";
        menuLayout += "                    MENU\n";
        menuLayout += "========================================\n";
        menuLayout += "[1] Criar Monstro\n";
        menuLayout += "[2] Procurar Monstro\n";
        menuLayout += "[3] Exibir Old Dragon Parametros\n";  
        menuLayout += "[4] Exibir Pocket Dragon Parametros\n"; 
        menuLayout += "[5] Excluir monstro\n";
        menuLayout += "[0] Desligar\n";
        menuLayout += "========================================\n";
        menuLayout += "CMD: ";
        System.out.print(menuLayout); 
        
        escolha(input.nextInt());
        menuTela();
    }
    
    private static void escolha(int cmd) {
        switch (cmd) {
            case 0: 
                System.out.println("Desligando...");
                System.exit(0);
                break;
            case 1:  
                Old m = cadastrarMonstro("Piprico");
                bestiario.add(m);
                System.out.printf("[%d] %s criado com sucesso.\n", m.getID(), m.getNome()); 
                break;
            case 2:  
                System.out.println("Monstro encontrado"); 
                break;
            case 3:  
                if (!bestiario.isEmpty()) {
                    exibirParametrosOD(bestiario.get(0));
                } else {
                    System.out.println("Nenhum monstro criado ainda!");
                }
                break;
            case 4:  
                System.out.println("Parametros do monstro no Pocket Dragon"); 
                break;
            case 5:  
                System.out.println("Monstro excluido"); 
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private static Old cadastrarMonstro(String nome){
        Old monstro = new Old();
        monstro.setId();
        monstro.setNome(nome);
        monstro.setConceito(Conceito.ANIMAL);
        monstro.setHabitat(Habitat.PLANICIES);  // ← CORRETO AGORA
        monstro.setTamanho(Tamanho.MEDIO);
        monstro.setAlinhamento(Alinhamento.ORDEIROS);  // ← CORRETO AGORA
        monstro.setExperiencia(35);
        monstro.setMovimento("10m");
        monstro.setMoral(9);
        monstro.setArmadura(10);
        monstro.setDadoVida("2d6");
        monstro.setJogadaProtecao(5);
        
        List<String> ataques = Arrays.asList(
            "1x Patada +2 (1d4)",
            "CORRER: pode correr com movimento 20 durante um turno, ou 12 durante 2 turnos",
            "CARGA: carrega até 2.500 moedas"
        );
        monstro.setAtaques(ataques);

        return monstro;
    }

    private static void exibirParametrosOD(Old monstro){
        String ficha = "";
        
        ficha += "========================================\n";
        ficha += "[" + monstro.getID() + "] " + monstro.getNome() + "- "+monstro.getExperiencia()+ "\n";
        ficha += "========================================\n";
        ficha += monstro.getDescricao() + "\n";
        ficha += "========================================\n";
        ficha += "DV: " + monstro.getDadoVida() + " || CA: " + monstro.getArmadura();
        ficha += " || JP: " + monstro.getJogadaProtecao() + " || MV: " + monstro.getMovimento() + " || MO: " + monstro.getMoral() +"\n";
        ficha += "========================================\n";
        
        if (monstro.getAtaques() != null && !monstro.getAtaques().isEmpty()) {
            ficha += "Ataques:\n";
            for (String ataque : monstro.getAtaques()) {
                ficha += "- " + ataque + "\n";
            }
            ficha += "========================================\n";
        }

        System.out.println(ficha);
    }
}