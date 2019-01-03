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
                                    <form method="post" id="form_student" action="Dashboard" name="form_student" data-parsley-validate>
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
                                                    <button class="btn btn-success btn-lg" type="submit">
                                                        <i class="fa fa-list"></i> Display
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>

                        <c:if test="${requestScope.answers != null}">
                            <div class="col-12">

                                <div class="card bg-white mt-3">
                                    <div class="card-body ">
                                        <h2 class="display-5">
                                            <i class="fa fa-user"></i> KEMING Loic <span class="float-right font-weight-bold text-info">5/10</span>
                                        </h2>
                                        <hr class="my-4">
                                        <div class="form-group">
                                            <button class="btn btn-light btn-lg" type="button" onclick="messageBox();">
                                                <i class="fa fa-print"></i> Print
                                            </button>
                                        </div>
                                    </div>
                                </div>
                                
                            </div>
                        </c:if>

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

                    if ('${requestScope.error ne null}'.toLowerCase() === 'true') {
                        messageBox({isSuccess: false, message: '${requestScope.error}'});
                    }

                }
            );

        </script>

        <jsp:include page="../_shared/_modals.jsp" /> 

    </body>

</html>
