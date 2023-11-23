package armas;

import personagens.*;

public class Arma {
    public String nome;
    public int dano;
    public int distancia;

    public void usarArma(Personagem alvo){
        alvo.vida--;
    }
}
