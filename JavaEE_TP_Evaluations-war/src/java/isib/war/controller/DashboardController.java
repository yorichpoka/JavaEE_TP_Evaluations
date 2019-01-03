package isib.war.controller;

import isib.ejb.entity.Student;
import isib.war.tools.Tools;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;


public class DashboardController extends BaseController {

    private static final Logger log4j = Logger.getLogger(DashboardController.class);
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // -- Check if user is connected -- //
        Tools.checkIsConnected(request, response);
        
        this.con = Tools.getConnexionSession(request);
        this.con.setModule_activate("Dashboard");
        
        request.setAttribute("comboBoxData", loadComboBoxData(
                                                this.con.getPerson().isIsStudent()  ? this.con.getPerson().getId() 
                                                                                    : 0));
                
        Tools.redirectToPage(request, response, "views/dashboard/index.jsp");
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        this.con = Tools.getConnexionSession(request);
        
        request.setAttribute("error", "Not implemented");
        
        request.setAttribute("comboBoxData", loadComboBoxData(
                                                this.con.getPerson().isIsStudent()  ? this.con.getPerson().getId() 
                                                                                    : 0));
                
        Tools.redirectToPage(request, response, "views/dashboard/index.jsp");
        
//        if ("getDataById".equals(action)) {
//            getDataById(request, response);
//        } else if ("create".equals(action)) {
//            create(request, response);
//        } else if ("update".equals(action)) {
//            update(request, response);
//        } else if ("delete".equals(action)) {
//            delete(request, response);
//        }
        
    }
    
    private Object[] loadComboBoxData(int id_student){
    
        Object[] comboBoxData = new Object[1];
        
        comboBoxData[0] = id_student == 0 ? studentEJB.readAll()
                                          : new Object[] { studentEJB.read(id_student) };
        
        return comboBoxData;
        
    }
    
}
