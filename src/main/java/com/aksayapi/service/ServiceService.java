package com.aksayapi.service;

import com.aksayapi.entity.ServiceEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {

    private final List<ServiceEntity> services;

    public ServiceService() {
        this.services = new ArrayList<>();
        initializeStaticData();
    }

    private void initializeStaticData() {
        services.add(new ServiceEntity(1L, "İnşaat", 
            "Modern ve kaliteli inşaat hizmetleri sunuyoruz. Konut, ticari ve endüstriyel projelerde uzman ekibimizle hizmet veriyoruz."));
        
        services.add(new ServiceEntity(2L, "Marina İnşaatı", 
            "Denizcilik alanında uzman ekibimizle marina, yat limanı ve denizcilik tesisleri inşaatı yapıyoruz."));
        
        services.add(new ServiceEntity(3L, "Otel İnşaatı", 
            "Lüks otel ve konaklama tesisleri inşaatında deneyimli ekibimizle kaliteli hizmet sunuyoruz."));
        
        services.add(new ServiceEntity(4L, "Liman İnşaatı", 
            "Modern liman tesisleri ve denizcilik altyapısı projelerinde uzman hizmet veriyoruz."));
        
        services.add(new ServiceEntity(5L, "Peyzaj", 
            "Çevre düzenleme ve peyzaj tasarımı konularında profesyonel hizmet sunuyoruz."));
        
        services.add(new ServiceEntity(6L, "Proje Yönetimi", 
            "İnşaat projelerinin baştan sona yönetimi konusunda deneyimli ekibimizle hizmet veriyoruz."));
    }

    public List<ServiceEntity> getAllServices() {
        return new ArrayList<>(services);
    }

    public ServiceEntity getServiceById(Long id) {
        Optional<ServiceEntity> service = services.stream()
            .filter(s -> s.getId().equals(id))
            .findFirst();
        return service.orElse(null);
    }

    public ServiceEntity saveService(ServiceEntity service) {
        if (service.getId() == null) {
            Long maxId = services.stream()
                .mapToLong(ServiceEntity::getId)
                .max()
                .orElse(0L);
            service.setId(maxId + 1);
        }
        services.add(service);
        return service;
    }

    public void deleteService(Long id) {
        services.removeIf(service -> service.getId().equals(id));
    }
}
