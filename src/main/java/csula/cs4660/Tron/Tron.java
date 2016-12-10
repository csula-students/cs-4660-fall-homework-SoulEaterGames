package csula.cs4660.Tron;

/**
 * Created by Bruno on 11/28/16.
 */
public class Tron {

    boolean board[][] = new boolean[30][20];
    int x = 10, y = 10;
    // 1: up || 2: right || 3: down || 4: left
    int direction = 1;

    public void setUpBoard(int startX, int startY){
        x = startX;
        y = startY;

        int i = 0;
        int j = 0;

        while (i < 30){
            while(j < 20){
                board[i][j] = false;
                j++;
            }
            j = 0;
            i++;
        }

        board[x][y] = true;
    }

    public void Game(){
        try{
            // set the board limits
            switch(direction){
                case 1: //up
                    if(!board[x][y - 1]){
                        board[x][y - 1] = true;
                        y--;
                    }

                case 2: //right
                    if(!board[x + 1][y]){
                        board[x + 1][y] = true;
                        x++;
                    }

                case 3: //down
                    if(!board[x][y + 1]){
                        board[x][y + 1] = true;
                        y++;
                    }

                case 4: //left
                    if(!board[x - 1][y]){
                        board[x - 1][y] = true;
                        x--;
                    }
            }
        }catch(Exception e){
            System.out.println(e);
        }

        boolean isItGoingLeft = false;
        boolean isItGoingRight = false;

        direction--;
        try{
            // check when player is moving
            switch(direction){
                case 1: //up
                    if(!board[x][y - 1]){
                        System.out.println("UP");
                        isItGoingLeft = true;
                    }
                    else {
                        isItGoingLeft = false;
                    }
                    break;

                case 2: //right
                    if(!board[x + 1][y]){
                        System.out.println("RIGHT");
                        isItGoingLeft = true;
                    }
                    else {
                        isItGoingLeft = false;
                    }
                    break;

                case 3: //down
                    if(!board[x][y + 1]){
                        System.out.println("DOWN");
                        isItGoingLeft = true;
                    }
                    else {
                        isItGoingLeft = false;
                    }
                    break;

                case 4: //left
                    if(!board[x - 1][y]){
                        System.out.println("LEFT");
                        isItGoingLeft = true;
                    }
                    else {
                        isItGoingLeft = false;
                    }
                    break;
            }
        }catch(Exception e){
            isItGoingLeft = false;
            System.out.println(e);
        }

        direction++;

        try{
            switch(direction){
                case 1: //up
                    if(!board[x][y - 1]){
                        System.out.println("UP");
                        isItGoingRight = true;
                    }
                    else {
                        isItGoingRight = false;
                    }
                    break;

                case 2: //right
                    if(!board[x + 1][y]){
                        System.out.println("RIGHT");
                        isItGoingRight = true;
                    }
                    else {
                        isItGoingRight = false;
                    }
                    break;

                case 3: //down
                    if(!board[x][y + 1]){
                        System.out.println("DOWN");
                        isItGoingRight = true;
                    }
                    else {
                        isItGoingRight = false;
                    }
                    break;

                case 4: //left
                    if(!board[x - 1][y]){
                        System.out.println("LEFT");
                        isItGoingRight = true;
                    }
                    else {
                        isItGoingRight = false;
                    }
                    break;
            }
        }catch(Exception e){
            isItGoingRight = false;
            System.out.println(e);
        }
        direction--;

        // if we can only go left
        if(isItGoingLeft&&!isItGoingRight){
            direction--;
            try{
                switch(direction){
                    case 1: //up
                        if(!board[x][y - 1]){
                            System.out.println("UP");
                            board[x][y-1] = true;
                            y--;
                        }

                    case 2: //right
                        if(!board[x + 1][y]){
                            System.out.println("RIGHT");
                            board[x + 1][y] = true;
                            x++;
                        }

                    case 3: //down
                        if(!board[x][y + 1]){
                            System.out.println("DOWN");
                            board[x][y + 1] = true;
                            y++;
                        }

                    case 4: //left
                        if(!board[x - 1][y]){
                            System.out.println("LEFT");
                            board[x - 1][y] = true;
                            x--;
                        }
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }

        // if we can only go right
        else if(!isItGoingLeft&&isItGoingRight){
            direction++;
            try{
                switch(direction){
                    case 1: //up
                        if(!board[x][y - 1]){
                            System.out.println("UP");
                            board[x][y - 1] = true;
                            y--;
                        }

                    case 2: //right
                        if(!board[x + 1][y]){
                            System.out.println("RIGHT");
                            board[x + 1][y] = true;
                            x++;
                        }

                    case 3: //down
                        if(!board[x][y + 1]){
                            System.out.println("DOWN");
                            board[x][y + 1] = true;
                            y++;
                        }

                    case 4: //left
                        if(!board[x - 1][y]){
                            System.out.println("LEFT");
                            board[x - 1][y] = true;
                            x--;
                        }
                        return;
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }

        // if it can go either way
        else if(isItGoingLeft && isItGoingRight){
            if(System.currentTimeMillis() % 2 == 0){
                direction--;
                try{
                    switch(direction){
                        case 1: //up
                            if(!board[x][y - 1]){
                                System.out.println("UP");
                                board[x][y - 1] = true;
                                y--;
                            }

                        case 2: //right
                            if(!board[x + 1][y]){
                                System.out.println("RIGHT");
                                board[x + 1][y] = true;
                                x++;
                            }

                        case 3: //down
                            if(!board[x][y + 1]){
                                System.out.println("DOWN");
                                board[x][y + 1] = true;
                                y++;
                            }

                        case 4: //left
                            if(!board[x - 1][y]){
                                System.out.println("LEFT");
                                board[x - 1][y] = true;
                                x--;
                            }

                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }

            else{
                direction++;
                try{
                    switch(direction){
                        case 1: //up
                            if(!board[x][y - 1]){
                                System.out.println("");
                                board[x][y - 1] = true;
                                y--;
                            }

                        case 2: //right
                            if(!board[x + 1][y]){
                                board[x + 1][y] = true;
                                x++;
                            }

                        case 3: //down
                            if(!board[x][y + 1]){
                                board[x][y + 1] = true;
                                y++;
                            }

                        case 4: //left
                            if(!board[x - 1][y]){
                                board[x - 1][y] = true;
                                x--;
                            }

                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
    }

    public void floodFill(){
        // for node in board
            // if player movement
                // paint player movement


    }


    public static void main(String args[]){
        Tron tron = new Tron();
        tron.setUpBoard(30, 20);
        tron.Game();

    }

}
