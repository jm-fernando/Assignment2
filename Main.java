import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static Dictionary data;
	
	//reads the csv file and stores all the words
	public static void csvRead() throws Exception {
		File file = new File("C:\\Users\\jerom\\Desktop/unigram_freq.csv");
		Scanner scan = new Scanner(file);
		while(scan.hasNext()) {
			String word = scan.next();
			data.insert(word);
		}
		scan.close();
	}
	
	//gets list of suggestions
	public static void listSuggestions(String input) throws Exception {
		Scanner scan = new Scanner(input);
		while(scan.hasNextLine()) {
			String word = scan.nextLine();
			List<String> suggestions = Dictionary.suggest(word, 5);
			String suggest = "";
			for(String s : suggestions) {
				suggest += s + " ";
			}
			System.out.println(suggest);
		}
		scan.close();
	}
	
	
	//main arg
	public static void main(String[] args) throws Exception {
		csvRead();
		listSuggestions(args[0]);
	}
	
}
