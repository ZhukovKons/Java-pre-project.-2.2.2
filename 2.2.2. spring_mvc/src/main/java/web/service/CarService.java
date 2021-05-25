package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CarService {

    private final List<Car> carList;

    public CarService(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList(int count){
        return carList.size() >= count ?
                carList.stream().limit(count).collect(Collectors.toList()) : carList;
    }
}
