
package ar.charlycimino.muestra.java.web.mvc.model;

/**
 *
 * @author Charly Cimino
 * Aprendé más Java en mi canal: https://www.youtube.com/c/CharlyCimino
 * Encontrá más código en mi repo de GitHub: https://github.com/CharlyCimino
 */
public class UtilExceptions {
    public static void checkNumeroNegativo(double valor, String mensajeDeError) {
        if (valor < 0) {
            throw new RuntimeException(mensajeDeError);
        }
    }
    
    public static void checkObjetoNulo(Object obj, String mensajeDeError) {
        if (obj == null) {
            throw new RuntimeException(mensajeDeError);
        }
    }
}
