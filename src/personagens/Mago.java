package personagens;

import armas.Magia;

public class Mago extends Personagem{




    public Mago(String nome, int vida, char simbolo) {
        super(nome, vida, simbolo);
        this.arma = new Magia();
    }
}
