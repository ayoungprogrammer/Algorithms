import java.util.Vector;


public class Vec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vector<Integer> v = new Vector<Integer>(10);
		v.add(1);
		v.add(2);
		v.add(3);
		v.insertElementAt(3,3);
		System.out.println(v);
	}

}
