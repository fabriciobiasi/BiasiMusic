package com.biasimusic.BiasiMusic.Principal;

import com.biasimusic.BiasiMusic.Model.Artistas;
import com.biasimusic.BiasiMusic.Model.Musicas;
import com.biasimusic.BiasiMusic.Model.TipoArtista;
import com.biasimusic.BiasiMusic.Repository.ArtistasRepository;
import com.biasimusic.BiasiMusic.Repository.MusicasRepository;
import com.biasimusic.BiasiMusic.Services.OpenAi;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.repository.query.parser.Part;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@Service
public class Principal {
    Scanner sc = new Scanner(System.in);

    private final ArtistasRepository artistasRepository;
    private final MusicasRepository musicasRepository;
    private List<Artistas> artistasList = new ArrayList<>();
    private List <Musicas> musicasList = new ArrayList<>();

    public Principal(ArtistasRepository artistasRepository , MusicasRepository musicasRepository) {
        this.artistasRepository = artistasRepository;
        this.musicasRepository = musicasRepository;

        this.artistasList = artistasRepository.findAll();
        this.musicasList = musicasRepository.findAll();
    }

    public void menu() {
        var opcao = -1;
        while (opcao != 9) {
            var menu = """
                    1- Cadastrar artistas
                    2- Cadastrar músicas
                    3- Listar músicas
                    4- Buscar músicas por artista
                    5- Pesquisar dados sobre um artista
                    9- Sair""";

            System.out.println(menu);
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicaArtista();
                    break;
            }
        }
    }




    private void cadastrarArtista() {

        System.out.println("Digite o nome do artista para cadastro: ");
        var nome = sc.nextLine();
        System.out.println("Tipo do artista(Solo/Dupla/Banda): ");
        var tipo = sc.nextLine();

        Artistas artistaCadastro = new Artistas();
        artistaCadastro.setNome(nome);

        TipoArtista tipoArtista = TipoArtista.fromPortugues(tipo);

        if (tipoArtista != null){
            artistaCadastro.setTipoArtista(tipoArtista);
            System.out.println("Artista cadastrado com sucesso!");
            artistasRepository.save(artistaCadastro);
            artistasList = artistasRepository.findAll();
        } else {
            System.out.println("Tipo de artista inválido!");
        }
    }
    private void cadastrarMusica() {

        System.out.println("Nome da música: ");
        var nomeMusica = sc.nextLine();

        if (artistasList.isEmpty()) {
            System.out.println("Não há artistas cadastrados. Primeiro cadastre um artista.");
            return;
        }
        System.out.println("De qual artista? ");
        artistasList.forEach(artistas -> System.out.println(artistas.getNome()));
        var musicaArtistaNome = sc.nextLine();

        Artistas musicaArtista = null;
        for (Artistas artistas : artistasList){
            if (artistas.getNome().equalsIgnoreCase(musicaArtistaNome)){
                musicaArtista = artistas;
                break;
            }
        }
        if (musicaArtista != null){
            Musicas musicaCadastro = new Musicas();
            musicaCadastro.setNome(nomeMusica);
            musicaCadastro.setArtistas(musicaArtista);

            musicasRepository.save(musicaCadastro);
            System.out.println("Música cadastrada!");
            musicasList = musicasRepository.findAll();
        }else {
            System.out.println("Artista não encontrado!");
        }
    }
    private void listarMusicas() {
        if (musicasList.isEmpty()) {
            System.out.println("Não há músicas cadastradas!");
        } else {
            musicasList.forEach(musica -> System.out.println(musica.getNome() + " - " + musica.getArtistas().getNome()));
        }
    }
    private void listarArtistas(){
        if (musicasList.isEmpty()){
            System.out.println("Não há artistas cadastrados!");
        } else {
            artistasList.forEach(artistas -> System.out.println(artistas.getNome() + " - " + artistas.getMusicas()));
        }
    }
    private void buscarMusicaArtista() {
        listarArtistas();
    }

}
