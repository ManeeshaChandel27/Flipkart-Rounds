package entity;

import java.util.List;

public class LowestCostStrategy implements OrderSelectionStrategy{

    @Override
    public Restaurant selectRestaurant(List<Restaurant> restaurants, Order order) throws CustomCheckedException {
        Restaurant selectedRestaurant = null;
        int lowestCost = Integer.MAX_VALUE;

        for(Restaurant restaurant : restaurants){
            if(restaurant.canProcessOrder() && restaurant.canFulfillOrder(order.getItems())){
                int cost = restaurant.calculateOrderCost((order.getItems()));
                if(cost < lowestCost){
                    lowestCost = cost;
                    selectedRestaurant = restaurant;
                }
            }
        }
        if(selectedRestaurant == null){
            throw new CustomCheckedException("No restaurant available to fulfill the order.");
        }
        return selectedRestaurant;

    }
}
