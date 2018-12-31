/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package isib.ejb.bo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author POKA
 */
public class StudentBO extends PersonBO implements Serializable {

    public StudentBO() {
        this.isStudent = true;
    }

    public StudentBO(int id) {
        this.id = id;
        this.isStudent = true;
    }
    
    public StudentBO(int id, UserBO user, String matricule, String firstname, String lastname, String address, String mobile_phone, String email, Date birthday) {
        this.id = id;
        this.matricule = matricule;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.mobile_phone = mobile_phone;
        this.email = email;
        this.birthday = birthday;
        this.user = user;
        this.isStudent = true;
    }

    public StudentBO(UserBO user, String matricule, String firstname, String lastname, String address, String mobile_phone, String email, Date birthday) {
        this.matricule = matricule;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.mobile_phone = mobile_phone;
        this.email = email;
        this.birthday = birthday;
        this.user = user;
        this.isStudent = true;
    }
    
}
