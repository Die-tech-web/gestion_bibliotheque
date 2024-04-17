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
    //suppp
    /**
     * @param ISBN
     */
    public void supprimerLivre(String ISBN) {
        Livre livreASupprimer = null;
        for (Livre livre : livres) {
            if (livre.getISBN().equalsIgnoreCase(ISBN)) {
                livreASupprimer = livre;
                break;
            }
        }
        if (livreASupprimer != null) {
            livres.remove(livreASupprimer);
            System.out.println("Le livre \"" + livreASupprimer.getTitre() + "\" a été supprimé avec succès.");
        } else {
            System.out.println("Aucun livre avec l'ISBN \"" + ISBN + "\" n'a été trouvé.");
        }
    }

    ///liste utilisateur
    public ArrayList<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }
    


    
}