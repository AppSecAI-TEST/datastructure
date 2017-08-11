import java.util.HashMap;
import java.util.Map;

public class MinWindowString {

	private static String s = "ADOBECODEBANC";
	private static String t = "ABC";

	// BANC
	public MinWindowString() {
		String result = minWindow(s, t);
		System.out.println("Test.Test():FINAL " + result);

	}

	public String minWindow(String s, String t) {
		// step 1 -
		// A-1
		// B-1
		// C-1

		int count = 0;
		int left = 0;
		String result = "";
		
		//create a lookup for target string
		Map<Character, Integer> target = new HashMap<Character, Integer>();
		int minLen = s.length() + 1;
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (target.containsKey(c)) {
				target.put(c, target.get(c) + 1);
			} else {
				target.put(c, 1);
			}
		}

		System.out.println("Test.Test():target:" + target);

		// STEP 2
		// A-2 ( 2 A and)
		// D-2 -ignore
		// 0-2 -ignore
		// B-2
		// E-2 -ignore
		// C-2
		// N-1 - ignore
		// A-2
		// B-2
		// C-2
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		//create a lookup for source  string which matches only source string
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			System.out.println("Test.minWindow():::" + c);
			if (target.containsKey(c)) {
				if (map.containsKey(c)) {
					if (map.get(c) < target.get(c)) {
						count++;
					}
					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
					count++;

				}
			}

			
			//only when  map match "ABC" i.e map contains all target strings
			if (count == t.length()) {
				char sc = s.charAt(left);
				while (!map.containsKey(sc) || map.get(sc) > target.get(sc)) {

					if (map.containsKey(sc) && map.get(sc) > target.get(sc)) {
						//remove those duplicates since we add duplicates in 60 line
						map.put(sc, map.get(sc) - 1);
					}
					
					//DOBEC  ODEB only comes inside this
					left++;
					sc = s.charAt(left);
					System.out.println("MinWindowString.minWindow():SC:"+sc);
				}

				if (i - left + 1 < minLen) {
					//substring returns index of  source and destindex is destindex-1 i.e
					//"test"substring(0,1)- 't' only since dest minus 1 from specified
					//so it will  be substring(0,0)-'t' hence use +1 to get the actual expected value
					result = s.substring(left, i + 1);
					//ADOBEC-5(i) -left -0  , minlen -14 
					//
					//BANC- i(12) ,left(9),
					minLen = i - left + 1;
					//minlen after it changes to 6(ADOBEC)
					//minlen after it changes to 4(BANC)
				}
			}

		}
		// mapping characters need to be find.
		// iterate start
		// consider only target characters i.e "ABC" and calculate count of
		// mapped
		// characters.
		// while in iteration if count reaches target count "ABC" 3 then we
		// found
		// all target characters in sample test
		// string S

		// each time in above iteration if count matches target string count
		// "ABC"
		// just substring of string from
		// iterate end

		return result;

	}

	public static void main(String args[]) {
		new MinWindowString();
	}

}
