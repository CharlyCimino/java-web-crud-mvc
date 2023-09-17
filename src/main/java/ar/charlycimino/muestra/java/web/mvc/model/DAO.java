
package ar.charlycimino.muestra.java.web.mvc.model;

import java.util.List;

/**
 *
 * @author Charly Cimino
 * Aprendé más Java en mi canal: https://www.youtube.com/c/CharlyCimino
 * Encontrá más código en mi repo de GitHub: https://github.com/CharlyCimino
 * @param <T> Tipo de dato de la entidad a persistir
 * @param <K> Tipo de dato del ID de la entidad
 */
public interface DAO<T, K> {
    void add(T entidad) throws Exception;
    void update(T entidad) throws Exception;
    void delete(K id) throws Exception;
    List<T> getAll() throws Exception;
    T getById(K id) throws Exception;
}
