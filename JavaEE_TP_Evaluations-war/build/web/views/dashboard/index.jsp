<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <head>        

        <jsp:include page="_partial/_style.html" /> 

        <!-- Title of the page -->
        <title>Dashboard history</title>

    </head>

    <body class="app-body">

        <jsp:include page="../_shared/_top.jsp" /> 

        <div class="container body-content">

            <div class="pt-3"></div>

            <div class="card">

                <jsp:include page="../_shared/_modules.jsp" /> 

                <div class="card-body">

                    <div class="row">

                        <div class="col-12">

                            <div class="card bg-light">
                                <div class="card-body ">
                                    <h1 class="display-4">
                                        Student <i class="fa fa-file-text-o fa-2x float-right"></i>
                                    </h1>
                                    <p class="lead">
                                        Select a student and display his transcript.
                                    </p>
                                    <hr class="my-4">
                                    <form method="post" id="form_student" name="form_student" data-parsley-validate>
                                        <div class="row">
                                            <div class="col-12 col-md-4">
                                                <div class="form-group">
                                                    <select class="form-control form-control-lg" id="form_id_student" name="id_student" required>
                                                        <option value="">Select</option>
                                                        <c:forEach items="${requestScope.comboBoxData[0]}" var="val" varStatus="listStudent">
                                                            <option value="${val.id}">${val.firstname} ${val.lastname}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <button class="btn btn-success btn-lg" type="button" onclick="messageBox();">
                                                        <i class="fa fa-list"></i> Display
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>

                    </div>

                </div>

            </div>

            <jsp:include page="../_shared/_bottom.jsp" /> 

        </div>

        <jsp:include page="_partial/_script.html" /> 

        <script type="text/javascript">

            // -- Lorsque le document est chargé -- //
            $(
                    function () {



                    }
            );

        </script>

        <jsp:include page="../_shared/_modals.jsp" /> 

    </body>

</html>
