package ar.charlycimino.muestra.java.web.mvc.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class RecetaDAOHardCodeado implements DAO<Receta, Integer> {

    // Modelo con recetas hardcodeadas para usar de test
    private static int contador = 1; // Simula un id autoincremental de base de datos
    private List<Receta> recetas;

    public RecetaDAOHardCodeado() {
        this.recetas = new ArrayList<>();
        cargarRecetasFake();
    }

    @Override
    public void add(Receta receta) {
        UtilExceptions.checkObjetoNulo(receta, "La receta no pueder nula");
        receta.setId(contador);
        recetas.add(receta);
        contador++;
    }

    @Override
    public void update(Receta receta) {
        UtilExceptions.checkObjetoNulo(receta, "La receta no pueder nula");
        int idx = recetas.indexOf(receta);
        if (idx > 0) {
            recetas.set(idx, receta);
        }
    }

    @Override
    public void delete(Integer recetaId) {
        this.recetas.remove(getById(recetaId));
    }

    @Override
    public List<Receta> getAll() {
        return new ArrayList<>(this.recetas);
    }

    @Override
    public Receta getById(Integer recetaId) {
        UtilExceptions.checkNumeroNegativo(recetaId, "El ID no puede ser negativo");
        Receta receta = null;
        Iterator<Receta> it = this.recetas.iterator();
        while (it.hasNext() && receta == null) {
            Receta aux = it.next();
            if (aux.getId() == recetaId) {
                receta = aux;
            }
        }
        UtilExceptions.checkObjetoNulo(receta, "No existe receta con id " + recetaId);
        return receta;
    }

    private void cargarRecetasFake() {
        add(new Receta(contador, "Tarta de manzana", "receta_1.jpg", "Pelar y cortar las manzanas en trozos. Mezclar con canela y azúcar. Cubrir con masa y hornear durante 45 minutos."));
        add(new Receta(contador, "Sopa de pollo", "receta_2.jpg", "Hervir el pollo en caldo con verduras. Agregar fideos y cocinar durante 15 minutos. Servir caliente."));
        add(new Receta(contador, "Ensalada César", "receta_3.jpg", "Mezclar lechuga romana, crotones de pan, queso parmesano y aderezo César. Servir como acompañamiento."));
    }
}
