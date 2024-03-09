package com.alves.lanchonete.adapters.in.rest.controllers;

import com.alves.lanchonete.adapters.in.rest.data.request.ProdutoRequest;
import com.alves.lanchonete.adapters.in.rest.data.response.ProdutoResponse;
import com.alves.lanchonete.adapters.in.rest.mappers.ProdutoRestMapper;
import com.alves.lanchonete.applications.ports.in.produto.SaveProdutoUseCase;
import com.alves.lanchonete.domain.models.Produto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final SaveProdutoUseCase saveProdutoUseCase;
    private final ProdutoRestMapper produtoRestMapper;

    @PostMapping
    private ResponseEntity<ProdutoResponse> save(@RequestBody @Valid ProdutoRequest produtoRequest) {
        Produto produto = produtoRestMapper.toDomain(produtoRequest);
        produto = saveProdutoUseCase.save(produto);
        ProdutoResponse produtoResponse = produtoRestMapper.toResponse(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoResponse);
    }
}
