package br.edu.insper.desagil.aps3.vapor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LojaTest {

    private Loja loja;
    private Usuario usuario;
    private Usuario dono;
    private Jogo jogo1;
    private Jogo jogo2;
    private Jogo jogo3;
    private List<Jogo> jogos;

    @BeforeEach
    void setUp(){
        dono = new Usuario("Clerio", "Henrique");
        usuario = new Usuario("GT", "Bruno");
        jogo1 = new Jogo(1, "Brawl Stars");
        jogo2 = new Jogo(2, "Rainbow Six");
        jogo3 = new Jogo(3, "Roblox");
        jogos = new ArrayList<>();
        jogos.add(jogo1);
        jogos.add(jogo2);
        jogos.add(jogo3);
        loja = new Loja(dono, jogos);
    }

    @Test
    void constroi(){
        assertEquals(dono, loja.getDono());
        assertEquals(0, loja.numeroAvaliados(dono));
    }
    @Test
    void umUsuarioAvaliaUmJogo(){
        jogo1.avalia("Clerio", 10);
        assertEquals(1, loja.numeroAvaliados(dono));
    }
    @Test
    void umUsuarioAvaliaDoisJogos(){
        jogo1.avalia("Clerio", 10);
        jogo2.avalia("Clerio", 10);
        assertEquals(2, loja.numeroAvaliados(dono));
    }
    @Test
    void doisUsuariosAvaliamUmJogo(){
        jogo1.avalia("Clerio", 10);
        jogo1.avalia("GT", 5);
        assertEquals(1, loja.numeroAvaliados(dono));
        assertEquals(1, loja.numeroAvaliados(usuario));
    }

    @Test
    void doisUsuariosAvaliamDoisJogos(){
        jogo1.avalia("Clerio", 10);
        jogo2.avalia("GT", 5);
        assertEquals(1, loja.numeroAvaliados(dono));
        assertEquals(1, loja.numeroAvaliados(usuario));
    }
}
