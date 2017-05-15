package hellojava.TestEnum;

import java.util.*;

public class TestEnum {

	// 1.����ö������

	public enum Light {

		// ���ù��캯������

		RED(1), GREEN(3), YELLOW(2);

		// ����˽�б���

		private int nCode;

		// ���캯����ö������ֻ��Ϊ˽��

		private Light(int _nCode) {

			this.nCode = _nCode;

		}

		@Override
		public String toString() {

			return String.valueOf(this.nCode);

		}

	}

	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		// 1.����ö������

		System.out.println("��ʾö�����͵ı��� ......");

		testTraversalEnum();

		// 2.��ʾEnumMap�����ʹ��

		System.out.println("��ʾEnmuMap�����ʹ�úͱ���.....");

		testEnumMap();

		// 3.��ʾEnmuSet��ʹ��

		System.out.println("��ʾEnmuSet�����ʹ�úͱ���.....");

		testEnumSet();

	}

	/**
	 * 
	 * ��ʾö�����͵ı���
	 */

	private static void testTraversalEnum() {

		//values
		Light[] allLight = Light.values();

		for (Light aLight : allLight) {

			
			System.out.println("��ǰ�Ƶ����֣���RED����" + aLight.name());

			System.out.println("��ǰ�Ƶ���ţ���0����" + aLight.ordinal());

			System.out.println("��ǰ�Ƶ����ݣ���RED(1)�е�1����" + aLight);

		}

	}

	/**
	 * 
	 * ��ʾEnumMap��ʹ�ã�EnumMap��HashMap��ʹ�ò�ֻ࣬����keyҪ��ö������
	 */

	private static void testEnumMap() {

		// 1.��ʾ����EnumMap����EnumMap����Ĺ��캯����Ҫ��������,Ĭ����key���������

		EnumMap<Light, String> currEnumMap = new EnumMap<Light, String>(

				Light.class);

		currEnumMap.put(Light.RED, "���");

		currEnumMap.put(Light.GREEN, "�̵�");

		currEnumMap.put(Light.YELLOW, "�Ƶ�");

		// 2.��������

		for (Light aLight : Light.values()) {

			System.out.println("[key=" + aLight.name() + ",value="

					+ currEnumMap.get(aLight) + "]");

		}

	}

	/**
	 * 
	 * ��ʾEnumSet���ʹ�ã�EnumSet��һ�������࣬��ȡһ�����͵�ö����������<BR/>
	 * 
	 * ����ʹ��allOf����
	 */

	private static void testEnumSet() {

		EnumSet<Light> currEnumSet = EnumSet.allOf(Light.class);

		for (Light aLightSetElement : currEnumSet) {

			System.out.println("��ǰEnumSet������Ϊ��" + aLightSetElement);

		}

	}

}
