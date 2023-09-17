
package ar.charlycimino.muestra.java.web.mvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 *
 * @author Charly Cimino
 * Aprendé más Java en mi canal: https://www.youtube.com/c/CharlyCimino
 * Encontrá más código en mi repo de GitHub: https://github.com/CharlyCimino
 */
public class ErrorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Throwable th = (Throwable) req.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        req.setAttribute("mensajeError", th.getMessage());
        req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
    }
    
}
