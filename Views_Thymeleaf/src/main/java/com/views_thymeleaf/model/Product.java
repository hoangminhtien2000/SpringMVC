package com.views_thymeleaf.model;



    public class Product {
        private int id;
        private String name;
        private String img;
        private double price;
        private boolean status;

        public Product(int id, String name, String img, double price, boolean status) {
            this.id = id;
            this.name = name;
            this.img = img;
            this.price = price;
            this.status = status;
        }

        public Product() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
}
