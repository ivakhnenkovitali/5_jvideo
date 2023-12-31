package model;

public class Student {
    private String name;
    private double grants;

    public Student() {
    }

    public Student(String name, double grants) {
        this.name = name;
        this.grants = grants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrants() {
        return grants;
    }

    public void setGrants(double grants) {
        this.grants = grants;
    }

    public void greeting() {
        System.out.println(name + ": привет всем!");
    }

    //перегрузка методов - созданием в одном классе нескольких методов
    //с одинаковым именем, но различным (уникальным) списком параметров
    //у перегруженных методов могут быть разные возвращаемые типы данных
    //но разные возвращаемые типы не гарантируют перегрузки
    //у перегруженных методов могут быть различные модифакаторы доступа

    public String greeting(Student student) {
        System.out.println(name + ": привет, " + student.name);
        return student.name;
    }

//    public void greeting(Student student) { ошибка
//        System.out.println(name + ": привет, " + student.name);
//    }

    public static double avgGrants(Student s1, Student s2) {
        double res = (s1.grants + s2.grants) / 2;
        return res;
    }

    //возможна перегрузка static методов
    public static double avgGrants(Student s1, Student s2, Student s3) {
        double res = (s1.grants + s2.grants + s3.grants) / 3;
        return res;
    }

    public static double avgGrants(Student[] students) {
        double res = 0;
        for (Student student : students) {
            res += student.grants;
        }
        res /= students.length;//res = res/students.length
        return res;
    }


    //метод с переменным кол-вом параметров
//    public static double avgGrants(Student ... students){
//        double res = 0;
//        for (Student student : students) {
//            res += student.grants;
//        }
//        res /= students.length;//res = res/students.length
//        return res;
//    }
//
//    public static double avgGrants(int x, Student ... students){
//        double res = 0;
//        for (Student student : students) {
//            res += student.grants;
//        }
//        res /= students.length;//res = res/students.length
//        return res;
//    }

}
