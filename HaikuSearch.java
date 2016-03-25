import java.io.*;
import java.util.regex.Pattern;

public class HaikuSearch {

	public static int countSyllables(String word){
		int nVowels = 0;
		int haiku = 0;
		char[] v = {'a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y'};
		char[] words = word.toCharArray();
		boolean prevVowel = false;
		
		for( char x : words){  //credit from StackOverFlow
			boolean fVowel = false;
		for(char i : v ){
		
			if ( (i == x) && prevVowel){
				fVowel = true;
				prevVowel = true;
				break;
			}
			else if ((i == x) && !prevVowel){
				nVowels++;
				fVowel = true;
				prevVowel = true;
				break;
			}
			
		}
		
		if(!fVowel){
			prevVowel = false;
		}
		if(nVowels == 5 && nVowels.nextInt() == 7 && nVowels.nextInt() == 5){
			haiku++;
			System.out.println(haiku);
		}
		
	}
		return nVowels;
	}
	
	
	public static void main(String[] args) throws IOException {
	    
		String textFile = "C:/Users/Win8/workspace/Haiku/src/haiku.txt";

		String line = null;
		
		try{
			FileReader FR = new FileReader(textFile);
			BufferedReader BR = new BufferedReader(FR);
			
			while((line = BR.readLine()) != null){
				int haiku = 0;
				System.out.println(line);
				String[] words = Pattern.compile("\\s+").split(line);   //Credit from StackOverflow
				System.out.println(words.length);
				int word = countSyllables(line);
				System.out.println(word);
				
				
	
			}
			
			BR.close();
			
		} catch(FileNotFoundException ex){
			System.out.println("Can't open file!");
		} catch(IOException ex){
			System.out.println("Error reading the file.");
		}
	}

}
