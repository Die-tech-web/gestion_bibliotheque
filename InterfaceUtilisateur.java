import java.util.Scanner;

public class InterfaceUtilisateur {
    private Bibliotheque bibliotheque;
    private Scanner scanner;

    public InterfaceUtilisateur() {
        this.bibliotheque = new Bibliotheque();
        this.scanner = new Scanner(System.in);
    }

    public void afficherMenuPrincipal() {
        System.out.println("Bienvenue dans le système de gestion de bibliothèque !");
        System.out.println("1. Ajouter un livre");
        System.out.println("2. Rechercher un livre");
        System.out.println("3. Emprunter un livre");
        System.out.println("4. Retourner un livre");
        System.out.println("5. Ajouter un utilisateur");
        System.out.println("6. Supprimer un livre");
        System.out.println("7. Afficher la liste des utilisateurs");
        System.out.println("8. Modifier un livre");
        System.out.println("9. Quitter");
    }
    ////liste utilisateur
    public void afficherListeUtilisateurs() {
        System.out.println("Liste des utilisateurs :");
        for (Utilisateur utilisateur : bibliotheque.getUtilisateurs()) {
            System.out.println("Nom : " + utilisateur.getNom() + ", ID : " + utilisateur.getNumeroIdentification());
        }
    }
    ////liste utiliateur
    public void executer() {
        int choix;
        do {
            afficherMenuPrincipal();
            System.out.print("Veuillez sélectionner une option : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne après la saisie de l'entier
    
            switch (choix) {
                case 1:
                    ajouterLivre();
                    break;
                case 2:
                    rechercherLivre();
                    break;
                case 3:
                    emprunterLivre();
                    break;
                case 4:
                    retournerLivre();
                    break;
                case 5:
                    ajouterUtilisateur();
                    break;
                case 6:
                    supprimerLivre();
                    break;
                case 7:
                    afficherListeUtilisateurs();
                    break;
                case 8:
                    modifierLivre();
                    break;
                case 9:
                    System.out.println("Merci d'avoir utilisé le système de gestion de bibliothèque !");
                    break;
                default:
                    System.out.println("Option invalide, veuillez réessayer.");
            }
        } while (choix != 9);
    }
    public void ajouterLivre() {
        System.out.println("Ajout d'un nouveau livre :");
        System.out.print("Titre : ");
        String titre = scanner.nextLine();
        System.out.print("Auteur : ");
        String auteur = scanner.nextLine();
        System.out.print("Année de publication : ");
        int anneePublication = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne
        System.out.print("ISBN : ");
        String ISBN = scanner.nextLine();

        Livre nouveauLivre = new Livre(titre, auteur, anneePublication, ISBN);
        bibliotheque.ajouterLivre(nouveauLivre);
        System.out.println("Le livre a été ajouté avec succès !");
    }

    public void rechercherLivre() {
        System.out.println("Recherche d'un livre :");
        System.out.print("Entrez le titre, l'auteur ou l'ISBN du livre : ");
        String critere = scanner.nextLine();

        Livre livreTrouve = bibliotheque.rechercherLivre(critere);
        if (livreTrouve != null) {
            System.out.println("Livre trouvé :");
            System.out.println(livreTrouve.toString());
        } else {
            System.out.println("Aucun livre correspondant trouvé.");
        }
    }

    public void emprunterLivre() {
        System.out.println("Emprunt d'un livre :");
        System.out.print("Nom de l'utilisateur : ");
        String nomUtilisateur = scanner.nextLine();
        System.out.print("ID de l'utilisateur : ");
        int idUtilisateur = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne

        System.out.print("Titre ou ISBN du livre à emprunter : ");
        String critereLivre = scanner.nextLine();

        // Recherche de l'utilisateur dans la bibliothèque
        Utilisateur utilisateur = bibliotheque.rechercherUtilisateur(idUtilisateur);
        if (utilisateur == null) {
            System.out.println("Utilisateur non trouvé.");
            return;
        }

        // Recherche du livre dans la bibliothèque
        Livre livre = bibliotheque.rechercherLivre(critereLivre);
        if (livre == null) {
            System.out.println("Livre non trouvé.");
            return;
        }

        // Enregistrement de l'emprunt
        Emprunt emprunt = new Emprunt(livre, utilisateur);
        bibliotheque.enregistrerEmprunt(emprunt);
        System.out.println("Emprunt enregistré avec succès !");
    }

    public void retournerLivre() {
        // Méthode retournerLivre inchangée
    }

    public void ajouterUtilisateur() {
        System.out.println("Ajout d'un nouvel utilisateur :");
        System.out.print("Nom de l'utilisateur : ");
        String nomUtilisateur = scanner.nextLine();
        System.out.print("ID de l'utilisateur : ");
        int idUtilisateur = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne
        
        Utilisateur nouvelUtilisateur = new Utilisateur(nomUtilisateur, idUtilisateur);
        bibliotheque.ajouterUtilisateur(nouvelUtilisateur);
        System.out.println("L'utilisateur a été ajouté avec succès !");
    }

///supp

public void supprimerLivre() {
    System.out.println("Suppression d'un livre :");
    System.out.print("Entrez l'ISBN du livre à supprimer : ");
    String ISBN = scanner.nextLine();

    bibliotheque.supprimerLivre(ISBN);
}
////sup
//modifier
public void modifierLivre() {
    System.out.println("Modification d'un livre :");
    System.out.print("Entrez l'ISBN du livre à modifier : ");
    String ISBN = scanner.nextLine();

    Livre livre = bibliotheque.rechercherLivre(ISBN);
    if (livre == null) {
        System.out.println("Livre non trouvé.");
        return;
    }

    System.out.println("Livre actuel :");
    System.out.println(livre.toString());

    System.out.print("Nouveau titre : ");
    String nouveauTitre = scanner.nextLine();
    System.out.print("Nouvel auteur : ");
    String nouvelAuteur = scanner.nextLine();
    System.out.print("Nouvelle année de publication : ");
    int nouvelleAnneePublication = scanner.nextInt();
    scanner.nextLine(); // Consommer la nouvelle ligne

    livre.setTitre(nouveauTitre);
    livre.setAuteur(nouvelAuteur);
    livre.setAnneePublication(nouvelleAnneePublication);

    bibliotheque.modifierLivre(livre);
    System.out.println("Le livre a été modifié avec succès.");
}
//modifier



    public static void main(String[] args) {
        InterfaceUtilisateur interfaceUtilisateur = new InterfaceUtilisateur();
        interfaceUtilisateur.executer();
    }
}


