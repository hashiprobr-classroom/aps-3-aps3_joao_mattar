package br.edu.insper.desagil.aps3.vapor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComunidadeDeJogoTest {

    private Comunidade comunidade;
    private Usuario usuario1;
    private Usuario usuario2;
    private Usuario usuario3;
    private Jogo jogo;

    @BeforeEach
    void setUp(){
        usuario1 = new Usuario("TT", "Thais");
        usuario2 = new Usuario("MF", "Manu");
        usuario3 = new Usuario("BB", "Bibica");
        jogo = new Jogo(1, "Brawl Stars");
        comunidade = new ComunidadeDeJogo(new ArrayList<>(List.of()), jogo);
    }

    @Test
    void adicionaDoisInvalidos(){
        comunidade.adicionaMembro(usuario1);
        comunidade.adicionaMembro(usuario2);
        List<String> esperado = List.of();
        assertEquals(esperado, comunidade.apelidosMembros());
    }
    @Test
    void adicionaUmInvalidoUmValido(){
        jogo.avalia(usuario1.getApelido(),10);
        comunidade.adicionaMembro(usuario1);
        comunidade.adicionaMembro(usuario2);
        List<String> esperado = List.of("TT");
        assertEquals(esperado, comunidade.apelidosMembros());
    }
    @Test
    void adicionaDoisValidos(){
        jogo.avalia(usuario1.getApelido(),10);
        jogo.avalia(usuario2.getApelido(),0);
        comunidade.adicionaMembro(usuario1);
        comunidade.adicionaMembro(usuario2);
        List<String> esperado = List.of("TT", "MF");
        assertEquals(esperado, comunidade.apelidosMembros());
    }
}
