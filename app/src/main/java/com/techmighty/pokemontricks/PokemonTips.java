package com.techmighty.pokemontricks;

/**
 * Created by ankitvaria on 14/07/16.
 */
public class PokemonTips {
    private String name;
    private int thumbnail;

    public PokemonTips() {
    }

    public PokemonTips(String name, int thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
