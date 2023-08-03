package com.db.grad.javaapi.service;

import com.db.grad.javaapi.dto.BondDTO;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityService {
    @Autowired
    SecurityRepository securityRepository;
    public List<BondDTO> getBonds() {
        List<Security> activeBonds = securityRepository.getActiveBonds();
        List<BondDTO> bonds = new ArrayList<>();

        for (Security bond : activeBonds) {
            BondDTO bondDTO = new BondDTO();
            bondDTO.setIsin(bond.getIsin());
            bondDTO.setCoupon(bond.getCoupon());
            bondDTO.setCurrency(bond.getCurrency());
            bondDTO.setCusip(bond.getCusip());
            bondDTO.setType(bond.getType());
            bondDTO.setFaceValue(bond.getFaceValue());
            bondDTO.setStatus(bond.getStatus());
            bondDTO.setIssuerName(bond.getIssuerName());
            bondDTO.setMaturityDate(bond.getMaturityDate());

            bonds.add(bondDTO);
        }
        return bonds;
    }
}
