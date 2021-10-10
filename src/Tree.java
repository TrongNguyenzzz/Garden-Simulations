/*
 * AUTHOR: TRONG NGUYEN
 * FILE: Flower.java
 * COURSE: CSc210, Fall 2020
 * PURPOSE: The class contains the constructor of 
 * the class Tree to plant a new tree or control
 * the tree inside the garden. The class contains 
 * some method to meet the demand of the users with
 * the tree such as grow and cut.
 * 
 * Usage:
 * If the user want to do any changes or control
 * the tree, they can call tree.method().
 * For example:
 * tree.grow(growNum) will grow the tree with
 * growNum times as the demand of the users.
 */
public class Tree extends Plant {
    private int growth;
    private int initRow;
    private int initCol;
    private String firstChar;

    // Constructor of the class
    // @param type: type is the name of
    // the tree that will be created.
    // For example: banana,..
    public Tree(String type) {
        firstChar = type.substring(0, 1).toLowerCase();
        this.growth = 1;
        this.initRow = 4;
        this.initCol = 2;
    }

    /*
     * PURPOSE: return the first character of
     * the type of the tree.
     * For example: type banana will return b.
     */
    public String returnChar() {
        return firstChar;
    }

    /*
     * PURPOSE: The method will be called when
     * the users want to plant trees.
     */
    public void plant() {
        super.changeGrid(initRow, initCol, firstChar);
    }

    /*
     * PURPOSE: The method will be called if the
     * users want to grow the tree in the
     * garden.
     * 
     * @param growNum: The amount of times that
     * the users want the tree to grow.
     */
    public void grow(String growNum) {
        int grow = Integer.valueOf(growNum);
        if (grow + growth < 5) {
            if (grow + growth == 2) {
                plantGrid[3][2] = firstChar;
                growth = 2;
            } else if (grow + growth == 3) {
                plantGrid[3][2] = firstChar;
                plantGrid[2][2] = firstChar;
                growth = 3;
            } else if (grow + growth == 4) {
                plantGrid[3][2] = firstChar;
                plantGrid[2][2] = firstChar;
                plantGrid[1][2] = firstChar;
            }
        } else {
            growAll();
            growth = 5;
        }
    }

    /*
     * PURPOSE: This method serves as the helper
     * method for grow. It will be called when
     * the total growth greater or equal to 5.
     */
    public void growAll() {
        for (int row = 0; row < 5; row++) {
            plantGrid[row][2] = firstChar;
        }
    }

    /*
     * PURPOSE: The method will be called when
     * the users want to cut tree in the garden.
     */
    public void cut() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                plantGrid[row][col] = ".";
            }
        }
    }
}
