package medium;

import simple.Student;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        DB db = new DB();

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            int choice = 0;
            // 显示调用
            System.out.println("---------------------操作数据库----------------------");
            System.out.println("1-显示 2-查询 3-增加 4-删除 5-修改 0-退出");
            System.out.println("---------------------------------------------------");
            System.out.print("请选择:");
            try {
                choice = scanner.nextInt();
            } catch(InputMismatchException e) {
                System.out.println("请输入符合要求的选项!再见!");
            }
            switch (choice) {
                case 1:
                    db.showData();
                    break;
                case 2:
                    // 查询
                    System.out.print("请输入想要查询的学生学号:");
                    String QueryName = scanner.next();
                    db.queryData(QueryName);
                    break;
                case 3:
                    // 添加
                    System.out.print("输入姓名:");
                    String Aname = scanner.next();
                    System.out.print("输入学号:");
                    String ID = scanner.next();
                    System.out.print("输入语文成绩:");
                    int Achinese = scanner.nextInt();
                    System.out.print("输入数学成绩:");
                    int Amath = scanner.nextInt();
                    System.out.print("输入英语成绩:");
                    int Aenglish = scanner.nextInt();
                    Student student1 = new Student(Aname,ID,Achinese,Amath,Aenglish);
                    db.AddData(student1);
                    break;
                case 4:
                    // 删除
                    System.out.print("请输入想要删除的学生学号:");
                    String DelId = scanner.next();
                    db.DeleteData(DelId);
                    break;
                case 5:
                    System.out.print("请输入想要修改的学生学号:");
                    String ModifyID = scanner.next();
                    db.ModifyData(ModifyID);
                    break;
                case 0:
                    flag = false;
                    break;
            }
        }
    }
}
