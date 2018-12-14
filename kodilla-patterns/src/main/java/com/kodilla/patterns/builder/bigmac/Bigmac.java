package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.bigmac.enums.Bun;
import com.kodilla.patterns.builder.bigmac.enums.Ingredients;
import com.kodilla.patterns.builder.bigmac.enums.Sauces;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {

    private Bun bun;
    private int burgers;
    private Sauces sauce;
    private List<Ingredients> ingeredients;

    private Bigmac(final Bun bun, final int burgers, final Sauces sauce, List<Ingredients> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingeredients = new ArrayList<>(ingredients);
    }

    public static class BigmacBuilder {
        private Bun bun;
        private int burgers;
        private Sauces sauce;
        private List<Ingredients> ingredients = new ArrayList<>();

        public BigmacBuilder bun(Bun bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(Sauces sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(Ingredients ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }

    public List<Ingredients> getIngeredients() {
        return ingeredients;
    }

    public int getBurgers() {
        return burgers;
    }

    public Sauces getSauce() {
        return sauce;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun=" + bun +
                ", burgers=" + burgers +
                ", sauce=" + sauce +
                ", ingeredients=" + ingeredients +
                '}';
    }
}
