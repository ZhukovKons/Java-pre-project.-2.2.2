package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cars")
public class CarsController {

    private final List<Car> carList;

    public CarsController(List<Car> carList) {
        this.carList = carList;
    }

    @GetMapping
    public String getCountCars(Model model, @RequestParam(value = "count", required = false) Integer count) {
        System.out.println(count);
        model.addAttribute("cars", count != null && carList.size() >= count ?
                carList.stream().limit(count).collect(Collectors.toList()) : carList);
        return "/cars";
    }

}
