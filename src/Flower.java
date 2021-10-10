/*
 * AUTHOR: TRONG NGUYEN
 * FILE: Flower.java
 * COURSE: CSc210, Fall 2020
 * PURPOSE: The class contains the constructor of 
 * the class Flower to plant a new flower or control
 * the flowers inside the garden. The class contains 
 * some method to meet the demand of the users with
 * the flower such as grow and pick.
 * 
 * Usage:
 * If the user want to do any changes or control
 * the flower, they can call flower.method().
 * For example:
 * flower.grow(growNum) will grow the flower with
 * growNum times as the demand of the users.
 */
public class Flower extends Plant {
    private int growth;
    private int initRow;
    private int initCol;
    private String firstChar;

    // Constructor of the class
    // @param type: type is the name of
    // the flowers(rose, tulip,...)
    public Flower(String type) {
        firstChar = type.substring(0, 1).toLowerCase();
        this.growth = 1;
        this.initCol = 2;
        this.initRow = 2;
    }

    /*
     * PURPOSE: This method will return the first
     * character in the type of the flower.
     * For example: type rose will return r.
     */
    public String returnChar() {
        return firstChar;
    }

    /*
     * PURPOSE: This method will be used when the
     * users want to plant flowers.
     */
    public void plant() {
        super.changeGrid(initRow, initCol, firstChar);
    }

    /*
     * PURPOSE: This method is call when they users
     * want to grow the flowers.
     * 
     * @param growNum: should be the amount of times
     * that the users want to grow the flower.
     */
    public void grow(String growNum) {
        int grow = Integer.valueOf(growNum);
        if (growth + grow < 5) {
            if (growth + grow == 2) {
                plantGrid[1][2] = firstChar;
                plantGrid[3][2] = firstChar;
                plantGrid[2][3] = firstChar;
                plantGrid[2][1] = firstChar;
                growth = 2;
            }
            else if (growth + grow == 3) {
                growSecond();
                growth = 3;
            }
            else if (growth + grow == 4) {
                growThird();
                growth = 4;
            }
        } else {
            growAll();
            growth = 5;
        }
    }

    /*
     * PURPOSE: This method serves as the helper
     * method for grow method. This method will be
     * called when the total growth equal to 3.
     */
    public void growSecond() {
        plantGrid[0][2] = firstChar;
        plantGrid[1][2] = firstChar;
        plantGrid[1][1] = firstChar;
        plantGrid[1][3] = firstChar;
        plantGrid[2][0] = firstChar;
        plantGrid[2][1] = firstChar;
        plantGrid[2][2] = firstChar;
        plantGrid[2][3] = firstChar;
        plantGrid[2][4] = firstChar;
        plantGrid[3][1] = firstChar;
        plantGrid[3][2] = firstChar;
        plantGrid[3][3] = firstChar;
        plantGrid[4][2] = firstChar;
    }

    /*
     * PURPOSE: This method serves as the helper
     * method for grow method. This method will be
     * called when the total growth equal to 4.
     */
    public void growThird() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                plantGrid[row][col] = firstChar;
            }
        }
        plantGrid[0][0] = ".";
        plantGrid[0][4] = ".";
        plantGrid[4][0] = ".";
        plantGrid[4][4] = ".";
    }

    /*
     * PURPOSE: This method serves as the helper
     * method for grow method. This method will be
     * called when the total growth larger or
     * equal to 5.
     */
    public void growAll() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                plantGrid[row][col] = firstChar;
            }
        }
    }

    /*
     * PURPOSE: This method will be called when
     * the users want to pick the flower in
     * the garden.
     */
    public void pick() {
        for (int row=0; row<5; row++) {
            for (int col=0; col<5; col++) {
                plantGrid[row][col] = ".";
            }
        }
    }
}


