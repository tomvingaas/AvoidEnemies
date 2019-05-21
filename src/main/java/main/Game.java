package main;

import java.awt.*;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1550691097823471818L;
    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 12 * 9;

    private Thread thread;
    private boolean running = false;

    public Game(){
        new Window(WIDTH, HEIGHT, "Game", this);
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try {
            thread.join();
            running = false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

    }

    public static void main(String[] args) {
        new Game();
    }
}
