/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package isib.ejb.services;

import isib.ejb.services.interfaces.IServices;
import isib.ejb.dao.Student_AnswerDAO;
import isib.ejb.dao.IDAO;
import isib.ejb.entity.Student_Answer;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author POKA
 */
@Stateless(name = "Student_AnswerEJB")
public class Students_AnswersServices implements IServices<Student_Answer> {

    @Override
    public IDAO<Student_Answer> dao() {
        return new Student_AnswerDAO();
    }
    
    @Override
    public Student_Answer create(Student_Answer obj) {
        return dao().create(obj);
    }

    @Override
    public Student_Answer createWithRelation(Student_Answer obj) {
        return dao().createWithRelation(obj);
    }

    @Override
    public Student_Answer update(Student_Answer obj) {
        return dao().update(obj);
    }

    @Override
    public boolean delete(int id) {
        return dao().delete(id);
    }

    @Override
    public Student_Answer read(int id) {
        return dao().get(id);
    }

    @Override
    public List<Student_Answer> readAll() {
        return dao().getAll();
    }
}
