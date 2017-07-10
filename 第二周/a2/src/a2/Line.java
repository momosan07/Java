package a2;

public class Line {
	//提供两点
	private Point p1=new Point();
	private Point p2=new Point();
    //默认构造函数
	public Line() {
		
	}
    //构造函数
	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
    //返回点1
	public Point getP1() {
		return p1;
	}
    //返回点2
	public Point getP2() {
		return p2;
	}
    //设置点1
	public void setP1(Point p1) {
		this.p1 = p1;
	}
    //设置点2
	public void setP2(Point p2) {
		this.p2 = p2;
	}
	//两点确定一条直线，返回一般式方程
	public String getLine(Point p1, Point p2) {
		//如果两点重合，可以返回异常或者返回null引用来解决这个问题。
		if (p1 == p2)
			return null;
		String f = new String();
		double a, b, c;
		a = p2.getY() - p1.getY();
		b = p1.getX() - p2.getX();
		c = p2.getX() * p1.getY() - p1.getX() * p2.getY();
		f = "(" + String.valueOf(a) + ")x + (" + String.valueOf(b) + ")y + (" + String.valueOf(c) + ") = 0";
		return f;
	}	
	//主函数打印直线l
	public static void main(String[] args) {
		Point p1 = new Point(0, 1);
		Point p2 = new Point(0,0);
		Line l = new Line();
		l.getLine(p1, p2);
		System.out.println(l.getLine(p1, p2));
	}
}

