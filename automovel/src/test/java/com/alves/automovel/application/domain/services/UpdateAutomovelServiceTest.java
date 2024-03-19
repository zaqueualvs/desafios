package com.alves.automovel.application.domain.services;

import com.alves.automovel.application.domain.models.Automovel;
import com.alves.automovel.application.ports.out.UpdateAutomovelPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateAutomovelServiceTest {

    @Mock
    private UpdateAutomovelPort updateAutomovelPort;

    @InjectMocks
    private UpdateAutomovelService updateAutomovelService;

    @Test
    public void updateAutomovel(){
        Automovel automovel = new Automovel(1L, "234-frd", "Volkswagem", "Gol", "Prata", "2015");
        when(updateAutomovelPort.update(automovel)).thenReturn(automovel);

        Automovel updatedAutomovel = updateAutomovelService.update(automovel);

        assertNotNull(updatedAutomovel);
    }
}