package simple;

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
    public void addStudent(ArrayList<Student> students) {

        String ID = "";
        while(true) {
            boolean flag = true;
            // 判断id是否重复
            System.out.print("输入学号:");
            ID = scanner.next();
            for(int i = 0;i < students.size();i++) {
                if(students.get(i).getId().equals(ID)) {
                    System.out.println("抱歉,该学号已存在!");
                    flag = false;
                    break;
                }
            }
            if(flag) {
                break;
            }
        }
        System.out.print("输入姓名:");
        String Aname = scanner.next();
        System.out.print("输入语文成绩:");
        int Achinese = scanner.nextInt();
        System.out.print("输入数学成绩:");
        int Amath = scanner.nextInt();
        System.out.print("输入英语成绩:");
        int Aenglish = scanner.nextInt();
        Student student1 = new Student(Aname,ID,Achinese,Amath,Aenglish);
        students.add(student1);
        System.out.println("添加成功!");
    }

    // 删除
    public void delStudent(String id) {
        boolean isFind = true;
        if(students.size() == 0) {
            System.out.println("抱歉,没有找到该学生!");
        }
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId().equals(id)) {
                isFind = false;
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
        if(isFind) {
            System.out.println("没有找到该学生,请确认输入的学号是否正确!");
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
        boolean isFind = true;
        if(students.size() == 0) {
            System.out.println("抱歉,没有找到该学生!");
        }
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getName().equals(name)) {
                isFind = false;
                System.out.println(students.get(i).toString());
            }
        }
        if(isFind) {
            System.out.println("没有找到该学生,请确认输入的学生名字是否正确!");
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
        System.out.println("1-显示 2-查询 3-增加 4-删除 5-修改 6-排名 0-退出");
        System.out.println("---------------------------------------------------");
    }

    // 学生排序
    public void studentSort(ArrayList<Student> students) {
        System.out.println("排名依据:1-语文成绩 2-数学成绩 3-英语成绩 4-总成绩");
        System.out.print("请选择:");
        int sortChoice = scanner.nextInt();
        int lastExchangIndex = 0;
        int sortBoard = students.size()-1;
        for(int i = 0;i < students.size()-1;i++) {
            boolean isSorted = true;
            for(int j = 0;j < sortBoard;j++) {
                if(sortChoice == 1) {
                    if(students.get(j).getChinese() < students.get(j+1).getChinese()) {
                        Student temp = students.get(j);
                        students.set(j,students.get(j+1));
                        students.set(j+1,temp);
                        isSorted = false;
                        lastExchangIndex = j;
                    }
                }else if(sortChoice == 2) {
                    if(students.get(j).getMath() < students.get(j+1).getMath()) {
                        Student temp = students.get(j);
                        students.set(j,students.get(j+1));
                        students.set(j+1,temp);
                        isSorted = false;
                        lastExchangIndex = j;
                    }
                }else if(sortChoice == 3) {
                    if(students.get(j).getEnglish() < students.get(j+1).getEnglish()) {
                        Student temp = students.get(j);
                        students.set(j,students.get(j+1));
                        students.set(j+1,temp);
                        isSorted = false;
                        lastExchangIndex = j;
                    }
                }else if(sortChoice == 4) {
                    if (students.get(j).getTotal() < students.get(j + 1).getTotal()) {
                        Student temp = students.get(j);
                        students.set(j, students.get(j + 1));
                        students.set(j + 1, temp);
                        isSorted = false;
                        lastExchangIndex = j;
                    }
                }
            }
            if(isSorted) {
                break;
            }
            sortBoard = lastExchangIndex;
        }
    }
}
