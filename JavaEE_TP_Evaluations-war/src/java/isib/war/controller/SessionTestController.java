package isib.war.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import isib.ejb.entity.Answer;
import isib.ejb.entity.Evaluation;
import isib.ejb.entity.Question;
import isib.war.bo.Notification;
import isib.war.tools.Tools;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

public class SessionTestController extends BaseController {

    private static final Logger log4j = Logger.getLogger(SessionTestController.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // -- Check if user is connected -- //
        Tools.checkIsConnected(request, response);
        
        String status = request.getParameter("status");

        if (status == null) {
            this.con = Tools.getConnexionSession(request);
            this.con.setModule_activate("SessionTest");

            request.setAttribute("comboBoxData", loadComboBoxData());

            Tools.redirectToPage(request, response, "views/sessionTest/index.jsp");
        } 
        else 
        {
            Tools.redirectToPage(request, response, "views/sessionTest/testProcessFinished.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        try {
            if (action == null) {
                int id_evaluation = Integer.parseInt(request.getParameter("id_evaluation"));

                Evaluation evaluation = (Evaluation)evaluationEJB.read(id_evaluation);

                if (evaluation == null) {
                    throw new Exception("Evaluation not found!");
                }
                
                evaluation.getQuestions().removeIf(question -> question.getAnswers().isEmpty());
                
                if (evaluation.getQuestions().isEmpty()) {
                    throw new Exception("Questions not found!");
                }
                
                request.setAttribute("evaluation", evaluation);
                request.setAttribute("comboBoxData", loadComboBoxData());
                
                Tools.redirectToPage(request, response, "views/sessionTest/testProcess.jsp");
            }
        } catch (Exception ex) {
            log4j.error(ex);
            request.setAttribute("error", ex.getMessage());
            Tools.redirectToPage(request, response, "views/sessionTest/index.jsp");
        }

        if ("getAnswers".equals(action)) {
            getAnswers(request, response);
        }
    }
    
    private void getAnswers(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
        Object obj;
        
        try {
            String answers = request.getParameter("answers");
            int id_evaluation = Integer.parseInt(request.getParameter("id_evaluation"));
//            List<Question_AnswerBO> question_answers =    new Gson().fromJson(answers, 
//                                                            new TypeToken<ArrayList<Question_AnswerBO>>(){}.getType()
//                                                        );
            
            
            this.notification = new Notification("SessionTest?status=finished");
        } 
        catch(Exception ex) {
            log4j.error(ex);
            this.notification = new Notification(false);
        }
        finally{
            sendNotificationToResponse(response);
        }
        
    }

    private Object[] loadComboBoxData() {

        Object[] comboBoxData = new Object[1];

        comboBoxData[0] = evaluationEJB.readAll();

        return comboBoxData;

    }

}
