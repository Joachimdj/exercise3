/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;

/**
 *
 * @author Joachim
 */
@Entity
public class Student extends Person implements Serializable {
    
    private int matNr;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date matDate;

    public Student(String firstName, String lastName, Date birthDate, int age, boolean isMarried, int matNr, Date matDate) {
        super(firstName, lastName, birthDate, age, isMarried);
        this.matNr = matNr;
        this.matDate = matDate;
    }

    public Student() {
    }

    public int getMatNr() {
        return matNr;
    }

    public void setMatNr(int matNr) {
        this.matNr = matNr;
    }

    public Date getMatDate() {
        return matDate;
    }

    public void setMatDate(Date matDate) {
        this.matDate = matDate;
    }
    
}
