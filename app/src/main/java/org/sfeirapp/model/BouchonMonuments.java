package org.sfeirapp.model;

/**
 * Created by tarekelchami on 28/04/14.
 */
public class BouchonMonuments {

    private static MonumentsVille monuments = new MonumentsVille();

    public BouchonMonuments() {
        this.monuments = new MonumentsVille();
    }

    public static MonumentsVille getMonuments() {

        for(int i = 0; i < 10; i++){
            Monument monument = new Monument();
            monument.setNomMonument("Monument " + i);
            monument.setLieuMonument("Lieu  " + i);
            monument.setDescription("Description " + i);

            monuments.add(monument);
        }
        return monuments;
    }
}
