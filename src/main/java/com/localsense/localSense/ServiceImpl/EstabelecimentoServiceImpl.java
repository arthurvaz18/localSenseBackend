package com.localsense.localSense.ServiceImpl;

import com.localsense.localSense.repository.EstabelecimentoRepository;
import com.localsense.localSense.service.EstabelecimentoService;
import org.springframework.stereotype.Service;

@Service
public class EstabelecimentoServiceImpl implements EstabelecimentoService {

    EstabelecimentoRepository estabelecimentoRepository;

    public EstabelecimentoServiceImpl(EstabelecimentoRepository estabelecimentoRepository) {
        this.estabelecimentoRepository = estabelecimentoRepository;
    }
}
