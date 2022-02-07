/*
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.Bug;

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class TriangleBug extends Bug {
    private int baseSteps;
    private int steps;
    private int baseAngle;

    /**
     * Constructs a box bug that traces a square of a given side length
     *
     * @param baseSteps the side length
     */
    public TriangleBug(int baseSteps) {
        this.baseSteps = baseSteps;
        this.setDirection(270);
        baseAngle = 270;
    }

    public int angle(int x){
        return x%360;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act() {
        if(this.getDirection() == angle(baseAngle) && steps < baseSteps && canMove()){
            move();
            steps++;
        } else if (((this.getDirection() == angle(baseAngle+135)) || (this.getDirection() == angle(baseAngle+225))) && steps < baseSteps/2 && canMove()){
            move();
            steps++;
        } else if (this.getDirection() == baseAngle){
            this.setDirection(angle(baseAngle+135));
            steps = 0;
            System.out.println("a" + baseAngle);
        } else if (this.getDirection() == angle(baseAngle+135)){
            this.setDirection(angle(baseAngle+225));
            steps = 0;
            System.out.println("b" + baseAngle);
        } else if (this.getDirection() == angle(baseAngle+225)){
            this.setDirection(angle(baseAngle));
            steps = 0;
            System.out.println("c" + baseAngle);
        } else {
            System.out.println(steps + " " + baseSteps + " " + canMove() + " " + baseAngle);
            baseAngle = angle(baseAngle + 90);
            this.setDirection(baseAngle);
            steps = 0;
            System.out.println(steps + " " + baseSteps + " " + canMove() + " " + baseAngle);
        }
    }
}
