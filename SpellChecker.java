
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction + " since levenshtein(" + word + ") == " + threshold);
	}

	public static String tail(String str) 
	{
		if (str.length() == 1)
		{
			String s= "";
			return s;
		}		
		return str.substring(1);
	}

	public static int levenshtein(String word1, String word2) {
		String a = word1.toLowerCase();
		String b = word2.toLowerCase(); 
		if (b.length() == 0)
		{
			return a.length();
		}
		if (a.length() == 0)
		{
			return b.length();
		}
		if (a.charAt(0) == b.charAt(0))
		{
			return levenshtein(tail(a), tail(b));
		}
		else 
		{
			return 1 + Math.min(levenshtein(tail(a), tail(b)),Math.min((levenshtein(tail(a), b)),levenshtein(a, tail(b))));
		}
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		int index = 0;
		while (!in.isEmpty())
		{
			String word = in.readLine(); 
			dictionary[index] = word;
			index++;
		}
		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		int min = levenshtein(word, dictionary[0]); //gets a first minimal value for the word
		int index = 1;
		for (int i = 1; i<dictionary.length; i++)
		{
			if (min >= levenshtein(word, dictionary[i]))
			{
				min = levenshtein(word, dictionary[i]); //updates the minimum according to the values
				index = i;
			}
		}
		if (min > threshold)
		{
			String s = ""; 
			return s; 
		}
		else 
		{
			return dictionary[index];
		}
		
	}

}
