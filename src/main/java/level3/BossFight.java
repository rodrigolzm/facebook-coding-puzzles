package level3;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Boss Fight
 * <p>
 * There are N warriors, the ith of which has a health of Hi units and can deal
 * Di units of damage per second. They are confronting a boss who has unlimited
 * health and can deal B units of damage per second. Both the warriors and the
 * boss deal damage continuously − for example, in half a second, the boss deals
 * B/2 units of damage.
 * <p>
 * The warriors feel it would be unfair for many of them to fight the boss at
 * once, so they'll select just two representatives to go into battle. One
 * warrior i will be the front line, and a different warrior j will back them
 * up. During the battle, the boss will attack warrior i until that warrior is
 * defeated (that is, until the boss has dealt Hi units of damage to them), and
 * will then attack warrior j until that warrior is also defeated, at which
 * point the battle will end. Along the way, each of the two warriors will do
 * damage to the boss as long as they are undefeated.
 * <p>
 * Of course, the warriors will never prevail, but they'd like to determine the
 * maximum amount of damage they could deal to the boss for any choice of
 * warriors i and j before the battle ends.
 * <p>
 * Note: Your return value must have an absolute or relative error of at most
 * 10^−6 to be considered correct.
 * <p>
 * Constraints<br>
 * 2 ≤ N ≤ 500,000<br>
 * 1 ≤ Hi ≤ 1,000,000,000<br>
 * 1 ≤ Di ≤ 1,000,000,000<br>
 * 1 ≤ B ≤ 1,000,000,000<br>
 * <p>
 * Sample test case #1<br>
 * N = 3<br>
 * H = [2, 1, 4]<br>
 * D = [3, 1, 2]<br>
 * B = 4<br>
 * Expected Return Value = 6.500000<br>
 * <p>
 * Sample test case #2<br>
 * N = 4<br>
 * H = [1, 1, 2, 100]<br>
 * D = [1, 2, 1, 3]<br>
 * B = 8<br>
 * Expected Return Value = 62.750000<br>
 * <p>
 * Sample test case #3<br>
 * N = 4<br>
 * H = [1, 1, 2, 3]<br>
 * D = [1, 2, 1, 100]<br>
 * B = 8<br>
 * Expected Return Value = 62.750000<br>
 * <p>
 * Sample Explanation
 * <p>
 * In the first case, there are 3 warriors with healths of [2,1,4] units, and
 * the ability to deal [3,1,2] units of damage respectively. The boss does B = 4
 * units of damage per second.
 * <p>
 * The optimal solution is to choose warrior 3 as the front line and warrior 1
 * as backup. Warrior 3 will be defeated after 1 second, dealing 2 units of
 * damage during this time (meanwhile, warrior 1 will have dealt 3 units of
 * damage). Warrior 1 will then step up and last for 0.5 seconds, while dealing
 * another 1.5 units of damage along the way. The total damage dealt will then
 * be 2 + 3 + 1.5 = 6.5 units.
 * <p>
 * In each of the second and third cases, it's possible for 62.75 units of
 * damage to be dealt to the boss, though with different configurations of
 * warriors.
 */
public class BossFight {
	
	//You solved 23 / 24 test cases. Wrong Answer on 1 test case
	public double getMaxDamageDealt(int N, int[] H, int[] D, int B) {
		
		final int MAP_SIZE = 2;
		
		SortedMap<Double, Integer> health = new TreeMap<Double, Integer>();
		SortedMap<Double, Integer> demage = new TreeMap<Double, Integer>();
		SortedMap<Double, Integer> performance = new TreeMap<Double, Integer>();
		SortedMap<Double, Integer> healthWeighted = new TreeMap<Double, Integer>();
		SortedMap<Double, Integer> damageWeighted = new TreeMap<Double, Integer>();
		
		for (int i = 0; i < N; i++) {
			
			health.put((double) H[i], i);
			if (health.size() > MAP_SIZE)
				health.remove(health.firstKey());

			demage.put((double) D[i], i);
			if (demage.size() > MAP_SIZE)
				demage.remove(demage.firstKey());

			performance.put((double) H[i] * D[i], i);
			if (performance.size() > MAP_SIZE)
				performance.remove(performance.firstKey());
			
			healthWeighted.put((double) H[i] * H[i] * D[i], i);
			if (healthWeighted.size() > MAP_SIZE)
				healthWeighted.remove(healthWeighted.firstKey());
			
			damageWeighted.put((double) H[i] * D[i] * D[i], i);
			if (damageWeighted.size() > MAP_SIZE)
				damageWeighted.remove(damageWeighted.firstKey());
		}
		
		Set<Integer> options = new HashSet<Integer>();
		options.addAll(health.values());
		options.addAll(demage.values());
		options.addAll(performance.values());
		options.addAll(healthWeighted.values());
		options.addAll(damageWeighted.values());

		double result = 0;
		for (int i = 0; i < N; i++) {
			for (int j : options) {
			
				if (i == j) continue;
				
				double time1 = (double) H[i] / B;
				double time2 = (double) H[j] / B;
				
				double opt1 = time1 * D[i] + time2 * D[j] + time1 * D[j];
				double opt2 = time1 * D[i] + time2 * D[j] + time2 * D[i];
				
				result = Math.max(result, Math.max(opt1, opt2));
			}
		}
		
		return result;
	}

}
