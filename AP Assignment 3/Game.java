import java.util.Scanner;
public class Game {
    public static void main(String[] args)
    {
        Scanner scn= new Scanner(System.in);
        String playername;
        System.out.println("Enter the player name and hit enter");
        playername=scn.nextLine();
        player p = new player(playername);
        System.out.println("The game setup is ready.");
        while(true)
        {
            System.out.print("Hit enter to roll a dice");
            scn.nextLine();
            Dice d1 = new Dice(2);
            System.out.println(d1);
            if(d1.getFaceValue()==1)
            {
                gameplay(p, d1, playername);
                break;
            }
            else
            {
                System.out.println("Game cannot start until you get 1");
            }
        }
    }
    public static void gameplay(player play, Dice d, String playername)
    {   Scanner scn= new Scanner(System.in);
        floor f=new floor(playername,0);
        f.display();
        play.display();
        while(f.getPosition()!=13)
        {
            System.out.print("Hit enter to roll a dice");
            scn.nextLine();
            d.roll();
            System.out.println(d);
            if(d.getFaceValue()==1 && f.getPosition()+d.getFaceValue()<=13)
            {
                f.setPosition(f.getPosition()+d.getFaceValue());
            }
            else if(d.getFaceValue()==2 && f.getPosition()+d.getFaceValue()<=13)
            {
                f.setPosition(f.getPosition()+d.getFaceValue());
            }
            else
            {
                System.out.println("Player cannot move");
                continue;
            }
            if(f.getPosition()==1)
            {
                play.setPoints(play.getPoints()+1);
                f.display();
                play.display();
            }
            else if(f.getPosition()==2)
            {
                  f= new ladder("Elevator");
                  f.setName(playername);
                  f.setPosition(2);
                  f.display();
                  play.setPoints(play.getPoints()+4);
                  play.display();
                  f=new floor(playername,10);
                  f.display();
                  play.setPoints(play.getPoints()+1);
                  play.display();
            }
            else if(f.getPosition()==3 || f.getPosition()==4)
            {
                play.setPoints(play.getPoints()+1);
                f.display();
                play.display();
            }
            else if(f.getPosition()==5)
            {   f=new snakes("Snake");
                f.setName(playername);
                f.setPosition(5);
                f.display();
                play.setPoints(play.getPoints()-2);
                play.display();
                f=new floor(playername,1);
                f.display();
                play.setPoints(play.getPoints()+1);
                play.display();
            }
            else if(f.getPosition()==6 || f.getPosition()==7)
            {
                play.setPoints(play.getPoints()+1);
                f.display();
                play.display();
            }
            else if(f.getPosition()==8)
            {   f=new ladder("Ladder");
                f.setName(playername);
                f.setPosition(8);
                f.display();
                play.setPoints(play.getPoints()+2);
                play.display();
                f=new floor(playername,12);
                f.display();
                play.setPoints(play.getPoints()+1);
                play.display();
            }
            else if(f.getPosition()==9 || f.getPosition()==10)
            {

                play.setPoints(play.getPoints()+1);
                f.display();
                play.display();
            }
            else if(f.getPosition()==11)
            {   f=new snakes("King Cobra");
                f.setName(playername);
                f.setPosition(11);
                f.display();
                play.setPoints(play.getPoints()-4);
                play.display();
                f=new floor(playername,3);
                f.display();
                play.setPoints(play.getPoints()+1);
                play.display();
            }
            else if(f.getPosition()==12)
            {
                play.setPoints(play.getPoints()+1);
                f.display();
                play.display();
            }
            else if(f.getPosition()==13)
            {

                play.setPoints(play.getPoints()+1);
                f.display();
                play.display();
                break;
            }
        }
        System.out.println("Game over");
        System.out.println(play.getName()+" accumulated "+ play.getPoints()+ " points");
    }
}
