package com.vinhnt.caferecipeadmin.controller;

import com.vinhnt.caferecipeadmin.data.entity.UnitConversion;
import com.vinhnt.caferecipeadmin.service.UnitConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/unit-conversions")
public class UnitConversionController {
    @Autowired
    private UnitConversionService unitConversionService;

    // Lấy tất cả các conversion
    @GetMapping
    public List<UnitConversion> getAllConversions() {
        return unitConversionService.findAll();
    }

    // Lấy conversion theo ID
    @GetMapping("/{id}")
    public ResponseEntity<UnitConversion> getConversionById(@PathVariable Long id) {
        Optional<UnitConversion> conversion = unitConversionService.findById(id);
        return conversion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tạo hoặc cập nhật conversion
    @PostMapping
    public UnitConversion createConversion(@RequestBody UnitConversion unitConversion) {
        return unitConversionService.save(unitConversion);
    }

    // Xóa conversion
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConversion(@PathVariable Long id) {
        Optional<UnitConversion> conversion = unitConversionService.findById(id);
        if (conversion.isPresent()) {
            unitConversionService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Chuyển đổi giá trị từ đơn vị này sang đơn vị khác
    @GetMapping("/convert")
    public ResponseEntity<Double> convert(@RequestParam Long fromUnitId, @RequestParam Long toUnitId, @RequestParam Double value) {
        try {
            Double convertedValue = unitConversionService.convert(fromUnitId, toUnitId, value);
            return ResponseEntity.ok(convertedValue);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}