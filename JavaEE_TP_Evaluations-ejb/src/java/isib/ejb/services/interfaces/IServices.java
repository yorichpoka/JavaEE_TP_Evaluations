/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package isib.ejb.services.interfaces;

import isib.ejb.dao.IDAO;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MultivaluedMap;

/**
 *
 * @author POKA
 */
public interface IServices<T> {
    
    IDAO<T> dao();
    T create(T obj);
    T createWithRelation(T obj);
    T update(T obj);
    boolean delete(int id);
    T read(int id);
    List<T> readAll();
    
}
