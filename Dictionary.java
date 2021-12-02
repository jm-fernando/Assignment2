import java.util.*;
import java.lang.*;


public interface Dictionary {

	public void insert(String s);
	public static boolean find(String s) {
		return false;
	}

	//function for possible suggestions
	public static List<String> suggest (String token, int count){
		List<String> suggestions = new ArrayList<String>();
		
		String temp = "";
		//alphabet in lower and upper case to cover all possibilities
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] charAlpha = alphabet.toCharArray();
		
		//appending a letter
		for(int i = 0; i < charAlpha.length; i++) {
			temp = token;
			if(find(temp += charAlpha[i]) && !suggestions.contains(temp)) {
				suggestions.add(temp);
			}
		}
		
		//add a letter in between
		for(int i = 0; i < token.length(); i++) {
			for(int j = 0; j < charAlpha.length; j++) {
				temp = token.substring(0, i) + charAlpha[j] + token.substring(i);
				if(find(temp) && !suggestions.contains(temp)) {
					suggestions.add(temp);
				}
			}
		}
		
		//replace every letter
		for(int i = 0; i < token.length(); i++) {
			for(int j = 0; j < charAlpha.length; j++) {
				if(i == token.length() - 1) {
					temp = token.substring(0, i) + charAlpha[j];
				} else {
					temp = token.substring(0, i) + charAlpha[j] + token.substring(i + 1);
				}
				
				if(find(temp) && !suggestions.contains(temp)){
					suggestions.add(temp);
				}
			}
		}
		
		//removing a letter
		for(int i = 0; i < token.length(); i++) {
			temp = token.substring(0, i) + token.substring(i + 1);
			if(find(temp) && !suggestions.contains(temp)) {
				suggestions.add(temp);
			}
		}
		
		//swapping letters
		for(int i = 0; i < token.length() - 1; i++) {
			char[] ch = swap(i, i + 1, token);
			temp = new String(ch);
			if(find(temp) && !suggestions.contains(temp)) {
				suggestions.add(temp);
			}
		}
		
		//listing all possible suggestions
		for(int i = suggestions.size(); i < count; i++) {
			String sug = suggestions.get(i);
			suggestions.clear();
			suggestions.add(sug);
		}
		return suggestions;
	}
	
	//helper function for swapping
	static char[] swap(int i, int j, String s) {
		char ch[] = s.toCharArray();
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
		return ch;
	}
	
}
