public class Fibo {
	public static void main(String[] args) {
		Fibo f = new Fibo();
		System.out.println(f.fibo1(9)); // �����ַ�������Ч�ʸ��ߣ�
		System.out.println(f.fibo2(9));
	}

	public int fibo1(int n) { // ʹ�÷������������ݹ���ʵ��
	  if (n==1||n==2){
	    return 1;
	  }
	  return fibo1(n-1)+fibo1(n-2);
	}
	
	
	
	public int fibo2(int n) { // ʹ��ѭ����ʵ��
		
	    int a=0;
        int b=1;
        int temp=0;
		for(int i=0;i<n;i++)
		{    
			temp=b;
			b=a+b;
			a=temp;
		}
	    return a;
    }
}