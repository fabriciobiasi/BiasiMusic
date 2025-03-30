package com.biasimusic.BiasiMusic.Model;

public enum TipoArtista {
    SOLO("Solo"),
    DUPLA("Dupla"),
    BANDA("Banda");

    private String tipoPortugues;

    TipoArtista(String tipoPortugues) {
        this.tipoPortugues = tipoPortugues;
    }
    public static TipoArtista fromPortugues(String text) {
        for (TipoArtista tipoArtista : TipoArtista.values()) {
            if (tipoArtista.tipoPortugues.equalsIgnoreCase(text)) {
                return tipoArtista;
            }
        }
        throw new IllegalArgumentException("Tipo de artista inválido: " + text);
    }
}
