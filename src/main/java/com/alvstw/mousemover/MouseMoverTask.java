package com.alvstw.mousemover;

public class MouseMoverTask extends Thread {
    private final MouseService mouseService;
    private int delay = 5000;
    public MouseMoverTask() {
        mouseService = new MouseService();
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getDelay() {
        return delay;
    }

    @Override
    public void run() {
        while (true) {
            int x = mouseService.getMouseX();
            int y = mouseService.getMouseY();

            mouseService.moveMouseRelative(100, 100, 100);
            mouseService.moveMouse(x, y, 100);

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
