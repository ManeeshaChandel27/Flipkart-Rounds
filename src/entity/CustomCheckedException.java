package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomCheckedException extends Exception{
    private String message;
    public  CustomCheckedException(String message){
        super(message);
    }
}
