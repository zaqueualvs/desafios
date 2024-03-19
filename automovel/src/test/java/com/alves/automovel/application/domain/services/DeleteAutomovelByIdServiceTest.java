package com.alves.automovel.application.domain.services;

import com.alves.automovel.application.domain.exceptions.AutomovelNaoEncontradoException;
import com.alves.automovel.application.domain.models.Automovel;
import com.alves.automovel.application.ports.in.FindAutomovelByIdUseCase;
import com.alves.automovel.application.ports.out.DeleteAutomovelPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeleteAutomovelByIdServiceTest {

    @Mock
    private FindAutomovelByIdUseCase findAutomovelByIdUseCase;
    @Mock
    private DeleteAutomovelPort deleteAutomovelPort;

    @InjectMocks
    private DeleteAutomovelByIdService deleteAutomovelByIdService;

    @Test
    public void deleteAutomovelWhenExist() {
        Automovel automovel = new Automovel(1L, "234-frd", "Volkswagem", "Gol", "Prata", "2015");
        findAutomovelByIdUseCase.find(1L);
        when(findAutomovelByIdUseCase.find(1L)).thenReturn(automovel);

        Automovel automovelMock = findAutomovelByIdUseCase.find(1L);

        assertNotNull(automovelMock);
        assertEquals(automovelMock.getId(), automovel.getId());
        assertEquals(automovelMock.getPlaca(), automovel.getPlaca());
        assertEquals(automovelMock.getMarca(), automovel.getMarca());
        assertEquals(automovelMock.getModelo(), automovel.getModelo());
        assertEquals(automovelMock.getPlaca(), automovel.getPlaca());
        assertEquals(automovelMock.getAno(), automovel.getAno());

        deleteAutomovelByIdService.delete(1L);

        when(findAutomovelByIdUseCase.find(anyLong())).thenThrow(AutomovelNaoEncontradoException.class);
        assertThrows(AutomovelNaoEncontradoException.class, () -> deleteAutomovelByIdService.delete(1L));

    }

    @Test
    public void deleteAutomovelWhenNotExist() {
        when(findAutomovelByIdUseCase.find(anyLong())).thenThrow(AutomovelNaoEncontradoException.class);
        assertThrows(AutomovelNaoEncontradoException.class, () -> deleteAutomovelByIdService.delete(1L));
    }

}