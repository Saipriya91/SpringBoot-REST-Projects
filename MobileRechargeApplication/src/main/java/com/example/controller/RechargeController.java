
package com.example.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.Recharge;
import com.example.service.RechargeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/recharges")
public class RechargeController {

    private final RechargeService rechargeService;

    public RechargeController(RechargeService rechargeService) {
        this.rechargeService = rechargeService;
    }

    @GetMapping
    public List<Recharge> getAllRecharges() {
        return rechargeService.getAllRecharges();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recharge> getRechargeById(
            @PathVariable int id) {

        Recharge recharge = rechargeService.getRechargeById(id);

        if (recharge == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(recharge);
    }

    @PostMapping
    public Recharge addRecharge(@Valid @RequestBody Recharge recharge) {
        return rechargeService.addRecharge(recharge);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecharge(@PathVariable int id) {
        boolean deleted = rechargeService.deleteRecharge(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
