// 13/17С������100λ�������Ǽ���
public class FractionalDigit {

	public static void main(String[] args) {
		int d = 13;
		int q = 17;
		int a = 0;
		int r=0;
		for(int i=0;i<=100;i++)
		{
			a=d/q;
			r=d%q;
			r*=10;
			d=r;
		}
		
		System.out.println(a);

	}

}
