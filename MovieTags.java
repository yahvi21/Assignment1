import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieTags {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Invalid arguments");
            System.exit(0);
        }
        String filename = args[0];
        TagList tags = new TagList();
        
        //Read the data file
        System.out.println("Reading data file .....");
        read(tags, filename);
        tags.sort();
        
        //Lists tags in order of its count
        System.out.println(" ========================================== ");
        System.out.println("*** Highest 3 movies by count ***");
        for (int i = 1; i <= 3; ++i) {
            System.out.println(tags.get(tags.size() - i));
        }
       
        System.out.println("*** Lowest 3 movies by count ***");
        for (int i = 0; i < 3; ++i) {
            System.out.println(tags.get(i));
        }
        
        System.out.println(" ========================================== ");
        
        //Find tags by count or tag counts by name or tags by counts
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Search by Tag or Tag Count? (Enter T or C... or EXIT to exit): ");
        
            String input = sc.nextLine();
            switch (input) {
		//Case T to count the number of times that input tag occurs
                case "T":
                    System.out.print("Tag to search for: ");
                    String name = sc.nextLine();
                    System.out.print("Tag \"" + name + "\" "); 
                    Tag tag = tags.search(name);
                    if (tag == null) {
                        System.out.println("does not exist.");
                    } else {
                        System.out.println("occurred " + tag.getCount() + " times.");
                    }
                    break;
		//Case C to find the tag that occurs as many times as the input count
                case "C":
                    System.out.print("Count to search for: ");
                    input = sc.nextLine();
                    try {
                        int count = Integer.parseInt(input);
                        if (count <= 0) {
                            System.out.println("Invalid count");
                            continue;
                        }
                        System.out.print("Tags with " + count + " occurances");
                        ArrayList<Tag> tagsFound = tags.search(count);
                        if (tagsFound.isEmpty()) {
                            System.out.println(" do not exist");
                        } else {
                            System.out.println(":");
                            for (int i = 0; i < tagsFound.size(); ++i) {
                                System.out.println("* " + tagsFound.get(i).getName());
                            }
                        }
		    //Using try catch for NumberFormatException so the string is in correct format or error message is shown
                    } catch (NumberFormatException e) {
                        System.out.println("Is " + input + " even a number? C'mon, man!");
                    }
                    break;
                case "EXIT":
                    System.out.println("Bye!");
                    System.exit(0);
            }
        }
    }
    //Reads file line by line    
    private static void read(TagList tags, String filename) {
        File file = new File(filename);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
		//line is split into an array using the comma
                String[] arr = line.split(",");
                String tag = arr[2];
                tags.add(tag);
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }
}
