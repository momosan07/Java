package a2;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Point {
	//��������
	private double x;  
	private double y;
    //Java��this��super���÷��ܽ� http://www.cnblogs.com/hasse/p/5023392.html
    //Ĭ�Ϲ��캯��
	public Point(){
		
	}
	//���캯��
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	//���غ�����
	public double getX() {
		return x;
	}
	//����������
	public double getY() { 
		return y;
	} 
	//����xֵ
	public void setX(double x) { 
		this.x = x;
	}
	//����yֵ
	public void setY(double y) {
		this.y = y;
	}
		
}
