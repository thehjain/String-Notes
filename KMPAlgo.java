//KMP (Kruth-Morris-Pat) Algorithm is also used for
//pattern matching like rabinkarp algo

//This is also another efficient algo to find the
//pattern is existing in string or not

//It will time compexity of O(n)

//Approach
//Here we try to use the previously matched characters and
//we do match only the new character. We do this using one
//extra array of same size of string

class KMPAlgo {

	public static void main(String[] args) {

		String txt = "ABABDABACDABABCABAB";
		String pat = "ABABCABAB";

		kmpSearch(txt, pat);

	}

	static void computeLPS(String pat, int m, int[] lps) {

		lps[0] = 0;
		int i = 1;
		int len = 0;

		while (i < m) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0)
					len = lps[len - 1];
				else {
					lps[i] = len;
					i++;
				}
			}
		}
	}

	static void kmpSearch(String txt, String pat) {

		int m = pat.length();
		int n = txt.length();
		int[] lps = new int[m];

		computeLPS(pat, m, lps);

		int i = 0;
		int j = 0;
		while (i < n) {
			if (pat.charAt(j) == txt.charAt(i)) {
				i++;
				j++;
			}
			if (j == m) {
				System.out.println("Found pattern at index " + (i - j));
				j = lps[j - 1];
			} else if (i < n && pat.charAt(j) != txt.charAt(i)) {
				if (j != 0)
					j = lps[j - 1];
				else
					i++;
			}
		}

	}

}

//Problem is available on geeksforgeeks