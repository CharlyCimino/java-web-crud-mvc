package ar.charlycimino.muestra.java.web.mvc;

import ar.charlycimino.muestra.java.web.mvc.model.DAO;
import ar.charlycimino.muestra.java.web.mvc.model.Receta;
import ar.charlycimino.muestra.java.web.mvc.model.RecetaDAOHardCodeado;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class RecetaServlet extends HttpServlet {
    
    private DAO<Receta, Integer> recetaDAO;

    @Override
    public void init() throws ServletException {
         recetaDAO = new RecetaDAOHardCodeado();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String destino;
            String pathInfo = req.getPathInfo(); // Obtiene la parte de la URL después de "/recetas"
            pathInfo = pathInfo == null ? "" : pathInfo;
            
            String idStr = req.getParameter("id");
            if (idStr != null) {
                req.setAttribute("receta", recetaDAO.getById(Integer.parseInt(idStr)));
            }
            
            switch (pathInfo) {
                case "/create": // Form de alta
                    destino = "/WEB-INF/jsp/recetaAddForm.jsp";
                    break;
                case "/read": // Ver detalle de receta
                    destino = "/WEB-INF/jsp/recetaDetail.jsp";
                    break;
                case "/update": // Form de edición
                    destino = "/WEB-INF/jsp/recetaEditForm.jsp";
                    break;
                case "/delete": // ¿Seguro?
                    destino = "/WEB-INF/jsp/recetaDeleteConf.jsp";
                    break;
                default: // Lista de recetas
                    req.setAttribute("listaDeRecetas", recetaDAO.getAll());
                    destino = "/WEB-INF/jsp/recetasList.jsp";
            }
            
            req.getRequestDispatcher(destino).forward(req, resp);
        } catch (Exception ex) {
            resp.sendError(500, ex.getMessage());
        }

    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Receta receta;
            int id;
            String pathInfo = req.getPathInfo(); // Obtiene la parte de la URL después de "/recetas"
            pathInfo = pathInfo == null ? "" : pathInfo;
            switch (pathInfo) {
                case "/create":
                    receta = new Receta();
                    cargarRecetaSegunParams(receta, req);
                    recetaDAO.add(receta);
                    break;
                case "/update":
                    id = Integer.parseInt(req.getParameter("id"));
                    receta = recetaDAO.getById(id);
                    cargarRecetaSegunParams(receta, req);
                    recetaDAO.update(receta);
                    break;
                case "/delete":
                    id = Integer.parseInt(req.getParameter("id"));
                    recetaDAO.delete(id);
                    break;
            }
            resp.sendRedirect(getServletContext().getContextPath() + "/recetas");
        } catch (Exception ex) {
            resp.sendError(500, ex.getMessage());
        }
    }

    private void cargarRecetaSegunParams(Receta receta, HttpServletRequest req) {
        receta.setNombre(req.getParameter("nombre"));
        receta.setFoto(""); // Sin efecto...
        receta.setInstrucciones(req.getParameter("instrucciones"));
    }

}
