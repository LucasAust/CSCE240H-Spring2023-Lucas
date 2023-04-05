import java.util.ArrayList;

public class disease {
    public String diseaseName;
    public ArrayList<String> CDCArticle;
    public ArrayList<String> WebMDArticle;
    public ArrayList<String> whatIs;
    public ArrayList<String> whoIs;
    public ArrayList<String> whatCanTravelers;
    public ArrayList<String> afterTravel;
    public ArrayList<String> moreInfo;
    public ArrayList<String> types;
    public ArrayList<String> symptoms;
    public ArrayList<String> whenToCall;
    public ArrayList<String> diagnosis;
    public ArrayList<String> treatment;
    public ArrayList<String> complications;
    public ArrayList<String> vaccine;
    public ArrayList<String> transmission;
    public ArrayList<String> causes;
    //This is the constructor for the disease. Builds a disease based on given inputs.
    public disease(String diseaseName, ArrayList<String> cDCArticle, ArrayList<String> webMDArticle,
            ArrayList<String> whatIs, ArrayList<String> whoIs, ArrayList<String> whatCanTravelers,
            ArrayList<String> afterTravel, ArrayList<String> moreInfo, ArrayList<String> types,
            ArrayList<String> symptoms, ArrayList<String> whenToCall, ArrayList<String> diagnosis,
            ArrayList<String> treatment, ArrayList<String> complications, ArrayList<String> vaccine, ArrayList<String> transmission, ArrayList<String> causes) {
        this.diseaseName = diseaseName;
        CDCArticle = CDCArticle;
        WebMDArticle = WebMDArticle;
        this.whatIs = whatIs;
        this.whoIs = whoIs;
        this.whatCanTravelers = whatCanTravelers;
        this.afterTravel = afterTravel;
        this.moreInfo = moreInfo;
        this.types = types;
        this.symptoms = symptoms;
        this.whenToCall = whenToCall;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.complications = complications;
        this.vaccine = vaccine;
        this.transmission = transmission;
        this.causes = causes;
    }
    public static ArrayList<ArrayList<String>> Articles = new ArrayList<ArrayList<String>>();
    

    public ArrayList<String> getTransmission() {
        return transmission;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public ArrayList<String> getCDCArticle() {
        return CDCArticle;
    }

    public void setCDCArticle(ArrayList<String> article) {
        CDCArticle = article;
    }

    public ArrayList<String> getWebMDArticle() {
        return WebMDArticle;
    }

    public void setWebMDArticle(ArrayList<String> article) {
        WebMDArticle = article;
    }
    //Get method to return the desired characteristic
    public ArrayList<String> getWhatIs() {
        return whatIs;
    }
    //For each setter, I loop through each article to find the correct information, and then add that information to the arrayList which serves as the diseases characteristic
    public void setWhatIs(ArrayList<ArrayList<String>> Articles) {
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

                    whatIs.add(print);//Prints each line to the console
                }
                break;
                }
            }
            if (print!=null)
            {//If print is null, then the first article did not have the desired information.
            whatIs.add("Source: "+article.get(0));//This will always be the file name
            break;
            }
            }      
    }

    public ArrayList<String> getWhoIs() {
        return whoIs;
    }

    public void setWhoIs(ArrayList<ArrayList<String>> Articles) {
        String print = null;
            for(int i =0;i<Articles.size();i++)
            {
                ArrayList<String> article = Articles.get(i);
                for(int j=0;j<article.size();j++)
                {
                String line = article.get(j);
                if(line.contains(" risk")&&line.contains("Who "))
                {
                for(int h = j+1;h<article.size()-1;h++)
                {
                    print=article.get(h);
                    if(print.equals(""))
                    break;

                    whoIs.add(print);
                }
                }
            }
            if (print!=null)
            {
            whoIs.add("Source: "+article.get(0));
            break;
            }
            }
    }
    //These functionalities are repeated for each of the characteristics
    public ArrayList<String> getCauses() {
        return causes;
    }

    public void setCauses(ArrayList<ArrayList<String>> Articles) {
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

                        causes.add(print);
                    }
                    }
                }
                if (print!=null)
                {
                causes.add("Source: "+article.get(0));
                break;
                }
                }
    }

    public ArrayList<String> getWhatCanTravelers() {
        return whatCanTravelers;
    }

    public void setWhatCanTravelers(ArrayList<ArrayList<String>> Articles) {
        String print = null;
        for(int i =0;i<Articles.size();i++)
        {
            ArrayList<String> article = Articles.get(i);
            for(int j=0;j<article.size()-1;j++)
            {
            String line = article.get(j).toLowerCase();
            if(line.contains("travelers")&&line.contains("prevent"))
            {
            for(int h = j+1;h<=article.size()-1;h++)
            {
                print=article.get(h);
                if(print.equals(""))
                break;
                whatCanTravelers.add(print);
            }
            }
        }
        if (print!=null)
        {
        whatCanTravelers.add("Source: "+article.get(0));
        break;
        }
        }
    }

    public ArrayList<String> getAfterTravel() {
        return afterTravel;
    }

    public void setAfterTravel(ArrayList<ArrayList<String>> Articles) {
        String print = null;
        for(int i =0;i<Articles.size();i++)
        {
            ArrayList<String> article = Articles.get(i);
            for(int j=0;j<article.size()-1;j++)
            {
            String line = article.get(j).toLowerCase();
            if(line.contains("after")&&line.contains("travel"))
            {
            for(int h = j+1;h<=article.size()-1;h++)
            {
                print=article.get(h);
                if(print.equals(""))
                break;
                afterTravel.add(print);
            }
            }
        }
        if (print!=null)
        {
        afterTravel.add("Source: "+article.get(0));
        break;
        }
    }
    }

    public ArrayList<String> getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(ArrayList<ArrayList<String>> Articles) {
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
                moreInfo.add(print);
            }
            break;
            }
        }
        if (print!=null)
        {
        moreInfo.add("Source: "+article.get(0));
        break;
        }
        }
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<ArrayList<String>> Articles) {
        String print = null;
        for(int i =0;i<Articles.size();i++)
        {
            ArrayList<String> article = Articles.get(i);
            for(int j=0;j<article.size()-1;j++)
            {
            String line = article.get(j).toLowerCase();
            if(line.contains("types")&&line.contains("vaccine")!=true)
            {
            for(int h = j+1;h<=article.size()-1;h++)
            {
                print=article.get(h);
                if(print.equals(""))
                break;
                types.add(print);
            }
            break;
            }
        }
        if (print!=null)
        {
        types.add("Source: "+article.get(0));
        break;
        }
        }
    }

    public ArrayList<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(ArrayList<ArrayList<String>> Articles) {
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

                    symptoms.add(print);
                }
                }
            }
            if (print!=null)
            {
            symptoms.add("Source: "+article.get(0));
            break;
            }
            }
    }

    public ArrayList<String> getWhenToCall() {
        return whenToCall;
    }

    public void setWhenToCall(ArrayList<ArrayList<String>> Articles) {
        String print = null;
            for(int i =0;i<Articles.size();i++)
            {
                ArrayList<String> article = Articles.get(i);
                for(int j=0;j<article.size();j++)
                {
                String line = article.get(j);
                if(line.contains("call")&&line.contains("doctor"))
                {
                for(int h = j+1;h<article.size()-1;h++)
                {
                    print=article.get(h);
                    if(print.equals(""))
                    break;

                    whenToCall.add(print);
                }
                }
            }
            if (print!=null)
            {
            whenToCall.add("Source: "+article.get(0));
            break;
            }
            }
    }

    public ArrayList<String> getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(ArrayList<ArrayList<String>> Articles) {
        String print = null;
            for(int i =0;i<Articles.size();i++)
            {
                ArrayList<String> article = Articles.get(i);
                for(int j=0;j<article.size();j++)
                {
                String line = article.get(j);
                if(line.contains("diagnose"))
                {
                for(int h = j+1;h<article.size()-1;h++)
                {
                    print=article.get(h);
                    if(print.equals(""))
                    break;

                    diagnosis.add(print);
                }
                }
            }
            if (print!=null)
            {
            diagnosis.add("Source: "+article.get(0));
            break;
            }
        }
    }

    public ArrayList<String> getTreatment() {
        return treatment;
    }

    public void setTreatment(ArrayList<ArrayList<String>> Articles) {
        String print = null;
            for(int i =0;i<Articles.size();i++)
            {
                ArrayList<String> article = Articles.get(i);
                for(int j=0;j<article.size();j++)
                {
                String line = article.get(j);
                if(line.contains("Treatment"))
                {
                for(int h = j+1;h<article.size()-1;h++)
                {
                    print=article.get(h);
                    if(print.equals(""))
                    break;

                    treatment.add(print);
                }
                }
            }
            if (print!=null)
            {
            treatment.add("Source: "+article.get(0));
            break;
            }
        }
    }

    public ArrayList<String> getComplications() {
        return complications;
    }

    public void setComplications(ArrayList<ArrayList<String>> Articles) {
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

                    complications.add(print);
                }
                }
            }
            if (print!=null)
            {
            complications.add("Source: "+article.get(0));
            break;
            }
        }
    }

    public ArrayList<String> getVaccine() {
        return vaccine;
    }

    public void setVaccine(ArrayList<ArrayList<String>> Articles) {
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
                    vaccine.add(print);
                }
                break;
                }
            }
            if (print!=null)
            {
            vaccine.add("Source: "+article.get(0));
            break;
            }
        }
    }
    public void setTransmission(ArrayList<ArrayList<String>> Articles) {
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
                    transmission.add(print);
                }
                break;
                }
            }
            if (print!=null)
            {
            transmission.add("Source: "+article.get(0));
            break;
            }
        }
    }
    
}
