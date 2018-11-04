package com.nagarro.yourmart.domains;

import javax.persistence.*;

/**
 * @author Sanyam Goel created on 30/10/18
 */
@Entity
@Table(name = "categories")
public class Categories extends BaseEntity {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

//    @JsonManagedReference
//    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Products> products;


    public Categories() {

    }

    public Categories(long createdAt, long updatedAt, long id, String name) {
        super(createdAt, updatedAt);
        this.id = id;
        this.name = name;
    }

    public Categories(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
