package model;

public class Employee {
    //такая инициализация полей синтаксически допустима, и она отрабатывает
    //первее чем конструкторы
    //такой инициализацией можно пользоваться как правило при полном
    // отсутствии конструкторов

    //static поле - создается в одном единственном экземпляре и существует вне объектов
    //так как статик поля существуют вне объектов то обращение к ним осуществляется
    //через имя класса (Employee.tax)

    //счетчик для присвоения уникальных id для каждного нового объекта
    private static int idCounter;
    private static double tax = 0.15;
    //public final static double TAX = 0.15; если считается, что налог программно не изменится
    private int id;
    private String name = "none";
    private double salary = 100;

    //static блок кода запускается единожды при прогрузке класса в память
    static {
        //можно использовать для инициализации static полей либо описать код,
        //который должен выполниться единожды при обращении к классу
        System.out.println("!!!");
        idCounter = 0;
    }


    //блок кода. такой блок кода будет запускаться при создании каждого объекта этого класса
    {
        System.out.println("!");
        id = ++idCounter;//сначала увеличивается счетчик а потом присвается значение
    }

    //this() - возможность в нутри одного конструктора, осуществить вызов другого
    public Employee() {
        //вызов конструктора через this() возможно только первой командой этого
        //конструктора
        this("noname", 500);// - вызов конструктора с параметрами
        //name = "noname";
        //salary = 500;
        //this("noname", 500); - ошибка
    }

    public Employee(String name, double salary) {
        this.name = name;
        setSalary(salary);//чтобы не писать аналогичную проверку
        //вызовем сеттер с уже описанной проверкой
        //id = ++idCounter;//сначала увеличивается счетчик а потом присвается значение
        //нежелательно выполнять какие либо действия кроме инициалиции полей и проверок
        //в конструкторе
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        //проверка, если пытаемся установить зп меньше 500
        //то мделать это не сможем
        if (salary >= 500) {
            this.salary = salary;
        } else {
            this.salary = 500;
        }
    }

    //для static полей необходимо создавать static сеттеры и геттеры
    //static методы вызываются не для конуретных объектов, а через имя класса
    //поэтому внутри static методов нелльзя обратить к this
    public static double getTax() {
        //this - ошибка
        return tax;
    }

    public static void setTax(double tax) {
        Employee.tax = tax;
    }

    public double netSalary() {
        double res = 0;
        res = (1 - tax) * salary;
        return res;
    }

    //метод расчета среднего арифметичского чистых зарплат двух работников
    //этот метод описан static т.к он должен работать не для одного конкретного объекта
    public static double avgNetSalary(Employee e1, Employee e2) {
        double res = 0;
        res = (e1.netSalary() + e2.netSalary()) / 2;
        return res;
    }

    public void info() {
        System.out.println("id: " + id +
                ", имя: " + name +
                ", зп: " + salary +
                ", без налогов: " + netSalary());
    }


    {
        //еще один блок кода
    }
}
