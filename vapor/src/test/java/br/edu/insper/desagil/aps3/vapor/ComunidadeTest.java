package br.edu.insper.desagil.aps3.vapor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComunidadeTest {

    private Comunidade comunidade;
    private Usuario usuario1;
    private Usuario usuario2;
    private Usuario usuario3;

    @BeforeEach
    void setUp(){
        usuario1 = new Usuario("GT", "Bruno");
        usuario2 = new Usuario("JH", "João");
        usuario3 = new Usuario("TT", "Thais");
        comunidade = new Comunidade(new ArrayList<>(List.of(usuario1, usuario2, usuario3)));
    }

    @Test
    void controi(){
        List<String> esperado = List.of("GT", "JH", "TT");
        assertEquals(esperado, comunidade.apelidosMembros());
    }
    @Test
    void adicionaUmMembro(){
        Usuario usuario4 = new Usuario("MF", "Manu");
        comunidade.adicionaMembro(usuario4);
        List<String> esperado = List.of("GT", "JH", "TT", "MF");
        assertEquals(esperado, comunidade.apelidosMembros());
    }
    @Test
    void adicionaDoisMembro(){
        Usuario usuario4 = new Usuario("MF", "Manu");
        Usuario usuario5 = new Usuario("BB", "Bibica");
        comunidade.adicionaMembro(usuario4);
        comunidade.adicionaMembro(usuario5);
        List<String> esperado = List.of("GT", "JH", "TT", "MF", "BB");
        assertEquals(esperado, comunidade.apelidosMembros());
    }
}
