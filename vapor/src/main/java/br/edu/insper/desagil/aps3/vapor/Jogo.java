package br.edu.insper.desagil.aps3.vapor;

import java.util.HashMap;
import java.util.Map;

public class Jogo {
    private int id;
    private String nome;
    private Map<String, Integer> avaliacoes;

    public Jogo(int id, String nome){
        this.id = id;
        this.nome = nome;
        this.avaliacoes = new HashMap<>();
    }

    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public void avalia(String apelido, int avaliacao){
        avaliacoes.put(apelido, avaliacao);
    }
    public boolean avaliado(String apelido){
        if (avaliacoes.containsKey(apelido)){
            return true;
        }
        return false;
    }
    public double media(){
        if (avaliacoes.isEmpty()){
            return 0;
        }
        double media = 0;
        for (String apelido : avaliacoes.keySet()){
            media += avaliacoes.get(apelido);
        }
        return media/avaliacoes.size();
    }

}
