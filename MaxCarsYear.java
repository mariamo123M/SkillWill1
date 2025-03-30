import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxCarsYear {
    public static void main(String[] args) {
        Map<Integer, List<Car>> yearToCarsMap = new HashMap<>();


        List<Car> cars2024 = new ArrayList<>();
        cars2024.add(new Car("Model AMG GT", "Brand Mercedes"));
        cars2024.add(new Car("Model F40", "Brand Ferrari"));

        List<Car> cars2020 = new ArrayList<>();
        cars2020.add(new Car("Model 911 Turbo S", "Brand Porsche"));
        cars2020.add(new Car("Model M3", "Brand BMW"));
        cars2020.add(new Car("Model AMG G63", "Brand Mercedes"));
        cars2020.add(new Car("Model Urus", "Brand Lamborghini"));

        List<Car> cars2025 = new ArrayList<>();
        cars2025.add(new Car("Model R8", "Brand Audi"));
        cars2025.add(new Car("Model P1", "Brand Mclaren"));
        cars2025.add(new Car("Model DB11", "Brand Aston Martin"));

        yearToCarsMap.put(2024, cars2024);
        yearToCarsMap.put(2020, cars2020);
        yearToCarsMap.put(2025, cars2025);

        int maxYear = findYearWithMaxCars(yearToCarsMap);
        System.out.println("Max cars year: " + maxYear);
    }
        public static int findYearWithMaxCars(Map<Integer, List<Car>> yearToCarsMap) {
            int maxYear = -1;
            int maxCount = -1;

            for (Map.Entry<Integer, List<Car>> entry : yearToCarsMap.entrySet()) {
                int year = entry.getKey();
                int count = entry.getValue().size();

                if (count > maxCount) {
                    maxCount = count;
                    maxYear = year;

                }
}
      return maxYear;
        }
    }
    class Car {
    String model;
    String brand;

    public Car(String model, String brand) {
        this.model = model;
        this.brand = brand;

    }
}