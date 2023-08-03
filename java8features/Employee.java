package java8features;

public class Employee {

    public Integer eid;
    public String ename;
    public Double esal;

    public Employee(int eid, String name, Double esal) {
        this.eid = eid;
        this.ename = name;
        this.esal = esal;
    }

    @Override
    public String toString() {
        return "Emp [edi=" + eid + ",ename=" + ename + ",esal=" + esal + "]";
    }

    public boolean salarayCheck() {
        return this.esal > 10000d;
    }

    public boolean nameCheck() {
        return this.ename.startsWith("r");
    }
}
