import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class extractor {
    public static Scanner keyboard = new Scanner(System.in);
    public static ArrayList<String> CDCArticle = new ArrayList();
    public static ArrayList<String> WebMDArticle = new ArrayList();
    public static void main(String[] args) {
        
        System.out.println("Hello, welcome to the disease chatbot.");
        disease();
        

    }
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
    public static void polio()
    {
        System.out.println("Enter the name of the first file you would like to read.\nThe default file name is programs/prog1-extractor/data/CDCPolio.txt.\nEnter \"test\" to run the default file");
        String in = keyboard.nextLine();
        if (in.equalsIgnoreCase("Test"))
        in = "programs/prog1-extractor/data/CDCPolio.txt";
        String CDCFile = in;
        System.out.println("Enter the name of the second file you would like to read.\nThe default file name will be programs/prog1-extractor/data/WebMDPolio.txt.\nEnter \"test\" to run the default file.");
        in = keyboard.nextLine();
        if(in.equalsIgnoreCase("Test"))
        in = "programs/prog1-extractor/data/WebMDPolio.txt";
        String WebMDFile = in;
        System.out.println();
        System.out.println("Statistics about the CDC File: ");
        CDCArticle = readFile(CDCFile, CDCArticle);
        System.out.println();
        System.out.println("Statistics about the WebMDFile");
        WebMDArticle = readFile(WebMDFile, WebMDArticle);
        System.out.println();
        System.out.println("I will now print each article to an output file.\nThese files will appear in the data folder.");
        System.out.println();
        System.out.println("Enter the name of the first output file you would like.\nThe default output file is programs/prog1-extractor/data/CDCPolioOut.txt.\nEnter \"test\" to use the default test file.");
        in = keyboard.nextLine();
        if(in.equalsIgnoreCase("Test"))
        in ="programs/prog1-extractor/data/CDCPolioOut.txt";
        String CDCOut = in;
        writeFile(CDCOut,CDCArticle);
        System.out.println("Enter the name of the second output file you would like.\nThe default ouput file name is programs/prog1-extractor/data/WebMDPolioOut.txt.\nEnter \"test\" to use the default test file.");
        in = keyboard.nextLine();
        if(in.equalsIgnoreCase("Test"))
        in ="programs/prog1-extractor/data/WebMDPolioOut.txt";
        String webMDOut = in;
        writeFile(webMDOut,WebMDArticle);
        System.out.println("Files successfully outputted.");
    }
    public static ArrayList<String> readFile(String fileName, ArrayList<String> data)
    {
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;
        int i = 0;
        String line = "";
        try {
            File file = new File(fileName);
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine())
            {
                line = scan.nextLine();
                data.add(i,line);
                if (line != "")
                {
                wordCount += line.split("\s+").length;
                charCount +=line.length();
                }
                lineCount++;
                i++;
            }
        
        }
        catch(Exception e)
        {
            System.out.println("Cannot open the file. Restarting the program");
            polio();
        }
        System.out.println("Number of lines: "+lineCount);
        System.out.println("Number of words: "+wordCount);
        System.out.println("Number of characters: "+charCount);
        return data;
    }
    public static void writeFile(String fileName, ArrayList<String> list)
    {
        File file = new File(fileName);
        try {
            PrintWriter writer = new PrintWriter(file);
            for (int i = 0;i<list.size();i++) {
              String item = list.get(i);
              writer.println(item);
            }
            writer.close();
          } catch (FileNotFoundException e) {
            System.out.println("Cannot open the file. Restarting the program");
            polio();
          }
    }
}
