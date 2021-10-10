import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * AUTHOR: TRONG NGUYEN
 * FILE: PA5Main.java
 * ASSIGNMENT: Programming Assignment 5 - Garden
 * COURSE: CSc210, Fall 2020
 * PURPOSE: The program will read in a text file which contains
 * a lot of command from the user (PLANT, PICK, GROW, HARVEST, 
 * CUT). With the based information from the reading file, the
 * file also contains other methods to meet the demand of the 
 * users from the reading file such as (method plant, method
 * pick, method grow, method pick,..) The demand of users also
 * need other information such as position, amount of time 
 * growth,...
 * The command line argument will be the name of reading
 * file which will be a string given from the user.
 * 
 * Usage:
 * This is what the input look like:
 * rows: 5
 * cols: 5
 * PLANT (0,0) iris
 * PLANT (0,1) oak
 * PLANT (1,1) rose
 * PLANT (1,3) tomato
 * PLANT (2,2) tulip
 * PLANT (2,3) pine
 * print
 * pick (0,0)
 * print
 * ------------------
 * All of the commands above are the commands
 * from the users that they want us to do.
 */
public class PA5Main {
    private static Garden garden;
    private static int row;
    private static int col;
    public static void main(String[] args) {
        readingFile(args[0]);
    }

    /*
     * PURPOSE: The method will receive a string file
     * name and then read in that file to get the
     * necessary based information for the other
     * methods
     * 
     * @param: filename: the name of the file provided
     * by the users which will be scanned.
     */
    public static void readingFile(String filename) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String lineRow = scanner.nextLine();
        String[] getRow = lineRow.split(" ");
        row = Integer.valueOf(getRow[1]);
        String lineCol = scanner.nextLine();
        String[] getCol = lineCol.split(" ");
        col = Integer.valueOf(getCol[1]);
        if (col > 16) {
            System.out.println("Too many plot columns.");
        } else {
            garden = new Garden(row, col);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] command = line.split(" ");
                commandCheck(command);
            }
        }
        scanner.close();
    }

    /*
     * PURPOSE: The method will receive a list of string
     * which contains the needed information to determine
     * the command of the users.
     * 
     * @param: A list of string which contains the
     * information of the command from users.
     */
    public static void commandCheck(String[] command) {
        if (command[0].equalsIgnoreCase("print")) {
            System.out.println("> PRINT");
            System.out.println(garden.printGarden());
        } else if(command[0].equalsIgnoreCase("PLANT")) {
            plant(command);
        } else if (command[0].equalsIgnoreCase("GROW")) {
            grow(command);
        } else if (command[0].equalsIgnoreCase("HARVEST")) {
            harvest(command);
        } else if (command[0].equalsIgnoreCase("PICK")) {
            pick(command);
        } else if (command[0].equalsIgnoreCase("CUT")) {
            cut(command);
        }
    }

    /*
     * PURPOSE: The method will receive a list of
     * needed information from the command of the
     * users and then plant the new plant into
     * the plot.
     * 
     * @param: A list of needed information of the
     * command line from the users.
     */
    public static void plant(String[] command) {
        int col = 0;
        int row = 0;
        if (command[1].substring(2, 3).equals(",")) {
            row = Integer.valueOf(command[1].substring(1, 2));
            if (command[1].substring(4, 5).equals(")")) {
                col = Integer.valueOf(command[1].substring(3, 4));
            } else {
                col = Integer.valueOf(command[1].substring(3, 5));
            }
        } else {
            row = Integer.valueOf(command[1].substring(1, 3));
            if (command[1].substring(5, 6).equals(")")) {
                col = Integer.valueOf(command[1].substring(4, 5));
            } else {
                col = Integer.valueOf(command[1].substring(4, 6));
            }
        }
        Plant toDo = garden.returnPlant(row, col);
        toDo.plant(command[2]);
    }

    /*
     * PURPOSE: The method will receive a list
     * of needed information for the command of
     * the users and then grow the wanted plants.
     * 
     * @param: A list of needed information of the
     * command line from the users.
     */
    public static void grow(String[] command) {
        if (command.length == 2) {
            growGeneral(command);
        } else if (command.length == 3) {
            if (command[2].substring(0, 1).equals("(")) {
                growPos(command);
            } else {
                String toCheck = command[2].substring(0, 2);
                if (toCheck.equals("fl") || toCheck.equals("ve")
                        || toCheck.equals("tr")) {
                    growPlant(command);
                } else {
                    growType(command);
                }
            }
        }
    }

    /*
     * PURPOSE: This method is a helper method of
     * grow method. This method will be called when
     * the users want to grow the whole garden.
     * 
     * @param: A list of needed information of the
     * command line from the users.
     */
    public static void growGeneral(String[]command) {
        System.out.println(">" + " " + command[0].toUpperCase() + " "
                + command[1] + "\n");
        for (int i = 0; i < row; i++) {
            for (int index = 0; index < col; index++) {
                garden.returnPlant(i, index).grow(command[1]);
            }
        }
    }

    /*
     * PURPOSE: This method is a helper method of grow
     * method. This method will be called when the user
     * want to grow plant at specific position.
     * 
     * @param: A list of needed information of the
     * command line from the users.
     */
    public static void growPos(String[]command) {
        System.out.println(">" + " " + command[0].toUpperCase() + " "
                + command[1].toUpperCase() + " " + command[2] + "\n");
        garden.growPos(command[1], command[2]);
    }

    /*
     * PURPOSE: This method is a helper method of grow
     * method. This method will be called when the user
     * want to grow any specific type of plant(flower,
     * vegetable, and tree).
     * 
     * @param: A list of needed information of the
     * command line from the users.
     */
    public static void growPlant(String[]command) {
        System.out.println(">" + " " + command[0].toUpperCase() + " "
                + command[1].toUpperCase() + " " + command[2] + "\n");
        for (int rowCheck = 0; rowCheck < row; rowCheck++) {
            for (int colCheck = 0; colCheck < col; colCheck++) {
                garden.returnPlant(rowCheck, colCheck)
                .growPlant(command[1], command[2]);
            }
        }
    }

    /*
     * PURPOSE: This method is a helper method of grow
     * method. This method will be called when the user
     * want to grow any specific type of Plant(rose,
     * tulip, banana,...)
     * 
     * @param: A list of needed information of the
     * command line from the users.
     */
    public static void growType(String[] command) {
        System.out.println(">" + " " + command[0].toUpperCase() + " "
                + command[1].toUpperCase() + " " + command[2] + "\n");
        for (int rowCheck = 0; rowCheck < row; rowCheck++) {
            for (int colCheck = 0; colCheck < col; colCheck++) {
                garden.returnPlant(rowCheck, colCheck).growType(command[1],
                        command[2]);
            }
        }
    }

    /*
     * PURPOSE : This method is a harvest method when the
     * users want to harvest all the garden.
     * 
     * @param: A list of needed information of the
     * command line from the users.
     */
    public static void harvest(String[] command) {
        if (command.length == 1) {
            System.out.println(">" + " " + command[0].toUpperCase() + "\n");
            for (int rowCheck = 0; rowCheck < row; rowCheck++) {
                for (int colCheck = 0; colCheck < col; colCheck++) {
                    garden.returnPlant(rowCheck, colCheck).harvest();
                }
            }
        } else if (command[1].substring(0, 1).equals("(")) {
            System.out.println(">" + " " + command[0].toUpperCase() + " "
                    + command[1] + "\n");
            garden.harvestPos(command[1]);
        } else {
            System.out.println(">" + " " + command[0].toUpperCase() + " "
                    + command[1] + "\n");
            for (int rowCheck = 0; rowCheck < row; rowCheck++) {
                for (int colCheck = 0; colCheck < col; colCheck++) {
                    garden.returnPlant(rowCheck, colCheck)
                            .harvestType(command[1]);
                }
            }
        }
    }

    /*
     * PURPOSE: This method is a pick method and it
     * is called when the users want to pick up all
     * the flowers in the garden.
     * 
     * @param: A list of needed information of the
     * command line from the users.
     */
    public static void pick(String[] command) {
        if (command.length == 1) {
            System.out.println(">" + " " + command[0].toUpperCase() + "\n");
            for (int rowCheck = 0; rowCheck < row; rowCheck++) {
                for (int colCheck = 0; colCheck < col; colCheck++) {
                    garden.returnPlant(rowCheck, colCheck).pick();
                }
            }
        } else if (command[1].substring(0, 1).equals("(")) {
            System.out.println(">" + " " + command[0].toUpperCase() + " "
                    + command[1] + "\n");
            garden.pickPos(command[1]);
        } else {
            System.out.println(">" + " " + command[0].toUpperCase() + " "
                    + command[1] + "\n");
            for (int rowCheck = 0; rowCheck < row; rowCheck++) {
                for (int colCheck = 0; colCheck < col; colCheck++) {
                    garden.returnPlant(rowCheck, colCheck).pickType(command[1]);
                }
            }
        }
    }

    /*
     * PURPOSE: This method is a cut method and it is
     * call when the users want to cut all the
     * tree in the garden
     * 
     * @param: A list of needed information of the
     * command line from the users.
     */
    public static void cut(String[] command) {
        if (command.length == 1) {
            System.out.println(">" + " " + command[0].toUpperCase());
            System.out.println("\n");
            for (int rowCheck = 0; rowCheck < row; rowCheck++) {
                for (int colCheck = 0; colCheck < col; colCheck++) {
                    garden.returnPlant(rowCheck, colCheck).cut();
                }
            }
        } else if (command[1].substring(0, 1).equals("(")) {
            System.out.println(">" + " " + command[0].toUpperCase() + " "
                    + command[1] + "\n");
            garden.cutPos(command[1]);
        } else {
            System.out.println(">" + " "
                    +
                    command[0].toUpperCase() + " " + command[1] + "\n");
            for (int rowCheck = 0; rowCheck < row; rowCheck++) {
                for (int colCheck = 0; colCheck < col; colCheck++) {
                    garden.returnPlant(rowCheck, colCheck).cutType(command[1]);
                }
            }
        }
    }
}






