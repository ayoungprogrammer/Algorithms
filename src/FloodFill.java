import java.util.LinkedList;


class Point{
	int x,y;
	public Point(int x,int y){
		this.x = x;
		this.y = y;
	}
}

public class FloodFill {

	int n,m;
	boolean visited[][] = new boolean[n][m];
	int image[][] = new int[n][m];
	/* Changes all pixels that are equal to src to tar that are connected to start
	 * and returns the number of pixels changed
	 */
	public int FloodFillDFS(int x,int y,int src,int tar){
		if(x<0 || x>=n || y<0 || y>=m)return 0;
		if(visited[x][y])return 0;
		visited[x][y] = true;
		if(image[x][y]!=src)return 0;
		image[x][y] = tar;
		int sum = 0;
		sum+=FloodFillDFS(x+1,y,src,tar);
		sum+=FloodFillDFS(x-1,y,src,tar);
		sum+=FloodFillDFS(x,y+1,src,tar);
		sum+=FloodFillDFS(x,y-1,src,tar);
		return sum;
	}
	/* Changes all pixels that are equal to src to tar that are connected to start
	 * and returns the number of pixels changes 
	 */
	public int FloodFillBFS(int x,int y,int src,int tar){
		LinkedList<Point> q = new LinkedList<Point>();
		q.push(new Point(x,y));
		int total = 0;
		while(q.isEmpty()==false){
			Point cur = q.pop();
			if(cur.x<0||cur.x>=n||cur.y<0||cur.y>=m)continue;
			if(visited[cur.x][cur.y])continue;
			visited[cur.x][cur.y] = true;
			if(image[cur.x][cur.y]!=src)continue;
			image[cur.x][cur.y] = tar;
			total++;
			q.push(new Point(cur.x+1,cur.y));
			q.push(new Point(cur.x-1,cur.y));
			q.push(new Point(cur.x,cur.y+1));
			q.push(new Point(cur.x,cur.y-1));
		}
		return total;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
