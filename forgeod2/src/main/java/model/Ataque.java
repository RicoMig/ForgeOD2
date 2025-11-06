package model;
import java.util.Random;
public class Ataque {
    Random generate = new Random();

    private Long id;
    private int numeroAtaques;
    private String tipoAtaque;
    private int bonusAtaque;
    private int qtdDanoBase;
    private int faceDanoBase;
    private String DanoBase;
    private int bonusDano;
    private String efeitoDano;

    public Ataque() {
        super();
    }

    public Ataque(int numeroAtaques,String tipoAtaque, int bonusAtaque,int qtdDanoBase, int faceDanoBase, int bonusDano, String efeitoDano){
        this.id = generate.nextLong(1,9999);
        this.numeroAtaques = numeroAtaques;
        this.tipoAtaque = (tipoAtaque != null && !tipoAtaque.trim().isEmpty()) ? tipoAtaque.trim() : "Ataque";
        this.bonusAtaque = bonusAtaque;
        this.qtdDanoBase = qtdDanoBase;
        this.faceDanoBase = faceDanoBase;
        this.DanoBase = qtdDanoBase+"d"+faceDanoBase;
        this.bonusDano = bonusDano;
        this.efeitoDano = efeitoDano != null && !efeitoDano.trim().isEmpty() ? efeitoDano.trim() : null;
    }

    @Override
    public String toString() {
        return "["+id+"] "+numeroAtaques+"x "+tipoAtaque+"+"+bonusAtaque+" ("+DanoBase+"+"+bonusDano+"+"+efeitoDano+")";
    }

    
}
