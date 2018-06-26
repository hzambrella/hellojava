package testAndtry;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class TestDirTree {
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public HashMap<String, Object> resultList;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("E:/test");

		// System.out.println(f.getName());

		DirTreeNode dirTreeBaseNode = new DirTreeNode(f, 0);

		List<DirTreeNode> childNode = tree(f, 1);

		if (childNode != null) {
			dirTreeBaseNode.AddChildNode(childNode);
		}

		System.out.println(JSON.toJSONString(dirTreeBaseNode));
	}

	private static List<DirTreeNode> tree(File f, int level) throws IOException {
		List<DirTreeNode> dirNodeList = new ArrayList<DirTreeNode>();
		// String preStr = "";
		// for (int i = 0; i < level; i++) {
		// preStr += "    ";
		// }

		File[] childs = f.listFiles();
		for (int i = 0; i < childs.length; i++) {
			// System.out.println(preStr + childs[i].getName());
			if (childs[i].isDirectory()) {
				DirTreeNode thisNode = new DirTreeNode(childs[i],
						level);
				List<DirTreeNode> nextNodeList = tree(childs[i], level + 1);
				if (nextNodeList != null) {
					thisNode.AddChildNode(nextNodeList);
				}

				dirNodeList.add(thisNode);
			}
		}

		return dirNodeList;
	}

}

class DirTreeNode {
	public String name;
	public String size;
	public String modifiedTime;
	public int level;
	public List<DirTreeNode> childDirNode;

	public DirTreeNode(String name, int level) {
		this.level = level;
		this.name = name;
	};

	public DirTreeNode(String name, int size, String modifiedTime, int level) {
		this.name = name;
		this.size = this.formatSize(size);
		this.modifiedTime = modifiedTime;
		this.level = level;
	};

	public DirTreeNode(File f,int level) throws IOException {
		this.name = f.getName();
		
		if (!f.isDirectory()) {
			// 文件夹没大小
			FileInputStream fis = new FileInputStream(f);
			int fileSize = fis.available();
			this.size = formatSize(fileSize);
		}else{
			this.size = formatSize(0);
		}
		
		// 获取文件修改时间
		Calendar cal = Calendar.getInstance();
//		System.out.println(f.lastModified());
		cal.setTimeInMillis(f.lastModified());
//		System.out.println(cal.getTime());
		String modifytimeStr = TestDirTree.sdf.format(cal.getTime());
		this.modifiedTime=modifytimeStr;
		
		this.level=level;

	}

	public void AddChildNode(List<DirTreeNode> childNode) {
		this.childDirNode = childNode;
	}

	public String toString() {
		return this.name + this.level + this.childDirNode.toString();
	}

	private String formatSize(int fileS) {
		DecimalFormat df = new DecimalFormat("#.00");
		String size = "0";
		if (fileS <= 0) {
			size = "0";
		} else if (fileS < 1024) {
			size = df.format((double) fileS) + "BT";
		} else if (fileS < 1048576) {
			size = df.format((double) fileS / 1024) + "KB";
		} else if (fileS < 1073741824) {
			size = df.format((double) fileS / 1048576) + "MB";
		} else {
			size = df.format((double) fileS / 1073741824) + "GB";
		}
		return size;
	}

}
