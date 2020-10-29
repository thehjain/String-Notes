//Here we have given a string
//consisting of white spaces,numerals and characters

//We have to find the first numeral number in string
//if found character first we have to return 0;

//base cases to be handled is numeral must be in between
//Integer.MIN && Integer.MAX


static int MAX = Integer.MAX_VALUE;
static int MIN = Integer.MIN_VALUE;
public int myAtoi(String s) {
	int i = 0, sign = 1, res = 0;
	if (s.length() == 0)
		return 0;
	while (i < s.length() && s.charAt(i) == ' ')
		i++;
	if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-'))
		sign = (s.charAt(i++) == '-') ? -1 : 1;
	while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
		if (res > MAX / 10 || (res == MAX / 10 && s.charAt(i) - '0' > MAX % 10))
			return (sign == 1) ? MAX : MIN;
		res = res * 10 + (s.charAt(i++) - '0');
	}
	return res * sign;
}


//Problem is available on leetcode