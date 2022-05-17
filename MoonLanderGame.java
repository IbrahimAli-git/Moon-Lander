package com.codegym.games.moonlander;


import com.codegym.engine.cell.*;

public class MoonLanderGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private Rocket rocket;
    private GameObject landscape;

    @Override
    public void initialize() {
        setScreenSize(HEIGHT, WIDTH);
        createGame();
        showGrid(false);
    }

    private void createGame(){
        createGameObjects();
        drawScene();
    }

    private void drawScene(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellColor(i, j, Color.ORANGE);
            }
        }
        rocket.draw(this);
        landscape.draw(this);
    }

    private void createGameObjects(){
        rocket = new Rocket(WIDTH/2, 0);
        landscape = new GameObject(0, 25, ShapeMatrix.LANDSCAPE);
    }
}

