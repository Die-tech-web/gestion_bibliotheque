

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
