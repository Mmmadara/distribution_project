package com.example.demo.repositories;

import com.example.demo.entities.DictOrgType;
import com.example.demo.entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganizationRepo extends JpaRepository<Organization, Long> {

    Optional<Organization> findOrganizationByOrgId(Long id);
    Optional<Organization> findByName_kzOrName_ru(String name);
    List<Organization> findAllByParentOrgOrDictOrgType(Organization parentOrgId, DictOrgType dictOrgType);
    List<Organization> findAllByParentOrgAndDictOrgType(Organization parentOrgId, DictOrgType dictOrgType);
    Optional<Organization> findByBIN(String bin);
    Optional<Organization> findByAddressOrPhone(String address, String phone);

}
