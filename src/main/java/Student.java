public class Student {
    private String name;
    private String id;
    private int chinese;
    private int math;
    private int english;

    public Student(String Sname,String SID,int Schinese,int Smath,int Senglish) {
       this.name = Sname;
       this.id = SID;
       this.chinese = Schinese;
       this.math = Smath;
       this.english = Senglish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    @Override
    public String toString() {
        return "姓名:" + name +
                ", 学号:" + id  +
                ", 语文成绩:" + chinese +
                ", 数学成绩:" + math +
                ", 英语成绩:" + english ;
    }
}
