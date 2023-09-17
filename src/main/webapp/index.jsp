<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="assets/css/style.css"/>
        <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico">
        <title>Recetorium - Home Page</title>
    </head>
    <body>
        <c:import url="WEB-INF/jsp/includes/navbar.jsp" />
        <h1>¡Te damos la bienvenida a nuestro sitio!</h1>
        <h2>¿Que deseás hacer?</h2>
        <p><a href="recetas/create">Contribuir con una receta</a></p>
        <p><a href="recetas">Explorar recetas existentes</a></p>
        <c:import url="WEB-INF/jsp/includes/footer.jsp" />
    </body>
</html>
