package com.example.fooddeliveryapp.table;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
//import org.apache.catalina.User;
import com.example.fooddeliveryapp.table.Users;   // ✅ Your Entity class


import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Orders {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;  // Order ID (auto-increment)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Many orders can be placed by one user
        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false)
        private Users user;

        // Each order belongs to one restaurant
        @ManyToOne
        @JoinColumn(name = "restaurant_id", nullable = false)
        private Restaurant restaurant;

    @Enumerated(EnumType.STRING)  // 👈 This tells JPA it's an ENUM
    @Column(nullable = false)
    private OrderStatus status;


    private Double totalAmount;  // Total price of the order

        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        @PrePersist
        protected void onCreate() {
            createdAt = LocalDateTime.now();
            updatedAt = LocalDateTime.now();
            if (status == null) {
                status = OrderStatus.PLACED; // default when order is created
            }
        }

        @PreUpdate
        protected void onUpdate() {
            updatedAt = LocalDateTime.now();
        }
    public enum OrderStatus {
        PLACED,
        CONFIRMED,
        OUT_FOR_DELIVERY,
        DELIVERED,
        CANCELLED
    }



    // Getters and Setters


}
