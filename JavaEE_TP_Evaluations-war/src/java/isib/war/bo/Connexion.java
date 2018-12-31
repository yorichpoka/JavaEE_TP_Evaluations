/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package isib.war.bo;

import isib.ejb.entity.Student;
import isib.ejb.entity.Teacher;
import isib.ejb.bo.TeacherBO;
import isib.ejb.bo.UserBO;
import isib.ejb.bo.PersonBO;
import isib.ejb.bo.StudentBO;
import java.util.Date;

/**
 *
 * @author POKA
 */
public class Connexion {
    
    private String id_session;
    private PersonBO person;
    private String module_activate;
//    private Object[] comboBoxData;
    private Date connection_date;

    public Connexion() {
        this.connection_date = new Date();
    }

    public Connexion(String id_session) {
        this.id_session = id_session;
        this.connection_date = new Date();
    }

    public String getId_session() {
        return id_session;
    }

    public void setId_session(String id_session) {
        this.id_session = id_session;
    }

    public PersonBO getPerson() {
        return person;
    }

    public String getModule_activate() {
        return module_activate;
    }

    public void setModule_activate(String module_activate) {
        this.module_activate = module_activate;
    }

    public void setPerson(PersonBO person) {
        this.person = person;
    }

    public void setPerson(Teacher person) {
        this.person =
            new TeacherBO(
                    person.getId(),
                    new UserBO(
                        person.getUser().getId(),
                        person.getUser().getLogin(),
                        person.getUser().getPassword(),
                        person.getUser().isEnabled()
                    ),
                    person.getMatricule(),
                    person.getFirstname(),
                    person.getLastname(),
                    person.getAddress(),
                    person.getMobile_phone(),
                    person.getEmail(),
                    person.getBirthday()
            );
    }

    public void setPerson(Student person) {
        this.person =
            new StudentBO(
                    person.getId(),
                    new UserBO(
                        person.getUser().getId(),
                        person.getUser().getLogin(),
                        person.getUser().getPassword(),
                        person.getUser().isEnabled()
                    ),
                    person.getMatricule(),
                    person.getFirstname(),
                    person.getLastname(),
                    person.getAddress(),
                    person.getMobile_phone(),
                    person.getEmail(),
                    person.getBirthday()
            );
    }     

//    public Object[] getComboBoxData() {
//        return comboBoxData;
//    }
//
//    public void setComboBoxData(Object[] comboBoxData) {
//        this.comboBoxData = comboBoxData;
//    }

    public Date getConnection_date() {
        return connection_date;
    }

    public void setConnection_date(Date connection_date) {
        this.connection_date = connection_date;
    }
    
    public boolean isAuthentificated(){
        
        return
            this.person != null && this.person.getId() != 0;
    }
}
