package com.alves.automovel.application.domain.services;

import com.alves.automovel.application.domain.models.Automovel;
import com.alves.automovel.application.ports.out.FindAllAutomovelPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindAllAutomovelServiceTest {

    @Mock
    private FindAllAutomovelPort findAllAutomovelPort;

    @InjectMocks
    private FindAllAutomovelService findAllAutomovelService;

    @Test
    public void findAllAutomovelWhenDontExist() {
        List<Automovel> automovelList = findAllAutomovelService.find();

        assertEquals(0, automovelList.size());
    }

    @Test
    public void findAllAutomovelWhenExistTwo() {
        when(findAllAutomovelPort.find())
                .thenReturn(List.of(
                        new Automovel(1L, "234-frd", "Volkswagem", "Gol", "Prata", "2015"),
                        new Automovel(2L, "678-rte", "Hynday", "HB-20", "Prata", "2013")
                )
        );
        List<Automovel> automovelList = findAllAutomovelService.find();
        assertEquals(2, automovelList.size());
    }

}