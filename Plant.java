/*
 * AUTHOR: TRONG NGUYEN
 * FILE: Plant.java
 * ASSIGNMENT: Programming Assignment 5 - Garden
 * COURSE: CSc210, Fall 2020
 * PURPOSE: This class contains a constructor of 
 * class Plant which would be useful to manage or
 * control or make any changes of the plant. 
 * The class also has some method such as grow,
 * pick, harvest to meet the demand of the users 
 * if they have those commands. Any changes or
 * activity of the plant will need to get through
 * this class.
 * 
 * Usage:
 * If users want to make any changes to the plant, 
 * they can call plant.method() to do it.
 * For example: plant.grow(growNum) will grow
 * the plant growNum times as the demand of users.
 */
public class Plant {
    protected String[][] plantGrid;
    protected int initCol;
    protected int initRow;
    private Flower flower;
    private Vegetable vegetable;
    private Tree tree;
    private String[] listFlower;
    private String[] listVegetable;
    private String[] listTree;

    // Constructor of the class
    public Plant() {
        plantGrid = new String[5][5];
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                plantGrid[row][col] = ".";
            }
        }
    }

    /*
     * PURPOSE: This method is called to set all the
     * types of flowers into an array for further
     * purposes.
     * 
     * @param listFlower: would be an array that
     * contains all type of flowers when the method
     * return.
     */
    public String[] setFlower(String[] listFlower) {
        listFlower = new String[6];
        listFlower[0] = "iris";
        listFlower[1] = "lily";
        listFlower[2] = "rose";
        listFlower[3] = "daisy";
        listFlower[4] = "tulip";
        listFlower[5] = "sunflower";
        return listFlower;
    }

    /*
     * PURPOSE: This method is called to set all the
     * types of vegetable into an array for further
     * purposes.
     * 
     * @param listVegetable: would be an array that
     * contains all the types of vegetables when the
     * method return.
     */
    public String[] setVegetable(String[] listVegetable) {
        listVegetable = new String[5];
        listVegetable[0] = "garlic";
        listVegetable[1] = "zucchini";
        listVegetable[2] = "tomato";
        listVegetable[3] = "yam";
        listVegetable[4] = "lettuce";
        return listVegetable;
    }

    /*
     * PURPOSE: This method is called to set all the
     * types of tree into a list for further
     * purposes.
     * 
     * @param listTree: would be an array that contains
     * all the types of trees after the method return.
     */
    public String[] setTree(String[] listTree) {
        listTree = new String[5];
        listTree[0] = "oak";
        listTree[1] = "willow";
        listTree[2] = "banana";
        listTree[3] = "coconut";
        listTree[4] = "pine";
        return listTree;
    }

    /*
     * PURPOSE: This method is to check the type
     * of Plant(Flower or Vegetable or Tree)
     * 
     * @param type: type is the name of the
     * plant which will be checked.
     */
    public String getName(String type) {
        String[] checkFlower = setFlower(listFlower);
        for (String flowers : checkFlower) {
            if (flowers.equalsIgnoreCase(type)) {
                return "Flower";
            }
        }
        String[] checkVegetable = setVegetable(listVegetable);
        for (String vegetables : checkVegetable) {
            if (vegetables.equalsIgnoreCase(type)) {
                return "Vegetable";
            }
        }
        String[] checkTree = setTree(listTree);
        for (String trees : checkTree) {
            if (trees.equalsIgnoreCase(type)) {
                return "Tree";
            }
        }
        return null;
    }

    /*
     * PURPOSE: This method will make change of the
     * plant inside the grid with the given row
     * and col.
     * 
     * @param row: should be an int passed in.
     * 
     * @param col: should be an int passed in.
     * 
     * @param toChange: should be a string that
     * the users want to change to.
     */
    public void changeGrid(int row, int col, String toChange) {
        plantGrid[row][col] = toChange;
    }

    /*
     * PURPOSE: This method will be called when
     * users want to plant any Plant in garden.
     * 
     * @param type: type is name of the plant
     * that the users want to plant.
     */
    public void plant(String type) {
        String plantType = getName(type);
        if (plantType.equals("Flower")) {
            flower = new Flower(type);
            flower.plant();
        } else if (plantType.equals("Vegetable")) {
            vegetable = new Vegetable(type);
            vegetable.plant();
        } else if (plantType.equals("Tree")) {
            tree = new Tree(type);
            tree.plant();
        }
    }

    /*
     * PURPOSE: Return the flower.
     */
    public Flower getFlower() {
        return flower;
    }

    /*
     * PURPOSE: Return the vegetable.
     */
    public Vegetable getVegetable() {
        return vegetable;
    }

    /*
     * PURPOSE: Return the tree.
     */
    public Tree getTree() {
        return tree;
    }

    /*
     * PURPOSE: This method will be called when
     * the users want to grow Plant in garden.
     * 
     * @param growNum: the amount of times
     * that users want to grow the Plant.
     */
    public void grow(String growNum) {
        if (flower != null) {
            flower.grow(growNum);
        } else if (vegetable != null) {
            vegetable.grow(growNum);
        } else if (tree != null) {
            tree.grow(growNum);
        }
    }

    /*
     * PURPOSE: This method will be called when
     * the users want to grow any specific type
     * of plant in the garden.
     * 
     * @param growNum: the amount of time that
     * users want to grow the Plant.
     * 
     * @param type: type is the name of the Plant
     * that the users want to grow.
     */
    public void growType(String growNum, String type) {
        String plantType = getName(type);
        if (plantType.equalsIgnoreCase("Flower")) {
            if (flower != null) {
                if (flower.returnChar().equals(type.substring(0, 1))) {
                    flower.grow(growNum);
                }
            } 
        }else if (plantType.equalsIgnoreCase("Vegetable")) {
            if (vegetable != null) {
                if (vegetable.returnChar().equals(type.substring(0, 1)))
                    vegetable.grow(growNum);
            }
        } else if (plantType.equalsIgnoreCase("Tree")) {
            if (tree != null) {
                if (tree.returnChar().equals(type.substring(0, 1)))
                    tree.grow(growNum);
            }
        }
    }

    /*
     * PURPOSE: This method will be called when the users
     * want to grow specific Plant type (Flower, Vegetable,
     * or Tree).
     * 
     * @param growNum: the amount of times that the users
     * want to grow the Plant.
     * 
     * @param type: type is the type of Plant that the users
     * want to grow.
     */
    public void growPlant(String growNum, String type) {
        if (type.equalsIgnoreCase("flower")) {
            if(flower!=null) {
                flower.grow(growNum);
            }
        } else if (type.equalsIgnoreCase("vegetable")) {
            if(vegetable != null) {
                vegetable.grow(growNum);
            }
        } else if (type.equalsIgnoreCase("tree")) {
            if(tree != null) {
                tree.grow(growNum);
            }
        }
    }

    /*
     * PURPOSE: This method will be called when
     * the users want to pick the flower in
     * the garden.
     */
    public void pick() {
        if (flower != null) {
            flower.pick();
            flower = null;
        }
    }

    /*
     * PURPOSE: This method will be called when
     * the users want to cut the tree in the
     * garden.
     */
    public void cut() {
        if (tree != null) {
            tree.cut();
            tree = null;
        }
    }

    /*
     * PURPOSE: This method will be called when
     * the users want to harvest the vegetable
     * in the garden.
     */
    public void harvest() {
        if (vegetable != null) {
            vegetable.harvest();
            vegetable = null;
        }
    }

    /*
     * PURPOSE: This method will be called when
     * the users want to pick specific type
     * of flower in garden.
     * 
     * @param type: the type of the flower that the
     * users want to pick.
     */
    public void pickType(String type) {
        if (flower != null) {
            String toCheck = flower.returnChar();
            if (type.substring(0, 1).equals(toCheck)) {
                flower.pick();
                flower = null;
            }
        }
    }

    /*
     * PURPOSE: This method will be called when the users
     * want to cut specific type of tree in garden.
     * 
     * @param type: the type of the tree that the users
     * want to cut.
     */
    public void cutType(String type) {
        if (tree != null) {
            String toCheck = tree.returnChar();
            if (type.substring(0, 1).equals(toCheck)) {
                tree.cut();
                tree = null;
            }
        }
    }

    /*
     * PURPOSE: This will be called when the users
     * want to harvest specific type of tree in garden.
     * 
     * @param type: the type of the vegetable that the
     * users want to harvest.
     */
    public void harvestType(String type) {
        if (vegetable != null) {
            String toCheck = vegetable.returnChar();
            if (type.substring(0, 1).equals(toCheck)) {
                vegetable.harvest();
                vegetable = null;
            }
        }
    }

    /*
     * PURPOSE: This method serves as the helper
     * method to get the element from the garden
     * to print them out.
     */
    public String helperOut() {
        String result = new String();
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                result += plantGrid[row][col];
            }
            result += "\n";
        }
        return result;
    }

    /*
     * PURPOSE: This method will be called when
     * the users want to get any elements from a
     * row in the garden
     * 
     * @param row: should be the row that the user
     * want to get element.
     */
    public String rowFactor(int row) {
        String result = new String();
        for (String rowPlant : plantGrid[row]) {
            result += rowPlant;
        }
        return result;
    }

    /*
     * PURPOSE: This method will be called when
     * the users want to pick the flower at specific
     * position.
     */
    public void pickPos() {
        if (flower != null) {
            flower.pick();
            flower = null;
        } else {
            System.out.println("Can't pick there." + "\n");
        }
    }

    /*
     * PURPOSE: This method will be called when the users
     * want to cut the tree at specific position.
     */
    public void cutPos() {
        if (tree != null) {
            tree.cut();
            tree = null;
        } else {
            System.out.println("Can't cut there." + "\n");
        }
    }

    /*
     * PURPOSE: This method will be called when
     * the users want to harvest the vegetable at
     * specific position.
     */
    public void harvestPos() {
        if (vegetable != null) {
            vegetable.harvest();
            vegetable = null;
        } else {
            System.out.println("Can't harvest there." + "\n");
        }
    }
}
