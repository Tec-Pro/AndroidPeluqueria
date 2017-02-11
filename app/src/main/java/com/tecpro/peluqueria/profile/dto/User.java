package com.tecpro.peluqueria.profile.dto;


import java.io.Serializable;

public class User implements Serializable {

    public final String id;
    public final String name;
    public final String status;
    public final String role;
    public final String phone;
    public final String pass;

    private User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.status = builder.status;
        this.role = builder.role;
        this.phone = builder.phone;
        this.pass = builder.pass;
    }




    public static class Builder {
        private String id;
        private String name;
        private String status;
        private String role;
        private String phone;
        private String pass;

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder withRole(String role) {
            this.role = role;
            return this;
        }

        public Builder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder withPass(String pass) {
            this.pass = pass;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", role='" + role + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
