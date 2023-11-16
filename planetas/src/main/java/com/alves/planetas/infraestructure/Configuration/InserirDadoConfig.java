package com.alves.planetas.infraestructure.Configuration;

import com.alves.planetas.infraestructure.delivery.Controllers.PlanetaController;
import com.alves.planetas.infraestructure.delivery.rest.PlanetaRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class InserirDadoConfig implements CommandLineRunner {

    @Autowired
    private PlanetaController planetaController;

    @Override
    public void run(String... args) throws Exception {
        List<PlanetaRest> list = Arrays.asList(
                new PlanetaRest(null, "Terra", "Quente", "Seco"),
                new PlanetaRest(null, "Marte", "Frio", "Seco"),
                new PlanetaRest(null, "Venus", "Quente", "Seco"),
                new PlanetaRest(null, "xb21", "Frio", "Seco"),
                new PlanetaRest(null, "jgb54", "Arido", "Seco"),
                new PlanetaRest(null, "54eds", "Ameno", "Verde")

        );
        for(PlanetaRest r: list){
            planetaController.create(r);
        }
    }
}
