<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../assets/css/style.css"/>
        <link rel="icon" type="image/x-icon" href="../assets/img/favicon.ico">
        <title>Agregar nueva receta</title>
    </head>
    <body>
        <c:import url="includes/navbar.jsp" />
        <h1>Agregar nueva receta</h1>
        <form id="formAgregarReceta" action="create" method="post">
            <div>
                <label for="nombre">Nombre: </label>
                <input type="text" id="nombre" name="nombre" required>
            </div>
            <div>
                <br/>
                <label for="foto">Agregar foto: </label>
                <br/>
                <input type="file" id="foto" name="foto">
            </div>   
            <div>
                <label for="instrucciones">Instrucciones</label>
                <br/>
                <textarea id="instrucciones" name="instrucciones" rows="10" cols="25"></textarea>
            </div>
            <div>                
                <input type="submit" value="Agregar receta" />
                <input type="reset" />
            </div>
            <c:import url="includes/comeBackButton.jsp" />
        </form>
        <c:import url="includes/footer.jsp" />
    </body>
</html>
