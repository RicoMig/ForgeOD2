package model.regras;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Ataque;
import model.Old;
import model.Pocket;
import model.enums.Alinhamento;
import model.enums.Conceito;
import model.enums.Habitat;
import model.enums.Tamanho;

public class CrudMonster {
    public static Old createMonster() {
        Scanner input = new Scanner(System.in);
        List<Ataque> ataquePackage = new ArrayList<>();

        try {
            // Basic attributes
            System.out.print("Nome: ");
            String nome = input.nextLine();
            
            System.out.print("Experiência: ");
            int experiencia = input.nextInt();
            
            System.out.print("Movimento: ");
            int movimento = input.nextInt();
            
            System.out.print("Moral: ");
            int moral = input.nextInt();
            
            System.out.print("Armadura: ");
            int armadura = input.nextInt();
            
            System.out.print("Dados de Vida: ");
            int qtdDado = input.nextInt();
            
            System.out.print("Bonus: ");
            int bonus = input.nextInt();
            
            System.out.print("Jogada de Proteção: ");
            int jogadaProtecao = input.nextInt();
            
            input.nextLine(); // Clear the buffer

            // Menu definitions
            String alinhamentoMessage = "===== Alinhamento =====\n" +
                    "[1] Ordeiro\n" +
                    "[2] Neutro\n" +
                    "[3] Caotico\n\nAlinhamento: ";

            String conceitoMessage = "===== Conceito =====\n" +
                    "[1] HUMANOIDE \n" +
                    "[2] HUMANOIDE_MONSTRUOSO \n" +
                    "[3] GIGANTE \n" +
                    "[4] ANIMAL \n" +
                    "[5] INSETO \n" +
                    "[6] CONSTRUCTO \n" +
                    "[7] MORTO_VIVO \n" +
                    "[8] PLANTA \n" +
                    "[9] GOSMA \n" +
                    "[10] DRAGAO \n" +
                    "[11] BESTAS\n\nConceito:";

            String habitatMessage = "===== Habitat =====\n" +
                    "[1] QUALQUER \n" +
                    "[2] PLANICIES \n" +
                    "[3] COLINAS \n" +
                    "[4] MONTANHAS \n" +
                    "[5] PANTANOS \n" +
                    "[6] GELEIRAS \n" +
                    "[7] DESERTOS \n" +
                    "[8] FLORESTAS \n" +
                    "[9] SUBTERRANEOS \n" +
                    "[10] OCEANOS \n" +
                    "[11] EXTRAPLANARES\n\nHabitat:";

            String tamanhoMessage = "===== Tamanho =====\n" +
                    "[1] MIUDO \n" +
                    "[2] PEQUENO \n" +
                    "[3] MEDIO \n" +
                    "[4] GRANDE \n" +
                    "[5] IMENSO \n" +
                    "[6] COLOSSAL \n\nTamanho:";

            // Get category selections
            System.out.print(alinhamentoMessage);
            int alinhamento = input.nextInt();
            
            System.out.print(conceitoMessage);
            int conceito = input.nextInt();
            
            System.out.print(habitatMessage);
            int habitat = input.nextInt();
            
            System.out.print(tamanhoMessage);
            int tamanho = input.nextInt();
            
            input.nextLine(); // Clear the buffer

            // Create monster
            Old oldDragon = new Old(nome, experiencia, movimento, moral, armadura, 
                                qtdDado, bonus, jogadaProtecao, alinhamento, 
                                conceito, habitat, tamanho);

            // Attack management loop
            while (true) {
                System.out.println("\nDeseja cadastrar novo ataque?");
                System.out.println("[s]im");
                System.out.println("[n]ão");
                System.out.print("R: ");
                
                String resposta = input.nextLine().trim().toLowerCase();

                switch (resposta) {
                    case "s":
                    case "sim":
                        Ataque novoAtaque = CrudAtaque.createAtaque();
                        if (novoAtaque != null) {
                            oldDragon.adicionarAtaque(novoAtaque);
                            System.out.println("✅ Ataque adicionado ao monstro!");
                        }
                        break;
                        
                    case "n":
                    case "não":
                    case "nao":
                        System.out.println("✅ Monstro cadastrado com sucesso!");
                        System.out.printf("[%d] %s criado com %d ataque(s)\n", 
                                oldDragon.getID(), oldDragon.getNome(), oldDragon.getAtaques().size());
                        return oldDragon;
                        
                    default:
                        System.out.println("❌ Opção inválida! Digite 's' ou 'n'.");
                }
            }
        } finally {
            // Don't close Scanner here if it's being used elsewhere in the application
            // input.close();
        }
    }

    public static Old finderMonster(List<Old> oldPackage) {
        Scanner input = new Scanner(System.in);
        System.out.print("Valor do ID: "); 
        Long id = input.nextLong();
        input.nextLine(); // Limpar buffer

        for(Old o : oldPackage) {
            // ✅ Usar equals() para comparar Long
            if(o.getID().equals(id)) {
                System.out.println("✅ Monstro encontrado!");
                return o;
            }
        }
        
        // ✅ Só mostra mensagem depois de verificar TODOS os monstros
        System.out.println("❌ Monstro ou Inimigo não localizado");
        return null;
    }

    public static Pocket convetToPocket(Old monster){
        Pocket pocketDragon = new Pocket(
            monster.getID(),
            monster.getNome(), 
            monster.getDescricao(),
            monster.getQtdDadoVida(),
            monster.getBonus(),
            monster.getArmadura(),
            monster.getMovimento(),
            monster.getTamanho()
        );

        pocketDragon.adicionarAtaques(monster.getAtaques());
        return pocketDragon;
    }

}