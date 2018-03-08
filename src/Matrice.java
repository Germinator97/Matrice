
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author germinator
 */
public class Matrice {
    int [][] matrice;
    int n;
    int m;
    public Matrice () {
        System.out.println("Veillez entrer le nombre de ligne de votre matrice : ");
        Scanner clavier = new Scanner (System.in) ;
        n = clavier.nextInt () ; // Nombre de ligne de la matrice
        System.out.println("Veillez entrer le nombre de colonne de votre matrice : ");
        m = clavier.nextInt () ; // Nombre de colonne de la matrice
        matrice = new int [n][m] ;
        if (n>0 && m>0) {
            for (int i=0 ; i<n ; i++) {
                int [] tab1;
                tab1 = new int [m];
                for (int j=0 ; j<m ; j++) {
                    System.out.println("Veillez entrer un entier : ");
                    int valeur = clavier.nextInt () ; // Les differents valeurs
                                                      // de la matrice
                    tab1[j]=valeur ;
                }
                matrice[i]=tab1 ; // Remplir la matrice en ligne avec le tableau
            }
        }
    }
    void Afficher () {
        System.out.println(Arrays.deepToString(matrice));
    }
    
    void Produit (int [][] matrice1) {
        int [] tab;
        int k=matrice1.length; // Nombre de ligne de la matrice
        int colonne=0; // Permet d'obtenir le nombre de colonne de la matrice
        for (int i:matrice1[1]) {
            colonne=colonne +1;
        }
        if (m==k) {
            int [][] solution = new int [n][colonne];
            int resultat=0;
            for (int i=0 ; i<n ; i++) {
                tab = new int [colonne];
                for (int j=0 ; j<colonne ; j++) {
                    for (int p=0 ; p<m ; p++) {
                        resultat=matrice[i][p]*matrice1[p][j]+resultat; 
                        // Permet d'obtenir le resultat de chaque intersection
                        // ligne et colonne de la matrice solution du produit
                        // des deux matrices
                    }
                    tab[j]=resultat;
                    resultat=0;
                }
                solution[i]=tab; // Remplir la matrice solution en ligne avec
                                 // le tableau tab
            }
            System.out.println("Le produit des matrices A = " + 
                    Arrays.deepToString(matrice) + " et B = " + 
                    Arrays.deepToString(matrice1) + " donne A*B = " + 
                    Arrays.deepToString(solution));
        }
        else {
            System.out.println("Multiplication impossible.");
        }
    }
}
class TestMatrice {
    public static void main (String[] arg) {
        System.out.println("En cours de programmation.");
        Matrice matrice1 = new Matrice () ;
        int [][] matrice2 = {{5,6,7},{8,9,0}};
        matrice1.Afficher();
        System.out.println(Arrays.deepToString(matrice2));
        matrice1.Produit(matrice2);
    }
}
