package se.castensson.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	
	public static String readFileAsString(String resource, boolean keepLineBreaks)
			throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("resources/" + resource)));
		StringBuffer resultString = new StringBuffer();
		String line = null;
		while ((line = reader.readLine()) != null) {
			resultString.append(line);
			if (keepLineBreaks) {
				resultString.append("\n");
			}
		}
		return resultString.toString();
	}

	public static void main(String[] args) {
		try {
			System.out.println(readFileAsString("1000.txt", false));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
