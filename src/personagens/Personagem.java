package personagens;

import Tools.InOut;
import Tools.Posicao;
import armas.*;

import static java.lang.Math.atan;
import static java.lang.Math.pow;

public class Personagem {
    Arma arma;
    public int vida;
    public String nome;
    public Posicao p;
    public char simbolo;

    public int qtdAndado;

    public Personagem(String nome, int vida, char simbolo){
        this.nome = nome;
        this.vida = vida;
        Posicao p = new Posicao(1, 1);
        this.p = p;
        this.simbolo = simbolo;
    }

    public void desenhar(){

    }

    public void falar(){

    }

    public void setArma(Arma arma){
        this.arma = arma;
    }

    public int calcularDistancia(Personagem p){
        int xa = p.p.x;
        int ya = p.p.y;
        int xb = this.p.x;
        int yb = this.p.y;

        return (int) Math.pow(Math.pow(xb - xa, 2) + Math.pow(yb - ya, 2) , 0.5);
    }

    public String mostrarInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.nome).append("\n\tArma: ")
                .append(this.arma.nome).append("\n\t\tDano da Arma: " + this.arma.dano)
                .append("\n\t\tDistancia: " + this.arma.distancia)
                .append("\n\tVidas: ").append(vida)
                .append("\nPosicao\tX: ").append(p.x).append("\tY: ").append(p.y);
        return sb.toString();
    }

    public void jogo(Dragao inimigo, String tabuleiro) {
        String characterInfo = "Personagem: \n" + this.mostrarInfo();
        String enemyInfo = "\n\n*****************\nInimigo: \n" + inimigo.mostrarInfo();
        int distancia = this.calcularDistancia(inimigo);
        String novoTabuleiro;
        StringBuilder stringBuild = new StringBuilder();
        stringBuild.append(characterInfo).append(enemyInfo).append("\n\nDistancia do Inimigo: " + distancia + "\n").append("\nMapa:  \n"+ tabuleiro);
        String opcao = InOut.leString(String.valueOf(stringBuild) + "\n(W)Cima \t(A)Esquerda\n(S)Baixo\t(D)Direita\n(X)Atacar");
        opcao.toLowerCase();
        switch (opcao){
            case "a":
                if(inimigo.vida <= 0){
                    InOut.MsgDeInformacao("Acabou", "Voce venceuuuu o Dragao");
                    break;
                }
                 tabuleiro = this.andar(inimigo, p.x - 1, p.y);
                 this.qtdAndado++;
                 inimigo.andarDragao();
                 inimigo.atacar(this);
                if(this.vida > 0){
                    this.jogo(inimigo, tabuleiro);
                    break;
                }else{
                    InOut.MsgDeInformacao("Fim de Jogo", "Acabou suas vidas");
                    break;
                }
            case "w":
                if(inimigo.vida <= 0){
                    InOut.MsgDeInformacao("Acabou", "Voce venceuuuu o Dragao");
                    break;
                }
                tabuleiro = this.andar(inimigo, p.x, p.y - 1);
                this.qtdAndado++;
                inimigo.andarDragao();
                inimigo.atacar(this);
                if(this.vida > 0){
                    this.jogo(inimigo, tabuleiro);
                    break;
                }else{
                    InOut.MsgDeInformacao("Fim de Jogo", "Acabou suas vidas");
                    break;
                }
            case "s":
                if(inimigo.vida <= 0){
                    InOut.MsgDeInformacao("Acabou", "Voce venceuuuu o Dragao");
                    break;
                }
                tabuleiro = this.andar(inimigo, p.x , p.y + 1);
                this.qtdAndado++;
                inimigo.andarDragao();
                inimigo.atacar(this);
                if(this.vida > 0){
                    this.jogo(inimigo, tabuleiro);
                    break;
                }else{
                    InOut.MsgDeInformacao("Fim de Jogo", "Acabou suas vidas");
                    break;
                }
            case "d":
                if(inimigo.vida <= 0){
                    InOut.MsgDeInformacao("Acabou", "Voce venceuuuu o Dragao");
                    break;
                }
                tabuleiro = this.andar(inimigo, p.x + 1, p.y);
                this.qtdAndado++;
                inimigo.andarDragao();
                inimigo.atacar(this);
                if(this.vida > 0){
                    this.jogo(inimigo, tabuleiro);
                    break;
                }else{
                    InOut.MsgDeInformacao("Fim de Jogo", "Acabou suas vidas");
                    break;
                }
            case "x":
                if(this.calcularDistancia(inimigo) <= this.arma.distancia && this.vida > 0){
                    InOut.MsgDeInformacao("Detalhes do Ataque", "Causou " + this.arma.dano + " dano ao Dragao");
                    if(inimigo.vida <= 0){
                        InOut.MsgDeInformacao("Acabou", "Voce venceuuuu o Dragao");
                        break;
                    }
                    atacar(inimigo);
                    inimigo.andarDragao();
                    novoTabuleiro = this.andar(inimigo, p.x, p.y);
                    if(this.vida > 0){
                        this.jogo(inimigo, novoTabuleiro);
                    }
                    break;
                }else{
                    tabuleiro = this.andar(inimigo, p.x, p.y);
                    if(this.vida > 0){
                        this.jogo(inimigo, tabuleiro);
                    }
                    break;
                }
            default:
                if(inimigo.vida <= 0){
                    InOut.MsgDeInformacao("Acabou", "Voce venceuuuu o Dragao");
                    break;
                }
                this.jogo(inimigo, tabuleiro);
        }
    }

    public String andar(Personagem inimigo, int x, int y){
        if (x >= 0 && x < 30 && y >= 0 && y < 7) {
            p.x = x;
            p.y = y;
        }

        return gerarTabuleiro(inimigo);
    }



    public void atacar(Personagem inimigo){
        if(this.calcularDistancia(inimigo) <= this.arma.distancia){
            inimigo.vida -= this.arma.dano;
        }
    }


    public String gerarTabuleiro(Personagem inimigo) {
        char[][] board = new char[7][30];
        int x, y, xI, yI;
        x = this.p.x;
        y = this.p.y;
        xI = inimigo.p.x;
        yI = inimigo.p.y;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 30; j++) {
                if (i == y && j == x) {
                    board[i][j] = this.simbolo;
                } else if (i == yI && j == xI) {
                    board[i][j] = inimigo.simbolo;
                } else {
                    board[i][j] = '*';
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 30; j++) {
                stringBuilder.append(board[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    public Arma escolherArma(){
        int opcao;
        Arma arma;

        opcao = InOut.leInt("Escolha uma Arma:\n(1)Fuzil\n(2)Faca\n(3)Desarmado\n(4)Revolver");
        switch (opcao){
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
