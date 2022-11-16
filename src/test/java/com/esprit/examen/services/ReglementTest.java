package com.esprit.examen.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.esprit.examen.entities.Reglement;
import com.esprit.examen.repositories.ReglementRepository;
import com.esprit.examen.services.ReglementServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@ExtendWith(MockitoExtension.class)
 class ReglementTest {
    @InjectMocks
    ReglementServiceImpl reglementServiceImpl ;
    @Mock
    ReglementRepository reglementRepository;

    

    @Test
    void testAddReglementOk() {
        Reglement reglement = new Reglement(1L,200, 56, null, null, null);
        reglementServiceImpl.addReglement(reglement);
        verify(reglementRepository, times(1)).save(reglement);

        log.info("add reglement ");
    }

    @Test
     void selectOne(){
        Reglement reglement = new Reglement(1L,200, 56, null, null, null);



        Mockito.when(reglementRepository.findById(1L)).thenReturn(Optional.of(reglement));
        Reglement reg = reglementServiceImpl.retrieveReglement(1L );

       
        log.info("get reglement ==>" + reg.getMontantPaye());
    }

    @Test
    void modifier(){
         Reglement re = new Reglement(1L,100, 10, null, null, null);

         reglementServiceImpl.updateReglement(re);
         verify(reglementRepository, times(1)).save(re);
        log.info("edit reglement");
     }
     @Test
      void delete() {

         reglementServiceImpl.deleteReglement(1L);
         verify(reglementRepository, times(1)).deleteById(1L);
         log.info("delete reglement** ");
     }
}
