package dataStructurePractice.hash;

import java.util.HashMap;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

//һ���Թ�ϣ�㷨����ֱ�����
public class DHTForDBTable {
	private TreeMap<Integer,Integer> store=new TreeMap<>();
	//����ڵ���������ڵ���Զ�һ�㣬�����ھ��ȷ���
	private static final int VIRTUAL_NODES = 150;
	
	DHTForDBTable(Integer[] nodeTable){
		for (int i=0;i<nodeTable.length;i++){
			int hash=getHash("table_order_"+String.valueOf(nodeTable[i]));
//			System.out.println(nodeTable[i]+"-"+hash);
			store.put(hash, nodeTable[i]);
			for (int j=0;j<VIRTUAL_NODES;j++){
				int hashV=getHash(String.valueOf("table_order_"+nodeTable[i]+(nodeTable.length+1)*j));
//				System.out.println(nodeTable[i]+(nodeTable.length+1)*j+"-"+hash);
				store.put(hashV, nodeTable[i]);
			}
		}
		
		//����ڵ�
		
	}

	public Integer getNode(Integer userId){
		int hash=getHash(String.valueOf(userId));
		SortedMap<Integer, Integer> subview=store.tailMap(hash);
		if (subview.isEmpty()){
			return store.get(store.firstKey());
		}
		return store.get(subview.firstKey());
	}
	

	/**
	 * ʹ��FNV1_32_HASH�㷨�����������Hashֵ,���ﲻʹ����дhashCode�ķ���������Ч��û����
	 */
	private static int getHash(String str) {
		final int p = 16777619;
		int hash = (int) 2166136261L;
		for (int i = 0; i < str.length(); i++)
			hash = (hash ^ str.charAt(i)) * p;
		hash += hash << 13;
		hash ^= hash >> 7;
		hash += hash << 3;
		hash ^= hash >> 17;
		hash += hash << 5;

		// ����������ֵΪ������ȡ�����ֵ
		if (hash < 0)
			hash = Math.abs(hash);
		return hash;
	}
	
	public static void main(String[] args) {
		Integer userNumber=10000;//�û�����
		Integer tableNumber=5;
		Integer[] table=new Integer[tableNumber];
		for (int i=0;i<tableNumber;i++){
			table[i]=i;
		}
		HashMap<Integer,Integer> count=new HashMap<>();
	
		DHTForDBTable test=new DHTForDBTable(table);
//		Integer[] userIds={100,213,122,312,1,500};
		for (int i=0;i<userNumber;i++){
			test.docount(count, test.getNode(i));
		}
		
		Set<Integer> keys=count.keySet();
		for (Integer key:keys){
			System.out.println(key+"-"+(((float)count.get(key)*100)/userNumber)+"%");
		}
		//System.out.println(count);
	}
	
	private void docount(HashMap<Integer,Integer> count,Integer node){
		if (!count.containsKey(node)){
			count.put(node, 0);
		}else{
			count.put(node, count.get(node)+1);
		}
	}
}
