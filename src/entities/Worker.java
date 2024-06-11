package entities;

import enums.WorkerLevel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private double baseSalary;

    private Department department;
    private List<HourContract> contracts = new ArrayList<>();


    public Worker(Department department, String workerName, String s, double workerBaseSalary) {
    }

    public Worker(String name, WorkerLevel level, double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    //O metodo Contracts nao tem set, pois já existem dois metodos que removem e adiocionam contratos.
    public List<HourContract> getContracts() {
        return contracts;
    }

    //Usada para associar um contrato a um trabalhador.
    public void addContract(HourContract contract){
        contracts.add(contract);
    }

    //Usado para realizar a remoçao de contrato associada a um trabalhador.
    public void removeContract(HourContract contract){
        contracts.remove(contract);
    }

    public double income(int year, int month){
         double sum = baseSalary;
        Calendar cal = Calendar.getInstance();
         for (HourContract c : contracts){
             cal.setTime(c.getDate());
             int c_year = cal.get(Calendar.YEAR);
             int c_month = 1 + cal.get(Calendar.MONTH);
            if (year == c_year && month == c_month) {
                sum += c.totalValue();
            }
         }
        return sum;
    }
}
