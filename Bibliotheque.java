import java.util.ArrayList;

// Classe Bibliotheque pour gérer les opérations sur les livres et les utilisateurs
class Bibliotheque {
    private ArrayList<Livre> livres;
    private ArrayList<Utilisateur> utilisateurs;
    private ArrayList<Emprunt> emprunts;

    // Constructeur
    public Bibliotheque() {
        this.livres = new ArrayList<>();
        this.utilisateurs = new ArrayList<>();
        this.emprunts = new ArrayList<>();
    }

    // Méthodes pour la gestion des livres
    public void ajouterLivre(Livre livre) {
        livres.add(livre);
    }

    public void modifierLivre(Livre livre) {
        // Implémenter la logique pour modifier un livre
        for (Livre l : livres) {
            if (l.getISBN().equals(livre.getISBN())) {
                l.setTitre(livre.getTitre());
                l.setAuteur(livre.getAuteur());
                l.setAnneePublication(livre.getAnneePublication());
                return;
            }
        }
    }

    public void supprimerLivre(Livre livre) {
        livres.remove(livre);
    }

    public Livre rechercherLivre(String critere) {
        for (Livre livre : livres) {
            if (livre.getTitre().equalsIgnoreCase(critere) || livre.getAuteur().equalsIgnoreCase(critere)
                    || livre.getISBN().equalsIgnoreCase(critere)) {
                return livre;
            }
        }
        return null; // Retourne null si aucun livre correspondant n'est trouvé
    }

    // Méthodes pour la gestion des emprunts
    public void enregistrerEmprunt(Emprunt emprunt) {
        emprunts.add(emprunt);
    }

    public void enregistrerRetour(Emprunt emprunt) {
        emprunts.remove(emprunt);
    }

    public ArrayList<Livre> livresEmpruntesParUtilisateur(Utilisateur utilisateur) {
        ArrayList<Livre> livresEmpruntes = new ArrayList<>();
        for (Emprunt emprunt : emprunts) {
            if (emprunt.getEmprunteur().equals(utilisateur)) {
                livresEmpruntes.add(emprunt.getLivreEmprunte());
            }
        }
        return livresEmpruntes;
    }

    // Méthodes pour la gestion des utilisateurs
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        utilisateurs.add(utilisateur);
    }

    public Utilisateur rechercherUtilisateur(int numeroIdentification) {
        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getNumeroIdentification() == numeroIdentification) {
                return utilisateur;
            }
        }
        return null; // Retourne null si aucun utilisateur correspondant n'est trouvé
    }
}

// Classe Emprunt pour représenter un emprunt de livre
class Emprunt {
    private Livre livreEmprunte;
    private Utilisateur emprunteur;

    // Constructeur
    public Emprunt(Livre livreEmprunte, Utilisateur emprunteur) {
        this.livreEmprunte = livreEmprunte;
        this.emprunteur = emprunteur;
    }

    // Getters et setters
    public Livre getLivreEmprunte() {
        return livreEmprunte;
    }

    public void setLivreEmprunte(Livre livreEmprunte) {
        this.livreEmprunte = livreEmprunte;
    }

    public Utilisateur getEmprunteur() {
        return emprunteur;
    }

    public void setEmprunteur(Utilisateur emprunteur) {
        this.emprunteur = emprunteur;
    }
}

////suppression d'un livre


////suppression d'un livre
// Classe Livre pour représenter un livre
class Livre {
    private String titre;
    private String auteur;
    private int anneePublication;
    private String ISBN;

    // Constructeur
    public Livre(String titre, String auteur, int anneePublication, String ISBN) {
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.ISBN = ISBN;
    }

    // Getters et setters
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getAnneePublication() {
        return anneePublication;
    }

    public void setAnneePublication(int anneePublication) {
        this.anneePublication = anneePublication;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Titre: " + titre + "\n" +
               "Auteur: " + auteur + "\n" +
               "Année de publication: " + anneePublication + "\n" +
               "ISBN: " + ISBN;
    }
}

// Classe Utilisateur pour représenter un utilisateur de la bibliothèque
class Utilisateur {
    private String nom;
    private int numeroIdentification;

    // Constructeur
    public Utilisateur(String nom, int numeroIdentification) {
        this.nom = nom;
        this.numeroIdentification = numeroIdentification;
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumeroIdentification() {
        return numeroIdentification;
    }

    public void setNumeroIdentification(int numeroIdentification) {
        this.numeroIdentification = numeroIdentification;
    }
}
