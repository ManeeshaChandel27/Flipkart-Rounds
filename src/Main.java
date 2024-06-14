import entity.*;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws CustomCheckedException {

        System.out.println("Hello world!");

        OrderSelectionStrategy strategy = new LowestCostStrategy();
        RestaurantService restaurantService = new RestaurantService();
        OrderService orderService = new OrderService(strategy,restaurantService);

        Map<String, Integer> menuR1 = new HashMap<>();
        menuR1.put("Veg Biryani", 100);
        menuR1.put("Chicken Biryani", 150);
        Restaurant r1 = new Restaurant("R1", 5, 4.5, menuR1, 0);
        restaurantService.onboardRestaurant(r1);

        Map<String, Integer> menuR2 = new HashMap<>();
        menuR2.put("TOFFEE", 80);
        menuR2.put("Shake", 175);
        menuR2.put("Dosa ", 50);
        Restaurant r2 = new Restaurant("R2", 5, 4, menuR2, 0);
        restaurantService.onboardRestaurant(r2);

        Map<String, Integer> menuR3 = new HashMap<>();
        menuR3.put("Gobi Manchuriani", 150);
        menuR3.put("Chicken Biryani", 175);
        menuR3.put("Dosa", 30);
        menuR3.put("Idli", 15);
        Restaurant r3 = new Restaurant("R3", 8, 4.9, menuR3, 0);
        restaurantService.onboardRestaurant(r3);

        System.out.println("Showing Restaurants first time");
        restaurantService.showRestaurants();

        Map<String, Integer> orderItems1 = new HashMap<>();
        orderItems1.put("Dosa", 3);
        Order order1 = new Order("Ashwin", orderItems1);
        System.out.println(orderService.placeOrder(order1));

//        Map<String, Integer> orderItems2 = new HashMap<>();
//        orderItems2.put("Chicken Biryani", 3);
//        orderItems2.put("Veg Biryani", 1);
//        Order order2 = new Order("Ashwin", orderItems2);
//        System.out.println(orderService.placeOrder(order2));
//        System.out.println(orderService.placeOrder(order2));
//        System.out.println(orderService.placeOrder(order2));
//        System.out.println(orderService.placeOrder(order2));
//        System.out.println(orderService.placeOrder(order2));
//        System.out.println(orderService.placeOrder(order2));


//        Map<String, Integer> orderItems3 = new HashMap<>();
//        orderItems2.put("Chicken Biryani", 3);
//        orderItems2.put("Veg Biryani", 1);
//        Order order3 = new Order("Ashwin", orderItems3);
//        System.out.println(orderService.placeOrder(order2));
//
//        Map<String, Integer> orderItems2 = new HashMap<>();
//        orderItems2.put("Chicken Biryani", 3);
//        orderItems2.put("Veg Biryani", 1);
//        Order order2 = new Order("Ashwin", orderItems2);
//        System.out.println(orderService.placeOrder(order2));
//
//        Map<String, Integer> orderItems2 = new HashMap<>();
//        orderItems2.put("Chicken Biryani", 3);
//        orderItems2.put("Veg Biryani", 1);
//        Order order2 = new Order("Ashwin", orderItems2);
//        System.out.println(orderService.placeOrder(order2));
//
//        Map<String, Integer> orderItems2 = new HashMap<>();
//        orderItems2.put("Chicken Biryani", 3);
//        orderItems2.put("Veg Biryani", 1);
//        Order order2 = new Order("Ashwin", orderItems2);
//        System.out.println(orderService.placeOrder(order2));

        //updateRestaurantMenu
        restaurantService.updateMenu("R3","Idli",27);

        //update Order
        orderService.updateOrderStatus(1);


        System.out.println("Showing Restaurants second time");

        restaurantService.showRestaurants();
    }
}
//machine round

//https://docs.google.com/document/d/1lPlez0wcoK_wEcbMNkWXI3foHiYiyW4PDFD9tOQGCo4/edit?addon_store#heading=h.yztdg0tevkl0
//https://docs.google.com/document/d/1DEWYab57PxhZlhK4jKstFxg09UXsmOm5x48BB8yJhdw/edit

//dsa round

//https://docs.google.com/document/d/1nwo4yWoTWeG3gysuGtCFQyIPHHPIvw6ZD9xg12PWdZ0/edit