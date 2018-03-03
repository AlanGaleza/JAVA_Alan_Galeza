package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {

    private final Roll roll;
    private final int burgers;
    private final Sauce sauce;
    private final List<Ingredients> ingredient;

        public static class BigmacBuilder {

            private Roll roll;
            private int burgers;
            private Sauce sauce;
            private List<Ingredients> ingredient = new ArrayList<>();

            public BigmacBuilder roll(Roll roll) {
                this.roll = roll;
                return this;
            }

            public BigmacBuilder burgers (int burgers) {
                this.burgers = burgers;
                return this;
            }

            public BigmacBuilder sauce (Sauce sauce) {
                this.sauce = sauce;
                return this;
            }

            public BigmacBuilder ingredient(Ingredients ingredient) {
                this.ingredient.add(ingredient);
                return this;
            }

            public Bigmac build() {
                return new Bigmac(roll, burgers, sauce, ingredient);
            }
        }

    public Bigmac(Roll roll, int burgers, Sauce sauce, List<Ingredients> ingredient) {
        this.roll = roll;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredient = new ArrayList<>(ingredient);
    }

    public Roll getRoll() {
        return roll;
    }

    public int getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredients> getIngredient() {
        return ingredient;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "roll='" + roll + '\'' +
                ", burgers='" + burgers + '\'' +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredient +
                '}';
    }
}
