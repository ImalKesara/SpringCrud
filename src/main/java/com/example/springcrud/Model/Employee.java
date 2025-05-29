package com.example.springcrud.Model;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private int NIC;

    @Column(name = "Name")
    private String Name;

    @Column(name = "address")
    private String Address;

    @Column(name = "salary")
    private int Salary;

    @Column(name = "email_address")
    private String email;


    public int getNIC() {
        return NIC;
    }

    public void setNIC(int NIC) {
        this.NIC = NIC;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
