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
    public static Old createMonster(){
        Scanner input = new Scanner(System.in);

        System.out.print("Nome: "); String nome = input.nextLine();
        System.out.print("Experiência: "); int experiencia = input.nextInt();
        System.out.print("Moviemnto: "); int movimento = input.nextInt();
        System.out.print("Moral: ");int moral = input.nextInt();
        System.out.print("Armadura: "); int armadura = input.nextInt();
        System.out.print("Dados de Vida: "); int qtdDado = input.nextInt();
        System.out.print("Bonus: "); int bonus = input.nextInt();
        System.out.print("Jogada de Proteção: "); int jogadaProtecao = input.nextInt();
        
        String alinhamentoMessage = "===== Alinhamento =====\n"+
                        "[1] Ordeiro\n"+
                        "[2] Neutro\n"+
                        "[3] Caotico\n\nAlinhamento: ";

        String conceitoMessage = "===== Conceito =====\n"+
                        "[1] HUMANOIDE \n"+
                        "[2] HUMANOIDE_MONSTRUOSO \n"+
                        "[3] GIGANTE \n"+
                        "[4] ANIMAL \n"+
                        "[5] INSETO \n" + 
                        "[6] CONSTRUCTO \n" +
                        "[7] MORTO_VIVO \n" +
                        "[8] PLANTA \n" +
                        "[9] GOSMA \n" +
                        "[10] DRAGAO \n"+
                        "[11] BESTAS\n\nConceito:";

        String habitatMessage = "===== Habitat =====\n"+
                        "[1] QUALQUER \n"+
                        "[2] PLANICIES \n"+
                        "[3] COLINAS \n"+
                        "[4] MONTANHAS \n"+
                        "[5] PANTANOS \n" + 
                        "[6] GELEIRAS \n" +
                        "[7] DESERTOS \n" +
                        "[8] FLORESTAS \n" +
                        "[9] SUBTERRANEOS \n" +
                        "[10] OCEANOS \n"+
                        "[11] EXTRAPLANARES\n\nHabitat:";

        String tamanhoMessage = "===== Tamanho =====\n"+
                        "[1] MIUDO \n"+
                        "[2] PEQUENO \n"+
                        "[3] MEDIO \n"+
                        "[4] GRANDE \n"+
                        "[5] IMENSO \n" + 
                        "[6] COLOSSAL \n\nTamanho:";
        
        
        System.out.print(alinhamentoMessage); int alinhamento = input.nextInt();
        System.out.print(conceitoMessage);int conceito = input.nextInt();
        System.out.print(habitatMessage);int habitat = input.nextInt();
        System.out.print(tamanhoMessage);int tamanho = input.nextInt();

        return new Old(nome,experiencia,movimento,moral,armadura,qtdDado,bonus,jogadaProtecao,alinhamento,conceito,habitat,tamanho);
    }

    public static Pocket convetToPocket(Old monster){

        return new Pocket(
            monster.getID(),
            monster.getNome(), 
            monster.getDescricao(),
            monster.getQtdDadoVida(),
            monster.getArmadura()-2,
            monster.getMovimento(),
            monster.getTamanho()
        );
    }
}