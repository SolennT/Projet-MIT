/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir.nf;

/*!
 *
 *  @enum Gender
 *
 *  @brief Classe correspondant a toutes les genres.
 *
 */
public enum Gender {
    H("Homme"),
    F("Femme"),
    A("Autre"), 
    I("Inconnu");

    private String libelle;

    private Gender(String libelle) {
        this.libelle = libelle;
    }
}
