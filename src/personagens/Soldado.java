package personagens;

import Tools.InOut;
import armas.*;

public class Soldado extends Personagem {

    public Soldado(String nome, int vida, char simbolo) {
        super(nome, vida, simbolo);
    }

    @Override
    public Arma escolherArma() {
        int opcao;
        Arma arma;

        opcao = InOut.leInt("Escolha uma Arma:\n(1)Faca\n(2)Desarmado\n(3)Revolver");
        switch (opcao) {
            case 1:
                arma = new Faca();
                arma.nome = "Faca";
                arma.dano = 9;
                arma.distancia = 2;
                return arma;
            case 2:
                arma = new Desarmado();
                arma.nome = "Desarmado";
                arma.dano = 10;
                arma.distancia = 1;
                return arma;
            case 3:
                arma = new Revolver();
                arma.nome = "Revolver";
                arma.dano = 6;
                arma.distancia = 4;
                return arma;
            default:
                throw new IllegalStateException("Unexpected value: " + opcao);
        }


    }
}
