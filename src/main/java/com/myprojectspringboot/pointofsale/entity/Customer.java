package com.myprojectspringboot.pointofsale.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name="customer")

public class Customer {

    @Id //primary key
    @Column (name="customer_id",length = 45)  //column name
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;


    @Column( name="customer_name",length = 100,nullable = false)
    private String customerName;

    @Column(name="customer_address",length = 255)
    private String customerAddress;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name="contact_numbers",length = 255,columnDefinition = "json")
    private ArrayList<String> contactNumber;


    @Column(name="customer_salary")
    private int customerSalary;

    @Column(name="customer_nic",length = 255)
    private String nic;


    @Column(name="customer_status",columnDefinition = "TINYINT default 1")
    private boolean active;

    @OneToMany(mappedBy = "customer")
    private Set<Orders> orders;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public ArrayList getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(ArrayList contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(int customerSalary) {
        this.customerSalary = customerSalary;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Customer(){

    }

    public Customer(int customerId, String customerName, String customerAddress, ArrayList contactNumber, int customerSalary, String nic, boolean active) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.contactNumber = contactNumber;
        this.customerSalary = customerSalary;
        this.nic = nic;
        this.active = active;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", contactNumber=" + contactNumber +
                ", customerSalary=" + customerSalary +
                ", nic='" + nic + '\'' +
                ", active=" + active +
                '}';
    }
}
