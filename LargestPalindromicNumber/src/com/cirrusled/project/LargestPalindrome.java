package com.cirrusled.project;

public class LargestPalindrome {
	long minValue=0, maxValue=0;
	
	/* Constructor to set the lower and upper bounds
	 * @param minValue: lower bound
	 * @param maxValue: upper bound
	 */
	public LargestPalindrome(double minValue, double maxValue )
	{
		this.minValue=(long)minValue;
		this.maxValue=(long)maxValue;
	}
	
	
	
	/* Function to search maximum number that is a palindrome 
	 * returns the maximum number from the range.
	 */	
	public String findPalindrome()
	{
		for(long number = maxValue; number >= minValue; number--)
		{
			if(isPalindromic(number))
			{
				return (number +"");
			}
		}
		return "No Palindromic Numbers";
	}

	
	
	/* Function to check if the number is palindrome or not
	 * @param number: number (long type)
	 */
	public boolean isPalindromic(long number)
	{
		StringBuffer reverseNumber = new StringBuffer(number+"");
		reverseNumber = reverseNumber.reverse();
		return reverseNumber.toString().equals(number+"");		 
	}
}
