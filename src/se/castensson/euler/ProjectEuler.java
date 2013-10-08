package se.castensson.euler;

import java.io.IOException;

import se.castensson.utils.HelperFunctions;

public class ProjectEuler {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ProjectEuler pe = new ProjectEuler();
//		 pe.eulerProblem1(1000);
//		 pe.eulerProblem2(4000000);
//		 pe.eulerProblem3(600851475143L);
//		 pe.eulerProblem4(100, 999);
//		 pe.eulerProblem5(20);
//		 pe.eulerProblem6(100);
//		 pe.eulerProblem7(10001);
		pe.eulerProblem8(5);
	}

	public void eulerProblem1(long maxNumber) {
		long startTime = System.currentTimeMillis();
		int sum = 0;
		for (int i = 1; i < maxNumber; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		printResult(1, sum, startTime);
	}

	public void eulerProblem2(long maxNumber) {
		long startTime = System.currentTimeMillis();
		int sum = 0;
		int next = 0;
		int current = 1;
		int last = 0;
		while (true) {
			next = last + current;
			if (next > maxNumber) {
				break;
			}
			if (next % 2 == 0) {
				sum += next;
			}
			last = current;
			current = next;
		}
		printResult(2, sum, startTime);
	}

	public void eulerProblem3(long targetNumber) {
		long startTime = System.currentTimeMillis();
		long highestPrime = 0;
		long baseNumber = targetNumber;
		int maxFactorBase = (int) Math.sqrt(baseNumber);
		for (long i = 1; i < maxFactorBase; i = i + 2) {
			if (HelperFunctions.isPrime(i) && baseNumber % i == 0) {
				highestPrime = i;
			}
		}
		printResult(3, highestPrime, startTime);
	}

	public void eulerProblem4(long lowestNumber, long highestNumber) {
		long startTime = System.currentTimeMillis();
		long highestPalindrome = 0;
		for (long i = lowestNumber; i <= highestNumber; i++) {
			for (long j = lowestNumber; j < highestNumber; j++) {
				Long product = i * j;
				if (HelperFunctions.isPalindrome(Long.toString(product)) && product > highestPalindrome) {
					highestPalindrome = product;
				}
			}
		}
		printResult(4, highestPalindrome, startTime);
	}

	public void eulerProblem5(int maxNumber) {
		long startTime = System.currentTimeMillis();
		long result = maxNumber;
		while (true) {
			int divider = maxNumber;
			for (; divider > 1; divider--) {
				if (result % divider != 0) {
					break;
				}
			}
			if (divider == 1) {
				break;
			}
			result += maxNumber;
		}
		printResult(5, result, startTime);
	}

	public void eulerProblem6(int maxNumber) {
		long startTime = System.currentTimeMillis();
		long squareSum = 0;
		long sum = 0;
		for (int i = 1; i <= maxNumber; i++) {
			sum += i;
			squareSum += (i * i);
		}
		printResult(6, sum * sum - squareSum, startTime);
	}

	public void eulerProblem7(long targetNumber) {
		long startTime = System.currentTimeMillis();
		long highestPrime = 0;
		int nrOfPrimes = 1;
		for (long i = 1;; i = i + 2) {
			if (HelperFunctions.isPrime(i)) {
				highestPrime = i;
				nrOfPrimes++;
				if (nrOfPrimes == targetNumber) {
					break;
				}
			}
		}
		printResult(7, highestPrime, startTime);
	}
	
	public void eulerProblem8(int numberOfFactors)
			throws IOException {
		long startTime = System.currentTimeMillis();
		String stringOfNumber = HelperFunctions.readFileAsString("1000.txt", false);
		long highestProduct = 0;
		for (int i = 0; i < stringOfNumber.length() - numberOfFactors + 1; i++) {
			int product = Integer.parseInt(String.valueOf(stringOfNumber.charAt(i)));
			for (int j = i + 1; j < i + numberOfFactors; j++) {
				product = product * Integer.parseInt(String.valueOf(stringOfNumber.charAt(j)));
			}
			if (highestProduct < product) {
				highestProduct = product;
			}
		}
		printResult(8, highestProduct, startTime);
	}


	private void printResult(int number, long answer, long time) {
		System.out.println(String.format("Euler Problem %s answer: %s (%s ms)", number, answer, System.currentTimeMillis() - time));
	}
}
