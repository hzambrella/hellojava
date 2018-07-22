package DataStructTree.Test;

import static org.junit.Assert.*;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

import DataStructTree.BiTree;
import DataStructTree.BiTreeNode;

public class TestTree {

	@Test
	public void testCreateTree() {
//		String str="ABCDEFG";
//		char[] charArray=str.toCharArray();
//		String[] strArray=new String[charArray.length];
//		for (int i=0;i<charArray.length;i++){
//			strArray[i]=String.valueOf(charArray[i]);
//		}
//		BiTree<String> bTree=new BiTree<>(strArray);
		
		LinkedList<String> dataqueue=new LinkedList<>();

		dataqueue.add("A");
		dataqueue.add("B");
		dataqueue.add("D");
		dataqueue.add(null);
		dataqueue.add(null);
		dataqueue.add("E");
		dataqueue.add(null);
		dataqueue.add(null);
		dataqueue.add("C");
		dataqueue.add("F");
		dataqueue.add(null);
		dataqueue.add(null);
		dataqueue.add("G");
		dataqueue.add(null);
		dataqueue.add(null);
		BiTree<String> bTree=new BiTree<>(dataqueue);
		System.out.println(bTree.preOrderTraverse());
		System.out.println(bTree.midOrderTraverse());
	}
	
	
	@Test
	public void testTraverse() {
		BiTree<String> tree=new BiTree<>("A");
		BiTreeNode<String> root=tree.getRoot();
		BiTreeNode<String>nodeb=new BiTreeNode<>("B");
		BiTreeNode<String>nodec=new BiTreeNode<>("C");
		BiTreeNode<String>noded=new BiTreeNode<>("D");
		BiTreeNode<String>nodee=new BiTreeNode<>("E");
		BiTreeNode<String>nodef=new BiTreeNode<>("F");
		BiTreeNode<String>nodeg=new BiTreeNode<>("G");
		root.setLeftChild(nodeb);
		root.setRightChild(nodec);
		nodeb.setLeftChild(noded);
		nodeb.setRightChild(nodee);
		nodec.setLeftChild(nodef);
		nodec.setRightChild(nodeg);
		System.out.println(tree.preOrderTraverse());
	}
}
