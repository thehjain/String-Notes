//Here we have given a string and we have to match
//give pattern in it.

//Brute force apprach is to check every same length
//substring with pattern


//Efficient approach is to use rabin karp algorithm
//It uses hash function to match patter in a string
//If hash value matches after that it check if pattern
//is matching or not


//Solution is available on tushar roy's git account

class RabinKarpAlgo {

	private static int prime = 101;

	public static void main(String[] args) {

		System.out.println(patternSearch("TusharRoy".toCharArray(), "sharRoy".toCharArray()));
		System.out.println(patternSearch("TusharRoy".toCharArray(), "Roy".toCharArray()));
		System.out.println(patternSearch("TusharRoy".toCharArray(), "shas".toCharArray()));
		System.out.println(patternSearch("TusharRoy".toCharArray(), "usha".toCharArray()));
		System.out.println(patternSearch("TusharRoy".toCharArray(), "Tus".toCharArray()));

	}

	static long createHash(char[] arr, int end) {
		long hash = 0;
		for (int i = 0; i <= end; i++)
			hash += arr[i] * Math.pow(prime, i);
		return hash;
	}

	static boolean checkEqual(char[] txt, int start, int end, char[] patt, int pstart, int pend) {
		if (end - start != pend - pstart)
			return false;
		while (start <= end && pstart <= pend) {
			if (txt[start] != patt[pstart])
				return false;
			start++;
			pstart++;
		}
		return true;
	}

	static long recalculateHash(char[] txt, int start, int newIndex, long hash, int m) {
		long newHash = hash - txt[start];
		newHash /= prime;
		newHash += txt[newIndex] * Math.pow(prime, m - 1);
		return newHash;
	}

	static int patternSearch(char[] txt, char[] patt) {

		int m = patt.length;
		int n = txt.length;

		long pattHash = createHash(patt, m - 1);
		long txtHash = createHash(txt, m - 1);

		for (int i = 1; i < ( n - m + 2); i++) {

			if (pattHash == txtHash && checkEqual(txt, i - 1, i + m - 2, patt, 0, m - 1))
				return i - 1;

			if (i < n - m + 1)
				txtHash = recalculateHash(txt, i - 1, i + m - 1, txtHash, m);

		}
		return -1;
	}

}


//Problem is available on geeksforgeeks