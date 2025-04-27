import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanI = new Scanner(System.in);
        Scanner scanS = new Scanner(System.in);
        Random rand = new Random();

        int menu1, menuCrafting;
        char[][] craftingTable = {
            {'|', ' ', '+', '-', '-', '-', '+', '-', '-', '-', '+', '-', '-', '-', '+', ' ', '|'},
            {'|', ' ', '|', ' ', '-', ' ', '|', ' ', '-', ' ', '|', ' ', '-', ' ', '|', ' ', '|'},
            {'|', ' ', '+', '-', '-', '-', '+', '-', '-', '-', '+', '-', '-', '-', '+', ' ', '|'},
            {'|', ' ', '|', ' ', '-', ' ', '|', ' ', '-', ' ', '|', ' ', '-', ' ', '|', ' ', '|'},
            {'|', ' ', '+', '-', '-', '-', '+', '-', '-', '-', '+', '-', '-', '-', '+', ' ', '|'},
            {'|', ' ', '|', ' ', '-', ' ', '|', ' ', '-', ' ', '|', ' ', '-', ' ', '|', ' ', '|'},
            {'|', ' ', '+', '-', '-', '-', '+', '-', '-', '-', '+', '-', '-', '-', '+', ' ', '|'}
        };

        char[][] mapGoMining = {
            {'=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '='},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '='},
        };

        Inventory<String> inventoryList = new Inventory<>();
        inventoryList.addItem("Stone");
        inventoryList.addItem("Iron");
        inventoryList.addItem("Diamond");
        inventoryList.qtyAdd(0);
        inventoryList.qtyAdd(1);
        inventoryList.qtyAdd(2);

        do {
            System.out.println("==========================");
            System.out.println("<<       Minecraft      >>");
            System.out.println("==========================");
            System.out.println("| Tools:                 |");
            System.out.println("|                        |");
            System.out.println("|                        |");
            System.out.println("==========================");
            System.out.println("| 1. Inventory           |");
            System.out.println("| 2. Crafting Table      |");
            System.out.println("| 3. Go Mining           |");
            System.out.println("| 0. Exit                |");
            System.out.println("==========================");
            do {                
                System.out.print(">> ");
                menu1 = scanI.nextInt();
            } while (menu1 < 0 || menu1 > 3 && menu1 != 555 && menu1 != 222);

            if(menu1 == 1) {
                System.out.println("=====================");
                System.out.println("      INVENTORY      ");
                System.out.println("=====================");
                inventoryList.displayItems();
                System.out.println("=====================");
            } else if(menu1 == 2) {
                char[][] currentCrafting = new char[7][17];
                for(int i = 0; i < craftingTable.length; i++) {
                    for(int j = 0; j < craftingTable[0].length; j++) {
                        currentCrafting[i][j] = craftingTable[i][j];
                    }
                }      
                do {              
                    System.out.println("=================");
                    System.out.println("|     CRAFT     |");
                    System.out.println("=================");
                    for(int i = 0; i < craftingTable.length; i++) {
                        for(int j = 0; j < craftingTable[0].length; j++) {
                            System.out.print(currentCrafting[i][j]);
                        }
                        System.out.println();
                    }
                    System.out.println("=================");
                    System.out.println("| 1. Place Item |");
                    System.out.println("| 2. Clear Grid |");
                    System.out.println("| 0. Exit       |");
                    System.out.println("=================");
                    do {
                        System.out.print(">> ");
                        menuCrafting = scanI.nextInt();
                    } while (menuCrafting < 0 || menuCrafting > 2);

                    if(menuCrafting == 1) {
                        int pilihMat, row, column;
                        String rowColumn;
                        Boolean isCukup = false;
                        System.out.println("Select material to place:");
                        System.out.println("1. Stick (s)");
                        System.out.println("2. Stone (S): x" + inventoryList.getQty(0));
                        System.out.println("3. Iron (I): x" + inventoryList.getQty(1));
                        System.out.println("4. Diamond (D): x" + inventoryList.getQty(2));
                        do {                            
                            System.out.print(">> ");
                            pilihMat = scanI.nextInt();
                            if(pilihMat == 1 || inventoryList.getQty(pilihMat-2) > 0) {
                                isCukup = true;
                            } else {
                                System.out.println("You don't have any " + inventoryList.getItem(pilihMat-2));
                            }
                        } while (pilihMat < 1 || pilihMat > 4 || !isCukup);
                        do {                            
                            System.out.print("Enter coordinates (row,column): ");
                            rowColumn = scanS.nextLine();
                            row = Character.getNumericValue(rowColumn.charAt(0));
                            column = Character.getNumericValue(rowColumn.charAt(2));
                            if (row < 0 || row > 2 || column < 0 || column > 2) {
                                System.out.println("Invalid coordinates!");
                            }
                        } while ((row < 0 || row > 2) || (column < 0 || column > 2));
                        if(row == 0) {
                            row = 1;
                        } else if(row == 1) {
                            row = 3;
                        } else if(row == 2) {
                            row = 5;
                        }

                        if(column == 0) {
                            column = 4;
                        } else if(column == 1) {
                            column = 8;
                        } else if(column == 2) {
                            column = 12;
                        }

                        if(pilihMat == 1) {
                            currentCrafting[row][column] = 's';
                        } else if(pilihMat == 2) {
                            currentCrafting[row][column] = 'S';
                            inventoryList.qtyMin(pilihMat-2);
                        } else if(pilihMat == 3) {
                            currentCrafting[row][column] = 'I';
                            inventoryList.qtyMin(pilihMat-2);
                        } else if(pilihMat == 4) {
                            currentCrafting[row][column] = 'D';
                            inventoryList.qtyMin(pilihMat-2);
                        }
                    } else if(menuCrafting == 2) {
                        for(int i = 0; i < currentCrafting.length; i++) {
                            for(int j = 0; j < currentCrafting[0].length; j++) {
                                if(currentCrafting[i][j] == 'S') {
                                    inventoryList.qtyAdd(0);
                                } else if(currentCrafting[i][j] == 'I') {
                                    inventoryList.qtyAdd(1);
                                } else if(currentCrafting[i][j] == 'D') {
                                    inventoryList.qtyAdd(2);
                                }
                            }
                        }
                        for(int i = 0; i < craftingTable.length; i++) {
                            for(int j = 0; j < craftingTable[0].length; j++) {
                                currentCrafting[i][j] = craftingTable[i][j];
                            }
                        }     
                    } else if(menuCrafting == 0){
                        for(int i = 0; i < currentCrafting.length; i++) {
                            for(int j = 0; j < currentCrafting[0].length; j++) {
                                if(currentCrafting[i][j] == 'S') {
                                    inventoryList.qtyAdd(0);
                                } else if(currentCrafting[i][j] == 'I') {
                                    inventoryList.qtyAdd(1);
                                } else if(currentCrafting[i][j] == 'D') {
                                    inventoryList.qtyAdd(2);
                                }
                            }
                        }
                    }

                    if(currentCrafting[1][4] == 'S' && currentCrafting[1][8] == 'S' && currentCrafting[1][12] == 'S' && currentCrafting[3][8] == 's' && currentCrafting[5][8] == 's') {
                        System.out.println("Stone Pickaxe crafted!");
                        for(int i = 0; i < 3; i++){
                            inventoryList.qtyMin(0);
                        }
                        for(int i = 0; i < craftingTable.length; i++) {
                            for(int j = 0; j < craftingTable[0].length; j++) {
                                currentCrafting[i][j] = craftingTable[i][j];
                            }
                        }
                    } else if(currentCrafting[1][4] == 'I' && currentCrafting[1][8] == 'I' && currentCrafting[1][12] == 'I' && currentCrafting[3][8] == 's' && currentCrafting[5][8] == 's') {
                        System.out.println("Iron Pickaxe crafted!");
                        for(int i = 0; i < 3; i++){
                            inventoryList.qtyMin(1);
                        }
                        for(int i = 0; i < craftingTable.length; i++) {
                            for(int j = 0; j < craftingTable[0].length; j++) {
                                currentCrafting[i][j] = craftingTable[i][j];
                            }
                        }
                    } else if(currentCrafting[1][4] == 'D' && currentCrafting[1][8] == 'D' && currentCrafting[1][12] == 'D' && currentCrafting[3][8] == 's' && currentCrafting[5][8] == 's') {
                        System.out.println("Diamond Pickaxe crafted!");
                        for(int i = 0; i < 3; i++){
                            inventoryList.qtyMin(2);
                        }
                        for(int i = 0; i < craftingTable.length; i++) {
                            for(int j = 0; j < craftingTable[0].length; j++) {
                                currentCrafting[i][j] = craftingTable[i][j];
                            }
                        }
                    } else if(currentCrafting[1][8] == 'S' && currentCrafting[3][8] == 'S' && currentCrafting[5][8] == 's') {
                        System.out.println("Stone Sword crafted!");
                        for(int i = 0; i < 2; i++){
                            inventoryList.qtyMin(0);
                        }
                        for(int i = 0; i < craftingTable.length; i++) {
                            for(int j = 0; j < craftingTable[0].length; j++) {
                                currentCrafting[i][j] = craftingTable[i][j];
                            }
                        }
                    } else if(currentCrafting[1][8] == 'I' && currentCrafting[3][8] == 'I' && currentCrafting[5][8] == 's') {
                        System.out.println("Iron Sword crafted!");
                        for(int i = 0; i < 2; i++){
                            inventoryList.qtyMin(1);
                        }
                        for(int i = 0; i < craftingTable.length; i++) {
                            for(int j = 0; j < craftingTable[0].length; j++) {
                                currentCrafting[i][j] = craftingTable[i][j];
                            }
                        }
                    } else if(currentCrafting[1][8] == 'D' && currentCrafting[3][8] == 'D' && currentCrafting[5][8] == 's') {
                        System.out.println("Diamond Sword crafted!");
                        for(int i = 0; i < 2; i++){
                            inventoryList.qtyMin(2);
                        }
                        for(int i = 0; i < craftingTable.length; i++) {
                            for(int j = 0; j < craftingTable[0].length; j++) {
                                currentCrafting[i][j] = craftingTable[i][j];
                            }
                        }
                    }

                } while (menuCrafting != 0);
            } else if(menu1 == 3) {
                char[][] currentMapGoMining = new char[9][21];
                for(int i = 0; i < mapGoMining.length; i++) {
                    for(int j = 0; j < mapGoMining[0].length; j++) {
                        currentMapGoMining[i][j] = mapGoMining[i][j];
                    }
                }
                Boolean isUpLevel = true;
                String inputPlay;
                int levelOre = 1;
                int level = 1;
                int y = 4;
                int x = 10;
                int[] yEnemy = {0, 0, 0, 0, 0};
                int[] xEnemy = {0, 0, 0, 0, 0};
                int[] jenisEnemy = {0, 0, 0, 0, 0};
                do {
                    if(levelOre == 1 && isUpLevel){
                        Boolean isKosong = false;
                        while(!isKosong){
                            int randY = rand.nextInt(8) + 1;
                            int randX = rand.nextInt(20) + 1;
                            if(currentMapGoMining[randY][randX] == ' '){
                                isKosong = true;
                            }
                            if(isKosong){
                                currentMapGoMining[randY][randX] = 'O';
                            }
                        }
                        for(int i = 0; i < 5; i++){
                            isKosong = false;
                            while(!isKosong){
                                int randY = rand.nextInt(8) + 1;
                                int randX = rand.nextInt(20) + 1;
                                if(currentMapGoMining[randY][randX] == ' '){
                                    isKosong = true;
                                }
                                if(isKosong){
                                    currentMapGoMining[randY][randX] = '@';
                                }
                            }
                        }
                        for(int i = 0; i < 5; i++){
                            isKosong = false;
                            while(!isKosong){
                                int randY = rand.nextInt(8) + 1;
                                int randX = rand.nextInt(20) + 1;
                                for(int j = 0; j < 5; j++){
                                    if(currentMapGoMining[randY][randX] == ' ' && randX != xEnemy[i] && randY != yEnemy[i]){
                                        isKosong = true;
                                    }
                                }
                                if(isKosong){
                                    yEnemy[i] = randY;
                                    xEnemy[i] = randX;
                                }
                            }
                        }
                        isUpLevel = false;
                    } else if(levelOre == 2 && isUpLevel){
                        for(int i = 0; i < mapGoMining.length; i++) {
                            for(int j = 0; j < mapGoMining[0].length; j++) {
                                currentMapGoMining[i][j] = mapGoMining[i][j];
                            }
                        }
                        Boolean isKosong = false;
                        while(!isKosong){
                            int randY = rand.nextInt(8) + 1;
                            int randX = rand.nextInt(20) + 1;
                            if(currentMapGoMining[randY][randX] == ' '){
                                isKosong = true;
                            }
                            if(isKosong){
                                currentMapGoMining[randY][randX] = 'O';
                            }
                        }
                        for(int i = 0; i < 5; i++){
                            isKosong = false;
                            while(!isKosong){
                                int randY = rand.nextInt(8) + 1;
                                int randX = rand.nextInt(20) + 1;
                                if(currentMapGoMining[randY][randX] == ' '){
                                    isKosong = true;
                                }
                                if(isKosong){
                                    currentMapGoMining[randY][randX] = '+';
                                }
                            }
                        }
                        for(int i = 0; i < 5; i++){
                            isKosong = false;
                            while(!isKosong){
                                int randY = rand.nextInt(8) + 1;
                                int randX = rand.nextInt(20) + 1;
                                for(int j = 0; j < 5; j++){
                                    if(currentMapGoMining[randY][randX] == ' ' && randX != xEnemy[i] && randY != yEnemy[i]){
                                        isKosong = true;
                                    }
                                }
                                if(isKosong){
                                    yEnemy[i] = randY;
                                    xEnemy[i] = randX;
                                }
                            }
                        }
                        for(int i = 0; i < 5; i++){
                            int randEnemy = rand.nextInt(2);
                            jenisEnemy[i] = randEnemy;
                        }
                        isUpLevel = false;
                    } else if(levelOre == 3 && isUpLevel){
                        for(int i = 0; i < mapGoMining.length; i++) {
                            for(int j = 0; j < mapGoMining[0].length; j++) {
                                currentMapGoMining[i][j] = mapGoMining[i][j];
                            }
                        }
                        Boolean isKosong = false;
                        while(!isKosong){
                            int randY = rand.nextInt(8) + 1;
                            int randX = rand.nextInt(20) + 1;
                            if(currentMapGoMining[randY][randX] == ' '){
                                isKosong = true;
                            }
                            if(isKosong){
                                currentMapGoMining[randY][randX] = 'O';
                            }
                        }
                        for(int i = 0; i < 5; i++){
                            isKosong = false;
                            while(!isKosong){
                                int randY = rand.nextInt(8) + 1;
                                int randX = rand.nextInt(20) + 1;
                                if(currentMapGoMining[randY][randX] == ' '){
                                    isKosong = true;
                                }
                                if(isKosong){
                                    currentMapGoMining[randY][randX] = '*';
                                }
                            }
                        }
                        for(int i = 0; i < 5; i++){
                            isKosong = false;
                            while(!isKosong){
                                int randY = rand.nextInt(8) + 1;
                                int randX = rand.nextInt(20) + 1;
                                for(int j = 0; j < 5; j++){
                                    if(currentMapGoMining[randY][randX] == ' ' && randX != xEnemy[i] && randY != yEnemy[i]){
                                        isKosong = true;
                                    }
                                }
                                if(isKosong){
                                    yEnemy[i] = randY;
                                    xEnemy[i] = randX;
                                }
                            }
                        }
                        for(int i = 0; i < 5; i++){
                            int randEnemy = rand.nextInt(3);
                            jenisEnemy[i] = randEnemy;
                        }
                        isUpLevel = false;
                    }
                    for(int i = 0; i < 5; i++){
                        int randPosisi = rand.nextInt(4);
                        if(randPosisi == 0 && currentMapGoMining[yEnemy[i]+1][xEnemy[i]] == ' '){
                            currentMapGoMining[yEnemy[i]][xEnemy[i]] = ' ';
                            yEnemy[i]++;
                        } else if(randPosisi == 1 && currentMapGoMining[yEnemy[i]-1][xEnemy[i]] == ' '){
                            currentMapGoMining[yEnemy[i]][xEnemy[i]] = ' ';
                            yEnemy[i]--;
                        } else if(randPosisi == 2 && currentMapGoMining[yEnemy[i]][xEnemy[i]+1] == ' '){
                            currentMapGoMining[yEnemy[i]][xEnemy[i]] = ' ';
                            xEnemy[i]++;
                        } else if(randPosisi == 3 && currentMapGoMining[yEnemy[i]][xEnemy[i]-1] == ' '){
                            currentMapGoMining[yEnemy[i]][xEnemy[i]] = ' ';
                            xEnemy[i]--;
                        }
                    }
                    for(int i = 0; i < 5; i++){
                        if(levelOre == 1){
                            currentMapGoMining[yEnemy[i]][xEnemy[i]] = 'Z';
                        } else if(levelOre == 2){
                            if(jenisEnemy[i] == 0){
                                currentMapGoMining[yEnemy[i]][xEnemy[i]] = 'Z';
                            } else {
                                currentMapGoMining[yEnemy[i]][xEnemy[i]] = 'S';
                            }
                        } else if(levelOre == 3){
                            if(jenisEnemy[i] == 0){
                                currentMapGoMining[yEnemy[i]][xEnemy[i]] = 'Z';
                            } else if(jenisEnemy[i] == 1){
                                currentMapGoMining[yEnemy[i]][xEnemy[i]] = 'S';
                            } else if(jenisEnemy[i] == 2){
                                currentMapGoMining[yEnemy[i]][xEnemy[i]] = 'C';
                            }
                        }
                    }
                    currentMapGoMining[y][x] = 'P';
                    System.out.println("=====================");
                    System.out.println("|     Go Mining     |");
                    for(int i = 0; i < currentMapGoMining.length; i++){
                        for(int j = 0; j < currentMapGoMining[0].length; j++){
                            System.out.print(currentMapGoMining[i][j]);
                        }
                        System.out.println();
                    }
                    if(levelOre == 1){
                        System.out.println("Level: " + level + "/3 (Stone Mine)");
                    } else if(levelOre == 2){
                        System.out.println("Level: " + level + "/3 (Iron Mine)");
                    } else if(levelOre == 3){
                        System.out.println("Level: " + level + "/3 (Diamond Mine)");
                    }
                    System.out.println("(wasd): Move Player");
                    System.out.println("(e): Exit Mining");
                    System.out.println("=====================");
                    System.out.print(">> ");
                    inputPlay = scanS.nextLine();
                    if(inputPlay.equals("w") && (currentMapGoMining[y-1][x] == ' ' || currentMapGoMining[y-1][x] == 'O')){
                        currentMapGoMining[y][x] = ' ';
                        y--;
                        if(currentMapGoMining[y][x] == 'O'){
                            isUpLevel = true;
                            levelOre++;
                            y = 4;
                            x = 10;
                        }
                    } else if(inputPlay.equals("a") && (currentMapGoMining[y][x-1] == ' ' || currentMapGoMining[y][x-1] == 'O')){
                        currentMapGoMining[y][x] = ' ';
                        x--;
                        if(currentMapGoMining[y][x] == 'O'){
                            isUpLevel = true;
                            levelOre++;
                            y = 4;
                            x = 10;
                        }
                    } else if(inputPlay.equals("s") && (currentMapGoMining[y+1][x] == ' ' || currentMapGoMining[y+1][x] == 'O')){
                        currentMapGoMining[y][x] = ' ';
                        y++;
                        if(currentMapGoMining[y][x] == 'O'){
                            isUpLevel = true;
                            levelOre++;
                            y = 4;
                            x = 10;
                        }
                    } else if(inputPlay.equals("d") && (currentMapGoMining[y][x+1] == ' ' || currentMapGoMining[y][x+1] == 'O')){
                        currentMapGoMining[y][x] = ' ';
                        x++;
                        if(currentMapGoMining[y][x] == 'O'){
                            isUpLevel = true;
                            levelOre++;
                            y = 4;
                            x = 10;
                        }
                    }
                } while (!inputPlay.equals("e") && levelOre < 4);
                levelOre = 1;
            } else if(menu1 == 555){
                for(int i = 0; i < 5; i++){
                    inventoryList.qtyAdd(0);
                    inventoryList.qtyAdd(1);
                    inventoryList.qtyAdd(2);
                }
                System.out.println("Provide 5 materials.");
            } else if(menu1 == 222){

            }

        } while (menu1 != 0);
    }
}
