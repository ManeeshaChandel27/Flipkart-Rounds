package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    private String name;
    private int maxOrders;
    private double rating;
    private Map<String, Integer> menu = new HashMap<>();
    private int currentOrders;

    public boolean canProcessOrder(){
        return currentOrders < maxOrders;
    }

    public void acceptOrder() {
        currentOrders++;
    }

    public void completeOrder() {
        currentOrders--;
    }

    public boolean canFulfillOrder(Map<String, Integer> orderItems) {
        return menu.keySet().containsAll(orderItems.keySet());
    }

    public int calculateOrderCost(Map<String, Integer> orderItems) {
        return orderItems.entrySet().stream()
                .mapToInt(item -> menu.get(item.getKey()) * item.getValue())
                .sum();
    }

    public void updateMenu(String itemName, int price) {
        menu.put(itemName, price);
    }
}
