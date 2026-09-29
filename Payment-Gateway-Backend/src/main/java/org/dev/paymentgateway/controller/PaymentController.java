package org.dev.paymentgateway.controller;

import org.dev.paymentgateway.entity.PaymentOrder;
import org.dev.paymentgateway.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/payment")
public class PaymentController {

    private PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create-order")
    public ResponseEntity<String> createPayment(@RequestBody PaymentOrder order) {
        System.out.println("inside controller....");
        try{
            String response = paymentService.createOrder(order);
            return ResponseEntity.ok(response);
        }
        catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error");
        }
    }


    @PostMapping("/update-order")
    public ResponseEntity<String> updateOrder(@RequestParam String paymentId, @RequestParam String orderId,
                                              @RequestParam String status) {

        paymentService.updateOrderStatus(orderId,paymentId,status);
        System.out.println("Email sent successfully");
        return ResponseEntity.ok("Order updated successfully");

    }
}
