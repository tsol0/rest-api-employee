package com.example.demo.models;

public record Employee (
   Integer id, // Assuming id is auto-generated
   String firstName,
   String lastName,
   String email,
   String phoneNumber,
   String department,
   String position,
   Double salary
) {}
