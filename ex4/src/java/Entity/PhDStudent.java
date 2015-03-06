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
public class PhDStudent extends Employee implements Serializable {
    
    private String dissSubject;

    public PhDStudent(String firstName, String lastName, Date birthDate, int age, boolean isMarried, int soSecNr, float wage, String taxClass, String dissSubject) {
        super(firstName, lastName, birthDate, age, isMarried, soSecNr, wage, taxClass);
        this.dissSubject = dissSubject;
    }

    public PhDStudent() {
    }

    public String getDissSubject() {
        return dissSubject;
    }

    public void setDissSubject(String dissSubject) {
        this.dissSubject = dissSubject;
    }
    
}
