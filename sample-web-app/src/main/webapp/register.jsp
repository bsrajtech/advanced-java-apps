<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!doctype html>
<html lang="en">
   <head>
      <!-- Required meta tags -->
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- Bootstrap CSS -->
      <link
         href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
         rel="stylesheet"
         integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
         crossorigin="anonymous">
      <title>e-commerce</title>
   </head>
   <body>
      <h1 style="text-align: center"> <a href="./">e-commerce web application</a></h1>
      <div class="container">
         <form action="./register" method="post">
            <div class="mb-3">
               <label for="username" class="form-label">Email address or
               username</label> <input type="text" class="form-control" id="username"
                  name="username" aria-describedby="emailHelp"
                  value="${formUsername}">
               <c:if test="${errUsername != null }">
                  <div id="errorU" class="form-text">${errUsername}</div>
               </c:if>
            </div>
            <div class="mb-3">
               <label for="secretkey1" class="form-label">Password</label> <input
                  type="password" class="form-control" id="secretkey1"
                  name="secretkey1">
               <c:if test="${errSecretkey1 != null }">
                  <div id="errorU" class="form-text">${errSecretkey1}</div>
               </c:if>
            </div>
            <div class="mb-3">
               <label for="secretkey2" class="form-label">Password</label> <input
                  type="password" class="form-control" id="secretkey2"
                  name="secretkey2">
               <c:if test="${errSecretkey2 != null }">
                  <div id="errorU" class="form-text">${errSecretkey2}</div>
               </c:if>
            </div>
            <div class="mb-3">
               <label for="exampleInputDOB1" class="form-label">Date of
               Birth</label> <input type="date" class="form-control" id="dob" name="dob">
               <c:if test="${errdob != null }">
                  <div id="errorU" class="form-text">${errdob}</div>
               </c:if>
            </div>
            <div class="mb-3">
               <label for="gender" class="form-label">Gender</label> 
               <select class="form-select" aria-label="Default select example"
                  id="gender" name="gender">
                  <option value="none">Please select gender</option>
                  <option value="male">male</option>
                  <option value="female">female</option>
                  <option value="other">other</option>
               </select>
               <c:if test="${errGender != null }">
                  <div id="errorU" class="form-text">${errGender}</div>
               </c:if>
            </div>
            <div class="mb-3">
               <label for="course" class="form-label">course</label> 
               <input class="form-control" list="courselist" name="course" placeholder="Type to search...">
               <datalist id="courselist">
                  <option value="Java FullStack">
                  <option value="Python FullStack">
                  <option value="UI FullStack">
                  <option value="Database">
                  <option value="DevOps">
               </datalist>
               <c:if test="${errCourse != null }">
               <div id="errorU" class="form-text"> ${errCourse} </div>
               </c:if>
            </div>
            <button class="form-control btn btn-primary" type="submit">Register</button>
         </form>
         <c:if test="${errRegister != null }">
         <div id="errorU" class="form-text"> ${errRegister} </div>
         </c:if>
         <p>
         Have account already? <a href="./login"> Click here to login</a>
         </p>
         
      </div>
   </body>
</html>