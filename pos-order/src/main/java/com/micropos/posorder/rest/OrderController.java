package com.micropos.posorder.rest;

import com.micropos.api.OrderApi;
import com.micropos.posorder.service.OrderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("posorder")
public class OrderController implements OrderApi{
    @Autowired
    private OrderService orderService;

    public static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @Override
    @PostMapping("/order/place")
    public ResponseEntity<Boolean> placeOrder(@RequestBody String orderInfo){
        
        log.info("order controller: {}", orderInfo);
        boolean res = orderService.placeOrder(orderInfo);
        if(!res)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
}
