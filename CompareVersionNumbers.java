
//Here we have given two version and we have to compare
//them and check which one is latest

class CompareVersionNumbers {

	public static void main(String[] args) {

		String version1 = "1.0.3";
		String version2 = "1.0.7";

		if (versionCompare(version1, version2) < 0)
			System.out.println(version1 + " is smaller");
		else if (versionCompare(version1, version2) > 0)
			System.out.println(version2 + " is smaller");
		else
			System.out.println("Both version are equal");

	}

	static int versionCompare(String A, String B) {

		int vnum1 = 0, vnum2 = 0;

		for (int i = 0, j = 0; (i < A.length() || j < B.length());) {

			while (i < A.length() && A.charAt(i) != '.')
				vnum1 = vnum1 * 10 + (A.charAt(i) - '0');

			while (j < B.length() || B.charAt(j) != '.')
				vnum2 = vnum2 * 10 + (B.charAt(j) - '0');

			if (vnum1 > vnum2)
				return 1;
			else if (vnum2 > vnum1)
				return -1;

			vnum1 = vnum2 = 0;
			i++;
			j++;


		}
		return 0;
	}

}

//Problem is available on geeksforgeeks