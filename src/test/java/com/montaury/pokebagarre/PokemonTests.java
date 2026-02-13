package com.montaury.pokebagarre;

import com.montaury.pokebagarre.metier.Pokemon;
import com.montaury.pokebagarre.fixtures.ConstructeurDePokemon;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Classe de test pour la classe Pokemon
 * 
 * Vérifie le comportement de la méthode estVainqueurContre en
 * fonction des valeurs d'attaque et de défense des Pokémons.
 * 
 * Tests présents:
 * 1. Le premier Pokémon gagne s'il a une meilleure attaque.
 * 2. Le second Pokémon gagne s'il a une meilleure attaque.
 * 3. Le premier Pokémon gagne si les attaques sont égales mais sa défense est
 * meilleure.
 * 4. Le second Pokémon gagne si les attaques sont égales mais sa défense est
 * meilleure.
 * 5. Le premier Pokémon gagne si les attaques et défenses sont égales.
 */

public class PokemonTests {

    @Test
    void premiere_serait_vainquer_avec_meilleur_attaque() {
        // GIVEN
        Pokemon premiere = new ConstructeurDePokemon()
                .avecAttaque(10)
                .avecDefense(5)
                .construire();
        Pokemon second = new ConstructeurDePokemon()
                .avecAttaque(9)
                .avecDefense(5)
                .construire();

        // WHEN
        Boolean estVainqueur = premiere.estVainqueurContre(second);

        // THEN
        assertThat(estVainqueur).isTrue();
    }

    @Test
    void second_serait_vainquer_avec_meilleure_attaque() {
        // GIVEN
        Pokemon premiere = new ConstructeurDePokemon()
                .avecAttaque(10)
                .avecDefense(5)
                .construire();
        Pokemon second = new ConstructeurDePokemon()
                .avecAttaque(11)
                .avecDefense(5)
                .construire();

        // WHEN
        Boolean estVainqueur = second.estVainqueurContre(premiere);

        // THEN
        assertThat(estVainqueur).isTrue();
    }

    @Test
    void premier_serait_vainquer_avec_attaques_egal_et_meilleurs_defense() {
        // GIVEN
        Pokemon premiere = new ConstructeurDePokemon()
                .avecAttaque(10)
                .avecDefense(6)
                .construire();
        Pokemon second = new ConstructeurDePokemon()
                .avecAttaque(10)
                .avecDefense(5)
                .construire();

        // WHEN
        Boolean estVainqueur = premiere.estVainqueurContre(second);

        // THEN
        assertThat(estVainqueur).isTrue();
    }

    @Test
    void second_serait_vainquer_avec_attaques_egal_et_meilleurs_defense() {
        // GIVEN
        Pokemon premiere = new ConstructeurDePokemon()
                .avecAttaque(10)
                .avecDefense(5)
                .construire();
        Pokemon second = new ConstructeurDePokemon()
                .avecAttaque(10)
                .avecDefense(6)
                .construire();

        // WHEN
        Boolean estVainqueur = second.estVainqueurContre(premiere);

        // THEN
        assertThat(estVainqueur).isTrue();
    }

    @Test
    void premier_serait_vainquer_avec_attaque_et_defenses_egal() {
        // GIVEN
        Pokemon premiere = new ConstructeurDePokemon()
                .avecAttaque(10)
                .avecDefense(10)
                .construire();
        Pokemon second = new ConstructeurDePokemon()
                .avecAttaque(10)
                .avecDefense(10)
                .construire();

        // WHEN
        Boolean estVainqueur = premiere.estVainqueurContre(second);

        // THEN
        assertThat(estVainqueur).isTrue();
    }

}
