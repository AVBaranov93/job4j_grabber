package ru.job4j.ood.srp.model;

import javax.xml.bind.annotation.*;
import java.util.List;
@XmlRootElement
public class Employees {
    @XmlElement(name = "employee")
    private List<FormattedEmploeey> employees;

    public Employees() {
    }

    public Employees(List<FormattedEmploeey> employees) {
        this.employees = employees;
    }
}
