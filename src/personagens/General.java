package personagens;

import Tools.InOut;
import armas.*;

public class General extends Personagem{

    public General(String nome, int vida, char simbolo) {
        super(nome, vida, simbolo);
    }


    @Override
    public Arma escolherArma() {
        int opcao;
        Arma arma;

        opcao = InOut.leInt("Escolha uma Arma:\n(1)Fuzil\n(2)Faca\n(3)Desarmado\n(4)Revolver");
        switch (opcao) {
            case 1:
                arma = new Fuzil();
                arma.nome = "Fuzil";
                arma.dano = 5;
                arma.distancia = 7;
                return arma;
            case 2:
                arma = new Faca();
                arma.nome = "Faca";
                arma.dano = 9;
                arma.distancia = 2;
                return arma;
            case 3:
                arma = new Desarmado();
                arma.nome = "Desarmado";
                arma.dano = 1;
                arma.distancia = 1;
                return arma;
            case 4:
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

