package TestIO;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class HaveOwnWayToSerialize implements Externalizable {
	private String name;
	private transient Point point;//transient 对于Externalizable 来说没什么用 Point可以自己实现或者用包的
	
	public HaveOwnWayToSerialize(){
		this.name="";
		this.point=new Point();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Point getPoint() {
		return new Point(point.getX(),point.getY());
	}

	public void setPoint(Point point) {
		this.point.setX(point.getX());
		this.point.setY(point.getY());
	}

	public HaveOwnWayToSerialize(String name,Point point){
		this.name=name;
		this.point=point;
	}
	
	public HaveOwnWayToSerialize(String name,Double x,Double y){
		this.name=name;
		this.point=new Point();
		point.setLocation(x, y);
	}
//	
//	private void writeObject(ObjectOutputStream out) throws IOException{
//		out.defaultWriteObject();
//		out.writeDouble(point.getX());
//		out.writeDouble(point.getY());
//	}
//	
//	
//	private void readObject(ObjectInputStream in)
//			throws ClassNotFoundException, IOException{
//		in.defaultReadObject();
//		Double x=in.readDouble();
//		Double y=in.readDouble();
//		Point point=new Point();
//		point.setLocation(x, y);
//		this.point=point;
//	}


	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(name);
		out.writeDouble(point.getX());
		out.writeDouble(point.getY());
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		this.name=in.readUTF();
		Double x=in.readDouble();
		Double y=in.readDouble();
		Point point=new Point();
		point.setLocation(x, y);
		this.point=point;
	}
	
	public String toString(){
		if (point==null){
			this.point=new Point();
			this.point.setLocation(0D,0D);
		}
		return String.format("%s (%f,%f)", name,point.getX(),point.getY());
	}
}
