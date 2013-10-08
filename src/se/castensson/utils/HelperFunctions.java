package se.castensson.utils;

public class HelperFunctions {

	/**
	 * Evaluate if a given number is a prime number
	 * 
	 * @param primeCandidate
	 * @return true is primeCandidate is a prime number
	 */
	public static boolean isPrime(long primeCandidate) {
		if (primeCandidate == 1) {
			return false;
		} else if (primeCandidate == 2) {
			return true;
		} else if (primeCandidate % 2 == 0) {
			return false;
		}
		long maxFactor = (long) Math.sqrt(primeCandidate);
		for (long j = 3; j <= maxFactor; j++) {
			if (primeCandidate % j == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks whether a given string qualifies as a palindrome or not
	 * 
	 * @param palindromeCandidate
	 * @return true is given string is a palindrome
	 */
	public static boolean isPalindrome(String palindromeCandidate) {
		boolean evenSized = (palindromeCandidate.length() % 2 == 0);
		int index1 = 0;
		int index2 = palindromeCandidate.length() - 1;
		while ((index1 < index2 && evenSized) || (index1 <= index2 && !evenSized)) {
			if (palindromeCandidate.charAt(index1) != palindromeCandidate.charAt(index2)) {
				break;
			} else if ((index1 + 1 == index2 && evenSized) || (index1 == index2 && !evenSized)) {
				return true;
			}
			index1++;
			index2--;
		}
		return false;
	}
}
