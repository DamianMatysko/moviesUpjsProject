import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Methods {
    public int moviesCanIWatchInTime(String path, int travelTime) throws IOException {
        int allFilmsLenght = 0;
        ArrayList<Films> listOfFilms = new ArrayList<Films>();
        ArrayList<Films> listOfMaxFilmsInTheTrain = new ArrayList<Films>();

        File f1 = new File(path); //Creation of File Descriptor for input file
        String[] words = null;  //Intialize the word Array
        String[] nameAndTime = null;  //Intialize the nameAndTime Array
        FileReader fr = new FileReader(f1);  //Creation of File Reader object
        BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
        String s;
        String input = "Java";   // Input word to be searched
        int count = 0;   //Intialize the word to zero
        while ((s = br.readLine()) != null)   //Reading Content from the file
        {
            words = s.split(" ");  //Split the word using space
            for (String word : words) {
                nameAndTime = word.split(":");
                listOfFilms.add(new Films(nameAndTime[0], Integer.valueOf(nameAndTime[1])));
            }
        }
        fr.close();

        System.out.println("Unsorted list of films");
        for (int i = 0; i < listOfFilms.size(); i++)
            System.out.println(listOfFilms.get(i).getName() + ":" + listOfFilms.get(i).getTime());

        Collections.sort(listOfFilms, new SortMinToMax());

        System.out.println("\nSorted list of films");
        for (int i = 0; i < listOfFilms.size(); i++)
            System.out.println(listOfFilms.get(i).getName() + ":" + listOfFilms.get(i).getTime());


        for (int i = 0; i < listOfFilms.size(); i++) {
            if (allFilmsLenght+listOfFilms.get(i).getTime() < travelTime) {
                allFilmsLenght += listOfFilms.get(i).getTime();
                listOfMaxFilmsInTheTrain.add(listOfFilms.get(i));
            }else {
                break;
            }
        }

        System.out.println("\nList of max film count per " + travelTime + " traveltime");
        for (int i = 0; i < listOfMaxFilmsInTheTrain.size(); i++)
            System.out.println(listOfMaxFilmsInTheTrain.get(i).getName() + ":" + listOfMaxFilmsInTheTrain.get(i).getTime());


        System.out.println("\nTime spend by watching series and movies: " + allFilmsLenght + " min");
        System.out.println("Time without watching series and movies: " + (travelTime - allFilmsLenght) + " min");
        System.out.println("////////////////////////////////////////////////////////////////////");
        return allFilmsLenght;
    }


}
