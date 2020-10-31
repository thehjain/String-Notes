//Here we have given a string and we have to find
//the number of characters needed to be inserted at starting
//of a string to make the string palindrome


//Naive approach is to start checking if a string is
//palindrome and if not keep deleting the characters from
//end of a string. And when it occurs as palindrome then
//number of characters deleted is the our answer

//Efficient approach is to compute lps array as we did
//in KMP Algorithm

//Reverse the string and add it after appending $ sign

// For string = AACECAAAA
// Concatenated String = AACECAAAA$AAAACECAA
// LPS array will be {0, 1, 0, 0, 0, 1, 2, 2, 2,
//                    0, 1, 2, 2, 2, 3, 4, 5, 6, 7}


class MinimumInsertionsPalindrome {

	public static void main(String[] args) {

		String str = "AACECAAAA";
		System.out.println(findInsertions(str));

	}

	static int[] computeLPS(String s) {

		int n = s.length();
		int[] lps = new int[n];
		int i = 1, len = 0;
		lps[0] = 0;

		while (i < n) {

			if (s.charAt(i) == s.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0)
					len = lps[len - 1];
				else {
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}

	static int findInsertions(String s) {

		StringBuilder st = new StringBuilder(s);
		String rev = st.reverse().toString();

		st.reverse().append("$").append(rev);

		int[] lps = computeLPS(st.toString());

		return s.length() - lps[st.length() - 1];

	}
}

//Problem is available on geeksforgeeks