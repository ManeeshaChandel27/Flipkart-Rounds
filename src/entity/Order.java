package entity;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {
    private static int idCounter = 0;
    private int id;
    private String user;
    private Map<String, Integer> items = new HashMap<>();
    private boolean isCompleted;

    public Order(String user, Map<String, Integer> items) {
        this.id = ++idCounter;
        this.user = user;
        this.items = new HashMap<>(items);
        this.isCompleted = false;
    }

    public void complete() {
        isCompleted = true;
    }
}
