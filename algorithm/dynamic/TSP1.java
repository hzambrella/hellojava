package algorithm.dynamic;

import java.util.ArrayList;  
import java.util.List;  
import java.util.Map;  
import java.util.HashMap;  
  
 // �ο�http://blog.csdn.net/ganglia/article/details/7074776
//��������store�������ġ��������4*4�������һ�е�һ��Ϊ00��
//store��key�Ǹ�λ��ʱ,��1������3-->1��ʮλ������12 ���� 2---1>   3--->2
//3012    0-->3  1-->0  2-->1  3-->2  =====>  0--->3---->2--->1--->0
//1230   =====��0-->1--->2--->3-->0
//���������nλ������m�����n��cityȥ��m��city��
//֤���ڷ���thePrint�ĵ����С�map()

//������򵱾���ά�ȴ��˻��������ڳ����������ϣ�������ٵķ�ʽ��O(n^n)
//������7�����С���������������
public class TSP1 {  
  
  
    private double[][] dArray; //�������  
    private int length; //�������ĳ���  
    private int lengthOfLength; //������󳤶��ַ����ĳ���  
    private String allzero = ""; //0��ɵ��ַ���  ���ֵ��length��(length - 1)�����������ַ�����ͬ����Сֵ��length��0��������  
    private String biggest ="";  
    private List<String> list = new ArrayList<String>();  //�������б�
    private Map<String, Double> store;   //�洢�м�����  
    private String notExist = "������";  
    private String firnalRoad = notExist; //���յ�·���������������к�ȡֵ  
    private String firnalCityFlow = ""; //�����γɵĳ�����  
    private String min = notExist; //������õ���Сֵ  
    private String allFlowTime = notExist; //������г�������ʱ��  
    private String guihuaTime = notExist; //��̬�滮��ʱ��  
  
  
    /** Creates a new instance of TwentyTwo */  
    public TSP1(double[][] dArray) {  
        if (this.check(dArray)) {  
            this.dArray = dArray;  
            this.length = dArray.length;  
            //1
            this.lengthOfLength = (length - 1 + "").length();  
            for (int zeroLength = 0; zeroLength < (length * lengthOfLength);) {  
                allzero += 0;  
                zeroLength = allzero.length();  
            } 
           
            for(int i = this.length; i > 0; i--){  
                this.biggest += this.toLengthOfLength(i - 1);  
            }  
            
            System.out.println("start,biggest:"+biggest);
            System.out.println("start,lengthOfLength:"+lengthOfLength);
            long start = System.currentTimeMillis();  
            this.allFlow();  
            System.out.println(list);
            long end = System.currentTimeMillis();  
            this.allFlowTime = end - start + "����";  
            start = System.currentTimeMillis();  
            this.initstoreMap();  
            this.guihua(this.length - 2);  
            end = System.currentTimeMillis();  
            this.guihuaTime = end - start + "����";  
        }  
    }  
  
  
    public String getFirnalRoad() {  
        return this.firnalRoad;  
    }  
  
  
    public String getFirnalCityFlow() {  
        if ("".equals(this.firnalCityFlow)) {  
            return this.notExist;  
        }  
        return this.firnalCityFlow;  
    }  
  
  
    public String getMin() {  
        return this.min;  
    }  
  
  
    public String getAllFlowTime() {  
        return this.allFlowTime;  
    }  
  
  
    public String getGuihuaTime() {  
        return this.guihuaTime;  
    }  
    //�������������Ч���ж�  
  
  
    private boolean check(double[][] dArray) {  
        if (dArray.length < 3) {  
            System.out.println("������Ϣ��������󳤶ȹ�С");  
            return false;  
        }  
        for (int i = 0; i < dArray.length; i++) {  // ÿ��double[]�ĳ��ȶ������ж�  
            if (dArray.length != dArray[i].length) {  
                System.out.println("������Ϣ���������鳤�Ȳ��Ϸ�");  
                return false;  
            }  
        }  
        for (int i = 0; i < dArray.length; i++) {  
            if (!oneZero(dArray[i], i)) {  
                System.out.println("������Ϣ����������˳���Ԫ��ֵ���ò��Ϸ�");  
                return false;  
            }  
        }  
        return true;  
    }  
    //����һ��doulbe���͵����飬ֻ�е�i��Ԫ��Ϊ0���ж�  
  
  
    private boolean oneZero(double[] dArray, int i) {  
        int numOfZero = 0;  
        for (double d : dArray) {  
            if (d == 0.0) {  
                numOfZero++;  
            }  
        }  
        if (numOfZero == 1 && (dArray[i] == 0)) {  
            return true;  
        } else {  
            return false;  
        }  
    }  
    //�ж�һ���������Ƿ�Ϸ�  
  
  
    private boolean oneFlow(String str) {  
        //��һ���ַ�������Ϊһ���ַ�����  
        List<String> listString = new ArrayList<String>();  
        for (int i = 0; i < (this.length * this.lengthOfLength);) {  
            listString.add(str.substring(i, i + this.lengthOfLength));  
            i += this.lengthOfLength;  
        }  
        //�������ͬ��Ԫ�أ���false  
        for (int i = 0; i < (this.length - 1); i++) {  
            for (int j = i + 1; j < this.length; j++) {  
                if (listString.get(i * this.lengthOfLength).equals(listString.get(j * this.lengthOfLength))) {  
                    return false;  
                }  
            }  
        }  
        //����о������ȫ0�Խ����ϵ�Ԫ�أ���false  
        for (int i = 0; i < listString.size(); i++) {  
            if (Integer.parseInt(listString.get(i)) == i) {  
                return false;  
            }  
        }  
        //�ų�û�б������г��е��������0���������0�㣩  
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();  
        for (int i = 0; i < this.length;) {  
            map.put(i, Integer.parseInt(str.substring(i, i + this.lengthOfLength)));  
            i += this.lengthOfLength;  
        }  
        int allcity = 0;  
        for (int i = 0;;) {  
            i = map.get(i);  
            allcity++;  
            if (i == 0) {  
                break;  
            }  
        }  
        if (allcity < this.length) {  
            return false;  
        }  
        return true;  
    }  
    //��ʼ���洢map  
  

    private void initstoreMap() {  
        this.store = new HashMap<String, Double>();  
        //�����������һ�п��ܵ��к�  
        for (int i = 0; i < this.length - 1; i++) {  
            this.store.put(this.toLengthOfLength(i), this.dArray[this.length - 1][i]);  
        }  
        System.out.println("�����������һ�п��ܵ��к�  "+store);
        //�������������п��ܵ��к�  
        for (int i = 0; i < this.length; i++) {  
            if(i == this.length -2)  
                continue;  
            for (int j = 0; j < this.length - 1; j++) {  
                if (i == j) {  
                    continue;  
                }  
                store.put(this.toLengthOfLength(i) + this.toLengthOfLength(j), this.dArray[this.length - 2][i] + store.get(this.toLengthOfLength(j)));  
            }  
        }
        System.out.println("�������������п��ܵ��к�"+store);
    }  
  
  
    //��������ĳ�������ǰlength - 2 - temp������ͬ�����治ͬ���ö�̬�滮ʵ��  
    private void guihua(int temp) {  
        if (list.size() == 1) {  
            this.firnalRoad = list.get(0);  
            this.thePrint(list.get(0));  
            this.min = this.store.get(list.get(0)) + "";  
            return;  
        }  
        for (int i = 0; i < (list.size() - 1); i++) {  
            int next = (i + 1);  
            //��123405 123504 0-2λ��ͬ  0-1λҲ��ͬ��ǰ����ͬ���ȶԱȣ�ȡ��ѽ���� 
            if (list.get(i).substring(0, temp * this.lengthOfLength).equals(list.get(next).substring(0, temp * this.lengthOfLength))) {  

            	double iValue = 0;  
                double nextValue = 0;  
  
                System.out.println("��ʼ�Ա�:"+list.get(i).substring(0, temp * this.lengthOfLength)+"����:"+temp);
            
                iValue = this.dArray[temp][Integer.parseInt(list.get(i).substring(temp, temp + this.lengthOfLength))] +  
                        store.get(list.get(i).substring((temp + 1) * this.lengthOfLength)); 
                
                System.out.print("iValue��ֵ"+iValue);
                System.out.print(" dArray["+temp+"]"+"["+Integer.parseInt(list.get(i).substring(temp, temp + this.lengthOfLength))+"]");
                System.out.println(" store.get("+list.get(i).substring((temp + 1) * this.lengthOfLength)+")");


                nextValue = this.dArray[temp][Integer.parseInt(list.get(next).substring(temp, temp + this.lengthOfLength))] +  
                        store.get(list.get(next).substring((temp + 1) * this.lengthOfLength));  
                
                System.out.print("nextValue��ֵ"+nextValue);
                System.out.print(" dArray["+temp+"]"+"["+Integer.parseInt(list.get(next).substring(temp, temp + this.lengthOfLength))+"]");
                System.out.println(" store.get("+list.get(next).substring((temp + 1) * this.lengthOfLength)+")");
  
                this.store.put(list.get(i).substring(temp * this.lengthOfLength), iValue);  
                this.store.put(list.get(next).substring(temp * this.lengthOfLength), nextValue);  
  
   /*             System.out.println(list.get(i).substring(temp * this.lengthOfLength));
                System.out.println(list.get(next).substring(temp * this.lengthOfLength));*/
                
                if (iValue >= nextValue) {  
                    list.remove(i);  
                } else {  
                    list.remove(next);  
                }  
                i--;  
            }  
        }  
        System.out.println(list);
        this.guihua(temp - 1);  
    }  
    //������еĳ����� �����︴�Ӷ�̫�ߣ�Ҫ��list����biggest��add������������7*7���� 
  
  
    private void allFlow() {  
        while (!this.biggest.equals(this.allzero)) { 
            this.allzero = this.addone(this.allzero);  
            if (this.oneFlow(this.allzero)) {  
                this.list.add(this.allzero); 
            	
            }  
        }
        System.out.println("allzero:"+allzero);
    }  
    //��length���Ƶ��ַ�����1����  
  
  
    private String addone(String str) {  
        List<String> listString = new ArrayList<String>();  
        for (int i = 0; i < (this.length * this.lengthOfLength);) {  
            listString.add(str.substring(i, i + this.lengthOfLength));  
            i += this.lengthOfLength;  
        }  
        for (int i = (length - 1); i > -1; i--) {  
            int last = Integer.parseInt(listString.get(i));  
            if (last == (length - 1)) {  
                last = 0;  
                String strLast = this.toLengthOfLength(last);  
                listString.set(i, strLast);  
            } else {  
                last++;  
                String strLast = this.toLengthOfLength(last);  
                listString.set(i, strLast);  
                break;  
            }  
        }  
        String ret = "";  
        for (String s : listString) {  
            ret += s;  
        }  
        return ret;  
    }  
    //���һ��int�ַ������Ȳ���lengthOfLength ����  
  
  
    private String toLengthOfLength(Object i) {  
        String returnString = i.toString();  
//        System.out.println("returnString:"+returnString);
        while (returnString.length() < this.lengthOfLength) {  
            returnString = (0 + returnString);  
        }  
        return returnString;  
    }  
    //��һ���ַ�����ֵӳ�䣬����׼���  
  
  
    private void thePrint(String str) {  
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();  
        for (int i = 0; i < this.length;) {  
            map.put(i, Integer.parseInt(str.substring(i, i + this.lengthOfLength)));  
            i += this.lengthOfLength;  
        }  
        String cityFlow = this.toLengthOfLength(0);  
        for (int i = 0;;) {  
            i = map.get(i);  
            cityFlow += this.toLengthOfLength(i);  
            if (i == 0) {  
                break;  
            }  
        }  
        for (int i = 0; i < this.length + 1;) {  
            if (i < (this.length)) {  
                this.firnalCityFlow += Integer.parseInt(cityFlow.substring(i, i + this.lengthOfLength)) + "->";  
            } else {  
                this.firnalCityFlow += Integer.parseInt(cityFlow.substring(i, i + this.lengthOfLength));  
            }  
            i += this.lengthOfLength;  
        }  
    }  
  
  
    public static void main(String[] args) {  
/*        double[][] first = {    //�����ڵ�֮��·�����ȵĶ�ά����  
            {0, 2, 1, 3, 4, 5, 5, 6},  
            {1, 0, 4, 4, 2, 5, 5, 6},  
            {5, 4, 0, 2, 2, 6, 5, 6},  
            {5, 2, 2, 0, 3, 2, 5, 6},  
            {4, 2, 4, 2, 0, 3, 5, 6},  
            {4, 2, 4, 2, 3, 0, 5, 6},  
            {4, 2, 4, 2, 4, 3, 0, 6},  
            {4, 2, 4, 2, 8, 3, 5, 0}}; */
/*        double[][] first={
        		{0,8566,9541,16808,28892,26086,15161,21438,34102,23661},
        		{8599,0,9321,16935,25888,30368,17596,25038,31988,34461},
        		{9782,8117,0,12821,22815,25118,12346,19788,26738,28207},
        		{17379,15803,13803,0,11537,24764,12250,20230,26855,37138},
        		{26930,26466,23354,13847,0,21213,17973,25231,25093,46356},
        		{26070,30544,25087,25871,19305,0,13726,15837,12520,33783},
        		{15972,17416,12195,13230,17031,14689,0,9279,15904,28118},
        		{22082,29457,20325,21243,24381,16116,9545,0,8344,19337},
        		{26913,35483,26805,27592,22497,11592,15894,9110,0,24922},
        		{22557,35141,25580,34383,45378,33873,23083,19605,24844,0}
        		};
*/
        double[][] first={
{0,66,95,16,288,26,15,218,32,21},
{99,0,93,169,258,308,17,258,31,36},
{82,81,0,128,225,258,12,198,26,27},
{179,153,138,0,137,264,12,200,26,33},
{230,264,233,147,0,213,17,21,25,46},
{260,305,257,271,193,0,13,137,12,33},
{15,174,121,130,170,14,0,99,10,28},
{22,294,203,213,243,16,95,0,83,19},
{26,35,265,27,224,115,89,91,0,24},
{22,35,25,383,78,383,83,65,44,0}
};
/*        double[][] first = {    //�����ڵ�֮��·�����ȵĶ�ά����  
                {0, 2121, 5121,121},  
                {2123, 0, 421,321},  
                {5121, 432, 0,412}, 
                {121, 321, 412,0}, 

              };  */

        long start = System.currentTimeMillis();  
        TSP1 ff = new TSP1(first);  
        System.out.println("·���ǣ�" + ff.getFirnalRoad());  
        System.out.println("����˳��" + ff.getFirnalCityFlow());  
        System.out.println("��Сֵ��" + ff.getMin());  
        System.out.println("�������кϷ���������ʱ��" + ff.getAllFlowTime());  
        System.out.println("��̬�滮��������ʱ��" + ff.getGuihuaTime());  
    }  
}  
