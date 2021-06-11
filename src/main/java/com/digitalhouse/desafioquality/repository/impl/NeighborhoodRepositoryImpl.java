package com.digitalhouse.desafioquality.repository.impl;

import com.digitalhouse.desafioquality.exceptions.ObjectNotFoundException;
import com.digitalhouse.desafioquality.repository.NeighborhoodRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NeighborhoodRepositoryImpl implements NeighborhoodRepository {
    private final Map<String, Double> neighborhoods = new HashMap<>();

    public NeighborhoodRepositoryImpl() {
        neighborhoods.put("Adalgisa", 100.0);
        neighborhoods.put("Aliança", 200.0);
        neighborhoods.put("Ayrosa", 300.0);
        neighborhoods.put("Bandeiras", 400.0);
        neighborhoods.put("Baronesa", 500.0);
        neighborhoods.put("Bela Vista", 600.0);
        neighborhoods.put("Bonança", 700.0);
        neighborhoods.put("Bonfim", 800.0);
        neighborhoods.put("Bussocaba", 900.0);
        neighborhoods.put("Castelo Branco", 1000.0);
        neighborhoods.put("Centro", 1100.0);
        neighborhoods.put("Cidade das Flores", 1200.0);
        neighborhoods.put("Cidade de Deus", 1300.0);
        neighborhoods.put("Cipava", 1400.0);
        neighborhoods.put("City Bussocaba", 1500.0);
        neighborhoods.put("Conceição", 1600.0);
        neighborhoods.put("Conjunto Metalúrgicos", 1700.0);
        neighborhoods.put("Continental", 1800.0);
        neighborhoods.put("Industrial Altino", 1900.0);
        neighborhoods.put("Industrial Anhanguera", 2000.0);
        neighborhoods.put("Industrial Autonomistas", 2100.0);
        neighborhoods.put("Industrial Centro", 2200.0);
        neighborhoods.put("Industrial Mazzei", 2300.0);
        neighborhoods.put("Industrial Remédios", 2400.0);
        neighborhoods.put("Helena Maria", 2500.0);
        neighborhoods.put("IAPI", 2600.0);
        neighborhoods.put("Jaguaribe", 2700.0);
        neighborhoods.put("Jardim D'Abril", 2800.0);
        neighborhoods.put("Jardim das Flores", 2900.0);
        neighborhoods.put("Jardim Elvira", 3000.0);
        neighborhoods.put("Mutinga", 3100.0);
        neighborhoods.put("Piratininga", 3200.0);
        neighborhoods.put("Platina", 3300.0);
        neighborhoods.put("Jardim Roberto", 3400.0);
        neighborhoods.put("Veloso", 3500.0);
        neighborhoods.put("km 18", 3600.0);
        neighborhoods.put("Munhoz Júnior", 3700.0);
        neighborhoods.put("Novo Osasco", 3800.0);
        neighborhoods.put("Padroeira", 3900.0);
        neighborhoods.put("Paiva Ramos", 4000.0);
        neighborhoods.put("Pestana", 4100.0);
        neighborhoods.put("Portal D'Oeste", 4200.0);
        neighborhoods.put("Presidente Altino", 4300.0);
        neighborhoods.put("Quitaúna", 4400.0);
        neighborhoods.put("Raposo Tavares", 4500.0);
        neighborhoods.put("Remédios", 4600.0);
        neighborhoods.put("Rochdale", 4700.0);
        neighborhoods.put("Santa Fé", 4800.0);
        neighborhoods.put("Santa Maria", 4900.0);
        neighborhoods.put("Santo Antônio", 5000.0);
        neighborhoods.put("São Pedro", 5100.0);
        neighborhoods.put("Setor Militar", 5200.0);
        neighborhoods.put("Três Montanhas", 5300.0);
        neighborhoods.put("Umuarama", 5400.0);
        neighborhoods.put("Vila Campesina", 5500.0);
        neighborhoods.put("Vila Menck", 5600.0);
        neighborhoods.put("Vila Militar", 5700.0);
        neighborhoods.put("Vila Osasco", 5800.0);
        neighborhoods.put("Vila Yara", 5900.0);
        neighborhoods.put("Vila Yolanda", 6000.0);
    }

    @Override
    public Double getSquareMeterValue(String neighborhoodName) {
        return neighborhoods.entrySet().stream().filter(f -> f.getKey().toLowerCase().equals(neighborhoodName.toLowerCase())).findFirst().map(Map.Entry::getValue).orElseThrow(() -> new ObjectNotFoundException("This neighborhood not exists"));
    }

    @Override
    public Map<String, Double> findAll() {
        return this.neighborhoods;
    }

}
