
public class KMP {

	
	public static int KMP(String needle,String haystack){
		int[] overlap = new int[needle.length()];
		overlap[0] = -1;
		overlap[1] = 0;
		int cand = 0;
		int pos = 2;
		//Build table
		while(pos<needle.length()){
			if(needle.charAt(pos-1)==needle.charAt(cand)){
				cand++;
				overlap[pos] = cand;
				pos++;
			}else if(cand>0){
				cand = overlap[cand];
			}else {
				overlap[cand]=0;
				pos++;
			}
		}
		for(int i=0;i<needle.length();i++)System.out.println(overlap[i]);
		int m = 0;
		int i = 0;
		//Search
		while(m+i<haystack.length()){
			System.out.println(i+" "+m+" "+needle.charAt(i)+" "+haystack.charAt(m+i));
			if(needle.charAt(i)==haystack.charAt(m+i)){
				if(i==needle.length()-1){
					return m;
				}
				i++;
			}if (i>0){
				i = overlap[i];
				m = m + 1 - overlap[i];
			}
			else {
				i=0;
				m++;
			}
			
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(KMP("abacababd","abcabacababd"));
	}

}
