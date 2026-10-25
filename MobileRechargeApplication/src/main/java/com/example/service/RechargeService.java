
package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Recharge;

@Service
public class RechargeService {

    private List<Recharge> recharges = new ArrayList<>();

    public List<Recharge> getAllRecharges() {
        return recharges;
    }

    public Recharge addRecharge(Recharge recharge) {
        recharges.add(recharge);
        return recharge;
    }

    public Recharge getRechargeById(int id) {
        for (Recharge recharge : recharges) {
            if (recharge.getRechargeId() == id) {
                return recharge;
            }
        }
        return null;
    }

    public boolean deleteRecharge(int id) {
        return recharges.removeIf(
                recharge -> recharge.getRechargeId() == id);
    }
}
