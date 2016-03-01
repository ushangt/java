import java.util.Scanner;

class Point{
	private int x;
	private int y;
	
	void setX(int x){
		this.x = x;
	}
	
	void setY(int y){
		this.y = y;
	}
	
	int getX(){
		return x;
	}
	
	int getY(){
		return y;
	}
}


public class PointsToOrigin {
	
	static double distanceFormula(int x, int y){		
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));				
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] p = new Point[10];
		Scanner ip = new Scanner(System.in);
		for(int i=0;i<p.length;i++){
			System.out.println("Enter x and y for point "+(i+1));
			p[i] = new Point();
			p[i].setX(ip.nextInt());
			p[i].setY(ip.nextInt());
		}
		System.out.println("Enter no.of points you want");
		int n = ip.nextInt();
		double[] distance = new double[p.length];
		for(int i=0;i<p.length;i++){
			distance[i] = distanceFormula(p[i].getX(), p[i].getY());
		}
		for(int i=0;i<distance.length;i++){
			int m=i;
			for(int j=i+1;j<distance.length;j++){
				if(distance[m] < distance[j])
					m = j;
				Point temp = p[i];
				p[i] = p[m];
				p[m] = temp;
				double t = distance[i];
				distance[i] = distance[m];
				distance[m] = t;
			}
		}
		for(int i=0;i<n;i++)
			System.out.println(p[i].getX()+","+p[i].getY());
		
		
	}

}
