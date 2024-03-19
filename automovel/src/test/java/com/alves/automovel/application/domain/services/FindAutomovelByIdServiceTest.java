package com.alves.automovel.application.domain.services;

import com.alves.automovel.application.domain.exceptions.AutomovelNaoEncontradoException;
import com.alves.automovel.application.domain.models.Automovel;
import com.alves.automovel.application.ports.out.FindAutomovelByIdPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindAutomovelByIdServiceTest {

    @Mock
    private FindAutomovelByIdPort findAutomovelByIdPort;

    @InjectMocks
    private FindAutomovelByIdService findAutomovelByIdService;


    @Test
    public void findAutomovelWhenExist() {
        Automovel automovel = new Automovel(1L, "234-frd", "Volkswagem", "Gol", "Prata", "2015");
        when(findAutomovelByIdPort.find(1L)).thenReturn(Optional.of(automovel));
        Automovel newAutomovel = findAutomovelByIdService.find(1L);
        assertNotNull(newAutomovel);
        assertEquals("234-frd", newAutomovel.getPlaca());
    }

    @Test
    public void findAutomovelWhenNotExist() {
        when(findAutomovelByIdPort.find(anyLong())).thenReturn(Optional.empty());
        assertThrows(AutomovelNaoEncontradoException.class, () -> findAutomovelByIdService.find(1L));
    }
}