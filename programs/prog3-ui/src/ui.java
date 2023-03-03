//Written by Lucas Aust
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class ui {
public static Scanner keyboard = new Scanner(System.in);
public static ArrayList<String> CDCArticle = new ArrayList<String>();
public static ArrayList<String> WebMDArticle = new ArrayList<String>();
public static ArrayList<ArrayList<String>> Articles = new ArrayList<ArrayList<String>>();
public static void main(String[] args)
{
    System.out.println("Welcome to the disease chatbot!");
    disease();
}
public static void disease()
{
    ArrayList<String> whatIs = new ArrayList<String>();//These arrayList are the default arrayLists that the disease will be based on
    ArrayList<String> whoIs = new ArrayList<String>();
    ArrayList<String> whatCanTravelers = new ArrayList<String>();
    ArrayList<String> afterTravel = new ArrayList<String>();
    ArrayList<String> moreInfo = new ArrayList<String>();
    ArrayList<String> types = new ArrayList<String>();
    ArrayList<String> symptoms = new ArrayList<String>();
    ArrayList<String> whenToCall = new ArrayList<String>();
    ArrayList<String> diagnosis = new ArrayList<String>();
    ArrayList<String> treatment = new ArrayList<String>();
    ArrayList<String> complications = new ArrayList<String>();
    ArrayList<String> vaccine = new ArrayList<String>();
    ArrayList<String> transmission = new ArrayList<String>();
    ArrayList<String> causes = new ArrayList<String>();
    System.out.println("Enter the disease you would like to talk about.");
    String diseaseName = keyboard.nextLine();
    System.out.println("This system runs on information from text file versions of a WebMD article, and a CDC article");
    System.out.println("Enter the name of your WebMD File.");
    String WebMDFile = keyboard.nextLine();
    System.out.println("Enter the name of your CDC file.");
    String CDCFile = keyboard.nextLine();
    WebMDArticle = readFile(WebMDFile,WebMDArticle);
    CDCArticle = readFile(CDCFile, CDCArticle);
    Articles.add(WebMDArticle);
    Articles.add(CDCArticle);
    //Creating the disease with only the articles and disease name
    disease disease = new disease(diseaseName, CDCArticle, WebMDArticle, whatIs, whoIs, whatCanTravelers, afterTravel, moreInfo, types, symptoms, whenToCall, diagnosis, treatment, complications, vaccine, transmission,causes);
    //Setting all of the diseases characteristics
    disease.setWhatIs(Articles);
    disease.setWhoIs(Articles);
    disease.setWhatCanTravelers(Articles);
    disease.setAfterTravel(Articles);
    disease.setMoreInfo(Articles);
    disease.setTypes(Articles);
    disease.setSymptoms(Articles);
    disease.setWhenToCall(Articles);
    disease.setDiagnosis(Articles);
    disease.setTreatment(Articles);
    disease.setComplications(Articles);
    disease.setVaccine(Articles);
    disease.setTransmission(Articles);
    disease.setCauses(Articles);
    bot(disease);
}
//Main method for the chat bot
public static void bot(disease disease)
{
    String resp = "";
    boolean quit = false;
    while(!quit)//Loop that continues until user wants to stop asking questions
    {
        ArrayList<String> ret = new ArrayList<String>();
        System.out.println("Ask me a question about the disease or enter \"quit\" to exit the program.");
        resp = keyboard.nextLine();
        resp = resp;
        resp = resp.toLowerCase();
        System.out.println();
        if(resp.contains("what is polio"))//This check will establish what the user wants to know, repeated multiple times below
        {
            ret = disease.getWhatIs();
            if (ret.size()==0)//Check to see if the arrayList is empty, if it is then it will not have any answer and say that 
            {
                System.out.println("Sorry, I have no information on that question.");
            }
            for(int i=0;i<ret.size();i++)//Loop to print all of the information
            {
                System.out.println(ret.get(i));
            }
        }
        //Each else if has the same functionality. The only difference is what specific question the program is checking for
        else if(resp.contains("cause")||resp.contains("causes"))
        {
            ret = disease.getCauses();
            if (ret.size()==0)
            {
                System.out.println("Sorry, I have no information on that question.");
            }
            for(int i=0;i<ret.size();i++)
            {
                System.out.println(ret.get(i));
            }
        }
        else if(resp.contains("symptom")||resp.contains("Symptom"))
        {
            ret = disease.getSymptoms();
            if (ret.size()==0)
            {
                System.out.println("Sorry, I have no information on that question.");
            }
            for(int i=0;i<ret.size();i++)
            {
                System.out.println(ret.get(i));
            }
        }
        else if(resp.contains("prevent")||resp.contains("prevents"))
        {
            ret = disease.getWhatCanTravelers();
            if (ret.size()==0)
            {
                System.out.println("Sorry, I have no information on that question.");
            }
            for(int i=0;i<ret.size();i++)
            {
                System.out.println(ret.get(i));
            }
        }
        else if(resp.contains("who")||resp.contains("risk"))
        {
            ret = disease.getWhoIs();
            if (ret.size()==0)
            {
                System.out.println("Sorry, I have no information on that question.");
            }
            for(int i=0;i<ret.size();i++)
            {
                System.out.println(ret.get(i));
            }
        }
        else if(resp.contains("transmitt")||resp.contains("transmiss"))
        {
            ret = disease.getTransmission();
            if (ret.size()==0)
            {
                System.out.println("Sorry, I have no information on that question.");
            }
            for(int i=0;i<ret.size();i++)
            {
                System.out.println(ret.get(i));
            }
        }
        else if(resp.contains("vaccine"))
        {
            ret = disease.getVaccine();
            if (ret.size()==0)
            {
                System.out.println("Sorry, I have no information on that question.");
            }
            for(int i=0;i<ret.size();i++)
            {
                System.out.println(ret.get(i));
            }
        }
        else if(resp.contains("more information"))
        {
            ret = disease.getMoreInfo();
            if (ret.size()==0)
            {
                System.out.println("Sorry, I have no information on that question.");
            }
            for(int i=0;i<ret.size();i++)
            {
                System.out.println(ret.get(i));
            }
        }
        else if(resp.contains("after travel"))
        {
            ret = disease.getAfterTravel();
            if (ret.size()==0)
            {
                System.out.println("Sorry, I have no information on that question.");
            }
            for(int i=0;i<ret.size();i++)
            {
                System.out.println(ret.get(i));
            }
        }
        else if(resp.contains("types"))
        {
            ret = disease.getAfterTravel();
            if (ret.size()==0)
            {
                System.out.println("Sorry, I have no information on that question.");
            }
            for(int i=0;i<ret.size();i++)
            {
                System.out.println(ret.get(i));
            }
        }
        else if(resp.contains("when")&&resp.contains("call"))
        {
            ret = disease.getWhenToCall();
            if (ret.size()==0)
            {
                System.out.println("Sorry, I have no information on that question.");
            }
            for(int i=0;i<ret.size();i++)
            {
                System.out.println(ret.get(i));
            }
        }
        else if(resp.contains("diagnosis"))
        {
            ret = disease.getDiagnosis();
            if (ret.size()==0)
            {
                System.out.println("Sorry, I have no information on that question.");
            }
            for(int i=0;i<ret.size();i++)
            {
                System.out.println(ret.get(i));
            }
        }
        else if(resp.contains("treatment"))
        {
            ret = disease.getTreatment();
            if (ret.size()==0)
            {
                System.out.println("Sorry, I have no information on that question.");
            }
            for(int i=0;i<ret.size();i++)
            {
                System.out.println(ret.get(i));
            }
        }
        else if(resp.contains("complications"))
        {
            ret = disease.getComplications();
            if (ret.size()==0)
            {
                System.out.println("Sorry, I have no information on that question.");
            }
            for(int i=0;i<ret.size();i++)
            {
                System.out.println(ret.get(i));
            }
        }
        else if(resp.contains("everything"))
        {
            for(int i = 0;i<Articles.size();i++)
            {
                ArrayList<String> article=Articles.get(i);
                for(int j = 0;j < article.size();j++)
                {
                    System.out.println(article.get(j));
                }
                System.out.println();
                System.out.println();
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

//Method to read the file into an array list, and then returns the array list
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
            scan.close();
            }
            catch(Exception e)
            {
                System.out.println("Cannot open the file. Restarting the program");
                disease();
            }
            
            return data;
    }
}
