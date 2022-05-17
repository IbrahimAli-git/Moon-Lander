package com.codegym.games.moonlander;


import com.codegym.engine.cell.*;

public class MoonLanderGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;


    @Override
    public void initialize() {
        setScreenSize(HEIGHT, WIDTH);
        createGame();
    }

    private void createGame(){
        drawScene();
    }

    private void drawScene(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellColor(i, j, Color.ORANGE);
            }
        }
    }


}
