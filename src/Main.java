import armas.*;
import personagens.*;
import Tools.*;


public class Main {
    public static void main(String[] args) {
        String nome;
        int vidas = 15, opcao;
        char simbolo;
        InOut io = new InOut();
        io.MsgDeInformacao("Objetivo do Jogo", "O objetivo do jogo é vencer o Dragão");
        Dragao dragao = new Dragao("Arkanis", 20, 'D');
        Fogo fogoDragao = new Fogo();
        fogoDragao.dano = 4;
        fogoDragao.distancia = 3;
        fogoDragao.nome = "Fogo";
        dragao.setArma(fogoDragao);
        dragao.p.x = 5;
        dragao.p.y = 5;
        opcao = io.leInt("Escolha um Personagem\n(1) Solado {$} , Vida  = 15 , Arma: Revolver, Faca e Desarmado\n(2) General {%}, Vida = 10, Arma: Todas\n(3)LutSUMO {@}, Vida = 25, Arma: Desarmado\n(4) Mago {&}, Vida = 10, Arma = Magia\n(5) Sair");
            if (opcao == 1) {
                nome = io.leString("Nome do Soldado: ");
                io.MsgDeInformacao("Dados de Vida","Quantidade de vidas: 15"  );
                simbolo = '$';
                Soldado soldado = new Soldado(nome, vidas, simbolo);
                Arma arma = soldado.escolherArma();
                soldado.setArma(arma);
                String tabuleiro = soldado.gerarTabuleiro(dragao);
                soldado.jogo(dragao, tabuleiro);
            } else if (opcao == 2) {
                nome = io.leString("Nome do General: ");
                io.MsgDeInformacao("Dados de Vida","Quantidade de vidas: 10"  );
                simbolo = '%';
                General general = new General(nome, vidas - 5, simbolo);
                Arma arma = general.escolherArma();
                general.setArma(arma);
                String tabuleiro = general.gerarTabuleiro(dragao);
                general.jogo(dragao, tabuleiro);
            } else if (opcao == 3) {
                nome = io.leString("Nome do Lutador de Sumo: ");
                io.MsgDeInformacao("Dados de Vida","Quantidade de vidas: 25"  );
                simbolo = '@';
                LutSUMO lutSUMO = new LutSUMO(nome, vidas + 10, simbolo);
                Arma arma = lutSUMO.escolherArma();
                lutSUMO.setArma(arma);
                String tabuleiro = lutSUMO.gerarTabuleiro(dragao);
                lutSUMO.jogo(dragao, tabuleiro);
            } else if(opcao == 4){
                nome = io.leString("Nome do Mago: ");
                io.MsgDeInformacao("Dados de Vida","Quantidade de vidas: 10"  );
                simbolo = '&';
                Mago mago = new Mago(nome, vidas - 5, simbolo);
                String tabuleiro = mago.gerarTabuleiro(dragao);
                mago.jogo(dragao, tabuleiro);
            }
        }
    }

