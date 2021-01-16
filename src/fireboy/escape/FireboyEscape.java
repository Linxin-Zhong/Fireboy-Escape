//Name:Lola Zhong
//Date:14/06/2019
//Purpose: Create a program playing the adapted version of the game Fireboy Escape.
package fireboy.escape;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

/**
 *
 * @author 1ZHONGLOL
 */
public class FireboyEscape extends JPanel implements ActionListener, KeyListener {

    Image border1, border2, obstacle, fireboy, bluegem, redgem, destinationw, destinationf, watergirl, monster;//create images for borders, moving obstacle and the fireboy,watergirl,destination door,monsters
    int xObstacle = 565;//determine the starting x coordinate of the obstacle
    int speedObstacle = 5;//determine the moving speed of the obstacle
    int xFireboy = 55;//determine the starting x coordinate for fireboy 
    int yFireboy = 416;//determine the starting y coordinate for the fireboy
    int xGem[] = new int[5];//create 2 arrays for the x and y coordinates of the gemstone
    int yGem[] = new int[5];
    Boolean newgame = false;
    int xBullet1 = 143;//create two variables for the x and y coordinates of the first bullet
    int yBullet1 = 194;
    int xBullet2[] = new int[3];//create 2 arrays for x and y coordinates of the bullets from monster number 2
    int yBullet2[] = new int[3];
    int xBullet3[] = new int[3];//create 2 arrays for x and y coordinates of the bullets from monster number 3
    int yBullet3[] = new int[3];
    String k = "Total shots you get: ";//create a string to show the total turns the player takes to win the game
    String totalShots = "0";
    boolean getGem[] = new boolean[5];//create a boolean to show the situation of each gemstone,if the fireboy already get it or not
    String a = "Current Score: ";//create a string to show the current score of the player
    String score = "0";
    boolean Win = false;
    String win = "YOU WIN!!!";//create a string to tell the player when they win the game
    boolean gotshot = false;
    String shot = "You got shot T^T";//create a string to tell the player when they got shot by the bullets
    int style = Font.BOLD;//set the font and the style for the text
    Font font = new Font("Arial", style, 23);//set the font
    Button NewGame;//create a new game button

    FireboyEscape() {
        NewGame = new Button("New Game");//create a newgame button
        NewGame.setBounds(10, 10, 80, 20);
        NewGame.addActionListener((ActionListener) this);
        add(NewGame);
        xGem[0] = 65;//set the coordinates for each gem stone
        xGem[1] = 312;
        xGem[2] = 635;
        xGem[3] = 680;
        xGem[4] = 395;
        yGem[0] = 50;
        yGem[1] = 344;
        yGem[2] = 130;
        yGem[3] = 465;
        yGem[4] = 465;
        for (int i = 0; i <= 2; i++) {//set the starting coordinates for each bullets from the monster 2 and 3
            xBullet2[i] = 500 - i * 30;//the distance between each bullet is 30
            yBullet2[i] = 350;
            xBullet3[i] = 690 - i * 30;
            yBullet3[i] = 60;
        }
        this.addKeyListener(this);
        setFocusable(true);
        this.setLayout(null);
        try {
            border1 = ImageIO.read(new File("border.png"));//find the images of borders, fireboy, and the moving obstacle,destination door,watergirl
            border2 = ImageIO.read(new File("border2.png"));
            obstacle = ImageIO.read(new File("obstacle.png"));
            fireboy = ImageIO.read(new File("fireboy.png"));
            bluegem = ImageIO.read(new File("bluegem.png"));
            redgem = ImageIO.read(new File("redgem.png"));
            destinationw = ImageIO.read(new File("destination water.png"));
            destinationf = ImageIO.read(new File("destination fire.png"));
            watergirl = ImageIO.read(new File("watergirl.png"));
            monster = ImageIO.read(new File("monster.png"));
        } catch (IOException e) {
            System.out.println("File not found");
            System.exit(-1);
        }
        border1 = border1.getScaledInstance(40, 268, Image.SCALE_SMOOTH);//set the size of the images
        border2 = border2.getScaledInstance(268, 40, Image.SCALE_SMOOTH);
        obstacle = obstacle.getScaledInstance(100, 35, Image.SCALE_SMOOTH);
        fireboy = fireboy.getScaledInstance(40, 80, Image.SCALE_SMOOTH);
        bluegem = bluegem.getScaledInstance(40, 30, Image.SCALE_SMOOTH);
        redgem = redgem.getScaledInstance(40, 30, Image.SCALE_SMOOTH);
        destinationf = destinationf.getScaledInstance(60, 75, Image.SCALE_SMOOTH);
        destinationw = destinationw.getScaledInstance(60, 75, Image.SCALE_SMOOTH);
        watergirl = watergirl.getScaledInstance(40, 80, Image.SCALE_SMOOTH);
        monster = monster.getScaledInstance(40, 50, Image.SCALE_SMOOTH);

        for (int i = 0; i <= 4; i++) {
            getGem[i] = false;//make the boolean of the fireboy getting each gemstone false
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        char key = (char) e.getKeyCode();
        if (key == e.VK_ESCAPE) {//when the escape key is pressed, exit the program
            System.exit(0);
        }
        if (key == e.VK_RIGHT) {//when the right arrow key is pressed
            if (xFireboy >= 680) {//if the fireboy touches outside or inside borders, stays at its original spot
            } else if (xFireboy >= 90 && xFireboy <= 146 && yFireboy <= 100) {

            } else if (xFireboy >= 90 && xFireboy <= 154 && yFireboy >= 140 && yFireboy <= 536) {

            } else if (xFireboy >= 306 && xFireboy <= 374 && yFireboy <= 285) {

            } else if (xFireboy >= 440 && xFireboy <= 555 && yFireboy >= 270 && yFireboy <= 392) {

            } else if (xFireboy >= 496 && xFireboy <= 560 && yFireboy >= 55 && yFireboy <= 393) {

            } else if (xFireboy + 50 >= xObstacle && xFireboy <= xObstacle + 100 && yFireboy >= 183 && yFireboy <= 274) {
                //If the fireboy touches the moving obstacle, stays at its original spot
            } else {//If he isn't touching any border or obstacle, move right by 5
                xFireboy = xFireboy + 10;

            }
        }
        if (key == e.VK_LEFT) {//if the left arrow key is pressed
            if (xFireboy <= 40) {//if the fireboy touches outside or inside borders, stays at its original spot
            } else if (xFireboy >= 122 && xFireboy <= 156 && yFireboy <= 100) {

            } else if (xFireboy >= 96 && xFireboy <= 160 && yFireboy >= 140 && yFireboy <= 536) {

            } else if (xFireboy >= 150 && xFireboy <= 575 && yFireboy >= 330 && yFireboy <= 415) {

            } else if (xFireboy >= 340 && xFireboy <= 375 && yFireboy <= 285) {

            } else if (xFireboy >= 530 && xFireboy <= 574 && yFireboy >= 47 && yFireboy <= 393) {

            } else if (xFireboy + 50 >= xObstacle && xFireboy <= xObstacle + 100 && yFireboy >= 183 && yFireboy <= 274) {
                //If the fireboy touches the moving obstacle, stays at its original spot
            } else {
                xFireboy = xFireboy - 10;//If he isn't touching any border or obstacle, move left by 5
            }
            System.out.println("Left");
        }
        if (key == e.VK_UP) {//if the up arrow key is pressed
            if (yFireboy <= 40) {//if the fireboy touches outside or inside borders, stays at its original spot
            } else if (xFireboy >= 120 && xFireboy <= 146 && yFireboy <= 110) {

            } else if (xFireboy >= 150 && xFireboy <= 555 && yFireboy >= 395 && yFireboy <= 420) {

            } else if (xFireboy >= 306 && xFireboy <= 374 && yFireboy <= 290) {

            } else if (xFireboy + 35 >= xObstacle && xFireboy <= xObstacle + 100 && yFireboy >= 195 && yFireboy <= 280) {
                //If the fireboy touches the moving obstacle, stays at its original spot
            } else {;//If he isn't touching any border or obstacle, move up by 5
                yFireboy = yFireboy - 10;
            }
        }
        if (key == e.VK_DOWN) {//if the down arrow key is pressed
            if (yFireboy >= 420) {//if the fireboy touches outside or inside borders, stays at its original spot
            } else if (xFireboy >= 96 && xFireboy <= 154 && yFireboy >= 136 && yFireboy <= 536) {

            } else if (xFireboy >= 150 && xFireboy <= 555 && yFireboy >= 325 && yFireboy <= 415) {

            } else if (xFireboy >= 465 && xFireboy <= 526 && yFireboy >= 265 && yFireboy <= 330) {

            } else if (xFireboy >= 514 && xFireboy <= 560 && yFireboy >= 45 && yFireboy <= 393) {

            } else if (xFireboy + 35 >= xObstacle && xFireboy <= xObstacle + 100 && yFireboy >= 174 && yFireboy <= 275) {
                //If the fireboy touches the moving obstacle, stays at its original spot 
            } else {;//If he isn't touching any border or obstacle, move down by 5
                yFireboy = yFireboy + 10;
            }
        }
        repaint();
    }

    public void actionPerformed(ActionEvent e)//This method responds to clicking a button
    {
        if (e.getActionCommand().equals("EXIT")) {//When the exit button is clicked, exit the program
            System.exit(0);
        }
        if (e.getActionCommand().equals("New Game")) {//When the New Game button is clicked, make the boolean true
            newgame = true;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // clear the frame
        g.setColor(Color.black);
        g.setFont(font);
        Dimension s = this.getSize();//get the length and width of the frame
        int w = s.width;
        int h = s.height;
        super.paintComponent(g);
        Color c = Color.black;//set the background color black
        g.setColor(c);
        Dimension size = this.getSize();
        g.fillRect(0, 0, size.width, size.height);
        g.drawImage(border1, 0, 0, null); // show the scaled image of borders
        g.drawImage(border1, 0, 268, null);
        g.drawImage(border2, 0, 0, null);
        g.drawImage(border2, 254, 0, null);
        g.drawImage(border2, 508, 0, null);
        g.drawImage(border1, 722, 0, null);
        g.drawImage(border1, 722, 268, null);
        g.drawImage(border1, 0, 268, null);
        g.drawImage(border2, 0, 496, null);
        g.drawImage(border2, 254, 496, null);
        g.drawImage(border2, 508, 496, null);
        g.drawImage(border1, 125, 240, null);
        g.drawImage(border1, 125, -155, null);
        g.drawImage(border2, 135, 393, null);
        g.drawImage(border2, 306, 393, null);
        g.drawImage(border1, 342, 30, null);
        g.drawImage(border1, 535, 128, null);
        g.drawImage(destinationw, 170, 430, null);//show the images of destination doors
        g.drawImage(destinationf, 240, 430, null);
        g.drawImage(watergirl, 180, 430, null);
        g.drawImage(monster, 125, 190, null);
        g.drawImage(monster, 500, 350, null);
        g.drawImage(monster, 370, 50, null);
        g.setColor(Color.green);
        for (int i = 0; i <= 2; i++) {//draw the three bullets from monster number2
            if (xBullet2[i] >= xFireboy && xBullet2[i] <= xFireboy + 40 && yBullet2[i] >= yFireboy && yBullet2[i] <= yFireboy + 80) {
                xFireboy = 55;//if the fireboy get shot by the bullets
                yFireboy = 416;//goes back to the starting point
                gotshot = true;
                int totalshots = Integer.parseInt(totalShots);
                totalshots++;//increase the number of shots by 1
                totalShots = "" + totalshots;
            }
            if (xBullet2[i] >= 154) {//If the bullets hasn't goes beyond the border
                g.fillOval(xBullet2[i], yBullet2[i], 10, 10);
                xBullet2[i] = xBullet2[i] - 2;//keep moving forward
            } else {
                xBullet2[i] = 500;//If it moves beyond the border
                g.fillOval(xBullet2[i], yBullet2[i], 10, 10);//put it back to the original point
            }
        }
        for (int i = 0; i <= 2; i++) {//draw the three bullets from monster number2
            if (xBullet3[i] >= xFireboy && xBullet3[i] <= xFireboy + 40 && yBullet3[i] >= yFireboy && yBullet3[i] <= yFireboy + 80) {
                xFireboy = 55;//if the fireboy get shot by the bullets
                yFireboy = 416;//goes back to the starting point
                gotshot = true;
                int totalshots = Integer.parseInt(totalShots);
                totalshots++;
                totalShots = "" + totalshots;
            }
            if (xBullet3[i] <= 726) {//if the bullets doesn't goe through the border
                g.fillOval(xBullet3[i], yBullet3[i], 10, 10);
                xBullet3[i] = xBullet3[i] + 2;//keep moving foward
            } else {//if the bullet goes beyond the border
                xBullet3[i] = 390;//move it back to the starting point
                g.fillOval(xBullet3[i], yBullet3[i], 10, 10);
            }
        }
        if (yBullet1 <= 35) {//make the hint of get shot disappear after every time the bullet number one reaches the border again
            yBullet1 = 194;//put the bullet back to its original point
            gotshot = false;
        } else {
            if (yBullet1 >= 113) {//only shows the bullet when the y coordinates is smaller than 113
                g.fillOval(xBullet1, yBullet1, 10, 10);
            }
            yBullet1 = yBullet1 - 2;//keep it moving forward at the speed of 2
        }
        if (xBullet1 >= xFireboy && xBullet1 <= xFireboy + 40 && yBullet1 >= yFireboy && yBullet1 <= yFireboy + 80) {//If fireboy got shot
            xFireboy = 55;//put it back to the starting point
            yFireboy = 416;
            gotshot = true;
            int totalshots = Integer.parseInt(totalShots);
            totalshots++;//increase the number of total shots by 1
            totalShots = "" + totalshots;
        }

        g.drawImage(obstacle, xObstacle, 253, null);//show the scaled image of the moving obstacle
        if (xObstacle >= 630) {//Let the moving obstacle moves back and forth between the borders.
            speedObstacle = -3;//when it touches one of the sides, change its direction of moving
        }
        if (xObstacle <= 565) {
            speedObstacle = 3;
        }
        xObstacle = xObstacle + speedObstacle;
        g.drawImage(fireboy, xFireboy, yFireboy, null);//show the scaled image of fireboy

        for (int i = 0; i <= 4; i++) {
            if (xFireboy >= xGem[i] - 40 && xFireboy <= xGem[i] + 40 && yFireboy >= yGem[i] - 60 && yFireboy <= yGem[i] + 30) {//If the fireboy get a gem stone stone

                getGem[i] = true;//make the corresponding boolean true
                int Score = Integer.parseInt(score);
                Score++;
                score = "" + Score;//increase the score by 1
                xGem[i] = 2000;//move the coordinates of the gemstone out side of the frame
                yGem[i] = 2000;
            }
        }
        for (int i = 0; i <= 4; i = i + 2) {//for gemstone number 0,2,4(red gem stones)
            if (getGem[i] == false) {//if they are not yet taken by the fireboy
                g.drawImage(redgem, xGem[i], yGem[i], null);//show them on the screen
            }
        }
        for (int i = 1; i <= 4; i = i + 2) {//for the gemstoines number 1,3(blue gem stones)
            if (getGem[i] == false) {//if they are not yet taken by the fireboy
                g.drawImage(bluegem, xGem[i], yGem[i], null);//show them on the screen
            }
        }
        g.setColor(Color.yellow);
        if (xFireboy >= 220 && xFireboy <= 280 && yFireboy >= 390 && yFireboy <= 465) {//If fireboy reaches the destination door
            Win = true;//make the boolean Win true
        }
        if (Win == true) {//if the boolean Win is true
            g.drawString(win, 300, 250);//Show the words "You Win!!"
            g.drawString(k, 300, 270);
            g.drawString(totalShots, 540, 270);//Show the total number of shots he gets to reach the destination
        }
        if (gotshot == true) {//If the boolean of the player get shot is true
            g.drawString(shot, 550, 70);//show a hint at the upper right corder to remind him/her
        }
        if (newgame == true) {//if the new game boolean is true 
            for (int i = 0; i <= 4; i++) {//reset all the scores, numbers, coordinates to the original point
                getGem[i] = false;
            }
            xGem[0] = 65;//Let all the gemstones that already taken away back to the riginal points
            xGem[1] = 312;
            xGem[2] = 635;
            xGem[3] = 680;
            xGem[4] = 395;
            yGem[0] = 50;
            yGem[1] = 344;
            yGem[2] = 130;
            yGem[3] = 465;
            yGem[4] = 465;
            Win = false;
            xFireboy = 55;//put fireboy back to its original point
            yFireboy = 416;
            score = "0";//reset the score and the shots number
            totalShots = "0";
            newgame = false;
            this.grabFocus();
        }

        g.drawString(a, 550, 35);
        g.drawString(score, 720, 35);//show the current score
        repaint();
        delay(35);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DrawOne");
        frame.getContentPane().add(new FireboyEscape());
        frame.setSize(780, 570);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void delay(int mili) {
        try {
            Thread.sleep(mili);
        } catch (InterruptedException e) {
            System.out.println("ERROR IN SLEEPING");
        }
    }
}
