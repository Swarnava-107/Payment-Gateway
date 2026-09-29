package org.dev.paymentgateway.service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.dev.paymentgateway.entity.PaymentOrder;
import org.dev.paymentgateway.repo.PaymentRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentService {

    @Value("${razorpay.key_id}")
    private String keyId;
    @Value("${razorpay.key_secret}")
    private String keySecret;

    private PaymentRepo paymentRepo;
    private EmailService emailService;

    public PaymentService(PaymentRepo paymentRepo, EmailService emailService) {
        this.paymentRepo = paymentRepo;
        this.emailService = emailService;
    }

    public String createOrder(PaymentOrder orderDetails) throws RazorpayException {

        System.out.println("inside service....");

        RazorpayClient client = new RazorpayClient(keyId,keySecret);

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", (int)(orderDetails.getAmount()*100));
        orderRequest.put("currency","INR");
        orderRequest.put("receipt", "txn_"+ UUID.randomUUID());

        Order razorpayOrder = client.orders.create(orderRequest);

        System.out.println(razorpayOrder.toString());
        orderDetails.setOrderId(razorpayOrder.get("id"));
        orderDetails.setStatus("CREATED");
        orderDetails.setCreatedDate(LocalDateTime.now());

        paymentRepo.save(orderDetails);
        return razorpayOrder.toString();
    }

    public void updateOrderStatus(String orderId, String paymentId, String status) {

        PaymentOrder order = paymentRepo.findByOrderId(orderId);
        order.setPaymentId(paymentId);
        order.setStatus(status);
        paymentRepo.save(order);

        if("SUCCESS".equalsIgnoreCase(status)) {
            emailService.sendEmail(order.getEmail(),order.getName(),
                    order.getCourseName(), order.getAmount());
        }
    }
}
