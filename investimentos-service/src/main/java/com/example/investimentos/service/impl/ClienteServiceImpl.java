package com.example.investimentos.service.impl;

import com.example.investimentos.dto.ClienteDTO;
import com.example.investimentos.model.Cliente;
import com.example.investimentos.repository.ClienteRepository;
import com.example.investimentos.service.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public ClienteDTO criar(ClienteDTO dto) {
        Cliente c = toEntity(dto);
        repository.save(c);
        return toDTO(c);
    }

    @Override
    public ClienteDTO buscarPorId(Long id) {
        Cliente c = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente id " + id + " não encontrado"));
        return toDTO(c);
    }

    @Override
    public Page<ClienteDTO> listar(Pageable pageable) {
        return repository.findAll(pageable).map(this::toDTO);
    }

    @Override
    public ClienteDTO atualizar(Long id, ClienteDTO dto) {
        Cliente c = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente id " + id + " não encontrado"));
        c.setNome(dto.nome());
        c.setEmail(dto.email());
        c.setTelefone(dto.telefone());
        repository.save(c);
        return toDTO(c);
    }

    @Override
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Cliente id " + id + " não encontrado");
        }
        repository.deleteById(id);
    }

    private ClienteDTO toDTO(Cliente c) {
        return new ClienteDTO(c.getId(), c.getNome(), c.getEmail(), c.getTelefone());
    }

    private Cliente toEntity(ClienteDTO dto) {
        Cliente c = new Cliente();
        c.setNome(dto.nome());
        c.setEmail(dto.email());
        c.setTelefone(dto.telefone());
        return c;
    }
}
