package ch.hearc.ig.odi.moviemanager.service;

import ch.hearc.ig.odi.moviemanager.business.Movie;
import ch.hearc.ig.odi.moviemanager.business.Person;
import ch.hearc.ig.odi.moviemanager.exception.DuplicateElementException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

/**
 * Classe de services qui stocke les données de l'application dans la session de
 * l'utilisateur. Cette classe est gérée par CDI et peut donc être injectée dans
 * les autres classes Java.
 *
 * @author julien.plumez
 */
@SessionScoped
@Stateful
public class Services implements Serializable {

    private Map<Long, Person> people;
    private Map<Long, Movie> movies;

    /**
     * Initialise la classe de services et crée 6 personnes et 9 films pour
     * avoir des données de test.
     */
    public Services() {
        people = new LinkedHashMap<>();
        people.put(1l, new Person(1l, "Lara", "Clette"));
        people.put(2l, new Person(2l, "Homer", "Dalors"));
        people.put(3l, new Person(3l, "Sarah", "Vigote"));
        people.put(4l, new Person(4l, "Pierre", "Oglyphe"));
        people.put(5l, new Person(5l, "John", "Doeuf"));
        people.put(6l, new Person(6l, "Cécile", "Icone"));

        // Liste tirée de http://www.allocine.fr/film/meilleurs/
        movies = new LinkedHashMap<>();
        movies.put(1l, new Movie(1l, "Forrest Gump", "Robert Zemeckis"));
        movies.put(2l, new Movie(2l, "La ligne verte", "Frank Darabont"));
        movies.put(3l, new Movie(3l, "Django Unchained", "Quentin Tarantino"));
        movies.put(4l, new Movie(4l, "Gran Torino", "Clint Eastwood"));
        movies.put(5l, new Movie(5l, "La liste de Schindler", "Steven Spielberg"));
        movies.put(6l, new Movie(6l, "The Dark Knight", "Christopher Nolan"));
        movies.put(7l, new Movie(7l, "Le Parrain", "Francis Ford Coppola"));
        movies.put(8l, new Movie(8l, "Pulp Fiction", "Quentin Tarantino"));
        movies.put(9l, new Movie(9l, "Le seigneur des anneaux, le retour du roi", "Peter Jackson"));

        try {
            people.get(1l).addMovie(movies.get(1l));
            people.get(1l).addMovie(movies.get(3l));
            people.get(1l).addMovie(movies.get(5l));
            people.get(1l).addMovie(movies.get(6l));
            people.get(2l).addMovie(movies.get(7l));
            people.get(2l).addMovie(movies.get(8l));
            people.get(2l).addMovie(movies.get(9l));
            people.get(3l).addMovie(movies.get(2l));
            people.get(3l).addMovie(movies.get(4l));
            people.get(3l).addMovie(movies.get(5l));
            people.get(4l).addMovie(movies.get(6l));
            people.get(4l).addMovie(movies.get(8l));
            people.get(4l).addMovie(movies.get(1l));
            people.get(4l).addMovie(movies.get(2l));
            people.get(4l).addMovie(movies.get(3l));
            people.get(4l).addMovie(movies.get(5l));
            people.get(4l).addMovie(movies.get(7l));
            people.get(5l).addMovie(movies.get(3l));
            people.get(5l).addMovie(movies.get(4l));
            people.get(5l).addMovie(movies.get(6l));
            people.get(6l).addMovie(movies.get(7l));
            people.get(6l).addMovie(movies.get(9l));
            people.get(6l).addMovie(movies.get(1l));
            people.get(6l).addMovie(movies.get(2l));
        } catch (DuplicateElementException ex) {
            // Ne devrait pas arriver
        }
    }

    /**
     * Retourne une List contenant toutes les personnes du système. Utile pour
     * l'affichage des personnes dans les facelets
     *
     * @return Une List contenant toutes les personnes du système.
     */
    public List<Person> getPeopleList() {
        return new ArrayList(people.values());
    }

    /**
     * Retourne une List contenant tous les films du système Utile pour
     * l'affichage des films dans les facelets
     *
     * @return Une List contenant tous les films du système
     */
    public List<Movie> getMoviesList() {
        return new ArrayList(movies.values());
    }
    
    /**
     * sauvegarde une nouvelle personne dans la list de personne
     *
     * @param id l'identifiant de la personne ajoutée
     * @param firstname leprenom de la personne ajoutée
     * @param lastname le nom de la personne ajoutée
     */
    public void savePerson(Long id, String firstname, String lastname) throws DuplicateElementException{
        if(people.containsKey(id)){
            throw new DuplicateElementException();
        }
        people.put(id, new Person(id, firstname,lastname));
    }
    
    /**
     * Cette méthode va permettre de sauvegarder un film dans la liste
     * @param id L'id du film
     * @param name Le nom du film
     * @param producer Le producteur du film
     */
    public void saveMovie(Long id, String name, String producer) throws DuplicateElementException{
        if(movies.containsKey(id)){
            throw new DuplicateElementException();
        }
        movies.put(id, new Movie(id, name, producer));
    }
}
