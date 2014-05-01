package org.caofei;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class FizzBuzzWhizzTest extends TestCase {
	private static final String[] WORDS = new String[] { "Fizz", "Buzz",
			"Whizz" };

	public void testExecute() {
		List<String> expectedList = new ArrayList<String>(100);
		int param1 = 3;
		int param2 = 5;
		int param3 = 7;
		expectedList.clear();
		List<Object> result = process(expectedList, param1, param2, param3);
		for (int i = 0; i < result.size(); i++) {
			assertEquals(expectedList.get(i), String.valueOf(result.get(i)));
		}
		param1 = 1;
		param2 = 2;
		param3 = 3;
		expectedList.clear();
		result = process(expectedList, param1, param2, param3);
		for (int i = 0; i < result.size(); i++) {
			assertEquals(expectedList.get(i), String.valueOf(result.get(i)));
		}
		param1 = 1;
		param2 = 6;
		param3 = 9;
		expectedList.clear();
		result = process(expectedList, param1, param2, param3);
		for (int i = 0; i < result.size(); i++) {
			assertEquals(expectedList.get(i), String.valueOf(result.get(i)));
		}
		param1 = 3;
		param2 = 6;
		param3 = 9;
		expectedList.clear();
		result = process(expectedList, param1, param2, param3);
		for (int i = 0; i < result.size(); i++) {
			assertEquals(expectedList.get(i), String.valueOf(result.get(i)));
		}
	}

	private List<Object> process(List<String> expectedList, int param1,
			int param2, int param3) {
		int[] keyNumbers = new int[] { param1, param2, param3 };
		String[] keyNumberstr = new String[] { String.valueOf(keyNumbers[0]),
				String.valueOf(keyNumbers[1]), String.valueOf(keyNumbers[2]) };
		List<Object> result = FizzBuzzWhizz.execute(keyNumbers);
		for (int i = 1; i <= 100; i++) {
			// rule5
			boolean next = false;
			String str = String.valueOf(i);
			for (int k = 0; k < str.length(); k++) {
				String letter = str.substring(k, k + 1);
				for (int j = 0; j < keyNumberstr.length; j++) {
					if (letter.contains(keyNumberstr[j])) {
						expectedList.add(WORDS[j]);
						next = true;
						break;
					}
				}
				if (next) {
					break;
				}
			}
			if (next) {
				continue;
			}

			// rule3
			next = false;
			String rule3Buffer = "";
			for (int j = 0; j < keyNumbers.length; j++) {
				boolean step = i % keyNumbers[j] == 0;
				if (step) {
					rule3Buffer += WORDS[j];
				}
				next = next || step;
			}
			if (next) {
				expectedList.add(rule3Buffer);
				continue;
			} else {
				expectedList.add(String.valueOf(i));
			}
		}
		return result;
	}

}
