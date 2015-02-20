import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
class Point implements Comparable<Point> {
	public double x;
	public double y;
	public double distance;
	private static Point REFPOINT = new Point(0,0);
	public Point(double x,double y) {
		this.x = x;
		this.y = y;
	}
	public double getDist(Point comparedPoint) {
		return Math.sqrt( Math.pow(x-comparedPoint.x,2) + Math.pow(y-comparedPoint.y,2));
	}
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Point)) {
			return false;
		}
		Point p1 = (Point) o;
		if ((Double.compare(x,p1.x) == 0) && (Double.compare(y,p1.y) ==0))
			return true;
		return false;
	}
	@Override
	public int compareTo(Point o) {
		double dist1 = this.getDist(REFPOINT);
		double dist2 = o.getDist(REFPOINT);
		int diff = Double.compare(dist1,dist2);
		if (diff != 0)
			return diff;
		if (this.x != o.x)
			return (Double.compare(this.x,o.x));
		return (Double.compare(this.y,o.y));
	}
}
class DistanceComp implements Comparator<Point> {
	Point mRefPoint = null;
	public DistanceComp(Point refPoint) {
		mRefPoint = refPoint;
	}
	public int compare(Point p1,Point p2) {
		double dist1 = p1.getDist(mRefPoint);
		double dist2 = p2.getDist(mRefPoint);
		int diff = Double.compare(dist2,dist1);
		/*
		if (diff != 0)
			return diff;
		if (p1.x != p2.x) 
			return Double.compare(p1.x,p2.x);
		return Double.compare(p1.y,p2.y);
		*/
		return diff;
	}
}
public class DistanceComparator {
	public static void main(String args[]) {
		List<Point> pts = new ArrayList<Point>();
		pts.add(new Point(5,10));
		pts.add(new Point(2,11));
		pts.add(new Point(5,5));
	//	Collections.sort(pts);
		for (Point p : pts) {
			System.out.println(p.x + "," + p.y);
                        System.out.println(p.getDist(new Point(0,0)));
		}
		PriorityQueue<Point> pq = new PriorityQueue<Point>(3,new DistanceComp(new Point(0,0)));
		pq.add(new Point(5,10));
		pq.add(new Point(2,11));
		pq.add(new Point(5,5));
		Point closePoint = new Point(1,1);
		if(closePoint.getDist(new Point(0,0)) < pq.peek().getDist(new Point(0,0))) {
			pq.poll();
			pq.add(closePoint);
		}
		Point[] ptList = new Point[pq.size()];
		ptList = pq.toArray(ptList);
		for(int i=0; i<ptList.length; i++)
			System.out.println(ptList[i].x + " " + ptList[i].y); 
	}
}   
