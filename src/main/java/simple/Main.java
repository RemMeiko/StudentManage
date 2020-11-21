package simple;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Student student = new Student("小明","B2018",45,56,76);
        ArrayList<Student> list = new ArrayList<>();
        list.add(student);
        Manage manage = new Manage(list);

        boolean flag = true;
        while(flag) {
            // 显示调用
            manage.show();
            System.out.print("请选择:");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    manage.according();
                    break;
                case 2:
                    System.out.print("请输入想要查询的学生姓名:");
                    String QueryName = in.next();
                    manage.query(QueryName);
                    break;
                case 3:
                    manage.addStudent(list);
                    break;
                case 4:
                    System.out.print("请输入想要删除的学生学号:");
                    String DelId = in.next();
                    manage.delStudent(DelId);
                    break;
                case 5:
                    System.out.print("请输入想要修改的学生学号:");
                    String ModifyID = in.next();
                    manage.modifyStudy(ModifyID);
                    break;
                case 6:
                    manage.studentSort(list);
                    for (Student k:list) {
                        System.out.println(k.toString());
                    }
                    break;
                case 0:
                    flag = false;
                    break;
            }
        }
    }
}
