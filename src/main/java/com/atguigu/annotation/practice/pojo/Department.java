package com.atguigu.annotation.practice.pojo;

import com.atguigu.annotation.practice.annotation.Column;
import com.atguigu.annotation.practice.annotation.Table;

/**
 * 部门实体类
 */
@Table("department")
public class Department {
    @Column("id")
    private Integer id;
    @Column("name")
    private String name;
    @Column("leader")
    private String leader;
    @Column("amount")
    private int amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
