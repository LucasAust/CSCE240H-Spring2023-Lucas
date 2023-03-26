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
    System.out.println("System: Welcome to the disease chatbot!");
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
    System.out.println("System: Enter the disease you would like to talk about.");
    System.out.print("User: ");
    String diseaseName = keyboard.nextLine();
    System.out.println("This system runs on information from text file versions of a WebMD article, and a CDC article");
    System.out.println("System: Enter the name of your WebMD File.");
    System.out.print("User: ");
    String WebMDFile = keyboard.nextLine();
    System.out.println("Enter the name of your CDC file.");
    System.out.print("User: ");
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
    boolean quit = false;
    while(!quit)//Loop that continues until user wants to stop asking questions
    {
        ArrayList<Double> percentages = new ArrayList<Double>();
        String resp = "";
        double minmatch = .7;
        String[] response;
        ArrayList<String> ret = new ArrayList<String>();
        System.out.println("System: Ask me a question about the disease or enter \"quit\" to exit the program.");
        System.out.print("User: ");
        resp = keyboard.nextLine();
        resp.replace("?","");//These avoid punctuation that would break calculations
        resp.replace(".","");
        response = resp.split(" ");
        String[] q1;
        String q1s = "What is "+disease.getDiseaseName();
        q1 = q1s.split(" ");//Populates the array with each word of the query
        String[] q2;
        String q2s = "Who is at risk";
        q2 = q2s.split(" ");
        String[] q3;
        String q3s = "travelers do to prevent";
        q3 = q3s.split(" ");
        String[] q4;
        String q4s = "prevent after travel";
        q4 = q4s.split(" ");
        String[] q5;
        String q5s = "more information";
        q5 = q5s.split(" ");
        String[] q6;
        String q6s = "what causes";
        q6 = q6s.split(" ");
        String[] q7;
        String q7s = "types";
        q7 = q7s.split(" ");
        String[] q8;
        String q8s = "symptoms";
        q8 = q8s.split(" ");
        String[] q9;
        String qs9 = "When should i call a doctor";
        q9 = qs9.split(" ");
        String[] q10;
        String q10s = "diagnosis";
        q10 = q10s.split(" ");
        String[] q11;
        String q11s = "treatment";
        q11 = q11s.split(" ");
        String[] q12;
        String q12s = "complications";
        q12 = q12s.split(" ");
        String[] q13;
        String q13s = "vaccine";
        q13 = q13s.split(" ");
        String[] q14;
        String q14s = "everything";
        q14 = q14s.split(" ");
        double q1p=querycheck(response,q1);//Calls teh method to calculate the matching percentage for each query
        percentages.add(q1p);
        double q2p=querycheck(response,q2);
        percentages.add(q2p);
        double q3p=querycheck(response,q3);
        percentages.add(q3p);
        double q4p=querycheck(response,q4);
        percentages.add(q4p);
        double q5p=querycheck(response,q5);
        percentages.add(q5p);
        double q6p=querycheck(response,q6);
        percentages.add(q6p);
        double q7p=querycheck(response,q7);
        percentages.add(q7p);
        double q8p=querycheck(response,q8);
        percentages.add(q8p);
        double q9p=querycheck(response,q9);
        percentages.add(q9p);
        double q10p=querycheck(response,q10);
        percentages.add(q10p);
        double q11p=querycheck(response,q11);
        percentages.add(q11p);
        double q12p=querycheck(response,q12);
        percentages.add(q12p);
        double q13p=querycheck(response,q13);
        percentages.add(q13p);
        double q14p=querycheck(response,q14);
        percentages.add(q14p);
        double maxMatch = sort(percentages);
        System.out.println("System:");
        if(resp.equalsIgnoreCase("quit"))
        {
            quit = true;
            System.out.println("Thank you for using the disease chatbot.");
            System.exit(0);
        }
        if(maxMatch<minmatch)
        {
            System.out.println("I could not understand this input, please rephrase and try again");
            bot(disease);
        }
        //The series of else if checks check to see which query has the highest match
        else if(maxMatch == q1p&&maxMatch!=q8p&&maxMatch!=q9p&&maxMatch!=q10p&&maxMatch!=q11p&&maxMatch!=q12p&&maxMatch!=q13p&&maxMatch!=q14p)
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
        else if(maxMatch == q2p)
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
        else if(maxMatch ==q3p&&maxMatch!=q4p)
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
        else if(maxMatch ==q4p)
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
        else if(maxMatch ==q5p)
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
        else if(maxMatch ==q6p)
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
        else if(maxMatch ==q7p)
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
        else if(maxMatch ==q8p)
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
        else if(maxMatch ==q9p)
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
        else if(maxMatch ==q10p)
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
        else if(maxMatch ==q11p)
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
        else if(maxMatch ==q12p)
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
        else if(maxMatch ==q13p)
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
        else if(maxMatch ==q14p)
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
    System.out.println();
    }
}

//Method to read the file into an array list, and then returns the array list
public static ArrayList<String> readFile(String fileName, ArrayList<String> data)
    {
        int i = 1;
        String line = "";
        try {
            File file = new File(fileName);
            Scanner scan = new Scanner(file);
            data.add(fileName);//Add the filename to the top line of the file, will only be accessed by calling for line 0
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
    //Checks what percentage of the query is included in the user response
    public static double querycheck(String[] response, String[] query)
    {
        double x = query.length;
        double count = 0;
        for(int i = 0;i<response.length;i++)
        {
            String word = response[i];
            for(int j = 0;j<query.length;j++)
            {
                String queryword = query[j];
                if (queryword.toLowerCase().equals(word.toLowerCase()))
                count++;
            }
        }
        double calc = count/x;
        return calc;
    }
    //Sorts the percentages and returns the highest match value
    public static double sort(ArrayList<Double> sort)
    {
        boolean sorted = false;
        double temp;
        while(!sorted){
            sorted = true;
            for(int i = 0;i<sort.size()-1; i++)
            {
                if (sort.get(i)>sort.get(i+1))
                {
                    temp = sort.get(i);
                    sort.set(i,sort.get(i+1));
                    sort.set(i+1,temp);
                    sorted = false;
                }
            }
        }
        return sort.get(sort.size()-1);
    }
}
