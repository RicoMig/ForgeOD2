import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Old;
import model.enums.Alinhamento;
import model.enums.Conceito;
import model.enums.Habitat;
import model.enums.Tamanho;
import model.regras.Cadastro;

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
                bestiario.add(Cadastro.createMonster());
                System.out.printf("[%d] %s criado com sucesso.\n", bestiario.getFirst().getID(), bestiario.getFirst().getNome()); 
                break;
            case 2:  
                System.out.println("Monstro encontrado"); 
                break;
            case 3:  
                if (!bestiario.isEmpty()) {
                    bestiario.forEach(old -> System.out.println(old));
                } else {
                    System.out.println("Nenhum monstro criado ainda!");
                }
                break;
            case 4:  
                if (!bestiario.isEmpty()) {
                    bestiario.forEach(old -> System.out.println(Cadastro.convetToPocket(old)));
                } else {
                    System.out.println("Nenhum monstro criado ainda!");
                }
                break;
            case 5:  
                System.out.println("Monstro excluido"); 
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

   

    private static void exibirParametrosOD(Old monstro){
        String ficha = "";
        
        ficha += "========================================\n";
        ficha += "[" + monstro.getID() + "] " + monstro.getNome() + " - " + monstro.getExperiencia() + " XP\n";
        ficha += "========================================\n";
        ficha += monstro.getDescricao() + "\n";
        ficha += "========================================\n";
        ficha += "DV: " + monstro.getDadoVida() + " || CA: " + monstro.getArmadura();
        ficha += " || JP: " + monstro.getJogadaProtecao() + " || MV: " + monstro.getMovimento() + " || MO: " + monstro.getMoral() + "\n";
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