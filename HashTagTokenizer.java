

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000]; //creates a new dictionry with all the words
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

	public static boolean existInDictionary(String word, String []dictionary) {
		for (int i = 0; i<dictionary.length; i++)
		{
			String w1 = dictionary[i];
			if (w1.equalsIgnoreCase(word)== true)
			{
				return true;
			}
		}
		return false; 
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
 
        int N = hashtag.length();

        for (int i = 1; i <= N; i++) 
		{
			if(existInDictionary(hashtag.substring(0,i), dictionary))
			{
				System.out.println(hashtag.substring(0,i)); //if the word exist, print it
				breakHashTag(hashtag.substring(i), dictionary);
				return;
			}	
        }
    }

}
