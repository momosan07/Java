package a2;

import java.util.Vector;
    //用分解的方法判断，11种情况，进行了合并简化
public class PrimeTest {
	public static boolean isSpPrime(String n) {
		//跳过个位数
		if (Integer.valueOf(n) < 10)
			return false;
		//分解素数，最多四位数，四份
		String a, b, c, d = new String();
		for (int i = 1; i < n.length(); ++i) {
			//将n分为两部分
			a = n.substring(0, i);
			b = n.substring(i);
			if (isPrime(Integer.valueOf(a)) && isPrime(Integer.valueOf(b))) {
				//第二份第一位是0，直接跳出本次循环。比如，素数307不满足条件，不能忽略0.
				//charAt(index) Parameters:index the index of the char value.Returns:the char value at the specified index of this string. The first char value is at index 0.
				if (b.charAt(0) == '0')
					continue;
				return true;
			}
			if (i == 1) {
				for (int j = 1; j < b.length(); j++) {
					c = b.substring(0, j);
					d = b.substring(j);
					if (isPrime(Integer.valueOf(a)) && isPrime(Integer.valueOf(c)) && isPrime(Integer.valueOf(d))) {
						if (c.charAt(0) == '0' || d.charAt(0) == '0')
							continue;
						return true;
					}
				}
			}
			if (i == 2) {
					c = b.substring(0, 1);
					d = b.substring(1);
					if (isPrime(Integer.valueOf(a)) && isPrime(Integer.valueOf(c)) && isPrime(Integer.valueOf(d))) 
						return true;
			}
			if (i == 3) {
				c = a.substring(1, 2);
				d = a.substring(2, 3);
				a = a.substring(0, 1);
				if (isPrime(Integer.valueOf(a)) && isPrime(Integer.valueOf(b)) && isPrime(Integer.valueOf(c))
						&& isPrime(Integer.valueOf(d))) {
					return true;
				}
			}
		}

		return false;
	}
    //判断素数
	public static boolean isPrime(int n) {
		if (n == 1)
			return false;
		if (n == 2)
			return true;
		if (n % 2 == 0)
			return false;
		for (int i = 3; i <= (int) Math.sqrt((double) n); i += 2)
			if (n % i == 0)
				return false;
		return true;
	}
    //主函数，把符合条件的拼接素数全部输出，并统计个数
	public static void main(String argv[]) {
		Vector<String> prime = new Vector<String>();
		int ans = 0;
		for (int i = 0; i < 10000; i++)
			if (isPrime(i))
				prime.add(String.valueOf(i));
		for (String num : prime) {
			if (isSpPrime(num)) {
				System.out.println(num);
				ans++;
			}
		}
		System.out.println("The answer : " + ans);
	}
}