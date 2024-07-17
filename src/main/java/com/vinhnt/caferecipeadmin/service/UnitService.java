package com.vinhnt.caferecipeadmin.service;

import com.vinhnt.caferecipeadmin.data.entity.Unit;
import com.vinhnt.caferecipeadmin.data.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {
    @Autowired
    private UnitRepository unitRepository;

    // Lấy tất cả các đơn vị
    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }

    // Lấy đơn vị theo ID
    public Unit getUnitById(Long id) {
        return unitRepository.findById(id).orElseThrow(() -> new RuntimeException("Unit not found"));
    }

    // Tạo đơn vị mới
    public Unit createUnit(Unit unit) {
        return unitRepository.save(unit);
    }

    // Cập nhật đơn vị
    public Unit updateUnit(Long id, Unit unitDetails) {
        Unit unit = unitRepository.findById(id).orElseThrow(() -> new RuntimeException("Unit not found"));
        unit.setName(unitDetails.getName());
        unit.setAbbreviation(unitDetails.getAbbreviation());
        return unitRepository.save(unit);
    }

    // Xóa đơn vị
    public void deleteUnit(Long id) {
        Unit unit = unitRepository.findById(id).orElseThrow(() -> new RuntimeException("Unit not found"));
        unitRepository.delete(unit);
    }
}