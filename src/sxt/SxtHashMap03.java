package sxt;

/**
 * �Զ���һ��HashMap
 * ʵ��get���������ݼ������ö�Ӧ��ֵ����
 * @author ���
 *
 */
public class SxtHashMap03 {
	
	Node2[]  table;    //λͰ���顣bucket  array
	int size;				//��ŵļ�ֵ�Եĸ���
	
	public SxtHashMap03() {
		table = new Node2[16];    //����һ�㶨���2��������
	}
	
	
	public  Object  get(Object  key){
		
		int  hash = myHash(key.hashCode(), table.length);
		Object value = null; 
		
		if(table[hash]!=null){
			Node2  temp = table[hash];
			
			while(temp!=null){
				
				if(temp.key.equals(key)){   //�����ȣ���˵���ҵ��˼�ֵ�ԣ�������Ӧ��value
					value = temp.value;
					break;
				}else{
					temp = temp.next;
				}
			}
			
		}
		
		return value;
	}
	
	
	public  void   put(Object key,  Object   value){
		
		//���Ҫ���ƣ�����Ҫ�����������ݵ����⣡����
		
		//�������µĽڵ����
		Node2    newNode = new Node2();
		newNode.hash = myHash(key.hashCode(),table.length);
		newNode.key =  key;
		newNode.value = value;
		newNode.next = null;
		
		Node2 temp = table[newNode.hash];
		
		Node2  iterLast = null;  //���ڱ��������һ��Ԫ��
		boolean  keyRepeat = false;  
		if(temp==null){
			//�˴�����Ԫ��Ϊ�գ���ֱ�ӽ��½ڵ�Ž�ȥ
			table[newNode.hash] = newNode;
			size++;
		}else{
			//�˴�����Ԫ�ز�Ϊ�ա��������Ӧ������
			while(temp!=null){
				
				//�ж�key����ظ����򸲸�
				if(temp.key.equals(key)){
					keyRepeat = true;
					temp.value =  value;  //ֻ�Ǹ���value���ɡ�������ֵ(hash,key,next)���ֲ��䡣
					
					break;
					
				}else{
					//key���ظ����������һ����
					iterLast = temp;
					temp = temp.next;
					
				}
			}
			
			if(!keyRepeat){   //û�з���key�ظ������������ӵ��������
				iterLast.next = newNode;
				size++;
			}
			
		}
		
		
		
	}

	
	@Override
	public String toString() {
		//{10:aa,20:bb}
		StringBuilder  sb = new StringBuilder("{");
		
		//����bucket����
		for(int i=0;i<table.length;i++){
			Node2  temp = table[i]; 
			
			//��������
			while(temp!=null){
				sb.append(temp.key+":"+temp.value+",");
				temp  = temp.next;
			}
		}
		sb.setCharAt(sb.length()-1, '}'); 
		return sb.toString();
		
	}
	
	
	public static void main(String[] args) {
		SxtHashMap03  m = new SxtHashMap03();
		m.put(10, "aa");
		m.put(20, "bb");
		m.put(30, "cc");
		m.put(20, "ssss");
		
		m.put(53, "gg");
		m.put(69, "hh");
		m.put(85, "kk");
		
		
		System.out.println(m);

//		for(int i=10;i<100;i++){
//			System.out.println(i+"---"+myHash(i,16));   //53, 69,85
//		}
		
		System.out.println(m.get(85));  
		
	}
	
	
	public static  int  myHash(int  v, int length){
//		System.out.println("hash in myHash:"+(v&(length-1)));		//ֱ��λ���㣬Ч�ʸ�
//		System.out.println("hash in myHash:"+(v%(length-1)));		//ȡģ���㣬Ч�ʵ�
		return  v&(length-1);
	}
	
	
}


