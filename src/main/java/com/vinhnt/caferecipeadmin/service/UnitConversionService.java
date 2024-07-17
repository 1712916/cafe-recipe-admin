package com.vinhnt.caferecipeadmin.service;

import com.vinhnt.caferecipeadmin.data.entity.UnitConversion;
import com.vinhnt.caferecipeadmin.data.repository.UnitConversionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnitConversionService {
    @Autowired
    private UnitConversionRepository unitConversionRepository;

    // Lấy tất cả các conversion
    public List<UnitConversion> findAll() {
        return unitConversionRepository.findAll();
    }

    // Lấy conversion theo ID
    public Optional<UnitConversion> findById(Long id) {
        return unitConversionRepository.findById(id);
    }

    // Tạo hoặc cập nhật conversion
    public UnitConversion save(UnitConversion unitConversion) {
        return unitConversionRepository.save(unitConversion);
    }

    // Xóa conversion
    public void deleteById(Long id) {
        unitConversionRepository.deleteById(id);
    }

    // Chuyển đổi giá trị từ đơn vị này sang đơn vị khác
    public Double convert(Long fromUnitId, Long toUnitId, Double value) {
        UnitConversion conversion = unitConversionRepository.findByFromUnitIdAndToUnitId(fromUnitId, toUnitId)
                .orElseThrow(() -> new RuntimeException("Conversion not found"));
        return value * conversion.getConversionFactor();
    }
}