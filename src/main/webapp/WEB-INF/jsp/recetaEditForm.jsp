<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../assets/css/style.css"/>
        <link rel="icon" type="image/x-icon" href="../assets/img/favicon.ico">
        <title>Editar receta: ${receta.nombre}</title>
    </head>
    <body>
        <c:import url="includes/navbar.jsp" />
        <h1>Editar receta: ${receta.nombre}</h1>
        <form id="formEditarReceta" action="update" method="post">

            <div>
                <label for="nombre">Nombre: </label>
                <input type="text" id="nombre" name="nombre" value="${receta.nombre}" required>
            </div>
            <div>
                <img class="fotoDeRecetaMD" src="../assets/img/recetas/${receta.foto}" alt="Foto de ${receta.nombre}"/>
                <br/>
                <label for="foto">
                    <c:choose>
                        <c:when test="${receta.tieneFoto()}">Modificar</c:when>
                        <c:otherwise>Agregar</c:otherwise>
                    </c:choose>
                    foto: 
                </label>
                <br/>
                <input type="file" id="foto" name="foto">
            </div>   
            <div>
                <label for="instrucciones">Instrucciones</label>
                <br/>
                <textarea id="instrucciones" name="instrucciones" rows="5" cols="50">${receta.instrucciones}</textarea>
            </div>
            <input type="hidden" name="id" value="${receta.id}" aria-label="Archivo"/>
            <div>                
                <input type="submit" value="Confirmar cambios" />
                <input type="reset" />
            </div>
        </form>
        <c:import url="includes/comeBackButton.jsp" />    
        <c:import url="includes/footer.jsp" />
    </body>
</html>
