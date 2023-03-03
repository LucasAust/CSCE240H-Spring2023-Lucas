//Written by Lucas Aust
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class processor {
    public static Scanner keyboard = new Scanner(System.in);
    public static ArrayList<String> CDCArticle = new ArrayList<String>();
    public static ArrayList<String> WebMDArticle = new ArrayList<String>();
    public static ArrayList<ArrayList<String>> Articles = new ArrayList<ArrayList<String>>();//ArrayList that will hold all of the articles

    public static void main(String[] args)
    {
        System.out.println("Welcome to the disease chatbot!");
        disease();
    }
    //Method to select which disease user wants to work with
    public static void disease()
    {
        System.out.println("Enter the name of the disease you would like to talk about.\n(The disease the system currently runs on is polio.)");
        String disease = keyboard.nextLine();
        if( disease.equalsIgnoreCase("Polio"))
        {
            polio();
        }
        else
        {
            System.out.println("Sorry, I do not know about this disease. Try again.");
            disease();
        }
    }
    //This method reads files given by the user and adds them to the arrayList
    public static void polio()
    {
        System.out.println("Enter the name of the first file you would like to read.\nThe default file name is programs/prog2-processor/data/CDCPolio.txt.\nEnter \"test\" to run the default file");
        String in = keyboard.nextLine();
        if (in.equalsIgnoreCase("Test"))
        in = "programs/prog2-processor/data/CDCPolio.txt";
        String CDCFile = in;
        System.out.println("Enter the name of the second file you would like to read.\nThe default file name will be programs/prog2-processor/data/WebMDPolio.txt.\nEnter \"test\" to run the default file.");
        in = keyboard.nextLine();
        if(in.equalsIgnoreCase("Test"))
        in = "programs/prog2-processor/data/WebMDPolio.txt";
        String WebMDFile = in;
        System.out.println();
        CDCArticle = readFile(CDCFile,CDCArticle);
        WebMDArticle = readFile(WebMDFile,WebMDArticle);
        Articles.add(CDCArticle);
        Articles.add(WebMDArticle);
        bot(Articles);
        
    }
    //Method that reads a text file and stores each line individually in an arrayList
    public static ArrayList<String> readFile(String fileName, ArrayList<String> data)
    {
        int i = 0;
        String line = "";
        try {
            File file = new File(fileName);
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine())
            {
                line = scan.nextLine();
                data.add(i,line);
                i++;
            }
            }
            catch(Exception e)
            {
                System.out.println("Cannot open the file. Restarting the program");
                polio();
            }
            return data;
    }
    //Main chatting method
    public static void bot(ArrayList<ArrayList<String>> Articles)
    {
        String resp = "";
        boolean quit = false;
        while(!quit)//Loop that continues until user wants to stop asking questions
        {
            System.out.println("Ask me a question about the disease or enter \"quit\" to exit the program.");
            resp = keyboard.nextLine();
            resp.toLowerCase();
            System.out.println();
            if(resp.contains("what is polio"))//This check will establish what the user wants to know, repeated multiple times below
            {
                String print = null;
                for(int i =0;i<Articles.size();i++)//Loop to check all of the articles for data
                {
                    ArrayList<String> article = Articles.get(i);
                    for(int j=0;j<article.size();j++)//Loop to check each line in an article
                    {
                    String line = article.get(j).toLowerCase();
                    if(line.contains("what is polio"))
                    {
                    for(int h = j+1;h<article.size()-1;h++)//Loop that prints each line until the section of information is over
                    {
                        print=article.get(h);
                        if(print.equals(""))//This check finds when the section of information is over
                        break;//Stops the loop once the information is over

                        System.out.println(print);//Prints each line to the console
                    }
                    break;
                    }
                }
                if (print!=null)//If print is null, then the first article did not have the desired information.
                break;//Breaks out of the loop of articles so that it only prints one set of data
                }
            }
            //Each else if has the same functionality. The only difference is what specific question the program is checking for
            else if(resp.contains("cause")||resp.contains("causes"))
            {
                String print = null;
                for(int i =0;i<Articles.size();i++)
                {
                    ArrayList<String> article = Articles.get(i);
                    for(int j=0;j<article.size();j++)
                    {
                    String line = article.get(j);
                    if(line.contains(" Causes ")||line.contains(" Cause "))
                    {
                    for(int h = j+1;h<article.size()-1;h++)
                    {
                        print=article.get(h);
                        if(print.equals(""))
                        break;

                        System.out.println(print);
                    }
                    }
                }
                if (print!=null)
                break;
                }
            }
            else if(resp.contains("symptom")||resp.contains("Symptom"))
            {
                String print = null;
                for(int i =0;i<Articles.size();i++)
                {
                    ArrayList<String> article = Articles.get(i);
                    for(int j=0;j<article.size();j++)
                    {
                    String line = article.get(j);
                    if(line.contains("Symptoms"))
                    {
                    for(int h = j+1;h<article.size()-1;h++)
                    {
                        print=article.get(h);
                        if(print.equals(""))
                        break;

                        System.out.println(print);
                    }
                    }
                }
                if (print!=null)
                break;
                }
            }
            else if(resp.contains("prevent")||resp.contains("prevents"))
            {
                String print = null;
                for(int i =0;i<Articles.size();i++)
                {
                    ArrayList<String> article = Articles.get(i);
                    for(int j=0;j<article.size()-1;j++)
                    {
                    String line = article.get(j).toLowerCase();
                    if(line.contains("Prevent")||line.contains("prevent"))
                    {
                    for(int h = j+1;h<=article.size()-1;h++)
                    {
                        print=article.get(h);
                        if(print.equals(""))
                        break;
                        System.out.println(print);
                    }
                    }
                }
                if (print!=null)
                break;
                }
            }
            else if(resp.contains("who")||resp.contains("risk"))
            {
                String print = null;
                for(int i =0;i<Articles.size();i++)
                {
                    ArrayList<String> article = Articles.get(i);
                    for(int j=0;j<article.size()-1;j++)
                    {
                    String line = article.get(j).toLowerCase();
                    if(line.contains(" Risk")||line.contains(" risk"))
                    {
                    for(int h = j+1;h<=article.size()-1;h++)
                    {
                        print=article.get(h);
                        if(print.equals(""))
                        break;
                        System.out.println(print);
                    }
                    break;
                    }
                }
                if (print!=null)
                break;
                }
            }
            else if(resp.contains("transmitt")||resp.contains("transmiss"))
            {
                String print = null;
                for(int i =0;i<Articles.size();i++)
                {
                    ArrayList<String> article = Articles.get(i);
                    for(int j=0;j<article.size()-1;j++)
                    {
                    String line = article.get(j).toLowerCase();
                    if(line.contains("Transmission")||line.contains("transmission"))
                    {
                    for(int h = j+1;h<=article.size()-1;h++)
                    {
                        print=article.get(h);
                        if(print.equals(""))
                        break;
                        System.out.println(print);
                    }
                    break;
                    }
                }
                if (print!=null)
                break;
                }
            }
            else if(resp.contains("vaccine"))
            {
                String print = null;
                for(int i =0;i<Articles.size();i++)
                {
                    ArrayList<String> article = Articles.get(i);
                    for(int j=0;j<article.size()-1;j++)
                    {
                    String line = article.get(j).toLowerCase();
                    if(line.contains("vaccine:"))
                    {
                    for(int h = j;h<=article.size()-1;h++)
                    {
                        print=article.get(h);
                        if(print.equals(""))
                        break;
                        System.out.println(print);
                    }
                    break;
                    }
                }
                if (print!=null)
                break;
                }
            }
            else if(resp.contains("more information"))
            {
                String print = null;
                for(int i =0;i<Articles.size();i++)
                {
                    ArrayList<String> article = Articles.get(i);
                    for(int j=0;j<article.size()-1;j++)
                    {
                    String line = article.get(j).toLowerCase();
                    if(line.contains("outlook"))
                    {
                    for(int h = j+1;h<=article.size()-1;h++)
                    {
                        print=article.get(h);
                        if(print.equals(""))
                        break;
                        System.out.println(print);
                    }
                    break;
                    }
                }
                if (print!=null)
                break;
                }
            }
            //when the user wants to end the program they enter quit, and the program will terminate
            else if(resp.equalsIgnoreCase("quit"))
            {
                quit = true;
                System.out.println("Thank you for using the disease chatbot.");
                System.exit(0);
            }
            //If the user input matches none of the known questions, then it simply asks the user to enter another question
            else
            {
                System.out.println("Sorry, I could not understand this input");
            }
            System.out.println();
        }
    }
}
