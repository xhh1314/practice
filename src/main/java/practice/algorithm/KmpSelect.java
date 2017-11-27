package practice.algorithm;
/**
 * kmp查找算法实现
 * @author lh
 * @version 
 */
public class KmpSelect {
	/**
	 * 计算模式串next数组
	 * @author lh
	 * @param str
	 * @return
	 */
	public int[] getNext(String str) {
		char[] strs=str.toCharArray();
		int[] next=new int[strs.length-1];
		//先计算每个位置的相同前缀，再右移动一位
		for(int i=0;i<strs.length;i++) {
			if(i==0)
				next[i]=0;
			
		}
		
		
		
		return null;
	}
	
	
}

