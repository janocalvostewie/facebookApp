/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookapp;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Media;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jano
 */
public class Faceb {
    /**
     * Instanciamos un objeto Facebook para poder llamar a los métodos de la librería
     */
    static Facebook facebook22 = new FacebookFactory().getInstance();

    /**
     * Publica un mensaje en el muro
     * @param mensaje String de lo que queremos publicar en le muro
     * @throws FacebookException 
     */
    public static void mensaje(String mensaje) throws FacebookException{
    
            facebook22.postStatusMessage(mensaje);
   
    }
    
    /**
     * Da un LIKE a un post
     * @param idPost parámetro que necesita para saber a qué post(publicación) dar el like
     * @throws FacebookException 
     */
    public static void darLike(String idPost) throws FacebookException{
    
    facebook22.likePost(idPost);
    }
    
    /**
     * Publica una foto
     * @param mensaje comentario que queramos ponerle a la foto
     * @param fotillo archivo de la foto que queremos subir
     * @throws FacebookException 
     */
    public static void subirFoto(String mensaje, File fotillo) throws FacebookException{
        Media fotoMedia=Media.class.cast(fotillo);
    facebook22.postPhoto(mensaje,fotoMedia);
    
    
    }
    
    /**
     * Comenta una publicación existente
     * @param idPost Id identificativo de la publicación
     * @param mensaje Mensaje que queremos publicar
     * @throws FacebookException 
     */
    public static void comentarPublicacion(String idPost, String mensaje) throws FacebookException{
    
        facebook22.commentPost(idPost, mensaje);
        
    }
    /**
     * No he conseguido que esto funcion ya que me salta el error #11 que la búsqueda está obsoleta en esta versión de Facebook4J
     * @param parametro
     * @throws FacebookException 
     */
    public static void buscaPubli(String parametro) throws FacebookException{
      
       
        ResponseList<Post> resultados = facebook22.searchPosts(parametro, new Reading().limit(100));

        for (Post result : resultados) {
            System.out.println(result);
        }
      
    }
}
