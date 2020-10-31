//Check if two string are anagrams

//Naive approach is to convert the string into an arrays
//and check after sorting if they are equal or not
//it will time complexity of (nlogn).


//Efficient approach is to use one array of size 256 and
//store the count of characters in a string. and for other
//string keep decrementing the count of that character.
//and if at any point count going to negative return false.

class CheckForAnagrams {
	public static void main(String[] args) {

		String A = "geeksforgeeks";
		String B = "forgeeksgeeks";

		if (isAnagram(A, B))
			System.out.println("Yes, String are anagrams");
		else
			System.out.println("No, strings are not anagrams");

	}

	static boolean isAnagram(String A, String B) {

		if (A.length() != B.length())
			return false;

		int[] count = new int[256];

		for (int i = 0; i < A.length(); i++)
			count[A.charAt(i)]++;
		for (int i = 0; i < B.length(); i++) {
			count[B.charAt(i)]--;
			if (count[B.charAt(i)] < 0)
				return false;
		}
		return true;
	}
}

//Problem is available on geeksforgeeks