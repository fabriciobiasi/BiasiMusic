package com.biasimusic.BiasiMusic.Model;

import com.biasimusic.BiasiMusic.Services.OpenAi;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Artistas")
public class Artistas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private TipoArtista tipoArtista;
    private String descricao;

    public Artistas(){}

    public Artistas(String nome, TipoArtista tipoArtista, String descricao) {
        this.nome = nome;
        this.tipoArtista = tipoArtista;
        this.descricao = OpenAi.descricao(nome).trim();
    }

    @OneToMany(mappedBy = "artistas", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musicas> musicas = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoArtista getTipoArtista() {
        return tipoArtista;
    }

    public void setTipoArtista(TipoArtista tipoArtista) {
        this.tipoArtista = tipoArtista;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Musicas> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musicas> musicas) {
        this.musicas = musicas;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Artista: " + nome + '\'' +
                ", Tipo do Artista: " + tipoArtista +
                ", Descricao: '" + descricao + '\'' +
                ", musicas: " + musicas;
    }
}
