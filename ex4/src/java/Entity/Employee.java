/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author Joachim
 */
@Entity
public class Employee extends Person implements Serializable {
    
    private int soSecNr;
    private float wage;
    private String taxClass;

    public Employee(String firstName, String lastName, Date birthDate, int age, boolean isMarried, int soSecNr, float wage, String taxClass) {
        super(firstName, lastName, birthDate, age, isMarried);
        this.soSecNr = soSecNr;
        this.wage = wage;
        this.taxClass = taxClass;
    }

    public Employee() {
    }

    public int getSoSecNr() {
        return soSecNr;
    }

    public void setSoSecNr(int soSecNr) {
        this.soSecNr = soSecNr;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
    }

    public String getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(String taxClass) {
        this.taxClass = taxClass;
    }
    
}
