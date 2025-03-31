package com.biasimusic.BiasiMusic.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "Musicas")
public class Musicas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "artistas_id")
    private Artistas artistas;

    public Musicas(){}

    public Musicas(String nome, Artistas artistas){
        this.nome = nome;
        this.artistas = artistas;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Artistas getArtistas() {
        return artistas;
    }

    public void setArtistas(Artistas artistas) {
        this.artistas = artistas;
    }

    @Override
    public String toString() {
        return "Musica: " + nome + '\'' +
                ", artista: " + artistas;
    }
}
