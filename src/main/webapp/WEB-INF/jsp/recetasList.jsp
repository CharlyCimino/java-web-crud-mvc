<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="assets/css/style.css"/>
        <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico">
        <title>Lista de recetas</title>
    </head>
    <body>
        <c:import url="includes/navbar.jsp" />
        <h1>Lista de recetas</h1>
        <p><a href="recetas/create" class="addRecetaLink">Nueva receta</a></p>
        <table>
            <tr>
                <th>Nombre</th>
                <th>Foto</th>
                <th>Instrucciones</th>
                <th colspan="3">Acciones</th>
            </tr>
            <c:forEach items="${listaDeRecetas}" var="receta">
                <tr>
                    <td>${receta.nombre}</td>
                    <td><img class="fotoDeRecetaSM" src="assets/img/recetas/${receta.foto}" alt="Foto de ${receta.nombre}"/></td>
                    <td>
                        ${fn:substring(receta.instrucciones, 0, 30)}...                    
                    </td>
                    <td><a href="recetas/read?id=${receta.id}">Ver</a></td>
                    <td><a href="recetas/update?id=${receta.id}">Editar</a></td>
                    <td><a href="recetas/delete?id=${receta.id}">Borrar</a></td>
                </tr>
            </c:forEach>
        </table>
        <c:import url="includes/comeBackButton.jsp" />
        <c:import url="includes/footer.jsp" />
    </body>
</html>
