package com.zed.bagofood.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Arnaud on 03/05/2015.
 */
@Entity
@Table(name = "foodlist", schema = "", catalog = "bagofood")
public class Foodlist {

    private int id;
    private String name;
    private String descriptions;
    private User user;
    private Set<Item> itemSet = new HashSet<>(0);

    protected Foodlist() {
    }

    public Foodlist(User user, String name, String descriptions) {
        this.user = user;
        this.name = name;
        this.descriptions = descriptions;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @NotBlank
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "descriptions")
    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    @ManyToOne
    @JoinColumn(name = "user_fk")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToMany
    @JoinTable(name = "foodlist_items", joinColumns = @JoinColumn(name = "foodlist_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
    public Set<Item> getItemSet() {
        return itemSet;
    }

    public void setItemSet(Set<Item> itemSet) {
        this.itemSet = itemSet;
    }
}
