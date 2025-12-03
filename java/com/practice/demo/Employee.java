package com.practice.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    
    private Long id;
    private String name;
    private String phone;
    private String gmail; 

    // public String getName() {
    //     return name;
    // }
    // public String getPhone() {
    //     return phone;
    // }
    // public String getGmail() {
    //     return gmail;
    // }
    // public void setName(String name) {
    //     this.name = name;
    // }
    // public void setPhone(String phone) {
    //     this.phone = phone;
    // }
    // public void setGmail(String gmail) {
    //     this.gmail = gmail;
    // }
}
