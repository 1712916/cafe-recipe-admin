package com.vinhnt.caferecipeadmin.controller;

import com.vinhnt.caferecipeadmin.data.entity.Unit;
import com.vinhnt.caferecipeadmin.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/units")
public class UnitController {
    @Autowired
    private UnitService unitService;

    // Lấy tất cả các đơn vị
    @GetMapping
    public List<Unit> getAllUnits() {
        return unitService.getAllUnits();
    }

    // Lấy đơn vị theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Unit> getUnitById(@PathVariable Long id) {
        Unit unit = unitService.getUnitById(id);
        return ResponseEntity.ok(unit);
    }

    // Tạo đơn vị mới
    @PostMapping
    public Unit createUnit(@RequestBody Unit unit) {
        return unitService.createUnit(unit);
    }

    // Cập nhật đơn vị
    @PutMapping("/{id}")
    public ResponseEntity<Unit> updateUnit(@PathVariable Long id, @RequestBody Unit unitDetails) {
        Unit updatedUnit = unitService.updateUnit(id, unitDetails);
        return ResponseEntity.ok(updatedUnit);
    }

    // Xóa đơn vị
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnit(@PathVariable Long id) {
        unitService.deleteUnit(id);
        return ResponseEntity.noContent().build();
    }
}