//Here we have given an integer value
//and we have to convert it in roman value

//Simply store the corresponding roman values
//to integer values in an array


public String intToRoman(int num) {
	int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

	StringBuilder res = new StringBuilder();

	for (int i = 0; i < values.length; i++) {
		while (num >= values[i]) {
			num -= values[i];
			res.append(strs[i]);
		}
		if (num <= 0)
			break;
	}
	return res.toString();
}


//Problem is availabale on leetcode