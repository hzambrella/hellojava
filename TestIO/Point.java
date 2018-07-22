package TestIO;

public class Point {
	private Double X=0D;
	private Double Y=0D;
	
	public Point(){
	}
	
	public Point(Double X,Double Y){
		this.X=X;
		this.Y=Y;
	}
	
	public Double getX() {
		return X;
	}
	public void setX(Double x) {
		X = x;
	}
	public Double getY() {
		return Y;
	}
	public void setY(Double y) {
		Y = y;
	}
	
	public void setLocation(Double x,Double y){
		this.X=x;
		this.Y=y;
	}
}
