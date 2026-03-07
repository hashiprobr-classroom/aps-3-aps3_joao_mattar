package br.edu.insper.desagil.aps3.vapor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JogoTest {
    private static final double DELTA = 0.01;
    private Jogo jogo;
    private Usuario usuario1;
    private Usuario usuario2;

    @BeforeEach
    void setUp(){
        jogo = new Jogo(0, "Brawl Stars");
        usuario1 = new Usuario("GT", "Bruno");
        usuario2 = new Usuario("JH", "João");
    }

    @Test
    void constroi(){
        assertEquals(0, jogo.getId());
        assertEquals("Brawl Stars", jogo.getNome());
        assertEquals(0, jogo.media(), DELTA);
    }

    @Test
    void avaliaUmaVez (){
        jogo.avalia(usuario1.getApelido(), 3);

        assertTrue(jogo.avaliado(usuario1.getApelido()));
        assertFalse(jogo.avaliado(usuario2.getApelido()));
        assertEquals(3, jogo.media(), DELTA);
    }

    @Test
    void avaliaDuasVezes(){
        jogo.avalia(usuario1.getApelido(), 3);
        jogo.avalia(usuario2.getApelido(), 4);
        assertTrue(jogo.avaliado(usuario1.getApelido()));
        assertTrue(jogo.avaliado(usuario2.getApelido()));
        assertEquals(3.5, jogo.media(), DELTA);
    }

    @Test
    void avaliaTresVezes(){
        jogo.avalia(usuario1.getApelido(), 3);
        jogo.avalia(usuario2.getApelido(), 4);
        jogo.avalia(usuario1.getApelido(), 5);
        assertEquals(4.5, jogo.media(), DELTA);
    }
}
