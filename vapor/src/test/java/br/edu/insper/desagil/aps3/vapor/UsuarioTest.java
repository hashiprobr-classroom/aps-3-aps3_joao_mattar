package br.edu.insper.desagil.aps3.vapor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioTest {

    private Usuario usuario;

    @BeforeEach
    void SetUp(){
        usuario = new Usuario("GT","Bruno");
    }

    @Test
    void constroi(){
        assertEquals("GT", usuario.getApelido());
        assertEquals("Bruno", usuario.getNome());
    }

    @Test
    void mudaNome(){
        usuario.setNome("Henrique");
        assertEquals("Henrique", usuario.getNome());
    }
}
