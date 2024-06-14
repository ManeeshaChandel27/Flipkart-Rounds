package entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class RestaurantService {
    private List<Restaurant> restaurants = new ArrayList<>();
    public void onboardRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }
    public void updateMenu(String restaurantName, String itemName, int price) throws CustomCheckedException {
        for(Restaurant restaurant : restaurants){
            if(restaurant.getName().equals(restaurantName)) {
                restaurant.updateMenu(itemName,price);
                return;
            }
        }
        throw new CustomCheckedException("Restaurant not found: "+ restaurantName);
    }

    public void showRestaurants(){
        for(int i=0;i< restaurants.size();i++){
            System.out.println(restaurants.get(i));
        }
    }
}
