package a2;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Point {
	//横纵坐标
	private double x;  
	private double y;
    //Java中this和super的用法总结 http://www.cnblogs.com/hasse/p/5023392.html
    //默认构造函数
	public Point(){
		
	}
	//构造函数
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	//返回横坐标
	public double getX() {
		return x;
	}
	//返回纵坐标
	public double getY() { 
		return y;
	} 
	//设置x值
	public void setX(double x) { 
		this.x = x;
	}
	//设置y值
	public void setY(double y) {
		this.y = y;
	}
		
}
