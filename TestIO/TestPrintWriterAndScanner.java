package TestIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

//将工资写入到文件中。再读出来
public class TestPrintWriterAndScanner {
	public static void main(String[] args) {
		Employee[] employees = new Employee[3];
		employees[0] = new Employee("haozho", 1000, 1990, 3, 23);
		employees[1] = new Employee("zhangsan", 1000, 1990, 3, 23);
		employees[2] = new Employee("lisi", 1000, 1990, 3, 23);
		String fileName = "employee.dat";
		try (PrintWriter pw = new PrintWriter(fileName, "UTF-8");) {
			writeToFile(pw, employees);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}

		try (Scanner scanner = new Scanner(new FileInputStream(fileName),
				"UTF-8")) {
			Employee[] employees2=ReadFromFile(scanner);
			for (Employee employee2:employees2 ){
				System.out.println(employee2);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void writeToFile(PrintWriter pw, Employee[] employees) {
		GregorianCalendar calendar = new GregorianCalendar();
		for (Employee employee : employees) {
			Date date = employee.getDate();
			calendar.clear();
			calendar.setTime(date);
			pw.println(employee.getName() + "|" + employee.getSalary() + "|"
					+ calendar.get(Calendar.YEAR) + "|"
					+ calendar.get(Calendar.MONTH) + "|"
					+ calendar.get(Calendar.DATE));

		}
	}

	public static Employee[] ReadFromFile(Scanner scanner) {
		Employee[] employees = new Employee[3];
		int i=0;
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			String[] el = line.split("\\|");
			if (el.length != 5) {
				continue;
			}

			Employee employee = new Employee(el[0], Integer.parseInt(el[1]),
					Integer.parseInt(el[2]), Integer.parseInt(el[3]),
					Integer.parseInt(el[4]));
			
			employees[i]=employee;
			i++;
		}
		return employees;
	}
}
