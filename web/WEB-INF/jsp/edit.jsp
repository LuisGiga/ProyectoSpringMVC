<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" />
    </head>
    <body>
       
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="/home.htm"/>">Listado de Personas /</a></li>
                <li class="active">Editar</li>
            </ol>
                <div class="panel panel-primary">
                    <div class="panel-heading">Formulario</div>
                    <div class="panel-body">
                        
                        <form:form method="post" commandName="usuarios">
                            <h1>Complete el fomulario</h1>
                            
                            <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                            
                            <p>
                            <form:label path="nombre">Nombre</form:label>
                            <form:input path="nombre" cssClass="form-control" />
                            </p>
                            
                            <p>
                            <form:label path="correo">Correo electronico</form:label>
                            <form:input path="correo" cssClass="form-control" />
                            </p>
                            
                            <p>
                            <form:label path="telefono">Telefono</form:label>
                            <form:input path="telefono" cssClass="form-control" />
                            </p>
                            <hr/>
                            <input type="submit" value="Enviar" class="btn btn-danger" />
                            
                        </form:form>
                        
                    </div>
                    
                </div>
        </div>
    </body>
</html>
