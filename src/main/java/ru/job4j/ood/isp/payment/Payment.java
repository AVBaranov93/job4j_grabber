package ru.job4j.ood.isp.payment;

import java.util.List;

public interface Payment {
    void initiatePayments();

    Object status();

    List<Object> getPayments();

    void intiateLoanSettlement();

    void initiateRePayment();

}
