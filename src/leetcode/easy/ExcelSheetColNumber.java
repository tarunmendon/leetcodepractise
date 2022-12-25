package src.leetcode.easy;

public class ExcelSheetColNumber {
	public static void main(String args[])
	{
		ExcelSheetColNumber obj=new ExcelSheetColNumber();
		System.out.println(obj.titleToNumber("AAA"));
	}
	public int titleToNumber(String s) {
		//copied - https://www.programcreek.com/2014/03/leetcode-excel-sheet-column-number-java/
	    int result = 0;
	    for (char c : s.toCharArray()) {
	        result = result * 26 + (c - 'A') + 1;
	    }
	    return result;
	}}
