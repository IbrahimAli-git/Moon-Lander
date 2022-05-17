package com.codegym.games.moonlander;


import com.codegym.engine.cell.*;

public class MoonLanderGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;


    @Override
    public void initialize() {
        setScreenSize(HEIGHT, WIDTH);
    }
}
