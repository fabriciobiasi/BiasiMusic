package com.biasimusic.BiasiMusic.Repository;

import com.biasimusic.BiasiMusic.Model.Musicas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicasRepository extends JpaRepository<Musicas, Long> {
}
