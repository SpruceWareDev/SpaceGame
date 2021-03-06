package me.spruce.game;

import me.spruce.game.display.Display;
import me.spruce.game.font.Fonts;
import me.spruce.game.gui.GuiElement;
import me.spruce.game.input.KeyInput;
import me.spruce.game.input.MouseInput;
import me.spruce.game.objects.ObjectHandler;
import me.spruce.game.setting.SettingsManager;
import me.spruce.game.state.StateManager;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.concurrent.CopyOnWriteArrayList;

public class Loop implements Runnable{

    private Display display;
    public int width, height;
    public String title;

    private Thread thread;
    private boolean running = false;

    private int fps;
    public static int finalFPS;

    private BufferStrategy bs;
    private Graphics g;

    public StateManager stateManager;

    public Fonts fonts;

    public SettingsManager settingsManager;

    // input
    public KeyInput keyInputManager;
    public MouseInput mouseInputManager;

    public Loop(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    private void init() {
        display = new Display(title, width, height);
        settingsManager = new SettingsManager(this);
        fonts = new Fonts();
        keyInputManager = new KeyInput();
        display.getFrame().addKeyListener(keyInputManager);

        stateManager = new StateManager(this);

        mouseInputManager = new MouseInput(this);
        display.getFrame().addMouseListener(mouseInputManager);
        display.getFrame().addMouseMotionListener(mouseInputManager);
        display.getCanvas().addMouseListener(mouseInputManager);
        display.getCanvas().addMouseMotionListener(mouseInputManager);

    }

    @Override
    public void run() {
        init();

        fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        finalFPS = 0;

        while(running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000) {
                //System.out.println("Ticks and Frames: " + ticks);
                finalFPS = ticks;
                ticks = 0;
                timer = 0;
            }

        }

        stop();
    }

    private void tick(){
        stateManager.getCurrentState().tick();
    }

    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();
        //Clear screen
        g.clearRect(0, 0, width, height);
        //Things to draw

        stateManager.getCurrentState().render(g);

        //end of drawing
        bs.show();
        g.dispose();
    }

    public synchronized void start() {
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
