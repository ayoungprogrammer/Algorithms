

public class TernarySearch {

	public double f(double x){
		return x;
	}
	
	public double tern(double a,double b){
		if(Math.abs(f(a)-f(b))<0.0001){
			return (a+b)/2.0;
		}
		double m1 = a+(b-a)/3.0;
		double m2 = a+(b-a)*2/3;
		if(f(a)<f(b)){
			return tern(m1,b);
		}else {
			return tern(a,m2);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
