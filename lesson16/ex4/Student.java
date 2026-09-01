public class Student {
    private String ra;
    private String name;
    private String surname;
    private double p1;
    private double p2;
    private double p3;
    private double p4;

    public Student(String ra, String name, String surname, double p1, double p2, double p3, double p4) {
        this.ra = ra;
        this.name = name;
        this.surname = surname;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    public String getRa() {
        return ra;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getP1() {
        return p1;
    }

    public double getP2() {
        return p2;
    }

    public double getP3() {
        return p3;
    }

    public double getP4() {
        return p4;
    }

    public double getAverage() {
        return (p1 + p2 + p3 + p4) / 4;
    }
}
