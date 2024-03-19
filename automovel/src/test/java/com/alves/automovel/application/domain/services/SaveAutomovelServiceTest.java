package com.alves.automovel.application.domain.services;

import com.alves.automovel.application.domain.models.Automovel;
import com.alves.automovel.application.ports.out.SaveAutomovelPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SaveAutomovelServiceTest {

    @Mock
    private SaveAutomovelPort saveAutomovelPort;

    @InjectMocks
    private SaveAutomovelService saveAutomovelService;

    @Test
    public void saveAutomovel() {
        Automovel automovel = new Automovel(1L, "234-frd", "Volkswagem", "Gol", "Prata", "2015");
        when(saveAutomovelPort.save(automovel)).thenReturn(automovel);

        Automovel newAutomovel = saveAutomovelService.save(automovel);

        assertNotNull(newAutomovel);
    }
}