package br.edu.insper.desagil.aps3.vapor;

import java.util.List;

public class Loja {
    private Usuario dono;
    private List<Jogo> jogos;

    public Loja(Usuario dono, List<Jogo> jogos){
        this.dono = dono;
        this.jogos = jogos;
    }

    public Usuario getDono(){
        return dono;
    }
    public int numeroAvaliados(Usuario usuario){
        String apelido = usuario.getApelido();
        int contador = 0;
        for(Jogo jogo: jogos){
            if (jogo.avaliado(apelido)){
                contador += 1;
            }
        }
        return contador;
    }
}
