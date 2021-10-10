/*
 * AUTHOR: TRONG NGUYEN
 * FILE: Flower.java
 * COURSE: CSc210, Fall 2020
 * PURPOSE: The class contains the constructor of 
 * the class Vegetable to plant a new vegetable or control
 * the vegetable inside the garden. The class contains 
 * some method to meet the demand of the users with
 * the vegetable such as grow and harvest.
 * 
 * Usage:
 * If the user want to do any changes or control
 * the vegetable, they can call vegetable.method().
 * For example:
 * vegetable.grow(growNum) will grow the vegetable with
 * growNum times as the demand of the users.
 */
public class Vegetable extends Plant {
    private int growth;
    private int initRow;
    private int initCol;
    private String firstChar;

    // Constructor of the class
    // @param type: type is the name of the
    // vegetable that will be created.
    public Vegetable(String type) {
        firstChar = type.substring(0, 1).toLowerCase();
        this.growth = 1;
        this.initRow = 0;
        this.initCol = 2;
    }

    /*
     * PURPOSE: The method will return the
     * first character of the type.
     * (For example: type tomato will return t).
     */
    public String returnChar() {
        return firstChar;
    }

    /*
     * PURPOSE: The method will be called when the users
     * want to plant vegetable in the garden.
     */
    public void plant() {
        super.changeGrid(initRow, initCol, firstChar);
    }

    /*
     * PURPOSE: The method will be called when the users
     * want to grow the vegetable in the garden.
     * 
     * @param growNum: The amount of times that the users want
     * the vegetable to grow();
     */
    public void grow(String growNum) {
        int grow = Integer.valueOf(growNum);
        if (growth + grow < 5) {
            if (growth + grow == 2) {
                plantGrid[1][2] = firstChar;
                growth = 2;
            } else if (growth + grow == 3) {
                plantGrid[1][2] = firstChar;
                plantGrid[2][2] = firstChar;
                growth = 3;
            } else if (growth + grow == 4) {
                plantGrid[1][2] = firstChar;
                plantGrid[2][2] = firstChar;
                plantGrid[3][2] = firstChar;
                growth = 4;
            }
        } else {
            growAll();
            growth = 5;
        }
    }

    /*
     * PURPOSE: This method serves as the helper
     * for the grow method. It is called when the total
     * growth greater or equal to 5.
     */
    public void growAll() {
        for (int row = 0; row < 5; row++) {
            plantGrid[row][2] = firstChar;
        }
    }  

    /*
     * PURPOSE: This method will be called if the
     * users want to harvest vegetable in the garden.
     */
    public void harvest() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                plantGrid[row][col] = ".";
            }
        }
    }
}
