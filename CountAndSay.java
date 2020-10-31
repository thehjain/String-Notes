

// Input: n = 4
// Output: "1211"
// Explanation:
// countAndSay(1) = "1"
// countAndSay(2) = say "1" = one 1 = "11"
// countAndSay(3) = say "11" = two 1's = "21"
// countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"



class CountAndSay {
	public static void main(String[] args) {

		int n = 4;

		System.out.println(countAndSay(n));

	}
	static String countAndSay(int n) {
		String s = "1";
		for (int i = 1; i < n; i++)
			s = countIndex(s);
		return s;
	}
	static String countIndex(String s) {
		StringBuilder sb = new StringBuilder();
		char c = s.charAt(0);
		int count = 1;
		for (int i = 1; i < s.length(); i++)
			if (s.charAt(i) == c)
				count++;
			else {
				sb.append(count);
				sb.append(c);
				c = s.charAt(i);
				count = 1;
			}
		sb.append(count);
		sb.append(c);
		return sb.toString();
	}

}

//problem is present on leetcode