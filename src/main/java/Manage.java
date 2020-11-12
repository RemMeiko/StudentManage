

import java.util.ArrayList;
import java.util.Scanner;

public class Manage {
    private ArrayList<Student> students;
    private Student stu;
    private Scanner scanner = new Scanner(System.in);

    public Manage() {
    }

    public Manage(ArrayList<Student> Nstudents) {
        this.students = Nstudents;
    }

    // 添加
    public void addStudent(Student stu) {
        // 判断id是否重复
        for(int i = 0;i < students.size();i++) {
            if(students.get(i).getId().equals(stu.getId())) {
                System.out.println("抱歉,该学生已存在!");
                break;
            }
            students.add(stu);
            System.out.println("添加成功!");
            break;
        }
    }

    // 删除
    public void delStudent(String id) {
        System.out.println("正在查询...");
        if(students.size() == 0) {
            System.out.println("抱歉,没有找到该学生!");
        }
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId().equals(id)) {
                System.out.println(students.get(i).toString());
                System.out.println("是否确认删除Y/N");
                System.out.print("请选择:");
                String choice = scanner.next();
                if(choice.equals("Y")) {
                    students.remove(i);
                    System.out.println("删除成功");
                } else {
                    System.out.println("已取消");
                }
            }
        }
    }

    // 修改
    public void modifyStudy(String Id) {
        if(students.size() == 0) {
            System.out.println("抱歉,没有找到该学生");
        }

        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId().equals(Id)) {
                System.out.printf("查找到符合要求的学生:\n"+students.get(i).toString()+"\n");
                boolean flag = true;
                while(flag) {
                    System.out.println("1-姓名,2-学号,3-语文,4-数学,5-英语,0-退出");
                    System.out.print("请选择想要修改的序号:");
                    int choice = scanner.nextInt();
                    if(choice == 0) {
                        break;
                    }
                    System.out.print("输入修改后信息:");
                    switch(choice) {
                        case 1:
                            String string =  scanner.next();
                            students.get(i).setName(string);
                            break;
                        case 2:
                            String id =  scanner.next();
                            students.get(i).setId(id);
                            break;
                        case 3:
                            int chinese =  scanner.nextInt();
                            students.get(i).setChinese(chinese);
                            break;
                        case 4:
                            int math = scanner.nextInt();
                            students.get(i).setMath(math);
                            break;
                        case 5:
                            int english = scanner.nextInt();
                            students.get(i).setEnglish(english);
                            break;
                    }
                }
            }
        }
    }


    // 查询
    public void query(String name) {
        if(students.size() == 0) {
            System.out.println("抱歉,没有找到该学生!");
        }
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getName().equals(name)) {
                System.out.println(students.get(i).toString());
            }
        }
    }

    // 显示全部学生信息
    public void according() {
        if(students.size() == 0) {
            System.out.println("抱歉,没有学生!");
        }
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).toString());
        }
    }

    // 显示选项即开始界面
    public void show() {
        System.out.println("---------------------------------------------------");
        System.out.println("1-显示 2-查询 3-增加 4-删除 5-修改 0-退出");
        System.out.println("---------------------------------------------------");
    }
}
