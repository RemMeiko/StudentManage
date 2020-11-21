package medium;

import simple.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DB {
    public static void main(String[] args) throws SQLException {
        /*
        // 2.获取连接
        Connection connection = DriverManager.getConnection(url, name, password);
        System.out.println(connection);
        Statement statement = connection.createStatement();
        ResultSet rs = null;
        rs = statement.executeQuery("select * from student");
        while (rs.next()) {
            System.out.println(rs.getString("name") + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getInt("english"));
        }
        connection.close();*/
        DB dataTest = new DB();
        dataTest.showData();
        Student student = new Student("小黑", "B2021", 89, 45, 56);
        dataTest.AddData(student);
        int[] a = {34,45,56};
         dataTest.ModifyData("B2021");
        // 删除
        // dataTest.DeleteData("B2021");
    }

    // 数据库连接
    public Connection GetCon() {
        String drive = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/StudyManage?serverTimezone=GMT&characterEncoding=utf-8";
        String Name = "root";
        String Password = "root";

        // 加载驱动
        try {
            Class.forName(drive);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection con = null;
        // 建立连接
        try {
            con = DriverManager.getConnection(url, Name, Password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("连接数据库失败!");
        }
        return con;
    }

    // 查询数据库
    public void queryData(String id) {
        Connection con = GetCon();
        // sql语句
        String sql = "select * from student where ID=?";
        // 学生对象存储对象
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,id);
            ResultSet Result = preparedStatement.executeQuery();
            if(Result.next()) {
                String name,ID;
                int chinese,math,english;
                name = Result.getString("name");
                ID = Result.getString("ID");
                chinese = Result.getInt(3);
                math = Result.getInt(4);
                english = Result.getInt(5);
                Student student = new Student(name,ID,chinese,math,english);
                System.out.println(student.toString());
            } else {
                System.out.println("没有该学生!");
            }
        } catch(Exception e) {
            System.out.println("失败!");
        }
    }

    //显示数据库所有数据
    public void showData() throws SQLException{
        ArrayList<Student> list = new ArrayList<>();
        String sql = "select * from student";
        // 建立连接
        Connection con = GetCon();
        // 建立
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        // 返回结果对象
        ResultSet Result = preparedStatement.executeQuery();
        // System.out.println(Result.next());
        while (Result.next()) {
            Student student = new Student(Result.getString("name"), Result.getString("ID"), Result.getInt(3), Result.getInt(4), Result.getInt(5));
            list.add(student);
        }
        preparedStatement.close();
        con.close();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

    // 添加数据
    public void AddData(Student s) {
        Connection con = GetCon();
        String sql = "select * from student where ID=?";
        String sqlAdd = "INSERT INTO student(name,ID,chinese,math,english,total) VALUES(?,?,?,?,?,?)";
        try {
            // 判断该学生是否存在
            PreparedStatement isResult = con.prepareStatement(sql);
            isResult.setString(1, s.getId());
            ResultSet isSet = isResult.executeQuery();
            // 返回true表示已存在
            if (!isSet.next()) {
                PreparedStatement statement = con.prepareStatement(sqlAdd);
                statement.setString(1, s.getName());
                statement.setString(2, s.getId());
                statement.setInt(3, s.getChinese());
                statement.setInt(4, s.getMath());
                statement.setInt(5, s.getEnglish());
                statement.setInt(6, s.getTotal());
                statement.execute();
                statement.close();
            } else {
                System.out.println("不好意思,该学生已存在!");
            }
            // 释放资源
            isResult.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("添加失败");
        }
    }

    // 删除数据
    public void DeleteData(String id) {
        Connection con = GetCon();
        String sql = "select * from student where ID=?";
        String sqlDelete = "delete FROM student where ID=?";
        try {
            PreparedStatement isResult = con.prepareStatement(sql);
            isResult.setString(1, id);
            if (!isResult.executeQuery().next()) {
                System.out.println("抱歉,没有找到该学生!");
                isResult.close();
            } else {
                // 创建数据集接受对象
                PreparedStatement Result = con.prepareStatement(sqlDelete);
                Result.setString(1, id);
                Result.execute();
                System.out.println("删除成功!");
            }
            isResult.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("删除失败");
        }
    }

    //修改数据
    public void ModifyData(String id) throws SQLException {
        Connection con = GetCon();
        // sql,isResult,isUpdate用来判断该学生是否存在
        String sql = "SELECT * FROM student WHERE ID=?";
        // String sqlUpdate = "UPDATE student set chinese=? where ID=?";
        Scanner scanner = new Scanner(System.in);
        // 判断
        PreparedStatement isUpdate = con.prepareStatement(sql);
        isUpdate.setString(1,id);
        ResultSet isResult = isUpdate.executeQuery();
        // 返回得到的记过元数据
        ResultSetMetaData resultSetMetaData = isResult.getMetaData();

        // 获取列数
        int ColumnCount = resultSetMetaData.getColumnCount();
        // 获取列名
        String[] ColumnName = new String[ColumnCount];
        for(int i = 0;i < ColumnCount;i++) {
            ColumnName[i] = resultSetMetaData.getColumnName(i+1);
        }

        if(isResult.next()) {
            boolean flag = true;
            while(flag) {
                System.out.println("1-姓名,2-语文,3-数学,4-英语,0-退出");
                System.out.print("请选择想要修改的序号:");
                int choice = scanner.nextInt();
                // 对输入的choice进行判断响应
                // choice为0或者大于4则直接退出,对应取数组中的列的名字
                // choice为1--下标0
                if (choice == 0) {
                    break;
                } else if (choice == 1) {
                    choice -= 1;
                } else if(choice > 4) {
                    break;
                }
                System.out.print("输入修改后信息:");
                String string = scanner.next();
                // 获取列名
                String Data = ColumnName[choice];
                String sqlUpdate = "UPDATE student set "+ Data + " = ? where ID='"+ id +"'";
                PreparedStatement Result = con.prepareStatement(sqlUpdate);
                Result.setString(1,string);
                Result.execute();
                System.out.println("修改成功");
                Result.close();
                /*Result.setString(1, a[0]);
                Result.setInt(2, a[0]);*/
                // 释放资源
                isUpdate.close();
            }
        } else {
            isUpdate.close();
            System.out.println("该学生不存在");
        }
        con.close();
    }
}
