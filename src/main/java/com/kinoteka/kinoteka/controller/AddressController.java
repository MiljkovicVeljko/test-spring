package com.kinoteka.kinoteka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {
   private final AddressService addressService;

   @PostMapping
   public ResponseEntity<Address> createAddress(@RequestBody Address address) {
      Address createdAddress = addressService.createAddress(address);
      if (createdAddress == null) {
         return ResponseEntity.badRequest().build();
      }

      return ResponseEntity.ok(createdAddress);
   }
}
