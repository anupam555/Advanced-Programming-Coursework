package com.company;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        // write your code here
        bucket store=new bucket();
        Scanner scn= new Scanner(System.in);
        Random random= new Random();
        String[] softToys={"Teddy","Mickey Mouse","Jerry","Pooh","Minion","Donald Duck","Tom","Doraemon","Oswald","Pink Panther",
                "Dora","Oggy","Scooby Dog","Dragon","Pikachu","Bheem","Road Runner","Jumbo","Sponge Bob","Popeye"};
        System.out.print("Hit enter to initialize the game");
        scn.nextLine();
        System.out.println("Game is ready");
        for (int i =1; i <= 5; i++) {
            System.out.print("Hit enter for your " + i + " hop");
            scn.nextLine();
            int x = 1 + (int) (Math.random() * 21);
            if (x == 21)
            {   System.out.println("You are too energetic and zoomed past all the tiles. Muddy Puddle Splash!");
            }
            else if(x%2 == 0){
                tiles t = new tiles(x,softToys[x-1]);
                System.out.println("You landed on tile "+t.getNumber());
                System.out.println("You won a "+t.getToyName()+" soft toy");
                store.addToy(t);
              }
            else if(x%2 == 1)
            {   String str;
                System.out.println("You landed on tile"+x);
                System.out.println("Question answer round. Integer or String?");
                str = scn.nextLine();
                if (str.equalsIgnoreCase("integer")) {
                    int a = random.nextInt(50);
                    int b = random.nextInt(50);
                    while(true)
                    {
                        try {
                            int div=a/b;
                            break;
                        }
                        catch(ArithmeticException e)
                        {
                            b= random.nextInt(50);
                        }
                    }
                    calculator<Integer> calculate = new calculator(a,b);
                    System.out.println("Calculate the result of " + a + " divided by" + b);
                    int ans = scn.nextInt();
                    int val = calculate.divide();
                    if (ans == val) {
                            tiles t = new tiles(x, softToys[x - 1]);
                            System.out.println("Correct answer");
                            System.out.println("You won a " + softToys[x - 1] + " soft toy");
                            store.addToy(t);
                        } else {
                            System.out.println("Incorrect answer");
                            System.out.println("You did not win any soft toy");
                        }
                    }
                    else if (str.equalsIgnoreCase("string")) {
                        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
                        String alphabets = upperAlphabet + lowerAlphabet;
                        StringBuilder sb = new StringBuilder();
                        StringBuilder sbr = new StringBuilder();
                        for (int k = 0; k < 4; k++) {
                            int index = random.nextInt(alphabets.length());
                            char randomChar = alphabets.charAt(index);
                             sb.append(randomChar);
                        }
                        String randomString1 = sb.toString();
                        for (int j = 0; j < 4; j++) {
                            int idx = random.nextInt(alphabets.length());
                            char rChar = alphabets.charAt(idx);
                            sbr.append(rChar);
                        }
                        String randomString2 = sbr.toString();
                        System.out.println("Calculate the concatenation of the strings " + randomString1 + " and " + randomString2);
                        String s = scn.nextLine();
                        calculator<String> calculate = new calculator(randomString1, randomString2);
                        String concat_string = calculate.concatenate();
                        if (s.equals(concat_string)) {
                            tiles t = new tiles(x, softToys[x - 1]);
                            System.out.println("Correct answer");
                            System.out.println("You won a " + softToys[x - 1] + " soft toy");
                            store.addToy(t);
                        }
                        else {
                            System.out.println("Incorrect answer");
                            System.out.println("You did not win any soft toy");
                        }
                    }
                    else
                    {
                        System.out.println("Invalid input");
                        break;
                    }
                }
            }
        ArrayList<tiles> softtoys= store.getStore();
        System.out.println("Game Over");
        System.out.println("Soft toys won by you are:");

        for(int i=0; i<softtoys.size()-1; i++)
        {   System.out.print(softtoys.get(i).getToyName()+",");
        }
        System.out.println(softtoys.get(softtoys.size()-1).getToyName());
    }
}
