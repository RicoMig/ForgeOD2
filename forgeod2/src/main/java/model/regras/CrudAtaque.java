package model.regras;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Ataque;

public class CrudAtaque {
    public static void main(String[] args) {
        Scanner command = new Scanner(System.in);
        List<Ataque> ataquePackage = new ArrayList<>();
        
        ataquePackage.add(new Ataque( 1,"Garra",8,2,6,5,null));
        ataquePackage.add(new Ataque( 1,"Mordida",8,1,10,7,null));
        ataquePackage.add(new Ataque( 1,"Pique Pequena",5,1,8,0,"Veneno"));
        ataquePackage.add(new Ataque( 1,"Besta de Mão",7,1,4,0,"Veneno"));

        while(true){
            System.out.print("Deseja criar um novo ataque?\n[s]im\n[n]ão\n"+"-".repeat(10)+"\nCMD:");

            switch(command.next().charAt(0)){
                case 's':
                    ataquePackage.add(createAtaque());
                    break;
                case 'n':
                    ataquePackage.forEach(a -> System.out.println(a));
                    System.exit(0);
            }
        }

        
    }

    public static Ataque createAtaque(){
        Scanner input = new Scanner(System.in);

        

        System.out.print("Nº de Ataques: "); int nAtaques = input.nextInt();

        input.nextLine();
        System.out.print("Tipo de Ataque: "); String tipoAtaque = input.nextLine();
        System.out.print("Bônus de Ataque: "); int bAtaque = input.nextInt();
        System.out.print("Dano Base (quantidade de Dados): "); int qtdDano = input.nextInt();
        System.out.print("Dano Base (quantidade de Faces):"); int qtdFace = input.nextInt();
        System.out.print("Bonus de Dano: "); int bonusDano = input.nextInt();

        input.nextLine();
        System.out.print("Efeito do Dano "); String efeitoDano = input.nextLine();

        return new Ataque(nAtaques,tipoAtaque, bAtaque, qtdDano, qtdFace,bonusDano,efeitoDano);
    }
}
