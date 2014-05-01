package org.caofei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * FizzBuzzWhizz
 * 
 * @see <a href="http://t.cn/8smosLQ">世界涨姿势面试IT公司@ThoughtWorks</a>
 * 
 * @author caofei.org
 * 
 */
public class FizzBuzzWhizz {
	private static final int STUDENT_COUNT = 100;
	private static final List<Object> result = new ArrayList<Object>(
			STUDENT_COUNT);
	private static final String[] WORDS = new String[] { "Fizz", "Buzz",
			"Whizz" };
	private static int[] keyNumbers;
	private static StringBuilder buffer = new StringBuilder();

	public static void main(String[] args) {
		prepareVar();
		execute(keyNumbers);
		showResult();
	}

	/**
	 * @param keyNumbers
	 *            keyNumbers
	 * @param args
	 *            sdtin arguments
	 * @return count off result
	 */
	public static List<Object> execute(int[] keyNumbers) {
		result.clear();
		FizzBuzzWhizz.keyNumbers = keyNumbers;
		for (int i = 1; i <= STUDENT_COUNT; i++) {
			if (!rule5(i))
				rule34(i);
		}
		return result;
	}

	/**
	 * <pre>
	 * rule3
	 * 如果所报数字是第一个特殊数（3）的倍数，那么不能说该数字，而要说Fizz；
	 * 如果所报数字是第二个特殊数（5）的倍数，那么要说Buzz；
	 * 如果所报数字是第三个特殊数（7）的倍数，那么要说Whizz。
	 * rule4
	 * 学生报数时，如果所报数字同时是两个特殊数的倍数情况下，也要特殊处理，
	 * 比如第一个特殊数和第二个特殊数的倍数，那么不能说该数字，而是要说FizzBuzz,
	 * 以此类推。如果同时是三个特殊数的倍数，那么要说FizzBuzzWhizz。
	 * </pre>
	 * 
	 * @param i
	 *            student
	 */
	private static void rule34(int i) {
		buffer.setLength(0);
		for (int j = 0; j < 3; j++) {
			buffer.append(i % keyNumbers[j] == 0 ? WORDS[j] : "");
		}
		appendResult(buffer.length() == 0 ? String.valueOf(i) : buffer
				.toString());
	}

	/**
	 * <pre>
	 * 学生报数时，如果所报数字包含了第一个特殊数，那么也不能说该数字，而是要说相应的单词，
	 * 比如本例中第一个特殊数是3，那么要报13的同学应该说Fizz。
	 * 如果数字中包含了第一个特殊数，那么忽略规则3和规则4，比如要报35的同学只报Fizz，不报BuzzWhizz。
	 * </pre>
	 * 
	 * @param i
	 *            student
	 * @return eligibility for rule5
	 */
	private static boolean rule5(int i) {
		int j = reverseNum(i),d;
		while ( ( d = j % 10) != 0) {
			for (int k = 0; k < 3; k++) {
				if (d == keyNumbers[k]) {
					appendResult(WORDS[k]);
					return true;
				}
			}
			j = j / 10;
		}
		return false;
	}

	/**
	 * show the final result to stdout
	 */
	private static void showResult() {
		for (Object line : result) {
			System.out.println(line);
		}
	}

	/**
	 * reverseNum
	 * 
	 * @param i
	 *            number
	 * @return reversed number
	 */
	private static int reverseNum(int i) {
		int s = 0;
		while (i != 0) {
			s = s * 10 + i % 10;
			i = i / 10;
		}
		return s;
	}

	/**
	 * prepare variable
	 * 
	 * @param args
	 */
	private static void prepareVar() {
		Scanner scanner = new Scanner(System.in);
		String input;
		String tip = "please input three number with comma, ex 3,5,7";
		System.out.println(tip);
		while (true) {
			input = scanner.nextLine().trim();
			if (!input.matches("\\d,\\d,\\d")) {
				System.out.println(tip);
			} else {
				break;
			}
		}
		String[] strKeyWords = input.split(",");
		keyNumbers = new int[strKeyWords.length];
		for (int i = 0; i < keyNumbers.length; i++) {
			keyNumbers[i] = Integer.valueOf(strKeyWords[i]);
		}
	}

	/**
	 * collect result
	 * 
	 * @param elements
	 */
	private static void appendResult(Object elements) {
		result.add(elements);
	}

}
