package com.main.desgins.carrental.course;

import com.main.desgins.carrental.course.models.User;
import com.main.desgins.carrental.self.models.Store;

import java.util.ArrayList;
import java.util.List;


public class CarRentalSystem {
    private final List<Store> stores = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    public void addStore(Store store) {
        stores.add(store);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Store getStores(String storeId) {
        return stores.stream().filter(store -> store.getStoreId() == storeId).findFirst().get();
    }

    public User getUsers(int userId) {
        return users.stream().filter(user->user.getUserId()==userId).findFirst().get();
    }
}
