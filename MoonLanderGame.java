package com.codegym.games.moonlander;

import com.codegym.engine.cell.*;

public class MoonLanderGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private Rocket rocket;
    private GameObject landscape;
    private boolean isUpPressed;
    private boolean isLeftPressed;
    private boolean isRightPressed;
    private GameObject platform;
    private boolean isGameStopped;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(HEIGHT, WIDTH);
        createGame();
        showGrid(false);
    }

    private void createGame() {
        createGameObjects();
        drawScene();
        setTurnTimer(50);
        isUpPressed = false;
        isLeftPressed = false;
        isRightPressed = false;
        isGameStopped = false;
        score = 1000;
        setScore(score);
    }

    private void drawScene() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellColor(i, j, Color.ORANGE);
            }
        }
        rocket.draw(this);
        landscape.draw(this);
    }

    private void check(){
        if (rocket.isCollision(landscape) && !(rocket.isCollision(platform) && rocket.isStopped())) {
            gameOver();
        }
        if (rocket.isCollision(platform) && rocket.isStopped()){
            win();
        }
    }

    private void win(){
        rocket.land();
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "You've Won", Color.BLACK, 75);
        stopTurnTimer();
    }

    private void gameOver(){
        rocket.crash();
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "Game Over", Color.BLACK, 75);
        stopTurnTimer();
        score = 0;
        setScore(score);
    }

    @Override
    public void onTurn(int step) {
        rocket.move(isUpPressed, isLeftPressed, isRightPressed);
        check();
        drawScene();
        if (score > 0){
            score--;
        }
        setScore(score);
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if (x <= 0 || y <= 0 || x >= WIDTH || y >= HEIGHT) {

        } else {
            super.setCellColor(x, y, color);
        }
    }

    private void createGameObjects() {
        rocket = new Rocket(WIDTH / 2, 0);
        landscape = new GameObject(0, 25, ShapeMatrix.LANDSCAPE);
        platform = new GameObject(23, MoonLanderGame.HEIGHT -1, ShapeMatrix.PLATFORM);
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.SPACE && isGameStopped){
            createGame();
            return;
        }
        switch (key) {
            case UP:
                isUpPressed = true;
                break;
            case LEFT:
                isLeftPressed = true;
                isRightPressed = false;
                break;
            case RIGHT:
                isRightPressed = true;
                isLeftPressed = false;
                break;
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        switch (key) {
            case UP:
                isUpPressed = false;
                break;
            case LEFT:
                isLeftPressed = false;
                break;
            case RIGHT:
                isRightPressed = false;
                break;
        }
    }
}
