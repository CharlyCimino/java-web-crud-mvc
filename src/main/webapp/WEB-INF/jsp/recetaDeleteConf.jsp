<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../assets/css/style.css"/>
        <link rel="icon" type="image/x-icon" href="../assets/img/favicon.ico">
        <title>Borrar receta: ${receta.nombre}</title>
    </head>
    <body>
        <c:import url="includes/navbar.jsp" />
        <h1>Borrar receta: ${receta.nombre}</h1>
        <p><img class="fotoDeRecetaMD" src="../assets/img/recetas/${receta.foto}" alt="Foto de ${receta.nombre}"/></p>
        <form id="formBorrarReceta" action="delete" method="post">
            <input type="hidden" name="id" value="${receta.id}"/>
            <div>                
                <input type="submit" value="Confirmar borrado" />
            </div>
        </form>
        <c:import url="includes/comeBackButton.jsp" />
        <c:import url="includes/footer.jsp" />
    </body>
</html>
