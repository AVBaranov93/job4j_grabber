package ru.job4j.ood.isp.payment;

import java.util.List;

public class BankPayment implements Payment {
    @Override
    public void initiatePayments() {
        /*some logic*/
    }

    @Override
    public Object status() {
        /*some logic*/
        return null;
    }

    @Override
    public List<Object> getPayments() {
        /*some logic*/
        return null;
    }

    @Override
    public void intiateLoanSettlement() {
        /*stub method, doesn't have realization for this class*/
    }

    @Override
    public void initiateRePayment() {
        /*stub method, doesn't have realization for this class*/
    }
}
