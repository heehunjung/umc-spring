package umc7.heehunjung.dto.restaurant;

import lombok.Getter;

public class RestaurantRequestDto {

    @Getter
    public static class addDto{
        String name;
        String address;
        String content;
        String region;
    }
}
