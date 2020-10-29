//WE have a given two strings
//we have to find if second string is present in first
//or not and to return its index if present
//other have to return -1;

public int strStr(String haystack, String needle) {
	if (needle == "") return 0;
	return haystack.indexOf(needle);
}


//Problem is available on leetcode