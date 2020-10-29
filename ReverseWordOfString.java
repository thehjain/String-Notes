//here we have given a string we have to reverse the words
//of it.

//Example "I Love program".
//Output: "program Love I".

//Naive approach is to use extra array and by splitting
//and making new string

//Efficeint approach is to use StringBuilder

public String reverseWords(String s) {
	StringBuilder res = new StringBuilder();
	for (int start = s.length() - 1; start >= 0; start--) {
		if (s.charAt(start) == ' ')
			continue;
		int end = start;
		while (start >= 0 && s.charAt(start) != ' ')
			start--;
		res.append(s.substring(start + 1, end + 1)).append(" ");
	}
	return res.toString().trim();
}


//Problem is avaible on leetcode