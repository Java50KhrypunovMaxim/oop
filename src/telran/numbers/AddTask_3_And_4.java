package telran.numbers;

public class AddTask_3_And_4 
{
	public static boolean isAnagram(String sourceWord, String targetWord) {
	 
	    sourceWord = sourceWord.toLowerCase();
	    targetWord = targetWord.toLowerCase();
	    boolean res = true;
	    if (sourceWord.length() != targetWord.length()){
	        return res = false;
	    };

	    int[] letterCount = new int[26];

	    for (char letter : sourceWord.toCharArray()) {
	        letterCount[letter - 'a']++;
	    }
	    for (char letter : targetWord.toCharArray()) {
	        letterCount[letter - 'a']--;
	    }

	    for (int count : letterCount) {
	        if (count != 0) {
	            return res = false;
	        }
	    }
	    return res;
	}
	public static boolean hasValidBrackets(String text) 
	{
		 	int roundBracketCount = 0;
		    int squareBracketCount = 0;
		    int curlyBracketCount = 0;
		    boolean res = false;
		    char [] symbol = text.toCharArray();
		    for (int i = 0; text.length()>i; i++)
		    {
	
		    	if (symbol[i] == '(') 
		    	{roundBracketCount++;
		    	} 
		    	else if (symbol[i] == ')') {roundBracketCount--;
		    
		        if (roundBracketCount < 0) 
		        { res = false; break;}}
		            
		        else if (symbol[i] == '[') 
		        {squareBracketCount++;
		        } 
		        else if (symbol[i] == ']') {squareBracketCount--;
		        if (squareBracketCount < 0) {
		        res = false; break;}} 
		            
		         else if (symbol[i] == '{') 
		         {curlyBracketCount++;} 
		         else if (symbol[i] == '}') {curlyBracketCount--;
		         if (curlyBracketCount < 0) {
		         res = false; 
				 break;}}}
		    	 res = roundBracketCount == 0 && squareBracketCount == 0 &&
		    	 curlyBracketCount == 0? true:false;
		    	
		    	 return res;
	}
	public static boolean hasValidBrackets2(String text) {
	    int roundBracketCount = 0;
	    int squareBracketCount = 0;
	    int curlyBracketCount = 0;
	    char[] symbol = text.toCharArray();
	    
	    for (int i = 0; i < text.length(); i++) {
	        if (symbol[i] == '(') {
	            roundBracketCount++;
	        } else if (symbol[i] == ')') {
	            roundBracketCount--;
	            if (roundBracketCount < 0) {
	                return false;
	            }
	        } else if (symbol[i] == '[') {
	            squareBracketCount++;
	        } else if (symbol[i] == ']') {
	            squareBracketCount--;
	            if (squareBracketCount < 0) {
	                return false;
	            }
	        } else if (symbol[i] == '{') {
	            curlyBracketCount++;
	        } else if (symbol[i] == '}') {
	            curlyBracketCount--;
	            if (curlyBracketCount < 0) {
	                return false;
	            }
	        }
	    }
	    
	    return roundBracketCount == 0 && squareBracketCount == 0 && curlyBracketCount == 0;
	}


}
		    

