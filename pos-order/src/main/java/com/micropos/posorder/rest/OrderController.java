package com.micropos.posorder.rest;

import com.micropos.posorder.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class OrderController implements OrderApi{
    @Autowired
    private OrderService orderService;

    // @Override
    @PostMapping("/order/place")
    public ResponseEntity<Boolean> placeOrder(@RequestBody String orderInfo){
        boolean res = orderService.placeOrder(orderInfo);
        if(!res)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
}
