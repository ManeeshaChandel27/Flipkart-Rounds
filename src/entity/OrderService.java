package entity;

import java.util.*;

public class OrderService {
    private RestaurantService restaurantService;
    private List<Order> waitlist = new LinkedList<>();
    private OrderSelectionStrategy selectionStrategy;
    private Map<Integer,Order> orderMap = new HashMap<>();

    public OrderService(OrderSelectionStrategy orderSelectionStrategy,RestaurantService restaurantService){
        this.selectionStrategy = orderSelectionStrategy;
        this.restaurantService = restaurantService;
    }
//    public void onboardRestaurant(Restaurant restaurant){
//        restaurantService.getRestaurants().add(restaurant);
//    }
    public String placeOrder(Order order){
        try{
            Restaurant selectedRestaurant = selectionStrategy.selectRestaurant(restaurantService.getRestaurants(),order);
            selectedRestaurant.acceptOrder();
            orderMap.put(order.getId(), order);
            return "Order assigned to " + selectedRestaurant.getName();

        } catch (CustomCheckedException e) {
            waitlist.add(order);
            orderMap.put(order.getId(), order);
            return "Order put on waitlist";
        }
    }
    public void updateOrderStatus(int orderId){
        Order order = orderMap.get(orderId);
        if(order != null && !order.isCompleted()){
            for(Restaurant restaurant : restaurantService.getRestaurants()){
                if(restaurant.getCurrentOrders()>0 &&
                        restaurant.canFulfillOrder(order.getItems())){
                    restaurant.completeOrder();
                    order.complete();
                    System.out.println("Particular Order got completed "+ order);
                    processWaitlist();
                    return;
                }
            }
        }
    }
    public void processWaitlist(){
        Iterator<Order> iterator = waitlist.iterator();
        while(iterator.hasNext()){
            Order order = iterator.next();
            try{
                Restaurant selectedRestaurant = selectionStrategy.selectRestaurant(restaurantService.getRestaurants(),order);
                selectedRestaurant.acceptOrder();
                iterator.remove();
                System.out.println("Waitlisted order assigned to " + selectedRestaurant.getName());
            }catch(CustomCheckedException e){

            }
        }
    }
}
