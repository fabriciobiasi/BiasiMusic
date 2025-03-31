package com.biasimusic.BiasiMusic.Repository;

import com.biasimusic.BiasiMusic.Model.Artistas;
import com.biasimusic.BiasiMusic.Model.Musicas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicasRepository extends JpaRepository<Musicas, Long> {
    List<Musicas> findByArtistas(Artistas artistas);
}
