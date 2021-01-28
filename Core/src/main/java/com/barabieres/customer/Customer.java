package com.barabieres.customer;

import com.barabieres.inventory.Stock;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Customer {
    private final double moneyToSpend;
    private final double alcoholByVolumeLiked;
    private final double alcoholAcceptance;

    public Customer() {
        moneyToSpend = generateMoneyToSpend();
        alcoholByVolumeLiked = generateAlcoholByVolumeLiked();
        alcoholAcceptance = 10;
    }

    Customer(double moneyToSpend, double alcoholByVolumeLiked, double alcoholAcceptance) {
        this.moneyToSpend = moneyToSpend;
        this.alcoholByVolumeLiked = alcoholByVolumeLiked;
        this.alcoholAcceptance = alcoholAcceptance;
    }

    private double generateAlcoholByVolumeLiked() {
        Random r = new Random();
        return 60 * r.nextDouble();
    }

    private double generateMoneyToSpend() {
        Random r = new Random();
        return 5 + (40 - 5) * r.nextDouble();
    }

    public double chooseBeersToBuy(List<Stock> beers) {
        double moneySpent = 0;
        List<Stock> beersCustomerCanBuy = getBeerThatCustomerCanBuy(beers);
        while (!beersCustomerCanBuy.isEmpty()) {
            Random r = new Random();
            int customerChoice = r.nextInt(beersCustomerCanBuy.size());
            String beerChosenName = beersCustomerCanBuy.get(customerChoice).getBeer().getName();
            for (Stock beer : beers) {
                if (beer.getBeer().getName().equals(beerChosenName)) {
                    moneySpent += beer.getBeer().getSellingPrice();
                    beer.decreaseQuantity(1);
                    break;
                }
            }
            beersCustomerCanBuy = getBeerThatCustomerCanBuy(beers);
        }
        return moneySpent;
    }

    private List<Stock> getBeerThatCustomerCanBuy(List<Stock> beers) {
        return beers.stream()
                .filter(beer -> beer.getQuantity() > 0)
                .filter(beer -> alcoholByVolumeLiked - alcoholAcceptance <= beer.getBeer().getAlcoholByVolume() && beer.getBeer().getAlcoholByVolume() <= alcoholByVolumeLiked + alcoholAcceptance)
                .filter(beer -> beer.getBeer().getSellingPrice() <= moneyToSpend)
                .collect(Collectors.toList());
    }
}
