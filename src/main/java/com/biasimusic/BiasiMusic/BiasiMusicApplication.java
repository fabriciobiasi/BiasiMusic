package com.biasimusic.BiasiMusic;

import com.biasimusic.BiasiMusic.Principal.Principal;
import com.biasimusic.BiasiMusic.Repository.ArtistasRepository;
import com.biasimusic.BiasiMusic.Repository.MusicasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BiasiMusicApplication implements CommandLineRunner {
	@Autowired
	private ArtistasRepository artistasRepository;
	@Autowired
	private MusicasRepository musicasRepository;

	public static void main(String[] args) {
		SpringApplication.run(BiasiMusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(artistasRepository, musicasRepository);
		principal.menu();
	}
}
