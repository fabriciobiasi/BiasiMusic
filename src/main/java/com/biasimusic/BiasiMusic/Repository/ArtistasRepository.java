package com.biasimusic.BiasiMusic.Repository;

import com.biasimusic.BiasiMusic.Model.Artistas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistasRepository extends JpaRepository< Artistas, Long> {
    Optional<Artistas> findByNomeContainingIgnoreCase(String nomeArtistas);
}
