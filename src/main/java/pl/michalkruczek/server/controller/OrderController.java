package pl.michalkruczek.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.michalkruczek.server.dto.OrderDto;
import pl.michalkruczek.server.model.Order;
import pl.michalkruczek.server.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mikr on 27/08/17.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    public OrderRepository orderRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addOrder(@RequestBody OrderDto orderDto){
        Order order = new Order();

        order.setId(orderDto.getId());
        order.setCompanyId(orderDto.getCompanyId());
        order.setProductId(orderDto.getProductId());

        orderRepository.save(order);

        return "Success - add order";
    }

    @RequestMapping("/all")
    public List<OrderDto> allOrder(){
        List<Order> orders = orderRepository.findAll();
        List<OrderDto> orderDtoList = new ArrayList<OrderDto>();

        for (Order order : orders) {
            OrderDto orderDto = new OrderDto();
            orderDto.setId(order.getId());
            orderDto.setCompanyId(order.getCompanyId());
            orderDto.setProductId(order.getProductId());

            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }

    @RequestMapping("company/{id}")
    public List<OrderDto> orderByCompanyId(@PathVariable long id){
        List<Order> orders = orderRepository.findByCompanyId(id);

        List<OrderDto> orderDtoList = new ArrayList<OrderDto>();

        for (Order order : orders) {
            OrderDto orderDto = new OrderDto();
            orderDto.setId(order.getId());
            orderDto.setCompanyId(order.getCompanyId());
            orderDto.setProductId(order.getProductId());

            orderDtoList.add(orderDto);
        }
        return orderDtoList;

    }

    @RequestMapping("delete/{id}")
    public String deleteOrder(@PathVariable long id){
        orderRepository.delete(id);

        return "Delete order : " + id + ".";
    }
}
