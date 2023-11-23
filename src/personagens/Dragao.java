package personagens;

import Tools.InOut;
import armas.Fogo;

import java.util.Random;

public class Dragao extends Personagem{

    public Dragao(String nome, int vida,  char simbolo) {
        super(nome, vida, simbolo);
        arma = new Fogo();
        arma.nome = "Magia de Fogo";
        arma.dano = 2;
    }

    @Override
    public void atacar(Personagem persoPrincipal){
        if(persoPrincipal.qtdAndado % 2 == 0){
            if(calcularDistancia(persoPrincipal) <= 3){
                InOut.MsgDeInformacao("Ataque do Dragao", "O Dragao te ATACOU\n Menos " + this.arma.dano + " de vida");
                persoPrincipal.vida -= this.arma.dano;
                this.andarDragao();
            }
        }
    }


    public void andarDragao(){
        Random random  = new Random();
        int x;
        int y;
        x = random.nextInt(3);
        y = random.nextInt(3);
        if (x >= 0 && x < 30 && y >= 0 && y < 7) {
            this.p.x = x;
            this.p.y = y;
        }

    }
}
