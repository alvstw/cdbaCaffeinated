package com.CDBA.Caffeinated;

public class MouseMoverTask extends Thread {
    private final MouseService mouseService;
    private int delay = 10000;
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

            mouseService.moveMouseRelative(20, 20, 50);
            mouseService.moveMouse(x, y, 50);

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
