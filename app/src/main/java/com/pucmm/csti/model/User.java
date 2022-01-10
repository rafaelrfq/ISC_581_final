package com.pucmm.csti.model;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    public enum ROL {SELLER, CUSTOMER}

    public int uid;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public Userr.ROL rol;
    public String contact;
    public String birthday;
    public String photo;

    public User() {}

    public int getUid() { return uid; }

    public void setUid(int uid) { this.uid = uid; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Userr.ROL getRol() { return rol; }

    public void setRol(Userr.ROL rol) { this.rol = rol; }

    public String getContact() { return contact; }

    public void setContact(String contact) { this.contact = contact; }

    public String getBirthday() { return birthday; }

    public void setBirthday(String birthday) { this.birthday = birthday; }

    public String getPhoto() { return photo; }

    public void setPhoto(String photo) { this.photo = photo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUid() == user.getUid();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid());
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", rol=" + rol +
                ", contact='" + contact + '\'' +
                ", birthday='" + birthday + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
