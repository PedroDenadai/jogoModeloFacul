package personagens;

import Tools.InOut;
import armas.*;

public class LutSUMO extends Personagem {

    public LutSUMO(String nome, int vida, char simbolo) {
        super(nome, vida, simbolo);
    }


    @Override
    public Arma escolherArma() {
        InOut.MsgDeInformacao("Info de Arma", "Lutador de sumo só luta desarmado");
        Desarmado desarmado = new Desarmado();
        desarmado.dano = 10;
        desarmado.distancia = 1;
        return desarmado;
    }
}