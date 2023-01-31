package com.alvstw.mousemover;


import java.awt.*;

public class MouseService {
    private Robot robot;

    public MouseService() {
        try {
            this.robot = new Robot();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void moveMouse(int x, int y, int delay) {
        int currentX = getMouseX();
        int currentY = getMouseY();
        int deltaX = x - currentX;
        int deltaY = y - currentY;
        int steps = 10;
        int stepX = deltaX / steps;
        int stepY = deltaY / steps;
        for (int i = 0; i < steps; i++) {
            robot.mouseMove(currentX + stepX * i, currentY + stepY * i);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void moveMouseRelative(int x, int y, int delay) {
        int currentX = getMouseX();
        int currentY = getMouseY();
        this.moveMouse(currentX + x, currentY + y, delay);
    }

    public int getMouseX() {
        return (int) MouseInfo.getPointerInfo().getLocation().getX();
    }

    public int getMouseY() {
        return (int) MouseInfo.getPointerInfo().getLocation().getY();
    }
}
