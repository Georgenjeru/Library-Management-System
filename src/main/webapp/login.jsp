<%@ page isELIgnored="false" %>
<jsp:include page = "header.jsp"/>


    <body>

           <jsp:include page = "header.jsp"/>
           <div class="container-fluid position-relative d-flex p-0">
           <div class="container-fluid">
                       <div class="row h-100 align-items-center justify-content-center" style="min-height: 100vh;">
                           <div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
                               <div class="bg-secondary rounded p-4 p-sm-5 my-4 mx-3">
                                   <div class="d-flex align-items-center justify-content-between mb-3">
                                       <a href="index.html" class="">
                                           <h3 class="text-primary"><i class="fa fa-user-edit me-2"></i>Library</h3>
                                       </a>
                                          <h2>${applicationScope.applicationLabel}</h2>
                                   </div>
                                   <form action= "./login" method= "post">
                                      <div class="form-floating mb-3">
                                             <input type="text" class="form-control" id="floatingInput" name="username" placeholder="Username/Email">
                                             <label for="floatingInput">Email address/Username</label>
                                      </div>
                                      <div class="form-floating mb-3">
                                                         <input type="text" class="form-control" id="floatingInput" name="password" placeholder="Password">
                                                         <label for="floatingInput">Password</label>
                                      </div>
                                     <button type="submit" class="btn btn-primary py-3 w-100 mb-4">Sign In</button>
                                     <p class="text-center mb-0">Dont have an Account? <a href="./register.jsp">Sign Up</a></p>

                                   </form>
                               </div>
                           </div>
                       </div>
           </div>
        <%
               String loginError = (String) application.getAttribute("loginError");
               if (loginError != null && !loginError.equals("")) {
        %>
              <span style="color:red">${applicationScope.loginError}</span><br/>


        <% } %>

    </body>
</html>