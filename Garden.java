/*
 * AUTHOR: TRONG NGUYEN
 * FILE: Garden.java
 * ASSIGNMENT: Programming Assignment 5 - Garden
 * COURSE: CSc210, Fall 2020
 * PURPOSE: The file will serve as the garden which manages
 * all the plant inside the garden. The file also contains
 * some methods which meet the demands of the users. The file
 * will keep track all the plant inside the garden and then 
 * manage the plant as the demands of the users.
 * 
 * Usage:
 * The user can active the methods of garden inside this
 * class to get access to the Plant inside the garden and 
 * then utilize all other features of the plant.
 * for example garden[row][col].grow(). 
 */
public class Garden {
    private Plant[][] garden;

    // Constructor of the class
    // @param row,col: The size of
    // the garden.
    public Garden(int row, int col) {
        garden = new Plant[row][col];
        for (int rowCheck = 0; rowCheck < row; rowCheck++) {
            for (int colCheck = 0; colCheck < col; colCheck++) {
                garden[rowCheck][colCheck] = new Plant();
            }
        }
    }

    /*
     * PURPOSE: This method will receive row
     * and col and then return the plant of
     * the garden at given position.
     * 
     * @param row: row of the plant that
     * the users want to get access.
     * 
     * @param col: col of the plant that the
     * users want to get access
     */
    public Plant returnPlant(int row, int col) {
        return garden[row][col];
    }

    /*
     * PURPOSE: This method will use the printHelper method
     * as the helper method to print out the whole garden
     * as the demand of the users.
     */
    public String printGarden() {
        String result = new String();
        for (Plant[] inRow : garden) {
            for (int index = 0; index < 5; index++) {
                for (Plant plantInRow : inRow) {
                    String constantStr = ".....";
                    if (plantInRow.getFlower() != null) {
                        constantStr = printHelper(constantStr,
                                plantInRow.getFlower().rowFactor(index));
                    }
                    if (plantInRow.getTree() != null) {
                        constantStr = printHelper(constantStr,
                                plantInRow.getTree().rowFactor(index));
                    }
                    if (plantInRow.getVegetable() != null) {
                        constantStr = printHelper(constantStr,
                                plantInRow.getVegetable().rowFactor(index));
                    }
                    result = result + constantStr;
                }
                result = result + "\n";
            }
        }
        return result;
    }

    /*
     * PURPOSE: This method will receive the amount
     * of times that the user want to grow the plant
     * and the position that they want to the grow
     * 
     * @param growNum: the amount of time that the
     * users want the plant to grow
     * 
     * @param pos: the position of the plant that
     * the users want to grow.
     */
    public void growPos(String growNum, String pos) {
        int col = 0;
        int row = 0;
        // Check if the row and col are 1 or 2 digits
        if (pos.substring(2, 3).equals(",")) {
            row = Integer.valueOf(pos.substring(1, 2));
            if (pos.substring(4, 5).equals(")")) {
                col = Integer.valueOf(pos.substring(3, 4));
            } else {
                col = Integer.valueOf(pos.substring(3, 5));
            }
        } else {
            row = Integer.valueOf(pos.substring(1, 3));
            if (pos.substring(5, 6).equals(")")) {
                col = Integer.valueOf(pos.substring(4, 5));
            } else {
                col = Integer.valueOf(pos.substring(4, 6));
            }
        }
        if (row >= garden.length || col >= garden[row].length) {
            System.out.println("Can't grow there." + "\n");
        } else {
            if (garden[row][col] == null) {
                System.out.println("Can't grow there." + "\n");
            } else {
                garden[row][col].grow(growNum);
            }
        }
    }

    /*
     * PURPOSE: The method will be called if the users
     * want to harvest the vegetable at specific
     * position.
     * 
     * @param pos: the position of the vegetable that
     * users want to harvest given by the users.
     */
    public void harvestPos(String pos) {
        int col = 0;
        int row = 0;
        // Check if the row and col are 1 or 2 digits
        if (pos.substring(2, 3).equals(",")) {
            row = Integer.valueOf(pos.substring(1, 2));
            if (pos.substring(4, 5).equals(")")) {
                col = Integer.valueOf(pos.substring(3, 4));
            } else {
                col = Integer.valueOf(pos.substring(3, 5));
            }
        } else {
            row = Integer.valueOf(pos.substring(1, 3));
            if (pos.substring(5, 6).equals(")")) {
                col = Integer.valueOf(pos.substring(4, 5));
            } else {
                col = Integer.valueOf(pos.substring(4, 6));
            }
        }
        if (row >= garden.length || col >= garden[row].length) {
            System.out.println("Can't harvest there." + "\n");
        } else {
            if (garden[row][col] == null) {
                System.out.println("Can't harvest there." + "\n");
            } else {
                garden[row][col].harvestPos();
            }
        }
    }

    /*
     * PURPOSE: The method will be called when the users
     * want to pick the flower at specific position.
     * 
     * @param pos: The position of the flower that the
     * users want to pick in the garden.
     */
    public void pickPos(String pos) {
        int col = 0;
        int row = 0;
        // Check if the row and col are 1 or 2 digits
        if (pos.substring(2, 3).equals(",")) {
            row = Integer.valueOf(pos.substring(1, 2));
            if (pos.substring(4, 5).equals(")")) {
                col = Integer.valueOf(pos.substring(3, 4));
            } else {
                col = Integer.valueOf(pos.substring(3, 5));
            }
        } else {
            row = Integer.valueOf(pos.substring(1, 3));
            if (pos.substring(5, 6).equals(")")) {
                col = Integer.valueOf(pos.substring(4, 5));
            } else {
                col = Integer.valueOf(pos.substring(4, 6));
            }
        }
        if (row >= garden.length || col >= garden[row].length) {
            System.out.println("Can't pick there." + "\n");
        } else {
            if (garden[row][col] == null) {
                System.out.println("Can't pick there." + "\n");
            }
            garden[row][col].pickPos();
        }
    }

    /*
     * PURPOSE: The method will be called when the
     * users want to cut tree at specific position
     * in the garden.
     * 
     * @param pos: The position of the tree that the
     * users want to cut.
     */
    public void cutPos(String pos) {
        int col = 0;
        int row = 0;
        // Check if the row and col are 1 or 2 digits
        if (pos.substring(2, 3).equals(",")) {
            row = Integer.valueOf(pos.substring(1, 2));
            if (pos.substring(4, 5).equals(")")) {
                col = Integer.valueOf(pos.substring(3, 4));
            } else {
                col = Integer.valueOf(pos.substring(3, 5));
            }
        } else {
            row = Integer.valueOf(pos.substring(1, 3));
            if (pos.substring(5, 6).equals(")")) {
                col = Integer.valueOf(pos.substring(4, 5));
            } else {
                col = Integer.valueOf(pos.substring(4, 6));
            }
        }
        if (row >= garden.length || col >= garden[row].length) {
            System.out.println("Can't cut there." + "\n");
        } else {
            if (garden[row][col] == null) {
                System.out.println("Can't cut there." + "\n");
            } else {
                garden[row][col].cutPos();
            }
        }
    }

    /*
     * PURPOSE: The method use as a helper method for the
     * print out method.
     * 
     * @param first: The first string passed in which the
     * users want to process.
     * 
     * @param second: The second string passed in which the
     * users want to process.
     */
    public String printHelper(String first, String second) {
        String checkingWith = ".";
        String result = "";
        for (int toCheck = 0; toCheck < 5; toCheck++) {
            if (!first.substring(toCheck, toCheck + 1).equals(checkingWith)) {
                result += first.substring(toCheck, toCheck + 1);
            } else if (!second.substring(toCheck, toCheck + 1)
                    .equals(checkingWith)) {
                result += second.substring(toCheck, toCheck + 1);
            } else {
                result += checkingWith;
            }
        }
        return result;
    }


}
