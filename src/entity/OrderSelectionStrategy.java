package entity;

import java.util.List;

public interface OrderSelectionStrategy {
    Restaurant selectRestaurant(List<Restaurant> restaurants, Order order) throws CustomCheckedException;
}
