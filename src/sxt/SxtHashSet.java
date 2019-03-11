package sxt;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * �ֶ�ʵ��һ��HashSet����������HashSet�ײ�ԭ��
 * @author ���
 *
 */
public class SxtHashSet {
	
	HashMap map;
	
	private static final Object  PRESENT = new Object();
	
	public SxtHashSet() {
		map = new HashMap();
	}
	
	public  int  size(){
		return  map.size();
	}
	
	public void add(Object o){
		map.put(o, PRESENT);
	}
	
	@Override
	public String toString() {
		
		StringBuilder   sb = new StringBuilder();
		sb.append("[");
		
		for(Object key:map.keySet()){
			sb.append(key+",");
		}
		sb.setCharAt(sb.length()-1, ']');  
		return  sb.toString();
		
	}
	
	public static void main(String[] args) {
		SxtHashSet   set = new SxtHashSet();
		set.add("aaa");
		set.add("bbb");
		set.add("ccc");
		
		System.out.println(set);
		
	}
	
}
