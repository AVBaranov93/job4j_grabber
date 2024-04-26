package ru.job4j.ood.srp.model;

import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlType(propOrder = {"name", "hired", "fired", "salary"})
public class FormattedEmploeey {
    private String name;
    private String hired;
    private String fired;
    private double salary;

    public FormattedEmploeey(String name, String hired, String fired, double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHired() {
        return hired;
    }

    public void setHired(String hired) {
        this.hired = hired;
    }

    public String getFired() {
        return fired;
    }

    public void setFired(String fired) {
        this.fired = fired;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FormattedEmploeey that = (FormattedEmploeey) o;
        return Double.compare(salary, that.salary) == 0 && Objects.equals(name, that.name)
                && Objects.equals(hired, that.hired) && Objects.equals(fired, that.fired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hired, fired, salary);
    }
}
